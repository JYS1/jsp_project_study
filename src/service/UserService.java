package service;

import java.util.List;
import vo.UserVO;

public interface UserService {
	
	public List<UserVO> userlist();
	
	public void userAdd(UserVO vo);
	
	public void userDelete(String id);
	
	public void userUpdate(UserVO vo);
	
	public UserVO getUser(String id);
	
	public List<UserVO> searchUser(String condition, String keyword);



	
}
