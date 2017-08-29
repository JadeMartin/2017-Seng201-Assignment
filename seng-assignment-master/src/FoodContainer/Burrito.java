package FoodContainer;
import Game.Food;
/**
 * The Burrito Class is for creating a food of type Burrito it inherits its methods from the abstract class Food.
 * <p>
 * The class defines the Burrito's food name, price and nutritional value.
 * The class is needed to create multiple Burrito's of type Food which can then be brought from a shop at the set price and then eaten for the set nutritional value.
 * @author Jade Martin
 * @author Kyran Stagg
 */
public class Burrito extends Food{
	/**
	 * The method Burrito() initializes the Burrito by creating a Burrito of type Food in which its price, name and nutritional value are already preset.
	 */
	public Burrito() {
		super.setFoodName("Burrito");
		super.setFoodPrice(13.00);
		super.setNutritionValue(18);
	}
}