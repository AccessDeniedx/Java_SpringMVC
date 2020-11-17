package Controller;

import dao.BaseDao;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EMAIL",urlPatterns = "/EMAIL")
public class EMAIL extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ResultSet rst = null;
            BaseDao bd = new BaseDao();
            String p1 = request.getParameter("username");
            String sql = "select UPWD,email from studentlogin where UNAME='"+p1+"';"; // 生成一条sql语句
            rst=bd.executeSelect(sql);
            /*while(rst.next()){
                System.out.println(rst.getString(1));
                System.out.println(rst.getString(2));
            }*/
            String p2=null,p3=null;
            while(rst.next()){
                p2 = rst.getString(1);
                p3 = rst.getString(2);
            }
            try {
                Properties properties = new Properties();
                properties.put("mail.transport.protocol", "smtp");// 连接协议
                properties.put("mail.smtp.host", "smtp.qq.com");// 主机名
                properties.put("mail.smtp.port", 465);// 端口号
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.ssl.enable", "true");// 设置是否使用ssl安全连接 ---一般都使用
                properties.put("mail.debug", "true");// 设置是否显示debug信息 true 会在控制台显示相关信息
                properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                // 得到回话对象
               Session session = Session.getInstance(properties);
                // 获取邮件对象
                //Message message = new MimeMessage(session);
                MimeMessage message = new MimeMessage(session);
                // 设置发件人邮箱地址

               message.setFrom(new InternetAddress("123456789@qq.com"));
                // 设置收件人邮箱地址
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(p3));
                // 设置邮件标题
                message.setSubject("尊敬的"+p1+"您好");
                // 设置邮件内容
                  message.setText("您的密码为："+p2);
                // 得到邮差对象
                Transport transport = session.getTransport();
                // 连接自己的邮箱账户
                transport.connect("12345678@qq.com", "123456789");// 密码为QQ邮箱开通的stmp服务后得到的客户端授权码
                // 发送邮件
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();
                System.out.println("success sending!");
                response.setContentType("text/html;charset=gb2312");

                PrintWriter out = response.getWriter();
                out.print("<script>alert('我们已经将密码以邮件的形式告知您，请注意查收！');" +
                        "window.location.href='index.jsp'</script>");
            }catch (Exception e) {
                e.printStackTrace();
                System.out.println("fail sending!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
        }
        /*System.out.println("testtest");*/
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
