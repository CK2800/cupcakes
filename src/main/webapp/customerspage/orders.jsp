<%-- 
    Document   : orders
    Created on : 28-09-2018, 12:18:18
    Author     : Claus
--%>

<%@page import="jhc.data.OrderDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jhc.logic.OrderDAO"%>
<%@page import="jhc.data.UserDTO"%>
<%
    UserDTO user = (UserDTO)request.getSession().getAttribute("userDTO");
    ArrayList<OrderDTO> orders = OrderDAO.getUserOrders(user);
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
            
            <table class="table">
                <thead class="thead-dark">
                  <tr>
                    <th scope="col">#</th>
                    <th scope="col">First</th>
                    <th scope="col">Last</th>
                    <th scope="col">Handle</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <th scope="row">1</th>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                  </tr>
                </tbody>
              </table>
        </div>
    </body>
</html>
