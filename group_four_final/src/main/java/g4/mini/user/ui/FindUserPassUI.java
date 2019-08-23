package g4.mini.user.ui;

import java.util.regex.Pattern;

import org.apache.ibatis.session.SqlSession;

import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.ui.BaseUI;
import g4.mini.user.account.dao.UserAccountMapper;
import g4.mini.user.dao.SendEmailDAO;
import g4.mini.vo.User;

public class FindUserPassUI extends BaseUI {
	private UserAccountMapper mapper;

	public FindUserPassUI() {
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(UserAccountMapper.class);
	}

	public void service() {
		outer: while (true) {
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("비밀번호 찾기");
			System.out.println("-------------------------------------------------------------------------------------");
			User user = new User();
			user.setUserId(getString("가입하신 아이디를 입력하세요 : "));
			inner: while (true) {
				String email = getString("가입하신 이메일을 입력하세요 : ");
				if (!Pattern.matches("^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$", email)) {
					System.out.println("알맞은 형식이 아닙니다.");
					System.out.println("다시 입력하세요. ");
				}
				user.setUserEmail(email);
				break inner;
			}

			// 아이디와 이메일로 찾은 user객체 담는다.
			User find = mapper.findUserPass(user);

			// 만약 일치하는 정보가 없어 찾은 user 없다면
			if (find == null) {
				System.out.println("입력한 정보와 일치하는 값이 없습니다.");
				System.out.println("다시 한번 확인해주세요.");
				continue outer;
			}

			String temPass = new SendEmailDAO().service(find.getUserEmail());
			find.setUserPass(temPass);

			mapper.passUpdate(find);
			break outer;
		}

	}
}
