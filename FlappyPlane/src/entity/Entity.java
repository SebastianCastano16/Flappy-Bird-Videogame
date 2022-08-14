package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {    
	public int x, y;    
	public int speed;  
	public int playerScore = 0;
	
	public BufferedImage up1, up2, map1, up3;
	public BufferedImage tile1, tile2;
	public int tile1_x = 790, tile1_y = 350, tile1_Height = 150; 
	public int tile2_x = 790, tile2_y = 0, tile2_Height = 150; 
	public int randNum = 0;
	public boolean planeCrash = false, scoreChecker = true;
	public boolean goldCheck = false;
	
	public BufferedImage apple1, apple2, apple3, apple4, apple5, apple6, apple7, apple8, apple9, apple10;
	
	public int spriteCounter = 0;
	public int spriteNum = 1;
	
	public Rectangle solidArea;
	public boolean collisionOn = false;
}

