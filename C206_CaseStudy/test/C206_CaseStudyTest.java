import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	//prepping test data.
	private Stall S1;
	private Stall S2;
	private Menu food1;
	private Menu food2;


	private ArrayList<Stall> Stalllist;
	private ArrayList<Menu> menuList;

	@Before
	public void setUp() throws Exception {

		S1 = new Stall(1, "The Noodle Bowl", "Noodles", "15th June 2018");
		S2 = new Stall(2, "Outback Grills", "Westerns", "25th July 2021");
		
		food1 = new Menu(1, "Mee Pok", 4);
		food2 = new Menu(2, "Beef Steak", 17);

		Stalllist = new ArrayList<Stall>();
		menuList = new ArrayList<Menu>();

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void Test_for_Stall_List() {
		
		//test for view list (issa)
		//Test if Stall list exist; 
		assertNotNull("Test if there is valid Stall arraylist to add to", Stalllist);

		// Given an empty list, after adding 1 item, the size of the list is 1
		Stalllist.add(S1);
		assertEquals("Test if that stall arraylist size is 1?", 1, Stalllist.size());

		// The item just added is as same as the first item of the list
		assertSame("Test that Stall is added same as 1st item of the list?", S1, Stalllist.get(0));
		
		//test if boundary set to 10 or less;
		assert(Stalllist.size() < 10);
		
		//test that stall details can be retrieve properly;
		assertNotNull(Stalllist.get(0).getStall_name());
		assertNotNull(Stalllist.get(0).getDate());
		
		
		
	}
	
	public void Test_for_edit() {
		Stalllist.add(S2);
		//test if index 1 (post 2) has an object in stall list;
		assertNotNull(Stalllist.get(1));
		
		
		
		
	}
	
	public void test_for_delete() {
		
	}

}
