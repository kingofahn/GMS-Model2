package template;

import java.sql.ResultSet;
import java.sql.SQLException;
import domain.MemberBean;
import enums.MemberQuery;
import factory.DatabaseFactory;

public class PstmtQuery extends QueryTemplate {
	@Override
    void initialize() {
		switch(map.get("flag").toString()) {
		case "LIST" :
			if(map.get("searchOption")!=null) {
				map.put("sql",
		                String.format(MemberQuery.SEARCH.toString(),
		                		map.get("searchOption")));
			}else {
				map.put("sql",
						String.format(MemberQuery.LIST.toString()));
			}
			break;
		case "RETRIEVE" :
			map.put("sql",
	                String.format(MemberQuery.RETRIEVE.toString()));
			System.out.println("sql : " + map.get("sql"));
			break;
		case "COUNT" : 	
			map.put("sql", MemberQuery.COUNT.toString());
			;
			break;
		default :	;
			break;
		}
	}
		
	
	@Override
	void startPlay() {
		switch(map.get("flag").toString()) {
		case "LIST" :
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
			break;
		case "RETRIEVE" :
			try {
				pstmt = DatabaseFactory
						.createDatabase2(map)
						.getConnection()
						.prepareStatement((String) map.get("sql"));
				pstmt.setString(1, (String)map.get("searchWord").toString());
				System.out.println("map.get(\"searchWord\") : " + map.get("searchWord"));
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			break;
		case "COUNT" : 	
			try {
				pstmt = DatabaseFactory
						.createDatabase2(map)
						.getConnection()
						.prepareStatement((String) map.get("sql"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		default :	;
			break;
		}
	}
	
	@Override
	void endPlay() {
		ResultSet rs;
		switch(map.get("flag").toString()) {
		case "LIST":
			try {
				System.out.println("10 PstmtQuery.endPlay()");
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
					mem.setSubject(rs.getString("SUBJECT"));
					list.add(mem);
	                }
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "RETRIEVE" :
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
					mem.setSubject(rs.getString("SUBJECT"));
					list.add(mem);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			break;
		case "COUNT": 
			try {
				rs = pstmt.executeQuery();
				while(rs.next()) {
					list.add(rs.getInt("count"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		default : 
			break;
		}
	}
}
