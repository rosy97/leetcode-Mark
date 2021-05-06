package Leetcode.lock;

public class DeadLock {
    public static int val = 0;
    public static Object o1 = new Object();
    public static Object o2 = new Object();

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o1){
                    System.out.println("线程1拿到o1....");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (o2){
                        for(int i=0;i<10000;i++){
                            val++;
                        }
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o2){
                    System.out.println("线程2拿到o2....");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (o1){
                        for(int i=0;i<10000;i++){
                            val++;
                        }
                    }
                }
            }
        }).start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(val);
    }
}
