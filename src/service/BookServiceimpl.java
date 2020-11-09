package service;

import java.util.List;

import dao.BookDAO_Mariadb;
import vo.BookVO;

public class BookServiceimpl implements BookService {		//impl = implements
	private BookDAO_Mariadb dao = null;		// DB작업에 필요함.
	
	
	public BookServiceimpl() { 		// 여기서는 필드값을 받음 
		//부모 객체의 기본 생성자가 실행될것. 그래서 super을 지워도됨
		// 같은 이름의 메소드가 여러개 존재함 단,~~
	}
	
	public BookServiceimpl(BookDAO_Mariadb dao) {	// DB값을 가지고옴 
													// 파라미터 생성자
		super();
		this.dao = dao;
	}
	
	public BookDAO_Mariadb getDao() {		//private 해서 get,set 필요
		return dao;
	}
	public void setDao(BookDAO_Mariadb dao) {
		this.dao = dao;
	}
	
	@Override
	public List<BookVO> booklist() {
		return dao.bookList();
	}

	@Override
	public void bookAdd(BookVO vo) {
		dao.bookAdd(vo);
	}

	@Override
	public void bookDelete(int bookno) {
		dao.bookDelete(bookno);
	}

	@Override
	public void bookUpdate(BookVO vo) {
		dao.bookUpdate(vo);
	}

	@Override
	public BookVO getBook(int bookno) {
		return dao.getBook(bookno);
	}

	@Override
	public List<BookVO> searchBook(String condition, String keyword) {
		return dao.bookSearch(condition, keyword);
	}	

}
