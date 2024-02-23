public class multiThreading {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hi");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hello");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        });

        t1.start();
        try {
            Thread.sleep(10);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        t2.start();
    }
}
