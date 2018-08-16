package enums;
public enum ImageQuery {
	READ, 
	UPLOAD
	;
	public String toString() {
		String sql = "";
		switch(this) {
		case READ :
			sql = 
				"SELECT " 
				+ " IMG_SEQ, IMG_NAME, EXTENSION, USERID " 
				+ " FROM IMAGE " 
				+ " WHERE USERID LIKE ?"
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





