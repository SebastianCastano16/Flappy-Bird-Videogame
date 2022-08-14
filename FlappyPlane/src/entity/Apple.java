package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Apple extends Entity{
	
	GamePanel gp;
	int index;
	public int [][]details = new int[5][3];
	
	public Apple(GamePanel g){      
		this.gp = g;
		index = 0;
		getApple();
		details[0][0] = 380;
		details[0][1] = 180;
		details[0][2] = 20;
	}
	
	public void getApple() {
		try {
			apple1 = ImageIO.read(getClass().getResourceAsStream("/gold/Gold_1.png"));
			apple2 = ImageIO.read(getClass().getResourceAsStream("/gold/Gold_2.png"));
			apple3 = ImageIO.read(getClass().getResourceAsStream("/gold/Gold_3.png"));
			apple4 = ImageIO.read(getClass().getResourceAsStream("/gold/Gold_4.png"));
			apple5 = ImageIO.read(getClass().getResourceAsStream("/gold/Gold_5.png"));
			apple6 = ImageIO.read(getClass().getResourceAsStream("/gold/Gold_6.png"));
			apple7 = ImageIO.read(getClass().getResourceAsStream("/gold/Gold_7.png"));
			apple8 = ImageIO.read(getClass().getResourceAsStream("/gold/Gold_8.png"));
			apple9 = ImageIO.read(getClass().getResourceAsStream("/gold/Gold_9.png"));
			apple10 = ImageIO.read(getClass().getResourceAsStream("/gold/Gold_10.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		if(index == 0) {
			image = apple1;
		}else if(index == 2){
			image = apple2;
		}else if(index == 4){
			image = apple3;
		}else if(index == 6){
			image = apple4;
		}else if(index == 8){
			image = apple5;
		}else if(index == 10){
			image = apple6;
		}else if(index == 12){
			image = apple7;
		}else if(index == 14){
			image = apple8;
		}else if(index == 16){
			image = apple9;
		}else if(index == 18){
			image = apple10;
		}
		
		if(index >= 20) {
			index = 0;
		}else {
			index = index + 2;
		}
		for(int i =0; i < 1;i++) {
			if(details[i][2] == 0) {
				g2.drawImage(image, details[i][0], details[i][1], gp.tileSize, gp.tileSize, null);
			}
		}
	}
}
