import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

public class InscriptionJoueur {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordCompare;

	public InscriptionJoueur() {
		initialize();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(60, 179, 113));
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		
		
		JLabel lblNomDuJoueur = new JLabel("Nom du joueur :");
		lblNomDuJoueur.setForeground(new Color(128, 0, 0));
		lblNomDuJoueur.setBackground(new Color(255, 127, 80));
		lblNomDuJoueur.setFont(new Font("DJB WERECOW OF DANVILLE", Font.BOLD, 15));
		lblNomDuJoueur.setBounds(40, 76, 224, 21);
		panel_1.add(lblNomDuJoueur);
		
		JLabel label_1 = new JLabel("Mot de passe :");
		label_1.setForeground(new Color(128, 0, 0));
		label_1.setBackground(new Color(255, 127, 80));
		label_1.setFont(new Font("DJB WERECOW OF DANVILLE", Font.BOLD, 15));
		label_1.setBounds(40, 116, 224, 21);
		panel_1.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBackground(new Color(189, 183, 107));
		textField.setBounds(274, 75, 156, 25);
		panel_1.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(189, 183, 107));
		passwordField.setBounds(274, 115, 156, 25);
		panel_1.add(passwordField);
		
		JButton btnRevenir = new JButton("Retour ");
		btnRevenir.setForeground(new Color(205, 133, 63));
		btnRevenir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Enregistrement log = new Enregistrement();
				frame.dispose();
			}
		});
		btnRevenir.setFont(new Font("DomoAregato", Font.BOLD, 14));
		btnRevenir.setBackground(new Color(220, 20, 60));
		btnRevenir.setBounds(40, 238, 171, 31);
		panel_1.add(btnRevenir);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setForeground(new Color(205, 133, 63));
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(passwordField.getText().equals(passwordCompare.getText())) {
					File file=new File("file.txt");
					if(!file.exists()){
						try{
							file.createNewFile();
						}catch (IOException ex){
							ex.printStackTrace();
						}
					}
					try(PrintWriter print =new PrintWriter(new FileOutputStream(file,true))) 
					{
						print.println(textField.getText()+" "+passwordField.getText());
					}catch (IOException exp)
					{
						exp.printStackTrace();
					}
					Acceuil acc=new Acceuil(textField.getText(),passwordField.getText() );
					frame.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Retaper votre mot de passe");
					textField.setText("");
					passwordField.setText("");
					passwordCompare.setText("");

				}
			}
		});
		btnValider.setFont(new Font("DomoAregato", Font.BOLD, 14));
		btnValider.setBackground(new Color(220, 20, 60));
		btnValider.setBounds(274, 238, 156, 31);
		panel_1.add(btnValider);
		
		JLabel lblRetapezLeMot = new JLabel("Retapez le mot de passe :");
		lblRetapezLeMot.setForeground(new Color(128, 0, 0));
		lblRetapezLeMot.setBackground(new Color(255, 127, 80));
		lblRetapezLeMot.setFont(new Font("DJB WERECOW OF DANVILLE", Font.BOLD, 15));
		lblRetapezLeMot.setBounds(40, 158, 224, 21);
		panel_1.add(lblRetapezLeMot);
		
		passwordCompare = new JPasswordField();
		passwordCompare.setBackground(new Color(189, 183, 107));
		passwordCompare.setBounds(274, 158, 156, 25);
		panel_1.add(passwordCompare);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 497, 395);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
