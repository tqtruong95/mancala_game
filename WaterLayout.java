import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Creating the Water Background Layout 
 */
public class WaterLayout extends BoardLayout{
	private Image background;
	/**
	 * Constructing a water theme board
	 */
	public WaterLayout(){
		try {
			this.background = ImageIO.read(new File("mancala_project/water.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Displays the water theme board
	 * @param g The Graphics object
	 * @param b The Board object
	 * @param game the Mancala object
	 */
	public void display(Graphics g, Board b, Mancala game){
		g.drawImage(background, 0, 0, 1100, 600, b);
		super.display(g, b, game);
	}
}
