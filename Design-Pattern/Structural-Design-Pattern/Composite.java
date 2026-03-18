import java.util.ArrayList;
import java.util.List;

interface CartItem {
    double getPrice();
    void display(String indent);
}

class Product implements CartItem {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + name + ": " + price);
    }
}

class ProductBundle implements CartItem {
    private String bundleName;
    private List<CartItem> items = new ArrayList<>();

    public ProductBundle(String bundleName) {
        this.bundleName = bundleName;
    }

    public void addItem(CartItem item) {
        items.add(item);
    }

    @Override
    public double getPrice() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "Bundle: " + bundleName);
        for (CartItem item : items) {
            item.display(indent + "  ");
        }
    }
}

public class Composite {
    public static void main(String[] args) {

        CartItem book = new Product("Atomic Habits", 1000);
        CartItem phone = new Product("iPhone 15", 50000);
        CartItem charger = new Product("20W Charger", 2000);

        ProductBundle iphoneBundle = new ProductBundle("iPhone Combo");
        iphoneBundle.addItem(phone);
        iphoneBundle.addItem(charger);

        ProductBundle schoolBundle = new ProductBundle("School Bundle");
        schoolBundle.addItem(book);
        schoolBundle.addItem(new Product("Notebook Pack", 200));
        schoolBundle.addItem(new Product("Pen Set", 50));

        List<CartItem> cart = new ArrayList<>();
        cart.add(iphoneBundle);
        cart.add(schoolBundle);

        System.out.println("Your Amazon Cart:");

        double totalPrice = 0;
        for (CartItem item : cart) {
            item.display(" ");
            totalPrice += item.getPrice();
        }

        System.out.println("Total Price: " + totalPrice);
    }
}