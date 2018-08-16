package template;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import domain.ImageBean;
import domain.MemberBean;
import enums.Vendor;
import factory.DatabaseFactory;
import lombok.Data;
import pool.DBConstant;

@Data
public abstract class QueryTemplate {
	int number;
	Object o;
	List<Object> list;
	Map<String,Object> map;
	PreparedStatement pstmt;
	ResultSet rs = null;
	MemberBean mem;
	ImageBean img;
	
	public final void play(Map<?,?> param) {
		this.number = 0;
		this.o = null;
		this.list = new ArrayList<>();
		this.map = new HashMap<>();
		this.pstmt = null;
		this.mem = null;
		this.map.put("vendor",Vendor.ORACLE);
		this.map.put("username", DBConstant.USERNAME);
		this.map.put("password", DBConstant.PASSWORD);
		Iterator<?> keys = param.keySet().iterator();
		while(keys.hasNext()){
			String key = (String) keys.next();
			this.map.put(key, param.get(key)) ;
		}
		initialize();
		pStmtInit();
		startPlay();
		endPlay();
	}
	
	public void pStmtInit() {
		try {
			this.pstmt = DatabaseFactory
					.createDatabase(map)
					.getConnection()
					.prepareStatement((String) map.get("sql"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
		
	public final void play() {
		this.number = 0;
		this.pstmt = null;
		this.map = new HashMap<>();
		this.map.put("vendor",Vendor.ORACLE);
		this.map.put("username", DBConstant.USERNAME);
		this.map.put("password", DBConstant.PASSWORD);
		initialize();
		pStmtInit();
		startPlay();
		endPlay();
		}	
		abstract void initialize();
		abstract void startPlay();
		abstract void endPlay();
}
