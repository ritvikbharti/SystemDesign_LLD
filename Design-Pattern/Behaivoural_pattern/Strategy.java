

interface MatchingStrategy{
    void match(String riderLocation);
}



class NearestDriverStrategy implements MatchingStrategy{
    @Override

    public void match(String riderLocation){
        System.out.println("Matching with nearest available driver to "+ riderLocation);
    }
}

class SurgePriorityStrategy implements MatchingStrategy{
    @Override
    public void match(String riderLocation){
     System.out.println("Matching rider using pricing priority near "+ riderLocation);
   
    }
}
class AirportPickupStrategy implements MatchingStrategy{
    @Override
    public void match(String riderLocation){
        System.out.println("Matching rider with drivers available for airport pickup near "+ riderLocation);
    }
}
class RideMatchingService{
    private MatchingStrategy strategy;

    public RideMatchingService(MatchingStrategy strategy){
        this.strategy = strategy;
    }

    public void setStrategy(MatchingStrategy strategy){
        this.strategy = strategy;
    }

    public void matchRider(String location){
        strategy.match(location);
    }

}




public class Strategy{
    public static void main(String[] args) {
        RideMatchingService matchingService = new RideMatchingService(new NearestDriverStrategy());
        matchingService.matchRider("Downtown");
        matchingService.setStrategy(new SurgePriorityStrategy());
        matchingService.matchRider("Downtown");
        matchingService.setStrategy(new AirportPickupStrategy());
        matchingService.matchRider("Airport");
    }
}