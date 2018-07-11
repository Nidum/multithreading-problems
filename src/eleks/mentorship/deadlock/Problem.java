package eleks.mentorship.deadlock;

public class Problem {
    private static Integer resourceA = new Integer(5);
    private static Integer resourceB = new Integer(7);

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (resourceA) {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resourceB) {
                    System.out.println(resourceA + resourceB);
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (resourceB) {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resourceA) {
                    System.out.println(resourceA * resourceB);
                }
            }
        }).start();
    }
}
