import java.util.Scanner;
import java.util.Random;
public class RockPaperScissor{
	
	public static int[] checkResult(byte userInput,int computerInput,int playerScore,int computerScore,int draws){
		
		if (userInput == 1 && computerInput == 3 || userInput == 2 && computerInput == 1 || userInput == 3 && computerInput == 2){
			System.out.println("You Won the Round.");
			playerScore += 1;
		}
				
		else if (userInput == 3 && computerInput == 1 || userInput == 1 && computerInput == 2 || userInput == 2 && computerInput == 3){
			System.out.println("Sorry!, Computer Won the Round.");
			computerScore += 1;
		}
		
		else{
			System.out.println("Oh, its a draw!");
			draws +=1;
		}
			
			
		System.out.println("");
		int[] scores = new int[3];
		scores[0] = playerScore;
		scores[1] = computerScore;
		scores[2] = draws;
		return scores;
	}
	public static String playAgain(Scanner scan){
		String again;
		System.out.println("");
		while (true){
			System.out.print("Do you want to play again (y/n): ");
			again = scan.next();
			if (again.equals("y")|| again.equals("n")|| again.equals("N")|| again.equals("Y"))
				break;
			System.out.println("Input Y or N");
		}
		
		
		return (again.toUpperCase());
	}
	public static void finalResult(int playerScore,int computerScore){
		if (playerScore > computerScore)
			System.out.println("Booyah, You won the Game.");
		else if (playerScore < computerScore)
			System.out.println("Soory, computer defeated you.");
		else
			System.out.println("Nice Work, its a Draw.");
	}
	
	public static void main(String[] args){
		String anotherTime;
		byte userInput = 0;
		int computerInput = 0;
		String computerSaid;
		int playerScore = 0;
		int computerScore = 0;
		int draws = 0;
		
		System.out.println("Welcome To ROCK PAPER SCISSORS\nThere will be 5 Rounds. If you can win 3 of those, you win the Game.");
		
		do {
			Scanner scan = new Scanner(System.in);
			for (int i = 1; i < 6;i++){
				Random computer = new Random();
				System.out.print("Round "+i+"\n1 for Rock\n2 for Paper\n3 for Scissor\n");
				while (true){
					System.out.print("So, What is your Weapon: ");
					userInput = scan.nextByte();
				if (userInput <= 3 && userInput >= 1)
					break;
				System.out.println("Enter a number among 1, 2 or 3 to play.");
				}
				
				computerInput = 1 + computer.nextInt(3);
				switch (computerInput){
					case 1:
						computerSaid = "Computer chose Rock";
						break;
					case 2:
						computerSaid = "Computer choose Paper";
						break;
					case 3:
						computerSaid = "Computer chose Scissor";
						break;
					default:
						computerSaid = "Sorry Some Error Accured.\nPlease try again!!";
				}
				System.out.println(computerSaid);
				int[] scores = checkResult(userInput,computerInput,playerScore,computerScore,draws);
				playerScore = scores[0];
				computerScore = scores[1];
				draws = scores[2];
			
				
	   		}
				System.out.println("Your Score: "+playerScore+"\nComputer Score: "+computerScore+"\nDraws: "+draws);
				finalResult(playerScore,computerScore);
				anotherTime = playAgain(scan);
			
		}while (anotherTime.equals("Y")
			);
		
	}
	
}
