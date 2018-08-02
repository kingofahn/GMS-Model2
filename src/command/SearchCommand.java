package command;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class SearchCommand extends Command {
	List<MemberBean> members;
	public List<MemberBean> getMembers() {
		return members;
	}

	public SearchCommand(HttpServletRequest request) {
		System.out.println("****    SearchCommand 들어옴!!!    ****");
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
			request.setAttribute(
					"memberList",MemberServiceImpl.getInstance().findMemberByTeamName(request.getParameter("searchOption")
																					+"/"+
																					request.getParameter("searchWord")));
			super.execute();
			System.out.println("**** SearchCommand에 execute 실행함!!! ****");
			break;
		default:
			break;
		}
	}
}