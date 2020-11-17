package Controller;

import dao.impl.FruitinfoDaoImpl;
import model.fruitinfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ListCartServlet")
public class ListCartServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        FruitinfoDaoImpl implf = new FruitinfoDaoImpl();
        List<fruitinfo> listfruit = implf.queryAllFruit();
        request.setAttribute("listfruitzxy", listfruit);
        request.getRequestDispatcher("cstmlist.jsp").forward(request, response);

    }
}
