package template;

import java.sql.SQLException;

import domain.MemberBean;
import enums.MemberQuery;
import factory.DatabaseFactory;

public class RetrieveQuery extends QueryTemplate {

	@Override
	void initialize() {
		map.put("sql",
                String.format(MemberQuery.RETRIEVE.toString()));
	}

	@Override
	void startPlay() {
		try {
			pstmt = DatabaseFactory
					.createDatabase2(map)
					.getConnection()
					.prepareStatement((String) map.get("sql"));
			pstmt.setString(1, (String)map.get("searchWord"));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}		
	}

	@Override
	void endPlay() {
		try {
			rs = pstmt.executeQuery();
			mem = new MemberBean();
			while(rs.next()) {
				mem.setUserid(rs.getString("USERID"));
				mem.setTeamid(rs.getString("TEAMID"));
				mem.setName(rs.getString("NAME"));
				mem.setAge(rs.getString("AGE"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setGender(rs.getString("GENDER"));
				mem.setPassword(rs.getString("PASSWORD"));
				mem.setSsn(rs.getString("SSN"));
				mem.setSubject(rs.getString("SUBJECT"));
				System.out.println("쿼리 리트리버 입장" + mem.getName());
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}		
	}

}
