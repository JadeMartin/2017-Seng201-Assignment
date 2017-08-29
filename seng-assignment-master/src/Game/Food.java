package Game;
/**
 * The Food Class is for initializing Food objects and their attributes.
 * <p>
 * Food is used to feed a pet. Different type of food exist therefore
 * this class is needed to create multiple types of food.
 * The Food class is also an abstract class.
 * @author Jade Martin
 * @author Kyran Stagg
 *
 */
public abstract class Food {
	/**
	 * Represents the Food Name.
	 */
	private String name;
	/**
	 * Represents the Food Price.
	 */
	private Double price;
	/**
	 * Represents the Food Nutrition Value.
	 */
	private Integer nutritionValue;
	
	/**
	 * This Method is used to get a foods name.
	 * @return String Returns the Name of a Food.
	 */
	public String getFoodName(){
		return name;
		}
	
	
	
	/**
	 * This Method is used to set a foods name or change its name.
	 * @param foodNameInput Name to be used with food object specified
	 */
	public void setFoodName(String foodNameInput){
		name = foodNameInput;
	}
	
	
	
	/**
	 * This Method is used to get a foods price.
	 * @return Double Returns the Price of the food.
	 */
	public Double getFoodPrice(){
		return price;
		}
	
	
	
	/**
	 * This Method is used to set a foods price or change its price.
	 * @param foodPriceInput Price to be used with food object specified.
	 */
	public void setFoodPrice(Double foodPriceInput){
		price = foodPriceInput;
	}
	
	
	
	/**
	 * This Method is used to get a foods Nutrition Value.
	 * @return Integer Returns the Nutrition Value of the food.
	 */
	public Integer getNutritionValue(){
		return nutritionValue;
		}
	
	
	
	/**
	 * This Method is used to set a foods Nutrition Value or change its Nutrition Value.
	 * @param foodNutritionValue Nutrition Value to be used with food object specified.
	 */
	public void setNutritionValue(Integer foodNutritionValue){
		nutritionValue = foodNutritionValue;
	}
}