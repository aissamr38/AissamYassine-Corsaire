import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class CorsaireEvenement implements MouseListener {
	
	private Ile plateau;
	private Corsaire corsaire;
	
	public CorsaireEvenement(Corsaire corsaire, Ile plateau){
		this.plateau=plateau;
		this.corsaire=corsaire;
	}

	public void mouseClicked(MouseEvent arg0) {
		
	}

	public void mouseEntered(MouseEvent arg0) {
	
	}

	public void mouseExited(MouseEvent arg0) {
		
	}

	public void mousePressed(MouseEvent arg0) {
		plateau.afficherPossibilites(corsaire);
	}

	public void mouseReleased(MouseEvent arg0) {
		
	}

}