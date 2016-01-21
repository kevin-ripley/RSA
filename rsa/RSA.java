/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa;
import java.util.*;
import java.io.*;
/**
 *
 * @author kevinripley
 */
public class RSA {

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length == 0) {//if no argument provided
            System.out.println("Please run as: java HWx <input_filename>");
            System.exit(-1);//exit abruptly
        }
        String fname = args[0]; //take in first argument as the name of the input file
        Scanner sc = new Scanner(new File(fname)); //scanner for reading the file
        String input = sc.nextLine(); //read the first line of the file

        int A = Integer.parseInt(input.split(" ")[0]); //first number
        int B = Integer.parseInt(input.split(" ")[1]); //second number		
        ArrayList output = egcd(A, B);//get the results
        System.out.println("" + output.get(0) + " " + output.get(1) + " " + output.get(2)); //print output

    }

    //You are required to complete the functionality of the folwoing method uisng the Extended Euclidian algorithm (Example 8.4.6 in text). You can have any number of other helper methods.
    //Given integers A and B with A > B > 0, this algorithm computes gcd(A, B) and finds integers s and t such that s A + t B = gcd(A, B).]
    //Arguments: A, B [integers with A > B > 0]
    //Returns: gcd[a positive integer], s, t [integers] OR  -1,-1,-1 if inputs does not satisfy A > B > 0
    public static ArrayList egcd(int A, int B) {
        ArrayList<Integer> results = new ArrayList<Integer>();

        int u = 0, v = 1, s = 1, t = 0, newu, newv;
        int gcd = 0;
      if(B==0){
          int l = -1;
          int m = -1;
          int n = -1;
          results.add(l);
          results.add(m);
          results.add(n);
          return results;
      }
        while (B != 0) {
            
            int r = A % B;
            int q = A / B;

            A = B;
            B = r;

            newu = s - u * q;
            newv = t - v * q;

            s = u;
            t = v;
            u = newu;
            v = newv;

        }

        gcd = A;
      
        
        results.add(gcd);
        results.add(s);
        results.add(t);
        return results;
    }
}

