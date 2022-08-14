package entity;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
	GamePanel gp;
	KeyHandler keyH;
	
	public Player(GamePanel g, KeyHandler k) {
		this.gp = g;
		this.keyH = k;
		
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() {
		
		x = 350;
		y = 230;
		speed = 2;
		
	}
	
	public void getPlayerImage() {
		
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/planeBlue1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/planeBlue2.png"));
			up3 = ImageIO.read(getClass().getResourceAsStream("/player/planeBlue3.png"));
			this.tile1 = ImageIO.read(getClass().getResourceAsStream("/map/tile1.png"));
			this.tile2 = ImageIO.read(getClass().getResourceAsStream("/map/tile2.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {               //Player Movement + Player AI
		if(this.keyH.exitPressed == true) {
			System.exit(0);
		}
		if(this.planeCrash == false) {
			if(keyH.upPressed == true) {
				y -= speed;
			}else {
				y += 2;
			}
			spriteCounter++;
			if(spriteCounter > 0) {
				if(spriteNum == 1) {
					spriteNum = 2;
				}else if(spriteNum == 2) {
					spriteNum = 3;
				}else if(spriteNum == 3) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
			if(this.tile1_x < -105) {
				this.tile1_x = 790;
				this.goldCheck = true;
				this.scoreChecker = true;
				Random rand = new Random();
				this.randNum = rand.nextInt() % 3;
				if(randNum == 0) {
					this.tile1_Height = 150;
					this.tile1_y = 350;
				}else if(randNum == 1) {
					this.tile1_Height = 200;
					this.tile1_y = 300;
				}else if(randNum == 2) {
					this.tile1_Height = 250;
					this.tile1_y = 250;
				}
				this.randNum = rand.nextInt() % 3;
				if(randNum == 0) {
					this.tile2_Height = 150;
				}else if(randNum == 1) {
					this.tile2_Height = 200;
				}else if(randNum == 2) {
					this.tile2_Height = 250;
				}
				
				if(tile2_Height == 250 && tile1_Height == 250) {
					this.tile2_Height = 150;
				}
				if(tile2_Height == 200 && tile1_Height == 250) {
					this.tile2_Height = 250;
					this.tile1_Height = 150;
					this.tile1_y = 350;
				}
				if(tile2_Height == 250 && tile1_Height == 200) {
					this.tile2_Height = 250;
					this.tile1_Height = 150;
					this.tile1_y = 350;
				}
			}
			this.tile1_x -= speed + 3;
		}
		
		if(!this.detectCollision()) {
			this.planeCrash = true;
			//System.out.println("Collision Detected!");
		}
		if(x > this.tile1_x + 100 && this.scoreChecker == true) {
			this.playerScore++;
			this.scoreChecker = false;
		}
	}
	
	public boolean detectCollision() {
		if(x <= this.tile1_x + 100 && x + 60 >= this.tile1_x - 2) {
			if(y + 45> this.tile1_y) {
				return false; 
			}else if(y < this.tile2_y + this.tile2_Height) {
				//System.out.println("Y here is " + y);
				return false;
			}
		}
		return true;
	}
	
	public void draw(Graphics2D g2) {       //Redrawing player after every 1 FPS
		
		BufferedImage image = null;
		BufferedImage tileImg1 = this.tile1;
		BufferedImage tileImg2 = this.tile2;
		if(spriteNum == 1) {
			image = up1;
		}
		if(spriteNum == 2) {
			image = up2;
		}
		if(spriteNum == 3) {
			image = up3;
		}
		
		g2.drawImage(image, x, y, 60, 45, null);
		g2.drawImage(tileImg1, this.tile1_x, this.tile1_y, 100, this.tile1_Height, null);
		g2.drawImage(tileImg2, this.tile1_x, this.tile2_y, 100, this.tile2_Height, null);
		if(this.planeCrash == true) {
			g2.setFont(new Font("Times New Roman", Font.BOLD, 60));
			g2.drawString("Plane Crashed!", 200, 250);
		}
	}
}
