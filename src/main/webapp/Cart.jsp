<%-- 
    Document   : Cart
    Created on : 27-09-2018, 12:22:33
    Author     : Jesper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container" style="padding-top: 25px;">
            <h2>Checkout</h2>
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
                <input type="text" class="form-control" id="cc-name" placeholder="" required="">
                <small class="text-muted">Full name as displayed on card</small>
                <div class="invalid-feedback">
                  Name on card is required
                </div>
              </div>
              <div class="col-md-6 mb-3">
                <label for="cc-number">Credit card number</label>
                <input type="text" class="form-control" id="cc-number" placeholder="" required="">
                <div class="invalid-feedback">
                  Credit card number is required
                </div>
              </div>
            </div>
                    <div class="row">
              <div class="col-md-3 mb-3">
                <label for="cc-expiration">Expiration</label>
                <input type="text" class="form-control" id="cc-expiration" placeholder="" required="">
                <div class="invalid-feedback">
                  Expiration date required
                </div>
              </div>
              <div class="col-md-3 mb-3">
                <label for="cc-cvv">CVV</label>
                <input type="text" class="form-control" id="cc-cvv" placeholder="" required="">
                <div class="invalid-feedback">
                  Security code required
                </div>
              </div>
            </div>
                    <hr class="mb-4">
                    <button class="btn btn-primary btn-lg btn-block" type="submit">Continue to checkout</button>
                </div>
                <div class="col-md-4">
                    <div class="col-md-12">
                    <h4 class="d-flex justify-content-between align-items-center mb-3">
                      <span class="text-muted">Your cart</span>
                      <span class="badge badge-secondary badge-pill">3</span>
                    </h4>
                    <ul class="list-group mb-3">
                      <li class="list-group-item d-flex justify-content-between lh-condensed">
                        <div>
                          <h6 class="my-0">Product name</h6>
                          <small class="text-muted">Brief description</small>
                        </div>
                        <span class="text-muted">$12</span>
                      </li>
                      <li class="list-group-item d-flex justify-content-between lh-condensed">
                        <div>
                          <h6 class="my-0">Second product</h6>
                          <small class="text-muted">Brief description</small>
                        </div>
                        <span class="text-muted">$8</span>
                      </li>
                      <li class="list-group-item d-flex justify-content-between lh-condensed">
                        <div>
                          <h6 class="my-0">Third item</h6>
                          <small class="text-muted">Brief description</small>
                        </div>
                        <span class="text-muted">$5</span>
                      </li>
                      <li class="list-group-item d-flex justify-content-between bg-light">
                        <div class="text-success">
                          <h6 class="my-0">Promo code</h6>
                          <small>EXAMPLECODE</small>
                        </div>
                        <span class="text-success">-$5</span>
                      </li>
                      <li class="list-group-item d-flex justify-content-between">
                        <span>Total (DKK)</span>
                        <strong>$20</strong>
                      </li>
                    </ul>
                  </div>
                </div>
            </div>
        </div>
    </body>
</html>
