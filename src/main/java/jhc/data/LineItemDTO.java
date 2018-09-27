/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jhc.data;

/**
 *
 * @author Claus
 */
public class LineItemDTO
{
    private int orderId;
    private int productId;
    private String productName;
    private int qty;
    private float price;
    
    public LineItemDTO(int orderId, int productId, String productName, int qty, float price)
    {
        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.qty = qty;
        this.price = price;
    }
    
    /**
     * Constructor for line items in cart, that do not have an order id yet.
     * @param productId
     * @param qty
     * @param price 
     */
    public LineItemDTO(int productId, int qty, float price)
    {
        this.productId = productId;
        this.qty = qty;
        this.price = price;
    }
    
    public int getOrderId(){return orderId;}
    public int getProductId(){return productId;}
    public String getProductName(){return productName;}
    public int getQty(){return qty;}
    public float getPrice(){return price;}
    
}
