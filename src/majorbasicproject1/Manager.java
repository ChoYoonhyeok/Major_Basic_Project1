package majorbasicproject1;

import java.util.Scanner;

public class Manager {
	static Scanner scan = new Scanner(System.in);
	
	boolean checkPermit() {
		//TODO: 관리자 식별 번호 확인 구문 - 관리자라면, return true 아니면 return false
		System.out.println("관리자로 확인되었습니다.");
		return true;
	}
	
	void printManagerMenu() {
		//TODO: 관리자 메뉴 출력 (1.상품검색, 2.재료검색, 3.매출확인)
		System.out.println("1.상품검색\n2.재료검색\n3.매출확인");
		String select = scan.next();
		selectMenu(select);
	}
	
	void selectMenu(String select) {
		// TODO: 메뉴 선택
		// TODO: ctrl + z -> 이전 메뉴로 이동
		if (select.equals("1")) {
			searchProducts();
		} else if (select.equals("2")) {
			searchIngredients();
		} else if (select.equals("3")) {
			checkSales();
		} else {
			// TODO: 예외 처리
		}
	}
	
	void searchProducts() {
		//TODO: 관리자 상품 검색
	}
	
	void searchIngredients() {
		//TODO: 관리자 재료 검색
	}
	
	void setPrice() {
		//TODO: 제품별 가격 설정
	}
	
	void manageInventory() {
		//TODO: 재료별 재고 관리
	}

	void checkSales() {
		//TODO: 매출 확인
	}
}
