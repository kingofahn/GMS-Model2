package controller;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import command.Carrier;
import command.Receiver;
import domain.ImageBean;
import domain.MemberBean;
import enums.Action;
import enums.Path;
import service.ImageServiceImpl;
import service.MemberServiceImpl;

@WebServlet({"/member.do"})  // URL Mapping
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		Receiver.init(request,response);
		ImageBean bean =null;
		MemberBean user = null;
		String sep=	"";
		switch(Action.valueOf(Receiver.cmd.getAction().toUpperCase())){
		case ADD : 
			Carrier.redirect(request, response,
					"/member.do?action=move&page=login");
			break;
		case SEARCH :
			Carrier.forward(request, response);
			break;
		case RETRIEVE : 
			Carrier.forward(request, response);
			break;
		case MODIFY : 
			Carrier.redirect(request, response,
					"/member.do?action=move&page=retrieve");
			break;
		case FILEUPLOAD: 
			System.out.println("=====[1]====");
			if(!ServletFileUpload.isMultipartContent(request)){
				System.out.println("업로드파일이 없습니다.");
				return;
			}
			System.out.println("=====[2]====업로드파일이 존재함");
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(1024 * 1024 * 40); //  40MB
			upload.setSizeMax(1024 * 1024 * 50); // 50MB
			List<FileItem> items = null;
				try {
					System.out.println("=====[3]====try 내부로 진입");
					File file = null;
					bean = new ImageBean();
					user = new MemberBean();
					items = upload.parseRequest(
							new ServletRequestContext(request));
					System.out.println("=====[4]====items 생성");
					Iterator<FileItem>iter = items.iterator();
					while(iter.hasNext()){
						System.out.println("=====[5]====while 진입");
						FileItem item = (FileItem)iter.next();
						if(!item.isFormField()){
							System.out.println("=====[6]====if 진입");
							String fileName = item.getName();
							file = new File(Path.UPLOAD_PATH + fileName);
							item.write(file);
							System.out.println("file" + file);
							System.out.println("=====[7]====파일업로드 성공 !!!");
							sep = File.separator;
							bean.setUserid(((MemberBean)request.getSession().getAttribute("user")).getUserid());
							bean.setImgname(fileName.substring((fileName.lastIndexOf("\\")+1),fileName.lastIndexOf(".")));
							bean.setExtension(fileName.substring(fileName.lastIndexOf(".")+1));
							System.out.println("7-1" + bean.getImgname());
							System.out.println("7-2" + bean.getExtension());
							System.out.println("7-3" + bean.getUserid());
							ImageServiceImpl.getInstance().insert(bean);
						}else{
							System.out.println("=====[8]====파일업로드 실패 !!!");
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			System.out.println("=====[10]====");
			Carrier.redirect(request, response, "/member.do?action=retrieve&page=retrieve");
			break;			
		case REMOVE : 
			Carrier.redirect(request, response,"");
			break;
		case JOIN : 
			Carrier.redirect(request, response,
					"/member.do?action=move&page=login");
			break;
		case LOGIN :
			if(request.getAttribute("match").equals("TRUE")){
                Carrier.forward(request, response);
            }else {
            	Carrier.redirect(request, response, "/member.do?action=move&page=login");
            }
			break;
		case LOGOUT : 
			Carrier.redirect(request, response,"");
			break;
	    case MOVE : 
	        Carrier.forward(request, response);
	        break;
		default : 
			Carrier.redirect(request, response,"");
			break;
		}
	}
}
