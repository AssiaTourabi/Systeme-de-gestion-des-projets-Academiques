package Presentation;

import java.awt.Color;
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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Metier.Entreprise;

public class FenetreEntrepris extends JFrame {

	private JPanel contentPane;

	private JTextField nomTextField;
	private JTextField emailTextField;
	private JTextField teletextField;
	private JTextField adrestextField;
	private JTextField respoTextField;
	private JTextField etudiantTextField;
	private JTextField encadrant1TextField;
	private JTextField encadrant2TextField;
	private JTextField entrepriseTextField;
	private JTextField laboTextField;

	private JLabel OperatLabel;
	private JLabel nomLabel;

	private JLabel teleLabel;

	private JLabel adresLabel;

	private JLabel respoLabel;

	private JLabel emailLabel;
	private JButton precedentBtn;
	private JButton ajouterBtn;
	private JButton modifierBtn;
	private JButton modifierToutBtn;
	private JButton supprimerBtn;

	private JButton afficherBtn;
	private ControlleurEntreprise controlleur;

	public FenetreEntrepris(ControlleurEntreprise c) throws HeadlessException {
		super();
		this.initialiser();
		this.dessiner();
		this.action();
		this.controlleur = c;
	}

	private void initialiser() {
		// ImageIcon leftIcon = new ImageIcon("images/tpReseau.png");
		contentPane = new JPanel();
		OperatLabel = new JLabel("Entreprise");
		precedentBtn = new JButton("precedent");
		nomLabel = new JLabel("Raison social:");

		emailLabel = new JLabel("Email:");
		teleLabel = new JLabel("telephone:");
		adresLabel = new JLabel("adress:");
		respoLabel = new JLabel("Responsable:");

		nomTextField = new JTextField();

		emailTextField = new JTextField();

		teletextField = new JTextField();

		adrestextField = new JTextField();

		respoTextField = new JTextField();

		etudiantTextField = new JTextField();

		encadrant1TextField = new JTextField();

		encadrant2TextField = new JTextField();

		entrepriseTextField = new JTextField();

		laboTextField = new JTextField();

		ajouterBtn = new JButton("Ajouter");

		modifierBtn = new JButton("Modifier");

		supprimerBtn = new JButton("Supprimer");

		afficherBtn = new JButton("Afficher");
		modifierToutBtn = new JButton("Modifier tout");

	}

	private void dessiner() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 190, 2500, 700);
		// setBounds(100, 100, 450, 300);

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

		nomLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		nomLabel.setBounds(353, 140, 46, 14);
		contentPane.add(nomLabel);

		emailLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		emailLabel.setBounds(353, 190, 107, 14);
		contentPane.add(emailLabel);

		teleLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		teleLabel.setBounds(353, 258, 83, 14);
		contentPane.add(teleLabel);

		adresLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		adresLabel.setBounds(353, 308, 46, 25);
		contentPane.add(adresLabel);

		respoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		respoLabel.setBounds(353, 356, 83, 25);
		contentPane.add(respoLabel);

		nomTextField.setBounds(592, 139, 144, 20);
		contentPane.add(nomTextField);
		nomTextField.setColumns(10);

		emailTextField.setBounds(592, 188, 137, 20);
		contentPane.add(emailTextField);
		emailTextField.setColumns(10);

		teletextField.setBounds(592, 244, 137, 20);
		contentPane.add(teletextField);
		teletextField.setColumns(10);

		adrestextField.setBounds(592, 312, 137, 20);
		contentPane.add(adrestextField);
		adrestextField.setColumns(10);

		respoTextField.setBounds(592, 360, 137, 20);
		contentPane.add(respoTextField);
		respoTextField.setColumns(10);

		ajouterBtn.setBounds(957, 100, 137, 23);
		contentPane.add(ajouterBtn);

		modifierBtn.setBounds(957, 172, 137, 23);
		contentPane.add(modifierBtn);

		supprimerBtn.setBounds(957, 253, 137, 23);
		contentPane.add(supprimerBtn);

		afficherBtn.setBounds(957, 318, 137, 23);
		contentPane.add(afficherBtn);

		modifierToutBtn.setBounds(957, 383, 137, 23);
		contentPane.add(modifierToutBtn);

	}

	public void action() {
		ajouterBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Entreprise entreprise = new Entreprise(nomTextField.getText(), respoTextField.getText(),
						adrestextField.getText(), emailTextField.getText(), teletextField.getText());
				if (controlleur.ajouter(entreprise)) {
					JOptionPane.showMessageDialog(ajouterBtn, "Ajout avec succes");
				} else {
					JOptionPane.showMessageDialog(ajouterBtn, "Entreprise existe deja");
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

				if (controlleur.supprimer(nomTextField.getText())) {
					JOptionPane.showMessageDialog(supprimerBtn, "Suppression avec succes");
				} else {
					JOptionPane.showMessageDialog(supprimerBtn, "Entreprise n'existe pas");
				}
			}

		});
		modifierBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (controlleur.modifier(nomTextField.getText(), respoTextField.getText())) {
					JOptionPane.showMessageDialog(modifierBtn, "Modification avec succes");
				} else {
					JOptionPane.showMessageDialog(modifierBtn, "Entreprise n'existe pas");
				}
			}

		});
		modifierToutBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (controlleur.modifierTout(nomTextField.getText(), respoTextField.getText(), adrestextField.getText(),
						emailTextField.getText(), teletextField.getText())) {
					JOptionPane.showMessageDialog(ajouterBtn, "Modification avec succes");
				} else {
					JOptionPane.showMessageDialog(ajouterBtn, "Entreprise n'existe pas ");
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
