package manager.ui;

import java.util.Scanner;

import manager.dao.ManagerStoreDAO;
import manager.storeui.DeleteStoreUI;
import manager.storeui.ListStoreUI;
import manager.storeui.UpdateStoreUI;
import manager.storeui.WriteStoreUI;
import manager.userui.ManagerUserUI;

public class ManagerUI extends BaseUI{
	
	Scanner sc = new Scanner(System.in);
	
	ManagerUserUI userUI = new ManagerUserUI();
	
	ManagerStoreDAO storeDao = new ManagerStoreDAO(); 
	
	public void service() {
		BaseUI ui = null;
		while(true) {
			switch (menu()) {
			case 1 : ui = new ListStoreUI(storeDao); break;
			case 2 : ui = new ListStoreUI(storeDao); break;
			case 3 : ui = new ListStoreUI(storeDao); break;
			case 4 : ui = new ListStoreUI(storeDao); break;
			case 5 : ui = new WriteStoreUI(storeDao); break;
			case 6 : ui = new UpdateStoreUI(storeDao); break;
			case 7 : ui = new DeleteStoreUI(storeDao); break;
			case 0 : exit();
				default :
					System.out.println("해당하는 번호를 찾을수 없습니다.");
					System.out.println("번호를 다시 입력해주세요.");
			}
			if (ui != null) ui.service(); 
		}
	}
	
	public int menu() {
		System.out.println("=========================================");
		System.out.println("1. 회원 전체 조회");
		System.out.println("2. 회원 수정");
		System.out.println("3. 회원 삭제");
		System.out.println("4. 스토어 전체 조회");
		System.out.println("5. 스토어 추가");
		System.out.println("6. 스토어 수정");
		System.out.println("7. 스토어 삭제");
		System.out.println("0. 종료");
		System.out.println("=========================================");
		System.out.print("메뉴를 선택해 주세요.");
		return Integer.parseInt(sc.nextLine());
	}
	
	void exit() {
		System.exit(0);
	}
}
