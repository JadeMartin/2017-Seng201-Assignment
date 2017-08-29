 package JUnitTests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import FoodContainer.Steak;
import Game.Food;


public class FoodTest {
	@Rule 
	public ExpectedException thrown = ExpectedException.none();
	static Food food;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		food = new Steak();
		//big ball name = Big Blue Ball, durability = 100.00, cost = 10.00
	}

	@Test
	public void testGetterAndSetters() {
		assertEquals(food.getFoodName(), "Steak");
		assertEquals(food.getFoodPrice(), 35.00, 0);
		assertEquals(food.getNutritionValue(), 35, 0);
		food.setFoodName("Pasta");
		assertEquals(food.getFoodName(), "Pasta");
		food.setFoodPrice(5.00);
		assertEquals(food.getFoodPrice(), 5.00, 0);
		food.setNutritionValue(7);
		assertEquals(food.getNutritionValue(), 7, 0);
	}
}
