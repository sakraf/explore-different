<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">
<title>Explore Different - Bike Shop</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Lato", sans-serif}
.w3-bar,h1,button {font-family: "Montserrat", sans-serif}
.fa-bicycle,.fa-search {font-size:200px}
</style>
<body>

<!-- Navbar -->
<div class="w3-top">
  <div class="w3-bar w3-yellow w3-card w3-left-align w3-large">
    <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-green w3-large w3-green" href="javascript:void(0);" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
    <a href="http://localhost:8080/explore-different/" class="w3-bar-item w3-button w3-padding-large w3-green">Home</a>
    <a href="http://localhost:8080/explore-different/shop" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-green">Shop</a>
    <a href="http://localhost:8080/explore-different/login" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-green">Login</a>
    <a href="http://localhost:8080/explore-different/register" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-green">Sign up</a>
    <a href="http://localhost:8080/explore-different/customer?action=cart" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-green">Your cart</a>
    <a href="http://localhost:8080/explore-different/customer?action=logout" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-green w3-display-right">Logout</a>
  </div>

  <!-- Navbar on small screens -->
  <div id="navDemo" class="w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium w3-large">
      <a href="http://localhost:8080/webapplication" class="w3-bar-item w3-button w3-padding-large">Home</a>
    <a href="http://localhost:8080/explore-different/shop" class="w3-bar-item w3-button w3-padding-large">Shop</a>
    <a href="http://localhost:8080/explore-different/login" class="w3-bar-item w3-button w3-padding-large">Login</a>
    <a href="http://localhost:8080/explore-different/register" class="w3-bar-item w3-button w3-padding-large">Sign up</a>
    <a href="http://localhost:8080/explore-different/customer?action=cart" class="w3-bar-item w3-button w3-padding-large">Your cart</a>
    <a href="http://localhost:8080/explore-different/customer?action=logout" class="w3-bar-item w3-button w3-padding-large">Logout</a>
  </div>
</div>

<!-- Header -->
<header class="w3-container w3-yellow w3-center" style="padding:128px 16px">
  <h1 class="w3-margin w3-jumbo">EXPLORE DIFFERENT</h1>
  <p class="w3-xlarge">We care about the environment </p>
  <a href="http://localhost:8080/explore-different/shop" button class="w3-button w3-black w3-padding-large w3-large w3-margin-top">View Shop</button></a>
</header>

<!-- First Grid -->
<div class="w3-row-padding w3-padding-64 w3-container">
  <div class="w3-content">
    <div class="w3-twothird">
      <h1>Welcome </h1>
      <h5 class="w3-padding-32">My first Java Web application. </h5>

      <p class="w3-text-grey">Lets list a few reasons why we consider that using a bike instead of a car is better. Its cheaper. Its healthier. Its way more fun. Parking is easier. It helps society (less tear and wear on the public roads along with less pollution in the air). Explore new areas, new roads, new routes. Its more engaging. </p>
    </div>

    <div class="w3-third w3-center">

      <i class="fa fa-bicycle w3-padding-64 w3-text-green"></i>
    </div>
  </div>
</div>

<!-- Second Grid -->
<div class="w3-row-padding w3-light-grey w3-padding-64 w3-container">
  <div class="w3-content">
    <div class="w3-third w3-center">
      <i class="fa fa-search w3-padding-64 w3-text-green w3-margin-right"></i>
    </div>

    <div class="w3-twothird">
      <h1>How does it work ?</h1>
      <h5 class="w3-padding-32">Compare the bike and prices, find what fits you and we do the rest!</h5>
      <h6 class="w3-text-grey">You can buy a good-quality road or mountain bike directly from our website and we ship it to your address in one working day.</h6>

    </div>
  </div>
</div>

<div class="w3-container w3-yellow w3-center w3-padding-64">
    <h1 class="w3-margin w3-xlarge">Quote of the day: live green</h1>
</div>

<!-- Footer -->
<footer class="w3-container w3-padding-64 w3-center w3-opacity">
  <div class="w3-xlarge w3-padding-32">
    <p> Contact number +40XXXXXXXXX</p>
    <i class="fa fa-instagram w3-hover-opacity"></i>
 </div>
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
var Tawk_API=Tawk_API||{}, Tawk_LoadStart=new Date();
(function(){
var s1=document.createElement("script"),s0=document.getElementsByTagName("script")[0];
s1.async=true;
s1.src='https://embed.tawk.to/5dadfeb2df22d91339a04955/default';
s1.charset='UTF-8';
s1.setAttribute('crossorigin','*');
s0.parentNode.insertBefore(s1,s0);
})();
</script>

</body>
</html>
