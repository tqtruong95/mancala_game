import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Mancala {

	private MancalaPlayer player1;
	private MancalaPlayer player2;
	private ArrayList<ChangeListener> listeners;
	private int hand; 
	private int handTracker;
	int startPos; 
	int endPos;
	int counter;
	int whoSide;

	/**
	 * Constructor for new mancala game
	 * @param p1 player 1
	 * @param p2 player 2
	 */
	public Mancala(MancalaPlayer p1, MancalaPlayer p2)
	{
		this.player1 = p1;
		this.player2 = p2;
		listeners = new ArrayList<ChangeListener>();
		hand = 0;
	}

	/**
	 * Check the winner of the game
	 */
	public void checkWinner()
	{
		if (player1.getMancala() > player2.getMancala())
		{

			System.out.println("Player 1 Wins"); // Quit or restart the game.


		}

		if (player2.getMancala() > player1.getMancala())
		{

			System.out.println("Player 2 Wins"); // Quit or start the game.


		}

		if (player2.getMancala() == player1.getMancala())
		{

			System.out.println("Draw"); // Quit or start the game.


		}


	}


	/**
	 * select a pit and spread the stones
	 * @param index this index selected
	 */
	public void select(int index)
	{
		int pos = index;
		int startPos = index;


		// numbers stones in hand 
		if (player1.isGoing() == true)
		{
			//int counter = player1.get(index);

			//selection = player1.arrayNow(); // for the stones // idk if we need this 
			hand = player1.get(index);
			handTracker = player1.get(index);

			if (player1.gameOver() == true)
			{
				checkWinner();

			}

			while (hand > 0) //(counter > 0)
			{
				for (int i = pos+1; i < 7 ; i++)
				{
					if(hand > 0)
					{
						player1.add(i); // add starting from this position 
						hand--;
						// counter--; dont know if i need this 
						counter++;
						endPos = i;
					}

					if (hand == 0)
					{
						whoSide = player1.getName();
						if (player1.getName() != whoSide || endPos < 6 )
						{
							player1.switchPlayer();
							player2.switchPlayer();

						}

						break;
					}
					

				}

				if (hand != 0)
				{

					for (int i = 0; i < 6; i++)
					{
						if (hand == 0)
						{
							whoSide = player2.getName();

							if (player1.getName() != whoSide || endPos < 6 )
							{
								player1.switchPlayer();
								player2.switchPlayer();

							}

							break;
						}


						player2.add(i); // 0 the starting point of player 2 array and board 
						hand--;
						counter++;
						endPos = i;
					}

					if (hand != 0)
					{

						for (int i = 0; i < 7; i++)
						{

							if (hand == 0)
							{
								whoSide = player1.getName();
								if (player1.getName() != whoSide || endPos < 6)
								{
									player1.switchPlayer();
									player2.switchPlayer();

								}
								break;
							}

							player1.add(i); // 0 the starting point of player 2 array and board 
							hand--;
							counter++;
							endPos = i;
						}
					}
				}
			}
		}
		else
		{
			//selection = player2.arrayNow(); // grab the stones 

			//selection = player2.arrayNow(); // for the stones // idk if we need this 
			hand = player2.get(index);
			handTracker = player2.get(index);
			counter = 0;

			if (player2.gameOver() == true)
			{
				checkWinner();

			}


			while (hand > 0)
			{
				for (int i = pos+1; i < 7; i++)
				{
					if (hand > 0)
					{
						player2.add(i); // add starting from this position 
						hand--;
						counter++;
						// counter--; dont know if i need this 
						endPos = i;
					}

					if (hand == 0)
					{
						whoSide = player2.getName();
						if (player2.getName() != whoSide || endPos < 6 )
						{
							player2.switchPlayer();
							player1.switchPlayer();

						}

						break;
					}
				}

				if (hand != 0)
				{

					for (int i = 0; i < 6 - 1; i++)
					{

						if (hand == 0)
						{
							whoSide = player1.getName();
							if (player2.getName() != whoSide || endPos < 6)
							{
								player2.switchPlayer();
								player1.switchPlayer();

							}
							break;
						}

						player1.add(i); // 0 the starting point of player 2 array and board 
						hand--;
						counter++;
						endPos = i;

					}

					if (hand != 0)
					{
						for (int i = 0; i < 7; i++)
						{
							if (hand == 0)
							{
								whoSide = player2.getName();
								if (player2.getName() != whoSide || endPos < 6)
								{
									player2.switchPlayer();
									player1.isGoing();
								}

								break;
							}

							player2.add(i); // 0 the starting point of player 2 array and board 
							hand--;
							counter++;
							endPos = i;
						}
					}
				}
			}
		}
		for(ChangeListener l : listeners){
			l.stateChanged(new ChangeEvent(this));
		}
		printBoard();
	}	

	/**
	 * undo a move
	 */
	public void undo()
	{

		if (player1.isGoing())
		{
			if (player1.checkUndos() == true)
			{
				player1.getUndo(); // subtracts a undo from the class 

				if (player1.getName() == whoSide)
				{
					while (handTracker > 0)
					{

						for (int i = endPos; i >= 0; i--)
						{ 
							if (handTracker == 0)
							{
								break;
							}


							player1.subtract(i);
							handTracker--;


						}

						if (handTracker != 0)
						{

							for (int i = 5; i >= 0; i--)
							{ 

								if (handTracker == 0)
								{
									break;
								}
								player2.subtract(i);
								handTracker--;

							}


						}

						if (handTracker != 0)
						{
							for (int i = 6; i >= 0; i--)
							{ 
								if (handTracker == 0)
								{
									break;
								}

								player1.subtract(i);
								handTracker--;		
							}

						}


					}
				}

				if (player2.getName() == whoSide)
				{
					while (handTracker > 0)
					{

						for (int i = endPos; i >= 0; i--)
						{ 
							if (handTracker == 0)
							{
								break;
							}


							player2.subtract(i);
							handTracker--;


						}

						if (handTracker != 0)
						{

							for (int i = 5; i >= 0; i--)
							{ 

								if (handTracker == 0)
								{
									break;
								}
								player1.subtract(i);
								handTracker--;
							}


						}

						if (handTracker != 0)
						{
							for (int i = 6; i >= 0; i--)
							{ 
								if (handTracker == 0)
								{
									break;
								}

								player2.subtract(i);
								handTracker--;		
							}

						}


					}

				}

			}

		}

		if (player2.isGoing())
		{
			if (player2.checkUndos() == true)
			{
				player2.getUndo(); // subtracts a undo from the class 

				if (player1.getName() == whoSide)
				{
					while (handTracker > 0)
					{

						for (int i = endPos; i >= 0; i--)
						{ 
							if (handTracker == 0)
							{
								break;
							}


							player1.subtract(i);
							handTracker--;


						}

						if (handTracker != 0)
						{

							for (int i = 5; i >= 0; i--)
							{ 

								if (handTracker == 0)
								{
									break;
								}
								player2.subtract(i);
								handTracker--;

							}


						}

						if (handTracker != 0)
						{
							for (int i = 6; i >= 0; i--)
							{ 
								if (handTracker == 0)
								{
									break;
								}

								player1.subtract(i);
								handTracker--;		
							}

						}


					}
				}

				if (player2.getName() == whoSide)
				{
					while (handTracker > 0)
					{

						for (int i = endPos; i >= 0; i--)
						{ 
							if (handTracker == 0)
							{
								break;
							}


							player2.subtract(i);
							handTracker--;


						}

						if (handTracker != 0)
						{

							for (int i = 5; i >= 0; i--)
							{ 

								if (handTracker == 0)
								{
									break;
								}
								player1.subtract(i);
								handTracker--;
							}


						}

						if (handTracker != 0)
						{
							for (int i = 6; i >= 0; i--)
							{ 
								if (handTracker == 0)
								{
									break;
								}

								player2.subtract(i);
								handTracker--;		
							}

						}


					}


				}

			}

		}
		for(ChangeListener l : listeners){
			l.stateChanged(new ChangeEvent(this));
		}

	}

	/**
	 * add new change listener to the array list
	 * @param l chnage listener
	 */
	public void addChangeListener(ChangeListener l)
	{

		listeners.add(l);
		// notifiedChange();
	}

	/**
	 * get the data of the board
	 * @return number of stones in each pit
	 */
	public int[][] getPits(){
		int[][] data = new int[2][7];
		int[] p1Data = player1.getData();
		int[] p2Data = player2.getData();
		for(int i = 0; i < 7; i++){
			data[0][i] = p1Data[i];
			data[1][i] = p2Data[i];
		}
		return data;
	}

	public int whoGoing(){
		if(player1.isGoing())
			return player1.getName();
		else
			return player2.getName();
	}
	
	public void printBoard(){
		int[] player2Pit = player2.getData();
		int[] player1Pit = player1.getData();
		System.out.println("  " + player2Pit[5] + " " + player2Pit[4] + " " + player2Pit[3] +
				" " + player2Pit[2] + " " + player2Pit[1] + " " + player2Pit[0]);
		System.out.println(player2Pit[6] + "             " + player1Pit[6]);
		System.out.println("  " + player1Pit[0] + " " + player1Pit[1] + " " + player1Pit[2] +
				" " + player1Pit[3] + " " + player1Pit[4] + " " + player1Pit[5]);
	}
}

