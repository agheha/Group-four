package g4.mini.admin.ui;

import org.apache.ibatis.session.SqlSession;

import g4.mini.admin.dao.AdministratorMapper;
import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.reservation.ui.CheckReservationUI;
import g4.mini.store.list.ui.StoreListUI;
import g4.mini.ui.BaseUI;
import g4.mini.user.account.ui.InfoUserUI;

public class StoInfoUpdateUI extends BaseUI {

	private AdministratorMapper mapper;

	public StoInfoUpdateUI() {
		SqlSession session =  MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(AdministratorMapper.class);
	}
	
	public void service() {
		
	}

	
}
