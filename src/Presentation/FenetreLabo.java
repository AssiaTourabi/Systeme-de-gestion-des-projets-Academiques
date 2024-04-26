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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Gestionnaire.Gestion_Labo;
import Metier.Labo;

public class FenetreLabo extends JFrame {
	private JLabel nom;
	private JLabel email;
	private JLabel num;
	private JLabel chef;
	private JTextField nomTexte;
	private JTextField emailTexte;
	private JTextField numTexte;
	private JTextField chefTexte;
	private JButton Supprimer;
	private JButton updateNom;
	private JButton updateEmail;
	private JButton ajouter;
	private JButton afficherTout;
	private ControlleurLabo controlleur;
	private Gestion_Labo lab;
	// private JComboBox<String> jComboBox;
	// private String[] optionsToChoose;
	private JTextField field1 = new JTextField();
	private JTextField field2 = new JTextField();
	private JPanel panel = new JPanel(new GridLayout(2, 2));

	public FenetreLabo(ControlleurLabo c) throws HeadlessException, SQLException {
		super();
		this.initialiser();
		this.dessiner();
		this.action();
		this.controlleur = c;
	}

	public FenetreLabo(ControlleurLabo c, Labo l) throws HeadlessException, SQLException {
		this(c);
		this.nomTexte.setText(l.getNom_Labo());
		this.emailTexte.setText(l.getEmail_Labo());
		this.numTexte.setText(l.getN_Labo().toString());

	}

	private void initialiser() throws SQLException {

		nom = new JLabel("Nom :");
		email = new JLabel("Email :");
		num = new JLabel("Num Labo :");
		chef = new JLabel("Num  chef Labo :");
		nomTexte = new JTextField(45);
		emailTexte = new JTextField(45);
		numTexte = new JTextField(45);
		chefTexte = new JTextField(45);
		Supprimer = new JButton("Supprimer par nom");
		updateNom = new JButton("update Nom");
		updateEmail = new JButton("update Email");
		ajouter = new JButton("Ajouter");
		afficherTout = new JButton("afficher Tout");
		lab = new Gestion_Labo();
		// optionsToChoose = new String[depart.dispNom().size()];
		// lab..dispNom().toArray(optionsToChoose);
		// jComboBox = new JComboBox<>(optionsToChoose);
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
		panelNord.add(nomTexte);
		panelNord.add(email);
		panelNord.add(emailTexte);
		panelNord.add(num);
		panelNord.add(numTexte);
		panelNord.add(chef);
		panelNord.add(chefTexte);

		// panelNord.add(jComboBox);
		panelNord.setBackground(Color.LIGHT_GRAY);

		JPanel panelSud = new JPanel();
		panelSud.add(ajouter);
		panelSud.add(Supprimer);
		panelSud.add(updateNom);
		panelSud.add(updateEmail);
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

				Labo lab;

				lab = new Labo(numTexte.getText(), nomTexte.getText(), emailTexte.getText(), chefTexte.getText());

				if (controlleur.ajouter(lab)) {
					JOptionPane.showMessageDialog(ajouter, "Le labo a été ajouter !");
				} else {
					JOptionPane.showMessageDialog(ajouter, "Error!!", "Alert", JOptionPane.WARNING_MESSAGE);
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
				try {
					if (controlleur.Supprimer(controlleur.ReturnId(numTexte.getText()))) {
						JOptionPane.showMessageDialog(Supprimer, "la fieliere a été supprimée !!");
					} else {
						JOptionPane.showMessageDialog(Supprimer, "Error!!", "Alert", JOptionPane.WARNING_MESSAGE);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				;
			}
		});

		updateNom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int result = JOptionPane.showConfirmDialog(null, panel, "Enter the old and new name",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				String input1 = field1.getText();
				String input2 = field2.getText();

				if (result == JOptionPane.OK_OPTION) {

					try {
						if (controlleur.chercherId(controlleur.ReturnId(input1))) {

							if (controlleur.updasteNom(controlleur.ReturnId(input1), input2)) {
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

		updateEmail.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int result = JOptionPane.showConfirmDialog(null, panel, "Enter the old and new Email",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				String input1 = field1.getText();
				String input2 = field2.getText();

				if (result == JOptionPane.OK_OPTION) {

					try {
						if (controlleur.chercherEmail(input1)) {

							if (controlleur.updasteEmail(controlleur.ReturnId(input1), input2)) {
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
