package out;

import java.io.PrintStream;
import java.util.List;

import printbale.Printable;
import printbale.Product;

public class Printer implements OutputDevice{
	private PrintStream ps;
	
	public Printer(PrintStream ps){
		this.ps=ps;
	}
	@Override
	public void print(Printable recipt) {
		
		ps.println("");
		ps.println("----- Printer  -----");
		ps.println("");
		ps.println("Receipt no. " + recipt.getReceiptNumber());
		ps.println("");
		
		List<Product> pList = recipt.getProductList();
		for(Product p : pList){
			ps.println(p.getBarCode() + " " + p.getName() + " " + p.getPrice());
		}
		ps.println("");
		ps.println("Total: " + Product.roundPrice(recipt.getTotal(), 2));
		ps.println("");
		ps.println("--------------------");
	}
}
