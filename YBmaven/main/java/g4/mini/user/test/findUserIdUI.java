package g4.mini.user.test;

import java.util.regex.Pattern;

import org.apache.ibatis.session.SqlSession;

import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.ui.BaseUI;
import g4.mini.user.dao.UserMapper;
import g4.mini.user.domain.User;

public class findUserIdUI extends BaseUI {
	private UserMapper mapper;

	public findUserIdUI() {
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(UserMapper.class);
	}

	public void service() {
		outer: while (true) {
			System.out.println("------------------------");
			System.out.println("아이디 찾기");
			System.out.println("------------------------");

			User user = new User();
			user.setUserName(getString("이름을 입력하세요 : "));

			inner: while (true) {
				String phone = getString("가입하신 휴대전화 번호를 입력하세요 : ");
				if (!Pattern.matches("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$", phone)) {
					System.out.println("숫자만 입력 가능합니다.");
					System.out.println("다시 입력해주세요. ");
					continue inner;
				}
				user.setUserPH(phone);
				break inner;
			}

			User find = mapper.findUserId(user);
			if (find == null) {
				System.out.println("입력한 정보와 일치하는 값이 없습니다.");
				System.out.println("다시 한번 확인해주세요.");
				continue outer;
			}

			System.out.println("가입하신 아이디는 ");
			System.out.println(find.getUserId());
			System.out.println("입니다.");
			break outer;
		}
	}
}
