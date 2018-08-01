package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import command.Carrier;
import command.Sentry;
import enums.Action;

@WebServlet({"/member.do"})  // URL Mapping
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("$$$$$$$$$$$$  MemberController Entered  $$$$$$$$$$$$");
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
		case UPDATE : 
			System.out.println("================컨트롤러 case 진입================");
			Carrier.redirect(request, response,
					"/member.do?action=move&page=userLoginForm");
			break;
		case DELETE :
			System.out.println("================컨트롤러 case 진입================");
			Carrier.redirect(request, response,"");
			break;
		case LOGIN :
			System.out.println("================컨트롤러 login 진입================");
			if(request.getAttribute("match").equals("TRUE")){
                Carrier.forward(request, response);
            }else {
                Carrier.redirect(request, response, "/member.do?action=move&page=userLoginForm");
            }
			System.out.println("================컨트롤러 login 종료================");
			break;
		default : 
			Carrier.redirect(request, response,"");
			break;
		}
	}
}
