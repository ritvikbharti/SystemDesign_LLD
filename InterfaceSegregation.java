//  ----- Before using ISP -----
       // interface uber{
        //     void bookRide();
        //     void acceptRide();
        //     void drive();
        //     void endRide();
        //     void payRide();
        // }

        
// ---- After using ISP -----
        interface RiderInterface {
            void bookRide();
            void payRide();
        }
        interface DriverInterface {
            void acceptRide();
            void drive();
            void endRide();
        }
        class Rider implements RiderInterface {
            @Override
            public void bookRide() {
                System.out.println("Booking a ride...");
            }
            @Override
            public void payRide() {
                System.out.println("Paying for the ride...");
            }
        }
        class Driver implements DriverInterface {
            public void acceptRide() {
                System.out.println("Accepting a ride...");
            }
            public void drive() {
                System.out.println("Driving...");
            }
            public void endRide() {
                System.out.println("Ending the ride...");
            }
        }
public class InterfaceSegregation {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}