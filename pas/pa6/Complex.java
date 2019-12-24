//-----------------------------------------------------------------------------
// Complex.java
// Henry Davila
// pa6
// Represents complex numbers as a pair of doubles
//
// pa6
// Fill in the function definitions below. See class notes, or the project 
// description for the definitions of the complex arithmetic operations.
//-----------------------------------------------------------------------------

class Complex{

   //--------------------------------------------------------------------------
   // Private Data Fields 
   //--------------------------------------------------------------------------
   private double re;
   private double im;
   
   //--------------------------------------------------------------------------
   // Public Constant Fields 
   //--------------------------------------------------------------------------
   public static final Complex ONE = Complex.valueOf(1,0);
   public static final Complex ZERO = Complex.valueOf(0,0);
   public static final Complex I = Complex.valueOf(0,1);

   //--------------------------------------------------------------------------
   // Constructors 
   //--------------------------------------------------------------------------
   Complex(double a, double b){
      this.re = a;
      this.im = b;
   }

   Complex(double a){
      this.re = a;
      this.im = 0;
   }

   Complex(String s){
      // Fill in this constructor.
      // It should accept expressions like "-2+3i", "2-3i", "3", "5i", etc..
      // Throw a NumberFormatException if s cannot be parsed as Complex.
      try{
      double[] part = new double[2];
      s = s.trim();
      String NUM = "(\\d+\\.\\d*|\\.?\\d+)";
      String SGN = "[+-]?";
      String OP =  "\\s*[+-]\\s*";
      String I =   "i";
      String OR =  "|";
      String REAL = SGN+NUM;
      String IMAG = SGN+NUM+"?"+I;
      String COMP = REAL+OR+
                    IMAG+OR+
                    REAL+OP+NUM+"?"+I;
      
      if( !s.matches(COMP) ){
         throw new NumberFormatException(
                   "Cannot parse input string \""+s+"\" as Complex");
      }
      s = s.replaceAll("\\s","");     
      if( s.matches(REAL) ){
         part[0] = Double.parseDouble(s);
         part[1] = 0;
      }else if( s.matches(SGN+I) ){
         part[0] = 0;
         part[1] = Double.parseDouble( s.replace( I, "1.0" ) );
      }else if( s.matches(IMAG) ){
         part[0] = 0;
         part[1] = Double.parseDouble( s.replace( I , "" ) );
      }else if( s.matches(REAL+OP+I) ){
         part[0] = Double.parseDouble( s.replaceAll( "("+REAL+")"+OP+".+" , "$1" ) );
         part[1] = Double.parseDouble( s.replaceAll( ".+("+OP+")"+I , "$1"+"1.0" ) );
      }else{   //  s.matches(REAL+OP+NUM+I) 
         part[0] = Double.parseDouble( s.replaceAll( "("+REAL+").+"  , "$1" ) );
         part[1] = Double.parseDouble( s.replaceAll( ".+("+OP+NUM+")"+I , "$1" ) );
      }
   
      this.re = part[0];
      this.im = part[1];
   }
      catch(Exception e){
         throw e;
      }
   }

   //---------------------------------------------------------------------------
   // Public methods 
   //---------------------------------------------------------------------------

   // Complex arithmetic -------------------------------------------------------

   // copy()
   // Return a new Complex equal to this Complex
   Complex copy(){
      // Fill in
      return new Complex(this.re, this.im);
   }
   
   // add()
   // Return a new Complex representing the sum this plus z.
   Complex add(Complex z){
      // Fill in
      // (this.re + z.re) + (this.im + z.im)//
      double re = (this.re + z.re);
      double im = (this.im + z.im);
      return new Complex(re,im);
   }
   
   // negate()
   // Return a new Complex representing the negative of this.
   Complex negate(){
      // Fill in
      double re = (this.re * (-1));
      double im = (this.im * (-1));
      return new Complex(re,im);
   }

   // sub()
   // Return a new Complex representing the difference this minus z.
   Complex sub(Complex z){
      // Fill in
      double re = (this.re - z.re);
      double im = (this.im - z.im);
      return new Complex(re,im);
   }

