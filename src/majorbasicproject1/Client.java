package majorbasicproject1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
   int pageNum; // 현재 페이지가 클라이언트 페이지의 몇번째 화면인지 보여주고, 뒤로 가기 기능을 구현하려 합니다.
   ProductManager productManager;            
   Basket basket;
   
   Client(ProductManager productmanager) {
      this.productManager = productmanager;
      //productmanager.printProductsMenu();//핀매 메뉴 전체 보여주기
      this.basket = new Basket();//장바구니
   }
   
   
   
   void printClientMenu() {
      if(true)
      {
         System.out.println("[메뉴명] [가격] [주문 가능 수량]");
         
         
      }//System.out.print("구매할 상품과 수량. 예) Whopper,3");
   }
   
   void selectMenu() {
	   //**********************모든 입력문 기획서랑 맞는지 확인**********************
      Scanner scan = new Scanner(System.in);	
      boolean flag = true;
      
      while(flag) {
    	 this.productManager.printProductsMenu();
    	 System.out.println("제품 번호를 입력해주세요.");      // +++++++++++++제품 번호만 받기로 했던가 ? ? ?
    	 int productSelect = scan.nextInt() - 1;	//선택한 제품 번호
    	 
    	 //제품 번호 예외처리
    	 ArrayList<Product> productList = productManager.productList;
    	 Product product = productManager.productList.get(productSelect);
         if(productSelect > (productList.size()-1) || productSelect < 0) {
            System.out.println("잘못된 입력입니다! [뭐가 잘못 되었는지 알려주기]");  //+++++++++++++기획서 확인 예외처리
            continue;
         } 
         else if(product.tempStock==0) {
        	 System.out.println("제품이 품절 되었습니다.");
        	 continue;   // +++++++++++++수량확인으로 가는 구문,,,,,,,,뭘까 ?
         }
         
         // 구매할 수량 입력
         System.out.println("수량을 입력해주세요.");
         int howmany = scan.nextInt();
         
         // 구매할 수량 입력 예외 처리
         if(howmany > product.tempStock) {
            System.out.println("재고가 부족합니다.");
            continue;
         } else if(howmany <= 0) {
            System.out.println("잘못된 입력입니다. [뭐가 잘못 되었는지 알려주기]");   //+++++++++++++++기획서 확인 예외처리
            continue;
         }
         
         System.out.println("[" + product.pName + "를 " + howmany + "개 선택합니다.]");
         System.out.println("장바구니에 추가하시겠습니까? Yes는 1 입력, No는 0 입력"); //++++++++++++++ 기획서에 안 적었던 거 같은디 추가하면 감점 요소가 있는지 ?
         int addQuery = scan.nextInt();
         
         //장바구니에 추가
         if(addQuery == 1) {
            basket.add(product.pName, howmany);
            product.tempStock -= howmany;
            basket.addSum(product.pPrice*howmany);
            
            boolean flag2 = true;
            while(flag2) {
            	System.out.println("더 주문하시겠습니까? Yes는 1 입력, No는 0 입력");        
                int temp = scan.nextInt();
                
                // 더 주문 안하기
                if(temp == 0) {
                	while(true) {
                		showBasket();
                        if(basket.productHowManyProductList.size()>0) {
                      	  System.out.println("결제할 총 금액은 "+ basket.getSum() +"원 입니다.");
                            System.out.println("결제 하시겠습니까? Yes는 1 입력, No는 0 입력");          //++++++ 기획서 입력 어떻게 되있는지
                            int temp2 = scan.nextInt();
                            
                            //결제
                            if(temp2 == 1) {
                            	pay();
                            
                          	  	System.out.println(basket.getSum() + "원이 결제 되었습니다.");
                          	  	increaseIncome();
                          	  	flag = false;
                          	  	flag2 = false;
                          	  	break;
                             }
                             //결제 취소
                             else if(temp2 == 0) {
                          	   rollback();
                          	   flag = false;
                          	   flag2 = false;
                          	   break;
                             }           
                             else {
                          	   rollback();
                          	   System.out.println("잘못된 입력입니다. [어떻게 입력 해야하는지 알려주기]");
                          	   //++++++ 기획서 예외처리 비교
                             }
                        }
                	}
                }
                // 더 주문하기
                else if(temp==1) {
                	break;
                }
                else {
                	rollback();
                	System.out.println("잘못된 입력입니다!");      //+++++++++기획서 확인 예외처리
                	break; //+++++++++++++더 주문하시겠습니까로 가는 구문,,,,,뭘까?
                }
            }
         }
         
         // 장바구니 추가 안하기
         else if(addQuery == 0) {
        	 System.out.println("이전 단계로 돌아가기 ctrl+z, 끝내기 1");           //+++++++++++++기획서 확인 N 이전 단계 구현
        	 int end=scan.nextInt();
        	 if(end==1) {
        		 break;
        	 }
         }
         
         //예외 처리
         else
         { 
            System.out.println("잘못된 입력입니다!");     //++++++++++++기획서 확인 예외처리
            continue; //+++++++++++++장바구니 추가 구문으로 가는 구문,,,,,뭘까?
         }
      }
   }
   
   //결제 함수
   void pay() {
	   
//	   File ingredients_file= new File("ingredients.txt");
//	   
//	   if(ingredients_file.delete()) {
//		   try {
//			   BufferedWriter bw = new BufferedWriter(new FileWriter(ingredients_file));
//			   for(int i=0; i<productManager.ingredientsList.size(); i++) {
//				   Ingredients ingredient = productManager.ingredientsList.get(i);
//				   String iName = ingredient.getiName();
//				   int iCount = ingredient.getInventory() - ;
//				   
//				   bw.write(iName + "/" + iCount + "\n");
//				   bw.flush();
//				   
//			   }
//			   bw.close();
//		   }catch(IOException e){
//			   e.printStackTrace();
//		   }
//	   }
   }
   
   // 수입 더해주는 함수
   void increaseIncome() {
	   
   }
   
   //결제 취소했을 때, 상품 리스트 원상 복구
   void rollback() {
	   for (int i = 0; i < productManager.productList.size(); i++) {
		   productManager.productList.get(i).tempStock = productManager.productList.get(i).stock;
	   }
   }
   
   void showBasket(){
      System.out.println();
      this.basket.showAll();
   }
}

//결제 안됐는데 장바구니에서 빠지는거 ,  컨트롤 제트,  장바구니에 담긴게 있을 때만 결제하시겠습니까 출력