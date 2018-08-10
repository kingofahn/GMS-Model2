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
		case "INSERT" :
			map.put("sql",MemberQuery.INSERT.toString());
			System.out.println("sql : " + map.get("sql"));
			break;
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
		case "INSERT" :
			try {
				pstmt = DatabaseFactory
						.createDatabase2(map)
						.getConnection()
						.prepareStatement((String) map.get("sql"));
				pstmt.setString(1, map.get("userid").toString());
				pstmt.setString(2, map.get("ssn").toString());
				pstmt.setString(3, map.get("name").toString());
				pstmt.setString(4, map.get("roll").toString());
				pstmt.setString(5, map.get("teamid").toString());
				pstmt.setString(6, map.get("password").toString());
				pstmt.setString(7, map.get("age").toString());
				pstmt.setString(8, map.get("gender").toString());
				pstmt.setString(9, map.get("subject").toString());
				System.out.println("pstmt.executeUpdate()" + pstmt.executeUpdate());
				/*pstmt.setString(9, map.get("subject").toString());*/
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			break;
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
		MemberBean mem = null;
		switch(map.get("flag").toString()) {
		case "INSERT":
			try {
				pstmt.executeQuery();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			break;
		case "LIST":
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
			break;
		case "RETRIEVE" :
			try {
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
