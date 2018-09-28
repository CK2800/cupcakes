<%@page import="jhc.data.UserDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jhc.presentation.Utils"%>
<%@page import="jhc.data.LineItemDTO"%>

<%
    ArrayList<LineItemDTO> lineItems = (ArrayList<LineItemDTO>)request.getSession().getAttribute("lineItems");
    UserDTO user = (UserDTO)request.getSession().getAttribute("userDTO");
%>
<div class="col-md-4">
    <p><%= Utils.cartDetails(lineItems, user) %></p>
</div>