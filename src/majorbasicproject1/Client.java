package majorbasicproject1;

import java.util.ArrayList;
import java.util.Scanner;

public class Client {
	int pageNum; // 현재 페이지가 클라이언트 페이지의 몇번째 화면인지 보여주고, 뒤로 가기 기능을 구현하려 합니다.
	ProductManager productManager;				
	Basket basket;
	Client(ProductManager productmanager) {
		this.productManager=productmanager;
		//productmanager.printProductsMenu();//핀매 메뉴 전체 보여주기
		this.basket = new Basket();//장바구니
	}
	void printClientMenu() {
		if(true)
		{
			System.out.println("[메뉴명] [가격] [주문 가능 수량]");
			productManager.printProductsMenu();
			
		}//System.out.print("구매할 상품과 수량. 예) Whopper,3");
	}
	
	void selectMenu() {
		Scanner scanner = new Scanner(System.in);
		int select=0,Howmany=0;
		Boolean Okay = true;
		int temp=0;
		while(Okay)
		{
			this.productManager.printProductsMenu();
			select =scanner.nextInt();
			Howmany = scanner.nextInt();
			System.out.println("["+productManager.productList.get(select-1).pName+"를 "+Howmany+"개 선택합니다.]");
			System.out.println("장바구니에 추가하시겠습니까? Yes는 1 입력, No는 0 입력");
			temp=scanner.nextInt();
			if(temp==1) {
				basket.add(productManager.productList.get(select-1).pName,Howmany);
			}
			productManager.productList.get(select-1).stock-=Howmany;
			System.out.println("더 주문하시겠습니까? Yes는 1 입력, No는 0 입력");
			temp=scanner.nextInt();
			if(temp==0)
			{
				break;
			}
		}
	}
	
	
	void showBasket(){
		System.out.println();
		this.basket.showAll();
	}
	int payment()
	{
		int sum =0;
		for (int i=0;i<this.basket.productBasketList.size();i++)
		{
			for(int j=0;j<this.productManager.productList.size();j++)
			{
				if(this.basket.productBasketList.get(i).equals(this.productManager.productList.get(j).pName))
				{
					//System.out.println(this.productManager.productList.get(j).pPrice);
					//System.out.println(this.basket.productHowManyProductList.get(i));
					sum = this.productManager.productList.get(j).pPrice*this.basket.productHowManyProductList.get(i);
				}
			}
		}
		return sum;
	}
}
