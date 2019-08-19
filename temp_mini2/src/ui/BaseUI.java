package ui;

import java.util.Scanner;

public abstract class BaseUI {
	private Scanner sc = new Scanner(System.in);
	
	public abstract void service();
	
	public int getInt(String msg) {
		System.out.print(msg);
		return Integer.parseInt(getString(msg));
	}
	
	public String getString(String msg) {
		System.out.print(msg);
		return sc.nextLine();
	}
	
	
}
