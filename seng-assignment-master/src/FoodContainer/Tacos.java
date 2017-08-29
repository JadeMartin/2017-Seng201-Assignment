package FoodContainer;
import Game.Food;
/**
 * The Tacos Class is for creating a food of type Tacos it inherits its methods from the abstract class Food.
 * <p>
 * The class defines the Tacos food name, price and nutritional value.
 * The class is needed to create multiple Tacos of type Food which can then be brought from a shop at the set price and then eaten for the set nutritional value.
 * @author Jade Martin
 * @author Kyran Stagg
 */
public class Tacos extends Food{
	/**
	 * The method Tacos() initializes the Tacos by creating a Tacos of type Food in which its price, name and nutritional value are already preset.
	 */
	public Tacos() {
		super.setFoodName("Tacos");
		super.setFoodPrice(5.00);
		super.setNutritionValue(10);
	}
}