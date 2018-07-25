package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import service.MemberServiceImpl;
public class LoginCommand extends Command {
	public LoginCommand(HttpServletRequest requset) {
		setRequest(requset);
		setDomain(request.getServletPath()
				.substring(1,
						request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	
	public void execute() {
			System.out.println("login Command 들어옴!!!");
			super.execute();
			MemberBean mem = new MemberBean();
			mem.setUserId(request.getParameter("userid"));
			mem.setPassword(request.getParameter("password"));
			if(MemberServiceImpl.getInstance().login(mem)) {
				request.setAttribute("match", "TRUE");
				request.setAttribute("user", MemberServiceImpl.getInstance().findById(request.getParameter("userid")));
			} else {
				request.setAttribute("match","FALSE");
			}
	}
}
