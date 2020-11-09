package service;

import java.util.List;

import dao.UserDAO_Mariadb;
import vo.UserVO;

public class UserServiceimpl implements UserService { // impl = implements
	private UserDAO_Mariadb dao = null; // DB작업에 필요함.

	public UserServiceimpl() {
	}

	public UserServiceimpl(UserDAO_Mariadb dao) {	// DB값을 가지고옴 
		// 파라미터 생성자
		super();
		this.dao = dao;
	}

	public UserDAO_Mariadb getDao() {
		return dao;
	}

	public void setDao(UserDAO_Mariadb dao) {
		this.dao = dao;
	}

	@Override
	public List<UserVO> userlist() {
		return dao.userList();
	}

	@Override
	public void userAdd(UserVO vo) {
		// TODO Auto-generated method stub
		dao.userAdd(vo);
	}

	@Override
	public void userDelete(String id) {
		// TODO Auto-generated method stub
		dao.userDelete(id);
	}

	@Override
	public void userUpdate(UserVO vo) {
		// TODO Auto-generated method stub
		dao.userUpdate(vo);
	}

	@Override
	public UserVO getUser(String id) {
		// TODO Auto-generated method stub
		return dao.getUser(id);
	}

	@Override
	public List<UserVO> searchUser(String condition, String keyword) {
		// TODO Auto-generated method stub
		return dao.userSearch(condition, keyword);
	}

}
