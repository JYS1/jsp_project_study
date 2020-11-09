package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.BookVO;

public class BookDAO_Mariadb {

	public List<BookVO> bookList() {
		List<BookVO> list = new ArrayList<BookVO>();
		String sql = "select * from book order by bookno desc";

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				BookVO vo = new BookVO();
				vo.setBookno(rs.getInt("bookno"));
				vo.setTitle(rs.getString("title"));
				vo.setPublisher(rs.getString("publisher"));
				vo.setPrice(rs.getInt("price"));

				list.add(vo);
			}

		} catch (Exception e) {
			System.out.println("error" + e);
		} finally {
			JDBCUtil.close(conn, ps, rs);
		}

		return list;
	}

	public void bookAdd(BookVO vo) {

		String sql = "insert into book (title,publisher,price) values (? , ? , ?)";

		Connection con = null;
		PreparedStatement ps = null; // SQL 관리
		ResultSet rs = null;
		int row = 0; // 결과 int 값으로 도출

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 값 셋팅 작업
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getPublisher());
			ps.setInt(3, vo.getPrice());

			// sql문 실행
			// ps.executeQuery(); // 가지고있는거 사용할때 사용

			row = ps.executeUpdate(); // 상태 변화 할때 사용

			// 결과값 처리
			if (row == 0) {
				throw new Exception("등록 실패"); // 예외 객체 생성
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error :" + e);
		} finally {

			JDBCUtil.close(con, ps, rs); // 자원반납 필수
		}

	}

	public void bookDelete(int bookno) {

		String sql = "delete from book where bookno = ?";

		Connection con = null;
		PreparedStatement ps = null; // SQL 관리
		ResultSet rs = null;
		int row = 0; // 결과 int 값으로 도출

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 값 셋팅 작업
			ps.setInt(1, bookno);

			// sql문 실행
			// ps.executeQuery(); // 가지고있는거 사용할때 사용

			row = ps.executeUpdate(); // 상태 변화 할때 사용

			// 결과값 처리
			if (row == 0) {
				throw new Exception("삭제 실패"); // 예외 객체 생성
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error :" + e);
		} finally {

			JDBCUtil.close(con, ps, rs); // 자원반납 필수
		}

	}

	public void bookUpdate(BookVO vo) {

		String sql = "update book set price = ? where bookno = ?";

		Connection con = null;
		PreparedStatement ps = null; // SQL 관리
		ResultSet rs = null;
		int row = 0; // 결과 int 값으로 도출

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 값 셋팅 작업
			ps.setInt(1, vo.getPrice());
			ps.setInt(2, vo.getBookno());

			// sql문 실행
			// ps.executeQuery(); // 가지고있는거 사용할때 사용

			row = ps.executeUpdate(); // 상태 변화 할때 사용

			// 결과값 처리

			if (row == 0) {
				throw new Exception("수정 실패"); // 예외 객체 생성
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error :" + e);
		} finally {

			JDBCUtil.close(con, ps, rs); // 자원반납 필수
		}

	}

	public List<BookVO> bookSearch(String condition, String keyword) {
		int row = 0;

		String sql = "select * from book where " + condition + " like ? order by bookno desc";

		// select * from book where publisher like '%한%';
		Connection con = null;
		PreparedStatement ps = null; // SQL 관리
		ResultSet rs = null;
		List<BookVO> list = new ArrayList<BookVO>();		// is a 관계
															// 
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + keyword + "%");
			
			rs = ps.executeQuery(); // 가지고있는거 사용할때 사용
			
			while(rs.next() ) {
				BookVO vo = new BookVO();
				vo.setBookno(rs.getInt("bookno"));
				vo.setPrice(rs.getInt("price"));
				vo.setTitle(rs.getString("title"));
				vo.setPublisher(rs.getString("publisher"));
				list.add(vo);
			}


		

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error :" + e);
		} finally {

			JDBCUtil.close(con, ps, rs); // 자원반납 필수
		}
		return list;

	}

	public BookVO getBook(int bookno) {
		
		
		String sql = "select * from book where bookno = ?";

		Connection con = null;
		PreparedStatement ps = null; // SQL 관리
		ResultSet rs = null;
		BookVO vo = null;
		
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, bookno);
			rs = ps.executeQuery(); // 가지고있는거 사용할때 사용
			
			// 결과값 처리
			while(rs.next()) {
				vo = new BookVO();
				vo.setBookno(rs.getInt("bookno"));
				vo.setPrice(rs.getInt("price"));
				vo.setTitle(rs.getString("title"));
				vo.setPublisher(rs.getString("publisher"));
				
			} 

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error :" + e);
		} finally {

			JDBCUtil.close(con, ps, rs); // 자원반납 필수
		}
		return vo;

	}

}