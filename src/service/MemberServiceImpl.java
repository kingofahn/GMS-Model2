package service;

import java.util.List;
import java.util.Map;

import dao.MemberDAOImpl;
import domain.MemberBean;


public class MemberServiceImpl implements MemberService {
	private static MemberService instance = new MemberServiceImpl();
	public static MemberService getInstance() {return instance;}
	private MemberServiceImpl() {}
	List<MemberBean> memberList;
	@Override
	public void add(MemberBean bean) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<MemberBean> search(Map<?, ?> param) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public MemberBean retrieve(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void modify(Map<?, ?> param) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void remove(MemberBean bean) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean login(MemberBean bean) {
		// TODO Auto-generated method stub
		return false;
	}

}
