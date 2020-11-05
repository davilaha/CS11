/*  Roots1.java
    Alex Davila
    Partner: Ravina G.
    pa4

Calculates the roots of an nth degree polynomial  */



import java.util.Scanner;
    class Roots1{
    public static void main(String[] args){

            Scanner sc=new Scanner(System.in);

            double resolution=0.01, tolerance=0.000000000001, threshold=0.00001; //
            double a; //left end point
            double b; //right end point
            int degree; 
            //Prompts the user for input of type integers which will be assigned to degrees//
            System.out.print("Enter the degree: ");
            degree =sc.nextInt();
            //Prompts user to input n number of coefficients based on the numeric value of degrees.
            System.out.print("Enter "+(degree+1)+" coefficients: ");
            double[] C = new double[degree+1]; //Creates a new array called "C" of length determined by [degrees+1]//
            for(int i=0; i<C.length;i++){ //this for loop allocates every double entered into [degrees+1] spaces into memory.
                    C[i]=sc.nextDouble();
            }
            System.out.print("Enter the left and right endpoints: "); //prompts input for left end right endpoints and assignes them to a,b.//
            a = sc.nextInt();
            b = sc.nextInt();
		System.out.println();

            //a1 and a2 are declared and initialized for the subintervals of size 0.01 withing the [a,b] interval. 
            double a1 = a;
            double a2 = a+resolution;
            int count = 0;
            double [] D = diff(C);
            double roots;
            while(a2 < b){
                if(poly(C,a1)*poly(C,a2)<0){
                    roots=findRoot(C,a1,a2,tolerance);
                    System.out.print("Odd root found at: ");
                    System.out.printf("%.10f%n",roots); //rounds to 10 decimal places//
                    count++;
                }
                else if(poly(D,a1)*poly(D,a2) <= 0){
                    roots = findRoot(D,a1,a2,tolerance);
                    if(Math.abs(poly(C,roots)) <= threshold){  
                        System.out.print("Even root found at: ");
                        System.out.printf("%.10f%n",roots); //rounds to 10 decimal places//
                        count++;
                    }
                }
		// this is the movemnet of the subinterval across the interval [L,R]//
                a1 = a2;
                a2 = a2+resolution;
            }
            if(count == 0){
                    System.out.print("No roots were found in the specific range.");
			System.out.println();
                }
        }
    static double poly(double[] C, double x){
            int n = C.length;
            int K;
            double sum = 0.0;
            for(int i=0;i<n;i++){
                    sum += C[i]*(Math.pow(x,i));
            }
            return sum;
    }
    static double[] diff(double[] C){
            int n = C.length-1;
            int K;
            double[] D = new double[n];
            for(int i=0;i<n;i++){
                    D[i] = C[i+1]*(i+1);
            }
            return D;
    }
    static double findRoot(double[] C, double a, double b, double tolerance){
        //this right here is double for the left and right endpoints. plus tolerance.
        //this is using findRoot2 example: 
      double mid, width;
      width = b-a;
      mid = (a+b)/2.0;
      while ( width>tolerance ){
         if( poly(C,a)*poly(C,mid)<0 ){  // if root is in [a, mid]
            b = mid;            //    move b left
         } else {               // else root is in (mid, b] 
            a = mid;            //    move a right
         }
         width = b-a;
         mid = (a+b)/2.0;
      }
      return mid;
   }
}





