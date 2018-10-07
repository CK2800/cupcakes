<%-- 
    Document   : orders
    Created on : 28-09-2018, 12:18:18
    Author     : Claus
--%>

<%@page import="jhc.presentation.Utils"%>
<%@page import="jhc.data.OrderDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jhc.logic.OrderDAO"%>
<%@page import="jhc.data.UserDTO"%>
<%
    UserDTO user = (UserDTO)request.getSession().getAttribute("userDTO");
    ArrayList<OrderDTO> orders = OrderDAO.getUserOrders(user.getId());
    String table = Utils.OrdersAsHtmlTable(orders);
    
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="../bootstrap/bootstrapcdn.jsp"></jsp:include>
    </head>
    <body>
        <div class="container">
            <jsp:include page="../ViewTop/view.jsp"></jsp:include>
            <%= table %>            
        </div>
    </body>
</html>
