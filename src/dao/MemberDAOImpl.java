package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.MemberBean;
import enums.Domain;
import enums.MemberQuery;
import enums.Vendor;
import factory.DatabaseFactory;
import pool.DBConstant;
import template.ListQuery;
import template.PstmtQuery;
import template.QueryTemplate;

public class MemberDAOImpl implements MemberDAO {
	private static MemberDAO instance = new MemberDAOImpl();
	public static MemberDAO getInstance() {return instance;}
	private MemberDAOImpl() {}
	
	@Override
	public void insertMember(MemberBean member) {
		try {
			DatabaseFactory.createDatabase(
					Vendor.ORACLE, 
					DBConstant.USERNAME, 
					DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeUpdate(
							String.format(MemberQuery.INSERT_MEMBER.toString(),
						              member.getUserid(),
						              member.getTeamid(),
						              member.getName(),
						              member.getAge(),
						              member.getRoll(),
						              member.getPassword(), 
						              member.getSsn(),
						              member.getGender()
						              ));
		} catch (Exception e) {   
			e.printStackTrace();
		}
	}
	
	@Override
	public List<MemberBean> selectMemberBySearchWord(String word) {
		QueryTemplate q = new PstmtQuery();
		List<MemberBean> list = new ArrayList<>();
		HashMap<String,Object> map = new HashMap<>();
		map.put("column", word.split("/")[0]);
        map.put("value", word.split("/")[1]);
        map.put("table", Domain.MEMBER);
		q.play(map);
		for(Object s : q.getList()) {
			list.add((MemberBean)s);
		}
		return list;
	}
	@Override
	public List<MemberBean> selectList(Map<?, ?> param) {
		QueryTemplate q = new ListQuery();
		List<MemberBean> list = new ArrayList<>();
		HashMap<String,Object> map = new HashMap<>();
		map.put("beginRow", param.get("beginRow"));
        map.put("endRow", param.get("endRow"));
        map.put("table", Domain.MEMBER);
        q.play(map);
        for(Object s: q.getList()) {
        	list.add((MemberBean)s);
        }
		return list;
	}
	
	
/*	public List<MemberBean> selectList(Map<?, ?> param) {
		List<MemberBean> lst = new ArrayList<>();
		try {
			ResultSet rs = DatabaseFactory.createDatabase(
					Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(String.format(MemberQuery.SELECT_LIST.toString(),param.get("beginRow"),
																	param.get("endRow")));
			
			MemberBean mem =null;
			while(rs.next()) {
				mem = new MemberBean();
				mem.setUserid(rs.getString("USERID"));
				mem.setTeamid(rs.getString("TEAMID"));
				mem.setName(rs.getString("NAME"));
				mem.setAge(rs.getString("AGE"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setGender(rs.getString("GENDER"));
				mem.setPassword(rs.getString("PASSWORD"));
				mem.setSsn(rs.getString("SSN"));
				lst.add(mem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}*/
	
	
	@Override
	public List<MemberBean> selectAllmemberList() {
		List<MemberBean> lst = new ArrayList<>();
		try {
			ResultSet rs = DatabaseFactory.createDatabase(
					Vendor.ORACLE, DBConstant.USERNAME,DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(MemberQuery.SELECT_ALL.toString());
			MemberBean mem =null;
			while(rs.next()) {
				mem = new MemberBean();
				mem.setUserid(rs.getString("USERID"));
				mem.setTeamid(rs.getString("TEAMID"));
				mem.setName(rs.getString("NAME"));
				mem.setAge(rs.getString("AGE"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setGender(rs.getString("GENDER"));
				mem.setPassword(rs.getString("PASSWORD"));
				mem.setSsn(rs.getString("SSN"));
				lst.add(mem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lst;
	}

	
	@Override
	public int countMember() {
		int count = 0;
		try {
			ResultSet rs =  DatabaseFactory.createDatabase(
					Vendor.ORACLE, 
					DBConstant.USERNAME, 
					DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(String.format(MemberQuery.COUNT_MEMBER.toString()));
			while(rs.next()) {
				count = rs.getInt("count");
				System.out.println("rs.getInt(Count) : " + rs.getInt("count") );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	@Override
	public MemberBean selectFindById(String id) {
		MemberBean mem = null;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(
					Vendor.ORACLE, 
					DBConstant.USERNAME, 
					DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(
							String.format(MemberQuery.FINDBYID.toString(),
						              id));
			while(rs.next()) {
				mem = new MemberBean();
				mem.setUserid(rs.getString("USERID"));
				mem.setTeamid(rs.getString("TEAMID"));
				mem.setName(rs.getString("NAME"));
				mem.setAge(rs.getString("AGE"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setGender(rs.getString("GENDER"));
				mem.setPassword(rs.getString("PASSWORD"));
				mem.setSsn(rs.getString("SSN"));
                }
			
		} catch (Exception e) {   
			e.printStackTrace();
		}
	return mem;
	}
	@Override
	public void updateMemberInformation(MemberBean member) {
		try {
		DatabaseFactory.createDatabase(
				Vendor.ORACLE, 
				DBConstant.USERNAME, 
				DBConstant.PASSWORD)
				.getConnection()
				.createStatement()
				.executeUpdate(
						String.format(MemberQuery.UPDATE_MEMBER.toString(),
								member.getPassword(), member.getTeamid(),member.getRoll(),member.getUserid()));		
		} catch (Exception e) {  
			e.printStackTrace();
		}
	}
	@Override
	public void deleteMemberInformation(MemberBean member) {
		try {
			DatabaseFactory.createDatabase(
					Vendor.ORACLE, 
					DBConstant.USERNAME, 
					DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeUpdate(String.format(
							MemberQuery.DELETE_MEMBER.toString(),member.getUserid(),member.getPassword()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	@Override
	public MemberBean login(MemberBean member) {
		MemberBean mem = null;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(
					Vendor.ORACLE, 
					DBConstant.USERNAME, 
					DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(
							String.format(MemberQuery.LOGIN.toString(),
						              member.getUserid(),member.getPassword()));
			
			while(rs.next()) {
				mem = new MemberBean();
				mem.setUserid(rs.getString("USERID"));
				mem.setTeamid(rs.getString("TEAMID"));
				mem.setName(rs.getString("NAME"));
				mem.setAge(rs.getString("AGE"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setGender(rs.getString("GENDER"));
				mem.setPassword(rs.getString("PASSWORD"));
				mem.setSsn(rs.getString("SSN"));
                }
			
		} catch (Exception e) {   // 수정해준다. 
			e.printStackTrace();
		}
	return mem;
	}
}
