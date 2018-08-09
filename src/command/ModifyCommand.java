package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class ModifyCommand extends Command {
	public ModifyCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath()
				.substring(1,
						request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	
	@Override
	public void execute() {
		switch(Domain.valueOf(Receiver.cmd.domain.toUpperCase())) {
		case MEMBER :
			System.out.println("update 들어옴!!!");
			Map<String,Object> map = new HashMap<>();
			MemberBean mem = new MemberBean();
			/*mem.setUserid(((MemberBean)request.getSession().getAttribute("user")).getUserid());
			 * mem.put("password",request.getParameter("password"));
			mem.setPassword(request.getParameter("password"));
			mem.setTeamid(request.getParameter("teamid"));
			mem.setRoll(request.getParameter("roll"));*/
			MemberServiceImpl.getInstance().modify(map);
			System.out.println("update 성공!!");
			break;
		default : 
			break;
		}
	}
}