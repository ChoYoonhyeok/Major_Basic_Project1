package majorbasicproject1;
import java.util.Scanner;

public class Main {
   static Scanner scan = new Scanner(System.in);
   static ProductManager productManager;
   static Manager manager;	//처음에 관리자는 항상 한명 존재해야 함
   
   public static void main(String[] args) {
      int select = 0;
      
      while(true) {
    	  productManager = new ProductManager();
    	  manager = new Manager(productManager);
    	  
         printMenu();
         select = scan.nextInt();//메뉴 선택
         
         if(selectMenu(select) != true) {
        	 break;
         }         
      }
   }
   
   
   
   
   private static void printMenu() {
      System.out.println("\n메뉴 번호를 입력하세요\n 1. 사용자 메뉴\n 2. 관리자 메뉴 \n 3. 종료");
   }
   
   private static boolean selectMenu(int select) {

      switch(select)
      {
         case 1:
            System.out.println("[사용자 메뉴]");
            Client client = new Client(productManager);
            client.printClientMenu();//고객에게 메뉴판 보여준다는 느낌
            client.selectMenu();
            return true;
         case 2:
            if (manager.checkPermit() == true) {
            	System.out.println("[관리자 메뉴]"); //관리자 메뉴
            	manager.printManagerMenu(productManager);
            }
            return true;
         case 3:
            System.out.println("프로그램을 종료합니다.");
            return false;
         default:
            System.out.println("잘못된 입력입니다.");            
            return true;
            
      }
      
   }

}