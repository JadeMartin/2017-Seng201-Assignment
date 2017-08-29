package FoodContainer;
import Game.Food;
/**
 * The Steak Class is for creating a food of type Steak it inherits its methods from the abstract class Food.
 * <p>
 * The class defines the Steak food name, price and nutritional value.
 * The class is needed to create multiple Steak of type Food which can then be brought from a shop at the set price and then eaten for the set nutritional value.
 * @author Jade Martin
 * @author Kyran Stagg
 */
public class Steak extends Food{
	/**
	 * The method Steak() initializes the Steak by creating a Steak of type Food in which its price, name and nutritional value are already preset.
	 */
	public Steak() {
		super.setFoodName("Steak");
		super.setFoodPrice(35.00);
		super.setNutritionValue(35);
	}
}