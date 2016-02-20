package database;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import printbale.Product;

public class DataBase {
	private static String productListPath;
	
	public DataBase(String path){
		productListPath = path;
	}

	public Product findProduct(String scan) {
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(productListPath));
			String line[];
			
			while(buffer.ready()){
				line = buffer.readLine().split(",");
				if(scan.equals(line[0])){
					buffer.close();
					return new Product(line[0], line[1], Math.abs(Double.parseDouble(line[2])));
				}
			}
			buffer.close();
			
		} catch(FileNotFoundException e){
			System.out.println(productListPath + " file not found...");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Reading from " + productListPath + " failed...");
			e.printStackTrace();
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
