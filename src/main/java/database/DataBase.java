package database;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import productInfo.Product;

public class DataBase {
	private static String productListPath;
	
	public DataBase(String path){
		productListPath = path;
	}

	public Product findProduct(String barCode) {
		if(!barCode.equals("")){
			try {
				BufferedReader buffer = new BufferedReader(new FileReader(productListPath));
				String line[];
			
				while(buffer.ready()){
					line = buffer.readLine().split(",");
					if(barCode.equals(line[0].trim())){
						buffer.close();
						if(line.length != 3){ return new Product();	}
						return new Product(line[0].trim(), line[1].trim(), Double.parseDouble(line[2].trim()));
					}
				}
				buffer.close();
			
			} catch(FileNotFoundException e){
				System.out.println(productListPath + " file not found...");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Reading from " + productListPath + " failed...");
				e.printStackTrace();
			} catch (NumberFormatException e){
				//return new Product();
			}
		}
		
		return new Product();
	}

	public static void ShowProductList() {
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(productListPath));
			String line[];
			
			while(buffer.ready()){
				line = buffer.readLine().split(",");
				for(String e : line){
					System.out.print(e + "   ");
				}
				System.out.println("");
			}
			buffer.close();
			
		} catch(FileNotFoundException e){
			System.out.println(productListPath + " file not found...");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Reading from " + productListPath + " failed...");
			e.printStackTrace();
		}
		
	}
}
