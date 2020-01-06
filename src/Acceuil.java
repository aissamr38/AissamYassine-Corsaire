import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSlider;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JComboBox;

public class Acceuil {

	private JFrame frame;



	
	public Acceuil(String psudo, String motPasse) {
		accueil(psudo,motPasse);
	}

	
	private void accueil(String chaine, String motDPasse) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 509, 358);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(238, 232, 170));
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JButton btnCommencerUneNouvelle = new JButton("JOUER A NOUVEAU");
		btnCommencerUneNouvelle.setForeground(new Color(160, 82, 45));
		btnCommencerUneNouvelle.setBounds(113, 123, 257, 31);
		btnCommencerUneNouvelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuControl menu = new MenuControl(chaine,motDPasse);
				frame.dispose();
			}
		});
		panel_1.setLayout(null);
		btnCommencerUneNouvelle.setFont(new Font("DFKai-SB", Font.BOLD | Font.ITALIC, 18));
		btnCommencerUneNouvelle.setBackground(new Color(95, 158, 160));
		panel_1.add(btnCommencerUneNouvelle);
		
		JButton btnChargerUnePartie = new JButton("LANCER UNE PARTIE");
		btnChargerUnePartie.setForeground(new Color(160, 82, 45));
		btnChargerUnePartie.setBounds(47, 67, 243, 31);
		
		btnChargerUnePartie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			       LancerPartie lanc=new LancerPartie();
			     
			       frame.dispose();
                             
                              
			}
		});
		
		btnChargerUnePartie.setFont(new Font("DFKai-SB", Font.BOLD | Font.ITALIC, 18));
		btnChargerUnePartie.setBackground(new Color(95, 158, 160));
		panel_1.add(btnChargerUnePartie);
		
		JButton btnQuitter = new JButton("Quitter ");
		btnQuitter.setForeground(new Color(160, 82, 45));
		btnQuitter.setBounds(113, 195, 257, 31);
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuitter.setFont(new Font("DFKai-SB", Font.BOLD | Font.ITALIC, 18));
		btnQuitter.setBackground(new Color(95, 158, 160));
		panel_1.add(btnQuitter);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tarnished Halo", Font.BOLD, 14));
		comboBox.setForeground(new Color(205, 92, 92));
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"etap1","etape2","etap3"}));
		comboBox.setToolTipText("Etape Savegarder");
		comboBox.setBounds(300, 68, 154, 32);
		panel_1.add(comboBox);
	}
}
