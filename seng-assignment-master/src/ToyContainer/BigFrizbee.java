package ToyContainer;
import Game.Toys;
/**
 * The BigFrizbee Class is for creating a toy of type BigFrizbee it inherits its methods from the abstract class Toys.
 * <p>
 * The class defines the BigFrizbee food name, price and toy durability.
 * The class is needed to create multiple BigFrizbee of type Toy which can then be brought from a shop at the set price 
 * and then played with but will lose durability after each play based on pet damage.
 * @author Jade Martin
 * @author Kyran Stagg
 */
public class BigFrizbee extends Toys {
	/**
	 * The method BigFrizbee() initializes the BigFrizbee by creating a BigFrizbee of type Toy in which its price, name and durability value are already preset.
	 */
	public BigFrizbee() {
		super.setToyName("Big Frizbee");
		super.setToyDurability(100.00);
		super.setToyPrice(10.00);
	}
}