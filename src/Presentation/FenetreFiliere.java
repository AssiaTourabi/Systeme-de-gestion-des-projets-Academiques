package Presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Gestionnaire.Gestion_Departement;
import Metier.Filiere;

public class FenetreFiliere extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel nom;
	private JLabel email;
	private JLabel idDepart;
	private JLabel idProf;
	private JTextField nomTexte;
	private JTextField emailTexte;
	private JTextField profTexte;
	private JButton Supprimer;
	private JButton updateNomFiliere;
	private JButton updateEmailFiliere;
	private JButton ajouter;
	private JButton afficherTout;
	private filiereControleur controlleur;
	private Gestion_Departement depart;
	private JComboBox<String> jComboBox;
	private String[] optionsToChoose;
	private JTextField field1 = new JTextField();
	private JTextField field2 = new JTextField();
	private JPanel panel = new JPanel(new GridLayout(2, 2));

	public FenetreFiliere(filiereControleur c) throws HeadlessException, SQLException {
		super();
		this.initialiser();
		this.dessiner();
		this.action();
		this.controlleur = c;
	}

	public FenetreFiliere(filiereControleur c, Filiere f) throws HeadlessException, SQLException {
		this(c);
		this.nomTexte.setText(f.getNom_Filiere());
		this.emailTexte.setText(f.getEmail_Filiere());

	}

	private void initialiser() throws SQLException {

		nom = new JLabel("Nom :");
		email = new JLabel("Email :");
		idDepart = new JLabel("Departement :");
		idProf = new JLabel("Professeur  :");
		nomTexte = new JTextField(45);
		emailTexte = new JTextField(45);
		profTexte = new JTextField(45);
		Supprimer = new JButton("Supprimer par nom");
		updateNomFiliere = new JButton("update Nom");
		updateEmailFiliere = new JButton("update Email");
		ajouter = new JButton("Ajouter");
		afficherTout = new JButton("afficher Tout");
		depart = new Gestion_Departement();
		optionsToChoose = new String[depart.dispNom().size()];
		depart.dispNom().toArray(optionsToChoose);
		jComboBox = new JComboBox<>(optionsToChoose);
		panel.add(new JLabel("Old one:"));
		panel.add(new JLabel("New one:"));

	}

	private void dessiner() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(450, 190, 2500, 700);
		this.setResizable(true);
		JPanel panelNord = new JPanel();
		panelNord.setLayout(new GridLayout(3, 3));
		panelNord.add(nom);
		panelNord.add(email);
		panelNord.add(idProf);
		panelNord.add(nomTexte);
		panelNord.add(emailTexte);
		panelNord.add(profTexte);
		panelNord.add(idDepart);
		panelNord.add(jComboBox);
		panelNord.setBackground(Color.LIGHT_GRAY);

		JPanel panelSud = new JPanel();
		panelSud.add(ajouter);
		panelSud.add(Supprimer);
		panelSud.add(updateNomFiliere);
		panelSud.add(updateEmailFiliere);
		panelSud.add(afficherTout);
		panelSud.setBackground(Color.gray);

		this.setLayout(new BorderLayout());
		this.add(panelSud, BorderLayout.CENTER);
		this.add(panelNord, BorderLayout.NORTH);
		// this.add(panelOuest, BorderLayout.WEST);
		this.setPreferredSize(new Dimension(1400, 1000));
		panel.add(field1);
		panel.add(field2);

	}

	public void action() {

		ajouter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Filiere filiere;

				try {

					filiere = new Filiere(nomTexte.getText(), emailTexte.getText(),
							depart.ReturnIdBySearchNom(optionsToChoose[jComboBox.getSelectedIndex()]),
							profTexte.getText());

					if (controlleur.ajouter(filiere)) {
						JOptionPane.showMessageDialog(ajouter, "La fielliere a été ajouter !");
					} else {
						JOptionPane.showMessageDialog(ajouter, "Error!!", "Alert", JOptionPane.WARNING_MESSAGE);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});

		afficherTout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					controlleur.affichertout();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

		Supprimer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (controlleur.Supprimer(nomTexte.getText())) {
					JOptionPane.showMessageDialog(Supprimer, "la fieliere a été supprimée !!");
				} else {
					JOptionPane.showMessageDialog(Supprimer, "Error!!", "Alert", JOptionPane.WARNING_MESSAGE);
				}
				;
			}
		});

		updateNomFiliere.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int result = JOptionPane.showConfirmDialog(null, panel, "Enter the old and new name",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				String input1 = field1.getText();
				String input2 = field2.getText();

				if (result == JOptionPane.OK_OPTION) {

					try {
						if (controlleur.chercherNom(input1)) {

							if (controlleur.updasteNom(input2, input1)) {
								JOptionPane.showMessageDialog(null, "Operation completed successfully.", "Success",
										JOptionPane.INFORMATION_MESSAGE);

							} else {
								JOptionPane.showMessageDialog(panel, "Error!!", "Alert", JOptionPane.WARNING_MESSAGE);
							}

						}
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}

		});

		updateEmailFiliere.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int result = JOptionPane.showConfirmDialog(null, panel, "Enter the old and new Email",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				String input1 = field1.getText();
				String input2 = field2.getText();

				if (result == JOptionPane.OK_OPTION) {

					try {
						if (controlleur.chercherEmail(input1)) {

							if (controlleur.updasteNom(input2, input1)) {
								JOptionPane.showMessageDialog(null, "Operation completed successfully.", "Success",
										JOptionPane.INFORMATION_MESSAGE);

							} else {
								JOptionPane.showMessageDialog(panel, "Error!!", "Alert", JOptionPane.WARNING_MESSAGE);
							}

						}
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}

		});

	}
}
