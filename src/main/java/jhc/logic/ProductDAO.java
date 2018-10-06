/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jhc.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import jhc.data.DBConnection;

import jhc.data.ProductDTO;

import jhc.presentation.FrontController;

/**
 *
 * @author Claus
 */
public class ProductDAO {
    
    public static final String BOTTOMS = "bottoms";
    public static final String TOPPINGS = "toppings";
    
    private static Connection connection;
    
    // SQL til forespørgsel på enkelt Product baseret på id og type
    final static String SINGLE_PRODUCT_SQL = "SELECT id, name, price FROM $TABEL$ WHERE id = ?";
    
    final static String PRODUCTS_OF_TYPE_SQL = "SELECT id, name, price FROM $TABLE$";
                         
           
    public static ArrayList<ProductDTO> getProductsOfType(String type)
    {
        
        ArrayList<ProductDTO> products = new ArrayList<ProductDTO>();
        try
        {
            connection = DBConnection.getConnection();
            // try to get products.
            
            PreparedStatement pstm = connection.prepareStatement(PRODUCTS_OF_TYPE_SQL.replace("$TABLE$", type));            
                        
            try(ResultSet rs = pstm.executeQuery();)
            {
                while(rs.next())
                    products.add(mapProduct(rs, type));
            }
        }
        catch(Exception e)
        {
            System.out.println("ProductDAO.getProductsOfType(String): " + e.getMessage() );
        } 
        return products;
    }
    
    
    /**
     * Henter enkelt produkt af angivet type med angivet id.
     * @param productId Produktets id.
     * @param type Produktets type, BOTTOM eller TOPPING.
     * @return ProductDTO hvis produktet findes, ellers null.
     */
    public static ProductDTO getSingleProduct(int productId, String type)
    {
        ProductDTO productDTO = null;        
                        
        try
        {
            // make connection.
            connection = DBConnection.getConnection();
            // Forsøg at hente recipe.
            PreparedStatement pstm = connection.prepareStatement(SINGLE_PRODUCT_SQL.replace("$TABLE$", type));            
            pstm.setInt(1, productId);

            // try with ressources.
            try (ResultSet rs = pstm.executeQuery();) 
            {
                
                if (rs.next()) // Kun 1 record pga SUM/COUNT i sql.
                {
                    productDTO = mapProduct(rs, type);                    
                }                                                
            }
        }
        catch(Exception e)
        {
            System.out.println("ProductDTO.getSingleProduct(int): " + e.getMessage() );
        }   
        
        return productDTO;
    }
    
    /**
     * Maps a product from resultset to ProductDTO.     
     * @param rs
     * @param type
     * @return ProductDTO object or null if ResultSet row is empty.
     * @throws Exception 
     */
    private static ProductDTO mapProduct(ResultSet rs, String type) throws Exception
    {
        ProductDTO productDTO = new ProductDTO(
                            rs.getInt("id"),
                            type,
                            rs.getString("name"),
                            rs.getFloat("price")
                            );
        if (productDTO.getId() > 0)
            return productDTO;
        return null;
    }    
}
