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
public class OrderDTO
{
    private int id;
    private int userId;
    
    public OrderDTO(int id, int userId)
    {
        this.id = id;
        this.userId = userId;
    }
    
    public int getId(){return id;}
    public int getUserId(){return userId;}
}
