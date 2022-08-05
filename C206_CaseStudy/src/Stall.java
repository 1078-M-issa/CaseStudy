/*
 * I declare that this code was written by me. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: MUHAMMAD ISSA BIN NORMAN
 * Student ID: 21001078
 * Class: W64L
 * Date/Time created: Friday 05-08-2022 12:38
 */

/**
 * @author 21001078
 *
 */
public class Stall {
	
	private int stall_id;
	private String stall_name;
	private String category;
	private String date;
	
	
	public Stall(int stall_id, String stall_name, String category, String date) {
		this.stall_id = stall_id;
		this.stall_name = stall_name;
		this.category = category;
		this.date = date;
		
	}
	
	public Stall(int stall_id) {
		this.stall_id = stall_id;
	}
	
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
	public int getStall_id() {
		return stall_id;
	}
	public void setStall_id(int stall_id) {
		this.stall_id = stall_id;
	}
	public String getStall_name() {
		return stall_name;
	}
	public void setStall_name(String stall_name) {
		this.stall_name = stall_name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}


}
