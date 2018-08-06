package enums;

public enum MemberQuery {
	LOGIN,INSERT_MEMBER,FINDBYID,COUNT_MEMBER,UPDATE_MEMBER,DELETE_MEMBER, SELECT_ALL, SELECT_SOME, SELECT_LIST;
	public String toString() {
		String query = "";
		switch(this) {
		case LOGIN :
			query = 
			"      SELECT USERID,"
			+ "    TEAMID,      "
			+ "    NAME,  "
			+ "    SSN,   "
			+ "    ROLL,  "
			+ "    PASSWORD      "
			+ "    FROM MEMBER          "
			+ "    WHERE USERID LIKE '%s' AND PASSWORD LIKE '%s'           ";
			break;
		case INSERT_MEMBER : 
			query =	
			"     INSERT INTO MEMBER "
			+ "    (USERID,TEAMID,NAME,AGE,ROLL,PASSWORD,SSN,GENDER)   "
			+ "   VALUES ('%s','%s','%s','%s','%s','%s','%s','%s') ";		
			break;
		case FINDBYID : 
			query =
             "    SELECT USERID,TEAMID,NAME,AGE,ROLL,PASSWORD,SSN,GENDER"
           + "    FROM MEMBER          "
           + "    WHERE USERID LIKE '%s' ";		
			break;
		case COUNT_MEMBER : 
			query =
             "      SELECT COUNT(*) COUNT FROM MEMBER";		
			break;
		case UPDATE_MEMBER : 
			query =
             "      UPDATE MEMBER		" 
			+"		SET PASSWORD = '%s', TEAMID = '%s', ROLL = '%s'	" 
            +"		WHERE USERID LIKE '%s'	";		
			break;
			// test
		case DELETE_MEMBER : 
			query =
			"	DELETE FROM MEMBER "
			+ " WHERE USERID LIKE '%s'"
			+ " AND PASSWORD LIKE '%s'";
			break;		
		case SELECT_ALL : 
			query =
			"	SELECT USERID,TEAMID,NAME,AGE,ROLL,PASSWORD,SSN,GENDER FROM MEMBER "; 
			break;
/*		case SELECT_LIST : 
			query =
					" SELECT T.* " 
					+ " FROM (SELECT ROWNUM SEQ, M.* "
					+ " FROM MEMBER M "
					+ " ORDER BY SEQ DESC) T " 
					+ " WHERE T.SEQ BETWEEN %s AND %s ";
			break;	*/
/*		case SELECT_SOME : 
			query =
			"	SELECT USERID,TEAMID,NAME,AGE,ROLL,PASSWORD,SSN,GENDER FROM MEMBER "
			+ " WHERE %s LIKE '%%%s%%'   "; 
			break;	*/	
		}
		return query;
	}
}





