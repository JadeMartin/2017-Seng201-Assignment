package JUnitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import FoodContainer.Grapes;
import FoodContainer.Steak;
import Game.Food;
import Game.Pet;
import Game.Player;
import Game.Toys;
import SpeciesContainer.Sloth;
import ToyContainer.BigBall;
import ToyContainer.ShortRope;

public class PlayerTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	static Player player;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
		player = new Player();
	}

	@Test
	public void balanceTest() {
		// test balance do not need to check negative starts at 100
		assertEquals(player.getPlayerBalance(), 100.00, 0);
		player.setPlayerBalance(0.00);
		assertEquals(player.getPlayerBalance(), 100.00, 0);
		player.setPlayerBalance(5.00);
		assertEquals(player.getPlayerBalance(), 105.00, 0);
		player.setPlayerBalance(105.00);
		assertEquals(player.getPlayerBalance(), 210.00, 0);
	}
   @Test
   public void negativeBalanceTest(){
	   //there is a check so it can not be an input with higher than the balance at any time but that is in the store
	   assertEquals(player.getPlayerBalance(), 100.00, 0);
	   player.setNegativePlayerBalance(100.00);
	   assertEquals(player.getPlayerBalance(), 0, 0);
	   player.setPlayerBalance(100.00);
	   player.setNegativePlayerBalance(0.00);
	   assertEquals(player.getPlayerBalance(), 100.00, 0);
	   player.setNegativePlayerBalance(5.00);
	   assertEquals(player.getPlayerBalance(), 95.00, 0);
   }
   @Test
   public void scoreTest() { 
		//test balance do not need to check negative
		assertEquals(player.getPlayerScore(), 0.00, 0);
		player.setPlayerScore(100.00);
		assertEquals(player.getPlayerScore(), 100.00, 0);
		player.setPlayerScore(0.00);
		assertEquals(player.getPlayerScore(), 100.00, 0);
		player.setPlayerScore(5.00);
		assertEquals(player.getPlayerScore(), 105.00, 0);
		player.setPlayerScore(105.00);
		assertEquals(player.getPlayerScore(), 210.00, 0);
	}
   @Test
   public void addAndRemoveToys(){
	   //remove never called on a empty list because is always called when a toy breaks and never called on a toy that is not in the list
	   ArrayList<Toys> playerInventoryToys = new ArrayList<Toys>();
	   Toys shortRope = new ShortRope();
	   Toys bigBall = new BigBall();
	   playerInventoryToys.add(shortRope);
	   assertEquals(player.getPlayerToys().size(), 0);
	   player.setPlayerToys(bigBall);
	   player.setPlayerToys(shortRope);
	   player.removeInventoryToy(bigBall);
	   assertEquals(playerInventoryToys, player.getPlayerToys());
	   player.removeInventoryToy(shortRope);
	   assertEquals(player.getPlayerToys().size(), 0);
	   }
   @Test
   public void addAndRemoveFood(){
	   //remove never called on a empty list because is always called when a toy breaks and never called on a toy that is not in the list
	   ArrayList<Food> playerInventoryfood = new ArrayList<Food>();
	   Food grapes = new Grapes();
	   Food steak = new Steak();
	   playerInventoryfood.add(grapes);
	   assertEquals(player.getPlayerFood().size(), 0);
	   player.setPlayerFood(steak);
	   player.setPlayerFood(grapes);
	   player.removeInventoryFood(steak);
	   assertEquals(playerInventoryfood, player.getPlayerFood());
	   player.removeInventoryFood(grapes);
	   assertEquals(player.getPlayerFood().size(), 0);
	   }
   @Test
   public void addPets(){
	  //cant remove pets not needed in program possible in future versions
	  assertEquals(player.getPlayerPets().size(), 0);
	  Pet pet = new Pet();
	  pet.setPetSpecies(new Sloth());
	  player.setPlayerPets(pet);
	  ArrayList<Pet> playerPets = new ArrayList<Pet>();
	  playerPets.add(pet);
	  assertEquals(playerPets, player.getPlayerPets());
   }
}
