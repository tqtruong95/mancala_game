import java.awt.Graphics;

import javax.swing.JComponent;

public class Board extends JComponent {
	private BoardLayout layout;
	public Board(BoardLayout layout){
		this.layout = layout;
	}

	public void paintComponent(Graphics g){
		layout.display(g, this);
	}
}
