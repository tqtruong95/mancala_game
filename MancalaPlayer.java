/**
 * The Mancala player class 
 */
public class MancalaPlayer{

	private int name;
	private boolean isGoing;
	private int[] mancala;
	private int undos = 3;
	private boolean usedUndo;

	// each player might need a "hand" and acessor, getter. and setter 
	//might need to store stones and set how each game has?
	
	/**
	 * Constructing the Mancala Player. 
	 * @param name The name of the player
	 * @param b Determines who is going 
	 * @param stones The number of stones in the board game
	 */
	public MancalaPlayer(int name, boolean b, int stones)
	{
		this.name = name;
		this.isGoing = b;
		this.mancala = new int[7];
		for(int i = 0; i < mancala.length-1; i++)
		{
			mancala[i] = stones;
		}
		this.usedUndo = false;
	}
	
	/**
	 * Returns the array of stones in each pit.
	 * @return mancala The number of mancala stones
	 */
	public int[] getData(){
		return mancala;
	}

	/**
	 * Returns the name of the player
	 * @return name the Name of player
	 */
	public int getName()
	{
		return name;

	}
	/**
	 * Check if user undo the board game
	 * @return true if user undo board game. False otherwise.
	 */
	public boolean checkUndos()
	{
		if (this.undos > 0)
		{
			return true;
		}
		return false;
	}

	/**
	 * Gets the restarted position of the board game
	 */
	public void getUndo()
	{

		if (undos > 0)
		{
			undos--;
			this.usedUndo();

		}

	}
	
	/**
	 * Player uses undo
	 * @return usedUndo Returns true if player uses undo
	 */
	public boolean usedUndo()
	{
		usedUndo = true;
		return usedUndo;

	}


	/**
	 * Retrieve the number of stones in the given index
	 * @param index Gets the index of the stones 
	 */
	public int get(int index)
	{
		int stones = mancala[index];
		mancala[index] = 0;
		return stones;
	}

	/**
	 * Adds stone to the mancala pits
	 */
	public void add(int p) 
	{
		int x; // save the reference of what is in mancala position 
		//int h = hand;	   
		x = mancala[p];
		mancala[p] = x + 1;

	}
	/**
	 * Subtracts the number of stones from the mancala pits 
	 */
	public void subtract(int p) // subtracting stones 
	{
		int x; // save the reference of what is in mancala position 
		//int h = hand;;
		x = mancala[p];
		mancala[p] = x - 1;

	}
	
	/**
	 * Checks if the player is going
	 * @return true if the player is going
	 */
	public boolean isGoing() 
	{
//		isGoing = true; // testing purposes 
		return isGoing;
	}

	/**
	 * Switches player after the player finishes going. 
	 */
	public void switchPlayer() // testing purposes 
	{
		isGoing = !isGoing;
		if(usedUndo) usedUndo = false;
	}

	/**
	 * Checks if the game is over
	 * @return true The game is over because there are no more stones left in one of the players pits
	 */
	public boolean gameOver()
	{
		for(int i = 0; i < mancala.length-1; i++)
		{
			if(mancala[i] != 0)
				return false;
		}
		return true;
	}
	
	/**
	 * Get the array of mancala stones
	 * @return mancala the number of mancala
	 */
	public int getMancala()
	{
		return mancala[mancala.length - 1];
	}

}
