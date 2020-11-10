package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO_Mariadb;
import service.BookService;
import service.BookServiceimpl;
import vo.BookVO;


@WebServlet("/deleteBook.do")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		BookDAO_Mariadb dao = new BookDAO_Mariadb();
		BookService service = new BookServiceimpl(dao);
		
		
		String[] bookno = request.getParameterValues("bookno");	// 여러개 지워야 하므로 리스트로 받는다.
		
		for(String no :bookno) {								// 돌리기
			service.bookDelete(Integer.parseInt(no) );
		}
		
			
		response.sendRedirect("booklist.do");
		
	}

}









