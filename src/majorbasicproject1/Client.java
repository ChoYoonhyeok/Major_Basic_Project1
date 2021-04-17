package majorbasicproject1;

import java.util.ArrayList;
import java.util.Scanner;

public class Client {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Product, Integer> shopping_basket;		//장바구니 ArrayList
	static ProductManager productManager;						//Products class
	
	Client() {
		productManager = new ProductManager();
		shopping_basket = new ArrayList<ProductManager>();
	}

	
	void printClientMenu() {
		productManager.printProductsMenu();
		System.out.print("구매할 상품과 수량. 예) Whopper,3");
		addBasket(scan.next());//이 줄에 대한 입력은 위 함수를 , 통해 쪼갠 후 parseInt 작업, 제네릭에 전달
		
		// TODO: 사용자가 주문한 상품의 가격 및 수량과 합계가격, [1. 상품주문수정/2. 결제]메뉴 출력
		//************장바구니 기능 구현 어디에 해야 할 지?
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
		//TODO: 상품주문수정
		
		System.out.println("상품이 변경되었습니다.");
	}
	
	void payBasket() {
		//TODO: 상품 결제
		System.out.println("결제되었습니다.");
	}
	
	void showBasket(){
		//장바구니 볼 수 있는 기능 추가.
	}
}
