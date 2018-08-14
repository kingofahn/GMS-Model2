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
		MemberDAOImpl.getInstance().insert(bean);
		
	}
	@Override
	public List<MemberBean> search(Map<?, ?> param) {
		System.out.println( "5  MemberServiceImpl");
		return MemberDAOImpl.getInstance()
				.selectSome(param);
	}
	@Override
	public MemberBean retrieve(String id) {
		return MemberDAOImpl.getInstance()
				.selectOne(id);
	}
	@Override
	public int count() {
		return MemberDAOImpl.getInstance()
				.count();
	}
	@Override
	public void modify(Map<?, ?> param) {
		MemberDAOImpl.getInstance().update(param);
	}
	@Override
	public void remove(MemberBean bean) {
		MemberDAOImpl.getInstance().delete(bean);
		
	}
	@Override
	public boolean login(MemberBean bean) {
		return (MemberDAOImpl.getInstance().login(bean)!=null);
	}
}
