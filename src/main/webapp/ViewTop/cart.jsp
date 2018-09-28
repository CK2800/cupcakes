<%@page import="jhc.data.UserDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jhc.presentation.Utils"%>
<%@page import="jhc.data.LineItemDTO"%>

<%
    ArrayList<LineItemDTO> lineItems = (ArrayList<LineItemDTO>)request.getSession().getAttribute("lineItems");
    UserDTO user = (UserDTO)request.getSession().getAttribute("userDTO");
%>
<div class="col-md-6">
    <p><%= Utils.cartDetails(lineItems, user) %> <img src="https://cdn4.iconfinder.com/data/icons/simple-peyment-methods/512/credit_card-512.png" style="width: 32px; height: 32px;"></p>
</div>