package majorbasicproject1;

import java.util.ArrayList;

public class Product {
	//상품명, 재료, 재료 재고, 가격
	String pName;
	ArrayList<Ingredients> ingredientList;
	int pPrice;
	boolean isAvailable;
	int stock;
	
	Product(String pName, int pPrice, ArrayList<Ingredients> ingredientList, boolean isAvailable) {
		this.pName = pName;
		this.ingredientList = ingredientList;
		this.pPrice = pPrice;
		this.isAvailable = isAvailable;
		
		//상품 재고 계산
		this.stock = 10000000;
		for (int i = 0; i < ingredientList.size(); i++) {
			if (this.stock > ingredientList.get(i).inventory) {
				this.stock = ingredientList.get(i).inventory;
			}
		}
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public ArrayList<Ingredients> getIngredientList() {
		return ingredientList;
	}

	public void setIngredientList(ArrayList<Ingredients> ingredientList) {
		this.ingredientList = ingredientList;
	}

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}
	
	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String toString() {
		return pName + " / " + pPrice + " / " + stock;
	}

	
	
}
