package SpeciesContainer;
import Game.Species;
/**
 * The Budgie Class is for creating a Species of type Budgie it inherits its methods from the abstract class Species which then becomes a pet.
 * <p>
 * The class defines the Budgies species name, weight and damage.
 * The class is needed to create multiple Budgies of type Species which can then be
 * turned into a pet and added to a player.
 * @author Jade Martin
 * @author Kyran Stagg
 */
public class Budgie extends Species{
	/**
	 * The method Budgie() initializes the Budgie by creating a Budgie of type Species in which its species name, weight and damage value are already preset.
	 */
	public Budgie() {
		super.setSpeciesWeight(1.00);
		super.setSpeciesDamage(6.00);
		super.setSpeciesName("Budgie");
	}
}