package enums;

import template.ColumnFinder;

public enum MemberQuery {
	INSERT,
	LIST,SEARCH,RETRIEVE,COUNT,
	UPDATE,
	DELETE,
	LOGIN, 
	UPLOAD
	;
	public String toString() {
		String sql = "";
		switch(this) {
		case INSERT : 
			sql =	
			"  INSERT INTO MEMBER ("
			+ ColumnFinder.find(Domain.MEMBER)
			+ ")"
			+ "   VALUES "
			+ " (?,?,?,?,?,?,?,?,?) ";		
			break;
		case LIST : 
			sql =
			"	SELECT T.* "
			+"  FROM (SELECT ROWNUM SEQ, M.* "
			+" FROM MEMBER M " 
			+" ORDER BY SEQ DESC) T "
			+" WHERE T.SEQ BETWEEN ? AND ? ";
			break;
		case SEARCH : 
			sql =
			"	SELECT T.* "
			+"  FROM (SELECT ROWNUM SEQ, M.* "
			+" FROM MEMBER M " 
			+" WHERE %s LIKE ? "
			+" ORDER BY SEQ DESC) T "
			+" WHERE T.SEQ BETWEEN ? AND ? ";
			break;
			
		case RETRIEVE : 
			sql =
            "select * " 
            + " FROM MEMBER " 
            + " WHERE USERID " 
            + " LIKE ? ";
			break;
			
		case COUNT : 
			sql =  
				" SELECT COUNT(*) AS COUNT "
			    +" FROM MEMBER ";		
			break;

		case UPDATE : 
			sql =
	             "  UPDATE		" 
				+"	MEMBER SET %s = ? "
	            +"	WHERE USERID LIKE ?	"
				;		
			break;
			
		case DELETE : 
			sql =
				"	DELETE "
				+ " FROM MEMBER "
				+ " WHERE USERID LIKE ? "
				+ " AND PASSWORD LIKE ? "
				;
			break;		
			
		case LOGIN :
			sql = 
				"select " 
				+ ColumnFinder.find(Domain.MEMBER) 
				+ " FROM MEMBER "
				+ " WHERE USERID LIKE ? "
				+ " AND PASSWORD LIKE ? "
			;
			break;
			
		case UPLOAD :
			sql = 
				" INSERT INTO IMAGE(IMG_SEQ,IMG_NAME,EXTENSION, USERID) "
				+ " VALUES (IMG_SEQ.NEXTVAL,?,?,?) "
			;
			break;
		}
		return sql;
	}
}





