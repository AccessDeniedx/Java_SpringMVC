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

@WebServlet("/ChangeQuantity")
public class ChangeQuantity extends HttpServlet {
    BusinessService service=new BusinessServiceImpl();
    public void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        doGet(request, response);

    }

    public void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        /*Cart cart=(Cart) request.getSession().getAttribute("cart");
        service.clearCart(cart);
        request.getRequestDispatcher("cstmlist.jsp").forward(request, response);*/

        String id = request.getParameter("id");
        String quantity = request.getParameter("quantity");

        Cart cart = (Cart) request.getSession().getAttribute("cart");

        BusinessService service = new BusinessServiceImpl();
        service.changeQuantity(id, quantity, cart);

        request.getRequestDispatcher("listcart.jsp").forward(request, response);
    }
}
