//A Davila
//lab7
//hdavilac

     /* Sphere.c */
#include<stdio.h>
    
int main(void){
float vol, surfA;
float rad;
const double pi = 3.141592654;

printf("Enter the radius of the sphere: ");

scanf(" %f", &rad);
vol = (4.0/3.0) * (pi) * (rad*rad*rad);
surfA = (4*pi) * (rad*rad);

printf("The volume is %f and the surface area is %f.", vol , surfA);

printf("\n");
return 0;
}
