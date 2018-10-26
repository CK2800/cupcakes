/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jhv.presentation;

import java.util.ArrayList;
import jhc.data.LineItemDTO;
import jhc.presentation.CartTotals;
import jhc.presentation.Utils;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Claus
 */
public class CartTotalsJUnitTest
{
    
    public CartTotalsJUnitTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testCartTotals()
    {
        // Create two line items with 4 items that total 24, add to list.
        LineItemDTO l1 = new LineItemDTO(1, 1, "Topping 1", "Bottom 1", 2, 5);
        LineItemDTO l2 = new LineItemDTO(2, 2, "Topping 2", "Bottom 2", 2, 7);
        ArrayList<LineItemDTO> lineitems = new ArrayList<>();
        lineitems.add(l1);
        lineitems.add(l2);        
        // Calculate a fictious total and show the result.
        CartTotals cartTotals = Utils.calculateCartTotals(lineitems);        
        System.out.println("CartTotals: " + cartTotals.toString());
        // Here is the assertion - cartTotals must exist !
        assertTrue(cartTotals.getCount()==4 && cartTotals.getTotal()==24f);
    }
}
