package majorbasicproject1;

import java.util.ArrayList;

public class Basket {
	ArrayList<String> productBasketList;
	ArrayList<Integer> productHowManyProductList;
	Basket()
	{
		productBasketList = new ArrayList<String>();
		productHowManyProductList = new ArrayList<Integer>();
	}
	void add(String product, int Howmany)
	{
		for (int i=0;i<productBasketList.size();i++)
		{
			if(productBasketList.get(i).equals(product))
			{
				productHowManyProductList.set(i,productHowManyProductList.get(i)+Howmany);
				//System.out.println("추가 완료");
				return;
			}
		
			System.out.println(productBasketList.get(i)+" "+productHowManyProductList.get(i));
		}
		
		productBasketList.add(product);
		productHowManyProductList.add(Howmany);
	}
	
	void showAll()
	{
		System.out.println("[장바구니]");
		for (int i=0;i<productBasketList.size();i++)
		{
			System.out.println((i+1)+". "+productBasketList.get(i)+" "+productHowManyProductList.get(i));
		}
		
	}
}
