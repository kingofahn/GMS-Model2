package dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.MemberBean;
import enums.MemberQuery;
import enums.Vendor;
import factory.DatabaseFactory;
import pool.DBConstant;
import template.PstmtQuery;
import template.QueryTemplate;

public class MemberDAOImpl implements MemberDAO {
	private static MemberDAO instance = new MemberDAOImpl();
	public static MemberDAO getInstance() {return instance;}
	private MemberDAOImpl() {}
	@Override
	public void insert(MemberBean bean) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<MemberBean> selectSome(Map<?, ?> param) {
		HashMap<String, Object> map = new HashMap<>();
		QueryTemplate q = new PstmtQuery();
		List<MemberBean> list = new ArrayList<>();
		map.put("flag","LIST");
		map.put("beginRow",param.get("beginRow"));
		map.put("endRow",param.get("endRow"));
		map.put("table", param.get("table"));
		map.put("rowCount", param.get("rowCount"));
		map.put("searchOption", param.get("searchOption"));
		map.put("searchWord", param.get("searchWord"));
		q.play(map);
		for(Object s : q.getList()) {
			list.add((MemberBean)s);
		}
		return list;
	}
	@Override
	public MemberBean selectOne(String id) {
		HashMap<String, Object> map = new HashMap<>();
		QueryTemplate q= new PstmtQuery();
		MemberBean bean = new MemberBean();
		map.put("flag","RETRIEVE");
		map.put("searchWord", id);
		q.play(map);
		for(Object s : q.getList()) {
			bean = (MemberBean) s;
		}
		System.out.println("==================================================");
		bean.getUserid();
		System.out.println("bean.getUserid() : " + bean.getUserid());
		System.out.println(bean);
		return bean;
	}
	@Override
	public int count() {
		int count = 0;
		QueryTemplate q = new PstmtQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("flag","COUNT");
		q.play(map);
		for(Object o : q.getList()) {
			count = (int) o;
		}	
		System.out.println("==================================" + count);
		return count;
	}
	
	@Override
	public void update(Map<?, ?> param) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(MemberBean bean) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public MemberBean login(MemberBean bean) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
