package Game;


import javax.swing.JOptionPane;

/**
 * The Pet Class is for initializing Pet objects, their attributes and calculating attribute changes between rounds.
 * <p>
 * Each player object can have up to 3 unique Pet Objects. Pets have multiple "actions" that a player can use
 * on a pet. 
 * @author Jade Martin
 * @author Kyran Stagg
 * 
 */

public class Pet extends Species {
	/**
	 * Represents the Species.
	 */
	private Species species;
	/**
	 * Represents the Name.
	 */
	private String name;
	/**
	 * Represents the Favorite Food.
	 */
	private Food favouriteFood;
	/**
	 * Represents the Favorite Toy.
	 */
	private Toys favouriteToy;
	/**
	 * Represents the weight.
	 */
	private Double weight;
	/**
	 * Represents the Damage.
	 */
	private Double damage;
	/**
	 * Represents the playfulness defaulted to 100.
	 */
	private Integer playfullness = 100;
	/**
	 * Represents the dead state defaulted to false.
	 */
	private Boolean dead = false;
	/**
	 * Represents if the pet has been revived before defaulted to false.
	 */
	private Boolean hasBeenRevived = false;
	/**
	 * Represents the Hunger defaulted to 100.
	 */
	private double hunger = 100;
	/**
	 * Represents the Sickness State.
	 */
	private Boolean sickness = false;
	/**
	 * Represents the Misbehaving State.
	 */
	private Boolean misbehaving = false;
	/**
	 * Represents the health defaults to 100.
	 */
	private double health = 100.00;
	/**
	 * Represents the Tiredness defaults to 100.
	 */
	private double tiredness = 100;
	/**
	 * Represents the Toilet Level. Defaults to 100.
	 */
	private Integer toiletLevel = 100;
	
	
	/**
	 * This Method refreshes the Health of a Pet every round depending on the other pet attributes.
	 * Specifically Sickness which subtracts 10 from the health.
	 */
	public void updateHealth(){
		health = Math.round(playfullness *0.10) + (tiredness * 0.20) + (toiletLevel* 0.30) + (hunger * 0.40);
		if(sickness == true){
			health = Math.round(health - 10);
		}
		if (health < 0){
			health = 0;
		}
		
	}
	
	
	/**
	 * This Method is called when a pet is put to sleep. It counts as one player action.
	 * It restores +20 to a Pets Tiredness.
	 */
	public void sleep(){
		JOptionPane.showMessageDialog(null, "After a long sleep Your pet feels well rested.");
		if(tiredness > 80){
			tiredness = 100;
			}
		else{
			tiredness = tiredness + 20;
		}
		updateHealth();
	}
	
	
	/**
	 * This Method is called when a Pet uses the Toilet. It counts as one Player action.
	 * It restore 20 to the Pets Toilet Level and Reduces the pet weight by 2.5.
	 */
	public void bathroom(){
		JOptionPane.showMessageDialog(null, "After Going to the bathroom the pet feels a lot better.");
		if(toiletLevel > 80){
			toiletLevel = 100;
			}
		else{
			toiletLevel = toiletLevel + 20;
		}
		if (weight <= 1){
			weight = (double) 1;
		}else{
			weight = weight - (weight *0.05);
		}
		weight = (double) Math.round(weight);
		updateHealth();
	}
	
	
	/**
	 * This Method is called when a Pet plays with a Toy Object. It counts as one Player action.
	 * It restores 20 to the pets playfulness and if the Toy is a pets favorite, it will restore an additional 20.
	 * @param inputToy Toy A Toy object to be used by the Pet.
	 */
	public void play(Toys inputToy){
		JOptionPane.showMessageDialog(null, "After a play session the pet feels a lot better");
		int damageValue = Integer.valueOf(damage.intValue());
		if (inputToy.getToyName() == favouriteToy.getToyName()){
			JOptionPane.showMessageDialog(null, "Pets favourite toy inceases his happiness and the amount of energy used");
			if(playfullness + (20 + (damageValue/2)) > 100){
				playfullness = 100;
				}
			else{
				playfullness = playfullness + 20 + (damageValue/2);
			}
		}else{
			if(playfullness + (10 + (damageValue/2)) > 100){
				playfullness = 100;
			}
		else{
			playfullness = playfullness + 10 + (damageValue/2);
		}
		}
		updateHealth();
	}
	
	
	/**
	 * This Method is called when a Pet is being feed with a food object. It counts as one player action.
	 * It restores hunger by the amount of the foods nutrition level. But takes away 2 times the nutrition value
	 * from toilet level.
	 * @param nutritionValue This is the input nutrition value of the food to be feed.
	 * @param inputFood This is the Food object from the player inventory to be feed.
	 */
	public void feed(Integer nutritionValue, Food inputFood){
		JOptionPane.showMessageDialog(null, "After the snack the pet feels less hungry but also toilet level has been decreased and the pet needs to visit the toilet");
		if (inputFood.getFoodName() == favouriteFood.getFoodName()){
			JOptionPane.showMessageDialog(null, "Pets favourite toy inceases his happiness and the amount of hunger recovered");
			if((hunger + (nutritionValue*2))> 100){
				hunger = 100;
				}
			else{
				hunger = hunger + nutritionValue*2;
			}
		}else{
		if((hunger + nutritionValue)> 100){
			hunger = 100;
			}
		else{
			hunger = hunger + nutritionValue;
		}
		}
		toiletLevel = toiletLevel - (nutritionValue/2);
		if (toiletLevel < 0){
			toiletLevel = 0;
		}
		if (weight <= 1){
			weight = (double) 1;
		}else{
			weight = weight + (weight *0.05);
		}
		weight = (double) Math.round(weight);
		updateHealth();
	}
	
	
	