   // mult()
   // Return a new Complex representing the product this times z.
   Complex mult(Complex z){
      // Fill in
     /* double re = (this.re * z.re)-(this.im * z.im);
      double im = (this.re * z.im)+(this.im * z.re);
      return new Complex(re, im); */
     double a = z.re;
      double b = z.im;
      double c = this.re;
      double d = this.im;
      double i = (a*c-d*b);
      double j = (a*d+b*c);
      return new Complex(i,j);
   }

   // recip()
   // Return a new Complex representing the reciprocal of this.
   // Throw an ArithmeticException with appropriate message if 
   // this.equals(Complex.ZERO).
   Complex recip(){
      // Fill in
      if(this.equals(Complex.ZERO)){
         throw new ArithmeticException("Cannot divide by zero.");
      }
         double a = Math.pow(this.re,2);
         double b = Math.pow(this.im,2);
         double re = (this.re/(a+b)); 
         double im = ((this.im * (-1))/(a+b));
         return new Complex(re,im);
         
      
   }


   // div()
   // Return a new Complex representing the quotient of this by z.
   // Throw an ArithmeticException with appropriate message if 
   // z.equals(Complex.ZERO).
   Complex div(Complex z){
      // Fill in
      if(z.equals(Complex.ZERO)){
         throw new ArithmeticException("Cannot have zero in the denominator");
      }
         double a = z.re;
         double b = z.im;
         double c = this.re;
         double d = this.im;
         double i = ((c*a)+(d*b))/((a*a)+(b*b));
         double j = ((a*d)-(b*c))/((a*a)+(b*b));
         return new Complex(i, j);

      
   }

   // conj()
   // Return a new Complex representing the conjugate of this Complex.
   Complex conj(){
      // Fill in
      //or I can create two double variables re im like usual.//
      return new Complex(re,-im);
   }
   
   // Re()
   // Return the real part of this.
   double Re(){
      return re;
   }

   // Im()
   // Return the imaginary part of this.
   double Im(){
      return im;
   }

   // abs()
   // Return the modulus of this Complex, i.e. the distance between 
   // points (0, 0) and (re, im).
   double abs(){
      // Fill in
      double a = Math.pow(this.re,2);
      double b = Math.pow(this.im,2);
      double z = Math.sqrt(a+b); 
      return z;
   }

   // arg()
   // Return the argument of this Complex, i.e. the angle this Complex
   // makes with positive real axis.
   double arg(){
      return Math.atan2(im, re);
   }

   // Other functions ---------------------------------------------------------
   
   // toString()
   // Return a String representation of this Complex.
   // The String returned will be readable by the constructor Complex(String s)
   public String toString(){
      // Fill in
      //String complex;
      //complex = this.re + this.im + "i";
      if ( im > 0 && re > 0){
            return re+"+"+im+"i";
         }else if (im == 0 && re > 0){
            return re+" ";
         }else if (im < 0 && re > 0){
            return +re+"-"+(-im)+"i";           
         }else if ( im > 0 && re < 0){
            return re+"+"+im+"i";
         }else if (im == 0 && re < 0){
            return re+" ";
         }else if (im < 0 && re < 0){
            return +re+"-"+(-im)+"i";
         }
         return +im+"i";
      //return complex;
   }

   // equals()
   // Return true iff this and obj have the same real and imaginary parts.
   public boolean equals(Object obj){
      // Fill in
      //MSI tuesday night//
      //A.equals(B); takes object A and B
      if(obj instanceof Complex){
         Complex temp  = (Complex)obj;
         if(temp.re == this.re && temp.im == this.im){
            return true;
         }
         else{
            return false;
         }
      }
      else return false;
      
   }

   // valueOf()
   // Return a new Complex with real part a and imaginary part b.
   static Complex valueOf(double a, double b){
      // Fill in
      return new Complex(a,b);
   }

   // valueOf()
   // Return a new Complex with real part a and imaginary part 0.
   static Complex valueOf(double a){
      // Fill in
      return new Complex(a,0);
   }

   // valueOf()
   // Return a new Complex constructed from s.
   static Complex valueOf(String s){
      // Fill in
      return new Complex(s);
   }

}
