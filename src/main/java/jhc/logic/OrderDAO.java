/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jhc.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import jhc.data.DBConnection;
import jhc.data.LineItemDTO;
import jhc.data.OrderDTO;
import jhc.data.UserDTO;


/**
 *
 * @author Claus
 */
public class OrderDAO
{
    private static final String INSERT_LINE_ITEM_SQL = "INSERT INTO lineitems(orderId, productId, qty, price) VALUES(?,?,?,?);";
    private static final String CREATE_ORDER_SQL = "INSERT INTO orders(userId) VALUES(?);";
    private static final String GET_USER_ORDERS_SQL = "SELECT id FROM orders WHERE userId = ?;";
    private static Connection connection;
    
    public static ArrayList<OrderDTO> getUserOrders(UserDTO user)
    {
        
    }
    
    public static boolean createOrder(UserDTO user, ArrayList<LineItemDTO> lineItems)
    {
        boolean created = false;
        try
        {
            connection = DBConnection.getConnection();
            PreparedStatement pstm = connection.prepareStatement(CREATE_ORDER_SQL, Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, user.getId());
            
            // create order.
             pstm.executeUpdate();
             ResultSet rs = pstm.getGeneratedKeys();
            //Q&D
            int orderId = rs.getInt("id");
            
            for(LineItemDTO lineItem : lineItems)
            {
                pstm = connection.prepareStatement(INSERT_LINE_ITEM_SQL);
                pstm.setInt(1, orderId);
                pstm.setInt(2, lineItem.getProductId());
                pstm.setInt(3, lineItem.getQty());
                pstm.setFloat(4, lineItem.getPrice());
                pstm.executeUpdate();
            }
            created = true;
        }
        catch(Exception e)
        {
            System.out.println("OrderDAO.createOrder(UserDTO, ArrayList<LineItemDTO>): " + e.getMessage());
        }
        return created;
    }
}
