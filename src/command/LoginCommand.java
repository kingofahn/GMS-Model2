package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
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
		switch(Domain.valueOf(Sentry.cmd.domain.toUpperCase())) {
		case MEMBER :
			System.out.println("login Command 들어옴!!!");
			MemberBean mem = new MemberBean();
			mem.setUserId(request.getParameter("userid"));
			mem.setPassword(request.getParameter("password"));
			if(MemberServiceImpl.getInstance().login(mem)) {
				System.out.println("로그인 성공");
			} else {
				System.out.println("로그인 실패");
			}
			break;
		default : 
			break;
		}
	}
}
