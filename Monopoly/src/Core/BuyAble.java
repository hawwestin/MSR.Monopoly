/*
 * The MIT License
 *
 * Copyright 2018 Michal.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package Core;

/**
 * Methods allowing player to obtain/sell field. 
 * @author Michal
 */
public interface BuyAble {
    
    
    /**
     * Get current value of rent on field
     * @return
     */
    public int getRent();

    /**
     * Sell field to bank
     */
    public void Sell();

    /**
     * Sell field to other player
     * @param buyer
     */
    public void Sell(Player buyer, int price);

    /**
     * Set new owner of the field 
     * Charge funds from the player's account
     * @param buyer
     */
    public void setOwner(Player buyer);

    /**
     * Return getPrice
     * @return
     */
    public int getPrice();    
    
    /**
     * Get Owner of current field or Null if unowned
     * @return
     */
    public Player getOwner();
    
    
}
