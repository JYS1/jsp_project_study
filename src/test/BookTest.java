package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.BookDAO_Mariadb;
import service.BookService;
import service.BookServiceimpl;
import vo.BookVO;

class BookTest {
	
	BookService service = null;
	
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		BookDAO_Mariadb dao = new BookDAO_Mariadb();
		service = new BookServiceimpl(dao);
		
	}

	@Test						//여기부분만 주석처리해도 안돌아감
	void list() {
		service.booklist().forEach(i-> {System.out.println(i); } );
	}
	
//	@Test
	void add() {
		BookVO vo = new BookVO();	// vo 타입이 필요함.
		vo.setTitle("JSP");
		vo.setPublisher("명지");
		vo.setPrice(10000);

		service.bookAdd(vo);
		System.out.println("등록 되었습니다.");
	}
	
//	@Test
	void getBook() {
		System.out.println(service.getBook(4));
	}
	
//	@Test
	void delete() {
		BookVO vo = service.getBook(14);
		if(vo !=  null) {
			System.out.println(vo);
			service.bookDelete(vo.getBookno() );
			System.out.println("삭제 되었습니다.");
		} else {
			System.out.println("존재 하지 않습니다.");
		}
	}
	
//	@Test
	void update() {
		BookVO vo = service.getBook(5);
		if(vo != null) {
			System.out.println(vo);
			vo.setPrice(0);
			service.bookUpdate(vo);
			System.out.println(service.getBook(1));
		} else {
			System.out.println("존재하지 않습니다.");
		}
		
	}

	@Test
	void search() {
		
		List<BookVO> list = service.searchBook("title", "j");
		
		System.out.println("=====================");
		
		for(BookVO data:list) {
			System.out.printf("%s|%d|%s| %n", data.getTitle(), data.getPrice(), data.getPublisher());
			
		}
		
	}
	
	
}
