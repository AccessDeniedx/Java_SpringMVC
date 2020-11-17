package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;

import com.sun.jdi.IntegerType;
import dao.FruitInfoDao;
import dao.impl.FruitinfoDaoImpl;
import model.userinfo;
import model.fruitinfo;
import dao.impl.UserInfoDaoImpl;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String flag = request.getParameter("flag");
        UserInfoDaoImpl impl = new UserInfoDaoImpl();
        FruitinfoDaoImpl implf = new FruitinfoDaoImpl();
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=gb2312");
        if ("zengjia".equals(flag)) {
            String id = request.getParameter("id");
            String p1 = request.getParameter("username");
            String p2 = request.getParameter("pass");
            String p3 = request.getParameter("email");

            System.out.println("zengjiatest");
            userinfo u = new userinfo();
            u.setUsername(p1);
            u.setPass(p2);
            u.setId(Integer.parseInt(id));
            u.setEmail(p3);
            int i = impl.addUser(u);
            if (i > 0) {
                out.print("<script>alert('添加用户成功！');" +
                        "window.location.href='welcome.jsp'</script>");
            } else {
                out.print("<script>alert('添加用户失败！');" +
                        "window.location.href='welcome.jsp'</script>");
            }

        }
        else if ("xiugai".equals(flag)) {
            String p1 = request.getParameter("username");
            String p2 = request.getParameter("pass");
            String p3 = request.getParameter("id");

            userinfo u = new userinfo();
            u.setUsername(p1);
            u.setPass(p2);
            u.setId(Integer.parseInt(p3));
            int i = impl.modifyUser(u);

            if (i > 0) {
                out.print("<script>alert('修改用户成功！');" +
                        "window.location.href='welcome.jsp'</script>");
            } else {
                out.print("<script>alert('修改用户失败！');" +
                        "window.location.href='welcome.jsp'</script>");
            }
        }
        else if ("shanchu".equals(flag)) {
            String id = request.getParameter("id");
            String p1 = request.getParameter("username");

            userinfo u = new userinfo();
            u.setUsername(p1);
            u.setId(Integer.parseInt(id));

            int i = impl.delUser(Integer.parseInt(id));

            if (i > 0) {
                out.print("<script>alert('删除用户成功！');" +
                        "window.location.href='welcome.jsp'</script>");
            } else {
                out.print("<script>alert('删除用户成功！');" +
                        "window.location.href='welcome.jsp'</script>");
            }
        }
        else if ("chaxun".equals(flag)) {
            String p1 = request.getParameter("username");
            String p2 = request.getParameter("pass");

            System.out.println("this is :" + p1 + "\npassword:" + p2);
            userinfo u = impl.queryByExample(p1, p2);

            //管理员登录
            if (p1.equals("admin") && p2.equals("123456")) {
                request.getSession().setAttribute("currusername", "管理员admin");//将登录的用户设置在session范围内
                request.getRequestDispatcher("welcome.jsp").forward(request, response);
            }
            //顾客登录
            else if (u.getId() != null) {
                request.getSession().setAttribute("currUser", u);//将登录的用户设置在session范围内
                request.getSession().setAttribute("currusername", u.getUsername());
                List<fruitinfo> listfruit = implf.queryAllFruit();
                request.setAttribute("listfruitzxy", listfruit);
                request.getRequestDispatcher("cstmlist.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("loginerror.jsp").forward(request, response);
            }
        }
        else if ("toAddUserPage".equals(flag)) {
            response.sendRedirect("adduser.jsp");
        }
        else if ("toUpdateUserPage".equals(flag)) {
            response.sendRedirect("modifyuser.jsp");
        }
        else if ("toDelUserPage".equals(flag)) {
            response.sendRedirect("deleteuser.jsp");
        }
        else if ("chaxunAll".equals(flag)) {
            List<userinfo> list = impl.queryAll();

            request.setAttribute("list", list);

            request.getRequestDispatcher("list.jsp").forward(request, response);
        }
    }
}