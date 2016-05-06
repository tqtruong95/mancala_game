import javax.swing.JFrame;

public class MancalaGUI extends JFrame{
	public MancalaGUI(Board b){
		add(b);
		setSize(1100, 600);
		setTitle("Mancala Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}

}
