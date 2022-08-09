
public class Promotions extends Menu {
	
	public Promotions(int stall_id, int id, String foodName, int price, int promotion_price) {
		super(stall_id, foodName, price);
		this.promotion_price = promotion_price;
	}

	private int promotion_price;



	public int promotion_price() {
		return promotion_price;
	}

	public void setPromotion_price() {
		this.promotion_price = promotion_price;

	}

}
