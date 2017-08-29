package FoodContainer;
import Game.Food;
/**
 * The DryBiscuit Class is for creating a food of type DryBiscuit it inherits its methods from the abstract class Food.
 * <p>
 * The class defines the Dry Biscuit's food name, price and nutritional value.
 * The class is needed to create multiple Dry Biscuit's of type Food which can then be brought from a shop at the set price and then eaten for the set nutritional value.
 * @author Jade Martin
 * @author Kyran Stagg
 */
public class DryBiscuit extends Food{
	/**
	 * The method DryBiscuit() initializes the DryBiscuit by creating a DryBiscuit of type Food in which its price, name and nutritional value are already preset.
	 */
	public DryBiscuit() {
		super.setFoodName("Dry Biscuits");
		super.setFoodPrice(5.00);
		super.setNutritionValue(5);
	}
}