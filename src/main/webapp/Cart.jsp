<%-- 
    Document   : Cart
    Created on : 27-09-2018, 12:22:33
    Author     : Jesper
--%>

<%@page import="jhc.presentation.FrontController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jhc.data.LineItemDTO"%>
<%@page import="jhc.presentation.Utils"%>
<%@page import="java.util.ArrayList"%>
<%
    ArrayList<LineItemDTO> products = (ArrayList<LineItemDTO>)request.getSession().getAttribute("lineItems");
    String productsListItems = Utils.cartListItems(products);
    float total = Utils.calculateCartTotals(products).getTotal();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="bootstrap/bootstrapcdn.jsp"></jsp:include>
    </head>
    <body>
        <div class="container">
            <jsp:include page="ViewTop/view.jsp"></jsp:include>
            <form action="FrontController?origin=<%= FrontController.CREATE_ORDER %>" method="POST">
            <div class="row">
                <div class="col-md-8">
                    <h4 class="mb-3">Payment</h4>
                    <div class="d-block my-3">
                    <div class="custom-control custom-radio">
                      <input id="credit" name="paymentMethod" type="radio" class="custom-control-input" checked="" required="">
                      <label class="custom-control-label" for="credit">Credit card</label>
                    </div>
                    <div class="custom-control custom-radio">
                      <input id="debit" name="paymentMethod" type="radio" class="custom-control-input" required="">
                      <label class="custom-control-label" for="debit">Debit card</label>
                    </div>
                    <div class="custom-control custom-radio">
                      <input id="paypal" name="paymentMethod" type="radio" class="custom-control-input" required="">
                      <label class="custom-control-label" for="paypal">PayPal</label>
                    </div>
                  </div>
                    
                    <div class="row">
              <div class="col-md-6 mb-3">
                <label for="cc-name">Name on card</label>
                <input type="text" class="form-control" id="cc-name" placeholder="">
                <small class="text-muted">Full name as displayed on card</small>
              </div>
              <div class="col-md-6 mb-3">
                <label for="cc-number">Credit card number</label>
                <input type="text" class="form-control" id="cc-number" placeholder="">
              </div>
            </div>
                    <div class="row">
              <div class="col-md-3 mb-3">
                <label for="cc-expiration">Expiration</label>
                <input type="text" class="form-control" id="cc-expiration" placeholder="">
              </div>
              <div class="col-md-3 mb-3">
                <label for="cc-cvv">CVV</label>
                <input type="text" class="form-control" id="cc-cvv" placeholder="">
              </div>
            </div>
                    <hr class="mb-4">
                    <button class="btn btn-primary btn-lg btn-block" type="submit">Continue to checkout</button>
                </div>
                <div class="col-md-4">
                    <a href="./" class="btn btn-primary btn-block btn-sm" style="margin-bottom: 10px; margin-top: 5px;">Tilføj flere vare</a>
                    <div class="col-md-12">
                    <h4 class="d-flex justify-content-between align-items-center mb-3">
                      <span class="text-muted">Your cart</span>
                      <span class="badge badge-secondary badge-pill"><%= products.size() %></span>
                    </h4>
                    <ul class="list-group mb-3">
                          <%= productsListItems %>

                      <li class="list-group-item d-flex justify-content-between">
                        <span>Total (DKK)</span>
                        <strong><%= total %>,- kr</strong>
                      </li>
                    </ul>
                  </div>
                </div>
            </div>
            </form>
        </div>
    </body>
</html>
