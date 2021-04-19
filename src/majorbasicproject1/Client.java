package majorbasicproject1;

import java.util.ArrayList;
import java.util.Scanner;

public class Client {
	static Scanner scan = new Scanner(System.in);
	//ArrayList<Product, Integer> shopping_basket;		//ArrayList
	ProductManager productManager;			//Products class
	
	Client() {
		productManager = new ProductManager();
		//shopping_basket = new ArrayList<Product, Integer>();
	}

	
	void printClientMenu() {
		productManager.printProductsMenu();
		System.out.print("구매할 상품을 선택하세요: ");
		addBasket(scan.next());
		
		// TODO: 사용자가 주문한 상품의 가격 및 수량과 합계가격, [1. 상품주문수정/2. 결제]메뉴 출력
		System.out.println("1. 상품주문수정\n2. 결제");
		selectMenu(scan.next());
	}
	
	void selectMenu(String select) {
		// TODO: ctrl + z -> 이전 메뉴로 이동
		//while(true) {
		if (select.equals("1")) {
			changeBasket();
		} else if (select.equals("2")) {
			payBasket();
		} else {
			//TODO : 예외 처리 구문
		}
	}
	
	void addBasket(String select) {
		//TODO: 장바구니에 상품 추가
		System.out.println("상품이 추가되었습니다.");
	}
	
	void changeBasket() {
		//TODO: 상품주문수정 상품 추가/삭제 기능
		System.out.println("1.상품 추가\n 2.상품 삭제");
	}
	
	void payBasket() {
		//TODO: 상품 결제
		System.out.println("결제되었습니다.");
	}
	
	void showBasket(){
		
	}
	

}
