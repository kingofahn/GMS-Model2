package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import service.ImageServiceImpl;
import service.MemberServiceImpl;

public class LoginCommand extends Command {
	public LoginCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, 
												request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage("retrieve");
		execute();
	}

	public void execute() {
		MemberBean mem = new MemberBean();
		mem.setUserid(request.getParameter("userid"));
		mem.setPassword(request.getParameter("password"));
		if (MemberServiceImpl.getInstance().login(mem)) {
			request.setAttribute("match", "TRUE");
			request.getSession().setAttribute("user", MemberServiceImpl.getInstance().retrieve(request.getParameter("userid")));
			request.getSession().setAttribute("image", ImageServiceImpl.getInstance().retrieve(request.getParameter("userid")));
		} else {
			request.getSession().setAttribute("match", "FALSE");
		}
		super.execute();
	}
}