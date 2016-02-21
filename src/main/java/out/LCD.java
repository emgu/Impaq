package out;

import java.io.PrintStream;

import productInfo.Product;
import productInfo.Receipt;

public class LCD implements OutputDevice{
	private PrintStream ps;
	
	public LCD(PrintStream ps){
		this.ps=ps;
	}
	@Override
	public void print(String str){
			ps.println(str);
	}
	@Override
	public void print(Product p){
		print(p.getName() + " " + p.getPrice());
	}
	@Override
	public void print(Receipt r){
		print("");
		print("Printing receipt no. " + r.getReceiptNumber());
		print("Total: " + r.getTotal());
		print("");
		
	}
}
