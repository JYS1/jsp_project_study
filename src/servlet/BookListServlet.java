package servlet;

import java.io.IOException;
import java.io.PrintWriter;
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


@WebServlet({ "/booklist.do" })
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		BookDAO_Mariadb dao = new BookDAO_Mariadb();
		BookService service = new BookServiceimpl(dao);
		List<BookVO> list = service.booklist();
		
		request.setAttribute("booklist", list);    //밑에 페이지에 쓸수 있도록 걸기 (items 와 같은 이름을 써야함)
		String page = "/BookList.jsp";
		
		getServletContext().getRequestDispatcher(page).forward(request, response);
		
		
		
	}

}
