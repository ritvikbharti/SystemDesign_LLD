// class PlainPizza{};
/*class CheesePizza extends PlainPizza{};
class OlivePizza extends PlainPizza{};
class stuffedPizza extends PlainPizza{};
class CheeseOlivePizza extends CheesePizza{};
class CheeseOliveStuffedPizza extends CheeseOlivePizza{};
*/

interface Pizza{
    String getDescription();
    double getCost();
}


class Margherita implements Pizza{
    @Override
    public  String getDescription(){
        return "Margherita Pizza";
    }
    public double getCost(){
        return 200.0;
    }
}

class PlainPizza implements Pizza{
    @Override
    public String getDescription(){
        return "Plain Pizza";
    }
    @Override
    public double getCost(){
        return 100.0;
    }

}

abstract class  PizzaDecorator implements Pizza{
    protected Pizza pizza;
    public PizzaDecorator(Pizza pizza){
        this.pizza = pizza;
    }

    
}

class ExtraCheese extends PizzaDecorator{
    public ExtraCheese(Pizza pizza){
        super(pizza);
    }
    @Override
    public String getDescription(){
        return pizza.getDescription()+ ", Extra cheese";

    }
    @Override
    public double getCost(){
        return pizza.getCost() + 40.0;
    }
}

class Olives extends PizzaDecorator{
    public Olives(Pizza pizza){
        super(pizza);
    }
    @Override
    public String getDescription(){
        return pizza.getDescription() + ", Olives";
    }

    @Override 
    public double getCost(){
        return pizza.getCost() + 30.0;
    }
}

class Stuffed extends PizzaDecorator{

    public Stuffed(Pizza pizza){
        super(pizza);
    }


    @Override
    public String getDescription(){
        return pizza.getDescription() + ", Stuffed";
    }

    @Override
    public double getCost(){
        return pizza.getCost() + 50.0;
    }
}

public class Decorator{
    public static void main(String[] args) {
        Pizza pizza  = new ExtraCheese(new PlainPizza());
        Pizza op = new Olives(pizza);
        Pizza stuff = new Stuffed(op);
        System.out.println(stuff.getCost());
    }
}