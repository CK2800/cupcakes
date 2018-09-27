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
    private String name;
    private String password;
    
    public UserDTO(int id, String name, String password)
    {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    
    public int getId(){return id;}
    public String getName(){return name;}
    public String getPassword(){return password;}
    
}
