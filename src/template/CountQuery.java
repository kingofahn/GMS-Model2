package template;

import java.sql.SQLException;

import enums.MemberQuery;
import factory.DatabaseFactory;

public class CountQuery extends QueryTemplate {

	@Override
	void initialize() {
		map.put("sql", (map.get("searchOption")==null)?
				MemberQuery.COUNT.toString():String.format(MemberQuery.CONDITIONCOUNT.toString(), map.get("searchOption")));
		System.out.println("sql : " + map.get("sql"));
		System.out.println("searchOption : " + map.get("searchOption"));
		System.out.println("searchWord : " + map.get("searchWord"));
	}

	@Override
	void startPlay() {
		try {
			if(map.get("searchOption")!=null) {
				pstmt.setString(1,"%"+map.get("searchWord")+"%");
				System.out.println("searchWord : " + map.get("searchWord"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
