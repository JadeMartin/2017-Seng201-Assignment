package ToyContainer;
import Game.Toys;
/**
 * The OldTeddy Class is for creating a toy of type OldTeddy it inherits its methods from the abstract class Toys.
 * <p>
 * The class defines the OldTeddy food name, price and toy durability.
 * The class is needed to create multiple OldTeddy of type Toy which can then be brought from a shop at the set price 
 * and then played with but will lose durability after each play based on pet damage.
 * @author Jade Martin
 * @author Kyran Stagg
 */
public class OldTeddy extends Toys {
	/**
	 * The method OldTeddy() initializes the OldTeddy by creating a OldTeddy of type Toy in which its price, name and durability value are already preset.
	 */
	public OldTeddy(){
		super.setToyName("Old Teddy Bear");
		super.setToyDurability(50.00);
		super.setToyPrice(5.00);
	}
}