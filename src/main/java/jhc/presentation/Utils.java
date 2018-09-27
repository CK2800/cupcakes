/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jhc.presentation;

import java.util.ArrayList;
import jhc.data.ProductDTO;

/**
 *
 * @author Claus
 */
public class Utils
{
    /**
     * Converts an ArrayList of ProductDTO objects to a HTML select element.
     * @param products Collection of ProductDTO objects.
     * @param htmlElementName The name of the select html element.
     * @return String
     */
    public static String ProductDropDown(ArrayList<ProductDTO> products, String htmlElementName)
    {
        String dropdown = "<select class=\"custom-select d-block w-100\" required=\"\" name="+htmlElementName+">";
        for(ProductDTO product : products)
            dropdown += "<option value=" + product.getId() + ">"+ product.getName() +"</option>";
        dropdown += "</select>";
        return dropdown;
    }
}
