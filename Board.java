import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

public class Board extends JComponent {
	private BoardLayout layout;
	private Mancala game;
	public Board(BoardLayout layout, Mancala game){
		this.layout = layout;
		this.game = game;
	}

	public void paintComponent(Graphics g){
		layout.display(g, this, game);
	}
	
	public BoardLayout mancalaLayout(){
		return layout;
	}
}
