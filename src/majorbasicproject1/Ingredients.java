package majorbasicproject1;

public class Ingredients {
	//��� �̸�, ��� ���
	String iName;
	int inventory;
	
	Ingredients(String iName, int inventory) {
		this.iName = iName;
		this.inventory = inventory;
	}

	public String getiName() {
		return iName;
	}

	public void setiName(String iName) {
		this.iName = iName;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
}
