import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class MenuControl {

	private JFrame frame;
        public boolean b=false;
        public LancerPartie lanc;
        private JTextField nbrCorsaire;
        private JTextField nbCases;
        public static int nbrcorsaire;
        public static int nbrcase;
        
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChoixDifNom window = new ChoixDifNom();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public MenuControl(String joueur,String motDPasse) {
		initialize(joueur, motDPasse);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String chaine,String motpasse) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(60, 179, 113));
		frame.setBounds(100, 100, 498, 382);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Saisir nombre de corsaire");
		lblNewLabel.setForeground(new Color(244, 164, 96));
		lblNewLabel.setFont(new Font("URW Gothic L", Font.BOLD | Font.ITALIC, 15));
		
		JLabel lblTapezLeNombre = new JLabel("Choisir case de l'\u00CFLE");
		lblTapezLeNombre.setBackground(new Color(205, 133, 63));
		lblTapezLeNombre.setForeground(new Color(244, 164, 96));
		lblTapezLeNombre.setFont(new Font("Georgia", Font.BOLD, 14));
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.setFont(new Font("Tekton Pro", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Acceuil acc=new Acceuil(chaine,motpasse);
				frame.dispose();
			}
		});
		btnNewButton.setBackground(new Color(255, 127, 80));
		
		JButton btnNewButton_1 = new JButton("COMMENCER");
		btnNewButton_1.setFont(new Font("Tekton Pro Cond", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			nbrcorsaire=	Integer.valueOf(nbrCorsaire.getText());
			nbrcase =	Integer.valueOf(nbCases.getText());
			        lanc=new LancerPartie();
			        
				frame.dispose();
                             
                              
			}
		});
		btnNewButton_1.setBackground(new Color(255, 127, 80));
		
		nbrCorsaire = new JTextField();
		nbrCorsaire.setColumns(10);
		
		nbCases = new JTextField();
		nbCases.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(48, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblTapezLeNombre, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel)
							.addGap(75))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(42)
									.addComponent(nbCases, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
									.addGap(134)
									.addComponent(nbrCorsaire, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
									.addGap(79)
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)))
							.addGap(84))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblTapezLeNombre, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(nbrCorsaire, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(nbCases, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(135))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
