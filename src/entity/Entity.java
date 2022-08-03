package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity { 
	
	public int worldX,worldY;
	public int speed;
	
	public BufferedImage planeBlue1, planeBlue2, planeBlue3, 
	planeGreen1, planeGreen2, planeGreen3;
	public String direction;
	public int spriteCounter = 0;
	public int spriteNum = 1;
	public Rectangle soidArea;
	public boolean collisionOn = false;
}
