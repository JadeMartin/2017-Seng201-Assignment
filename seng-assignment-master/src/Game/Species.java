package Game;
/**
 * The Species Class is for initializing Species objects and their attributes.
 * <p>
 * Species class it used to create multiple species which in turn become pets. 
 * this class is inherited by the pet class as the pet can use the methods in this to get the base weight and base damage of the pet.
 * the Species class is also an abstract class
 * @author Jade Martin
 * @author Kyran Stagg
 *
 */
public abstract class Species {
	/**
	 * Represents the species name.
	 */
	private String name;
	/**
	 * Represents the base weight of the species.
	 */
	private Double baseWeight;
	/**
	 * Represents the base damage of the species.
	 */
	private Double baseDamage;
	/**
	 * This method is used to return the Species weight.
	 * @return Double This returns the Species weight.
	 */
	public Double getSpeciesWeight(){
		return baseWeight;
		}
	/**
	 * This method is used to set and update the Species weight.
	 * @param speciesWeightInput This is the inputed species weight and is used as the new default weight for the species and for the pet.
	 */
	public void setSpeciesWeight(Double speciesWeightInput){
		baseWeight = speciesWeightInput;
	}
	/**
	 * This method is used to return the Species damage.
	 * @return Double This returns the Species damage.
	 */
	public Double getSpeciesDamage(){
		return baseDamage;
	}
	/**
	 * This method is used to set and update the Species damage
	 * @param speciesDamageInput This is the inputed species damage and is used as the new default damage for the species and for the pet.
	 */
	public void setSpeciesDamage(Double speciesDamageInput){
		baseDamage = speciesDamageInput;
	}
	/**
	 * This method is used to return the Species name.
	 * @return String This returns the Species name.
	 */
	public String getSpeciesName(){
		return name;
	}
	/**
	 * This method is used to set and update the Species name.
	 * @param speciesNameInput This is the inputed species name and is used as the new default name for the species and for the pet species.
	 */
	public void setSpeciesName(String speciesNameInput){
		name = speciesNameInput;
	}

}
