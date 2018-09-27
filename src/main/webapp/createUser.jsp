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
        <link href="createuser.min.css" rel="stylesheet" type="text/css">

        <!--
             <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
             <title>JSP Page</title>
        -->
    </head>
    <body>
        <div id="container">

            <div class="topnav">
                <a class="active" href="./">Home</a>
                <a href="/FrontController?origin=">Create user</a>
                <a href="/FrontController?origin=">Login</a>
                
            </div>
            
            <h1>Create user page</h1>

            <%= errorMessage%>
            <form action="FrontController" method="POST">
                <input type="hidden" name="origin" value="<%= FrontController.LOGIN%>" />

        
                <img src="https://www.fifteenspatulas.com/wp-content/uploads/2011/10/Chocolate-Peanut-Butter-Cupcakes-Fifteen-Spatulas-14-640x959.jpg" alt="Cupcake" style="width:500px;height:450px;"/> 
                
                <label>Email</label>
                <input type="text" name="name" placeholder="Username" class="form-control"/>
                <label>Username</label>
                <input type="password" name="password" placeholder="Password" />
                <label>Password</label>
                <input type="password" name="password" placeholder="Password" />
                <input type="submit" value="Create User"/>            
            </form>
        </div>
    </body>
</html>
