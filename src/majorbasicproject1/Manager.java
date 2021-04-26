package majorbasicproject1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;



public class Manager {
   Scanner scan = new Scanner(System.in);
   int income;		//수입이 int 넘으면 예외처리 해주기
   int code = 1234; //비밀번호 고정
   ProductManager productManager;
   
   Manager(ProductManager productManager) {
      this.productManager = productManager;
      
    //income.txt 에서 수입 불러오기
      File income_file = new File("income.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(income_file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        income = Integer.parseInt(line);
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}
   }
   

   boolean checkPermit() {
	 //TODO: 관리자 식별 번호 확인 구문 - 관리자라면, return true 아니면 return false
      int input=0;
         //8.6.4문법오류
      try {
         System.out.println("비밀번호를 입력해 주세요(정수)");
         String inputcode=scan.nextLine();
         input=Integer.parseInt(inputcode);
      } catch (NumberFormatException e) {
         // TODO Auto-generated catch block
         System.out.println("올바른 비밀번호 형식이 아닙니다.");
         return false;
      }
      if(input==1234) {
         System.out.println("관리자로 확인되었습니다.\n");
         return true;
      }
      else { //8.6.5의미오류
         System.out.println("비밀번호가 일치하지 않습니다.");
         return false;
      }
      
      
   }
   
	void printManagerMenu(ProductManager p) {
		// TODO: 관리자 메뉴 출력 (1.상품검색, 2.재료검색, 3.매출확인)
		while (true) {
			System.out.println("This is 관리자 메뉴");
			System.out.println("1.상품검색, 2.재료검색, 3.매출확인 4.관리자 메뉴 나가기(한자리 자연수)");
			String select = scan.next();
			int selectInt=0;
			//8.7.4문법오류
			try {
				 selectInt=Integer.parseInt(select);
			} catch (NumberFormatException e) {
				System.out.println("입력값이 올바르지 않습니다.");  
			}
			if (select.equals("1")) {
				searchProducts();
				break;
			} else if (select.equals("2")) {
				searchIngredients();
			} else if (select.equals("3")) {
				checkSales();
			}else if (select.equals("4")) {
				return;
			}
			else if(selectInt<=9) { //8.7.5의미오류
				System.out.println("없는 메뉴입니다."); 
			}
		}
	}

	void searchProducts() {
	 //TODO: 관리자 상품 검색
      for(int i=0; i<productManager.productList.size(); i++) {
         System.out.println(productManager.productList.get(i).getpName());
      }
      while(true) {
      System.out.println("제품별 가격 설정을 하시겠습니까? (y/n)");
      String check=scan.next();
      if(check.equals("y")) {
         setPrice();
         break;
      }
      else if (check.equals("n")) {
         break;
      }else {
    	  System.out.println("입력이 올바르지 않습니다. 다시 입력해주세요.");
      }
     }
   }

   void searchIngredients() {
	 //TODO: 관리자 재료 검색
      for(int i=0;i<productManager.ingredientsList.size();i++) {
    	  String name = productManager.ingredientsList.get(i).iName;
    	  int inventory = productManager.ingredientsList.get(i).inventory;
    	  System.out.println(name + "  " + inventory);
      }
      while(true) {
      System.out.println("재료별 재고관리를 하시겠습니까?(y/n)");
      String check = scan.next();
      
      if(check.equals("y")) {
         manageInventory();
      }
      else if (check.equals("n")) {
         break;
      }
      else {
    	  System.out.println("입력이 올바르지 않습니다. 다시 입력해주세요.");
      }
      }
   }
   
