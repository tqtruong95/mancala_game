import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class WoodLayout extends BoardLayout{
	private Image background;
	public WoodLayout(){
		try {
			this.background = ImageIO.read(new File("mancala_project/wood.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void display(Graphics g, Board b){
		g.drawImage(background, 0, 0, 1100, 600, b);
		super.display(g, b);
	}
}
