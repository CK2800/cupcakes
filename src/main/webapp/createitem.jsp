<%-- 
    Document   : createRecipe
    Created on : 26-09-2018, 08:50:35
    Author     : Claus
--%>

<%@page import="jhc.data.UserDTO"%>
<%@page import="jhc.presentation.FrontController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Grab UserDTO from session.
    UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create a recipe - Recipes'R'Us</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container">
            <h1>Create recipe</h1>
            
            <form action="FrontController" method="POST">
                <input type="hidden" name="origin" value="<%= FrontController.CREATE_RECIPE %>" />
                <input type="hidden" name="userId" value="<%= userDTO.getId() %>" />
                <div class="form-group">
                    <label>Headline</label>
                    <input type="text" name="headline" value="" placeholder="Headline" class="form-control" />
                </div>
                
                <div class="form-group">
                    <label>Instructions</label>
                    <textarea cols="10" rows="10" name="instructions" value="" placeholder="Instructions" class="form-control"></textarea>
                </div>
                <div class="form-group">
                    <label>Ingredients</label>
                    <input type="text" name="ingredients" value="" placeholder="Ingredients" class="form-control" />
                </div>
                <input type="submit" value="Create recipe" class="btn btn-success" />
            </form>
                <a href="<%= request.getContextPath() %>/FrontController" class="btn btn-dark btn-xs">Back to recipes list</a>
        </div>
    </body>
</html>
