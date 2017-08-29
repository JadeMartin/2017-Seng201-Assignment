package ToyContainer;
import Game.Toys;
/**
 * The RedBall Class is for creating a toy of type RedBall it inherits its methods from the abstract class Toys.
 * <p>
 * The class defines the RedBall food name, price and toy durability.
 * The class is needed to create multiple RedBall of type Toy which can then be brought from a shop at the set price 
 * and then played with but will lose durability after each play based on pet damage.
 * @author Jade Martin
 * @author Kyran Stagg
 */
public class RedBall extends Toys {
	/**
	 * The method RedBall() initializes the RedBall by creating a RedBall of type Toy in which its price, name and durability value are already preset.
	 */
	public RedBall() {
		super.setToyName("Red Ball");
		super.setToyDurability(50.00);
		super.setToyPrice(5.00);
	}
}
