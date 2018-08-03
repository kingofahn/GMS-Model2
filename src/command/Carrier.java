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
				System.out.println("%%%%"+"Sentry.cmd.getView() 의 내용 :  "+Sentry.cmd.getView()+"%%%%");
				System.out.println("%%%% forward 종료 %%%%");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	public static void redirect(HttpServletRequest request, 
		HttpServletResponse response, String url) {
		System.out.println("%%%% redirect 사용됨!!! %%%%");
			try {
				response.sendRedirect(request.getContextPath()+url);/*url :  /member.do?action=move&page=userLoginForm*/
				System.out.println("%%%%" + "request.getContextPath() 의 내용 : " + request.getContextPath() + "%%%%" );
				System.out.println("%%%% forward 종료 %%%%");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
