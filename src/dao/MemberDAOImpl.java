package dao;
import java.util.List;
import java.util.Map;

import domain.MemberBean;

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
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public MemberBean selectOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
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
