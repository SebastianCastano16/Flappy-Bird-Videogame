package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import FlappyBird.GamePanel;
import FlappyBird.KeyHandler;

public class Player extends Entity {

	GamePanel gp;
	KeyHandler keyH;
	
	public final int screenX;
	public final int screenY;


	public Player(GamePanel gp, KeyHandler keyH) {

		this.gp = gp;
		this.keyH = keyH;
		
		screenX = 0;
		screenY = 250;

	/*	screenX = gp.screenWidth/2 - (gp.tileSize/2); 
		screenY = gp.screenHeight/2 -(gp.tileSize/2);
		 
		soidArea = new Rectangle
	*/	  
		 
		setDefaultValues();
		getPlayerImage();
	}

	public void setDefaultValues() {

		worldX = 50403;
		worldY = 1000;
		speed = 4;
		direction = "down";
	}

	public void getPlayerImage() {

		try {

			planeBlue1 = ImageIO.read(getClass().getResourceAsStream("/player/planeBlue1.png"));
			planeBlue2 = ImageIO.read(getClass().getResourceAsStream("/player/planeBlue2.png"));
			planeBlue3 = ImageIO.read(getClass().getResourceAsStream("/player/planeBlue3.png"));
			planeGreen1 = ImageIO.read(getClass().getResourceAsStream("/player/planeGreen1.png"));
			planeGreen2 = ImageIO.read(getClass().getResourceAsStream("/player/planeGreen2.png"));
			planeGreen3 = ImageIO.read(getClass().getResourceAsStream("/player/planeGreen3.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update() {

		if (keyH.upPressed == true || keyH.downPressed == true || keyH.rightPressed == true
				|| keyH.leftPressed == true) {

			if (keyH.upPressed == true) {
				direction = "up";
				worldY -= speed;
			} else if (keyH.downPressed == true) {
				direction = "down";
				worldY += speed;
			} else if (keyH.leftPressed == true) {
				direction = "left";
				worldX -= speed;
			} else if (keyH.rightPressed == true) {
				direction = "right";
				worldX += speed;
			}

			spriteCounter++;
			if (spriteCounter > 10) {
				if (spriteNum == 1) {
					spriteNum = 2;
				} else if (spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}
	}

	public void draw(Graphics2D g2) {

//		g2.setColor(Color.cyan);
//		g2.fillRect(x, y, gp.tileSize, gp.tileSize);

		BufferedImage image = null;

		switch (direction) {
		case "up":
			if (spriteNum == 1) {
				image = planeBlue1;
			}
			if (spriteNum == 2) {
				image = planeBlue2;
			}

			break;
		case "down":
			if (spriteNum == 1) {
				image = planeBlue1;
			}
			if (spriteNum == 2) {
				image = planeBlue2;
			}
			break;
		case "right":
			if (spriteNum == 1) {
				image = planeBlue1;
			}
			if (spriteNum == 2) {
				image = planeBlue2;
			}
			break;

		case "left":
			if (spriteNum == 1) {
				image = planeBlue1;
			}
			if (spriteNum == 2) {
				image = planeBlue3;
			}
		}
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);

	}

}
