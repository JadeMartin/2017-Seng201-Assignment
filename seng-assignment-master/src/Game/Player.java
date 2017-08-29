package Game;
import java.util.ArrayList;
/**
 * The Player Class is for initializing the Player class and its objects it is also used to store the players pets and their food and toys.
 * <p>
 * this class is needed to create multiple Players.
 * the Player class store a lot of information about the player each player can be very different
 * the important information can include playerInventoryToys which keeps track of the current players toys and also 
 * playerInventoryFood which keeps track of the current players food theses together represent the players inventory.
 * There is also a list of pets called pets this represents all of the pets that the current play owns and stores the information of each pet.
 * @author Jade Martin
 * @author Kyran Stagg
 */
public class Player {
	/**
	 * Represents the Player Name.
	 */
	private String name;
	/**
	 * Represents the Players pets and is a list of Pet each object in the list is a pet object.
	 */
	private ArrayList<Pet> pets = new ArrayList<Pet>();
	/**
	 * Represents the Players toys and is a list of Toys each object in the list is a toy object.
	 */
	private ArrayList<Toys> playerInventoryToys = new ArrayList<Toys>();
	/**
	 * Represents the Players foods and is a list of Food each object in the list is a food object.
	 */
	private ArrayList<Food> playerInventoryFood = new ArrayList<Food>();
	/**
	 * Represents the Players current balance.
	 */
	private Double balance = 100.00;
	/**
	 * Represents the Players current score.
	 */
	private Double playerScore = 0.00;
	/**
	 * This method is used to return the players name.
	 * @return String This returns the players name.
	 */
	public String getPlayerName(){
		return name;
	}
	/**
	 * This method is used to set and update the players name.
	 * @param playerNameInput This is the inputed player name and is used as the new/updated player name.
	 */
	public void setPlayerName(String playerNameInput){
		name = playerNameInput;
	}
	/**
	 * This method is used to return a list of the current players pets.
	 * @return ArrayList<Pet> This returns a list of players pets.
	 */
	public ArrayList<Pet> getPlayerPets(){
		return pets;
	}
	/**
	 * This method is used to add a pet into the players pet list.
	 * @param playerPetsInput This is the inputed player pet and is added to the pets list.
	 */
	public void setPlayerPets(Pet playerPetsInput){
		pets.add(playerPetsInput);
	}
	/**
	 * This method is used to return a list of the current players toys.
	 * @return ArrayList<Toys> This returns a list of the players toys.
	 */
	public ArrayList<Toys> getPlayerToys(){
		return playerInventoryToys;
	}	
	/**
	 * This method is used to add a toy into the players toy list and into his inventory.
	 * @param playerToysInput This is the inputed toy which is then added into the players list of toys.
	 */
	public void setPlayerToys(Toys playerToysInput){
		playerInventoryToys.add(playerToysInput);
	}
	/**
	 * This method is used to return a list of the current players foods.
	 * @return ArrayList<Food> This returns a list of the players food.
	 */
	public ArrayList<Food> getPlayerFood(){
		return playerInventoryFood;
	}	
	/**
	 * This method is used to add a food into the players food list and into his inventory
	 * @param playerFoodInput This is the inputed food which is then added into the players list of food.
	 */
	public void setPlayerFood(Food playerFoodInput){
		playerInventoryFood.add(playerFoodInput);
	}
	/**
	 * This method is used to return the players current balance
	 * @return Double This returns the current balance of the player
	 */
	public Double getPlayerBalance(){
		return balance;
	}
	/**
	 * This method is used to update the players current balance it adds the input on top of the players balance.
	 * For example if balance was $10 and input was $5 then balance becomes $15. 
	 * @param playerBalanceInput This is the inputed balance which is then added together with the player balance to become the updated balance.
	 */
	public void setPlayerBalance(Double playerBalanceInput){
		balance = balance + playerBalanceInput;
		balance = (double) Math.round(balance);
	}
	/**
	 * This method is used to update the players current balance it removes the input from the players balance.
	 * For example if balance was $10 and input was $5 then balance becomes $5. 
	 * @param playerBalanceInput This is the inputed balance which is then removed from the player balance to become the updated balance.
	 */
	public void setNegativePlayerBalance(Double playerBalanceInput){
		balance = balance - playerBalanceInput;
		balance = (double) Math.round(balance);
	}
	/**
	 * This method is used to return the players current score.
	 * @return Double This returns the current score of the player.
	 */
	public Double getPlayerScore(){
		return playerScore;
	}
	/**
	 * This method is used to update the players current score it adds the input on to the current players score.
	 * For example if the players score was 100 and input was 50 then the score will become 150. 
	 * @param playerScoreInput This is the inputed score which is then added together with the player score to become the updated player score.
	 */
	public void setPlayerScore(Double playerScoreInput){
		playerScore = playerScore + playerScoreInput;
	}
	/**
	 * This method is used to update the players list of toys it removes the input from the players toy list.
	 * For example if the player had a red ball and a long rope and the input is a red ball 
	 * then it would remove it from the toy list and then the players toys would only be long rope.
	 * @param playerBalanceInput This is the inputed toy which is then removed from the players toy list to become the updated toy list.
	 */
	public void removeInventoryToy(Toys removeToy){
		playerInventoryToys.remove(removeToy); 
	}
	/**
	 * This method is used to update the players list of food it removes the input from the players food list.
	 * For example if the player had a steak and a burrito and the input is a burrito 
	 * then it would remove it from the food list and then the players food would only be a steak.
	 * @param removeFood This is the inputed food which is then removed from the players food list to become the updated food list.
	 */
	public void removeInventoryFood(Food removeFood){
		playerInventoryFood.remove(removeFood);
	}

}
