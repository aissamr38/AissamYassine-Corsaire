import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class CaseDeplacement implements MouseListener{
	
	private Case casee;
	private Ile ile;

	
	public CaseDeplacement(Case casee, Ile ile) {
		super();
		this.casee = casee;
		this.ile = ile;
	}


	public void mouseClicked(MouseEvent arg0) {
	
	}


	public void mouseEntered(MouseEvent arg0) {
		
	}


	public void mouseExited(MouseEvent arg0) {
		
	}


	public void mousePressed(MouseEvent arg0) {
		if(casee.isSelectionnee()){
			ile.deplacer(casee);
		}
	}


	public void mouseReleased(MouseEvent arg0) {
		
	}
	
	

}