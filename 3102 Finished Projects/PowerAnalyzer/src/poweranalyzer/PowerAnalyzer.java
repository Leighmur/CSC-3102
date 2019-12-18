/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poweranalyzer;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

/**
 *CSC 3102 Programming Project #0
 * @author Leigh Wright
 * @since 1/24/19
 * @see java.math.BigInteger
 */
public class PowerAnalyzer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    
    // 1). From the handout specifying the PowerAnalyzer program
    System.out.print("Enter the base of the power -> ");
    BigInteger base = BigInteger.valueOf(sc.nextLong());
    
    // 2
    System.out.print("Enter the exponent of the power -> ");
    int exponent = sc.nextInt();
    
    // 3
    BigInteger result = BigMath.naivePow(base, exponent);
    System.out.println("Using Naive Algorithm: " + base + "^" + exponent + " = " + result);
    result = BigMath.fastPow(base, exponent);
    System.out.println("Using Fast Algorithm: " + base + "^" + exponent + " = " + result);
    
    Random rand = new Random();
    
    // 4
    int randHugeBase = rand.nextInt(10000) + 1000;
    BigInteger rBigBase = BigInteger.valueOf(randHugeBase);
    
    // 5
    int rExponent = rand.nextInt(100) + 10;
    
    // 6
    System.out.println("");
    System.out.println("Using a random 4-digit base and a random 2-digit exponent: ");
    System.out.println("Using Naive Algorithm: " + rBigBase + "^" + rExponent + " = " + BigMath.naivePow(rBigBase, rExponent));
    System.out.println("Using Fast Algorithm: " + rBigBase + "^" + rExponent + " = " + BigMath.fastPow(rBigBase, rExponent));
    
    // 7
    System.out.print("Enter the base of the powers for the table -> ");
    BigInteger tBase = BigInteger.valueOf(sc.nextInt());
    
    // 8
    int n[] = {16,32,64,128,256,512,1024,2048,4096,8192};
    
    System.out.println("b = " + tBase);
    System.out.println("==================================================");
    System.out.println("n b^n: Fast Power(ns) b^n: Naive Power (ns)");
    
    for (int i = 0; i < n.length; i++) {
           
           long startTime = System.nanoTime();
           BigMath.fastPow(tBase, n[i]);
           long endTime = System.nanoTime();
           long fast = endTime - startTime;

           startTime = System.nanoTime();
           BigMath.naivePow(tBase, n[i]);
           endTime = System.nanoTime();
           long naive = endTime - startTime;

           System.out.println(n[i] + " " + fast + " " + naive);
       }
    }
    
}
