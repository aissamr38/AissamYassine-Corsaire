import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class Enregistrement {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Enregistrement log = new Enregistrement();
					log.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Enregistrement() {
		initialize();
	}

	private static boolean isBlank(String s) {
	     return s == null || s.isEmpty();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 600, 348);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 230, 140));
		panel.setBounds(0, 0, 598, 73);
		frame.getContentPane().add(panel);
		/* les style de l'ecriture */
		JLabel titleFrame = new JLabel("JEU CORSAIRE");
		titleFrame.setFont(new Font("Janda Curlygirl Pop", Font.BOLD, 24));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(181)
					.addComponent(titleFrame)
					.addContainerGap(212, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(20, Short.MAX_VALUE)
					.addComponent(titleFrame)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 230, 140));
		panel_1.setBounds(0, 66, 598, 253);
		
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnSeConnecter = new JButton("connexion");
		btnSeConnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File fichier=new File("file.txt");
				String li;
				boolean trouv=false;
				if(!fichier.exists()){
					try{
						fichier.createNewFile();
					}catch (IOException e){
						e.printStackTrace();
					}
				}
				try(FileInputStream lecture=new FileInputStream(fichier)){
						Scanner a=new Scanner(lecture);
						a.useDelimiter("-");
						while(a.hasNextLine() && !isBlank(li = a.nextLine())){
							 String[] accountData = li.split(" ");
						     String user = accountData[0];
						     String password = accountData[1];
							if (textField.getText().equals(user) && passwordField.getText().equals(password)){
								trouv=true;
								Acceuil acc=new Acceuil(textField.getText(),passwordField.getText());
								frame.dispose();
							}
						}
						if(trouv==false) {
							JOptionPane.showMessageDialog(null, "Le Nom ou le mot de passe est erroné");
						}
						
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		});
		btnSeConnecter.setFont(new Font("DK Pundak", Font.BOLD | Font.ITALIC, 18));
		btnSeConnecter.setBackground(new Color(154, 205, 50));
		btnSeConnecter.setBounds(335, 137, 156, 31);
		panel_1.add(btnSeConnecter);
		
		JLabel username = new JLabel("Psudo d'utilisateur :");
		username.setForeground(new Color(139, 69, 19));
		username.setFont(new Font("DK Jambo", Font.BOLD, 18));
		username.setBounds(80, 40, 184, 28);
		panel_1.add(username);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setForeground(new Color(139, 69, 19));
		lblMotDePasse.setFont(new Font("DK Jambo", Font.BOLD | Font.ITALIC, 19));
		lblMotDePasse.setBounds(80, 80, 184, 21);
		panel_1.add(lblMotDePasse);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 224));
		textField.setBounds(335, 44, 156, 25);
		panel_1.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(255, 255, 224));
		passwordField.setBounds(335, 80, 156, 25);
		panel_1.add(passwordField);
		
		JButton btnSinscrire = new JButton("S'inscrire");
		btnSinscrire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 InscriptionJoueur reg = new InscriptionJoueur();
			 frame.dispose();
			}
		});
		btnSinscrire.setFont(new Font("DK Pundak", Font.BOLD | Font.ITALIC, 18));
		btnSinscrire.setBackground(new Color(154, 205, 50));
		btnSinscrire.setBounds(93, 137, 171, 31);
		panel_1.add(btnSinscrire);
	}
	
	
	/*
	public void paint(Graphics g) {
		ImageIcon img= new ImageIcon("imageAceuilVrai.jpg");
		g.drawImage(img.getImage(), 0, 0, null);
	}*/
}