	/**
	 * This Method gets the species of a pet and returns it of type Species.
	 * @return Species This returns the Species
	 */
	public String getPetSpecies(){
		return species.getSpeciesName();
	}
	
	
	
	/**
	 * This Method is used to set the Species of a Pet Object and inturn, get the weight and damage of the pet.
	 * @param petSpeciesInput This is the Species to be set for the given pet.
	 */
	public void setPetSpecies(Species petSpeciesInput){
		weight = petSpeciesInput.getSpeciesWeight();
		damage = petSpeciesInput.getSpeciesDamage();
		species = petSpeciesInput;
	}
	
	
	
	/**
	 * This Method returns the name of a Pet object.
	 * @return String This returns the name of a Pet.
	 */
	public String getPetName(){
		return name;
	}	
	
	
	/**
	 * This Method sets the name of a pet or changes it.
	 * @param petNameInput This is the name to be set.
	 */
	public void setPetName(String petNameInput){
		name = petNameInput;
	}
		
	
	/**
	 * This Method return the Playfulness of a Pet Object.
	 * @return Integer Returns the Playfulness of the Pet.
	 */
	public Integer getPetPlayfullness(){
		return playfullness;
	}
	
	public void setPetPlayfullness(Integer petPlayfullnessInput){
		playfullness = petPlayfullnessInput;
	}
	
	
	/**
	 * This Method gets the Favorite Food of a Pet of type Food.
	 * @return Food Returns the Favorite Food of the Pet.
	 */
	public Food getPetFavouriteFood(){
		return favouriteFood;
	}
	
	
	
	/**
	 * This Method sets the Favorite Food of a Pet Object.
	 * @param petFavouriteFoodInput This is the Food Object to be assigned as the favorite food.
	 */
	public void setPetFavouriteFood(Food petFavouriteFoodInput){
		favouriteFood = petFavouriteFoodInput;
	}
	
	
	/**
	 * This Method Returns the Toy Object that is the favorite of a Pet Object.
	 * @return Toy The Favorite toy of a Pet.
	 */
	public Toys getPetFavouriteToy(){
		return favouriteToy;
	}
	
	
	/**
	 * This Method sets the Favorite Toy of a Pet Object.
	 * @param petFavouriteToyInput This is the Toy Object to be assigned as the favorite food.
	 */
	public void setPetFavouriteToy(Toys petFavouriteToyInput){
		favouriteToy = petFavouriteToyInput;
	}
	
	
	/**
	 * This Method Returns a Boolean value. True if the pet is dead and false if the pet is alive.
	 * @return Boolean The Death status of the Pet.
	 */
	public Boolean getPetDead() {
		return dead;
	}
	
	
	/**
	 * This Method sets the Dead Boolean of a pet. True being dead and False being alive.
	 * @param petDeadInput This is the Boolean to be set as the death state of the pet.
	 */
	public void setPetDead(Boolean petDeadInput) {
		dead = petDeadInput;
	}
	

	/**
	 * This Method returns the weight of a Pet Object.
	 * @return Double The Weight of a certain Pet.
	 */
	public Double getPetWeight() {
		return weight;
	}
	
	
	
	/**
	 * This Method Sets the weight of a Pet Object or changes it.
	 * @param petWeightInput This is the Double to be set as the weight.
	 */
	public void setPetWeight(Double petWeightInput) {
		weight = petWeightInput;
	}
	
	
	/**
	 * This Method Returns the Damage of a given Pet.
	 * @return Double The Damage of a Pet.
	 */
	public Double getPetDamage() {
		return damage;
	}
	
	
	
	/**
	 * This Method Sets the Damage of a Pet Object or changes it.
	 * @param petDamageInput This is the Double to be set as the Damage.
	 */
	public void setPetDamage(Double petDamageInput) {
		damage = petDamageInput;
	}
	
	
	
	/**
	 * This Method Returns the Hunger of a given Pet.
	 * @return double The Hunger of a Pet.
	 */
	public double getPetHunger() {
		return hunger;
	}
	
	
	
	/**
	 * This Method Sets the Hunger of a Pet Object or changes it.
	 * @param petHungerInput This is the Double to be set as the Hunger.
	 */
	public void setPetHunger(Integer petHungerInput) {
		hunger = petHungerInput;
	}
	
	
	
	/**
	 * This Method Returns the Sickness of a given Pet.
	 * @return Boolean The Sickness of a Pet.
	 */
	public Boolean getPetSickness() {
		return sickness;
	}
	
	
	
