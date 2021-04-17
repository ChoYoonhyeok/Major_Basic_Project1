package majorbasicproject1;
import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		while(true) {
			printMenu();
			String select = scan.next();
			boolean flag = selectMenu(select);
			if (flag == false) break;
		}
		System.out.println("프로그램 종료");
	}
	
	private static void printMenu() {
		System.out.println("\n메뉴 번호를 입력하세요\n 1. 사용자 메뉴\n 2. 관리자 메뉴 \n 3. 종료");
	}
	
	private static boolean selectMenu(String select) {
		if (select.equals("1")) {
			//TODO: 사용자 메뉴로 이동 (Client)
			Client client = new Client();
			client.printClientMenu();
			return true;
			
		} else if (select.equals("2")) {
			//TODO: 관리자 메뉴로 이동 (Manager)
			Manager manager = new Manager();
			if (manager.checkPermit()) {
				manager.printManagerMenu();
			} else {
				// TODO: 관리자가 아닐떄 실행할 구문
			}
			return true;
			
		} else if (select.equals("3")) {
			return false; 
		}
		else {
			//TODO: 예외 처리 구문
			return true;
		}
	}

}
