package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO_Mariadb;
import service.BookService;
import service.BookServiceimpl;
import vo.BookVO;

@WebServlet("/bookSeach.do")
public class BookSeachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//public 와도됨
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException	{	// 오버라이딩이라 지워도됨 나중에 찾아볼것
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String condition = request.getParameter("condition");
		String keyword = request.getParameter("keyword");
		
		BookDAO_Mariadb dao = new BookDAO_Mariadb();
		BookService service = new BookServiceimpl(dao);
		List<BookVO> list = service.searchBook(condition, keyword);
		
		request.setAttribute("booklist", list); 
		String page = "/BookList.jsp";
		
		getServletContext().getRequestDispatcher(page).forward(request, response);
		
		
	}

}
