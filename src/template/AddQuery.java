package template;

import java.sql.SQLException;
import domain.MemberBean;
import enums.MemberQuery;
import factory.DatabaseFactory;

public class AddQuery extends QueryTemplate {

	@Override
	void initialize() {
		map.put("sql",MemberQuery.INSERT.toString());		
	}

	@Override
	void startPlay() {
		try {
			pstmt = DatabaseFactory
					.createDatabase2(map)
					.getConnection()
					.prepareStatement((String) map.get("sql"));
			mem = (MemberBean) map.get("bean");
			System.out.println(" mem.getUserid()  : " +mem.getUserid());
			pstmt.setString(1, mem.getUserid());
			pstmt.setString(2, mem.getSsn());
			pstmt.setString(3, mem.getName());
			pstmt.setString(4, mem.getRoll());
			pstmt.setString(5, mem.getTeamid());
			pstmt.setString(6, mem.getPassword());
			pstmt.setString(7, mem.getAge());
			pstmt.setString(8, mem.getGender());
			pstmt.setString(9, mem.getSubject());
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		try {
			pstmt.executeQuery();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}		
	}
}
