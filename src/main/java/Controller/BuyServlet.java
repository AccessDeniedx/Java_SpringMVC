//BuyServlet,获取书并添加到购物车

package Controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.BusinessServiceImpl;
import dao.impl.FruitinfoDaoImpl;
import dao.impl.UserInfoDaoImpl;
import model.Cart;
import model.CartItem;
import model.fruitinfo;
import model.userinfo;

@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
    BusinessServiceImpl service=new BusinessServiceImpl();
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        //1.获取要买的水果id
        String sid=request.getParameter("id");
        fruitinfo fruit =service.findFruit(sid);
        //2.得到购物车
        Cart cart=(Cart)request.getSession().getAttribute("cart");
        if(cart==null){
            cart=new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        //3.添加到购物车中
        cart.add(fruit);

        FruitinfoDaoImpl implf = new FruitinfoDaoImpl();
        List<fruitinfo> listfruit = implf.queryAllFruit();
        request.setAttribute("listfruitzxy", listfruit);
        request.getRequestDispatcher("cstmlist.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

}

