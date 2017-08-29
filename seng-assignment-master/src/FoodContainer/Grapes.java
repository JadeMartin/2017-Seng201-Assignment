package FoodContainer;
import Game.Food;
/**
 * The Grapes Class is for creating a food of type Grape it inherits its methods from the abstract class Food.
 * <p>
 * The class defines the Grapes food name, price and nutritional value.
 * The class is needed to create multiple grapes of type Food which can then be brought from a shop at the set price and then eaten for the set nutritional value.
 * @author Jade Martin
 * @author Kyran Stagg
 */
public class Grapes extends Food{
	/**
	 * The method Grapes() initializes the grapes by creating a grape of type Food in which its price, name and nutritional value are already preset.
	 */
	public Grapes() {
		super.setFoodName("Grapes");
		super.setFoodPrice(5.00);
		super.setNutritionValue(10);
	}
}