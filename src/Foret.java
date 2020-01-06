import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Foret {

	private int x;
	private int y;
	private ImageIcon iconImage;
	
	
	public Foret(int x, int y, ImageIcon iconImage) {
		super();
		this.x = x;
		this.y = y;
		this.iconImage = iconImage;
	}




	public void paint(Graphics g) {
		 iconImage= new ImageIcon("foret.jpg");
		g.drawImage(iconImage.getImage(), 0, 0, null);
	}

	
	
	public int getX() {
		return x;
	}




	public void setX(int x) {
		this.x = x;
	}




	public int getY() {
		return y;
	}




	public void setY(int y) {
		this.y = y;
	}




	public ImageIcon getIconImage() {
		return iconImage;
	}




	public void setIconImage(ImageIcon iconImage) {
		this.iconImage = iconImage;
	}





}
