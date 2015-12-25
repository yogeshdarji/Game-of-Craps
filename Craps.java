
public class Craps {


	public static void main(String[] args) {

		for (int round =0 ; round <5; round ++)	   
		{	   

			// STRATEGY 1

			int numberOfGames=0;
			int amount = 1000;
			int wager=100;
			int amountStrategy[] = new int[10];
			int numberOfGameStrategy[] = new int[10];

			while(numberOfGames<10 && amount!=0)
			{
				wager=100;
				int throwDice;  // initial roll
				throwDice = (int)(6.0*Math.random() + 1.0) + (int)(6.0*Math.random() + 1.0);
						

				if (throwDice == 2 || throwDice == 3 || throwDice == 12) {
					amount = amount-wager;    //   First loss with 2, 3 or 12
				}
				else if (throwDice == 7 || throwDice == 11) {
					amount = amount+wager;    // First win with 7 or 11
				}
				else { 
					int point = throwDice; // point: 4, 5, 6, 8, 9, or 10
					while (true) {  // keep rolling
						throwDice = (int)(6.0*Math.random() + 1.0) +
								(int)(6.0*Math.random() + 1.0);
						if (throwDice == point) {
							amount= amount+wager;    //   "Win as got point 
							break;  // break out of loop, a win
						}
						if (throwDice == 7) {
							amount = amount-wager;  //  Lost with 7
							break;  // break out of loop, a loss
						}
						//   else System.out.println("No help");
					}
				}
				numberOfGames = numberOfGames+1;
				numberOfGameStrategy[0] = numberOfGames;
				amountStrategy[0]= amount;

			}

			// STRATEGY 2

			numberOfGames=0;
			amount = 1000;
			wager=100;

			while(numberOfGames<10 && amount!=0)
			{

				int throwDice;  // initial roll
				throwDice = (int)(6.0*Math.random() + 1.0) +
						(int)(6.0*Math.random() + 1.0);

				if (throwDice == 2 || throwDice == 3 || throwDice == 12) {
					amount = amount-wager;    //   First loss with 2, 3 or 12

					if (amount < 2*wager)
						wager=amount;
					else
						wager= 2 * wager;
				}
				else if (throwDice == 7 || throwDice == 11) {

					amount = amount+wager;   // First win with 7 or 11
					wager = 100;
				}
				else { 
					int point = throwDice; // point: 4, 5, 6, 8, 9, or 10

					while (true) {  // keep rolling
						throwDice = (int)(6.0*Math.random() + 1.0) +
								(int)(6.0*Math.random() + 1.0);
						if (throwDice == point) {

							amount= amount+wager;   //   "Win as got point 
							wager = 100;
							break;  // break out of loop, a win
						}
						if (throwDice == 7) {

							amount = amount-wager;       //  Lost with 7
							if (amount < 2*wager)
								wager=amount;
							else
								wager= 2 * wager;
							break;  // break out of loop, a loss
						}
						//    else System.out.println("No help");
					}
				}
				numberOfGames = numberOfGames+1;
				numberOfGameStrategy[1] = numberOfGames;
				amountStrategy[1]= amount;

			}


			// STRATEGY 3

			numberOfGames=0;
			amount = 1000;
			wager=100;
			while(numberOfGames<10 && amount!=0)
			{

				int throwDice;  // initial roll
				throwDice = (int)(6.0*Math.random() + 1.0) +
						(int)(6.0*Math.random() + 1.0);

				if (throwDice == 2 || throwDice == 3 || throwDice == 12) {
					amount = amount-wager;    //   First loss with 2, 3 or 12
					wager = 100;

				}
				else if (throwDice == 7 || throwDice == 11) {
					amount = amount+wager;   // First win with 7 or 11

					if (amount < 2*wager)
						wager=amount;
					else
						wager= 2 * wager;

				}
				else { 
					int point = throwDice; // point: 4, 5, 6, 8, 9, or 10
					while (true) {  // keep rolling
						throwDice = (int)(6.0*Math.random() + 1.0) +
								(int)(6.0*Math.random() + 1.0);
						if (throwDice == point) {
							amount= amount+wager;   // Made Point, Win
							if (amount < 2*wager)
								wager=amount;
							else
								wager= 2 * wager;
							break;  // break out of loop, a win
						}
						if (throwDice == 7) {
							amount = amount-wager;
							wager =100;
							break;  // break out of loop, a loss
						}
						// else System.out.println("No help");
					}
				}
				numberOfGames = numberOfGames+1;

				numberOfGameStrategy[2] = numberOfGames;
				amountStrategy[2]= amount;
			}



			System.out.println("************************************Round "+ (round+1) +"*****************************************");

			System.out.println("Strategy  "+ "\t  " + "Number of games " + "\t   "+ "Ending Balance ");
			for(int i=0; i<3; i++)
			{
				System.out.println("    "+(i+1) + "\t\t\t" + numberOfGameStrategy[i] + "\t\t\t" +"$"+amountStrategy[i]);


			}
		}
	}
}


