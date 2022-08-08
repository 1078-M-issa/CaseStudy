import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class C206_CaseStudy {

	public static void main(String[] args) {


		ArrayList<Stall> Stalllist = new ArrayList<Stall>();
		ArrayList<Menu> Stallmenu = new ArrayList<Menu>();
		ArrayList<Ingredients> ingredients = new ArrayList<Ingredients>();
		ArrayList<ArrayList> ListofOrders = new ArrayList<ArrayList>();

		Stalllist.add(new Stall(1,"The Juicer","Drinks", "15th Sept 2020"));
		Stalllist.add(new Stall(2,"Outback Grill","Western", "24th Sept 2019"));
		Stallmenu.add(new Menu(1,"Apple Juice", 2.00));
		Stallmenu.add(new Menu(1,"Orange Juice", 1.50));
		Stallmenu.add(new Menu(2,"Fries", 3));
		Stallmenu.add(new Menu(2,"Lamb chop", 7.50));
		ingredients.add(new Ingredients(1,"Apple",15));
		ingredients.add(new Ingredients(1,"Orange",10));
		ingredients.add(new Ingredients(2,"Potato",20));
		ingredients.add(new Ingredients(2,"Lamb meat",10));

		int choice = 1;

		System.out.println("1 - Admin");
		System.out.println("2 - Stall Ops");
		int Role = Helper.readInt(" Welcome ");

		//Role: Admin
		if (Role == 1) {
			while (choice != 0) {
				C206_CaseStudy.menu(Role,Stalllist);
				choice = Helper.readInt("Enter an option > ");
				//admin (paulo) view Stall choice
				if (choice == 1) {
					choice = Helper.readInt("Enter Stall to view > ");
					for (int i = 0; i<Stallmenu.size(); i++) {
						if(Stallmenu.get(i).getStall_id() == choice) {
							System.out.println(Stallmenu.get(i).getfoodName() + " - " + Stallmenu.get(i).getPrice());
						}
					}
					System.out.println("\n");
					Helper.line(80, "-");
					System.out.println("What would you like to do? \n");
					System.out.println("1 - Add food item to menu");
					System.out.println("2 - View food menu item");
					System.out.println("3 - Delete food item from menu");

					choice = Helper.readInt("Choose option > ");
					if (choice == 1) {
						Menu food1 = inputMenu();
						C206_CaseStudy.addMenu(Stallmenu, food1);
						System.out.println("Food item added");
					} else if (choice == 2) {
						C206_CaseStudy.viewAllMenu(Stallmenu);

					} else if (choice == 3) {
						int foodId = Helper.readInt("Enter Food id > ");
						for (int i = 0; i<Stallmenu.size(); i++) {
							if(Stallmenu.get(i).getStall_id() == foodId) {
								C206_CaseStudy.deleteFood(Stallmenu, foodId);	
							}
						} System.out.println("Food item deleted");
					}	

					//admin edit stall choice
				} else if (choice == 2) {
					C206_CaseStudy.setHeader("Edit stall");
					choice = Helper.readInt("Enter which stall to edit > ");
					for (int i = 0; i<Stalllist.size(); i++) {
						if ((i + 1) == choice) {
							String NewName = Helper.readString("Enter new stall name >  ");
							String NewCat = Helper.readString("Enter new stall Cat >  ");
							String OpDate = Helper.readString("Enter operating date >");
							Stalllist.get(i).setStall_name(NewName);
							Stalllist.get(i).setCategory(NewCat);
							Stalllist.get(i).setDate(OpDate);
						}

					}
					Helper.line(80, "-");
				} else if (choice == 3) {
					C206_CaseStudy.setHeader("Delete stall");
					choice = Helper.readInt("Enter which stall to delete > ");
					for (int i = 0; i<Stalllist.size(); i++) {
						if ((i + 1) == choice) {
							Stalllist.remove(Stalllist.get(i));
						}
					}
					Helper.line(80, "-");
				} else if (choice == 4) {
					C206_CaseStudy.setHeader("Add a new stall");
					for (int i = 0; i < 10 ; i++) {
						if (Stalllist.size() > i) {
							System.out.println((i + 1) + " " + Stalllist.get(i).getStall_name()); 
						} else {
							System.out.println((i + 1) + " Empty Stallslot"); 
						}
					}
					Helper.line(80, "-");
					int newid = Helper.readInt("Enter in stall slot > ");
					String NewName = Helper.readString("Enter new stall name >  ");
					String NewCat = Helper.readString("Enter new stall Cat >  ");
					String OpDate = Helper.readString("Enter operating date >");
					Stalllist.add(new Stall(newid,NewName, NewCat,OpDate ));
				}
			}
			//Celest & Jennifer Programme code 4 Stall operator
		} else if (Role == 2) {
			C206_CaseStudy.menu(Role,Stalllist);
			int Stallslot = Helper.readInt("Enter stall > ");
			if (choice!=0) {
				System.out.println("\n");
				C206_CaseStudy.setHeader(Stalllist.get(Stallslot - 1).getStall_name());
				System.out.println("What would you like to do? \n");
				System.out.println("1 - View Promotions");
				System.out.println("2 - View Ingredient Order List\n");	

				choice=Helper.readInt("Enter option > ");


				//jennifer 
				if (choice == 1) {

					
					//------------------------------------------------------------------------------------------------------
				} // celest;
				else if (choice == 2) {
					System.out.println("\n");
					Helper.line(80, "-");
					System.out.println("What would you like to do? \n");
					System.out.println("1 - Add ingredients to order list");
					System.out.println("2 - View ingredients in order list");
					System.out.println("3 - Remove ingredients in order list");

					choice = Helper.readInt("Choose option > ");
					//Add
					if (choice==1) {
						C206_CaseStudy.addIngredient();
						System.out.println("Ingredient added");
					//View
					} else if (choice==2) {
						String output="";
						output=String.format("%-10s %-30s %-30s\n","STORE ID", "INGREDIENT NAME", "QUANTITY");
						for (int i = 0; i < ingredients.size(); i++) {
							if (ingredients.get(i).getStall_id()==Stallslot) {
								output += String.format("%-10d %-30s %-10d\n",ingredients.get(i).getStall_id(),ingredients.get(i).getIngredient_name(), ingredients.get(i).getQuantity());
							} 
						}System.out.println(output);
					//Delete
					} else if (choice==3) {
						int ingredientId = Helper.readInt("Enter Ingredient ID > ");
						for (int i = 0; i<ingredients.size(); i++) {
							if(ingredients.get(i).getStall_id() == ingredientId) {
								C206_CaseStudy.deleteIngredient(ingredients, ingredientId);
								System.out.println("Ingredient deleted");
							}
						} 
					} else {
						System.out.println("Invalid option");
					}
				}//-------------------------------------------------------------------------------------------------
			}
		}


		// Methods for Casestudy;
	}
	//print Mainmenu
	public static void menu(int role,ArrayList<Stall> AL) {
		C206_CaseStudy.setHeader("CANTEEN AUTOMATIC SYSTEM");
		//view for admin;
		if (role == 1) {
			System.out.println("Hello Admin \nList of Stalls\n ");
			for (int i = 0; i < AL.size(); i++) {
				System.out.println( (i + 1) + " - " +  AL.get(i).getStall_name() + " Operated since: " + AL.get(i).getDate());
			}
			System.out.println("\n");
			Helper.line(80, "-");
			System.out.println("What would you like to do? \n");
			System.out.println("1 - View Stall");
			System.out.println("2 - Edit Stall");
			System.out.println("3 - Delete Stall");
			System.out.println("4 - Add Stall");

			//Celest & Jennifer Main Menu 4 Stall operator;
		} else if (role == 2) {

			System.out.println("Hello Stall ops \nList of Stalls\n ");
			for (int i = 0; i < AL.size(); i++) {
				System.out.println( (i + 1) + " - " +  AL.get(i).getStall_name() + " Operated since: " + AL.get(i).getDate());
			}
			System.out.println("\n");
			Helper.line(80, "-");
			System.out.println(" Enter your stall slot \n");

		} else {
			for (int i = 0; i < AL.size(); i++) {
				System.out.println( (i + 1) + " - " +  AL.get(i).getStall_name());
			}
		}
	}
	//set header
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	//add new Menu (Paulo)
	public static Menu inputMenu() {
		String name = Helper.readString("Enter name of food > ");
		double price = Helper.readDouble("Enter price of food item > ");

		Menu food = new Menu(1, name, price);
		return food;
	}
	public static void addMenu(ArrayList<Menu>Stallmenu, Menu food) {
		Stallmenu.add(food);
	}
	public static String getAllMenu(ArrayList<Menu> Stallmenu){
		String output="";

		for (int i = 0; i < Stallmenu.size(); i++) {
			output += String.format("%-10d %-30s %-10.2f\n", Stallmenu.get(i).getStall_id(), Stallmenu.get(i).getfoodName(), Stallmenu.get(i).getPrice());
		}
		return output;
	}

	// view food item menu (Paulo)
	public static void viewAllMenu(ArrayList<Menu> Stallmenu) {
		String output = String.format("%-10s %-30s $-10s\n", "FOOD ID", "FOOD ITEM", " FOOD PRICE");
		output += getAllMenu(Stallmenu);

		System.out.println(output);
	}

	// Delete food item from menu (Paulo)
	public static void deleteFood(ArrayList<Menu> Stallmenu, int foodId) {

		Stallmenu.remove(foodId);
	}
	//Add ingredient into order list (Celest)
	public static Ingredients addIngredient() {
		String ingredient_name=Helper.readString("Enter ingredient name > ");
		int quantity=Helper.readInt("Enter quantity > ");
		Ingredients item=new Ingredients(1,ingredient_name,quantity);
		return item;
	}
	//Delete ingredient from order list (Celest)
	public static void deleteIngredient(ArrayList<Ingredients> ingredients,int ingredientId) {
		ingredients.remove(ingredientId);
	}

}
