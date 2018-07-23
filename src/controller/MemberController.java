package controller;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import command.Carrier;
import command.ListCommand;
import command.RetrieveCommand;
import command.SearchCommand;
import command.Sentry;
import domain.MemberBean;
import enums.Action;

@WebServlet({"/member.do"})  // URL Mapping
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("$$$$$$$$$$$$  MemberController Entered  $$$$$$$$$$$$");
		List<MemberBean> lst = null;
		MemberBean mem = null;
		Sentry.init(request,response);
		switch(Action.valueOf(Sentry.cmd.getAction().toUpperCase())){
	    case MOVE : 
			System.out.println("================컨트롤러  MOVE case 진입================");
	        Carrier.forward(request, response);
	        break;
		case JOIN : 
			System.out.println("================컨트롤러 JOIN case 진입================");
			Carrier.redirect(request, response,
					"/member.do?action=move&page=userLoginForm");
			break;
		case UPDATE : case DELETE :
			System.out.println("================컨트롤러 case 진입================");
			Carrier.redirect(request, response,"");
			break;
		case LOGIN :
			System.out.println("================컨트롤러 login 진입================");
			if(request.getAttribute("match").equals("TRUE")) {
				Carrier.forward(request, response);
			} else {
				Carrier.redirect(request, response,
						"/member.do?action=move&page=userLoginForm");
			}
			System.out.println("================컨트롤러 login 종료================");
			break;
		case RETRIEVE :
			System.out.println("================컨트롤러 RETRIEVE case 진입================");
			System.out.println("================RETRIEVE 출력 : =================");
			/*mem = ((RetrieveCommand) Sentry.cmd).getMember();*/
			/*request.setAttribute("member", MemberServiceImpl.getInstance().findById("uid"));*/
			mem = ((RetrieveCommand) Sentry.cmd).getMember();
			System.out.println(mem);
			System.out.println("================RETRIEVE 종료 : =================");
			Carrier.redirect(request, response,"");
			break;
		case LIST :
			System.out.println("================컨트롤러 LIST case 진입================");
			System.out.println("================list 출력 : =================");
			lst = ((ListCommand) Sentry.cmd).getMembers();
			System.out.println(lst);
			System.out.println("================list 종료 : =================");
			Carrier.redirect(request, response,"");
			break;
		case SEARCH :
			System.out.println("================컨트롤러 SEARCH case 진입================");
			System.out.println("================SEARCH 출력 : =================");
			lst = ((SearchCommand) Sentry.cmd).getMembers();
			System.out.println(lst);
			System.out.println("================SEARCH 종료 : =================");
			Carrier.redirect(request, response,"");
			break;
		case COUNT :
			System.out.println("================컨트롤러 Count case 진입================");
			System.out.println("================COUNT 출력 : =================");
			System.out.println(request.getAttribute("count"));
			System.out.println("================COUNT 종료 : =================");
			Carrier.redirect(request, response,"");
			break;
		default : 
			Carrier.redirect(request, response,"");
			break;
		}
	}
}
