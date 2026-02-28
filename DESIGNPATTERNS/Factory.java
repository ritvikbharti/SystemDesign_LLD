interface Logistics {
    void send();
}


class Road implements Logistics{
    @Override
    public void send(){
        System.out.println("Road");
    }
}

class Air implements Logistics{
    @Override
    public void send(){
        System.out.println("Air");
    }
}

class LogisticsFactory{
    public static Logistics geLogistics(String mode){
        if(mode == "road"){
            return new Road();
        }
        return new Air();
    }
}
class LogisticsService{
// ------ Before using factory pattern --------
//      vioalating s principle 
        /*  public static Logistics send(String mode){
            if(mode =="Road"){
                Logistics logistics = new Air();
                logistics.send();
            }else if(mode == "Air"){
                Logistics logistics = new Road();
                logistics.send();
            }

         }*/

// 
// --------------------------------------------------------------

// -- After using factory patterns
public void send(String mode){
    Logistics logistics = LogisticsFactory.geLogistics(mode);
    logistics.send();
}

}
public class Factory{

    public static void main(String[] args) {
        // Car car1 = CarFactory.createCar("Sedan");
        // Car car2 = CarFactory.createCar("SUV");
        // car1.drive();
        // car2.drive();
    }

}