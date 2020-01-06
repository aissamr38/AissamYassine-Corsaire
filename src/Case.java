import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Paint;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Case extends JPanel {
	
	private static final long serialVersionUID = -1839026893240660968L;
	private boolean pelle;
	private Constantes couleur;
	private boolean selectionnee;
        private boolean trisor;
        private boolean mousquet;
        private boolean armure;
        private boolean machette;
        
        public boolean isMachette() {
			return machette;
		}

		private boolean foret;
        private boolean eau;
        
        public boolean isEau() {
			return eau;
		}

		public void setEau(boolean eau) {
			this.eau = eau;
		}

		public boolean isForet() {
			return foret;
		}

		public void setForet(boolean foret) {
			this.foret = foret;
		}

		private BufferedImage image;
		
	public Case(Constantes couleur){
		setLayout(new GridLayout(1,0));
		this.couleur=couleur;
                        try {                
          image = ImageIO.read(new File("case.png"));
                   } catch (IOException ex) {
                         System.out.println("PATH ERROR");
                         }
                        
                    
		couleurInitialiser();
	}

	public Constantes getCouleur() {
		return couleur;
	}

	public boolean isSelectionnee() {
		return selectionnee;
	}

	public void setSelectionnee(boolean selectionnee) {
		this.selectionnee = selectionnee;
		if(selectionnee){
			setBackground(Color.BLUE);
			setForeground(Color.LIGHT_GRAY);
		}
		else {
			couleurInitialiser();
		}
	}
	

	
	@Override
	public void paintComponent(Graphics g){
		 super.paintComponent(g);
        g.drawImage(image, 0, 0, this);

                
	}

    public boolean isPelle() {
        return pelle;
    }

    public void setPelle(boolean pelle) {
        this.pelle = pelle;
    }

    public boolean isTrisor() {
        return trisor;
    }

    public void setTrisor(boolean trisor) {
        this.trisor = trisor;
    }

    public boolean isMousquet() {
        return mousquet;
    }

    public void setMousquet(boolean mousquet) {
        this.mousquet = mousquet;
    }
    
    
    public void setMachette(boolean machette) {
        this.machette = machette;
    }
    

    public boolean isArmure() {
        return armure;
    }

    public void setArmure(boolean armure) {
        this.armure = armure;
    }
    
    
	private void couleurInitialiser(){
		switch(couleur){
		case VERT :
			setBackground(Color.GREEN);
			setForeground(new Color(10, 10, 10));
			
			break;
		case NOIR :
			setBackground(Color.GRAY);
			setForeground(new Color(20, 20, 20));
			break;
		case ORANGE :
			setBackground(Color.ORANGE);
			setForeground(new Color(30, 30, 30));
			break;
		}
	}
    
    
	public void setImagePath(BufferedImage imagePath) {
		if(imagePath==null)
		
			JOptionPane.showMessageDialog(null, " ERROR PATH ");
		else
		this.image = imagePath;
	}
        
}