package SpeciesContainer;
import Game.Species;
/**
 * The Sloth Class is for creating a Species of type Sloth it inherits its methods from the abstract class Species which then becomes a pet.
 * <p>
 * The class defines the Sloths species name, weight and damage.
 * The class is needed to create multiple Sloth of type Species which can then be
 * turned into a pet and added to a player.
 * @author Jade Martin
 * @author Kyran Stagg
 */
public class Sloth extends Species{
	/**
	 * The method Sloth() initializes the Sloth by creating a Sloth of type Species in which its species name, weight and damage value are already preset.
	 */
	public Sloth() {
		super.setSpeciesWeight(15.00);
		super.setSpeciesDamage(18.00);
		super.setSpeciesName("Sloth");
	}
}