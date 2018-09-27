<%-- 
    Document   : createUser
    Created on : 27-09-2018, 10:36:03
    Author     : Jesper
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
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
        <h1>Create user page</h1>
        
            <%= errorMessage %>
            <form action="FrontController" method="POST">
                <input type="hidden" name="origin" value="<%= FrontController.LOGIN %>" />
                
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
