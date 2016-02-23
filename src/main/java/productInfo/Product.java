package productInfo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {
	private String productBarCode;
	private String productName;
	private double productPrice;
	
	public Product(){
		this.productBarCode = "";
		this.productName = "";
		this.productPrice = 0.0;
	}
	public Product(String pBarCode, String pName, double pPrice){
		this.productBarCode = pBarCode;
		this.productName = pName;
		this.productPrice = Math.abs(Product.roundPrice(pPrice));
	}
	
	public String getBarCode(){
		return this.productBarCode;
	}
	public String getName(){
		return this.productName;
	}
	public double getPrice(){
		return this.productPrice;
	}
	public boolean isEmpty() {
		return (this.productBarCode.equals("") && 
				this.productName.equals("") &&
				this.productPrice == 0.0);
	}
	public static double roundPrice(double value) {
	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(2, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
}
