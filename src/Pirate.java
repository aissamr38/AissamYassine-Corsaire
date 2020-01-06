import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import javax.swing.JPanel;


public class  Pirate extends JPanel {

	
	private Constantes couleur;
        private int id;
       
	private boolean monte;
        private String img;
        private BufferedImage image;
        

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
        

	public Pirate(Constantes couleur) {
		
		this.couleur = couleur;
		setOpaque(false);
               

	}
        public Pirate(Constantes couleur,String img) {
		this.img = img;
		this.couleur = couleur;
		setOpaque(false);
                try {                
          image = ImageIO.read(new File(img));
                   } catch (IOException ex) {
                         System.out.println("erreur path");
                         }

	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
        g.drawImage(image, 0, 0, this);

	}

	public Constantes getCouleur() {
		return couleur;
	}

	public boolean isMonte() {
		return monte;
	}

	public void setMonte(boolean monte) {
		this.monte = monte;
	}

        public void tirer()
        {
        
        }
         
    
}