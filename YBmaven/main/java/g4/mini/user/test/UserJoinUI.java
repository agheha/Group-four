package g4.mini.user.test;

import java.util.regex.Pattern;

import org.apache.ibatis.session.SqlSession;

import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.ui.BaseUI;
import g4.mini.user.dao.UserMapper;
import g4.mini.user.domain.User;



public class UserJoinUI extends BaseUI{
	private UserMapper mapper;
	
	public UserJoinUI() {
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(UserMapper.class);
	}
	
	// 생각해야할 것 
	// 1. id에 특수문자가 들어가지 않을 것
	// 2. id가 중복되는 값은 안된다.
	// 3. 비밀번호에는 특수문자를 허용하나, 비밀번호와 비밀번호확인을 일치시킬 것
	
	public void service() {
		
		User join = new User();
		
		while(true) {
			System.out.println("------------------------");
			System.out.println("회원가입");
			System.out.println("------------------------");
			String id = getString("1. 아이디 : ");
			
			// id의 유효성 검사
			if(!Pattern.matches("^[a-zA-Z0-9]*$", id)) {
				System.out.println("아이디는 영문과 숫자만 가능합니다.");
				System.out.println("다시 입력해주세요. ");
				continue;
			};
			
			if(mapper.idMatching(id) == 1) {
				System.out.println("입력하신 아이디는 이미 있는 아이디입니다.");
				System.out.println("다시 입력해주세요. ");
				continue;
			}
			
			//조건 통과 후 아이디 새 객체에 넣기
			join.setUserId(id);
			break;
		}
		
		while(true) {
			String pass = getString("2. 비밀번호 : ");
			String pass2 = getString("3. 비밀번호확인 : ");
			
			// 비밀번호 일치한다면
			if (pass.equals(pass2)) { 
				//일치시 비밀번호 객체에 넣기
				join.setUserPass(pass);
				break;
			} else {
				System.out.println("비밀번호를 확인하세요.");
				continue;
			}
			
		}
			
			// 이름, 생년월일도 객체에 넣는다.
			join.setUserName(getString("4. 이름 : "));
			join.setUserBirth(getString("5. 생년월일 : "));
			
			
			try {
				mapper.userJoin(join);
			//	dao.userJoinDAO(join);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("회원가입이 완료 되었습니다. ");
		
	
	}
}
