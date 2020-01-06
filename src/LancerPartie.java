

import javax.swing.JFrame;
import javax.swing.UIManager;


public class LancerPartie {
        public boolean a = true;
        int nb=MenuControl.nbrcase;
	public LancerPartie() {
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch(Exception e){}
		JFrame f = new JFrame();

		 f.setSize(50*nb, 50*nb);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		Ile p =new Ile(12);
                f.add(p);
                f.setVisible(true);
               

	}

}