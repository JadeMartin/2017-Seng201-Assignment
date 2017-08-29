package ToyContainer;
import Game.Toys;
/**
 * The ShortRope Class is for creating a toy of type ShortRope it inherits its methods from the abstract class Toys.
 * <p>
 * The class defines the ShortRope food name, price and toy durability.
 * The class is needed to create multiple ShortRope of type Toy which can then be brought from a shop at the set price 
 * and then played with but will lose durability after each play based on pet damage.
 * @author Jade Martin
 * @author Kyran Stagg
 */
public class ShortRope extends Toys {
	/**
	 * The method ShortRope() initializes the ShortRope by creating a ShortRope of type Toy in which its price, name and durability value are already preset.
	 */
	public ShortRope() {
		super.setToyName("Short Rope");
		super.setToyDurability(50.00);
		super.setToyPrice(5.00);
	}
}