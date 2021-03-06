<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="utf-8">
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

            .fa-bicycle,
            .fa-search {
                font-size: 200px
            }
        </style>

        <title>Sign Up Form</title>
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
                <a href="http://localhost:8080/explore-different/shop" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-green">Shop</a>
                <a href="http://localhost:8080/explore-different/login" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-green">Login</a>
                <a href="http://localhost:8080/explore-different/register" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-green">Sign up</a>
                <a href="http://localhost:8080/explore-different/customer?action=cart" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-green">Your cart</a>
                <a href="http://localhost:8080/explore-different/customer?action=logout" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-green w3-display-right">Logout</a>
            </div>

            <!-- Navbar on small screens -->
            <div id="navDemo" class="w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium w3-large">
                <a href="http://localhost:8080/explore-different/" class="w3-bar-item w3-button w3-padding-large">Home</a>
                <a href="http://localhost:8080/explore-different/shop" class="w3-bar-item w3-button w3-padding-large">Shop</a>
                <a href="http://localhost:8080/explore-different/login" class="w3-bar-item w3-button w3-padding-large">Login</a>
                <a href="http://localhost:8080/explore-different/register" class="w3-bar-item w3-button w3-padding-large">Sign up</a>
                <a href="http://localhost:8080/explore-different/customer?action=cart" class="w3-bar-item w3-button w3-padding-large">Your cart</a>
                <a href="http://localhost:8080/explore-different/customer?action=logout" class="w3-bar-item w3-button w3-padding-large">Logout</a>

            </div>
        </div>
        <form method="post">
            <input type="hidden" name="action" value="register">
            <h1>Sign Up</h1>

            <fieldset>
                <legend><span class="symbol">#</span>Please enter your details</legend>
                <label for="First Name">First Name:</label>
                <input type="text" id="name" placeholder="First Name" name="firstName">

                <label for="Last Name">Last Name:</label>
                <input type="text" id="mail" placeholder="Last Name" name="lastName">

                <label for="username">Username:</label>
                <input type="text" id="username" placeholder="Username" name="username">

                <label for="password">Password:</label>
                <input type="password" id="password" placeholder="Password" name="password">

                <label for="address">Address:</label>
                <input type="text" id="address" placeholder="Shipping Address" name="address">

                <label for="contact">Contact Number:</label>
                <input type="tel" pattern="[0-9]{10}" id="contact" placeholder="07########" name="contact">

            </fieldset>
            <button type="submit">Sign Up</button>
        </form>

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

    </body>

    </html>