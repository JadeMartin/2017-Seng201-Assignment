package SpeciesContainer;
import Game.Species;
/**
 * The Manatee Class is for creating a Species of type Manatee it inherits its methods from the abstract class Species which then becomes a pet.
 * <p>
 * The class defines the Manatees species name, weight and damage.
 * The class is needed to create multiple Manatee of type Species which can then be
 * turned into a pet and added to a player.
 * @author Jade Martin
 * @author Kyran Stagg
 */
public class Manatee extends Species{
	/**
	 * The method Manatee() initializes the Manatee by creating a Manatee of type Species in which its species name, weight and damage value are already preset.
	 */
	public Manatee() {
		super.setSpeciesWeight(100.00);
		super.setSpeciesDamage(4.00);
		super.setSpeciesName("Manatee");
	}
}