package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class AddCommand extends Command {
	public AddCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();  // this.execute() 인데 this가 생략됨
		/*System.out.println("CreateCommand Domain.valueOf(getDomain().toUpperCase()) : " + Domain.valueOf(getDomain().toUpperCase()));*/
	}

	@Override
	public void execute() {
		switch (Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
			System.out.println("회원가입에 들어옴!!!");
			MemberBean mem = new MemberBean();
			mem.setName(request.getParameter("name"));
			mem.setUserid(request.getParameter("userid"));
			mem.setPassword(request.getParameter("password"));
			mem.setSsn(request.getParameter("ssn"));
			mem.setGender(request.getParameter("gender"));
			mem.setAge(request.getParameter("age"));
			mem.setTeamid(request.getParameter("teamid"));
			mem.setRoll(request.getParameter("roll"));
			/*mem.setSubject(ParamMap.getValues(request,"subject"));*/
			MemberServiceImpl.getInstance().add(mem);	
			System.out.println("회원가입 성공!!");
			break;
		default:
			break;
		}
		super.execute();
	}
}