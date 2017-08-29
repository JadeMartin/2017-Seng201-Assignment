package FoodContainer;
import Game.Food;
/**
 * The JellyMeat Class is for creating a food of type JellyMeat it inherits its methods from the abstract class Food.
 * <p>
 * The class defines the Jelly Meat's food name, price and nutritional value.
 * The class is needed to create multiple Jelly Meat's of type Food which can then be brought from a shop at the set price and then eaten for the set nutritional value.
 * @author Jade Martin
 * @author Kyran Stagg
 */
public class JellyMeat extends Food{
	/**
	 * The method JellyMeat() initializes the JellyMeat by creating a JellyMeat of type Food in which its price, name and nutritional value are already preset.
	 */
	public JellyMeat() {
		super.setFoodName("Jelly Meat");
		super.setFoodPrice(5.00);
		super.setNutritionValue(10);
	}
}