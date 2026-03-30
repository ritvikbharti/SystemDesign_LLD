

// Here we are creating two threads, one for sending SMS and another for sending Email. 
// We are using the Thread class to create these threads and overriding the run() method to define the task that each thread will perform.
//  We are also using the sleep() method to simulate a delay in sending SMS and Email. 
// Finally, we are using the join() method to wait for both threads to complete before printing "Task Done".

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class smsThread extends Thread{
    @Override
    public void run() {
        try{
            Thread.sleep(1000);
            System.out.println("Sending SMS...");

        } catch (InterruptedException e) {
            e.printStackTrace();        }
    }
 
    }
class smsThreadRunnable implements Runnable{
    @Override
    public void run() {
        try{
            Thread.sleep(1000);
            System.out.println("Sending SMS...");

        } catch (InterruptedException e) {
            e.printStackTrace();        }
    }
 
    }

    class EmailThread extends Thread{
        @Override
        public void run() {
            try{
                Thread.sleep(1000);
                System.out.println("Sending Email...");

            } catch (InterruptedException e) {
                e.printStackTrace();        }
        }
     
    }
    class EmailThreadRunnable implements Runnable{
        @Override
        public void run() {
            try{
                Thread.sleep(1000);
                System.out.println("Sending Email...");

            } catch (InterruptedException e) {
                e.printStackTrace();        }
        }
     
    }
 // Callable interface for type declaration ie returnt type
class ETACalculator implements Callable<String>{
    private final String location;
    public ETACalculator(String location){
        this.location = location;
    }
    @Override
    public String call() throws Exception{
        System.out.println("["+ Thread.currentThread().getName() +"] Calculating ETA to: "+ location);
        Thread.sleep(3000);
        return "ETA to " + location + ": 20 minutes";
    }
}

 public class Multithreading {
    

   public static void main(String[] args) {



    Thread smsThread = new Thread(new smsThreadRunnable());
    smsThread sms = new smsThread();
    EmailThread email = new EmailThread();
    Thread emailThread = new Thread(new EmailThreadRunnable());

// Callable
    FutureTask etaThreadRunnable =  new FutureTask<>(new ETACalculator("BLR"));
    Thread etaThread = new Thread(etaThreadRunnable);








    System.out.println("Task started...");
    sms.start();
    System.out.println("Task in progress...");
    email.start();
    etaThread.start();
    System.out.println("Task completed...");

    try{
        sms.join();
        email.join();
        String eta = (String) etaThreadRunnable.get();
        System.out.println("ETA is: "+eta);
        System.out.println("Task Done");
    } catch (InterruptedException e) {
        e.printStackTrace();
    } catch(ExecutionException e){
        e.printStackTrace();
    }
   }


   
}