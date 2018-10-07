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
public class ProductDTO
{
    private int id;
    private String type;
    private String name;
    private float price;
    
    public ProductDTO(int id, String type, String name, float price)
    {
        this.id = id;
        this.type = type;
        this.name = name;
        this.price = price;
    }
    
    public int getId(){return id;}
    public String getType(){return type;}
    public String getName(){return name;}
    public float getPrice(){return price;}    
}
