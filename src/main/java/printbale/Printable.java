package printbale;

import java.util.ArrayList;
import java.util.List;

public abstract class Printable {

	public int getReceiptNumber() { return 0; };
	public List<Product> getProductList() { return new ArrayList<Product>(); };
	public double getTotal() { return 0.0; };

	public String getBarCode() { return ""; }
	public String getName() { return ""; }
	public double getPrice() { return 0.0; }
	
}
