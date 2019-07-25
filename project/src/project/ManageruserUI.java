package project;

import java.util.Scanner;



public class ManageruserUI {
	Scanner sc = new Scanner(System.in);
	ManageruserDAO userDao = new ManageruserDAO();
	
	public void userSelect() {
		Manageruser[] userList = userDao.selectUser();
		
		System.out.println("전체 " + userList.length + "명");
		System.out.println("=========================================");
		if (userList.length == 0) {
			System.out.println("회원 정보가 존재하지 않습니다.");
			return;
		}
		for (int i = userList.length - 1 ; i >= 0; i--) {
			Manageruser user = userList[i];
			System.out.printf(
					"회원번호 : %-3d\n아이디 : %-15s\n비밀번호 : %-10s\n이름 : %-5s\n생년월일 : %-6s\n주소 : %-20s\n", 
					user.getUserNum(), user.getId(), user.getPass(), user.getName(),user.getBirth(),user.getAddr());
		}
		System.out.println("=========================================");	
		}

	
	
	public void userUpdate() {
		System.out.print("수정할 회원번호를 입력하세요 : ");
		int no = Integer.parseInt(sc.nextLine());
		Manageruser user = userDao.selectOneUser(no);
		if (user == null) {
			System.out.println("해당 번호는 존재하지 않습니다.");
			return;
		}
		// 글번호가 존재할때 사용자에게 수정할 내용을 받는다.
		System.out.print("아이디를 입력하세요 : ");
		user.setId(sc.nextLine());
		System.out.print("비밀번호를 입력하세요 : ");
		user.setPass(sc.nextLine());
		System.out.print("이름을 입력하세요 : ");
		user.setName(sc.nextLine());
		System.out.print("생일을 입력하세요 : ");
		user.setBirth(sc.nextLine());
		System.out.print("주소를 입력하세요 : ");
		user.setAddr(sc.nextLine());
		
		userDao.UpdateUser(user);
		
		System.out.println();
		System.out.println("회원정보가 수정되었습니다.");	
	}
	
	public void userDelete() {
		System.out.print("삭제할 회원번호를 입력하세요 : ");
		int no = Integer.parseInt(sc.nextLine());
		int result = userDao.deleteUser(no);
		if (result == 1) {
			System.out.println();
			System.out.println("회원정보가 삭제되었습니다.");
			return;
		}
		System.out.println("해당 번호는 존재하지 않습니다.");
	}
}
	

	


