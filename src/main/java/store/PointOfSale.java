package store;

import database.DataBase;
import in.BarCodeScanner;
import out.LCD;
import out.OutputDevice;
import out.Printer;
import productInfo.Product;
import productInfo.Receipt;

public class PointOfSale {
	
	private DataBase DB;
	private BarCodeScanner BCscanner;
	private OutputDevice LCDdisplay;
	private OutputDevice printer;
	
	public PointOfSale(BarCodeScanner bcs, LCD lcd, Printer p, DataBase db){
		this.BCscanner = bcs;
		this.LCDdisplay = lcd;
		this.printer = p;
		this.DB = db;
	}
	
	public void handleCustomer(){
		
		LCDdisplay.print("Input barcode or \"exit\":");
		
		String barCode = BCscanner.getBarCode();
		Receipt receipt = new Receipt();
		
		while(!barCode.equals("exit")){
			if(barCode.equals("")){
				LCDdisplay.print("Invalid bar-code. Next barcode or \"exit\":");
			} else {
				Product product = DB.findProduct(barCode);
				if(product.isEmpty()){
					LCDdisplay.print("Product not found. Next barcode or \"exit\":");	
				}else{
					receipt.addProduct(product);
					LCDdisplay.print(product);
					LCDdisplay.print("Product cashed. Next barcode or \"exit\":");
				}
			}

			barCode = BCscanner.getBarCode();
		}
		LCDdisplay.print(receipt);
		printer.print(receipt);
	}

}
