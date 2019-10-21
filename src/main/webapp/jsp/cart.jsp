<%@ page isELIgnored = "false" %>
<%@ page session="true" %>
   <%@page import="skf.bean.Customer"%>
   <%@page import="skf.controller.SQLControl"%>
   <%@ page import = "javax.servlet.http.*,javax.servlet.*,javax.servlet.*" %>
   <%@page import="java.util.ArrayList"%>
   <%@ page import="java.io.*, java.sql.*" %>
   <%@page import="skf.bean.Cart"%>

   <%@page contentType="text/html" pageEncoding="UTF-8"%>
   <!DOCTYPE html>
   <html>
       <head>
           <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
           <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
           <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
           <style>
           input[type=submit]{
             background-color: #4CAF50;
             font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
             border: 0;
             border-radius: 5px;
             cursor: pointer;
             color: #fff;
             font-size:16px;
             font-weight: bold;
             line-height: 1.4;
             padding: 6px 12px;
             width: 180px
           }
           </style>
           <title>Shopping Cart</title>
       </head>
       <body>
           <br>
           <br>
           <div class ="container">
           <h1>Shopping Cart</h1>
           <hr>
           <br>
           <%!
               SQLControl control = new SQLControl();
               ArrayList<Customer> arrCus;
           %>

           <%
               try{
               arrCus = control.selectAllCustomer();
                  } catch (SQLException e) {
                           e.printStackTrace();
                  } catch (ClassNotFoundException e) {
                           e.printStackTrace();
                       }
           %>


           <form action="<%= request.getContextPath()%>/ShoppingCartServlet" method="POST">

             <%
                String user = null;
                user = (String) session.getAttribute("username");
             %>

               </select>
           </p>
           <p>Payment Method: <input type="text" name="txtMethod" value="Ramburs" /></p>
           <table border="0">
           <table class="table table-striped table-hover table-bordered">
               <thead>
                   <tr>
                        <th>Product</th>
                        <th>Quantity</th>
                        <th>Price</th>
                   </tr>
               </thead>
               <tbody>
                   <%--
                       - Get all product that added to cart
                       - total order to be fixed
                   --%>
                   <%!

                       HttpSession newSession;
                       %>
                       <%
                       newSession = request.getSession();
                       if (newSession.getAttribute("cart") != null) {
                           ArrayList<Cart> arrC = (ArrayList<Cart>) newSession.getAttribute("cart");
                           for (int i = 0; i < arrC.size(); i++) {

                   %>
                   <tr>
                       <td><%= arrC.get(i).getpName()%></td>
                       <td><%= arrC.get(i).getQuantity()%></td>
                       <td><%= arrC.get(i).getpPrice()%></td>
                   </tr>
                   <%      }
                   } else {
                   %>
               <h4>Hello <%=user %>, your cart is empty.</h4>
               <%
                   }

               %>
           </tbody>
       </table>


                        <div class="btn-toolbar">
                        <td><a href="http://localhost:8080/explore-different/shop" class="btn btn-primary">Back to shop</a></td>
                        <td><a href="http://localhost:8080/explore-different/customer?action=clearCart" button type="button" class="btn btn-outline-warning">Clear cart</a></td></button>
                        </div>

<span style="display:flex; justify-content:flex-end; width:100%; padding:0;">
       <p><input type="submit" value="Confirm" value ="confirm" /></p>
</span>


</div>

   </body>
   </html>