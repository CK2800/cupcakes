/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jhc.presentation;

import java.util.ArrayList;
import jhc.data.ProductDTO;
import jhc.data.LineItemDTO;
import jhc.data.UserDTO;

/**
 *
 * @author Claus
 */
public class Utils
{
    public static class CartTotals
    {
        private int count;
        private float total;
        public int getCount(){return count;}
        public float getTotal(){return total;}
        public CartTotals(int count, float total)
        {
            this.count = count;
            this.total = total;
        }
    }
    
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
    
    public static String cartDetails(ArrayList<LineItemDTO> lineItems, UserDTO user)
    {
        
        String cartHTML = (user != null) ? user.getUsername() + " " : "";
        float total = 0;
        int count = 0;
        
        // Calculate total of cart.
        CartTotals cartTotals = calculateCartTotals(lineItems);
        
        cartHTML += cartTotals.getCount() + " cupcake parts in basket";
        if (cartTotals.getCount() > 0)
            cartHTML += ", total: " + cartTotals.getTotal();
        
        return cartHTML;
    }
    
    public static String cartListItems(ArrayList<LineItemDTO> lineItems)
    {
        String listitems = "";
        for (LineItemDTO lineItem : lineItems)
        {
            listitems += "<li class='list-group-item d-flex justify-content-between lh-condensed'><div>" +
                         "<h6 class='my-0'>" + lineItem.getProductName() + "</h6>" +
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
