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
		System.out.println("���α׷� ����");
	}
	
	private static void printMenu() {
		System.out.println("\n�޴� ��ȣ�� �Է��ϼ���\n 1. ����� �޴�\n 2. ������ �޴� \n 3. ����");
	}
	
	private static boolean selectMenu(String select) {
		if (select.equals("1")) {
			//TODO: ����� �޴��� �̵� (Client)
			Client client = new Client();
			client.printClientMenu();
			return true;
			
		} else if (select.equals("2")) {
			//TODO: ������ �޴��� �̵� (Manager)
			Manager manager = new Manager();
			if (manager.checkPermit()) {
				manager.printManagerMenu();
			} else {
				// TODO: �����ڰ� �ƴҋ� ������ ����
			}
			return true;
			
		} else if (select.equals("3")) {
			return false; 
		}
		else {
			//TODO: ���� ó�� ����
			return true;
		}
	}

}
