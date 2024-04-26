package Presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Metier.Projet;
import Metier.Projet.projetType;

public class FenetreProjet extends JFrame {

	private JPanel contentPane;
	private JTextField ddTextField;
	private JTextField idtextField;
	private JTextField titreTextField;
	private JTextField dfTextField;
	private JTextField dureTextField;

	private JTextField etudiantTextField;
	private JTextField encadrant1TextField;
	private JTextField encadrant2TextField;
	private JTextField entrepriseTextField;
	private JTextField laboTextField;

	private JComboBox typebox;
	private JLabel OperatLabel;
	private JLabel titreLabel;
	private JLabel idProjetLabel;

	private JLabel DateFLabel;

	private JLabel dureeLabel;

	private JLabel typeLabel;

	private JLabel etudiantLabel;

	private JLabel encadrant1;

	private JLabel encadrant2;

	private JLabel entrepriseLabel;
	private JLabel laboratoireLabel;
	private JLabel DateDLabel;
	private JButton precedentBtn;
	private JButton ajouterBtn;
	private JButton modifierBtn;
	private JButton modifiertoutBtn;
	private JButton supprimerBtn;

	private JButton afficherBtn;
	private ControlleurProjet controlleur;

	public FenetreProjet(ControlleurProjet c) throws HeadlessException {
		super();
		this.initialiser();
		this.dessiner();
		this.action();
		this.controlleur = c;
	}

	private void initialiser() {
		// ImageIcon leftIcon = new ImageIcon("images/tpReseau.png");

		OperatLabel = new JLabel("Operation sur projet");
		precedentBtn = new JButton("precedent");
		titreLabel = new JLabel("Titre:");
		idProjetLabel = new JLabel("id de projet:");
		DateDLabel = new JLabel("Date de Debut:");
		DateFLabel = new JLabel("Date de fin:");
		dureeLabel = new JLabel("Durée:");
		typeLabel = new JLabel("Type:");
		etudiantLabel = new JLabel("Etudiant:");
		encadrant1 = new JLabel("Professeur encadrant 1:");
		encadrant2 = new JLabel("Professeur encadrant 2:");
		entrepriseLabel = new JLabel("Entreprise:");
		laboratoireLabel = new JLabel("Laboratoire:");

		ddTextField = new JTextField();

		idtextField = new JTextField();

		titreTextField = new JTextField();

		dfTextField = new JTextField();

		dureTextField = new JTextField();

		etudiantTextField = new JTextField();

		encadrant1TextField = new JTextField();

		encadrant2TextField = new JTextField();

		entrepriseTextField = new JTextField();

		laboTextField = new JTextField();

		typebox = new JComboBox();

		ajouterBtn = new JButton("Ajouter");

		modifierBtn = new JButton("changer deadLine");
		modifiertoutBtn = new JButton("Modifier");

		supprimerBtn = new JButton("Supprimer");

		afficherBtn = new JButton("Afficher");

	}

