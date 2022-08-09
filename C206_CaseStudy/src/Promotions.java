
public class Promotions extends Menu {
	
<<<<<<< HEAD
	public Promotions(int stall_id, String foodName, double price, double promotion_price) {
=======
	public Promotions(int stall_id, int id, String foodName, int price, int promotion_price) {
>>>>>>> branch 'master' of https://github.com/1078-M-issa/CaseStudy.git
		super(stall_id, foodName, price);
		this.promotion_price = promotion_price;
	}

	private double promotion_price;

	public double getPromotion_price() {
		return promotion_price;
	}

	public void setPromotion_price(double promotion_price) {
		this.promotion_price = promotion_price;
	}




	

}
