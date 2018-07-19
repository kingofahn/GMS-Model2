package command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Carrier {
	public static void forward(HttpServletRequest request, 
		HttpServletResponse response){
		System.out.println("%%%% forward 사용됨 %%%%");
			try {
				request
				.getRequestDispatcher(Sentry.cmd.getView())
				.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	public static void redirect(HttpServletRequest request, 
		HttpServletResponse response, String url) {
		System.out.println("%%%% redirect 사용됨!!! %%%%");
			try {
				response.sendRedirect(request.getContextPath()+url);/*url :  /member.do?action=move&page=userLoginForm*/
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
