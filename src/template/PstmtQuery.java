package template;

import java.sql.ResultSet;
import java.sql.SQLException;
import domain.MemberBean;
import enums.Domain;
import factory.DatabaseFactory;

public class PstmtQuery extends QueryTemplate {

	@Override
    void initialize() {
        map.put("sql",
                String.format("select " + ColumnFinder.find(Domain.MEMBER) 
                + " FROM %s " 
                + " WHERE %s " 
                + " LIKE ? ",
                        map.get("table"), map.get("column")));
    }
	
	@Override
	void startPlay() {
		try {
			pstmt = DatabaseFactory
					.createDatabase2(map)
					.getConnection()
					.prepareStatement((String)map.get("sql"));
			System.out.println("(String)map.get(\"sql\")" + (String)map.get("sql"));
			System.out.println("map.get(\"value\").toString() : "+map.get("value").toString());
			pstmt.setString(1, 
					"%"+map.get("value").toString()+"%");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	void endPlay() {
		ResultSet rs;
		try {
			rs = pstmt.executeQuery();
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
