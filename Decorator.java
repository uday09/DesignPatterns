package Structural;

/*
The decorator pattern is used to extend or alter the functionality of objects at run-time by wrapping them in an object of a decorator class. 
This provides a flexible alternative to using inheritance to modify behaviour

Example could be a Pizza with various Toppings. Based on Toppings selected, Price may vary. 
*/
/*
enum SIZE {
	SMALL, MEDIUM, LARGE;
}
*/
abstract class Pizza {
	// it is an abstract pizza
	String description = "Unkknown Pizza";

	public String getDescription() {
		return description;
	}

	public abstract int getCost();
}

class PeppyPaneer extends Pizza {
	public PeppyPaneer() {
		description = "PeppyPaneer";
	}

	public int getCost() {
		return 100;
	}
}

class FarmHouse extends Pizza {
	public FarmHouse() {
		description = "FarmHouse";
	}

	public int getCost() {
		return 200;
	}
}

class Margherita extends Pizza {
	public Margherita() {
		description = "Margherita";
	}

	public int getCost() {
		return 100;
	}
}

abstract class ToppingsDecorator extends Pizza {
	public abstract String getDescription();
}

class Paneer extends ToppingsDecorator {
	Pizza pizza;

	public Paneer(Pizza pizza) {
		this.pizza = pizza;
	}

	public String getDescription() {
		return pizza.getDescription() + ", Paneer ";
	}

	public int getCost() {
		return 70 + pizza.getCost();
	}
}

class Olives extends ToppingsDecorator {
	Pizza pizza;

	public Olives(Pizza pizza) {
		this.pizza = pizza;
	}

	public String getDescription() {
		return pizza.getDescription() + ", Paneer ";
	}

	public int getCost() {
		return 70 + pizza.getCost();
	}
}

public class Decorator {
	public static void main(String args[]) 
    { 
        // create new margherita pizza 
        Pizza pizza = new Margherita(); 
        System.out.println( pizza.getDescription() + 
                         " Cost :" + pizza.getCost()); 
  
        // create new FarmHouse pizza 
        Pizza pizza2 = new FarmHouse(); 
  
        // decorate it with olives topping 
        pizza2 = new Olives(pizza2); 
  
        //decorate it with paneer topping 
        pizza2 = new Paneer(pizza2); 
  
        System.out.println( pizza2.getDescription() + 
                         " Cost :" + pizza2.getCost()); 
       
   }
}
