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
public class ImageDTO {
    private int id, recipeId;
    private String url;
    
    public ImageDTO(int id, int recipeId, String url)
    {
        this.id = id;
        this.recipeId = recipeId;
        this.url = url;
    }
    
    public int getId(){return id;}
    public int getRecipeId(){return recipeId;}
    public String getUrl(){return url;}
}
