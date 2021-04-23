package majorbasicproject1;

import java.util.ArrayList;
import java.util.Scanner;

public class Client {
	int pageNum; // ���� �������� Ŭ���̾�Ʈ �������� ���° ȭ������ �����ְ�, �ڷ� ���� ����� �����Ϸ� �մϴ�.
	ProductManager productManager;				
	Basket basket;
	Client(ProductManager productmanager) {
		this.productManager=productmanager;
		//productmanager.printProductsMenu();//�ɸ� �޴� ��ü �����ֱ�
		this.basket = new Basket();//��ٱ���
	}
	void printClientMenu() {
		if(true)
		{
			System.out.println("[�޴���] [����] [�ֹ� ���� ����]");
			productManager.printProductsMenu();
			
		}//System.out.print("������ ��ǰ�� ����. ��) Whopper,3");
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
			System.out.println("["+productManager.productList.get(select-1).pName+"�� "+Howmany+"�� �����մϴ�.]");
			System.out.println("��ٱ��Ͽ� �߰��Ͻðڽ��ϱ�? Yes�� 1 �Է�, No�� 0 �Է�");
			temp=scanner.nextInt();
			if(temp==1) {
				basket.add(productManager.productList.get(select-1).pName,Howmany);
			}
			productManager.productList.get(select-1).stock-=Howmany;
			System.out.println("�� �ֹ��Ͻðڽ��ϱ�? Yes�� 1 �Է�, No�� 0 �Է�");
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
