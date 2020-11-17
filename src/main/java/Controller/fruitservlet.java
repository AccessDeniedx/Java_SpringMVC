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

@WebServlet("/fruitservlet")
public class fruitservlet extends HttpServlet {
    public fruitservlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String flag = request.getParameter("flag");
        FruitinfoDaoImpl implf = new FruitinfoDaoImpl();
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=gb2312");
        if("toAddfruitPage".equals(flag)){
            response.sendRedirect("addfruit.jsp");
        }
        else if("toUpdateFruitPage".equals(flag)){
            response.sendRedirect("modifyfruit.jsp");
        }
        else if("toDelFruitPage".equals(flag)){
            response.sendRedirect("deletefruit.jsp");
        }
        else if("chaxunAllFruit".equals(flag)){
            List<fruitinfo> listfruit = implf.queryAllFruit();

            request.setAttribute("listfruit", listfruit);

            request.getRequestDispatcher("listfruit.jsp").forward(request, response);

        }
        else if ("zengjiaf".equals(flag)) {
            String id = request.getParameter("id");
            String p1 = request.getParameter("fname");
            String p2 = request.getParameter("fprice");

            fruitinfo f = new fruitinfo();
            f.setFNAME(p1);
            f.setFprice(Double.parseDouble(p2));
            f.setFruitid(Integer.parseInt(id));
            int i = implf.addFruit(f);

            if (i>0) {
                out.print("<script>alert('添加水果成功！');" +
                        "window.location.href='welcome.jsp'</script>");
            }else{
                out.print("<script>alert('添加水果失败！');" +
                        "window.location.href='welcome.jsp'</script>");
            }

        }
        else if("xiugaif".equals(flag)){
            String p1 = request.getParameter("fname");
            String p2 = request.getParameter("fprice");
            String p3 = request.getParameter("id");

            fruitinfo f = new fruitinfo();
            f.setFNAME(p1);
            f.setFprice(Double.parseDouble(p2));
            f.setFruitid(Integer.parseInt(p3));
            int i = implf.modifyFruit(f);

            if (i>0) {
                out.print("<script>alert('修改水果成功！');" +
                        "window.location.href='welcome.jsp'</script>");
            }else{
                out.print("<script>alert('修改水果失败！');" +
                        "window.location.href='welcome.jsp'</script>");
            }
            System.out.println();
        }
        else if("shanchuf".equals(flag)){
            String id = request.getParameter("id");
            String p1 = request.getParameter("fname");

            fruitinfo f = new fruitinfo();
            f.setFNAME(p1);
            f.setFruitid(Integer.parseInt(id));

            int i = implf.delFruit(Integer.parseInt(id));

            if (i>0) {
                out.print("<script>alert('删除水果成功！');" +
                        "window.location.href='welcome.jsp'</script>");
            }else{
                out.print("<script>alert('删除水果失败！');" +
                        "window.location.href='welcome.jsp'</script>");
            }
        }
    }
}
