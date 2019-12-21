//GCD
//A Davila
//hdavilac
//lab8
//This program calculates the GCD of two positive integers in C

#include<stdio.h>

 int main(void){
	//I am declaring variables I will use for input and control loops//
 	int inY, inX, n, i, GCD;
 	char str[100]; //discarding bad input//

	//ask for user input//
 	printf("Enter a positive integer: ");
 	while(1){
 		n = scanf("%d", &inY);
 		while (n != 1){ //checks if input is an integer, if not it will ask again//
 			n = scanf(" %s", str);
 			printf("Please enter a positive integer: ");
 			n = scanf("%d", &inY);
 		}
 		if(inY > 0) break; //if it is a positive integer, it will go onto the next call.//
 		printf("Please enter a positive integer: ");
 	}
	
	//this is the next call for another input integer//
 	printf("Enter another positive integer: ");
 	while(1){
 		n = scanf("%d", &inX);
 		while (n != 1){ //we check again if input is a positive integer, if not then ask again//
 			n = scanf(" %s", str);
 			printf("Please enter a positive integer: ");
 			n = scanf("%d", &inX);
 		}
 		if(inX > 0) break; //if input is positive integer move onto the next call//
 		printf("Please enter a positive integer: "); //otherwise, ask again//
 	}

 	for(i=1; i <= inY && i <= inX; ++i){
        // Checks if i is factor of both integers
        if(inY%i==0 && inX%i==0)
            GCD = i;
         printf("The GCD of %d and %d is %d", inY, inX, GCD);
         printf("\n");

    return 0;
    }

 }
