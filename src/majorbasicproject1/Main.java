package majorbasicproject1;
import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		Manager manager = new Manager(0);//ó���� �����ڴ� �׻� �Ѹ� �����ؾ� ��
		ProductManager productManager = new ProductManager();
		Scanner scanner = new Scanner(System.in);
		int select = 0;
		while(true) {
			printMenu();
			select = scanner.nextInt();//�޴� ����
			//System.out.println("���� ��ȣ : "+select);
			selectMenu(select,manager,productManager);
			
		}
		
	}
	
	private static void printMenu() {
		System.out.println("\n�޴� ��ȣ�� �Է��ϼ���\n 1. ����� �޴�\n 2. ������ �޴� \n 3. ����");
	}
	
	private static boolean selectMenu(int select,Manager manager,ProductManager productManager) {
		switch(select)
		{
			case 1:
				System.out.println("[����� �޴�]");
				Client client = new Client(productManager);
				//client.printClientMenu();//������ �޴��� �����شٴ� ����
				client.selectMenu();
				client.showBasket();
				
				System.out.println(client.payment());
				manager.income += client.payment();
				System.out.println("���� ���� : " + manager.income+"��");
				 //�Һ�ݾ� ��ȯ������
				break;
			case 2:
				//������ �޴�
				break;
			case 3:
				System.out.println("���α׷��� �����մϴ�.");
				break;
			default:
				System.out.println("�ùٸ� ���α׷��� �Է����ּ���.");
				break;
				
		}
		
		/*
		 * if (select==1) { //TODO: ����� �޴��� �̵� (Client) Client client = new
		 * Client();//�� ����
		 * 
		 * return //�Һ� �ݾ��� ��ȯ���ֱ�
		 * 
		 * } else if (select.equals("2")) { //TODO: ������ �޴��� �̵� (Manager) Manager manager
		 * = new Manager(); if (manager.checkPermit()) { manager.printManagerMenu(); }
		 * else { // TODO: �����ڰ� �ƴҋ� ������ ���� } return true;
		 * 
		 * } else if (select.equals("3")) { return false; } else { //TODO: ���� ó�� ����
		 * return true; }
		 */
		return true;
	}

}
