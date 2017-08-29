package SpeciesContainer;
import Game.Species;
/**
 * The Rabbit Class is for creating a Species of type Rabbit it inherits its methods from the abstract class Species which then becomes a pet.
 * <p>
 * The class defines the Rabbits species name, weight and damage.
 * The class is needed to create multiple Rabbit of type Species which can then be
 * turned into a pet and added to a player.
 * @author Jade Martin
 * @author Kyran Stagg
 */
public class Rabbit extends Species{
	/**
	 * The method Rabbit() initializes the Rabbit by creating a Rabbit of type Species in which its species name, weight and damage value are already preset.
	 */
	public Rabbit() {
		super.setSpeciesWeight(5.00);
		super.setSpeciesDamage(10.00);
		super.setSpeciesName("Rabbit");
	}
}