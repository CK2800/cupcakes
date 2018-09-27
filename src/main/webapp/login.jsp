<%-- 
    Document   : login
    Created on : 25-09-2018, 09:32:56
    Author     : Claus
--%>

<%@page import="jhc.presentation.FrontController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Object oErrorMessage = request.getAttribute("errorMessage");
    String errorMessage = (oErrorMessage == null ? "" : "<div class='alert alert-danger'>"+ oErrorMessage.toString() +"</div>");
    
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login - Recipes'R'Us</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container">
        <h1>Login page</h1>
        
            <%= errorMessage %>
            <form action="FrontController" method="POST">
                <input type="hidden" name="origin" value="<%= FrontController.LOGIN %>" />
                <div class="form-group">
                    <label>Username</label>
                    <input type="text" name="name" placeholder="Username" class="form-control"/>
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input type="password" name="password" placeholder="Password" class="form-control" />
                </div>
                <input type="submit" value="Login" class="btn btn-info btn-lg btn-block" />            
            </form>
        </div>
    </body>
</html>
