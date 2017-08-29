package FoodContainer;
import Game.Food;
/**
 * The SicknessCure Class is for creating a food of type SicknessCure it inherits its methods from the abstract class Food.
 * <p>
 * The class defines the SicknessCure food name, price and nutritional value.
 * The class is needed to create multiple SicknessCure of type Food which can then be brought from a shop at the set price and then eaten for the set nutritional value.
 * The class is special as it is the only way to cure a pet of sickness hence why it has a high food price.
 * @author Jade Martin
 * @author Kyran Stagg
 */
public class SicknessCure extends Food{
	/**
	 * The method SicknessCure() initializes the SicknessCure by creating a SicknessCure of type Food in which its price, name and nutritional value are already preset.
	 */
	public SicknessCure() {
		super.setFoodName("Sickness Potion");
		super.setFoodPrice(50.00);
		super.setNutritionValue(1);
	}
}