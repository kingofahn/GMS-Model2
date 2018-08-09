package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class RemoveCommand extends Command {
	public RemoveCommand(HttpServletRequest requset) {
		System.out.println("DeleteCommand 들어옴!!!");
		setRequest(requset);
		setDomain(request.getServletPath()
				.substring(1,
						request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	
	public void execute() {
		switch(Domain.valueOf(Receiver.cmd.domain.toUpperCase())) {
		case MEMBER :
			MemberBean mem = new MemberBean();
			mem.setUserid(((MemberBean)request.getSession().getAttribute("user")).getUserid());
			mem.setPassword(request.getParameter("password"));
			if(MemberServiceImpl.getInstance().login(mem)) {
				MemberServiceImpl.getInstance().remove(mem);
				request.getSession().invalidate();
			} else {
				System.out.println("Error");
			}
			break;
		default : 
			break;
		}
	}
}
