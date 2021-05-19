import java.io.*;
import java.util.*;

class SieveValidator {

   public static int [] readSieve(String fileName){
      try {
      
         BufferedReader br = new BufferedReader(new FileReader(fileName));
         
         int size = Integer.parseInt(br.readLine()); 
         int [] primeArray = new int[size];
         String line;
         int count = 0;
         
         while ((line = br.readLine()) != null) {
            for (String letter: line.split("")) {
               primeArray[count] = Integer.parseInt(letter);
               count++;
            }
         }
         return primeArray;  
      } catch (FileNotFoundException FNFE) {
         System.err.println(fileName + " " + FNFE);
      } catch (Exception E) {
         System.err.println(E);
      }
      return null;
      
   }
   
   public static int[] repairSieve(int[] primeArray) {
      int n = 0;
      int errors = 0;
      for (int p: primeArray) {
         if ( p == 1 && !Primes.isPrime(n) ) {
            primeArray[n] = 0;
            System.err.println(n + " is not a prime!");
            errors++;
         } else if ( p == 0 && Primes.isPrime(n) ) {
            primeArray[n] = 1;
            System.err.println(n + "is a prime!");
            errors++;
         }
         n++;
      }
      System.out.println("Sieve contained: " + errors + " error(s)");
      return primeArray;
      
   }
   
   public static void main(String[] args) {
      readSieve("./sieve_10.txt");
   }
}