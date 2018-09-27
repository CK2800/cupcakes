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
public class RatingDTO {
    private int id, recipeId, rating;
        
    public RatingDTO(int id, int recipeId, int rating)
    {
        this.id = id;
        this.recipeId = recipeId;
        this.rating = rating;
    }
    
    public int getId(){return id;}
    public int getRecipeId(){return recipeId;}
    public int getRating(){return rating;}    
}