	/**
	 * This Method Sets the Sickness of a Pet Object or changes it.
	 * @param petSicknessInput This is the Boolean to be set as the Sickness.
	 */
	public void setPetSickness(Boolean petSicknessInput) {
		sickness = petSicknessInput;
	}
	
	
	
	/**
	 * This Method Returns the Health of a given Pet.
	 * @return Double The Health of a Pet.
	 */
	public Double getPetHealth() {
		return health;
	}
	
	
	
	
	/**
	 * This Method Sets the Health of a Pet Object or changes it.
	 * @param petHealthInput This is the Double to be set as the Health.
	 */
	public void setPetHealth(Double petHealthInput) {
		health = petHealthInput;
	}
	
	
	/**
	 * This Method Returns the Misbehaving State of a given Pet.
	 * @return Boolean The Misbehaving State of a Pet.
	 */
	public Boolean getPetMisbehaving() {
		return misbehaving;
	}
	
	
	
	/**
	 * This Method Sets the Misbehaving Boolean of a Pet Object or changes it.
	 * @param petMisbehavingInput This is the Boolean to be set as the Misbehaving.
	 */
	public void setPetMisbehaving(Boolean petMisbehavingInput) {
		misbehaving = petMisbehavingInput;
	}
	
	
	
	/**
	 * This Method Returns the Tiredness of a given Pet.
	 * @return Double The Tiredness of a Pet.
	 */
	public double getPetTiredness() {
		return tiredness;
	}
	
	
	
	/**
	 * This Method Sets the Tiredness of a Pet Object or changes it.
	 * @param petTirednessInput This is the Integer to be set as the Tiredness.
	 */
	public void setPetTiredness(Integer petTirednessInput) {
		tiredness = petTirednessInput;
	}
	
	
	/**
	 * This Method Returns the Toilet Level of a given Pet.
	 * @return Integer The Toilet Level of a Pet.
	 */
	public Integer getPetToiletLevel() {
		return toiletLevel;
	}
	
	
	
	/**
	 * This Method Sets the Toilet Level of a Pet Object or changes it.
	 * @param petToiletLevelInput This is the Integer to be set as the Toilet Level.
	 */
	public void setPetToiletLevel(Integer petToiletLevelInput) {
		toiletLevel = petToiletLevelInput;
	}
	
	
	
	/**
	 * This method returns the boolean of if the Pet object has been previously revived.
	 * @return Boolean Has the Pet been revived before.
	 */
	public Boolean getRevived(){
		return hasBeenRevived;
	}
	
	
	/**
	 * This method Revives a Pet and sets its death status to false.
	 * It also resets the pets statuses to their defaults.
	 */
	public void revivePet(){
		dead = false;
		hasBeenRevived = true;
		playfullness = 100;
		hunger = 100;
		tiredness = 100;
		toiletLevel = 100;
		health = 100;
		misbehaving = false;
		sickness = false;
		weight = species.getSpeciesWeight();
		JOptionPane.showMessageDialog(null, "Pet: "+getPetName()+" has been revived");
	}
	
	
	/**
	 * This Method Displays if a pet is dead or has died.
	 */
	public void isDead(){
		if(dead == false){
			if(health<=15){
				dead = true;
				JOptionPane.showMessageDialog(null, "Pet: "+getPetName()+" has died");
			}
		}
	}
	
	
	/**
	 * This Method Will determine if a pet is Misbehaving. There is a one in five chance of a pet starting to misbehave.
	 */
	public void rollMisbehavouring(){
		double randomNum = Math.round(Math.random()* 4);
		if(randomNum == 1){
			JOptionPane.showMessageDialog(null, "Pet: "+getPetName()+" has started misbehavouring");
			misbehaving = true;
		}
	}
	
	
	/**
	 * This Method Will determine if a pet is Feeling Sick. There is a one in five chance of a pet starting to feel Sick.
	 */
	public void rollSickness(){
		double randomNum = Math.round(Math.random()* 4);
		if(randomNum == 1){
			JOptionPane.showMessageDialog(null, "Pet: "+getPetName()+" has gotten sick");
			sickness = true;
		}
	}
	
	
	/**
	 * This Method is used at the end of a round to recalculate the status of a Pet Object.
	 * It also Calls necessary methods for the end turn phase.
	 */
	public void drainStats(){
		hunger = Math.round(hunger - 5.00*((weight/100.00)+1.00));
		playfullness = playfullness - 10;
		tiredness =  Math.round(tiredness - 10.00/((weight/100.00)+1.00));
		toiletLevel = toiletLevel - 10;
		if (hunger < 0){
			hunger = 0;
		}
		if (playfullness < 0){
			playfullness = 0;
		}
		if (tiredness < 0){
			tiredness = 0;
			
		}
		if (toiletLevel < 0){
			toiletLevel = 0;
		}
		//roll random events
		if (misbehaving == false){rollMisbehavouring();}
		if (sickness == false){rollSickness();}
		updateHealth();
		isDead();
	}

	
}

