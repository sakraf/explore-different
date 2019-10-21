package skf.servlet;

import skf.bean.Cart;
import skf.controller.SQLControl;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "ShoppingCartServlet", urlPatterns = {"/ShoppingCartServlet"})

public class ShoppingCartServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        SQLControl control = new SQLControl();
        //get session
        HttpSession session = request.getSession();
        //get cUsername,payMethod and date
        String cUsername = (String) session.getAttribute("username");
        String payMethod = request.getParameter("txtMethod");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = dateFormat.format(new Date());

        PrintWriter out = response.getWriter();
        if (session.getAttribute("cart") != null) {
            try {
                //insert order table
                control.insertOrder(date, payMethod, cUsername);
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println("SQL Error");
            }
            try {
                //insert order line table
                int orderID = control.getlastedOrID();
                ArrayList<Cart> arrC = (ArrayList<Cart>) session.getAttribute("cart");
                for (int i = 0; i < arrC.size(); i++) {
                    String pID = arrC.get(i).getpID();
                    int quantity = arrC.get(i).getQuantity();
                    int price = arrC.get(i).getpPrice();

                    control.insertOrderLine(orderID, pID, quantity, price);
                }
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println("SQL Error");
            }
            session.removeAttribute("cart");
            response.sendRedirect(request.getContextPath() + "/shop");
        } else {
            response.sendRedirect(request.getContextPath() + "/shop");
        }

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
