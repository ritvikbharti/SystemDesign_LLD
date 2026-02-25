
// ---> Open Closed Principle (OCP) <---
interface TaxCalculator {
    double amountAfterTax(double amount);
}

class IndianTax implements TaxCalculator{
    public double amountAfterTax(double amount){
        return (amount +0.18*amount);
    }
}
class USATax implements TaxCalculator{
    public double amountAfterTax(double amount){
        return (amount +0.07*amount);
    }
}
class InvoiceService{
    public void calculate(){
        TaxCalculator taxCalculator = new IndianTax();
        double amount = 100.0;
        double totalAmount = taxCalculator.amountAfterTax(amount);
        System.out.println("Total amount after tax: " + totalAmount);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}