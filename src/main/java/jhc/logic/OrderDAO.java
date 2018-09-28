/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jhc.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import jhc.data.DBConnection;
import jhc.data.LineItemDTO;
import jhc.data.UserDTO;


/**
 *
 * @author Claus
 */
public class OrderDAO
{
    private static final String INSERT_LINE_ITEM_SQL = "INSERT INTO lineitems(orderId, productId, qty, price) VALUES(?,?,?,?);";
    private static final String CREATE_ORDER_SQL = "INSERT INTO orders(userId) VALUES(?);";
    
    private static Connection connection;
    public static boolean createOrder(UserDTO user, ArrayList<LineItemDTO> lineItems)
    {
        try
        {
            connection = DBConnection.getConnection();
            PreparedStatement pstm = connection.prepareStatement(CREATE_ORDER_SQL);
            //pstm.setInt(1, user.)
        }
        catch(Exception e)
        {
            System.out.println("OrderDAO.createOrder(UserDTO, ArrayList<LineItemDTO>): " + e.getMessage());
        }
        return false;
    }
}
