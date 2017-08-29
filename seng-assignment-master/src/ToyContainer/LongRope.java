package ToyContainer;
import Game.Toys;
/**
 * The LongRope Class is for creating a toy of type LongRope it inherits its methods from the abstract class Toys.
 * <p>
 * The class defines the LongRope food name, price and toy durability.
 * The class is needed to create multiple LongRope of type Toy which can then be brought from a shop at the set price 
 * and then played with but will lose durability after each play based on pet damage.
 * @author Jade Martin
 * @author Kyran Stagg
 */
public class LongRope extends Toys {
	/**
	 * The method LongRope() initializes the LongRope by creating a LongRope of type Toy in which its price, name and durability value are already preset.
	 */
	public LongRope() {
		super.setToyName("Long Rope");
		super.setToyDurability(100.00);
		super.setToyPrice(10.00);
	}
}