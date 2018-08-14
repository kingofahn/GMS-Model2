package command;

import javax.servlet.http.HttpServletRequest;

public class MoveCommand extends Command{
	public MoveCommand(HttpServletRequest requset) {
		setRequest(requset);
		setDomain(request.getServletPath()
				.substring(1,
						request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	
	public void execute() {
		super.execute();
		request.setAttribute("pagename", 
				request.getParameter("page"));
	}
}
