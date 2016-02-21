package out;

import productInfo.Product;
import productInfo.Receipt;

public interface OutputDevice {
	public void print(String s);
	public void print(Product p);
	public void print(Receipt r);
}
