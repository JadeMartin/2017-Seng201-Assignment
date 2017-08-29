package SpeciesContainer;
import Game.Species;
/**
 * The Dog Class is for creating a Species of type Dog it inherits its methods from the abstract class Species which then becomes a pet.
 * <p>
 * The class defines the Dogs species name, weight and damage.
 * The class is needed to create multiple Dog of type Species which can then be
 * turned into a pet and added to a player.
 * @author Jade Martin
 * @author Kyran Stagg
 */
public class Dog extends Species{
	/**
	 * The method Dog() initializes the Dog by creating a Dog of type Species in which its species name, weight and damage value are already preset.
	 */
	public Dog() {
		super.setSpeciesWeight(20.00);
		super.setSpeciesDamage(16.00);
		super.setSpeciesName("Dog");
	}
}