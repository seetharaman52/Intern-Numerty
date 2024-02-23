public class multiThreading1 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread");
        
        Thread thread1 = new Thread1();
        System.out.println("Thread is running: " + thread1.isAlive());
        
        thread1.start();
        
        Thread.sleep(1000);
        
        System.out.println("Thread is running: " + thread1.isAlive());
        System.out.println("Main thread ends");
    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread1 is running...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread1 ends");
    }
}
