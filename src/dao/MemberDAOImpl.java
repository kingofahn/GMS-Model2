package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.MemberBean;
import enums.MemberQuery;
import enums.Vendor;
import factory.*;
import pool.DBConstant;

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
						              member.getUserId(),member.getPassword(), member.getSsn(),member.getName(),Integer.parseInt(member.getAge())));
		} catch (Exception e) {   
			e.printStackTrace();
		}
	}
	
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
				mem.setUserId(rs.getString("MEM_ID"));
				mem.setTeamId(rs.getString("TEAM_ID"));
				mem.setName(rs.getString("NAME"));
				mem.setAge(rs.getString("AGE"));
				mem.setRoll(rs.getString("ROLL"));
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
	public List<MemberBean> selectMemberBySearchWord(String word) {
		List<MemberBean> lst = new ArrayList<>();
		try {
			ResultSet rs = DatabaseFactory.createDatabase(
					Vendor.ORACLE, DBConstant.USERNAME,DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(String.format(MemberQuery.SELECT_SOME.toString(),word));
			MemberBean mem =null;
			while(rs.next()) {
				mem = new MemberBean();
				mem.setUserId(rs.getString("MEM_ID"));
				mem.setTeamId(rs.getString("TEAM_ID"));
				mem.setName(rs.getString("NAME"));
				mem.setAge(rs.getString("AGE"));
				mem.setRoll(rs.getString("ROLL"));
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
/*			Class.forName(DBConstant.ORACLE_DRIVER);
			Connection conn = DriverManager.getConnection(DBConstant.CONNECTION_URL, DBConstant.USERNAME, DBConstant.PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("");*/
			ResultSet rs =  DatabaseFactory.createDatabase(
					Vendor.ORACLE, 
					DBConstant.USERNAME, 
					DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(String.format(MemberQuery.COUNT_MEMBER.toString()));
						
			while(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return count;
	}
	@Override
	public MemberBean selectFindById(String id) {
		MemberBean member = null;
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
				member = new MemberBean();
                member.setUserId(rs.getString("MEM_ID"));
                member.setTeamId(rs.getString("TEAM_ID"));
                member.setName(rs.getString("NAME"));
                member.setAge(rs.getString("AGE"));
                member.setRoll(rs.getString("ROLL"));
                member.setSsn(rs.getString("SSN"));
                }
			
		} catch (Exception e) {   
			e.printStackTrace();
		}
	return member;
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
								member.getPassword(),member.getUserId()));		
		
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
							MemberQuery.DELETE_MEMBER.toString(),member.getUserId()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	@Override
	public MemberBean login(MemberBean member) {
		MemberBean m = null;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(
					Vendor.ORACLE, 
					DBConstant.USERNAME, 
					DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(
							String.format(MemberQuery.LOGIN.toString(),
						              member.getUserId(),member.getPassword()));
			
			while(rs.next()) {
				m = new MemberBean();
                m.setUserId(rs.getString("MEM_ID"));
                m.setName(rs.getString("NAME"));
                m.setTeamId(rs.getString("TEAM_ID"));
                m.setSsn(rs.getString("SSN"));                
                m.setRoll(rs.getString("ROLL"));
                m.setPassword(rs.getString("PASSWORD"));
                }
			
		} catch (Exception e) {   // 수정해준다. 
			e.printStackTrace();
		}
	return m;
	}
	
}
