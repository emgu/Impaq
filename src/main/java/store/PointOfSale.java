package store;

import database.DataBase;
import in.BarCodeScanner;
import out.LCD;
import out.Printer;
import printbale.Product;
import printbale.Receipt;

public class PointOfSale {
	
	private DataBase DB;
	private BarCodeScanner BCscanner;
	private LCD LCDdisplay;
	private Printer printer;
	
	public PointOfSale(BarCodeScanner bcs, LCD lcd, Printer p, DataBase db){
		this.BCscanner = bcs;
		this.LCDdisplay = lcd;
		this.printer = p;
		this.DB = db;
	}
	
	public void handleCustomer(){
		
		LCDdisplay.print("----- LCD -----");
		LCDdisplay.print("type next bar code or \"exit\" to print receipt");
		
		String barCode = BCscanner.getBarCode();
		//Product product = new Product();
		Receipt receipt = new Receipt();
		
		while(!barCode.equals("exit")){
			if(barCode.equals("")){
				LCDdisplay.print("Invalid bar-code");
				LCDdisplay.print("---------------");
			} else {
				Product product = DB.findProduct(barCode);
				if(product.isEmpty()){
					LCDdisplay.print("Product not found");	
					LCDdisplay.print("---------------");
				}else{
					receipt.addProduct(product);
					LCDdisplay.print(product);
					LCDdisplay.print("---------------");
				}
			}
			LCDdisplay.print("----- LCD -----");
			LCDdisplay.print("type next bar code or \"exit\" to print receipt");
			barCode = BCscanner.getBarCode();
		}
		LCDdisplay.print("---------------");
		
		printer.print(receipt);
	}
	public int test(int a){
		System.out.println(a);
		return a+10;

	}
}
