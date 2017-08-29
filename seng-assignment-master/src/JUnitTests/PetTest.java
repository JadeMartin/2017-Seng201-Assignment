package JUnitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import FoodContainer.Burrito;
import FoodContainer.JellyMeat;
import Game.Pet;
import SpeciesContainer.Cat;
import ToyContainer.BigBall;
import ToyContainer.RedBall;

public class PetTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	static Pet pet;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		// default pet with species set as Cat
		pet = new Pet();
		pet.setPetSpecies(new Cat());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUpdateHealth() {
		// default playfulness = 100, tiredness = 100, toiletLevel = 100, hunger
		// == 100, sickness = false
		pet.updateHealth();
		assertEquals(pet.getPetHealth(), 100, 0);

		// default with sickness true
		pet.setPetSickness(true);
		pet.updateHealth();
		assertEquals(pet.getPetHealth(), 90, 0);

		// all attributes equal 0
		pet.setPetPlayfullness(0);
		pet.setPetTiredness(0);
		pet.setPetToiletLevel(0);
		pet.setPetHunger(0);
		pet.updateHealth();
		assertEquals(pet.getPetHealth(), 0, 0);
	}

	@Test
	public void testSleep() {
		// default tiredness = 100
		pet.sleep();
		assertEquals(pet.getPetTiredness(), 100, 0);

		// tiredness greater than 80 but less that 100
		pet.setPetTiredness(85);
		pet.sleep();
		assertEquals(pet.getPetTiredness(), 100, 0);

		// tiredness less that 80
		pet.setPetTiredness(50);
		pet.sleep();
		assertEquals(pet.getPetTiredness(), 70, 0);
	}

	@Test
	public void testBathroom() {
		// default toilet level = 100 and weight == 15
		pet.bathroom();
		assertEquals(pet.getPetToiletLevel(), 100, 0);
		assertEquals(pet.getPetWeight(), 14, 0);

		// toilet level < 80 weight = 0
		pet.setPetWeight((double) 0);
		pet.setPetToiletLevel(50);
		pet.bathroom();
		assertEquals(pet.getPetToiletLevel(), 70, 0);
		assertEquals(pet.getPetWeight(), 1, 0);
	}

	@Test
	public void testPlay() {
		// default playfullness = 100 without favourite toy
		pet.setPetFavouriteToy(new BigBall());
		pet.play(new RedBall());
		assertEquals(pet.getPetPlayfullness(), 100, 0);

		// default playfullness = 100 with favourite
		pet.setPetFavouriteToy(new BigBall());
		pet.play(new BigBall());
		assertEquals(pet.getPetPlayfullness(), 100, 0);

		// playfullness = 30 without favourite
		pet.setPetPlayfullness(30);
		pet.setPetFavouriteToy(new BigBall());
		pet.play(new RedBall());
		assertEquals(pet.getPetPlayfullness(), 45, 0);

		// playfullness = 30 with favourite
		pet.setPetPlayfullness(30);
		pet.setPetFavouriteToy(new BigBall());
		pet.play(new BigBall());
		assertEquals(pet.getPetPlayfullness(), 55, 0);
	}

	@Test
	public void testFeed() {
		// default hunger toilet level and weight without favourite food
		pet.setPetFavouriteFood(new JellyMeat());
		pet.feed(18, new Burrito());
		assertEquals(pet.getPetHunger(), 100, 0);
		assertEquals(pet.getPetToiletLevel(), 100 - (18 / 2), 0);
		assertEquals(pet.getPetWeight(), 16, 0);

		// default hunger toilet level and weight with favourite food
		pet.setPetToiletLevel(100);
		pet.setPetWeight((double) 15);
		pet.setPetFavouriteFood(new JellyMeat());
		pet.feed(10, new JellyMeat());
		assertEquals(pet.getPetHunger(), 100, 0);
		assertEquals(pet.getPetToiletLevel(), 100 - (10 / 2), 0);
		assertEquals(pet.getPetWeight(), 16, 0);

		// hunger = 50, toilet level = 50 and weight = 50 without favourite
		pet.setPetHunger(50);
		pet.setPetToiletLevel(50);
		pet.setPetWeight((double) 50);
		pet.feed(18, new Burrito());
		assertEquals(pet.getPetHunger(), 50 + 18, 0);
		assertEquals(pet.getPetToiletLevel(), 50 - (18 / 2), 0);
		assertEquals(pet.getPetWeight(), 53, 0);

		// hunger = 50, toilet level = 50 and weight = 50 with favourite
		pet.setPetHunger(50);
		pet.setPetToiletLevel(50);
		pet.setPetWeight((double) 50);
		pet.feed(10, new JellyMeat());
		assertEquals(pet.getPetHunger(), 50 + 20, 0);
		assertEquals(pet.getPetToiletLevel(), 50 - (10 / 2), 0);
		assertEquals(pet.getPetWeight(), 53, 0);

		// hunger = 0, toilet level = 0 and weight = 0.1 without favourite
		pet.setPetHunger(0);
		pet.setPetToiletLevel(0);
		pet.setPetWeight((double) 0.1);
		pet.feed(18, new Burrito());
		assertEquals(pet.getPetHunger(), 0 + 18, 0);
		assertEquals(pet.getPetToiletLevel(), 0, 0);
		assertEquals(pet.getPetWeight(), 1, 0);

		// hunger = 0, toilet level = 0 and weight = 0.1 with favourite
		pet.setPetHunger(0);
		pet.setPetToiletLevel(0);
		pet.setPetWeight((double) 0.1);
		pet.feed(10, new JellyMeat());
		assertEquals(pet.getPetHunger(), 0 + 20, 0);
		assertEquals(pet.getPetToiletLevel(), 0, 0);
		assertEquals(pet.getPetWeight(), 1, 0);
	}
	
	@Test
	public void testRevivePet(){
		pet.revivePet();
		assertEquals(pet.getPetDead(), false);
		assertEquals(pet.getRevived(), true);
	}
	
	@Test
	public void testIsDead(){
		//below boundary
		pet.setPetHealth((double) 15);
		pet.isDead();
		assertEquals(pet.getPetDead(), true);
		
		//above boundary
		pet.setPetDead(false);
		pet.setPetHealth((double) 16);
		pet.isDead();
		assertEquals(pet.getPetDead(), false);
	}
	
	@Test
	public void testDrainStats(){
		//default values hunger = 100, playfullness = 100, tiredness = 100, toiletLevel = 100
		pet.drainStats();
		assertEquals(pet.getPetPlayfullness(), 90, 0);
		assertEquals(pet.getPetTiredness(), 91, 0);
		assertEquals(pet.getPetToiletLevel(), 90, 0);
		
		//hunger = 0,playfullness = 0, tiredness = 0, toiletLevel = 0
		pet.setPetHunger(0);
		pet.setPetPlayfullness(0);
		pet.setPetTiredness(0);
		pet.setPetToiletLevel(0);
		pet.drainStats();
		assertEquals(pet.getPetHunger(), 0, 0);
		assertEquals(pet.getPetPlayfullness(), 0, 0);
		assertEquals(pet.getPetTiredness(), 0, 0);
		assertEquals(pet.getPetToiletLevel(), 0, 0);
	}
}
