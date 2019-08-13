package manager.ui;

import java.util.Scanner;

public abstract class BaseUI {
	protected Scanner sc = new Scanner(System.in);
	
	public abstract void service();
	
	protected int getInt(String msg) {
		return Integer.parseInt(sc.nextLine());
	}
	
	protected String getString(String msg) {
		System.out.println(msg);
		return sc.nextLine();
	}
	
}
