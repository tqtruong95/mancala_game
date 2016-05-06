import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class InitialScreen extends JDialog{
	private int numberOfStones;
	private BoardLayout layout;

	/**
	 * Constructor for the Mancala game initial screen
	 * @param owner the parent frame
	 */
	public InitialScreen(Frame owner){
		super(owner, true);
		Container frame = getContentPane();
		setSize(200, 200);
		setTitle("Mancala Game");

		JLabel chooseLayout = new JLabel("Choose a Layout");
		JRadioButton wood = new JRadioButton("Wood");
		wood.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				layout = new WoodLayout();
			}
		});
		JRadioButton water = new JRadioButton("Water");
		water.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				layout = new WaterLayout();
			}
		});

		ButtonGroup lGroup = new ButtonGroup();
		JPanel lP = new JPanel(); // panel for jayout option
		lGroup.add(water);
		lGroup.add(wood);
		lP.add(water);
		lP.add(wood);

		Box box1 = Box.createHorizontalBox();
		box1.add(lP);
		ActionListener l = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JRadioButton b = (JRadioButton) e.getSource();
				int n = Integer.parseInt(b.getText());
				numberOfStones = n;
			}
		};
		JLabel numOfStones = new JLabel("Number of stones");
		JRadioButton one = new JRadioButton("1");
		one.addActionListener(l);
		JRadioButton two = new JRadioButton("2");
		two.addActionListener(l);
		JRadioButton three = new JRadioButton("3");
		three.addActionListener(l);
		JRadioButton four = new JRadioButton("4");
		four.addActionListener(l);
		ButtonGroup sGroup = new ButtonGroup();
		sGroup.add(one);
		sGroup.add(two);
		sGroup.add(three);
		sGroup.add(four);
		JPanel sP = new JPanel();
		sP.add(one);
		sP.add(two);
		sP.add(three);
		sP.add(four);
		Box box2 = Box.createHorizontalBox();
		box2.add(sP);

		JButton start = new JButton("Start Game");
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				dispose();
				MancalaPlayer p1 = new MancalaPlayer(0 , true, numberOfStones);
				MancalaPlayer p2 = new MancalaPlayer(1 , false, numberOfStones);
				Mancala game = new Mancala(p1, p2);
				//				Scanner in = new Scanner(System.in);
				//				while(in.hasNextLine()){
				//					String input = in.nextLine();
				//					game.select(Integer.parseInt(input));
				//				}
				Board b = new Board(layout);
				MancalaGUI gui = new MancalaGUI(b);
			}
		});

		frame.setLayout(new FlowLayout(FlowLayout.LEFT));
		frame.add(chooseLayout);
		frame.add(box1);
		frame.add(numOfStones);
		frame.add(box2);
		frame.add(start);
		setVisible(true);
		setResizable(false);
	}
}
