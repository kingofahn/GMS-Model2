package template;

import java.sql.SQLException;

import domain.MemberBean;
import enums.MemberQuery;

public class UpdateQuery extends QueryTemplate {

	@Override
	void initialize() {
		map.put("sql", String.format(MemberQuery.UPDATE.toString()));
	}

	@Override
	void startPlay() {
		 try {
			mem = (MemberBean) map.get("user");
			pstmt.setString(1, mem.getPassword());
			pstmt.setString(2, mem.getTeamid());
			pstmt.setString(3, mem.getRoll());
			pstmt.setString(4, mem.getUserid());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
