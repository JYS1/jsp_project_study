package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.UserDAO_Mariadb;
import service.UserService;
import service.UserServiceimpl;
import vo.UserVO;

class UserTest {
	
	UserService service = null;
	
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		UserDAO_Mariadb dao = new UserDAO_Mariadb();
		service = new UserServiceimpl(dao);
		
	}

	@Test						//여기부분만 주석처리해도 안돌아감
	void list() {
		service.userlist().forEach(i -> {System.out.println(i);} );
	}
	
//	@Test
	void add() {
		UserVO vo = new UserVO();	// vo 타입이 필요함.
		vo.setId("goo");
		vo.setPassword("1234");
		vo.setName("김씨씨");
		vo.setRole("user");
		
	

		service.userAdd(vo);
		System.out.println("등록 되었습니다.");
	}
	
//	@Test
	void getUser() {
		System.out.println(service.getUser("goo"));
	}
	
//	@Test
	void delete() {
		UserVO vo = service.getUser("goo");
		if(vo !=  null) {
			System.out.println(vo);
			service.userDelete("goo");
			System.out.println("삭제 되었습니다.");
		} else {
			System.out.println("존재 하지 않습니다.");
		}
	}
	
//	@Test
	void update() {
		UserVO vo = service.getUser("goo");
		if(vo != null) {
			System.out.println(vo);
			vo.setPassword("1333");
			vo.setId("goo");
			service.userUpdate(vo);
			System.out.println(service.getUser("goo"));
		} else {
			System.out.println("존재하지 않습니다.");
		}
		
	}

//	@Test
	void search() {
		
		List<UserVO> list = service.searchUser("id", "a");
		
		System.out.println("=====================");
		
		for(UserVO data:list) {
			System.out.printf("%s|%s|%s %n", data.getId(), data.getName(), data.getRole());
			
		}
		
	}
	
	
}
