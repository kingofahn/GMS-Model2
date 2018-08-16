package template;

import java.sql.SQLException;

import domain.ImageBean;
import domain.MemberBean;
import enums.MemberQuery;
import enums.ImageQuery;
import factory.DatabaseFactory;

public class RetrieveQuery extends QueryTemplate {

	@Override
	void initialize() {
		switch(map.get("table").toString()) {
		case "member" :
			map.put("sql",
	                String.format(MemberQuery.RETRIEVE.toString()));
			break;
		case "image" :
			map.put("sql",
	                String.format(ImageQuery.READ.toString()));
			break;
		default :
			break;
		}
	}

	@Override
	void startPlay() {
		switch(map.get("table").toString()) {
		case "member" :
			try {
				pstmt.setString(1, (String)map.get("searchWord"));
			} catch (SQLException e1) {
				e1.printStackTrace();
			}	
			break;
		case "image" :
			try {
				pstmt.setString(1, (String)map.get("userid"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		default :
			break;
		}
	}

	@Override
	void endPlay() {
		switch(map.get("table").toString()) {
		case "member" :
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
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			break;
		case "image" :
			try {
				rs=pstmt.executeQuery();
				img = new ImageBean();
				while(rs.next()) {
					img.setImgseq(rs.getInt("IMG_SEQ"));
					img.setImgname(rs.getString("IMG_NAME"));
					img.setExtension(rs.getString("EXTENSION"));
					img.setUserid(rs.getString("USERID"));
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
