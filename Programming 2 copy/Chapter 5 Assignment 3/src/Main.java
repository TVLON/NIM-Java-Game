import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class Main {

	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//declare variables
		int totalStones = 25;
		int personMove = 0;
		int computerMove = 0;
		int stonesLeft = totalStones;
		
		do {
			computerMove = drawStones(stonesLeft);
			System.out.println("There are " + stonesLeft + " stones. The computer took " + computerMove + " stone.");
			stonesLeft -= computerMove;
			if (stonesLeft <= 0) {
				System.out.println("COMPUTER LOSES");
			}//end if
			
			personMove = isValidInput(stonesLeft);
			stonesLeft -= personMove;
			if (stonesLeft <= 0) {
				System.out.println("PLAYER LOSES");
			}
	
		} while (stonesLeft > 0);//end while

	}//end main
	
	//create method isValidInput()
	public static int isValidInput(int stonesLeft) {
		Scanner input = new Scanner(System.in);
		int personMove = 0;
		
		do {
		try {
			
			System.out.println("There are " + stonesLeft + " stones. How many would you like? (1-3)");
			personMove = input.nextInt();

			
		} catch(InputMismatchException err) {
			System.err.println("Invalid Input. Please choose between 1-3.");
			input = new Scanner(System.in);
		}//end catch
		
		}while (personMove < 1 || personMove > 3 || personMove > stonesLeft);
		
		return personMove;
	}
	//create method drawStones()
	 public static int drawStones(int stonesLeft)
	    {
	        return (int)(Math.random()*3)+1;
	    }
	
}//end class
