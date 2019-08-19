package ui;

import java.util.Scanner;

public abstract class BaseUI {
	protected Scanner sc = new Scanner(System.in);
	
	public abstract void service();
	
	protected String getString(String msg) {
		System.out.println(msg);
		return sc.nextLine();
	}
	protected int getInt(String msg) {
		
		return Integer.parseInt(getString(msg));
		
	}
}
