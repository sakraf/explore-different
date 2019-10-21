<%@page import="skf.bean.Bike"%>
<%@page import="java.util.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*,javax.servlet.*" %>
<%@page import="skf.servlet.UserServlet"%>
<%@page import="skf.controller.SQLControl"%>
<%@ page import="java.io.*, java.sql.*" %>
<%@ page errorPage = "ShowError.jsp" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List products</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <style>
            body,
            h1,
            h2,
            h3,
            h4,
            h5,
            h6 {
                font-family: "Lato", sans-serif
            }

            .w3-bar,
            h1,
            button {
                font-family: "Montserrat", sans-serif
            }

            table,
            th,
            td {
                margin-left: auto;
                margin-right: auto;
                padding: 10px;
                border: 1px solid black;
                border-collapse: collapse;
            }
        </style>

        <link rel="stylesheet" href="css/normalize.css">
        <link href='https://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="css/main.css">
        <style>
            <%@include file="../css/loginregister.css"%>
        </style>

    </head>

    <body>

        <!-- Navbar -->
        <div class="w3-top">
            <div class="w3-bar w3-white w3-card w3-left-align w3-large">
                <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-green" href="javascript:void(0);" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
                <a href="http://localhost:8080/explore-different/" class="w3-bar-item w3-button w3-padding-large w3-hover-green">Home</a>
                <a href="http://localhost:8080/explore-different/shop" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-green">Shop</a>
                <a href="http://localhost:8080/explore-different/login" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-green">Login</a>
                <a href="http://localhost:8080/explore-different/register" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-green">Sign up</a>
                <a href="http://localhost:8080/explore-different/customer?action=cart" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-green">Your cart</a>
                <a href="http://localhost:8080/explore-different/customer?action=logout" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-green w3-display-right">Logout</a>
            </div>

            <!-- Navbar on small screens -->
            <div id="navDemo" class="w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium w3-large">
                <a href="http://localhost:8080/explore-different" class="w3-bar-item w3-button w3-padding-large">Home</a>
                <a href="http://localhost:8080/explore-different/shop" class="w3-bar-item w3-button w3-padding-large">Shop</a>
                <a href="http://localhost:8080/explore-different/login" class="w3-bar-item w3-button w3-padding-large">Login</a>
                <a href="http://localhost:8080/explore-different/register" class="w3-bar-item w3-button w3-padding-large">Sign up</a>
                <a href="http://localhost:8080/explore-different/customer?action=cart" class="w3-bar-item w3-button w3-padding-large">Your cart</a>
                <a href="http://localhost:8080/explore-different/customer?action=logout" class="w3-bar-item w3-button w3-padding-large">Logout</a>
            </div>
        </div>
        </br>

        <%!
            SQLControl control = new SQLControl();
             ArrayList<Bike> arrP;
        %>

            <%
            try{
            arrP = control.selectAllProduct();
               } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    }
        %>
                <br>
                <br>
                <h1>Welcome to the shop</h1>
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Image</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>

                        <%  if (arrP != null) {
                        for (int i = 0; i < arrP.size(); i++) {
                %>
                            <tr>

                                <td>
                                    <%= arrP.get(i).getBikeId()%>
                                </td>
                                <td>
                                    <%= arrP.get(i).getBikeName()%>
                                </td>
                                <td>
                                    <%= arrP.get(i).getBikePrice()%> RON</td>
                                <td><img src="<%=arrP.get(i).getImageUrl()%>" + style='width:auto;max-height:150px;padding:5px;align=center;' </td>
                                    <td>
                                        <a href="ProductServlet?id=<%=arrP.get(i).getBikeId()%>">
                                            <input type="submit" value="Buy" />
                                        </a>

                                    </td>
                            </tr>
                            <% }
                    }%>
                    </tbody>
                </table>
                <div style="text-align:center">
                    <p><a href="http://localhost:8080/explore-different/customer?action=cart">View Shopping Cart</a></p>
                </div>
                <!-- Footer -->
                <footer class="w3-container w3-padding-64 w3-center w3-opacity">
                    <p>Project by <a href="https://github.com/sakraf" target="_blank">Farkas Vlad</a></p>
                </footer>

                <script>
                    // Used to toggle the menu on small screens when clicking on the menu button
                    function myFunction() {
                        var x = document.getElementById("navDemo");
                        if (x.className.indexOf("w3-show") == -1) {
                            x.className += " w3-show";
                        } else {
                            x.className = x.className.replace(" w3-show", "");
                        }
                    }
                </script>

                <script type="text/javascript">
                    var Tawk_API = Tawk_API || {},
                        Tawk_LoadStart = new Date();
                    (function() {
                        var s1 = document.createElement("script"),
                            s0 = document.getElementsByTagName("script")[0];
                        s1.async = true;
                        s1.src = 'https://embed.tawk.to/5dadfeb2df22d91339a04955/default';
                        s1.charset = 'UTF-8';
                        s1.setAttribute('crossorigin', '*');
                        s0.parentNode.insertBefore(s1, s0);
                    })();
                </script>

    </body>

    </html>

