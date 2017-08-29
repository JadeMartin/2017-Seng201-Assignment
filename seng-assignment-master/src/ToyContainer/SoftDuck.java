package ToyContainer;
import Game.Toys;
/**
 * The SoftDuck Class is for creating a toy of type SoftDuck it inherits its methods from the abstract class Toys.
 * <p>
 * The class defines the SoftDuck food name, price and toy durability.
 * The class is needed to create multiple SoftDuck of type Toy which can then be brought from a shop at the set price 
 * and then played with but will lose durability after each play based on pet damage.
 * @author Jade Martin
 * @author Kyran Stagg
 */
public class SoftDuck extends Toys {
	/**
	 * The method SoftDuck() initializes the SoftDuck by creating a SoftDuck of type Toy in which its price, name and durability value are already preset.
	 */
	public SoftDuck() {
		super.setToyName("Soft Toy Duck");
		super.setToyDurability(50.00);
		super.setToyPrice(5.00);
	}
}