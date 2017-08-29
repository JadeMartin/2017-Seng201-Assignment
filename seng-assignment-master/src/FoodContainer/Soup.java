package FoodContainer;
import Game.Food;
/**
 * The Soup Class is for creating a food of type Soup it inherits its methods from the abstract class Food.
 * <p>
 * The class defines the Soup food name, price and nutritional value.
 * The class is needed to create multiple Soup of type Food which can then be brought from a shop at the set price and then eaten for the set nutritional value.
 * @author Jade Martin
 * @author Kyran Stagg
 */
public class Soup extends Food{
	/**
	 * The method Soup() initializes the Soup by creating a Soup of type Food in which its price, name and nutritional value are already preset.
	 */
	public Soup() {
		super.setFoodName("Soup");
		super.setFoodPrice(5.00);
		super.setNutritionValue(10);
	}
}