// package RaceCondition;

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
