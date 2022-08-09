
public class Promotions extends Menu {
	
	public Promotions(int stall_id, String foodName, double price, double promotion_price) {
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
