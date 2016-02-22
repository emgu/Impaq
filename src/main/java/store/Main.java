package store;

import java.io.PrintStream;
import java.util.Scanner;

import database.DataBase;
import in.BarCodeScanner;
import out.*;

public class Main {


	
	public static void main(String[] args) {
		
		PrintStream output = new PrintStream(System.out);
		Scanner input = new Scanner(System.in);
		
		PointOfSale checkout = new PointOfSale(	new BarCodeScanner(input),
												new LCD(output), new Printer(output),
												new DataBase("data/ProductList.csv"));
		
		DataBase.ShowProductList();
//		testm t = new testm();
	//	t.ProdWasFound();
		//checkout.dbTest();
		
		Scanner in = new Scanner(System.in);
				
		while(nextCustomer(in).equals("c")){
			checkout.handleCustomer();
		}
		System.out.println("");
		in.close();
	}
	private static String nextCustomer(Scanner in){
		System.out.println("");
		System.out.println("Press c to handle customer, or other key to exit:");
		return in.nextLine();
	}

}
