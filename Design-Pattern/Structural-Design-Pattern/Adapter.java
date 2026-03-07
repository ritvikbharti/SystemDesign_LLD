interface PaymentGateway{
    public void pay(String orderId,double amount);
}

class PayUGateway implements PaymentGateway{
    @Override
    public void pay(String orderId,double amount ){
        System.out.println("Paid Rs "+ amount + " using PayU for order: "+ orderId);

    }
}
// Not implementing PaymentGateway ie 3rd party
class RazorpayApi{
    public void makePayment(String invoiceId,double amountInRupees){
        System.out.println("Paid Rs"+ amountInRupees + " using Razorpay for invoice "+ invoiceId);
    }
}

// we use adapter pattern to solve that issue

        class RazorpayAdapter implements PaymentGateway{
            private RazorpayApi razorpayApi;

            public RazorpayAdapter(){
                this.razorpayApi = new RazorpayApi();
            }
            public void pay(String orderId,double amount){
                razorpayApi.makePayment(orderId, amount);
            }
        }
class CheckoutService{
    private PaymentGateway paymentGateway;
    public CheckoutService(PaymentGateway paymentGateway){
        this.paymentGateway = paymentGateway; //adapting para
    }
    public void checkout(String orderId,double amount){
        paymentGateway.pay(orderId,amount);
    }
}

public class Adapter{
    public static void main(String[] args) {
        CheckoutService checkoutService = new CheckoutService(new RazorpayAdapter());
        checkoutService.checkout("7777",100000);
        CheckoutService checkoutService2 = new CheckoutService(new PayUGateway());
        checkoutService2.checkout("1111",9999999);
    }

}