package ToyContainer;
import Game.Toys;
/**
 * The SqueakyDuck Class is for creating a toy of type SqueakyDuck it inherits its methods from the abstract class Toys.
 * <p>
 * The class defines the SqueakyDuck food name, price and toy durability.
 * The class is needed to create multiple SqueakyDuck of type Toy which can then be brought from a shop at the set price 
 * and then played with but will lose durability after each play based on pet damage.
 * @author Jade Martin
 * @author Kyran Stagg
 */
public class SqueakyDuck extends Toys {
	/**
	 * The method SqueakyDuck() initializes the SqueakyDuck by creating a SqueakyDuck of type Toy in which its price, name and durability value are already preset.
	 */
	public SqueakyDuck() {
		super.setToyName("Squeaky Toy Duck");
		super.setToyDurability(100.00);
		super.setToyPrice(10.00);
	}
}