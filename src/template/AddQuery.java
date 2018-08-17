package template;

import java.sql.SQLException;

import domain.ImageBean;
import domain.MemberBean;
import enums.ImageQuery;
import enums.MemberQuery;
import factory.DatabaseFactory;

public class AddQuery extends QueryTemplate {

	@Override
	void initialize() {
		switch (map.get("table").toString()) {
		case "member":
			map.put("sql", String.format(MemberQuery.INSERT.toString()));
			break;
		case "image":
			map.put("sql", String.format(ImageQuery.UPLOAD.toString()));
			break;
		default:
			break;
		}
	}

	@Override
	void startPlay() {
		switch (map.get("table").toString()) {
		case "member":
			try {
				mem = (MemberBean) map.get("bean");
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
			break;
		case "image":
			try {
				img = (ImageBean) map.get("img");
				pstmt.setString(1, img.getImgname());
				pstmt.setString(2, img.getExtension());
				pstmt.setString(3, img.getUserid());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
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
