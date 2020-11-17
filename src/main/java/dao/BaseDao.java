package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDao {
	public static Connection con = null;//负责与数据连接用的
	public static PreparedStatement pstat = null; // 预编译的sql语句装载器,比普通statement的优势在于传递参数时,更安全和高效
	public static ResultSet rst = null;

	List list = new ArrayList();

	//连接数据库
	public static Connection getCon(){
		try {
			//1.加载mysql数据库驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.获取数据库回话
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?&useSSL=false&serverTimezone=UTC", "root", "123456");
			//3.装载一个查询的sql语句
			String sql = "select * from studentlogin;";
			pstat = con.prepareStatement(sql);
			rst = pstat.executeQuery(sql);
		} catch (Exception e) {
			System.out.println("failed to db!");
			e.printStackTrace();
		}

		return con;
	}

	//关闭
	public void closeAll(Connection con,Statement st,ResultSet rs){
		try {
			if(null!=rs){
				rs.close();
			}
			if (null!=st) {
				st.close();
			}
			if (null!=con) {
				con.close();
			}
		} catch (Exception e2) {
			System.out.println("数据库已关闭！");
			e2.printStackTrace();
		}
		
	}

	//更新数据
	public int executeIUD(String sql){
		PreparedStatement pst =null;
		getCon();
		int count =0;
		try {
			pst=con.prepareStatement(sql);
			System.out.println(sql);
			count=pst.executeUpdate();//PreparedStatement
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			//closeAll(con,pst,null);
		}
		
		return count;
	}

	//查询select数据
	public ResultSet executeSelect(String sql){
		getCon();
		try {
			pstat=con.prepareStatement(sql);
			rst=pstat.executeQuery();
		} catch (Exception e) {
				e.printStackTrace();
		} finally{

		}
		return rst;
	}

	public static void main(String[] args) {
		BaseDao bb = new BaseDao();
	}
	
}
