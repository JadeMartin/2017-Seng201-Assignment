package ToyContainer;
import Game.Toys;
/**
 * The MisbehavouringWhip Class is for creating a toy of type MisbehavouringWhip it inherits its methods from the abstract class Toys.
 * <p>
 * The class defines the MisbehavouringWhip food name, price and toy durability.
 * The class is needed to create multiple MisbehavouringWhip of type Toy which can then be brought from a shop at the set price 
 * and then played with but will lose durability after each play based on pet damage.
 * The Misbehavouring Whip is a special toy in that on use it will cure the misbehaving status but for this strong perk it has a sharply increased price.
 * @author Jade Martin
 * @author Kyran Stagg
 */
public class MisbehavouringWhip extends Toys {
	/**
	 * The method MisbehavouringWhip() initializes the MisbehavouringWhip by creating a MisbehavouringWhip of type Toy in which its price, name and durability value are already preset.
	 */
	public MisbehavouringWhip() {
		super.setToyName("Whip to cure misbhavouring");
		super.setToyDurability(100.00);
		super.setToyPrice(100.00);
	}
}