package template;

import java.sql.SQLException;

import domain.MemberBean;
import enums.MemberQuery;
import factory.DatabaseFactory;

public class SearchQuery extends QueryTemplate {

	@Override
	void initialize() {
		if(map.get("searchOption")!=null) {
			map.put("sql",
	                String.format(MemberQuery.SEARCH.toString(),
	                		map.get("searchOption")));
		}else {
			map.put("sql",
					String.format(MemberQuery.LIST.toString()));
		}
	}

	@Override
	void startPlay() {
		if(map.get("searchOption")!=null) {
			try {
				pstmt = DatabaseFactory
						.createDatabase2(map)
						.getConnection()
						.prepareStatement((String)map.get("sql"));
				pstmt.setString(1,"%"+map.get("searchWord").toString()+"%");
				pstmt.setString(2, map.get("beginRow").toString());
				pstmt.setString(3, map.get("rowCount").toString());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			try {
				pstmt = DatabaseFactory
						.createDatabase2(map)
						.getConnection()
						.prepareStatement((String)map.get("sql"));
				pstmt.setString(1, (String)map.get("beginRow").toString());
				pstmt.setString(2, (String)map.get("endRow").toString());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}

	@Override
	void endPlay() {
		try {
			System.out.println("10 PstmtQuery.endPlay()");
			rs = pstmt.executeQuery();
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
				mem.setSubject(rs.getString("SUBJECT"));
				list.add(mem);
                }
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
/*!map.containsKey("column")*/	
}
