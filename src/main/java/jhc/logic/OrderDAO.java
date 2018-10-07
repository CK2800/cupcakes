
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
    /**
     * SQL for inserting a line item into the database.
     */
    private static final String INSERT_LINE_ITEM_SQL = "INSERT INTO lineitems(orderId, toppingId, bottomId, qty, price) VALUES(?,?,?,?,?);";
    /**
     * SQL for creating an order in the database.
     */
    private static final String CREATE_ORDER_SQL = "INSERT INTO orders(userId) VALUES(?);";
    /**
     * SQL for getting orders for a specific user.
     */
    private static final String GET_USER_ORDERS_SQL = "SELECT id FROM orders WHERE userId = ?;";
    /**
     * The database connection.
     */
    private static Connection connection;
    
    /**
     * Get orders belonging to a specific user.
     * @param user UserDTO object
     * @return ArrayList of OrderDTO objects. If the user has no orders, the list will be empty.
     */
    public static ArrayList<OrderDTO> getUserOrders(UserDTO user)
    {
        ArrayList<OrderDTO> orders = new ArrayList<OrderDTO>();
        try
        {
            connection = DBConnection.getConnection();
            PreparedStatement pstm = connection.prepareStatement(GET_USER_ORDERS_SQL);
            pstm.setInt(1, user.getId());
            
            try(ResultSet rs = pstm.executeQuery();)
            {
                while(rs.next())
                    orders.add(MapOrder(rs));
            }                
        }
        catch(Exception e)
        {
            System.out.println("OrderDAO.getUserOrders(UserDTO): " + e.getMessage());
        }
        return orders;
    }
    
    /**
     * Maps the current row from a ResultSet to an OrderDTO object.
     * @param rs ResultSet 
     * @return OrderDTO object
     * @throws Exception If the ResultSet fails to read values from the specified columns, an Exception will be thrown.
     */
    private static OrderDTO MapOrder(ResultSet rs) throws Exception
    {
        return new OrderDTO(rs.getInt("id"), rs.getInt("userId"));
    }
//    Q&D test
//    public static void main(String[] args) {
//        createOrder(new UserDTO(1, "Jesper", "Petersen", 0), new ArrayList());
//
//    }      
    /**
     * Creates a new order in the database and its lineitems.
     * @param user UserDTO object of the user making the order.
     * @param lineItems ArrayList of LineItemDTO objects for the order.
     * @return boolean, true if order and corresponding lineitems were created, false otherwise.
     */
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
             rs.next();
            //Q&D
            int orderId = rs.getInt(1);            
            for(LineItemDTO lineItem : lineItems)
            {
                pstm = connection.prepareStatement(INSERT_LINE_ITEM_SQL);
                pstm.setInt(1, orderId);
                pstm.setInt(2, lineItem.getToppingId());
                pstm.setInt(2, lineItem.getBottomId());
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
