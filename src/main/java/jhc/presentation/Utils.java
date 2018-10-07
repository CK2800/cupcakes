/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jhc.presentation;

import java.util.ArrayList;
import jhc.data.ProductDTO;
import jhc.data.LineItemDTO;
import jhc.data.OrderDTO;
import jhc.data.UserDTO;

/**
 *
 * @author Claus
 */
public class Utils
{  
    public static String LineItemsAsTable(ArrayList<LineItemDTO> lineItems)
    {
        String table = "";
        for(LineItemDTO item : lineItems)
        {
            table += "<tr>";
            table += "<td>" + item.toString() + "</td>";
            table += "<td class=\"text-center\">" + item.getPrice() + "</td>";
            table += "<td class=\"text-center\">" + item.getQty() + "</td>";
            table += "<td class=\"text-right\">" + item.getPrice() * item.getQty() + "</td>";
            table += "</tr>";
        }
        return table;
    }
    
    public static String OrdersAsHtmlTable(ArrayList<OrderDTO> orders)
    {
        String table = "<table class=\"table\">" +
                       "<thead class=\"thead-dark\">" + 
                       "<tr><th scope=\"col\">#</th><th scope=\"col\">Id</th></tr>" +
                       "</thead>" + 
                       "<tbody>";
        for(OrderDTO order : orders)
        {
            table += "<tr><th scope=\"row\"></th>" +
                     "<td><a href=FrontController?origin=" + FrontController.SHOW_INVOICE + "&orderId=" + order.getId() + ">" + order.getId() + "</a></td>" + 
                     "</tr>";
        }
        table += "</tbody></table>";
        return table;
    }
    /**
     * Calculates totals of the virtual shopping cart from the provided collection of line items.
     * @param lineItems ArrayList of LineItemDTO objects.
     * @return CartTotals
     */
    public static CartTotals calculateCartTotals(ArrayList<LineItemDTO> lineItems)
    {
        // Calculate total of cart.
        float total = 0;
        int count = 0;
        CartTotals cartTotals;
        if (lineItems != null)
        {            
            for(LineItemDTO lineItem : lineItems)
            {
                total += lineItem.getQty() * lineItem.getPrice();            
                count += lineItem.getQty();
            }  
        }
        return new CartTotals(count, total);        
    }
    
    /**
     * Builds a HTML anchor element with 
     * @param lineItems
     * @param user
     * @return 
     */
    public static String cartDetails(ArrayList<LineItemDTO> lineItems, UserDTO user)
    {        
        String cartHTML = (user != null) ? user.getUsername() + " " : "Anonymous user ";
        float total = 0;
        int count = 0;
        
        // Calculate total of cart.
        CartTotals cartTotals = calculateCartTotals(lineItems);
        
        if(cartTotals.getCount() > 0)
        {
            cartHTML += "<a href='/cupcakes/FrontController?origin=" + FrontController.CHECKOUT + "'>" + cartTotals.getCount() + " cupcakes in basket, total: " + cartTotals.getTotal() + ",- kr (DKK)</a>";
        }
        else
        {
            cartHTML = "Intet i kurven";
        }
        
        return cartHTML;
    }
    
    public static String cartListItems(ArrayList<LineItemDTO> lineItems)
    {
        String listitems = "";
        for (LineItemDTO lineItem : lineItems)
        {
            listitems += "<li class='list-group-item d-flex justify-content-between lh-condensed'><div>" +
                         "<h6 class='my-0'>" + lineItem.toString() + "</h6>" +
                         //<small class="text-muted">Brief description</small>
                        "</div>" +
                        "<span class='text-muted'>" + lineItem.getQty() * lineItem.getPrice() + "</span></li>";
        }
        return listitems;
    }
    
    /**
     * Converts an ArrayList of ProductDTO objects to a HTML select element.
     * @param products Collection of ProductDTO objects.
     * @param htmlElementName The name of the select html element.
     * @param htmlElementId The id of the select element.
     * @return String
     */
    public static String ProductDropDown(ArrayList<ProductDTO> products, String htmlElementName, String htmlElementId)
    {        
        String dropdown = "<select class=\"custom-select d-block w-100\" required=\"\" id="+htmlElementId+" name="+htmlElementName+">";
        for(ProductDTO product : products)
            dropdown += "<option value=" + product.getId() + ">"+ product.getName() +"</option>";
        dropdown += "</select>";
        return dropdown;
    }
}
