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
public class LineItemsDTO
{
    private int orderId;
    private int productId;
    private String productName;
    private int qty;
    private float price;
    
    public LineItemsDTO(int orderId, int productId, String productName, int qty, float price)
    {
        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.qty = qty;
        this.price = price;
    }
    
    public int getOrderId(){return orderId;}
    public int getProductId(){return productId;}
    public String getProductName(){return productName;}
    public int getQty(){return qty;}
    public float getPrice(){return price;}
    
}