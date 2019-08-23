package g4.mini.store.ui;

import java.util.regex.Pattern;

import org.apache.ibatis.session.SqlSession;

import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.store.dao.StoreMapper;
import g4.mini.ui.BaseUI;
import g4.mini.vo.Store;

public class StoreJoinUI extends BaseUI {

	private StoreMapper mapper;

	public StoreJoinUI() {
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(StoreMapper.class);
	}

	// 생각해야할 것
	// 1. id에 특수문자가 들어가지 않을 것
	// 2. id가 중복되는 값은 안된다.
	// 3. 비밀번호에는 특수문자를 허용하나, 비밀번호와 비밀번호확인을 일치시킬 것
	Store sto = new Store();
	
	public void service() {

		while (true) {
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("가게 회원가입");
			System.out.println("-------------------------------------------------------------------------------------");
			String stoId = getString("1. 아이디 : ");

			// id의 유효성 검사
			if (!Pattern.matches("^[a-zA-Z0-9]*$", stoId)) {
				System.out.println("아이디는 영문과 숫자만 가능합니다.");
				System.out.println("다시 입력해주세요. ");
				continue;
			}
			if (mapper.idMatching(stoId) == 1) {
				System.out.println("입력하신 아이디는 이미 있는 아이디입니다.");
				System.out.println("다시 입력해주세요. ");
				continue;
			}

			// 조건 통과 후 아이디 새 객체에 넣기
			sto.setStoId(stoId);
			break;
		}

		while (true) {
			String pass = getString("2. 비밀번호 : ");
			String pass2 = getString("3. 비밀번호확인 : ");

			// 비밀번호 일치한다면
			if (pass.equals(pass2)) {
				// 일치시 비밀번호 객체에 넣기
				sto.setStoPass(pass);
				break;
			} else {
				System.out.println("비밀번호를 확인하세요.");
				continue;
			}

		}
		sto.setStoName(getString("4. 가게이름 : "));
		sto.setRstMenu(getString("5. 대표메뉴 : "));
		sto.setRstPrice(getInt("6. 대표메뉴 가격 : "));
		sto.setStoType(getString("7. 가게종류(중식,한식,일식,양식,패스트푸드) : "));
		sto.setBitDistance(getInt("8. 비트캠프와 거리 : "));
		sto.setStoAddr(getString("9. 주소 : "));
		sto.setStoHours(getString("10. 영업시간을 입력하세요(ex : 00:00~00:00)  : "));
		sto.setStoPhoneNumber(getString("11. 전화번호(ex : 00-0000-0000) : "));
		sto.setStoSeat(getInt("12. 총 좌석수 : "));
		System.out.println("");
		try {
			mapper.storeJoin(sto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("회원가입이 완료 되었습니다. ");
		new StoreUI().service();

	}
}