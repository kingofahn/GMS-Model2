package template;

import java.sql.SQLException;

import enums.MemberQuery;
import factory.DatabaseFactory;

public class CountQuery extends QueryTemplate {

	@Override
	void initialize() {
		map.put("sql", MemberQuery.COUNT.toString());
		;		
	}

	@Override
	void startPlay() {
			pStmtInit();
	}

	@Override
	void endPlay() {
		number=0;
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				number=(rs.getInt("count"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
