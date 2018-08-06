package template;

import java.sql.ResultSet;
import java.sql.SQLException;
import domain.MemberBean;
import factory.DatabaseFactory;

public class ListQuery extends QueryTemplate {

	@Override
	void initialize() {
		map.put("sql",
				String.format(" SELECT T.* " 
					+ " FROM (SELECT ROWNUM SEQ, M.* "
					+ " FROM %s M "
					+ " ORDER BY SEQ DESC) T " 
					+ " WHERE T.SEQ BETWEEN ? AND ?",
					map.get("table"),map.get("beginRow"), map.get("endRow")));
	}

	@Override
	void startPlay() {
		try {
			pstmt =DatabaseFactory
					.createDatabase2(map)
					.getConnection()
					.prepareStatement((String) map.get("sql"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		ResultSet rs;
		try {
			rs=pstmt.executeQuery();
			MemberBean mem = null;
			while(rs.next()) {
				mem = new MemberBean();
				mem.setUserid(rs.getString("USERID"));
				mem.setTeamid(rs.getString("TEAMID"));
				mem.setName(rs.getString("NAME"));
				mem.setAge(rs.getString("AGE"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setGender(rs.getString("GENDER"));
				mem.setPassword(rs.getString("PASSWORD"));
				mem.setSsn(rs.getString("SSN"));
				list.add(mem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
