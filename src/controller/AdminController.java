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
@WebServlet("/admin.do")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Sentry.init(request,response);
		switch(Action.valueOf(Sentry.cmd.getAction().toUpperCase())){
	    case MOVE : 
	    	System.out.println("================Admin 컨트롤러  MOVE case 진입================");
	        Carrier.forward(request, response);
	        System.out.println("================Admin 컨트롤러  MOVE case 종료================");
	        break;
		case LIST :
			System.out.println("================컨트롤러 LIST case 진입================");
			Carrier.forward(request, response);
			System.out.println("================컨트롤러 LIST case 종료 : =================");
			break;
		case RETRIEVE :
			System.out.println("================컨트롤러 RETRIEVE case 진입================");
			Carrier.forward(request, response);
			System.out.println("================컨트롤러 RETRIEVE case 종료================");
			break;
		case SEARCH :
			System.out.println("================컨트롤러 SEARCH case 진입================");
			Carrier.forward(request, response);
			System.out.println("================SEARCH 종료 : =================");
			break;
		case COUNT :
			System.out.println("================컨트롤러 Count case 진입================");
			Carrier.forward(request, response);
			System.out.println("================COUNT 종료 : =================");
			break;
		default : 
			Carrier.redirect(request, response,"");
			break;
		}
	}
}
