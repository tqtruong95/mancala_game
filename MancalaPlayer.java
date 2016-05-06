public class MancalaPlayer{

	private int name;
	private boolean isGoing;
	private int[] mancala;
	private int undos = 3;
	private boolean usedUndo;

	// each player might need a "hand" and acessor, getter. and setter 
	//might need to store stones and set how each game has?

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
	
	public int[] getData(){
		return mancala;
	}

	public int getName()
	{
		return name;

	}

	public boolean checkUndos()
	{
		if (this.undos > 0)
		{
			return true;
		}
		return false;
	}


	public void getUndo()
	{

		if (undos > 0)
		{
			undos--;
			this.usedUndo();

		}

	}

	public boolean usedUndo()
	{
		usedUndo = true;
		return usedUndo;

	}


	//pick the pit and set it to 0
	public int get(int index)
	{
		int stones = mancala[index];
		mancala[index] = 0;
		return stones;
	}


	public void add(int p) // adding stones to pit 
	{
		int x; // save the reference of what is in mancala position 
		//int h = hand;	   
		x = mancala[p];
		mancala[p] = x + 1;

	}

	public void subtract(int p) // subtracting stones 
	{
		int x; // save the reference of what is in mancala position 
		//int h = hand;;
		x = mancala[p];
		mancala[p] = x - 1;

	}

	public boolean isGoing() 
	{
//		isGoing = true; // testing purposes 
		return isGoing;
	}

	public void switchPlayer() // testing purposes 
	{
		isGoing = !isGoing;
		if(usedUndo) usedUndo = false;
	}

	public boolean gameOver()
	{
		for(int i = 0; i < mancala.length-1; i++)
		{
			if(mancala[i] != 0)
				return false;
		}
		return true;
	}

	public int getMancala()
	{
		return mancala[mancala.length - 1];
	}

}