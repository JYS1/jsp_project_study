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

@WebServlet(asyncSupported = true, urlPatterns = { "/addBook.do" })
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	
	BookDAO_Mariadb dao = new BookDAO_Mariadb();
	BookService service = new BookServiceimpl(dao);
	
	String title = request.getParameter("title");
	String publisher = request.getParameter("publisher");
	int price = Integer.parseInt(request.getParameter("price") );
	
	
	BookVO vo = new BookVO();
	
	vo.setTitle(title);
	vo.setPublisher(publisher);
	vo.setPrice(price);
	
	
	service.bookAdd(vo);
		
	response.sendRedirect("booklist.do");
	}

}
