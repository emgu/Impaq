package in;

import java.util.Scanner;

public class BarCodeScanner {
	private static Scanner scan = new Scanner(System.in);

	public String getBarCode(){
		return scan.nextLine();
	}
	
}
