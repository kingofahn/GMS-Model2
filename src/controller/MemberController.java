package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member.do")  // URL Mapping
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*		System.out.println("MemberController Entered!!");*/
		String page = request.getParameter("page");
		switch(request.getParameter("action")) {
		case "move" : 
			request.getRequestDispatcher("/WEB-INF/view/member/"+page+".jsp").forward(request, response); 
			break; 
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
