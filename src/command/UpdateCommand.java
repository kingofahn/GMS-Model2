package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class UpdateCommand extends Command {
	public UpdateCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		switch (Domain.valueOf(Sentry.cmd.domain.toUpperCase())) {
		case MEMBER:
			System.out.println("update 들어옴!!!");
			MemberBean mem = new MemberBean();
			mem.setUserId(request.getParameter("userid"));
			mem.setPassword(request.getParameter("password"));
			if(MemberServiceImpl.getInstance().login(mem)) {
				mem.setPassword(request.getParameter("newpassword"));
				MemberServiceImpl.getInstance().updateMemberInformation(mem);		
			} else {
				System.out.println("error");
			}
			System.out.println("update 성공!!");
			break;
		default:
			break;
		}
	}
}