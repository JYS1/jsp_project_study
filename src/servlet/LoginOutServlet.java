package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO_Mariadb;
import service.UserService;
import service.UserServiceimpl;
import vo.UserVO;


@WebServlet({ "/login.do", "/logout.do" })
public class LoginOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//logout.do
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		if(session != null) {			// 세션이 있으면
			session.invalidate();		// 세션을 파괴
		}
		response.sendRedirect("/index.jsp");
		
		
	}

	//login.do
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		UserDAO_Mariadb dao = new UserDAO_Mariadb();
		UserService service = new UserServiceimpl(dao);
		
		UserVO login = service.login(id,password);
//		System.out.println(login);
		
		if(login != null) {
			HttpSession session = request.getSession();
			session.setAttribute("login", login);
			
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				
		} else {
			request.setAttribute("msg", "로그인 실패, 로그인 정보를 다시 입력 하세요.");
			getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		
	}

}
