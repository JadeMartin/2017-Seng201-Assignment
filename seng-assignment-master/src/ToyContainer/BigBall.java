package ToyContainer;
import Game.Toys;
/**
 * The BigBall Class is for creating a toy of type BigBall it inherits its methods from the abstract class Toys.
 * <p>
 * The class defines the BigBall food name, price and toy durability.
 * The class is needed to create multiple BigBall of type Toy which can then be brought from a shop at the set price 
 * and then played with but will lose durability after each play based on pet damage.
 * @author Jade Martin
 * @author Kyran Stagg
 */
public class BigBall extends Toys {
	/**
	 * The method BigBall() initializes the BigBall by creating a BigBall of type Toy in which its price, name and durability value are already preset.
	 */
	public BigBall() {
		super.setToyName("Big Blue Ball");
		super.setToyDurability(100.00);
		super.setToyPrice(10.00);
	}
}