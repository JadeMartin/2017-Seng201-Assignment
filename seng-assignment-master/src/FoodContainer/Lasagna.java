package FoodContainer;
import Game.Food;
/**
 * The Lasagna Class is for creating a food of type Lasagna it inherits its methods from the abstract class Food.
 * <p>
 * The class defines the Lasagna's food name, price and nutritional value.
 * The class is needed to create multiple Lasagna's of type Food which can then be brought from a shop at the set price and then eaten for the set nutritional value.
 * @author Jade Martin
 * @author Kyran Stagg
 */
public class Lasagna extends Food{
	/**
	 * The method Lasagna() initializes the Lasagna by creating a Lasagna of type Food in which its price, name and nutritional value are already preset.
	 */
	public Lasagna() {
		super.setFoodName("Lasagna");
		super.setFoodPrice(15.00);
		super.setNutritionValue(20);
	}
}