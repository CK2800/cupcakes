<%-- 
    Document   : invoiceDetails
    Created on : 28-09-2018, 09:36:24
    Author     : Jesper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <div class="row">
                <div class="col-xs-12">
                        <div class="invoice-title">
                                <h2>Invoice</h2><h3 class="pull-right">Order # 12345</h3>
                        </div>
                        <hr>
                        <div class="row">
                                <div class="col-xs-6">
                                        <address>
                                        <strong>Billed To:</strong><br>
                                                John Smith<br>
                                                1234 Main<br>
                                                Apt. 4B<br>
                                                Springfield, ST 54321
                                        </address>
                                </div>
                                <div class="col-xs-6 text-right">
                                        <address>
                                        <strong>Shipped To:</strong><br>
                                                Jane Smith<br>
                                                1234 Main<br>
                                                Apt. 4B<br>
                                                Springfield, ST 54321
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
                                                                <!-- foreach ($order->lineItems as $line) or some such thing here -->
                                                                <tr>
                                                                        <td>BS-200</td>
                                                                        <td class="text-center">$10.99</td>
                                                                        <td class="text-center">1</td>
                                                                        <td class="text-right">$10.99</td>
                                                                </tr>
                                        <tr>
                                                                        <td>BS-400</td>
                                                                        <td class="text-center">$20.00</td>
                                                                        <td class="text-center">3</td>
                                                                        <td class="text-right">$60.00</td>
                                                                </tr>
                                        <tr>
                                                                <td>BS-1000</td>
                                                                        <td class="text-center">$600.00</td>
                                                                        <td class="text-center">1</td>
                                                                        <td class="text-right">$600.00</td>
                                                                </tr>
                                                                <tr>
                                                                        <td class="thick-line"></td>
                                                                        <td class="thick-line"></td>
                                                                        <td class="thick-line text-center"><strong>Subtotal</strong></td>
                                                                        <td class="thick-line text-right">$670.99</td>
                                                                </tr>
                                                                <tr>
                                                                        <td class="no-line"></td>
                                                                        <td class="no-line"></td>
                                                                        <td class="no-line text-center"><strong>Shipping</strong></td>
                                                                        <td class="no-line text-right">$15</td>
                                                                </tr>
                                                                <tr>
                                                                        <td class="no-line"></td>
                                                                        <td class="no-line"></td>
                                                                        <td class="no-line text-center"><strong>Total</strong></td>
                                                                        <td class="no-line text-right">$685.99</td>
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