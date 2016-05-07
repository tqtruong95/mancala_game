import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

public class BoardLayout {
	private Rectangle2D.Double[][] pits;
	private int stones;
	
	/**
	 * Construct a new board layout
	 */
	public BoardLayout(){
		this.pits = new Rectangle2D.Double[2][7];
		Rectangle2D.Double mancala2 = new Rectangle2D.Double(80, 80, 100, 410);
		pits[1][6] = mancala2;
		for(int i = 5; i >= 0; i--){
			Rectangle2D.Double pit = new Rectangle2D.Double(200 + 120*i, 110, 100, 150);
			pits[1][5-i] = pit;
		}
		for(int i = 0; i < 7; i++){
			if(i < 6){
				Rectangle2D.Double pit = new Rectangle2D.Double(200 + 120*i, 310, 100, 150);
				pits[0][i] = pit;
			}
			else{
				Rectangle2D.Double mancala1 = new Rectangle2D.Double(200 + 120*i, 80, 100, 410);
				pits[0][i] = mancala1;
			}
			
		}
//		g.fillRect(0, 80, 1000, 400);
//		g.setColor(Color.WHITE);
//		g.fillRect(70, 150, 110, 300);
//		g.fillRect(800, 150, 110, 300);
//		for(int i = 200; i <= 700; i+=100)
//		{
//			g.clearRect(i, 200, 80, 80);
//
//		} 
//
//		for(int j = 200; j <= 700; j+=100)
//		{
//			g.clearRect(j, 300, 80, 80);
//		}
		
	}
	
	public void display(Graphics g, Board b){
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new java.awt.BasicStroke(5)); 
		for(int i = 0; i < pits.length; i++){
			for(int j = 0; j < pits[i].length; j++){
				g2.draw(pits[i][j]);
			}
		}
	}
	
	public Rectangle2D.Double[][] getPits(){
		return pits;
	}
}
