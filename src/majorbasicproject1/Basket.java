package majorbasicproject1;

import java.util.ArrayList;

public class Basket {
	ArrayList<String> productBasketList;
	ArrayList<Integer> productHowManyProductList;
	int sum;
	
	Basket()
	{
		productBasketList = new ArrayList<String>();
		productHowManyProductList = new ArrayList<Integer>();
		sum = 0;
	}
	
	void add(String product, int Howmany)
	{
		for (int i=0;i<productBasketList.size();i++) {
			if(productBasketList.get(i).equals(product)) {
				productHowManyProductList.set(i,productHowManyProductList.get(i)+Howmany);
				//System.out.println("�߰� �Ϸ�");
				return;
			}
		}
		
		productBasketList.add(product);
		productHowManyProductList.add(Howmany);
	}
	
	public int getSum() {
		return sum;
	}

	public void addSum(int price) {
		this.sum += price;
	}

	void showAll()
	{
		System.out.println("[현재 장바구니에 있는 품목/수량]");
		for (int i=0;i<productBasketList.size();i++)
		{
			System.out.println((i+1)+". "+productBasketList.get(i)+" "+productHowManyProductList.get(i));
		}
		
	}
}