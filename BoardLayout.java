import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class BoardLayout {
	private Rectangle2D.Double[][] pits;
	private Image stone;
	
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
		try {
			this.stone = ImageIO.read(new File("mancala_project/stone.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	public void display(Graphics g, Board b, Mancala game){
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new java.awt.BasicStroke(5)); 
		for(int i = 0; i < pits.length; i++){
			for(int j = 0; j < pits[i].length; j++){
				g2.draw(pits[i][j]);
			}
		}
		
		//draw stones
		int[][] stoneCount = game.getPits();
		for(int r = 0; r < pits.length; r++){
			for(int c = 0; c < pits[r].length; c++){
				for(int n = 0; n < stoneCount[r][c]; n++){
					drawStone(pits[r][c], g2, b, n);
				}
			}
		}
	}
	
	//Change up this code
		private void drawStone(Rectangle2D.Double r, Graphics g, Board b, int n)
		{
			Random rand = new Random();
			rand.setSeed((int)r.getX() * n +  (int)r.getY() * n + n * n);
			int x = rand.nextInt((int)r.getWidth() - stone.getWidth(b));
			int y = rand.nextInt((int)r.getHeight() - stone.getHeight(b));
			g.drawImage(stone, (int)r.getX() + x, (int)r.getY() + y, 25,
					25, b);
			
			/*for(int i = 0; i < pits.length; i++)
			{
				g.drawImage(stone, (int)r.getX() + i+1, (int)r.getY() + y, 25,
						25, b);
			} 
			for(int i = 0; i < pits.length; i+=200)
			{
				g.drawImage(stone, (int)r.getX() + i + 50, (int)r.getY() + y, 25,
						25, b);
			}*/
		}
	
	public Rectangle2D.Double[][] getPits(){
		return pits;
	}
}
