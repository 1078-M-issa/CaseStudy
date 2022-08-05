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
		
		Stalllist.add(new Stall(1,"The Juicer","Drinks"));
		Stallmenu1.add(new Menu(1,"Apple Juice", 2.00));
		Stallmenu1.add(new Menu(1,"Orange Juice", 1.50));
		

		
		int choice = 1;

		while (choice != 0) {
			C206_CaseStudy.menu(Stalllist);
			choice = Helper.readInt("Enter an option > ");
			
			if (choice == 1) {
				C206_CaseStudy.stallmenu(Stallmenu1);
				
			}
		}


	}
	//print menu
	public static void menu(ArrayList<Stall> AL) {
		C206_CaseStudy.setHeader("CANTEEN AUTOMATIC SYSTEM");
		for (int i = 0; i < AL.size(); i++) {
			System.out.println( (i + 1) + " - " +  AL.get(i).getStall_name());
		}

	}
	//set header
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	//get stall menu
	public static void stallmenu(ArrayList<Menu> AL) {
		for (int i = 0; i < AL.size(); i++) {
			System.out.println( (i + 1) + " - " +  AL.get(i).getfoodName() + " - $" + AL.get(i).getPrice());
		}
	}
	



}
