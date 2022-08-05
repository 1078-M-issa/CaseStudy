import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	//prepping test data.
	private Stall S1;
	private Stall S2;


	private ArrayList<Stall> Stalllist;

	@Before
	public void setUp() throws Exception {

		S1 = new Stall(1, "The Noodle Bowl", "Noodles");
		S2 = new Stall(2, "Outback Grills", "Westerns");

		Stalllist = new ArrayList<Stall>();

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void c206_test() {
		
		//test for view list (issa)
		//Test if Stall list exist; 
		assertNotNull("Test if there is valid Stall arraylist to add to", Stalllist);

		// Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addStall(Stalllist, S1);
		assertEquals("Test if that Camcorder arraylist size is 1?", 1, Stalllist.size());

		// The item just added is as same as the first item of the list
		assertSame("Test that Camcorder is added same as 1st item of the list?", S1, Stalllist.get(0));		
		
	}

}
