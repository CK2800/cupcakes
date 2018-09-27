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
import jhc.data.RecipeDTO;
import jhc.presentation.FrontController;

/**
 *
 * @author Claus
 */
public class RecipeDAO {
    
    private static Connection connection;
    
    // SQL til forespørgsel på enkelt recipe baseret på recipe.id
    final static String singleRecipeSql = "SELECT re.id, re.userId, re.headline, re.ingredients, re.instructions, u.name, SUM(ra.rating)/COUNT(ra.rating) as rating " +
                         "FROM recipe re INNER JOIN ratings ra ON ra.recipeId = re.id "+
                         "INNER JOIN `user` u ON re.userId = u.id WHERE re.id = ?;";            
    
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
    
    /**
     * Retrieves all recipes and converts them into html table.
     * @return A HTML table.
     */
    public static String getRecipesTable(String contextPath)
    {
        String html = "<table class='table table-striped'><tr><th>id</th><th>user id</th><th>headline</th><th>rating</th></tr>";
        ArrayList<RecipeDTO> recipes = getRecipes();
        for(RecipeDTO recipe : recipes)
        {
            html += recipeDTOToTable(contextPath, recipe);
        }
        html += "</table>";
        return html;
    }
    
    /**
     * Helper method to convert a RecipeDTO to a HTML table row.
     * 
     * @param recipeDTO
     * @return A HTML table row.
     */
    public static String recipeDTOToTable(String contextPath, RecipeDTO recipeDTO)
    {
        String anchor = "<a href='" + contextPath + "/FrontController?origin=" + FrontController.SHOW_SINGLE_RECIPE + "&id=" + recipeDTO.getId() + "'>";
        String html = "<tr><td>" + anchor + recipeDTO.getId() + "</a></td><td>" + anchor + recipeDTO.getuserId() + 
                      "</a></td><td>"+anchor+ recipeDTO.getHeadline() + "</a></td><td>" + anchor + recipeDTO.getRating() + "</a></td></tr>";
        return html;
                      
    }
    
    
    
    public static RecipeDTO getSingleRecipe(int produktId)
    {
        RecipeDTO recipeDTO = null;        
                        
        try
        {
            // make connection.
            connection = DBConnection.getConnection();
            // Forsøg at hente recipe.
            PreparedStatement pstm = connection.prepareStatement(singleRecipeSql);
            pstm.setInt(1, produktId);

            // try with ressources.
            try (ResultSet rs = pstm.executeQuery();) 
            {
                // Tomt recordset giver 1 tuple med null i kolonnerne,
                // derfor check at rs.getInt("id") > 0.
                if (rs.next() && rs.getInt("id") > 0) // Kun 1 record pga SUM/COUNT i sql.
                {
                    System.out.println("rs:" + rs.toString());                    
                    recipeDTO = new RecipeDTO(rs.getInt("id"),
                            rs.getInt("userId"),
                            rs.getString("instructions"),
                            rs.getString("ingredients"),
                            rs.getString("headline"),
                            rs.getFloat("rating")
                    );
                }                
            }
        }
        catch(Exception e)
        {
            System.out.println("RecipeDTO.getSingleRecipe(): " + e.getMessage() );
        }            
               
        
        return recipeDTO;
    }
    
    

            
            
         
}
