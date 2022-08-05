import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {


		ArrayList<Stall> Stalllist = new ArrayList<Stall>();
		
		Stalllist.add(new Stall(1, "The Juicer", "Drinks"));
		Stalllist.add(new Stall(1, "Outback Grill", "Western"));
		
		int choice = 0;
		
			while (choice != 0) {
				C206_CaseStudy.menu();
				choice = Helper.readInt("Enter an option > ");
			}
		}
		
	public static void menu() {
		C206_CaseStudy.setHeader("CANTEEN AUTOMATIC SYSTEM");
		System.out.println("1. Display Stall");

	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	
	
}
