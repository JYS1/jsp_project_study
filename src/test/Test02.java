package test;

import dao.BookDAO_Mariadb;
import vo.BookVO;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookDAO_Mariadb b = new BookDAO_Mariadb();

		BookVO vo = new BookVO();
		vo.setTitle("java");
		vo.setPublisher("구구구구");
		vo.setPrice(8100);

		//b.bookAdd(vo);
		// b.bookList().forEach(i->{System.out.println(i);});

		// vo.setBookno(6);
		// b.bookUpdate(vo);
		// b.bookDelete(8);

		// System.out.println("=====================================================");
		// b.bookList().forEach(i->{System.out.println(i);});
		// System.out.println("=====================================================");
		BookVO book = b.getBook(5);
		if (book != null) {
			System.out.println(book);
			book.setPrice(book.getPrice() * 2);
			b.bookUpdate(book);
			BookVO book2 = b.getBook(book.getBookno());
			System.out.println(book2);
			b.bookDelete(book2.getBookno());
			System.out.println(b.getBook(book2.getBookno()));
		}

		System.out.println("==================목록 보기====================");
		b.bookList().forEach(i -> {
			System.out.println(i);
		});
		
		System.out.println("=================== 검 색 =====================");
		b.bookSearch("title", "on").forEach(i -> {System.out.println(i);});
		
		System.out.println("=================== 검 색 =====================");
		b.bookSearch("publisher", "한").forEach(i -> {System.out.println(i);});
	}

}
