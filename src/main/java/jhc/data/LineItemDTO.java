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
    private int toppingId;    
    private int bottomId;
    private String toppingName;
    private String bottomName;
    private int qty;
    private float price;
    
    public LineItemDTO(int orderId, int toppingId, int bottomId, String toppingName, String bottomName, int qty, float price)
    {
        this.orderId = orderId;
        this.toppingId = toppingId;
        this.bottomId = bottomId;                
        this.toppingName = toppingName;
        this.bottomName = bottomName;
        this.qty = qty;
        this.price = price;
    }
    
    /**
     * Constructor for line items in cart, that do not have an order id yet.
     * @param toppingId
     * @param bottomId
     * @param toppingName
     * @param bottomName
     * @param qty
     * @param price 
     */
    public LineItemDTO(int toppingId, int bottomId, String toppingName, String bottomName, int qty, float price)
    {
        this.toppingId = toppingId;
        this.bottomId = bottomId;
        this.toppingName = toppingName;
        this.bottomName = bottomName;        
        this.qty = qty;
        this.price = price;
    }
    
    public int getOrderId(){return orderId;}
    public int getToppingId(){return toppingId;}
    public int getBottomId(){return bottomId;}        
    public int getQty(){return qty;}
    public float getPrice(){return price;}
    public void addQty(int qty){this.qty += qty;}
    @Override public String toString(){return qty + " " +  toppingName + "/" + bottomName;}
    
}
