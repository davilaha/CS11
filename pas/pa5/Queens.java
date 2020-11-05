/* Queens.java 
   A Davila 
   pa5 

In this assignment a Java program that finds all solutions to the n-Queens problem, for 1  n  13 */


class Queens{
    public static void main(String[] args){
        int counter;
        int number;
        int queensLength;
        if (args.length > 0){
            if (args[0].equals("-v")){ //normal and verbose mode, indicated by the command line option "-v"//
                if (isInteger(args[1]) == true){ 
                    queensLength = Integer.parseInt(args[1]);
                    counter = 0;
                    int[] queens = new int[queensLength+1];

                    number = queensLength;
                    for (int i=queensLength-1;i>0;i--){
                        number*=i;
                    }
                    int[][] nextArray = new int[number][queensLength+1];
                    for (int i=1;i<=queensLength;i++){
                        queens[i] = i;
                    }
                    if (isSolution(queens) == true){
                        for (int i=1;i<=queensLength;i++){
                            nextArray[counter][i] = queens[i];
                        }
                        counter++;
                    }
                    for (int i=number;i>0;i--){
                        nextPermutation(queens);
                        if (isSolution(queens) == true){
                            for (int in=1;in<=queensLength;in++){
                                nextArray[counter][in] = queens[in];
                            }
                            counter++;
                        }
                    }
                    if (counter!=0){
                        for (int i=0;i<counter;i++){
                            printArrayLine(nextArray,i);
                        }
                        System.out.println(queensLength+"-Queens has "+ counter + " solutions");
                    }
                    else{
                        System.out.println(queensLength + "-Queens has 0 solutions");
                    }
                }
                else{
                    defaultText();
                }
            } 
            else if (isInteger(args[0]) == true){ 
                queensLength = Integer.parseInt(args[0]);
                int[] queens = new int[queensLength+1];
                number = queensLength;
                for (int i=queensLength-1;i>0;i--){
                    number =  number*i;
                }
                counter = 0;
                for (int i=1; i<=queensLength;i++){
                    queens[i] = i;
                }
                if (isSolution(queens) == true){
                    counter++;
                }
                for (int i=number; i>0;i--){
                    nextPermutation(queens);
                    if (isSolution(queens) == true){
                        counter++;
                    }
                }
                if (counter != 0){
                    System.out.println(queensLength + "-Queens has " + counter + " solutions");
                }
                else{
                System.out.println(queensLength + "-Queens has 0 solutions.");
                }
            }
            else{
                defaultText();
            }
        }
        else{
            defaultText();
        }
    }


    static void printArrayLine(int[][] A, int line){
        System.out.print("(");
        for (int i=1; i<=A[line].length-1;i++){
            System.out.print(A[line][i]);
            if (i < A[line].length-1){
                System.out.print(", ");
            }else{
                System.out.println(")");
            }
        }
    }

//This method will alter its argument by advancing to the next permutation//
    static void nextPermutation(int[] A){
        int currentOne = A[A.length-1];
        int pivot = 0;
        int next = 0;
        int currentTwo = 0;
        int successor = 0;
        int piv = A.length-1;
        int nextPos = A.length-1;

        //Scan the array from right - to - left and calls the first element the pivot//
        for (int i=A.length-1;i>=1;i--){
            if (A[i] < currentOne){
                pivot = A[i];
                piv = i;
                break; //Stops scanning//
            }else{
                currentOne = A[i];
            }
        }
        //reverse the array if left was reached without finding the pivot point.
        if (pivot == 0){
            currentTwo = 1;
            successor = A.length-1;
            while (currentTwo < successor){
                swap(A,currentTwo,successor);
                currentTwo++;
                successor--;
            }
            return;
        }
        for (int i=A.length-1;i>=1;i--){
            if (A[i] > pivot){
                next = A[i];
                nextPos = i;
                break;
            }
        }
        swap(A,piv,nextPos);
        if (piv != A.length-1){
            currentTwo = piv+1;
            successor = A.length-1;
            while (currentTwo < successor){
                swap(A,currentTwo,successor);
                currentTwo++;
                successor--;
            }
        }
        return;
    }

//This is a swap function using temp and what we waht to swap//
    static void swap(int[] array, int first, int second){
        int temp;
        temp= array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    static boolean isSolution(int[] A){
        int x,y;
        boolean isCorrect = true;
        for (int i=1;i<=A.length-1;i++){
            for (int j=1;j<=A.length-1;j++){
                if (j!=i){
                    x = Math.abs(i - j);
                    y = Math.abs(A[i] - A[j]);
                    if (x == y){
                        isCorrect = false;
                    }
                }
            }
        }
        if (isCorrect == true){
            return(true);
        }
        else{
            return(false);
        }
    }

    public static boolean isInteger(String s){
        try{ 
            Integer.parseInt(s); 
        } 
        catch(NumberFormatException e){ 
            return false; 
        }
        return true;
    }
//This function will print out the following lines after the user has input a wrong input//
    static void defaultText(){
        System.out.println("Usage: Queens [-v] number");
        System.out.println("Option: -v verbose output, print all solutions");
    }

}







