// package RaceCondition;

import java.util.concurrent.atomic.AtomicInteger;

class PurchaseCounter{
    private int count;
    public void increment(){
        synchronized (this){
        count++;
        }
        
    }

    public int getCount(){
        return count;
    }
}


class PurchaseAtomicCounter{
    private AtomicInteger likes = new AtomicInteger(0);

    public void incrementLikes(){
        int prev,next;
        do{
            prev = likes.get(); // user1 -> prev = 10,user2-> prev = 10;
            next = prev + 1; // u1->next =11,user2 -> next = 11;

        }while(!likes.compareAndSet(prev,next));// u1 and u2
    }
    public int getCount(){
        return likes.get();
    }

}



public class RaceConditiondemo {
    
    public static void main(String[] args) throws InterruptedException {

        PurchaseCounter counter = new PurchaseCounter();

        Runnable task = ()->{
            for(int i = 0;i<1000;i++) counter.increment();

        };


        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Final count: "+counter.getCount());
        
    }
}
