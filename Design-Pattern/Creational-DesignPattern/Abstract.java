package DESIGNPATTERNS;
// ---- Abstract Factory Design Pattern
// Abstract factory design pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes. 
// It allows you to create objects that belong to a particular family (or theme) without coupling your code to the specific implementations of those objects.
//  This pattern is particularly useful when you want to ensure that related objects are used together and when you want to provide a way to create objects that can vary based on some configuration or context.
interface PaymentGateway{
    void processPayment(double amount);
}

class RazorpayGateway implements PaymentGateway{
    @Override
    public void processPayment(double amount){
        System.out.println("Processing INR payment via Razorpay: " + amount);
    }
}

class PayUGateway implements PaymentGateway{
    @Override
    public void processPayment(double amount){
        System.out.println("Processing INR payment via PayU: " + amount);
    }
}

class PaypalGateway implements PaymentGateway{
    @Override
    public void processPayment(double amount){
        System.out.println("Processing payment via PAypal" + amount);
    }
}

class StripeGateway implements PaymentGateway{
    @Override
    public void processPayment(double amount){
        System.out.println("Processing payment via Stripe" + amount);
    }
}

interface Invoice{
    void generateInvoice();
}

class GSTInvoice implements Invoice{
    public void generateInvoice(){
        System.out.println("Generating GST invoice for India.");

    }
}

class UsInvoice implements Invoice{
    public void generateInvoice(){
        System.out.println("Generating us invoice for USA.");

    }

}
// --------- Abstract factory Designing
interface RegionFactory{
     PaymentGateway createPaymentGateway(String gatewayType);
     Invoice createInvoice();
}
class IndiaFactory implements RegionFactory{
    public  PaymentGateway createPaymentGateway(String gatewayType){
        switch(gatewayType.toLowerCase()){
            case "razorpay":
                return new RazorpayGateway();
            case "payu":
                return new PayUGateway();
            default:
                throw new IllegalArgumentException("Unsupported payment gateway in India: " + null)
        }

    }
    public  Invoice createInvoice(){
        return new GSTInvoice();
    }
}


class UsFactory implements RegionFactory{
    public  PaymentGateway createPaymentGateway(String gatewayType){
        switch(gatewayType.toLowerCase()){
            case "paypal":
                return new PaypalGateway();
            case "stripe":
                return new StripeGateway();
            default:
                throw new IllegalArgumentException("Unsupported payment gateway in India: " + null)
        }

    }
    public  Invoice createInvoice(){
        return new UsInvoice();
    }
}

class CheckoutService{
    private PaymentGateway paymentGateway;
    private Invoice invoice;
    private String gatewayType;

    public CheckoutService(RegionFactory factory,String gatewayType){
        this.gatewayType = gatewayType;
        this.paymentGateway = factory.createPaymentGateway(gatewayType);
        this.invoice = factory.createInvoice();
    }

    public void completeOrder(double amount){
        paymentGateway.processPayment(amount);
        invoice.generateInvoice();
    }
}


/* class CheckoutService{
    private String gatewayType;
    public CheckoutService(String gatewayType){
        this.gatewayType = gatewayType;
    }
// -------------------------------------- before factory
              /*   public void checkOut(double amount){
                    if(gatewayType == "razorpay"){

                        PaymentGateway paymentGateway = new RazorpayGateway();
                        paymentGateway.processPayment(amount);
                    }else{
                        PaymentGateway paymentGateway = new PayUGateway();
                        paymentGateway.processPayment(amount);        
                    }
                    Invoice invoice = new GSTInvoice();
                    invoice.generateInvoice();
                }*/
// ------------------------------------------------------
// After using factory
/*public void checkOut(double amount){
    PaymentGateway paymentGateway = IndiaFactory.createPaymentGateway("razorpay");
    paymentGateway.processPayment(amount);
    Invoice invoice = IndiaFactory.creatInvoice();
    invoice.generateInvoice();


}
}*/
public class Abstract {
    public static void main(String[] args) {
        CheckoutService checkoutServiceforIndia = new CheckoutService(new IndiaFactory(), "razorpay");
        CheckoutService checkoutServiceforUs = new CheckoutService(new UsFactory(),"stripe");
    }
}