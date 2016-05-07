import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MancalaGUI extends JFrame implements ChangeListener{
	private Board board;
	private Mancala game;
	
	/**
	 * Construct a new window for the game
	 * @param b the mancala board
	 * @param game the database of mancala
	 */
	public MancalaGUI(Board b, Mancala game){
		this.game = game;
		this.board = b;
		b.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				double x = e.getX();
				double y = e.getY();
				Rectangle2D.Double[][] pits = b.mancalaLayout().getPits();
				int player = game.whoGoing();
				for(int i = 0; i < pits[player].length; i++){
					if(pits[player][i].contains(x, y))
						game.select(i);
				}
			}
		});
		add(b);
		setSize(1100, 600);
		setTitle("Mancala Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		board.repaint();
	}


}
