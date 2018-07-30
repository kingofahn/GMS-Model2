package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class DeleteCommand extends Command {
	public DeleteCommand(HttpServletRequest requset) {
		System.out.println("DeleteCommand 들어옴!!!");
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
			MemberBean mem = new MemberBean();
			mem.setUserid(request.getParameter("userid"));
			mem.setPassword(request.getParameter("password"));
			if(MemberServiceImpl.getInstance().login(mem)) {
				MemberServiceImpl.getInstance().deleteMemberInformation(mem);				
			} else {
				System.out.println("Error");
			}
			break;
		default : 
			break;
		}
	}

	
}
