package majorbasicproject1;
import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		Manager manager = new Manager(0);//처음에 관리자는 항상 한명 존재해야 함
		ProductManager productManager = new ProductManager();
		Scanner scanner = new Scanner(System.in);
		int select = 0;
		while(true) {
			printMenu();
			select = scanner.nextInt();//메뉴 선택
			//System.out.println("선택 번호 : "+select);
			selectMenu(select,manager,productManager);
			
		}
		
	}
	
	private static void printMenu() {
		System.out.println("\n메뉴 번호를 입력하세요\n 1. 사용자 메뉴\n 2. 관리자 메뉴 \n 3. 종료");
	}
	
	private static boolean selectMenu(int select,Manager manager,ProductManager productManager) {
		switch(select)
		{
			case 1:
				System.out.println("[사용자 메뉴]");
				Client client = new Client(productManager);
				//client.printClientMenu();//고객에게 메뉴판 보여준다는 느낌
				client.selectMenu();
				client.showBasket();
				
				System.out.println(client.payment());
				manager.income += client.payment();
				System.out.println("현재 수입 : " + manager.income+"원");
				 //소비금액 반환해주지
				break;
			case 2:
				//관리자 메뉴
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("올바른 프로그램을 입력해주세요.");
				break;
				
		}
		
		/*
		 * if (select==1) { //TODO: 사용자 메뉴로 이동 (Client) Client client = new
		 * Client();//고객 입장
		 * 
		 * return //소비 금액을 반환해주기
		 * 
		 * } else if (select.equals("2")) { //TODO: 관리자 메뉴로 이동 (Manager) Manager manager
		 * = new Manager(); if (manager.checkPermit()) { manager.printManagerMenu(); }
		 * else { // TODO: 관리자가 아닐떄 실행할 구문 } return true;
		 * 
		 * } else if (select.equals("3")) { return false; } else { //TODO: 예외 처리 구문
		 * return true; }
		 */
		return true;
	}

}
