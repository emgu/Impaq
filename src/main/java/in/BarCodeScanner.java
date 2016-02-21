package in;

import java.util.Scanner;

public class BarCodeScanner {
	private Scanner scan;

	public BarCodeScanner(Scanner scan){
		this.scan = scan;
	}
	
	public String getBarCode(){
		return scan.nextLine();
	}
}
