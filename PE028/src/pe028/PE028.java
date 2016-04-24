/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe028;

/**
 *
 * @author maurice
 */
public class PE028 {

    /**
     *
     * <p>Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:</p>
     * <p>
     * 21 22 23 24 25<br>
     * 20  7  8  9 10<br>
     * 19  6  1  2 11<br>
     * 18  5  4  3 12<br>
     * 17 16 15 14 13<br></p>
     * 
     * <p>It can be verified that the sum of the numbers on the diagonals is 101.</p>
     * 
     * <p>What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?</p>
     * 
     * @return The required sum
     */
    public static long doIt() {
        final int TARG = 1001 * 1001;
        long ans = 1;
        for (int bas = 1, jmp = 2; bas < TARG; bas += 4 * jmp, jmp += 2) {
            ans += 4 * bas + 10 * jmp;
        }
        return ans;
    }
    
}
