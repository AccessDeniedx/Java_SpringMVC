package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.UserInfoDao;
import model.*;

public class UserInfoDaoImpl extends BaseDao implements UserInfoDao {

	@Override
	public int addUser(userinfo u) {
		String sql  = "insert into studentlogin (id,UNAME,UPWD,email) " +
				"values("+u.getId()+",'"+u.getUsername()+"','"+u.getPass()+"','"+u.getEmail()+"')";
		int i = executeIUD(sql);
		return i;
	}

	@Override
	public int delUser(Integer id) {
		String sql  = "delete from studentlogin where id="+id+";";
		int i = executeIUD(sql);
		return i;
	}

	@Override
	public int modifyUser(userinfo u) {
		String sql  = "update studentlogin set " +
				"UNAME='"+u.getUsername()+" ', UPWD='"+
				u.getPass()+"' where id="+u.getId()+";";

		int i = executeIUD(sql);
		return i;
	}

	@Override
	public List<userinfo> queryAll() {
		List<userinfo> list = new ArrayList<userinfo>();
		try {
			String sql="select * from studentlogin;";
			ResultSet rs = executeSelect(sql);

			while(rs.next()){
				userinfo temp = new userinfo();
				temp.setId(rs.getInt(1));
				temp.setUsername(rs.getString(2));
				temp.setPass(rs.getString(3));
				temp.setEmail(rs.getString(4));

				list.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			//closeAll(BaseDao.con, BaseDao.pstat, rst);
		}

		
		return list;
	}

	@Override
	public userinfo queryByExample(String username, String pass) {
		userinfo u = new userinfo();
		try {
			String sql ="select * from studentlogin where UNAME='"+username+
					"' and UPWD='"+pass+"';";
			ResultSet rs = executeSelect(sql);
			while (rs.next()) {
				u.setId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPass(rs.getString(3));
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("userinfodaoimplexception!");
		}

		return u;
	}

	@Override
	public int checkUsername(String username) {
		int num=0;
		try {
			String sql="select count(*) from studentlogin " +
					"where username="+username+";";
			ResultSet rs = executeSelect(sql);
			
			if(rs.next()) {
				num = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return num;//返回的是id
	}

}
