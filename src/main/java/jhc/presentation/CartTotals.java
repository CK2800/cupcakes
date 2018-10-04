/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jhc.presentation;

/**
 *
 * @author Claus
 * A wrapper class that allows the return of multiple values from a method.
 */
public class CartTotals
    {
        private int count;
        private float total;
        public int getCount(){return count;}
        public float getTotal(){return total;}
        public CartTotals(int count, float total)
        {
            this.count = count;
            this.total = total;
        }
    }
