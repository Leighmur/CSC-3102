/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poweranalyzer;
import java.math.BigInteger;

/**
 * Provides implementations for a naive and a fast power method for 
 * BigIntegers types with integer exponents
 * @author Leigh Wright
 * @since 1/24/19
 * @see java.math.BigInteger
 */
public class BigMath {
   /**
    * This method computes the non-negative power of a positive "BigInteger"
    * using the fast power algorithm that uses successive squaring
    * @param base a positive object of the BigInt class
    * @param n a non-negative integer
    * @return the power of a big integer to the specified non-negative exponent
    * @throw IllegalArgumentException when n is negative or base is not positive.
    */
   public static BigInteger naivePow(BigInteger base, int n) throws IllegalArgumentException
   {
       BigInteger r = BigInteger.ONE;
       for (int i = 0; i < n; i++) {
           r = r.multiply(base);
       }
       return r;
   }
   
    public static BigInteger fastPow(BigInteger base, int n) throws IllegalArgumentException {
       if (n == 1 || n == 0)
           return base;
       if (n == 2)
           return base.multiply(base);
       if (n % 2 == 0)
           return fastPow(fastPow(base, n / 2), 2);
       else
           return base.multiply(fastPow(fastPow(base, (n - 1) / 2), 2));
   }
   
}
    

