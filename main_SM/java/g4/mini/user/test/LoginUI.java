package g4.mini.user.test;

import org.apache.ibatis.session.SqlSession;

import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.session.LoginStatus;
import g4.mini.ui.BaseUI;
import g4.mini.user.dao.UserMapper;
import g4.mini.vo.User;

public class LoginUI extends BaseUI{
	
	private UserMapper mapper;
	
	public LoginUI() {
		SqlSession session =  MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(UserMapper.class);
	}
	
	public void service() {
		
			System.out.println("-------------------------");
			System.out.println("로그인");
			System.out.println();
			String loginId = getString("아이디 : ");
			String loginPass = getString("패스워드 : ");
			System.out.println();
			
			// 입력받은 아이디와 비밀번호를 user객체의 형태로 바꾸어 Mapper에 넣어준다.
			User u = new User();
			u.setUserId(loginId);
			u.setUserPass(loginPass);

			// Mapper를 통해 일치하는 값을 돌려받았을때의 객체를 login이라 하자.
			User login = mapper.userLogin(u);
			
			if(login != null) {
				System.out.println("로그인이 되었습니다.");
				
				// 로그인관리하는 클래스에 로그인된 객체 담아줌
				LoginStatus.login = login; 
				return;
			}
			
			// 만약 Mapper를 통해 돌려받은 값이 없을 경우 (로그인정보가 없을 경우)
			System.out.println("-------------------------");
			System.out.println("입력된 정보를 확인하여주세요.");
			System.out.println("-------------------------");
		}

	}	
		



