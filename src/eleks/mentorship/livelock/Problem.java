package eleks.mentorship.livelock;

public class Problem {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        new Thread(() -> {
            a.doWork(b);
        }).start();

        new Thread(() -> {
            b.doWork(a);
        }).start();
    }
}

class A {
    private boolean workIsDone = false;

    public void doWork(B b) {
        while (!b.isBsWorkIsDone()) {
            System.out.println("Waiting for B...");
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        workIsDone = true;
    }

    public boolean isAsWorkIsDone() {
        return workIsDone;
    }
}

class B {
    private boolean workIsDone = false;

    public void doWork(A a) {
        while (!a.isAsWorkIsDone()) {
            System.out.println("Waiting for A...");
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        workIsDone = true;
    }

    public boolean isBsWorkIsDone() {
        return workIsDone;
    }
}