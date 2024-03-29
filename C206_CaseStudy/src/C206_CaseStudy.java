import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class C206_CaseStudy {

	public static void main(String[] args) {


		ArrayList<Stall> Stalllist = new ArrayList<Stall>();
		ArrayList<Menu> Stallmenu = new ArrayList<Menu>();
		ArrayList<Ingredients> ingredients1 = new ArrayList<Ingredients>();
		ArrayList<Ingredients> ingredients2 = new ArrayList<Ingredients>();
		ArrayList<ArrayList> ListofOrders = new ArrayList<ArrayList>();
		ArrayList<Promotions> promotionList = new ArrayList<Promotions>();

		Stalllist.add(new Stall(1,"The Juicer","Drinks", "15th Sept 2020"));
		Stalllist.add(new Stall(2,"Outback Grill","Western", "24th Sept 2019"));
		Stallmenu.add(new Menu(1,"Apple Juice", 6.00));
		Stallmenu.add(new Menu(1,"Orange Juice", 3.50));
		Stallmenu.add(new Menu(2,"Fries", 3));
		Stallmenu.add(new Menu(2,"Lamb chop", 7));
		ingredients1.add(new Ingredients(1,"Apple",15));
		ingredients1.add(new Ingredients(1,"Orange",10));
		ingredients1.add(new Ingredients(2,"Potato",13));
		ingredients1.add(new Ingredients(2,"Lamb meat",10));
		ListofOrders.add(ingredients1);
		ListofOrders.add(ingredients2);

		int choice = 1;

		System.out.println("1 - Admin");
		System.out.println("2 - Stall Ops");
		Helper.line(80, "-");
		int Role = Helper.readInt("Welcome - ");

		//Role: Admin
		if (Role == 1) {
			while (choice != 0) {
				C206_CaseStudy.menu(Role,Stalllist);
				choice = Helper.readInt("Enter an option > ");
				//admin (paulo) view Stall choice
				if (choice == 1) {

					Helper.line(80, "-");
					choice = Helper.readInt("Enter Stall to view > ");
					Helper.line(80, "-");

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

					Helper.line(80, "-");
					choice = Helper.readInt("Choose option > ");
					Helper.line(80, "-");

					if (choice == 1) {
						Menu food1 = inputMenu();
						C206_CaseStudy.addMenu(Stallmenu, food1);
						System.out.println("Food item added");
						//System.out.println("Food item added");
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
					C206_CaseStudy.setHeader("Delete stall");
					choice = Helper.readInt("Enter which stall to delete > ");
					deleteStall(Stalllist, choice);
					Helper.line(80, "-");
				} else if (choice == 3) {
					C206_CaseStudy.setHeader("Add a new stall");
					retrieveAllStalls(Stalllist);
					Helper.line(80, "-");
					int newid = Helper.readInt("Enter in stall slot > ");
					newid = newStallSlotChecker(newid);
					addStall(Stalllist, newid);
				}
			}
			//Celest & Jennifer Programme code 4 Stall operator
		} else if (Role == 2) {
			while (choice != 0) {
				String output1="";
				String output2="";
				C206_CaseStudy.menu(Role,Stalllist);
				int Stallslot = Helper.readInt("Enter stall > ");
				if (Stallslot > Stalllist.size()) {
					while (Stallslot > Stalllist.size()) {
						System.out.println("Stall does not exist");
						Stallslot = Helper.readInt("try again > ");
					}
				}
				while (choice!=0) {
					System.out.println("\n");
					C206_CaseStudy.setHeader(Stalllist.get(Stallslot - 1).getStall_name());
					System.out.println("What would you like to do? \n");
					System.out.println("1 - View Promotions");
					System.out.println("2 - View Ingredient Order List");	
					System.out.println("0 - Exit \n");

					Helper.line(80, "-");
					choice=Helper.readInt("Enter option > ");
					Helper.line(80, "-");


					//jennifer 
					if (choice == 1) {

						System.out.println("\n");
						Helper.line(80, "-");
						System.out.println("What would you like to do? \n");
						System.out.println("1 - Add promotions to food item");
						System.out.println("2 - View promotions");
						System.out.println("3 - Delete promotions");

						choice = Helper.readInt("Choose option > ");

						//C206_CaseStudy.addPromotion();
						Helper.line(80, "-");
						if (choice==1) {
							for (int i = 0; i<Stallmenu.size(); i++) {
								if(Stallmenu.get(i).getStall_id() == (Stallslot )) {
									System.out.println(Stallmenu.get(i).getfoodName() + " - " + Stallmenu.get(i).getPrice());
								}
							} 
							addPromotions(Stallmenu, promotionList, Stallslot);


							//View Promotions

						}else if (choice == 2) {

							viewPromotion(Stalllist, promotionList, Stallslot);

							//Delete Promotions

						}else if (choice == 3) {
							deletePromotions(promotionList, Stallslot);
							if (promotionList.isEmpty() == true) {
								System.out.println("deletion successful") ;
							} else {
								System.out.println("deletion Fail") ;
							}
						}



						//------------------------------------------------------------------------------------------------------
					} // celest;
					else if (choice == 2) {


						System.out.println("\n");
						Helper.line(80, "-");
						System.out.println("What would you like to do? \n");
						System.out.println("1 - Add order list");
						System.out.println("2 - View order list");
						System.out.println("3 - Remove order list");
						System.out.println("4 - Back");
						System.out.println("0 - Exit");

						Helper.line(80, "-");
						choice = Helper.readInt("Choose option > ");
						Helper.line(80, "-");
						//Add
						if (choice==1) {
							ArrayList <Ingredients> selected = null;
							if (ListofOrders.get(0).size() < 1) {
								selected = ListofOrders.get(0);
							}  else if (ListofOrders.get(1).size() < 1) {
								selected = ListofOrders.get(1);
							}	else {
								System.out.println("You've exceded your maximum order list of 2, edit or delete the 2 submited.");
							}

							choice = addOrderList(choice, Stallslot, selected);
							System.out.println("Ingredient added");

							//View
						} else if (choice==2) {
							boolean mark1 = false;
							boolean mark2 = false;
							ArrayList <Ingredients> selected = null;
							output1=String.format("%-10s %-30s %-30s\n","ID", "INGREDIENT NAME", "QUANTITY");
							if (ListofOrders.get(0).size() >= 1) {
								selected = ListofOrders.get(0);
								output1 = viewOrderList(output1, Stallslot, selected);
								if (output1.isBlank() == false) {
									System.out.println("List 1 \n"+ output1);
									Helper.line(80, "-");
									mark1 = true;
								}
							} 
							output2=String.format("%-10s %-30s %-30s\n","ID", "INGREDIENT NAME", "QUANTITY");
							if (ListofOrders.get(1).size() >= 1) {
								selected = ListofOrders.get(1);
								output2 = viewOrderList(output2, Stallslot, selected); 
								if (output2.isBlank() == false) {
									System.out.println("List 2 \n"+ output2);
									Helper.line(80, "-");
									mark2 = true;
								}
							}


							if (mark1 == false && mark2 == false ) {
								System.out.println("Orders list is empty");
							}

							//Delete		
						} else if (choice==3) {
							boolean mark1 = false;
							boolean mark2 = false;
							ArrayList <Ingredients> selected = null;
							output1=String.format("%-10s %-30s %-30s\n","ID", "INGREDIENT NAME", "QUANTITY");
							if (ListofOrders.get(0).size() >= 1) {
								selected = ListofOrders.get(0);
								output1 = viewOrderList(output1, Stallslot, selected);
								if (output1.isBlank() == false) {
									System.out.println("List 1 \n"+ output1);
									Helper.line(80, "-");
									mark1 = true;
								}
							} 
							if (ListofOrders.get(1).size() >= 1) {
								output2=String.format("%-10s %-30s %-30s\n","ID", "INGREDIENT NAME", "QUANTITY");
								selected = ListofOrders.get(1);
								output2 = viewOrderList(output2, Stallslot, selected); if (output2.isBlank() == false) {
									System.out.println("List 2 \n"+ output2);
									Helper.line(80, "-");
									mark2 = true;
								}
							}


							if (mark1 == false && mark2 == false ) {
								System.out.println("Orders list is empty");
							}
							selected = null;
							System.out.println("1- Delete a list\n2- Cancel");
							Helper.line(80, "-");
							choice = Helper.readInt("Your Option> ");
							if(choice == 1) {
								choice = Helper.readInt("Which list to delete> ");
								while (choice > ListofOrders.size()){
									System.out.println("List doesn't exist");

									choice = Helper.readInt("Try again > ");
								}
								deleteList(ListofOrders, choice);
							}
							else {
								if (choice == 4) {
									break;
								} else {
									System.out.println("Invalid option");
								}

							}
						}
					}
				}
			}
		}




		//-----------------------------------------------------------------------------------------------------


		// Methods for Casestudy;
	
	}
	//celest
	public static void deleteList(ArrayList<ArrayList> ListofOrders, int choice) {
		ArrayList<Ingredients> selected;
		selected = ListofOrders.get(choice - 1);

		if(selected.removeAll(selected) == true) {
			System.out.println("List removed succesfully.");
		}
	}

	//celest;
	public static String viewOrderList(String output1, int Stallslot, ArrayList<Ingredients> selected) {
		for (int i = 0; i < selected.size(); i++) {
			if (selected.get(i).getStall_id()==Stallslot) {
				output1 += String.format("%-10d %-30s %-10d\n", i+1 ,selected.get(i).getIngredient_name(), selected.get(i).getQuantity());
			} 
		}
		return output1;
	}
	
	
	//Jennifer

	public static void deletePromotions(ArrayList<Promotions> promotionList, int Stallslot) {
		for (int o = 0; o < promotionList.size(); o++) {
			if (promotionList.get(o).getStall_id() == Stallslot);
			promotionList.remove(o);
		}
	}
	//Jennifer
	public static void viewPromotion(ArrayList<Stall> Stalllist, ArrayList<Promotions> promotionList, int Stallslot) {
		if ( promotionList.size() != 0) {
			System.out.println("Promotion for " + Stalllist.get(Stallslot - 1).getStall_name());
			for (int a = 0 ; a < promotionList.size(); a++ ) {
				if (promotionList.get(a).getStall_id() == promotionList.get(a).getStall_id()) {
					System.out.println((promotionList.get(a).getfoodName() + " : " + promotionList.get(a).getPromotion_price()));
				}
			}
		} else {
			System.out.println("An empty list");
		}
	}//Jennifer
	public static void addPromotions(ArrayList<Menu> Stallmenu, ArrayList<Promotions> promotionList, int Stallslot) {
		String Selection = Helper.readString("Enter food name to apply promotions> ");
		String Name =  " ";
		double price = 0;
		if(promotionList.size() < 1) {
			for (int o = 0; o < Stallmenu.size(); o++) {
				if (Stallmenu.get(o).getfoodName().equalsIgnoreCase(Selection)) {
					Name = Stallmenu.get(o).getfoodName();
					price = Stallmenu.get(o).getPrice(); 
					System.out.println(Name);
					System.out.println(price);
				}
			}

			double promoprice = price - 2;              
			Promotions newpromo = new Promotions(Stallslot, Name, price, promoprice);
			System.out.println("Promotion has been added");

			promotionList.add(newpromo);
		} else {
			System.out.println("Promotion limit reach, please delete the current one");
		}
	} 
	//Celest
	public static int addOrderList(int choice, int Stallslot, ArrayList<Ingredients> selected) {
		int num = 0;
		while (choice != 2) {
			Ingredients Newlyadded = C206_CaseStudy.addIngredient(Stallslot);
			selected.add(Newlyadded);
			if (selected.get(num).getIngredient_name() == Newlyadded.getIngredient_name()) {
				System.out.println("Ingredients added succesfully \n Would you like to add another to the list?\n---------- \n 1- Yes \n 2- No \n----------");
				num++;
				choice = Helper.readInt("Choose option > ");
			}
		}
		return choice;
	}//(issa)
	public static void addStall(ArrayList<Stall> Stalllist, int newid) {
		String NewName = Helper.readString("Enter new stall name >  ");
		String NewCat = Helper.readString("Enter new stall Cat >  ");
		String OpDate = Helper.readString("Enter operating date >");
		Stalllist.add(new Stall(newid,NewName, NewCat,OpDate ));

	} //(issa)
	public static int newStallSlotChecker(int newid) {
		while (newid > 10) {
			System.out.println("Stall slot doesn't exist");
			newid = Helper.readInt("Try again > ");
		}
		return newid;
	} //(issa)
	public static void retrieveAllStalls(ArrayList<Stall> Stalllist) {
		boolean trigger = true;
		for (int i = 0; i < 10 ; i++) {
			trigger = false;
			for (int a =0 ; a < Stalllist.size(); a++) {
				if (Stalllist.get(a).getStall_id() == i) {
					System.out.println((i + 1) + " " + Stalllist.get(a).getStall_name()); 
					trigger = true;
					break;

				} 
			} if (trigger == false) {
				System.out.println((i + 1) + " Empty Stallslot"); 
			}

		}
	}
	public static void deleteStall(ArrayList<Stall> Stalllist, int choice) {
		for (int i = 0; i<Stalllist.size(); i++) {
			if ((i + 1) == choice) {
				Stalllist.remove(Stalllist.get(i));
			}
		}
	}
	//print Mainmenu (issa)
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
			System.out.println("1 - View Stall Menu");
			System.out.println("2 - Delete Stall");
			System.out.println("3 - Add Stall");
			System.out.println("0 - Exit");

			//Celest & Jennifer Main Menu 4 Stall operator;
		} else if (role == 2) {

			System.out.println("Hello Stall ops \n\nList of Stalls\n ");

			Helper.line(80, "-");
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
		if (price >= 3 && price <= 10) {
			Menu food = new Menu(1, name, price);
			return food;
		} else {
			System.out.println("Invalid price");
		}
		return null;

		//		Menu food = new Menu(1, name, price);
		//		return food;
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
	public static Ingredients addIngredient(int stallslot) {
		String ingredient_name=Helper.readString("Enter ingredient name > ");
		int quantity=Helper.readInt("Enter quantity > ");
		Ingredients item=new Ingredients(stallslot,ingredient_name,quantity);
		return item;
	}


}
