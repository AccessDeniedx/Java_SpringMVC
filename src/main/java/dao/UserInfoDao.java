package dao;

import java.util.List;

import model.*;

public interface UserInfoDao {
	int addUser(userinfo u);
	
	int delUser(Integer id);
	
	int modifyUser(userinfo u);
	
	List<userinfo> queryAll();

	userinfo queryByExample(String username, String pass);
	
	int checkUsername(String username);

	
}
