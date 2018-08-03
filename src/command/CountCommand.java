package command;

import javax.servlet.http.HttpServletRequest;

import service.MemberServiceImpl;
public class CountCommand extends Command {
	public CountCommand(HttpServletRequest request) {
		System.out.println("CountCommand 들어옴!!!");
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	
	public void execute() {
		request.setAttribute("count",MemberServiceImpl.getInstance().memberCount());// 해쉬맵의 구조라서 숫자값을 먹게한다.
		System.out.println("CountCommand : " + MemberServiceImpl.getInstance().memberCount());
		super.execute();
	}
}
