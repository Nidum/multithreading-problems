package eleks.mentorship.race_condition;

public class Problem {
    public static void main(String[] args) {
        A a = new A();

        Thread th1 = new Thread(()->{
            for(int i=0; i<1000000000; i++){
                a.addOne();
            }
        });
        Thread th2 = new Thread(()->{
            for(int i=0; i<1000000000; i++){
                a.addOne();
            }
        });

        th1.start();
        th2.start();

        while(th1.isAlive() || th2.isAlive()){
            System.out.println("Waiting for threads to calculate...");
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(a.getA());
    }
}

class A {
    private int a;

    public void addOne(){
        a++;
    }

    public int getA() {
        return a;
    }
}
