package template;

import java.sql.SQLException;

import domain.MemberBean;
import enums.MemberQuery;
import factory.DatabaseFactory;

public class LoginQuery extends QueryTemplate {

	@Override
	void initialize() {
		map.put("sql",
				String.format(MemberQuery.LOGIN.toString()));
	}

	@Override
	void startPlay() {
		try {
			pstmt = DatabaseFactory
					.createDatabase2(map)
					.getConnection()
					.prepareStatement((String) map.get("sql"));
			o = (MemberBean)map.get("bean");
			pstmt.setString(1,((MemberBean) o).getUserid());
			pstmt.setString(2,((MemberBean) o).getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	void endPlay() {
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				mem = new MemberBean();
                mem.setUserid(rs.getString("userid"));
                mem.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
