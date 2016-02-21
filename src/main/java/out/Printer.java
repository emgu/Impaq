package out;

import java.io.PrintStream;
import java.util.List;

import productInfo.Product;
import productInfo.Receipt;

public class Printer implements OutputDevice{
	private PrintStream ps;
	
	public Printer(PrintStream ps){
		this.ps=ps;
	}
	
	@Override
	public void print(String s) {
		ps.println(s);
	}
	@Override
	public void print(Product p) {
		ps.println(p.getName() + " " + p.getPrice());
	}
	@Override
	public void print(Receipt recipt) {
		
		print("Receipt no. " + recipt.getReceiptNumber());
		print("");
		
		List<Product> pList = recipt.getProductList();
		for(Product p : pList){
			print(p);;
		}
		print("");
		print("Total: " + Product.roundPrice(recipt.getTotal(), 2));
		print("");

	}	
}
