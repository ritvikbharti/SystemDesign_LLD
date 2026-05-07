
class RideMatchingService{
    public void requestRide(String riderId){
        Thread matchThread = new Thread(()->{
            System.out.println("Matching rider "+riderId +" to a driver...");
            try{
                Thread.sleep(1000);

            }catch(Exception e){
                Thread.currentThread().interrupt();

            }

            System.out.println("Ride matched for rider "+ riderId);
            
        });
        matchThread.start();
    }
    
}

public class RideMatching {
    public static void main(String[] args) {
        
        RideMatchingService rs1 = new RideMatchingService();
        RideMatchingService rs2 = new RideMatchingService();
        rs1.requestRide("ritvik1");
        System.out.println("task1 running");
        rs2.requestRide("Ritvik2");
        System.out.println("Task2 running");
    }
}
