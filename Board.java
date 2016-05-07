import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

public class Board extends JComponent {
	private BoardLayout layout;
	private Mancala game;
	
	/**
	 * Construct a new Mancala board
	 * @param layout the BoardLayout
	 */
	public Board(BoardLayout layout, Mancala game){
		this.layout = layout;
		this.game = game;
	}

	/**
	 * draw the board
	 * Graphics g object of Graphics
	 */
	public void paintComponent(Graphics g){
		layout.display(g, this, game);
	}
	
	/**
	 * get the board layout
	 * @return board layout
	 */ 
	public BoardLayout mancalaLayout(){
		return layout;
	}
}
