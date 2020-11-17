package Controller;

import dao.BusinessService;
import dao.impl.BusinessServiceImpl;
import model.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ClearCartServlet")
public class ClearCartServlet extends HttpServlet {
    BusinessService service=new BusinessServiceImpl();
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cart cart=(Cart) request.getSession().getAttribute("cart");
        service.clearCart(cart);
        request.getRequestDispatcher("/listcart.jsp").forward(request, response);

    }
}
