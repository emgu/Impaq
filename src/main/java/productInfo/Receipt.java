package productInfo;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
	private static int receiptNumber = 0;
	private List<Product> productList;
	private double total;
	
	public Receipt(){
		receiptNumber++;
		this.productList = new ArrayList<>();
		this.total = 0.00;
	}
	
	public void addProduct(Product p){
		if(p != null){
			this.productList.add(p);
			this.total = Product.roundPrice(this.total + p.getPrice());
		}
	}
	
	public int getReceiptNumber(){
		return Receipt.receiptNumber;
	}
	
	public List<Product> getProductList(){
		return this.productList;
	}
	
	public double getTotal(){
		return this.total;
	}
}
