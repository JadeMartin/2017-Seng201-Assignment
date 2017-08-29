package JUnitTests;

import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import Game.Toys;
import ToyContainer.BigBall;

public class ToysTest {
	@Rule 
	public ExpectedException thrown = ExpectedException.none();
	static Toys toy;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		toy  = new BigBall();
		//big ball name = Big Blue Ball, durability = 100.00, cost = 10.00
	}

	@Test
	public void testRemoveDurability() {
		toy.removeToyDurability(5.00);
		assertEquals(toy.getToyDurability(), 95, 0 );
		toy.removeToyDurability(95.00);
		assertEquals(toy.getToyDurability(), 0, 0 );
		toy.removeToyDurability(150.00);
		assertEquals(toy.getToyDurability(), 0, 0 );
	}

}
