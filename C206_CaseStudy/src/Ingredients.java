
public class Ingredients extends Stall{
	private String ingredient_name;
	private int quantity;
	
	public Ingredients(int stall_id, String ingredient_name, int quantity) {
		super(stall_id);
		this.ingredient_name = ingredient_name;
		this.quantity = quantity;
	}

	public String getIngredient_name() {
		return ingredient_name;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public void setIngredient_name(String name) {
		ingredient_name = name;
	}
	
	public void setQuantity(int num) {
		quantity = num;
	}

	@Override
	public String toString() {
		return "Ingredients: "+ ingredient_name + "\nQuantity:"+ quantity;
	}
}
