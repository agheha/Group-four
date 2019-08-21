package g4.mini.user.common.db;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// mybatis의 관련된 환경설정정보가 들어있는 sqlMapConfig.xml 파일을 한번! 로딩하는 역학을 한다.

public class MyAppSqlConfig {  // 마이바티스 전체 환경과 관련된 정보를 메모리에 로딩하는 역할의 클래스
	
	private static final SqlSession sqlMapper;  // 바깥에서 쓰기위해 멤버로 올려준다.
	
	static {  // 딱 한번 로딩
		try {
			String resource = "config/mybatis/sqlMapConfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlFactory = new SqlSessionFactoryBuilder().build(reader);
//			sqlMapper = sqlFactory.openSession();   
			sqlMapper = sqlFactory.openSession(true);  // 자동커밋됨 
 		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
					"Error initializing MyAppSqlConfig class. Cause: " + e);
		}
	}

	public static SqlSession getSqlSessionInstance() {       //sqlSession이라는 것을 이제 DAO가 사용하게 된다. 실제 필요한 것이다.
		return sqlMapper;
	}
}