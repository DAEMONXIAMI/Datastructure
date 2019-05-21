package main;

public class TestMyThreadPool {
    public static void main(String[] args) {
        MyThreadPool myThreadPool = new MyThreadPool(2, 6);
        for (int i = 0; i < 10; i++) {
            myThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("一个线程被放到仓库中");
                    try {
                        Thread.sleep(2500);
                    } catch (InterruptedException e) {
                        System.out.println("一个线程被唤醒了");
                    }
                }
            });
            System.out.println(i);
        }

        myThreadPool.shutDown();
    }
}
