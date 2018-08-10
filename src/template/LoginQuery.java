package template;

import java.sql.SQLException;

import domain.MemberBean;
import enums.MemberQuery;
import factory.DatabaseFactory;

public class LoginQuery extends QueryTemplate {

	@Override
	void initialize() {
		map.put("sql",
				String.format(MemberQuery.LOGIN.toString()));
	}

	@Override
	void startPlay() {
		try {
			pstmt = DatabaseFactory
					.createDatabase2(map)
					.getConnection()
					.prepareStatement((String) map.get("sql"));
			mem = (MemberBean) map.get("bean");
			pstmt.setString(1,mem.getUserid());
			pstmt.setString(2,mem.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	void endPlay() {
		
	}

}
