package sql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Test1 {
	public static void SqlConncheck(String user,String password) throws Exception {
		int logincheck = 0;
		Connection con = null;//负责与数据连接用的
		PreparedStatement pstat = null; // 预编译的sql语句装载器,比普通statement的优势在于传递参数时,更安全和高效

		List list = new ArrayList();

		try {
			//1.加载mysql数据库驱动
			Class.forName("com.mysql.cj.jdbc.Driver");

			System.out.println("test");
			//2.获取数据库回话
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?&useSSL=false&serverTimezone=UTC", "root", "123456");

			System.out.println("建立数据库连接成功!");

			//3.装载一个查询的sql语句
			String sql = "select * from studentlogin;";
			pstat = con.prepareStatement(sql);
			ResultSet rst = pstat.executeQuery(sql);

			while(rst.next()){
				if(user.equals(rst.getString(1))&&password.equals(rst.getString(2))){
					System.out.println(user+"\n"+password);
				}
				else
					break;

			}


		} catch (Exception e) {
			System.out.println("数据库连接失败!");
			e.printStackTrace();
			//return 0;
		} finally {
			// 关闭顺序  rs  -> stat  -> con
			try {
				if(null!=pstat){
					pstat.close();
				}
				if (null!=con) {
					con.close();// 关闭回话,清空jvm内存
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
	}

}
