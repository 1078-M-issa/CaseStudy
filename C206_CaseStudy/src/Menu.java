/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Paulo Diaz
 * Student ID: 21009874
 * Class: W64N
 * Date/Time created: Friday 05-08-2022 14:22
 */

/**
 * @author paulo
 *
 */
public class Menu extends Stall{
	
	public Menu(int stall_id, String foodName, int price) {
		super(stall_id);
		this.foodName = foodName;
		this.price = price;
	}
	private String foodName;
	private int price;

	
	

	public String toString() {

		String foodItem = String.format("%-10s %-30f",  foodName, price);
		return foodItem;
	}
	public String getfoodName() {
		return foodName;
	}
	public int getPrice() {
		return price;
	}

}
