package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Map extends Entity{
	GamePanel gp;
	
	public Map(GamePanel g){
		this.gp = g;
		
		getMap();
	}
	
	public void getMap() {
		try {
			map1 = ImageIO.read(getClass().getResourceAsStream("/map/bg.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {
		BufferedImage image = map1;
		g2.drawImage(image, 0, 0, gp.screenWidth, gp.screenHeight, null);
	}
}