	private void dessiner() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 190, 2500, 700);
		// setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 255));
		panel.setBounds(0, 39, 1370, 25);
		contentPane.add(panel);

		OperatLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		OperatLabel.setForeground(new Color(255, 255, 255));
		panel.add(OperatLabel);

		precedentBtn.setBackground(new Color(128, 0, 255));
		precedentBtn.setForeground(new Color(255, 255, 255));
		precedentBtn.setBounds(10, 11, 89, 23);
		contentPane.add(precedentBtn);

		titreLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		titreLabel.setBounds(353, 140, 100, 14);
		contentPane.add(titreLabel);

		idProjetLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		idProjetLabel.setBounds(353, 90, 100, 14);
		contentPane.add(idProjetLabel);

		DateDLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		DateDLabel.setBounds(353, 190, 107, 14);
		contentPane.add(DateDLabel);

		DateFLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		DateFLabel.setBounds(353, 258, 100, 14);
		contentPane.add(DateFLabel);

		dureeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		dureeLabel.setBounds(353, 308, 100, 25);
		contentPane.add(dureeLabel);

		typeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		typeLabel.setBounds(353, 356, 100, 25);
		contentPane.add(typeLabel);

		etudiantLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		etudiantLabel.setBounds(353, 411, 100, 14);
		contentPane.add(etudiantLabel);

		encadrant1.setFont(new Font("Tahoma", Font.BOLD, 13));
		encadrant1.setBounds(353, 451, 165, 25);
		contentPane.add(encadrant1);

		encadrant2.setFont(new Font("Tahoma", Font.BOLD, 13));
		encadrant2.setBounds(353, 503, 165, 25);
		contentPane.add(encadrant2);

		entrepriseLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		entrepriseLabel.setBounds(353, 550, 107, 24);
		contentPane.add(entrepriseLabel);

		laboratoireLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		laboratoireLabel.setBounds(353, 596, 107, 14);
		contentPane.add(laboratoireLabel);

		ddTextField.setBounds(592, 188, 137, 20);
		contentPane.add(ddTextField);
		ddTextField.setColumns(10);

		idtextField.setBounds(592, 89, 144, 20);
		contentPane.add(idtextField);
		idtextField.setColumns(10);

		titreTextField.setBounds(592, 139, 144, 20);
		contentPane.add(titreTextField);
		titreTextField.setColumns(10);

		dfTextField.setBounds(592, 244, 137, 20);
		contentPane.add(dfTextField);
		dfTextField.setColumns(10);

		dureTextField.setBounds(592, 312, 137, 20);
		contentPane.add(dureTextField);
		dureTextField.setColumns(10);

		typebox.setModel(new DefaultComboBoxModel(new String[] { "pfa", "pfe", "doctorat" }));
		typebox.setBounds(592, 359, 137, 20);
		contentPane.add(typebox);

		etudiantLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		etudiantLabel.setBounds(353, 411, 100, 14);
		contentPane.add(etudiantLabel);

		encadrant1.setFont(new Font("Tahoma", Font.BOLD, 13));
		encadrant1.setBounds(353, 451, 165, 25);
		contentPane.add(encadrant1);

		encadrant2.setFont(new Font("Tahoma", Font.BOLD, 13));
		encadrant2.setBounds(353, 503, 165, 25);
		contentPane.add(encadrant2);

		entrepriseLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		entrepriseLabel.setBounds(353, 550, 107, 24);
		contentPane.add(entrepriseLabel);

		laboratoireLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		laboratoireLabel.setBounds(353, 596, 107, 14);
		contentPane.add(laboratoireLabel);

		etudiantTextField.setBounds(592, 410, 140, 20);
		contentPane.add(etudiantTextField);
		etudiantTextField.setColumns(10);

		encadrant1TextField.setBounds(592, 454, 137, 20);
		contentPane.add(encadrant1TextField);
		encadrant1TextField.setColumns(10);

		encadrant2TextField.setBounds(592, 506, 137, 20);
		contentPane.add(encadrant2TextField);
		encadrant2TextField.setColumns(10);

		entrepriseTextField.setBounds(592, 554, 137, 20);
		contentPane.add(entrepriseTextField);
		entrepriseTextField.setColumns(10);

		laboTextField.setBounds(592, 595, 137, 20);
		contentPane.add(laboTextField);
		laboTextField.setColumns(10);

		ajouterBtn.setBounds(957, 287, 137, 23);
		contentPane.add(ajouterBtn);

		modifierBtn.setBounds(957, 359, 137, 23);
		contentPane.add(modifierBtn);

		modifiertoutBtn.setBounds(957, 431, 137, 23);
		contentPane.add(modifiertoutBtn);

		supprimerBtn.setBounds(957, 488, 137, 23);
		contentPane.add(supprimerBtn);

		afficherBtn.setBounds(957, 550, 137, 23);
		contentPane.add(afficherBtn);

	}

	public void action() {

		ajouterBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Projet projet = new Projet(idtextField.getText(), titreTextField.getText(),

						dfTextField.getText(), ddTextField.getText(), dureTextField.getText(),
						projetType.valueOf(typebox.getSelectedItem().toString()),

						encadrant1TextField.getText(), encadrant2TextField.getText(), etudiantTextField.getText(),
						laboTextField.getText(), entrepriseTextField.getText());

				if (controlleur.ajouter(projet)) {
					JOptionPane.showMessageDialog(ajouterBtn, "Ajout avec succes");
				}

				else {
					JOptionPane.showMessageDialog(ajouterBtn, "Projet existe deja");
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

				if (controlleur.supprimer(titreTextField.getText())) {
					JOptionPane.showMessageDialog(supprimerBtn, "Suppression avec succes");
				} else {
					JOptionPane.showMessageDialog(supprimerBtn, "Projet n'existe pas");
				}
			}

		});
		modifierBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (controlleur.modifier(titreTextField.getText(), dfTextField.getText())) {
					JOptionPane.showMessageDialog(modifierBtn, "Modification avec succes");
				} else {
					JOptionPane.showMessageDialog(modifierBtn, "Entreprise n'existe pas");
				}

			}

		});
		modifiertoutBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (controlleur.modifierTout(idtextField.getText(), titreTextField.getText(),

						dfTextField.getText(), ddTextField.getText(), dureTextField.getText(),
						typebox.getSelectedItem().toString(),

						encadrant1TextField.getText(), encadrant2TextField.getText(), etudiantTextField.getText(),
						laboTextField.getText(), entrepriseTextField.getText())) {
					JOptionPane.showMessageDialog(modifierBtn, "Modification avec succes");
				} else {
					JOptionPane.showMessageDialog(modifierBtn, "Entreprise n'existe pas");
				}

			}

		});
		precedentBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				controlleurAdministrateur admin = new controlleurAdministrateur();
				try {
					admin.demmarrerApplication();
				} catch (HeadlessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});

	}

}
