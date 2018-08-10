package template;

import java.sql.SQLException;

import enums.MemberQuery;
import factory.DatabaseFactory;

public class ModifyQuery extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql",MemberQuery.UPDATE.toString());
	}

	@Override
	void startPlay() {
		try {
			pstmt = DatabaseFactory
					.createDatabase2(map)
					.getConnection()
					.prepareStatement((String) map.get("sql"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		try {
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
