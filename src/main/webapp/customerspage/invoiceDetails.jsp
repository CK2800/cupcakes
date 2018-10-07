<%-- 
    Document   : invoiceDetails
    Created on : 28-09-2018, 09:36:24
    Author     : Jesper
--%>
<%@page import="jhc.data.OrderDTO"%>
<%@page import="jhc.data.UserDTO"%>
<%@page import="jhc.presentation.Utils"%>
<%@page import="jhc.presentation.CartTotals"%>

<%
    
    OrderDTO order  = (OrderDTO)request.getAttribute("orderDTO");
    UserDTO user = (UserDTO)request.getSession().getAttribute("userDTO");
    String lineItemsToTable = Utils.LineItemsAsTable(order.getLineItems());
    CartTotals orderTotal = Utils.calculateCartTotals(order.getLineItems());

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
            <div class="row">
                <div class="col-xs-12">
                        <div class="invoice-title">
                                <h2>Invoice</h2><h3 class="pull-right">Order # <%= order.getId() %></h3>
                        </div>
                        <hr>
                        <div class="row">
                                <div class="col-xs-6">
                                        <address>
                                        <strong>Billed To:</strong><br>
                                                <%= user.getUsername() %><br>                                                
                                        </address>
                                </div>
                                <div class="col-xs-6 text-right">
                                        <address>
                                        <strong>Shipped To:</strong><br>
                                                <%= user.getUsername() %><br>
                                        </address>
                                </div>
                        </div>
                        <div class="row">
                                <div class="col-xs-6">
                                        <address>
                                                <strong>Payment Method:</strong><br>
                                                Visa ending **** 4242<br>
                                                jsmith@email.com
                                        </address>
                                </div>
                                <div class="col-xs-6 text-right">
                                        <address>
                                                <strong>Order Date:</strong><br>
                                                March 7, 2018<br><br>
                                        </address>
                                </div>
                        </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                        <div class="panel panel-default">
                                <div class="panel-heading">
                                        <h3 class="panel-title"><strong>Order summary</strong></h3>
                                </div>
                                <div class="panel-body">
                                        <div class="table-responsive">
                                                <table class="table table-condensed">
                                                        <thead>
                                        <tr>
                                                                        <td><strong>Item</strong></td>
                                                                        <td class="text-center"><strong>Price</strong></td>
                                                                        <td class="text-center"><strong>Quantity</strong></td>
                                                                        <td class="text-right"><strong>Totals</strong></td>
                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                                <%= lineItemsToTable %>                                                                                                                                                                                                                                        
                                                                <tr>
                                                                        <td class="no-line"></td>
                                                                        <td class="no-line"></td>
                                                                        <td class="no-line text-center"><strong>Total</strong></td>
                                                                        <td class="no-line text-right"><%= orderTotal.getTotal() %></td>
                                                                </tr>
                                                        </tbody>
                                                </table>
                                        </div>
                                </div>
                        </div>
                </div>
            </div>
        </div>
    </body>
</html>
