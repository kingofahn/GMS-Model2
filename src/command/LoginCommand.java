package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import service.MemberServiceImpl;

public class LoginCommand extends Command {
	public LoginCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage("retrieve");
		execute();
	}

	public void execute() {
		System.out.println("login Command 들어옴!!!");
		super.execute();
		MemberBean mem = new MemberBean();
		mem.setUserid(request.getParameter("userid"));
		mem.setPassword(request.getParameter("password"));
		if (MemberServiceImpl.getInstance().login(mem)) {
			request.setAttribute("match", "TRUE");
			request.getSession().setAttribute("user", MemberServiceImpl.getInstance().retrieve(request.getParameter("searchWord")));
		} else {
			request.setAttribute("match", "FALSE");
		}
		System.out.println("로그인 TRUE FLASE" + request.getAttribute("match"));
		
	}
}