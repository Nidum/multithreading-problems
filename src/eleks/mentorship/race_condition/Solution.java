package eleks.mentorship.race_condition;

import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    public static void main(String[] args) {
        B b = new B();

        Thread th1 = new Thread(()->{
            for(int i=0; i<1000000000; i++){
                b.addOne();
            }
        });
        Thread th2 = new Thread(()->{
            for(int i=0; i<1000000000; i++){
                b.addOne();
            }
        });

        th1.start();
        th2.start();

        while(th1.isAlive() ||  th2.isAlive()){
            System.out.println("Waiting for threads to calculate...");
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(b.getB());
    }
}

class B {
    private AtomicInteger b = new AtomicInteger(0);

    public void addOne(){
        b.incrementAndGet();
    }

    public int getB() {
        return b.get();
    }
}
