package template;

import java.sql.SQLException;

import enums.MemberQuery;
import factory.DatabaseFactory;

public class ModifyQuery extends QueryTemplate{

	@Override
	void initialize() {
		String[] arr = {"password", "teamid", "roll"};
		for(int i=0; i<arr.length; i++) {
			map.put("sql"+i,
					String.format(MemberQuery.UPDATE.toString(),map.get(arr[i])));
		}
	}

	@Override
	void startPlay() {
		try {
			pstmt = DatabaseFactory
					.createDatabase2(map)
					.getConnection()
					.prepareStatement((String) map.get("sql"));
			pstmt.setString(1,map.get("password").toString());
			pstmt.setString(2,map.get("searchWord").toString());
			System.out.println("===[1]==="+map.get("password").toString());
			System.out.println("===[2]==="+map.get("searchWord").toString());
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
