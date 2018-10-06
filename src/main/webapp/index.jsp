<%-- 
    Document   : index
    Created on : 25-09-2018, 15:23:13
    Author     : Claus
--%>

<%@page import="jhc.presentation.Utils"%>
<%@page import="jhc.presentation.FrontController"%>
<%@page import="jhc.logic.ProductDAO"%>
<%@page import="java.util.ArrayList"%>

<%@page import="jhc.data.ProductDTO"%>
<%@page import="jhc.data.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    UserDTO userDTO = (UserDTO)request.getSession().getAttribute("userDTO");            
    String bt = "btn btn-";
    
    String aLogout = "<a href='" + request.getContextPath() + "/FrontController?origin=" + FrontController.LOGOUT + "' class='" + bt + "danger'>Log out</a>";
    String aLogin  = "<a href='" + request.getContextPath() + "/FrontController?origin=" + FrontController.LOGIN + "' class='" + bt + "warning'>Log in</a>";
    
    ArrayList<ProductDTO> bottoms  = ProductDAO.getProductsOfType(1);
    ArrayList<ProductDTO> toppings = ProductDAO.getProductsOfType(2);
    String bottomsDropDown = Utils.ProductDropDown(bottoms, "bottoms", "bottoms");
    String toppingsDropDown = Utils.ProductDropDown(toppings, "toppings", "toppings");
    UserDTO user = (UserDTO)request.getSession().getAttribute("userDTO");

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome - Recipes'R'Us</title>
        <jsp:include page="bootstrap/bootstrapcdn.jsp"></jsp:include>
    </head>
    <body>     
        <div class="container">
        <jsp:include page="ViewTop/view.jsp"></jsp:include>
        <%-- are there any cupcakes, print them. --%>
        <div class="row">
            <form style="display:inherit; width:100%" action="FrontController" method="<%= FrontController.POST %>">
                <input type="hidden" name="origin" value="<%= FrontController.ADD_TO_BASKET %>" />
                <div class="col-md-3" style="margin-top: 35px;">
                <label for="zip">Qty</label>
                <input type="text" class="form-control" name="qty" id="qty" placeholder="" required="">
              </div>
              <div class="col-md-7">
                <label for="country">Top</label>                
                <%= toppingsDropDown %>
                <label for="state">Bund</label>                
                <%= bottomsDropDown %>
              </div>
                <div class="col-md-2" style="margin-top: 65px;">
                    <input type="submit" value="Bestil" class="btn btn-success btn-lg" />
              </div>
              </form>
            </div>
        <%-- are there any recipes, print them. --%>
        <%-- Login button or log out button. --%>
        <%= userDTO != null ? aLogout : aLogin %>
        
        
        </div>
    </body>    
</html>
