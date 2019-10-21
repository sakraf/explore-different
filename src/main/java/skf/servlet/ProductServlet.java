package skf.servlet;

import skf.bean.Bike;
import skf.bean.Cart;
import skf.controller.SQLControl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet (name = "ProductServlet", urlPatterns = {"/ProductServlet"})

public class ProductServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        System.out.println(id);
        SQLControl control = new SQLControl();
        //get session
        HttpSession session = request.getSession();
        ArrayList<Cart> arrCart = new ArrayList<Cart>();
        ArrayList<Bike> arrPro = new ArrayList<Bike>();

        // get product detail
        try {
            arrPro = control.selectProduct(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        //store product information to session
        if (session.getAttribute("cart") == null) {
            //if not exists session cart
            //add new product to cart
            arrCart.add(new Cart(arrPro.get(0).getBikeId(), arrPro.get(0).getBikeName(), arrPro.get(0).getBikePrice(), arrPro.get(0).getImageUrl(), 1));
        } else {
            arrCart = (ArrayList<Cart>) session.getAttribute("cart");
            //if ID already exists
            //increase quantity by 1
            boolean checkID = false;
            for (int i = 0; i < arrCart.size(); i++) {
                if (arrCart.get(i).getpID().equalsIgnoreCase(id)) {
                    arrCart.get(i).setQuantity(arrCart.get(i).getQuantity() + 1);
                    checkID = true;
                    break;
                }
            }
            //if ID doesn't exist
            if (checkID ==false) {
                arrCart.add(new Cart(arrPro.get(0).getBikeId(), arrPro.get(0).getBikeName(), arrPro.get(0).getBikePrice(),arrPro.get(0).getImageUrl(), 1));
            }
        }
        //set attribute for cart
        session.setAttribute("cart", arrCart);
        response.sendRedirect(request.getContextPath() + "/customer?action=cart");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

