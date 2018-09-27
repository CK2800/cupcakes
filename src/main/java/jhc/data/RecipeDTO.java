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
public class RecipeDTO {
    private int id, userId;
    private String ingredients, instructions, headline;
    float rating = 0;
      
    // Konstruktør til eksisterende opskrift (mappet fra database).
    public RecipeDTO(int id, int userId, String instructions, String ingredients, String headline, float rating)
    {
        this.id = id;
        this.userId = userId;
        this.instructions = instructions;
        this.ingredients = ingredients;
        this.headline = headline;
        this.rating = rating;
    }
    
    // Overloadet konstruktør til brug v. oprettelse af ny opskrift.
    public RecipeDTO(int userId, String instructions, String ingredients, String headline)
    {
        this.userId = userId;
        this.instructions = instructions;
        this.ingredients = ingredients;
        this.headline = headline;
    }
    
    // getters
    public int getId(){return id;}
    public int getuserId(){return userId;}
    public String getIngredients(){return ingredients;}
    public String getInstructions(){return instructions;}
    public String getHeadline(){return headline;}
    public float getRating(){return rating;}
}
