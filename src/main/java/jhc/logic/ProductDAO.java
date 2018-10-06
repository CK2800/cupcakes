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
    
    private static Connection connection;
    
    // SQL til forespørgsel på enkelt Product baseret på id
    final static String SINGLE_PRODUCT_SQL = "SELECT p.id, p.producttypeId, p.name, p.price " +
                         "FROM products p WHERE p.id = ?";
    
    final static String PRODUCTS_OF_TYPE_SQL = "SELECT p.id, p.producttypeId, p.name, p.price " +
                        "FROM products p WHERE p.producttypeId = ?";
                         
           
    public static ArrayList<ProductDTO> getProductsOfType(int producttypeId)
    {
        ArrayList<ProductDTO> products = new ArrayList<ProductDTO>();
        try
        {
            connection = DBConnection.getConnection();
            // try to get products.
            PreparedStatement pstm = connection.prepareStatement(PRODUCTS_OF_TYPE_SQL);
            pstm.setInt(1, producttypeId);
            
            try(ResultSet rs = pstm.executeQuery();)
            {
                while(rs.next())
                    products.add(mapProduct(rs));
            }
        }
        catch(Exception e)
        {
            System.out.println("ProductDTO.getProductsOfType(int): " + e.getMessage() );
        } 
        return products;
    }
    
    
    public static ProductDTO getSingleProduct(int productId)
    {
        ProductDTO productDTO = null;        
                        
        try
        {
            // make connection.
            connection = DBConnection.getConnection();
            // Forsøg at hente recipe.
            PreparedStatement pstm = connection.prepareStatement(SINGLE_PRODUCT_SQL);
            pstm.setInt(1, productId);

            // try with ressources.
            try (ResultSet rs = pstm.executeQuery();) 
            {
                
                if (rs.next()) // Kun 1 record pga SUM/COUNT i sql.
                {
                    productDTO = mapProduct(rs);                    
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
     * @return ProductDTO object or null if ResultSet row is empty.
     * @throws Exception 
     */
    private static ProductDTO mapProduct(ResultSet rs) throws Exception
    {
        ProductDTO productDTO = new ProductDTO(
                            rs.getInt("id"),
                            rs.getInt("producttypeId"),
                            rs.getString("name"),
                            rs.getFloat("price")
                            );
        if (productDTO.getId() > 0)
            return productDTO;
        return null;
    }    
}
