/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jhc.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jhc.data.DBConnection;
import jhc.data.UserDTO;

/**
 *
 * @author Claus
 */
public class UserDAO {
    
    private static Connection connection;
    
    private static final String userByNameSql = "SELECT id, name, password FROM user WHERE name = ?";
    public static UserDTO getUser(String name)
    {
        UserDTO userDTO = null;
        try
        {
            connection = DBConnection.getConnection();
            PreparedStatement pstm = connection.prepareStatement(userByNameSql);
            pstm.setString(1, name);
            
            try(ResultSet rs = pstm.executeQuery();)
            {
                if (rs.next())
                {
                    userDTO = MapUser(rs);
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("UserDAO.getUser(String): " + e.getMessage());
        }
        return userDTO;
    }
    
    /**
     * Mapper en række fra ResultSet til UserDTO.
     * @param rs ResultSet
     * @return UserDTO objekt hvis id > 0, ellers null.
     * @throws Exception 
     */
    public static UserDTO MapUser(ResultSet rs) throws Exception
    {
        UserDTO userDTO = new UserDTO(rs.getInt("id"), rs.getString("name"), rs.getString("password"));        
        
        if(userDTO.getId() > 0)
            return userDTO;
        
        return null;
    }
    
}
