package majorbasicproject1;

import java.util.ArrayList;
import java.util.Scanner;

public class Client {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Product, Integer> shopping_basket;		//��ٱ��� ArrayList
	static ProductManager productManager;						//Products class
	
	Client() {
		productManager = new ProductManager();
		shopping_basket = new ArrayList<ProductManager>();
	}

	
	void printClientMenu() {
		productManager.printProductsMenu();
		System.out.print("������ ��ǰ�� ����. ��) Whopper,3");
		addBasket(scan.next());//�� �ٿ� ���� �Է��� �� �Լ��� , ���� �ɰ� �� parseInt �۾�, ���׸��� ����
		
		// TODO: ����ڰ� �ֹ��� ��ǰ�� ���� �� ������ �հ谡��, [1. ��ǰ�ֹ�����/2. ����]�޴� ���
		//************��ٱ��� ��� ���� ��� �ؾ� �� ��?
		System.out.println("1. ��ǰ�ֹ�����\n2. ����");
		selectMenu(scan.next());
	}
	
	void selectMenu(String select) {
		// TODO: ctrl + z -> ���� �޴��� �̵�
		//while(true) {
		if (select.equals("1")) {
			changeBasket();
		} else if (select.equals("2")) {
			payBasket();
		} else {
			//TODO : ���� ó�� ����
		}
	}
	
	void addBasket(String select) {
		//TODO: ��ٱ��Ͽ� ��ǰ �߰�
		System.out.println("��ǰ�� �߰��Ǿ����ϴ�.");
	}
	
	void changeBasket() {
		//TODO: ��ǰ�ֹ�����
		
		System.out.println("��ǰ�� ����Ǿ����ϴ�.");
	}
	
	void payBasket() {
		//TODO: ��ǰ ����
		System.out.println("�����Ǿ����ϴ�.");
	}
	
	void showBasket(){
		//��ٱ��� �� �� �ִ� ��� �߰�.
	}
}
