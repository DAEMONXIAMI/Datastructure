package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPool {
    //1.需要一个仓库
    private BlockingQueue<Runnable> blockingQueue;

    //2. 一个线程的集合
    private List<Thread> workers;

    //3. 一个人干活
    public static class Worker extends Thread {
        private MyThreadPool pool;

        public Worker(MyThreadPool pool) {
            this.pool = pool;
        }

        @Override
        public void run() {
            while (this.pool.isWorking || this.pool.blockingQueue.size() > 0) {
                Runnable task = null;

                try {
                    if(this.pool.isWorking)
                        task = this.pool.blockingQueue.take();
                    else
                        task = this.pool.blockingQueue.poll();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (task != null) {
                    task.run();
                    System.out.println("线程：" + Thread.currentThread().getName() + "执行完毕");
                }
            }
        }
    }

    //4.初始话线程池
    public MyThreadPool(int poolSize, int taskSize) {
        if (poolSize <= 0 || taskSize <= 0) {
            throw new IllegalArgumentException("非法参数");
        }

        this.blockingQueue = new LinkedBlockingQueue<>(taskSize);
        this.workers = Collections.synchronizedList(new ArrayList<>());

        for (int i = 0; i < poolSize; i++) {
            Worker worker = new Worker(this);
            worker.start();
            workers.add(worker);
        }
    }

    //5. 向仓库中放任务（非阻塞）
    public boolean submit(Runnable task) {
        if (isWorking) {
        return this.blockingQueue.offer(task);}
        return false;
    }

    //6.  向仓库中放任务（阻塞）
    public void execute(Runnable task) {
        if (isWorking){
            try {
                this.blockingQueue.put(task);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //7. 关闭
    //关闭的时候，仓库停止有新的任务进来
    //关闭的时候，仓库如果还有东西要执行完毕
    //关闭的时候，如果再去仓库拿东西，就不能阻塞了
    //关闭的时候，如果还有线程被阻塞，要强行中断
    private volatile boolean isWorking = true;

    public void shutDown() {
        isWorking = false;
        for (Thread thread : workers) {
            if (thread.getState().equals(Thread.State.WAITING) ||
                    thread.getState().equals(Thread.State.BLOCKED)) {
                thread.interrupt();
            }
        }
    }
}
