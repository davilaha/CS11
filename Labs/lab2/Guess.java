//Guess.java
//Henry A. Davila
//pa2
// This program asks the monkey at the keybord for three guesses to a number
//from 1 to 10 that the computer ramndomly choses. Its a guessing game and the player
//has only three chnaces to win. If player doesn't guess it after three tries,
//palyer loses and game ends. If player guesses after or before 3 tries, game ends.

import java.util.Scanner;

class Guess{

	public static void main(String [] args){

		double guessA, guessB, guessC;
		int n = ((int) (Math.random()*10))+1;

		Scanner sc = new Scanner(System.in);

		System.out.print("\nI'm thinking of an integer in the range 1 to 10.  You have three guesses.");
		System.out.println();
		

		//first guess
		System.out.print("\nEnter your first guess: ");
		guessA = sc.nextInt();

		if(guessA > n){
		System.out.print("Your guess is too high.");
		System.out.println();
		}
		else if(guessA < n){
		System.out.print("Your guess is too low.");
		System.out.println();
		}
		else if(guessA==n){
		System.out.print("You win!");
		System.out.println("\n");
		System.exit(0);
		}

		//Second guess
		System.out.print("\nEnter your second guess: ");
		guessB = sc.nextInt();
		
		if(guessB>n){
		System.out.print("Your guess is too high.");
		System.out.println();
		}
		else if(guessB<n){
		System.out.print("Your guess is too low.");
		System.out.println();
		}
		else if(guessB==n){
		System.out.print("You win!");
		System.out.println("\n");
		System.exit(0);
		}

		//third guess
		System.out.print("\nEnter your third guess: ");
		guessC = sc.nextInt();

		if(guessC>n){
		System.out.print("Your guess is too high.");
		System.out.println();
		}
		else if(guessC<n){
		System.out.print("Your guess is too low.");
		System.out.println();
		}
		else if(guessC==n){
		System.out.print("You win!");
		System.out.println("\n");
		System.exit(0);
		}

		//after three wrong guesses
		System.out.print("\nYou lose.  The number was " + n+".");
		System.out.println("\n");
		System.exit(0);
		
	}
	Timer timer = new Timer();
	timer.scheduleAtFixedRate(new CursorBlink(), 1, 500);

	class CursorBlink extends TimerTask {
  	Cursor cursor = null;
	// constructor
	public CursorBlink (Cursor cursor){
  	this.cursor = cursor;
	}
	public void run(){
    // changes cursor color and calls glcanvas.display(); 
    cursor.changecolor();  
  }
}








