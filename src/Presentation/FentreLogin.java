package Presentation;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Metier.Etudiant;
import Metier.professeur;

public class FentreLogin extends JFrame {

	private JPanel contentPane;
	private JTextField cnetextField;
	private JPasswordField mdpText;

	JLabel cneLabel;
	JLabel mdpLabel;

	JButton loginBtn;
	private Controlleurlogin controlleur;

	public FentreLogin(Controlleurlogin c) throws HeadlessException {
		super();

		this.initialiser();
		this.dessiner();
		this.action();
		this.controlleur = c;
	}

	private void initialiser() {

		contentPane = new JPanel();
		cneLabel = new JLabel("Identifiant:");
		mdpLabel = new JLabel("Mot de passe:");
		cnetextField = new JTextField();
		mdpText = new JPasswordField();
		loginBtn = new JButton("login");

	}

	private void dessiner() {
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 450, 315);

		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		cneLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		cneLabel.setBounds(72, 100, 124, 21);
		contentPane.add(cneLabel);

		mdpLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		mdpLabel.setBounds(72, 155, 124, 37);
		contentPane.add(mdpLabel);

		cnetextField.setBounds(205, 103, 124, 20);
		contentPane.add(cnetextField);
		cnetextField.setColumns(10);

		mdpText.setBounds(206, 166, 124, 20);
		contentPane.add(mdpText);

		loginBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginBtn.setBounds(175, 227, 104, 23);
		contentPane.add(loginBtn);
	}

	public void action() {
		/*
		 * loginBtn.addActionListener(new ActionListener () {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { Etudiant etudiant=new
		 * Etudiant(cnetextField.getText(),mdpTextField.getText());
		 * 
		 * if(controlleur.login(etudiant)) {controlleur.afficherProjerDetail(etudiant);}
		 * else {JOptionPane.showMessageDialog(loginBtn,
		 * "mot de passe ou CNE pas correcte ");} }
		 * 
		 * 
		 * });
		 */

		loginBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String motPasse = new String(mdpText.getPassword());
				Etudiant etudiant = new Etudiant(cnetextField.getText(), motPasse);
				professeur prof = new professeur(cnetextField.getText(), motPasse);
				String CNE = new String(cnetextField.getText());
				if (controlleur.login(etudiant)) {

					ControlleurProjetButtons controlleurB = new ControlleurProjetButtons();
					controlleurB.demmarrerApplication(etudiant);
				} else if (controlleur.loginInfo(prof) != null) {

					if (controlleur.loginInfo(prof).getFonctionalite().equals("admin")) {
						controlleurAdministrateur admin = new controlleurAdministrateur();

						try {
							admin.demmarrerApplication();
						} catch (HeadlessException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					} else if (controlleur.loginInfo(prof).getFonctionalite().equals("Chef de Departement")) {
						// chef departement
						ControlleurElements controlleurEl = new ControlleurElements();
						controlleurEl.demmarrerApplication();

					} else if (controlleur.loginInfo(prof).getFonctionalite().equals("coordinateur")) {
						ControlleurElements controlleurEl = new ControlleurElements();
						controlleurEl.demmarrerApplication();
					} else if (controlleur.loginInfo(prof).getFonctionalite().equals("resposable laboratoire")) {
						// chef labo
						ControlleurElements2 controlleurEl = new ControlleurElements2();
						controlleurEl.demmarrerApplication();
					} else if (controlleur.loginInfo(prof).getFonctionalite().equals("encadrant")) {
						// encadrant
						ControlleurElements2 controlleurEl = new ControlleurElements2();
						controlleurEl.demmarrerApplication();

					}
				} else {

					JOptionPane.showMessageDialog(loginBtn, "mot de passe ou CNE pas correcte ");

				}
			}

		});

	}
}
