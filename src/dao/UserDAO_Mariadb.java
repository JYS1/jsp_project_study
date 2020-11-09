package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.UserVO;

public class UserDAO_Mariadb {

	public List<UserVO> userList() {
		List<UserVO> list = new ArrayList<UserVO>();
		String sql = "select * from user";

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				UserVO vo = new UserVO();
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setRole(rs.getString("role"));

				list.add(vo);
			}

		} catch (Exception e) {
			System.out.println("error" + e);
		} finally {
			JDBCUtil.close(conn, ps, rs);
		}

		return list;
	}

	public void userAdd(UserVO vo) {

		String sql = "insert into user (id, password, name, role) values (? , ? , ? , ?)";

		Connection con = null;
		PreparedStatement ps = null; // SQL 관리
		ResultSet rs = null;
		int row = 0; // 결과 int 값으로 도출

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 값 셋팅 작업
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPassword());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getRole());

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

	public void userDelete(String id) {

		String sql = "delete from user where id = ?";

		Connection con = null;
		PreparedStatement ps = null; // SQL 관리
		ResultSet rs = null;
		int row = 0; // 결과 int 값으로 도출

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 값 셋팅 작업
			ps.setString(1, id);

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

	public void userUpdate(UserVO vo) {

		String sql = "update user set password = ? where id = ?";

		Connection con = null;
		PreparedStatement ps = null; // SQL 관리
		ResultSet rs = null;
		int row = 0; // 결과 int 값으로 도출

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 값 셋팅 작업
			ps.setString(1, vo.getPassword());
			ps.setString(2, vo.getId());

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

	public List<UserVO> userSearch(String condition, String keyword) {
		int row = 0;

		String sql = "select * from user where " + condition + " like ?";

		// select * from book where publisher like '%한%';
		Connection con = null;
		PreparedStatement ps = null; // SQL 관리
		ResultSet rs = null;
		List<UserVO> list = new ArrayList<UserVO>();		// is a 관계
															// 
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + keyword + "%");
			
			rs = ps.executeQuery(); // 가지고있는거 사용할때 사용
			
			while(rs.next() ) {
				UserVO vo = new UserVO();
				
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setRole(rs.getString("role"));
				
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

	public UserVO getUser(String id) {
		
		
		String sql = "select * from user where id = ?";

		Connection con = null;
		PreparedStatement ps = null; // SQL 관리
		ResultSet rs = null;
		UserVO vo = null;
		
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery(); // 가지고있는거 사용할때 사용
			
			// 결과값 처리
			while(rs.next()) {
				vo = new UserVO();
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setRole(rs.getString("role"));
				
			} 

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error :" + e);
		} finally {

			JDBCUtil.close(con, ps, rs); // 자원반납 필수
		}
		return vo;

	}

	public List<UserVO> userlist() {
		// TODO Auto-generated method stub
		return null;
	}

	

}