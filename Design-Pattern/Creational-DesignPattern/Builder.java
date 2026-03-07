import java.util.*;
// Builder pattern is a design pattern that allows for the construction of complex objects step by step, separating the construction process from the representation.
//  It is particularly useful when an object can be created with various configurations or when the construction process involves multiple steps.
class BurgerMeal{
    // Required
    private final  String bunType;
    private final String patty;
    // OPtional
    private final boolean hasCheese;
    private final List<String> toppings;
    private final String side;
    private final String drink;


    private BurgerMeal(BurgerBuilder builder){
        this.bunType = builder.bunType;
        this.patty = builder.patty;
        this.hasCheese = builder.hasCheese;
        this.toppings = builder.toppings;
        this.side = builder.side;
        this.drink = builder.drink;
    }



//Seperate  Inner Class
   public static class BurgerBuilder{
        // Required
    private final  String bunType;
    private final String patty;
    // OPtional
    private final boolean hasCheese;
    private final List<String> toppings;
    private final String side;
    private final String drink;
    // Taking the mandatory parameter
    public BurgerBuilder(String bunType,String patty){
        this.bunType = bunType;
        this.patty = patty;
    }
    // returning the builder object itself to allow method chaining
    public BurgerBuilder withChesse(boolean hasCheese){
        this.hasCheese = hasCheese;
        return this;
    }
 // method chaining allows us to set multiple optional parameters in a single statement, making the code more readable and concise.
    public BurgerBuilder withToppings(List<String> toppings){
        this.toppings = toppings;
        return this;
    }

    public BurgerBuilder withSide(String side){
        this.side = side;
        return this;
    }


    public BurgerMeal build(){
      return new BurgerMeal(this);
    }
   }
    
}

public class Builder{
    public static void main(String args[]){
        BurgerMeal burgerMeal = new BurgerMeal.BurgerBuilder("wheat", "veg").build();
        BurgerMeal burgerMealWithCheeseWithside = new BurgerMeal.BurgerBuilder("wheat", "veg").withChesse(true).withSide("fries").build();
    }
}
