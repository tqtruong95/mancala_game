import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
* Creating the WoodLayout theme  
*/
public class WoodLayout extends BoardLayout{
	private Image background;
	/**
	 * Constructing the Wood layout theme for Mancala 
	 */
	public WoodLayout(){
		try {
			this.background = ImageIO.read(new File("mancala_project/wood.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Displays the wood layout theme
	 * @param g The Graphics object
	 * @param b  The Board object
	 * @param game The Mancala object 
	 */
	public void display(Graphics g, Board b, Mancala game){
		g.drawImage(background, 0, 0, 1100, 600, b);
		super.display(g, b, game);
	}
}
