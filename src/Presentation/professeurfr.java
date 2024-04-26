package Presentation;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Metier.professeur;

public class professeurfr extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField PRENOM;
	private JTextField NOM;
	private JTextField Num_de_somme;
	private JTextField Grade;
	private JPasswordField passwordField;
	private JTextField Etat;
	private JTextField fonctionnalite;

	private JButton btnNewButton;
	private JButton supprimerButton;
	private JButton modifierButton;
	private JButton ArrchiverButton;
	private Controleurprf controlleur;
	JLabel lblNewPROF = new JLabel("PROFESSEUR");

	JLabel lblName = new JLabel("PRENOM");

	JLabel lblNewLabel = new JLabel("NOM");

	JLabel lblPassword = new JLabel("Password");

	JLabel lbNumdesomme = new JLabel("Num de somme");

	JLabel lbGRADE = new JLabel("Grade");

	JLabel lbfonctionnalite = new JLabel("fonctionnalite");

	JLabel lbEtat = new JLabel("ETAT");

	JLabel lbEmail = new JLabel("EMAIL");

	JLabel lbDepartpr = new JLabel("departement");

	JTextField Email = new JTextField();

	JTextField departpr = new JTextField();

	/**
	 * Create the frame.
	 */
	public professeurfr(Controleurprf c) throws HeadlessException {
		super();
		this.initialiser();
		this.dessiner();
		this.action();
		this.controlleur = c;
	}

	public void initialiser() {

		// setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\SALMA\\Downloads\\study_avatar_man_teacher_professor_school_back_to_education_icon_219898.png"));

		contentPane = new JPanel();
		JLabel lblNewPROF = new JLabel("PROFESSEUR");
		contentPane.add(lblNewPROF);
		JLabel lblName = new JLabel("PRENOM");
		JLabel lblNewLabel = new JLabel("NOM");
		JLabel lblPassword = new JLabel("Password");
		JLabel lbNumdesomme = new JLabel("Num de somme");
		JLabel lbGRADE = new JLabel("Grade");

		JLabel lbfonctionnalite = new JLabel("fonctionnalite");
		JLabel lbEtat = new JLabel("ETAT");
		JLabel lbEmail = new JLabel("EMAIL");
		JLabel lbDepartpr = new JLabel("departement");
		PRENOM = new JTextField();
		NOM = new JTextField();
		Num_de_somme = new JTextField();
		passwordField = new JPasswordField();
		Grade = new JTextField();
		fonctionnalite = new JTextField();
		Etat = new JTextField();
		JTextField Email = new JTextField();
		JTextField departpr = new JTextField();
		supprimerButton = new JButton("Supprimer");
		modifierButton = new JButton("Modifier");
		btnNewButton = new JButton("AJOUTER");
		ArrchiverButton = new JButton("Archiver");

	}

	public void dessiner() {

		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\SALMA\\Downloads\\study_avatar_man_teacher_professor_school_back_to_education_icon_219898.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 190, 2500, 597);
		setResizable(false);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewPROF.setFont(new Font("Times New Roman", Font.PLAIN, 42));
		lblNewPROF.setBounds(502, 52, 325, 50);

		contentPane.add(lblNewPROF);

		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(58, 152, 130, 20);
		contentPane.add(lblName);

		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(58, 243, 130, 20);
		contentPane.add(lblNewLabel);

		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(502, 151, 130, 20);
		contentPane.add(lblPassword);

		lbNumdesomme.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbNumdesomme.setBounds(502, 245, 130, 20);
		contentPane.add(lbNumdesomme);

		lbGRADE.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbGRADE.setBounds(58, 300, 130, 20);
		contentPane.add(lbGRADE);

		lbfonctionnalite.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbfonctionnalite.setBounds(58, 380, 130, 20);
		contentPane.add(lbfonctionnalite);

		lbEtat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbEtat.setBounds(950, 151, 130, 20);
		contentPane.add(lbEtat);

		lbEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbEmail.setBounds(502, 300, 130, 20);
		contentPane.add(lbEmail);

		lbDepartpr.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbDepartpr.setBounds(502, 380, 130, 20);
		contentPane.add(lbDepartpr);

		PRENOM.setFont(new Font("Tahoma", Font.PLAIN, 32));
		PRENOM.setBounds(214, 151, 220, 40);
		contentPane.add(PRENOM);
		PRENOM.setColumns(10);

		NOM.setFont(new Font("Tahoma", Font.PLAIN, 32));
		NOM.setBounds(214, 235, 220, 40);
		contentPane.add(NOM);
		NOM.setColumns(10);

		Num_de_somme.setFont(new Font("Tahoma", Font.PLAIN, 32));
		Num_de_somme.setBounds(702, 235, 220, 40);
		contentPane.add(Num_de_somme);
		Num_de_somme.setColumns(10);

		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		passwordField.setBounds(702, 151, 220, 40);

		Grade.setFont(new Font("Tahoma", Font.PLAIN, 32));
		Grade.setBounds(214, 300, 220, 40);
		contentPane.add(Grade);
		Grade.setColumns(10);

		fonctionnalite.setFont(new Font("Tahoma", Font.PLAIN, 32));
		fonctionnalite.setBounds(214, 380, 220, 40);
		contentPane.add(fonctionnalite);
		fonctionnalite.setColumns(10);

		Etat.setFont(new Font("Tahoma", Font.PLAIN, 32));
		Etat.setBounds(1020, 151, 220, 40);
		contentPane.add(Etat);
		Etat.setColumns(10);

		Email.setFont(new Font("Tahoma", Font.PLAIN, 32));
		Email.setBounds(702, 300, 220, 40);
		contentPane.add(Email);
		Email.setColumns(10);

		departpr.setFont(new Font("Tahoma", Font.PLAIN, 32));
		departpr.setBounds(702, 380, 220, 40);
		contentPane.add(departpr);
		departpr.setColumns(10);

		contentPane.add(passwordField);
		supprimerButton = new JButton("Supprimer");
		modifierButton = new JButton("Modifier");
		btnNewButton = new JButton("AJOUTER");
		ArrchiverButton = new JButton("Archiver");

		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setBounds(100, 447, 259, 74);
		supprimerButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		supprimerButton.setBounds(400, 447, 259, 74);
		modifierButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		modifierButton.setBounds(700, 447, 259, 74);
		ArrchiverButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		ArrchiverButton.setBounds(1000, 447, 259, 74);

		contentPane.add(btnNewButton);
		contentPane.add(supprimerButton);
		contentPane.add(modifierButton);
		contentPane.add(ArrchiverButton);
	}

	public void action() {

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				professeur p = new professeur(NOM.getText(), PRENOM.getText(), departpr.getText(), Email.getText(),
						Grade.getText(), Etat.getText(), Num_de_somme.getText(), passwordField.getText(),
						fonctionnalite.getText());
				try {
					controlleur.AjouterPr(p);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		modifierButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				professeur p = new professeur(NOM.getText(), PRENOM.getText(), departpr.getText(), Email.getText(),
						Grade.getText(), Etat.getText(), Num_de_somme.getText(), passwordField.getText(),
						fonctionnalite.getText());
				try {
					controlleur.modifierpr(passwordField.getText(), p.getN_somme());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		supprimerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				professeur p = new professeur(NOM.getText(), PRENOM.getText(), departpr.getText(), Email.getText(),
						Grade.getText(), Etat.getText(), Num_de_somme.getText(), passwordField.getText(),
						fonctionnalite.getText());
				try {
					controlleur.supprimerpr(p);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		ArrchiverButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				professeur p = new professeur(NOM.getText(), PRENOM.getText(), departpr.getText(), Email.getText(),
						Grade.getText(), Etat.getText(), Num_de_somme.getText(), passwordField.getText(),
						fonctionnalite.getText());
				try {
					controlleur.archiver(p);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

	}
}
