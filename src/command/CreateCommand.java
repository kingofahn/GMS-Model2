package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class CreateCommand extends Command {
	public CreateCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();  // this.execute() 인데 this가 생략됨
		System.out.println("CreateCommand Domain.valueOf(getDomain().toUpperCase()) : " + Domain.valueOf(getDomain().toUpperCase()));
	}

	@Override
	public void execute() {
		switch (Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
			System.out.println("회원가입에 들어옴!!!");
			MemberBean mem = new MemberBean();
			mem.setName(request.getParameter("name"));
			mem.setPassword(request.getParameter("password"));
			mem.setSsn(request.getParameter("ssn"));
			mem.setUserId(request.getParameter("userid"));
			MemberServiceImpl.getInstance().createMember(mem);	
			System.out.println("회원가입 성공!!");
			break;
		default:
			break;
		}
		super.execute();
	}
}