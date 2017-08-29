package ToyContainer;
import Game.Toys;
/**
 * The SmallFrizbee Class is for creating a toy of type SmallFrizbee it inherits its methods from the abstract class Toys.
 * <p>
 * The class defines the SmallFrizbee food name, price and toy durability.
 * The class is needed to create multiple SmallFrizbee of type Toy which can then be brought from a shop at the set price 
 * and then played with but will lose durability after each play based on pet damage.
 * @author Jade Martin
 * @author Kyran Stagg
 */
public class SmallFrizbee extends Toys {
	/**
	 * The method SmallFrizbee() initializes the SmallFrizbee by creating a SmallFrizbee of type Toy in which its price, name and durability value are already preset.
	 */
	public SmallFrizbee() {
		super.setToyName("Small Frizbee");
		super.setToyDurability(50.00);
		super.setToyPrice(5.00);
	}
}