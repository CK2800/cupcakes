<%-- 
    Document   : recipe
    Created on : 26-09-2018, 11:27:56
    Author     : Claus
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="jhc.data.ImageDTO"%>
<%@page import="jhc.data.RecipeDTO"%>
<%@page import="jhc.logic.RecipeDAO"%>
<%
    int recipeId = Integer.parseInt(request.getParameter("id"));
    RecipeDTO recipeDTO = RecipeDAO.getSingleRecipe(recipeId);
    ArrayList<ImageDTO> images = RecipeDAO.getRecipeImages(recipeId);
    String imageHTML = "";
    for(ImageDTO image : images)
    {
        imageHTML += "<img class='img-responsive img-rounded mb-lg' src='"+ image.getUrl() +"' style='max-width: 100%;' />";
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recipe - Recipes'R'Us</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class='col-md-8'>
                    <h3>Opskrift til <%= recipeDTO.getHeadline() %></h3>
                    <%= imageHTML != "" ? "" + imageHTML + "" : "" %>
                </div>
                <div class="col-md-4">
                    <h5>Ingredients</h5>
                    <%= recipeDTO.getIngredients() %>
                    <br/>
                    <h5>Instructions</h5>
                    <%= recipeDTO.getInstructions() %>
                </div>
            </div>
                <a href="<%= request.getContextPath() %>/FrontController" class="btn btn-link btn-sm">Back to recipes list</a>
        </div>
                    
    </body>
</html>
