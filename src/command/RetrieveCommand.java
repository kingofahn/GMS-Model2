package command;

import javax.servlet.http.HttpServletRequest;
import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class RetrieveCommand extends Command {
	MemberBean member;
	public MemberBean getMember() {
		return member;
	}

	public RetrieveCommand(HttpServletRequest request) {
		System.out.println("****    RetrieveCommand 들어옴!!!    ****");
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}

	@Override
	public void execute() {
		switch (Domain.valueOf(Sentry.cmd.domain.toUpperCase())) {
		case ADMIN:
			request.setAttribute("findMember",
					MemberServiceImpl.getInstance().retrieve(request.getParameter("userid")));
			super.execute();
			System.out.println("**** RetrieveCommand에 execute 실행함!!! ****");
			break;
		default:
			break;
		}
	}
}