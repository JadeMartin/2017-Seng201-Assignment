package FoodContainer;
import Game.Food;
/**
 * The Salmon Class is for creating a food of type Salmon it inherits its methods from the abstract class Food.
 * <p>
 * The class defines the Salmon food name, price and nutritional value.
 * The class is needed to create multiple Salmon of type Food which can then be brought from a shop at the set price and then eaten for the set nutritional value.
 * @author Jade Martin
 * @author Kyran Stagg
 */
public class Salmon extends Food{
	/**
	 * The method Salmon() initializes the Salmon by creating a Salmon of type Food in which its price, name and nutritional value are already preset.
	 */
	public Salmon() {
		super.setFoodName("Salmon");
		super.setFoodPrice(20.00);
		super.setNutritionValue(25);
	}
}