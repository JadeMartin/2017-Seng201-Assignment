package JUnitTests;

import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import SpeciesContainer.Cat;


public class SpeciesTest {
	@Rule 
	public ExpectedException thrown = ExpectedException.none();
	static Cat species;
	
	@BeforeClass
	static public void setUpBeforeClass() throws Exception {
		species = new Cat();
	}

	@Test
	public void testGetSpeciesName() {
		assertEquals(species.getSpeciesWeight(), 15.00, 0); 
	}

}
