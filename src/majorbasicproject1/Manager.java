package majorbasicproject1;

import java.util.Scanner;

public class Manager {
	int income;
	Manager(int income)
	{
		this.income= income;
	}
	boolean checkPermit() {
		//TODO: ������ �ĺ� ��ȣ Ȯ�� ���� - �����ڶ��, return true �ƴϸ� return false
		System.out.println("�����ڷ� Ȯ�εǾ����ϴ�.");
		return true;
	}
	
	void printManagerMenu() {
		//TODO: ������ �޴� ��� (1.��ǰ�˻�, 2.���˻�, 3.����Ȯ��)
		System.out.println("This is ������ �޴�");
		Scanner scan = null;
		String select = scan.next();
		selectMenu(select);
	}
	
	void selectMenu(String select) {
		// TODO: �޴� ����
		// TODO: ctrl + z -> ���� �޴��� �̵�
		if (select.equals("1")) {
			searchProducts();
		} else if (select.equals("2")) {
			searchIngredients();
		} else if (select.equals("3")) {
			checkSales();
		} else {
			// TODO: ���� ó��
		}
	}
	
	void searchProducts() {
		//TODO: ������ ��ǰ �˻�
	}
	
	void searchIngredients() {
		//TODO: ������ ��� �˻�
	}
	
	void setPrice() {
		//TODO: ��ǰ�� ���� ����
	}
	
	void manageInventory() {
		//TODO: ��Ằ ��� ����
	}

	void checkSales() {
		//TODO: ���� Ȯ��
	}
}