 //제품 가격 설정
   void setPrice() {
	  
      System.out.println("가격 설정할 제품명을 입력해주세요");
      String name = scan.next();
      
     //8.8.4문법오류 
      if(name.length()>15) {
    	  System.out.println("입력값이 올바르지 않습니다. 1~15자리의 문자열을 입력 해주세요 "); 
    	  return;
      }
     
      boolean pCheck = false;
      int productIndex = 0;
      for (int i = 0; i < productManager.productList.size(); i++) {
    	  if (name.equals(productManager.productList.get(i).pName)) {
    		  pCheck = true;
    		  productIndex = i;
    		  break;
    	  }
      }
      //8.8.5의미오류
      if(pCheck==false) {
    	  System.out.println("상품이 존재하지 않습니다.");
    	  return;
      }
      
      
    //가격 수정 -> 파일 수정
      if (pCheck) {
    	  System.out.println("수정할 가격을 입력해주세요");
          String price = scan.next();
       
          //8.11.4문법오류 
          int priceInt=0;
          try {
			priceInt=Integer.parseInt(price);
		} catch (NumberFormatException e1) {
			System.out.println("입력값이 올바르지 않습니다. 첫번째 자리에 0이 올 수 없습니다. 3~8자리 자연수를 입력해주세요");
			return;
		}
          File products_file= new File("products.txt");
          if (products_file.delete()) {
        	  try {
        		  BufferedWriter bw = new BufferedWriter(new FileWriter(products_file));
        		  for (int i = 0; i < productManager.productList.size(); i++) {
        			  Product tempProduct = productManager.productList.get(i);
        			  String pName = tempProduct.getpName();
        			  String pPrice = "";
        			  if (i == productIndex) {
        				  pPrice = price;
        			  } else {
        				  pPrice =  Integer.toString(tempProduct.getpPrice());
        			  }
        			  
        			  String ingredients = "";
        			  for (int j = 0; j < tempProduct.ingredientList.size(); j++) {
        				  ingredients += tempProduct.ingredientList.get(j).iName;
        				  
        				  if (j < tempProduct.ingredientList.size()-1) {
        					  ingredients += ",";
        				  }
        			  }
        	
        			  bw.write(pName + "/" + pPrice + "/" + ingredients + "\n");
                      bw.flush();
        		  }
        		  bw.close();
        	  } catch (IOException e) {
        		// TODO Auto-generated catch block
                  e.printStackTrace();
        	  }
        	  System.out.println(name + " 가격 " + price + " 변경 완료");
          } else {
        	  System.out.println("상품이 존재하지 않습니다.");
          }
      }
      
   } 
         
      

         
   
   
   void manageInventory() {
	 //TODO: 재료별 재고 관리
      System.out.println("재고정리 할 재료를 입력해주세요");
      String name=scan.next();
      if(name.length()>10) {
    	  System.out.println(); //8.9.4문법오류
    	  return;
      }
      int nameInt=0;
      nameInt=Integer.parseInt(name);
      boolean iCheck=false;
      int ingredientIndex=0;
      for(int i=0; i<productManager.ingredientsList.size(); i++) {
    	  if(name.equals(productManager.ingredientsList.get(i).iName)) {
    		  iCheck=true;
    		  ingredientIndex=i;
    		  break;
    	  }
      }
      if(iCheck==false) {
    	  System.out.println(""); //8.9.5의미오류
    	  return;
      } 
      
      if(iCheck) {
    	  System.out.println("수정할 수량을 입력해주세요");
          String count=scan.next(); //8.10.4문법오류
          //문법오류 (string 입력)
          int countInt=0;
          try {
			countInt=Integer.parseInt(count);
		} catch (NumberFormatException e1) {
			System.out.println("입력값이 올바르지 않습니다. 1~4자리 0 이상의 정수를 입력해주세요");
			return;
		}
          
          File ingredients_file= new File("ingredients.txt");
          
          if(ingredients_file.delete()) {
        	  try {
        		  BufferedWriter bw = new BufferedWriter(new FileWriter(ingredients_file));
        		  for (int i = 0; i < productManager.ingredientsList.size(); i++) {
        			  Ingredients tempIngredient = productManager.ingredientsList.get(i);
        			  String iName = tempIngredient.getiName();
        			  String iCount = "";
        			  if (i == ingredientIndex) {
        				  iCount = count;
        			  } else {
        				  iCount =  Integer.toString(tempIngredient.getInventory());
        			  }
        			  
        	
        			  bw.write(iName + "/" + iCount + "\n");
                      bw.flush();
        	  }
        		  bw.close();
          }catch (IOException e) {
      		// TODO Auto-generated catch block
              e.printStackTrace();
    	  }
        	  System.out.println(name + " 수량 " + count + " 변경 완료되었습니다.");
      }else {
    	  System.out.println("수량을 수정할 수 없습니다.");
      }
   }  
      
}

   void checkSales() {
	   //TODO: 매출 확인
	   System.out.println("현재 매출"+income+"입니다.");
   }
}