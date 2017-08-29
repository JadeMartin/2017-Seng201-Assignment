package Game;
/**
 * The Toys Class is for initializing Toy objects and their attributes.
 * <p>
 * Toys are used to play with a pet. Different type of toys exist the toys can vary in durability and price therefore
 * this class is needed to create multiple types of toys.
 * the Toy class is also an abstract class
 * @author Jade Martin
 * @author Kyran Stagg
 *
 */
public abstract class Toys {
	/**
	 * Represents the toys price.
	 */
	private Double price;
	/**
	 * Represents the toys name.
	 */
	private String name;
	/**
	 * Represents the toys durability.
	 */
	private Double durability;
	
	/**
	 * This method is used to return the toys price.
	 * @return Double This returns the toy price
	 */
	public Double getToyPrice(){
		return price;
		}
	/**
	 * This method is used to set and update the toys price.
	 * @param toyPriceInput This is the inputed price and is used as the new price for the toy.
	 */
	public void setToyPrice(Double toyPriceInput){
		price = toyPriceInput;
	}
	
	/**
	 * This method is used to return the toys name.
	 * @return String This returns the current toys name
	 */
	public String getToyName(){
		return name;
	}
	
	/**
	 * This method is used to set and update the toys name.
	 * @param toyNameInput This is the inputed name and is used as the new name for the toy.
	 */
	public void setToyName(String toyNameInput){
		name = toyNameInput;
	}
	
	/**
	 * This method is used to return the toys durability.
	 * @return Double This returns the toy durability
	 */
	public Double getToyDurability(){
		return durability;
	}
	
	/**
	 * This method is used to update the toys durability as the more it is played with the less durability the toy will have
	 * @param petDamage The pet that is playing with damage which determines how much durability will be lost.
	 */
	public void removeToyDurability(Double petDamage){
		if(petDamage > durability){
			durability = 0.00;
		}else{
		durability = durability - petDamage;
		}
	}
	
	/**
	 * This method is used to set and update the toys durability.
	 * @param toyDurabilityInput This is the inputed durability and is used as the new durability for the toy.
	 */
	public void setToyDurability(Double toyDurabilityInput){
		durability = toyDurabilityInput;
	}
}