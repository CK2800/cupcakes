/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jhc.data;

import java.util.ArrayList;

/**
 *
 * @author Claus
 */
public class OrderDTO
{

//    private int id;
//    private int userId;
//    private ArrayList<LineItemDTO> lineItems;
//    
//    public OrderDTO(int id, int userId)
//    {
//        this.id = id;
//        this.userId = userId;
//    }
//    
//    public int getId(){return id;}
//    public int getUserId(){return userId;}
//    
//    public void setLineItems(ArrayList<LineItemsDTO> lineItems)
//    {
//        if (lineItems != null && lineItems)
//    }

    private int id;
    private int userId;
    private ArrayList<LineItemDTO> lineItems;
    
    public OrderDTO(int id, int userId)
    {
        this.id = id;
        this.userId = userId;
    }
    
    public int getId(){return id;}
    public int getUserId(){return userId;}
    
    /**
     * Adds a list of LineItemDTO ojects to this order.
     * PRE: LineItemDTO's order id must match this orders id.
     * @param lineItems
     * @return true if line items were added, false otherwise.
     */
    public boolean setLineItems(ArrayList<LineItemDTO> lineItems)
    {
        if (lineItems != null && lineItems.get(0).getOrderId() == id)
        {
            this.lineItems = lineItems;
            return true;
        }
        return false;
    }

}
