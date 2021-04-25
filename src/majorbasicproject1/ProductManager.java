package majorbasicproject1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProductManager {
	ArrayList<Product> productList;
	ArrayList<Ingredients> ingredientsList;
	
	ProductManager() {
		productList = new ArrayList<Product>();
		ingredientsList = new ArrayList<Ingredients>();
		fileRead();
	}
	
	void fileRead() {
		File ingredients_file = new File("ingredients.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(ingredients_file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] str = line.split("/");
		        Ingredients temp = new Ingredients(str[0],  Integer.parseInt(str[1]));
		        ingredientsList.add(temp);
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		File products_file = new File("products.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(products_file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	ArrayList<Ingredients> tempIngred = new ArrayList<Ingredients>();
		    	boolean isAvailable = true;
		        String[] str = line.split("/");
		        String[] istr = str[2].split(",");
		        for (int i = 0; i < istr.length; i++) {
		        	for (int j = 0; j < ingredientsList.size(); j++) {
		        		if (istr[i].equals(ingredientsList.get(j).getiName())) {
		        			tempIngred.add(ingredientsList.get(j));
		        			if (ingredientsList.get(j).inventory == 0) {
		        				isAvailable = false;
		        			}
		        			break;
		        		}
		        	}
		        }
		        
		        Product temp = new Product(str[0], Integer.parseInt(str[1]), tempIngred, isAvailable);
		        productList.add(temp);
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	void printProductsMenu() {
		for (int i = 0; i < productList.size(); i++) {
			System.out.println((i+1) + ") "+ productList.get(i).toString());
		}
	}
}
