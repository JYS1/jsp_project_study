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

/**
 * Servlet implementation class BookBoardServlet
 */
@WebServlet({"/bookview.do"})					// {}로 감싸면 여러개의 링크가 가능하다.
public class BookViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int bookno = Integer.parseInt(request.getParameter("bookno"));
		
		BookDAO_Mariadb dao = new BookDAO_Mariadb();
		BookService service = new BookServiceimpl(dao);
		BookVO vo =  service.getBook(bookno);
		
		request.setAttribute("book", vo); 
		String page = "/BookView.jsp";
		
		getServletContext().getRequestDispatcher(page).forward(request, response);
		
		
	}
}
