package Presentation;

import java.awt.BorderLayout;
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

import Metier.departement;

public class FenetreDepart extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel nom;
	private JLabel codeDepart;
	private JLabel email;
	private JTextField nomTexte;
	private JTextField codeDepartTexte;
	private JTextField emailTexte;
	private JButton Supprimer;
	private JButton ajouter;
	private JButton afficherTout;
	private JButton updateNom;
	private JButton updateEmail;
	private JTextField field1 = new JTextField();
	private JTextField field2 = new JTextField();
	private JPanel panel = new JPanel(new GridLayout(2, 2));

	private ControlleurDepart controlleur;

	public FenetreDepart(ControlleurDepart c) throws HeadlessException {
		super();
		this.initialiser();
		this.dessiner();
		this.action();
		this.controlleur = c;
	}

	public FenetreDepart(ControlleurDepart c, departement d) throws HeadlessException {
		this(c);
		this.codeDepartTexte.setText(d.getCode_depart().toString());
		this.nomTexte.setText(d.getNom_dep());
		this.emailTexte.setText(d.getEmail_dep());
	}

	private void initialiser() {
		nom = new JLabel("Nom");
		codeDepart = new JLabel("Code");
		email = new JLabel("Email");
		nomTexte = new JTextField(30);
		codeDepartTexte = new JTextField(30);
		emailTexte = new JTextField(30);
		Supprimer = new JButton("Supprimer par code");
		updateNom = new JButton("update nom");
		updateEmail = new JButton("update Email");
		ajouter = new JButton("Ajouter");
		afficherTout = new JButton("afficherTout");
		panel.add(new JLabel("Old one:"));
		panel.add(new JLabel("New one:"));
		panel.add(field1);
		panel.add(field2);
	}

	private void dessiner() {
		JPanel panelNord = new JPanel();
		setBounds(450, 190, 2500, 700);
		setResizable(false);
		panelNord.setLayout(new GridLayout(3, 2));
		panelNord.add(codeDepart);
		panelNord.add(codeDepartTexte);
		panelNord.add(nom);
		panelNord.add(nomTexte);
		panelNord.add(email);
		panelNord.add(emailTexte);

		JPanel panelSud = new JPanel();
		panelSud.add(Supprimer);
		panelSud.add(ajouter);
		panelSud.add(afficherTout);
		panelSud.add(updateNom);
		panelSud.add(updateEmail);
		this.setLayout(new BorderLayout());
		this.add(panelSud, BorderLayout.CENTER);
		this.add(panelNord, BorderLayout.NORTH);
		// this.add(panelOuest, BorderLayout.WEST);
		this.setPreferredSize(new Dimension(1400, 1000));

	}

	public void action() {
		ajouter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				departement depart = new departement(Integer.parseInt(codeDepartTexte.getText()), nomTexte.getText(),
						emailTexte.getText());
				if (controlleur.ajouter(depart)) {
					JOptionPane.showMessageDialog(ajouter, "Le departement a été ajouter !");
				}
				;
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
				if (controlleur.Supprimer(Integer.parseInt(codeDepartTexte.getText()))) {
					JOptionPane.showMessageDialog(Supprimer, "Le departement a été supprimée !!");
				} else {
					JOptionPane.showMessageDialog(Supprimer, "Error!!", "Alert", JOptionPane.WARNING_MESSAGE);
				}

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
						if (controlleur.chercherNom(input1)) {

							if (controlleur.updasteNom(controlleur.ReturnId(input1), input2)) {
								JOptionPane.showMessageDialog(null, "Operation completed successfully.", "Success",
										JOptionPane.INFORMATION_MESSAGE);

							} else {
								JOptionPane.showMessageDialog(panel, "Error!!", "Alert", JOptionPane.WARNING_MESSAGE);
							}

						} else {
							JOptionPane.showMessageDialog(panel, "Error!!", "Alert", JOptionPane.WARNING_MESSAGE);
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

							if (controlleur.updasteEmail(input2, Integer.parseInt(input1))) {
								JOptionPane.showMessageDialog(null, "Operation completed successfully.", "Success",
										JOptionPane.INFORMATION_MESSAGE);

							} else {
								JOptionPane.showMessageDialog(panel, "Error!!", "Alert", JOptionPane.WARNING_MESSAGE);
							}

						} else {
							JOptionPane.showMessageDialog(panel, "Error!!", "Alert", JOptionPane.WARNING_MESSAGE);
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
