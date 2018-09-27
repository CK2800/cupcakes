<%-- 
    Document   : index
    Created on : 25-09-2018, 15:23:13
    Author     : Claus
--%>

<%@page import="jhc.presentation.FrontController"%>
<%@page import="jhc.logic.RecipeDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jhc.data.RecipeDTO"%>
<%@page import="jhc.data.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    UserDTO userDTO = (UserDTO)request.getSession().getAttribute("userDTO");            
    String bt = "btn btn-";
    String recipesTable = RecipeDAO.getRecipesTable(request.getContextPath());
    String aLogout = "<a href='" + request.getContextPath() + "/FrontController?origin=" + FrontController.LOGOUT + "' class='" + bt + "danger'>Log out</a>";
    String aLogin  = "<a href='" + request.getContextPath() + "/FrontController?origin=" + FrontController.LOGIN + "' class='" + bt + "warning'>Log in</a>";
    String aCreateRecipe = "<a href='" + request.getContextPath() + "/FrontController?origin=" + FrontController.CREATE_RECIPE + "' class='" + bt + "secondary'>Create recipe</a>";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome - Recipes'R'Us</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </head>
    <body>     
        <div class="container">
        <%-- is there a user, print out username. --%>        
        <h1>Velkommen <%= (userDTO != null ? userDTO.getUsername(): " til Cupcakes") %>!</h1>
        <%-- are there any cupcakes, print them. --%>
        <div class="row">
                <div class="col-md-3" style="margin-top: 35px;">
                <label for="zip">Zip</label>
                <input type="text" class="form-control" id="zip" placeholder="" required="">
                <div class="invalid-feedback">
                  Zip code required.
                </div>
              </div>
              <div class="col-md-7">
                <label for="country">Country</label>
                <select class="custom-select d-block w-100" id="country" required="">
                  <option value="">Choose...</option>
                  <option>United States</option>
                </select>
                <div class="invalid-feedback">
                  Please select a valid country.
                </div>
                <label for="state">State</label>
                <select class="custom-select d-block w-100" id="state" required="">
                  <option value="">Choose...</option>
                  <option>California</option>
                </select>
                <div class="invalid-feedback">
                  Please provide a valid state.
                </div>
              </div>
                <div class="col-md-2" style="margin-top: 65px;">
                <button type="button" class="btn btn-success btn-lg">Success</button>
              </div>
            </div>
        <%-- are there any recipes, print them. --%>
        <%-- Login button or log out button. --%>
        <%= userDTO != null ? aLogout : aLogin %>
        <%-- Create recipe if user is logged in --%>
        <%= userDTO != null ? aCreateRecipe : "" %>
        </div>
    </body>
</html>
