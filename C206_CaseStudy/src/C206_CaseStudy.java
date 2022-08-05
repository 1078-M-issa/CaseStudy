import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudy {

	public static void main(String[] args) {


		ArrayList<Stall> Stalllist = new ArrayList<Stall>();
		ArrayList<Menu> Stallmenu1 = new ArrayList<Menu>();
		ArrayList<Menu> Stallmenu2 = new ArrayList<Menu>();
		ArrayList<Menu> Stallmenu3 = new ArrayList<Menu>();
		ArrayList<Menu> Stallmenu4 = new ArrayList<Menu>();
		ArrayList<Menu> Stallmenu5 = new ArrayList<Menu>();
		ArrayList<Menu> Stallmenu6 = new ArrayList<Menu>();
		ArrayList<Menu> Stallmenu7 = new ArrayList<Menu>();
		ArrayList<Menu> Stallmenu8 = new ArrayList<Menu>();
		ArrayList<Menu> Stallmenu9 = new ArrayList<Menu>();
		ArrayList<Menu> Stallmenu10 = new ArrayList<Menu>();

		Stalllist.add(new Stall(1,"The Juicer","Drinks", "15th Sept 2020"));
		Stallmenu1.add(new Menu(1,"Apple Juice", 2.00));
		Stallmenu1.add(new Menu(1,"Orange Juice", 1.50));



		int choice = 1;


		System.out.println("1 - Admin");
		System.out.println("2 - Stall Ops");
		int Role = Helper.readInt(" Welcome ");

		if (Role == 1) {
			while (choice != 0) {
				C206_CaseStudy.menu(Role,Stalllist);
				choice = Helper.readInt("Enter an option > ");
				//admin (paulo) view Stall choice
				if (choice == 1) {
					choice = Helper.readInt("Enter Stall to view > ");
					if (choice == 1) {

					} else if (choice == 2) {

					}
				//admin edit stall choice
				}else if (choice == 2) {
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
				} else if (choice == 3) {
					choice = Helper.readInt("Enter which stall to delete > ");
					for (int i = 0; i<Stalllist.size(); i++) {
						if ((i + 1) == choice) {
							Stalllist.remove(Stalllist.get(i));
						}
					}
				}

			}
		//Celest & Jennifer Programme code 4 Stall operator
		}else if (Role == 2) {

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
			System.out.println("1 - View");
			System.out.println("2 - Edit");
			System.out.println("3 - Delete");



		//Celest & Jennifer Main Menu 4 Stall operator;
		} else if (role == 2) {

			for (int i = 0; i < AL.size(); i++) {
				System.out.println( (i + 1) + " - " +  AL.get(i).getStall_name());
			}	

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
	//get stall menu
	public static void stallmenu(int role,ArrayList<Menu> AL) {
		for (int i = 0; i < AL.size(); i++) {

			if (role == 1) {



			} else if (role == 2) {

			} else {

				System.out.println( (i + 1) + " - " +  AL.get(i).getfoodName() + " - $" + AL.get(i).getPrice());
			}
		}
	}




}
