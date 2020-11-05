 /*GCD.java
   A Davila
 
 
  This program asks the user to input two positive integers 
  and will keep asking for integers when something other 
  than an integer is entered.
  returns the GCD of these two inputs. */

import java.util.Scanner;

class GCD{
    static int GCDcalc (int x, int y) {

        int localMax, localMin;
        int mod = -1;
        localMax = Math.max (x, y);
        localMin = Math.min (x, y);
        while (mod != 0) {
            mod = localMax % localMin;
            localMax = localMin;
            localMin = mod;
        }
        return localMax;
     }    

    public static void main ( String[] args ) {

        int x, y;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        while (true) {
            while (!sc.hasNextInt()) {
            System.out.print("Please enter a positive integer: ");
                sc.next();
            }
                x = sc.nextInt();
                if(x > 0) {
                    break;
                }else {

                System.out.print("Please enter a positive integer: ");
            
            }
        }

        System.out.print("Enter another positive integer: ");
        while (true) {
            while (!sc.hasNextInt()) {
            System.out.print("Please enter a positive integer: ");
                sc.next();
                } 
                y = sc.nextInt();
                if (y > 0){
                    break;
                }
                else {
                System.out.print("Please enter a positive integer: ");

            }
        } 

        System.out.print("The GCD of" + " " +x+ " and " +y+ " is " + GCDcalc(x, y) + " ");
        System.out.println("\n");
    }
}









