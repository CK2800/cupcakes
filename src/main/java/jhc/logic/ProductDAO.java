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
import jhc.data.ImageDTO;
import jhc.data.ProductDTO;
import jhc.data.RecipeDTO;
import jhc.presentation.FrontController;

/**
 *
 * @author Claus
 */
public class ProductDAO {
    
    private static Connection connection;
    
    // SQL til forespørgsel på enkelt Product baseret på id
    final static String singleProductSql = "SELECT p.id, p.producttypeId, p.name, p.price " +
                         "FROM products p WHERE p.id = ?";
    
    final static String productsOfTypeSql = "SELECT p.id, p.producttypeId, p.name, p.price " +
                        "FROM products p WHERE p.producttypeId = ?";
                         
    
    // SQL til forespørgsl på alle recipes.
    final static String allRecipesSql = "SELECT re.id, re.userId, re.headline, re.ingredients, re.instructions, u.name, SUM(ra.rating)/COUNT(ra.rating) as rating " +
                                 "FROM recipe re INNER JOIN user u ON re.userId = u.id " +
                                 "LEFT JOIN ratings ra ON ra.recipeId = re.id GROUP BY re.id;";
    
    // SQL til forespørgsel på en recipe's billeder.
    final static String imageSql = "SELECT id, recipeId, url FROM image WHERE recipeId = ?;";
    
    // SQL for creating a new recipe.
    final static String createRecipeSql = "INSERT INTO recipe(userId, headline, instructions, ingredients) VALUES (?,?,?,?);";
    
    
    public static ArrayList<ImageDTO> getRecipeImages(int produktId)
    {
        ArrayList<ImageDTO> images = new ArrayList<ImageDTO>();
        // Har vi forbindelse, kan vi forsøge at hente.                
        try
        {
            // Make connection.
            connection = DBConnection.getConnection();
            // Forsøg at hente billeder.
            PreparedStatement pstm = connection.prepareStatement(imageSql);
            pstm.setInt(1, produktId);


            // try with ressources.
            try(ResultSet rs = pstm.executeQuery();)
            {                
                while(rs.next())
                {
                    images.add(new ImageDTO(
                            rs.getInt("id"), 
                            rs.getInt("recipeId"), 
                            rs.getString("url"))
                    );
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("RecipeDTO.getRecipeImages(int): " + e.getMessage() );
        }
        
        return images;
    }
    
    public static ArrayList<RecipeDTO> getRecipes()
    {
        // Opret liste til opskrifter.
        ArrayList<RecipeDTO> recipes = new ArrayList<RecipeDTO>();
        
        // Har vi forbindelse, kan vi forsøge at hente.
        
        try
        {
            // make connection.
            connection = DBConnection.getConnection();
            // Forsøg at hente recipes.
            PreparedStatement pstm = connection.prepareStatement(allRecipesSql);

            // try with ressources.
            try (ResultSet rs = pstm.executeQuery();) 
            {
                // Gennemløb resultsæt og map til RecipeDTO's
                while (rs.next()) 
                {
                    System.out.println("rs:" + rs.toString());                    
                    recipes.add(new RecipeDTO(rs.getInt("id"),
                            rs.getInt("userId"),
                            rs.getString("instructions"),
                            rs.getString("ingredients"),
                            rs.getString("headline"),
                            rs.getFloat("rating"))
                    );
                }                
            }
        }
        catch(Exception e)
        {
            System.out.println("RecipeDTO.getRecipes(): " + e.getMessage() );
        }       
        
        return recipes;              
    }
    
    public static boolean createRecipe(int userId, String headline, String instructions, String ingredients)
    {
        // sanitize.
        headline = headline.trim();
        instructions = instructions.trim();
        ingredients = ingredients.trim();
        
        try
        {
            connection = DBConnection.getConnection();
            PreparedStatement pstm = connection.prepareStatement(createRecipeSql);
            pstm.setInt(1, userId);
            pstm.setString(2, headline);
            pstm.setString(3, instructions);
            pstm.setString(4, ingredients);
            
            // If exactly one row was affected, return true.
            return pstm.executeUpdate() == 1;            
        }
        catch(Exception e)
        {
            System.out.println("RecipeDAO.createRecipe(int, String, String, String): " + e.getMessage());
        }
        return false;
        
        
    }
       
    public static ArrayList<ProductDTO> getProductsOfType(int producttypeId)
    {
        ArrayList<ProductDTO> products = new ArrayList<ProductDTO>();
        try
        {
            connection = DBConnection.getConnection();
            // try to get products.
            PreparedStatement pstm = connection.prepareStatement(productsOfTypeSql);
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
            PreparedStatement pstm = connection.prepareStatement(singleProductSql);
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
