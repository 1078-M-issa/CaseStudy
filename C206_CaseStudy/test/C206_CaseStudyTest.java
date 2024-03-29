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
	private Ingredients ingredient1;
	private Ingredients ingredient2;
	private Ingredients ingredient3;
	private Ingredients ingredient4;
	private Promotions promotion1;
	private Promotions promotion2;


	private ArrayList<Stall> Stalllist;
	private ArrayList<Menu> menuList;
	private ArrayList<Ingredients> ingredients;
	private ArrayList<Promotions> promotionList;
	private ArrayList<ArrayList> orderlist;

	@Before
	public void setUp() throws Exception {

		S1 = new Stall(1, "The Noodle Bowl", "Noodles", "15th June 2018");
		S2 = new Stall(2, "Outback Grills", "Westerns", "25th July 2021");


		food1 = new Menu(1, "Mee Pok", 4);
		food2 = new Menu(2, "Beef Steak", 17);

		ingredient1 = new Ingredients(1,"Apple",10);
		ingredient2 = new Ingredients(1,"Orangee",10);
		ingredient3 = new Ingredients(2,"Potato",15);
		ingredient4 = new Ingredients(2,"Beef",15);

		Stalllist = new ArrayList<Stall>();
		menuList = new ArrayList<Menu>();
		ingredients = new ArrayList<Ingredients>();
		promotionList = new ArrayList<Promotions>();
		orderlist = new ArrayList<ArrayList>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void Test_for_Stall_Add() {

		//test for view list (issa)
		//Test if Stall list exist; 
		assertNotNull("Test if there is valid Stall arraylist to add to", Stalllist);

		// Given an empty list, after adding 1 item, the size of the list is 1
		Stalllist.add(S1);
		assertEquals("Test if that stall arraylist size is 1?", 1, Stalllist.size());

		// The item just added is as same as the first item of the list
		assertSame("Test that Stall is added same as 1st item of the list?", S1, Stalllist.get(0));

		//test that stall details can be retrieve properly;
		assertNotNull(Stalllist.get(0).getStall_name());
		assertNotNull(Stalllist.get(0).getDate());

		//test for the system to remove/reject insertion past the 10th index
		Stalllist.add(S2);

		int newid = Helper.readInt("Enter in stall slot > ");
		newid = C206_CaseStudy.newStallSlotChecker(newid);
		C206_CaseStudy.addStall(Stalllist, newid);
	}

	@Test
	public void Test_for_View() {

		//(issa)

		Stalllist.add(S1);
		Stalllist.add(S2);
		//test if stallist if not empty;
		assertNotNull(Stalllist.get(1));
		assertNotNull(Stalllist.get(0));


		C206_CaseStudy.menu(1, Stalllist);

		Helper.line(80, "-");



	}//issa
	@Test
	public void test_for_delete() {

		Stalllist.add(S1);
		Stalllist.add(S2);
		//test if index 1 (post 2) has an object in stall list;
		assertNotNull(Stalllist.get(1));

		//test if object has been deleted
		Stall test = new Stall(1, "The Noodle Bowl", "Noodles", "15th June 2018");
		C206_CaseStudy.deleteStall(Stalllist, 0);
		assertNotSame(Stalllist.get(0), test);

	}

	//Paulo
	@Test
	public void test_addMenu() {

		assertNotNull("test if there is a valid Stallmenu arraylist to add food item to", menuList);
		C206_CaseStudy.addMenu(menuList, food1);
		assertEquals("test if the menuList arraylist size is 1?", 1, menuList.size());

		assertSame("test if food item is added same as the first item in the arraylist?", food1 , menuList.get(0));

		C206_CaseStudy.addMenu(menuList, food2);
		assertEquals("Test that the arraylist menu size is 2?", 2, menuList.size());
		assertSame("test that food item is added same as the second item of the list?", food2, menuList.get(1));
	}


	//Paulo
	@Test
	public void test_getAllMenu() {
		assertNotNull("Test if there is a menuList arraylist to add into", menuList);
		String allMenus = C206_CaseStudy.getAllMenu(menuList);
		String testOutput="";
		assertEquals("Check that ViewAllMenuList", testOutput, allMenus);

		C206_CaseStudy.addMenu(menuList, food1);
		C206_CaseStudy.addMenu(menuList, food2);

		assertEquals("test if that the arraylist size of Menu is 2?", 2, menuList.size());

		allMenus = C206_CaseStudy.getAllMenu(menuList);

		testOutput = String.format("%-10d %-30s %-10.2f\n", 1, "Mee Pok", 4.00);
		testOutput += String.format("%-10d %-30s %-10.2f\n", 2, "Beef Steak", 17.00);

		assertEquals("Check that viewAllMenuList", testOutput, allMenus);
	}

	//Paulo
	@Test
	public void test_deleteFood() {
		assertNotNull("test if there is a valid MenuList arraylist to add food item into", menuList);
		String allMenus = C206_CaseStudy.getAllMenu(menuList);
		String testOutput="";
		assertEquals("Check that viewAllmenuList", testOutput, allMenus);
		C206_CaseStudy.addMenu(menuList, food1);
		C206_CaseStudy.addMenu(menuList, food2);

		assertEquals("test if that the size of the food item menu is 2", 2, menuList.size());

		C206_CaseStudy.deleteFood(menuList, food1.getStall_id());
		assertEquals("Test if that Menu arraylist size is 1?", 1, menuList.size());
		C206_CaseStudy.getAllMenu(menuList);

		String actOutput = String.format("%-10d %-30s %-10.2f\n", menuList.get(0).getStall_id(), menuList.get(0).getfoodName(), menuList.get(0).getPrice());
		testOutput = String.format("%-10d %-30s %-10.2f\n", 1, "Mee Pok", 4.00);

		assertEquals("check if viewAllmenuList", testOutput, actOutput);

	}
	//Jennifer
	@Test
	public void test_addPromotions() {
		Stalllist.add(S1);
		Stalllist.add(S2);

		C206_CaseStudy.addMenu(menuList, food1);
		C206_CaseStudy.addMenu(menuList, food2);

		assertNotNull("test if there is a valid Promotion arraylist to add promotion item to", promotionList);
		C206_CaseStudy.addPromotions(menuList, promotionList, 0);
		assertEquals("test if the menuList promotionlist size is 1?", 1, promotionList.size());

		promotion1 = promotionList.get(0);

		assertSame("test if daily promotion added is the same as the first item in the arraylist?", promotion1 , promotionList.get(0));

	}
	//Jennifer
	@Test
	public void test_viewPromotions() {

		Stalllist.add(S1);
		Stalllist.add(S2);

		C206_CaseStudy.addMenu(menuList, food1);
		C206_CaseStudy.addMenu(menuList, food2);

		promotion1 = new Promotions(1, "Beef Steaks", 17, 15);
		promotionList.add(promotion1);

		C206_CaseStudy.viewPromotion(Stalllist, promotionList, 1);


	}
	//Jennifer
	@Test
	public void test_deletePromotions() {

		Stalllist.add(S1);
		Stalllist.add(S2);

		C206_CaseStudy.addMenu(menuList, food1);
		C206_CaseStudy.addMenu(menuList, food2);

		promotion1 = new Promotions(1, "Beef Steaks", 17, 15);
		promotionList.add(promotion1);

		C206_CaseStudy.deletePromotions(promotionList, 1);;

	}
	//Celest
	@Test
	public void test_addIngredient() {
		assertNotNull("test if there is a valid ingredient list to add ingredient to", ingredients);

		Ingredients object = C206_CaseStudy.addIngredient(1);
		ingredients.add(object);

		assertEquals("test if the ingredient list size is 1", 1, ingredients.size());

		assertSame("test if ingredient added is the same as the first item in the list", ingredients.get(0), object);

		Ingredients object2 = C206_CaseStudy.addIngredient(1);
		ingredients.add(object2);

		assertEquals("Test if the ingredient list size is 2", 2, ingredients.size());
		assertSame("test if ingredient added is the same as the second item of the list", object2, ingredients.get(1));
	} 
	//Celest
	@Test
	public void test_ViewList() {

		ingredients.add(ingredient1);
		ingredients.add(ingredient2);

		assertNotNull(ingredients.get(0));
		assertNotNull(ingredients.get(1));

		String output=String.format("%-10s %-30s %-30s\n","ID", "INGREDIENT NAME", "QUANTITY");
		output = C206_CaseStudy.viewOrderList(output, 1, ingredients);
		System.out.println(output);

	}
	//Celest
	@Test
	public void test_deleteList() {

		ingredients.add(ingredient1);
		ingredients.add(ingredient2);

		assertNotNull(ingredients.get(0));
		assertNotNull(ingredients.get(1));

		orderlist.add(ingredients);

		assertNotNull(orderlist.get(0));

		C206_CaseStudy.deleteList(orderlist, 1);

		assertEquals(orderlist.get(0).size(), 0);

	}

}
