<%-- 
    Document   : createUser
    Created on : 27-09-2018, 10:36:03
    Author     : Jesper
--%>

<!--
    http://localhost:8084/cupcakes/FrontController?origin=createUser
-->

<%@page import="jhc.presentation.FrontController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Object oErrorMessage = request.getAttribute("errorMessage");
    String errorMessage = (oErrorMessage == null ? "" : "<div class='alert alert-danger'>" + oErrorMessage.toString() + "</div>");
%>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="utf-8">
        <link href="css/createuser.min.css" rel="stylesheet" type="text/css">

        <!--
             <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
             <title>JSP Page</title>
        -->
    </head>
    <body>
        <div id="container">
            <h1> <a href="./" >Cupcakes</a></h1>
            <div class="topnav">
                <a href="./">Home</a>
                <a href="/cupcakes/FrontController?origin=<%= FrontController.LOGIN %>">Login</a>
            </div>

            <%= errorMessage%>
            <form action="FrontController" method="POST">
                <input type="hidden" name="origin" value="<%= FrontController.LOGIN%>" />

        
                <img src="https://www.fifteenspatulas.com/wp-content/uploads/2011/10/Chocolate-Peanut-Butter-Cupcakes-Fifteen-Spatulas-14-640x959.jpg" alt="Cupcake" style="width:500px;height:450px;"/> 
                <div class="inputValue">
                    <label>Email</label>
                    <input type="text" name="name" placeholder="Email"/>
                </div>
                <div class="inputValue">
                <label>Username</label>
                <input type="password" name="password" placeholder="Username" />
                </div>
                <div class="inputValue">
                <label>Password</label>
                <input type="password" name="password" placeholder="Password" />
                </div>
                <input type="submit" value="Create User" id="create"/>            
            </form>
        </div>
    </body>
</html>
