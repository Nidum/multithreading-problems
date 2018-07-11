package eleks.mentorship.visibility_issue;

public class Problem {
    private static int n;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            int tmp = 0;
            while (tmp < 10) {
                if (n != tmp) {
                    tmp = n;
                    System.out.println("TMP = " + n);
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                n++;
                System.out.println("N = " + n);
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.exit(0);
        });

        thread1.start();
        thread2.start();
    }
}
