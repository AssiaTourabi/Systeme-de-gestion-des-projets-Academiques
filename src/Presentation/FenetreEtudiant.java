package Presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Metier.Etudiant;

public class FenetreEtudiant extends JFrame {

	private JPanel contentPane;
	private JTextField idtextField;
	private JTextField nomtextField;
	private JTextField prenomtextField;
	private JTextField cnetextField;
	private JTextField filieretextField;
	private JTextField niveautextField;
	private JTextField emailtextField;
	private JTextField motPassetextField;

	JLabel titleLabel;
	JLabel idLabel;
	JLabel nomLabel;

	JLabel Label;

	JLabel filliereLabel;

	JLabel niveauLabel;

	JLabel cneLabel;

	JLabel emailLabel;

	JLabel motPassLabel;

	JButton ajouterBtn;

	JButton modifuerBtn;

	JButton afficherBtn;

	JButton supprimerBtn;

	private ControlleurEtudiant controlleur;

	public FenetreEtudiant(ControlleurEtudiant c) throws HeadlessException {
		super();
		this.initialiser();
		this.dessiner();
		this.action();
		this.controlleur = c;
	}

	private void initialiser() {
		idtextField = new JTextField();

		nomtextField = new JTextField();

		prenomtextField = new JTextField();

		cnetextField = new JTextField();

		filieretextField = new JTextField();

		niveautextField = new JTextField();

		emailtextField = new JTextField();

		motPassetextField = new JTextField();

		titleLabel = new JLabel("Etudiant");

		idLabel = new JLabel("id Etudiant:");

		nomLabel = new JLabel("Nom Etudiant");

		Label = new JLabel("Prenom Etudiant");

		filliereLabel = new JLabel("Filliere");

		niveauLabel = new JLabel("Niveau");

		cneLabel = new JLabel("CNE");

		emailLabel = new JLabel("Email");

		motPassLabel = new JLabel("Mot De passe");

		ajouterBtn = new JButton("ajouter");

		modifuerBtn = new JButton("modifier");

		afficherBtn = new JButton("afficher");

		supprimerBtn = new JButton("supprimer");

	}

	private void dessiner() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 190, 2500, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		titleLabel.setBounds(29, 23, 160, 25);
		contentPane.add(titleLabel);

		idLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idLabel.setBounds(155, 122, 118, 25);
		contentPane.add(idLabel);

		nomLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nomLabel.setBounds(155, 189, 99, 25);
		contentPane.add(nomLabel);

		Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Label.setBounds(155, 271, 118, 25);
		contentPane.add(Label);

		filliereLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		filliereLabel.setBounds(155, 402, 96, 25);
		contentPane.add(filliereLabel);

		niveauLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		niveauLabel.setBounds(155, 451, 99, 25);
		contentPane.add(niveauLabel);

		cneLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cneLabel.setBounds(155, 338, 99, 14);
		contentPane.add(cneLabel);

		emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		emailLabel.setBounds(155, 527, 81, 25);
		contentPane.add(emailLabel);

		motPassLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		motPassLabel.setBounds(155, 592, 118, 25);
		contentPane.add(motPassLabel);

		idtextField.setBounds(383, 126, 127, 21);
		contentPane.add(idtextField);
		idtextField.setColumns(10);

		nomtextField.setBounds(383, 193, 127, 20);
		contentPane.add(nomtextField);
		nomtextField.setColumns(10);

		prenomtextField.setBounds(383, 275, 127, 20);
		contentPane.add(prenomtextField);
		prenomtextField.setColumns(10);

		cnetextField.setBounds(383, 337, 127, 20);
		contentPane.add(cnetextField);
		cnetextField.setColumns(10);

		filieretextField.setBounds(383, 406, 127, 20);
		contentPane.add(filieretextField);
		filieretextField.setColumns(10);

		niveautextField.setBounds(383, 466, 127, 20);
		contentPane.add(niveautextField);
		niveautextField.setColumns(10);

		emailtextField.setBounds(383, 531, 127, 20);
		contentPane.add(emailtextField);
		emailtextField.setColumns(10);

		motPassetextField.setBounds(383, 596, 127, 20);
		contentPane.add(motPassetextField);
		motPassetextField.setColumns(10);

		ajouterBtn.setBounds(699, 315, 99, 37);
		contentPane.add(ajouterBtn);

		modifuerBtn.setBounds(699, 386, 99, 30);
		contentPane.add(modifuerBtn);

		afficherBtn.setBounds(699, 454, 99, 25);
		contentPane.add(afficherBtn);

		supprimerBtn.setBounds(699, 514, 99, 30);
		contentPane.add(supprimerBtn);
		contentPane.setVisible(true);
	}

	public void action() {

		ajouterBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Etudiant etud = new Etudiant(idtextField.getText(), nomtextField.getText(), prenomtextField.getText(),
						filieretextField.getText(), niveautextField.getText(), cnetextField.getText(),
						emailtextField.getText(), motPassetextField.getText());

				try {
					if (controlleur.ajouter(etud)) {
						JOptionPane.showMessageDialog(ajouterBtn, "Ajout avec succes");
					}

					else {
						JOptionPane.showMessageDialog(ajouterBtn, "Etudiant existe deja");
					}
				} catch (HeadlessException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		afficherBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				controlleur.affichertout();
			}

		});
		supprimerBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (controlleur.supprimer(idtextField.getText())) {
					JOptionPane.showMessageDialog(supprimerBtn, "Suppression avec succes");
				} else {
					JOptionPane.showMessageDialog(supprimerBtn, "Etudiant n'existe pas");
				}
			}

		});
		modifuerBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// prenomETextField

				if (controlleur.modifier(idtextField.getText(), nomtextField.getText(), prenomtextField.getText(),
						niveautextField.getText(), filieretextField.getText(), emailtextField.getText(),
						cnetextField.getText(), motPassetextField.getText())) {
					JOptionPane.showMessageDialog(modifuerBtn, "Modification avec succes");
				} else {
					JOptionPane.showMessageDialog(modifuerBtn, "Etudiant n'existe pas");
				}

			}

		});

	}

}
