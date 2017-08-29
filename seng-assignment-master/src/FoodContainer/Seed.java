package FoodContainer;
import Game.Food;
/**
 * The Seed Class is for creating a food of type Seed it inherits its methods from the abstract class Food.
 * <p>
 * The class defines the Seed food name, price and nutritional value.
 * The class is needed to create multiple Seed of type Food which can then be brought from a shop at the set price and then eaten for the set nutritional value.
 * @author Jade Martin
 * @author Kyran Stagg
 */
public class Seed extends Food{
	/**
	 * The method Seed() initializes the Seed by creating a Seed of type Food in which its price, name and nutritional value are already preset.
	 */
	public Seed() {
		super.setFoodName("Bag of Seeds");
		super.setFoodPrice(5.00);
		super.setNutritionValue(10);
	}
}