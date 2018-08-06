package command;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import service.MemberServiceImpl;

public class ListCommand extends Command {
	List<MemberBean> members;
	public List<MemberBean> getMembers() {
		return members;
	}

	public ListCommand(HttpServletRequest request) {
		System.out.println("****    ListCommand 들어옴!!!    ****");
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		request.setAttribute("count",MemberServiceImpl.getInstance().memberCount());// 해쉬맵의 구조라서 숫자값을 먹게한다.
		request.setAttribute("beginPage",1);// 해쉬맵의 구조라서 숫자값을 먹게한다.
		int count = (int) request.getAttribute("count");
		int endPage = (count>25)? 5 : (count%5==0)? count/5: count/5+1;
		request.setAttribute("endPage",endPage);
		Map<String,Object> param = new HashMap<>();
		String beginRow = "1";
		String endRow = "5";
		param.put("beginRow", Integer.parseInt(beginRow));
		param.put("endRow", Integer.parseInt(endRow));
		request.setAttribute("endPage", endPage);
		request.setAttribute("getList", MemberServiceImpl.getInstance().getList(param));
		request.setAttribute("memberList", MemberServiceImpl.getInstance().listMember());
		super.execute();
		System.out.println("**** ListCommand에 execute 실행함!!! ****");
	}
}