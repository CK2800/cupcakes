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
public class UserDTO {
    
    private int id;
    private String username;
    private String password;
    private float balance;
    
    public UserDTO(int id, String name, String password, float balance)
    {
        this.id = id;
        this.name = name;
        this.password = password;
        this.balance = balance;
    }
    
    public int getId(){return id;}
    public String getName(){return name;}
    public String getPassword(){return password;}
    public flot getBalance(){return balance;}
}
