package SpeciesContainer;
import Game.Species;
/**
 * The Cat Class is for creating a Species of type Cat it inherits its methods from the abstract class Species which then becomes a pet.
 * <p>
 * The class defines the Cats species name, weight and damage.
 * The class is needed to create multiple Cat of type Species which can then be
 * turned into a pet and added to a player.
 * @author Jade Martin
 * @author Kyran Stagg
 */
public class Cat extends Species{
	/**
	 * The method Cat() initializes the Cat by creating a Cat of type Species in which its species name, weight and damage value are already preset.
	 */
	public Cat() {
		super.setSpeciesWeight(15.00);
		super.setSpeciesDamage(10.00);
		super.setSpeciesName("Cat");
	}
}