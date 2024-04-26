package Presentation;

import java.awt.EventQueue;
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

public class professeurfr2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField PRENOM;
	private JTextField NOM;
	private JTextField Num_de_somme;
	private JTextField Grade;
	private JPasswordField passwordField;
	private JButton modifierButton;
	private JButton ArrchiverButton;
	private Controleurprf controlleur;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					professeurfr2 frame = new professeurfr2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public professeurfr2(Controleurprf c) throws HeadlessException {
		super();
//				this.initialiser();
//				this.dessiner();
//				this.action();
		this.controlleur = c;
	}

	public professeurfr2(JTextField pRENOM, JTextField nOM, JTextField num_de_somme, JTextField grade,
			JPasswordField passwordField, Controleurprf controlleur) throws HeadlessException {
		super();
		PRENOM = pRENOM;
		NOM = nOM;
		Num_de_somme = num_de_somme;
		Grade = grade;
		this.passwordField = passwordField;
		this.controlleur = controlleur;
	}

	public professeurfr2() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\SALMA\\Downloads\\study_avatar_man_teacher_professor_school_back_to_education_icon_219898.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 190, 2500, 597);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewPROF = new JLabel("PROFESSEUR");
		lblNewPROF.setFont(new Font("Times New Roman", Font.PLAIN, 42));
		lblNewPROF.setBounds(502, 52, 325, 50);

		contentPane.add(lblNewPROF);

		JLabel lblName = new JLabel("PRENOM");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(58, 152, 130, 20);
		contentPane.add(lblName);

		JLabel lblNewLabel = new JLabel("NOM");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(58, 243, 130, 20);
		contentPane.add(lblNewLabel);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(502, 151, 130, 20);
		contentPane.add(lblPassword);

		JLabel lbNumdesomme = new JLabel("Num de somme");
		lbNumdesomme.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbNumdesomme.setBounds(502, 245, 130, 20);
		contentPane.add(lbNumdesomme);

		JLabel lbGRADE = new JLabel("Grade");
		lbGRADE.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbGRADE.setBounds(58, 300, 130, 20);
		contentPane.add(lbGRADE);

		JLabel lbfonctionnalite = new JLabel("fonctionnalite");
		lbfonctionnalite.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbfonctionnalite.setBounds(58, 380, 130, 20);
		contentPane.add(lbfonctionnalite);

		JLabel lbEtat = new JLabel("ETAT");
		lbEtat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbEtat.setBounds(950, 151, 130, 20);
		contentPane.add(lbEtat);

		JLabel lbEmail = new JLabel("EMAIL");
		lbEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbEmail.setBounds(502, 300, 130, 20);
		contentPane.add(lbEmail);

		JLabel lbDepartpr = new JLabel("departement");
		lbDepartpr.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbDepartpr.setBounds(502, 380, 130, 20);
		contentPane.add(lbDepartpr);

		PRENOM = new JTextField();
		PRENOM.setFont(new Font("Tahoma", Font.PLAIN, 32));
		PRENOM.setBounds(214, 151, 220, 40);
		contentPane.add(PRENOM);
		PRENOM.setColumns(10);

		NOM = new JTextField();
		NOM.setFont(new Font("Tahoma", Font.PLAIN, 32));
		NOM.setBounds(214, 235, 220, 40);
		contentPane.add(NOM);
		NOM.setColumns(10);

		Num_de_somme = new JTextField();
		Num_de_somme.setFont(new Font("Tahoma", Font.PLAIN, 32));
		Num_de_somme.setBounds(702, 235, 220, 40);
		contentPane.add(Num_de_somme);
		Num_de_somme.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		passwordField.setBounds(702, 151, 220, 40);

		Grade = new JTextField();
		Grade.setFont(new Font("Tahoma", Font.PLAIN, 32));
		Grade.setBounds(214, 300, 220, 40);
		contentPane.add(Grade);
		Grade.setColumns(10);

		JTextField fonctionnalite = new JTextField();
		fonctionnalite.setFont(new Font("Tahoma", Font.PLAIN, 32));
		fonctionnalite.setBounds(214, 380, 220, 40);
		contentPane.add(fonctionnalite);
		fonctionnalite.setColumns(10);

		JTextField Etat = new JTextField();
		Etat.setFont(new Font("Tahoma", Font.PLAIN, 32));
		Etat.setBounds(1020, 151, 220, 40);
		contentPane.add(Etat);
		Etat.setColumns(10);

		JTextField Email = new JTextField();
		Email.setFont(new Font("Tahoma", Font.PLAIN, 32));
		Email.setBounds(702, 300, 220, 40);
		contentPane.add(Email);
		Email.setColumns(10);

		JTextField departpr = new JTextField();
		departpr.setFont(new Font("Tahoma", Font.PLAIN, 32));
		departpr.setBounds(702, 380, 220, 40);
		contentPane.add(departpr);
		departpr.setColumns(10);

		contentPane.add(passwordField);
		modifierButton = new JButton("Modifier");

		ArrchiverButton = new JButton("Archiver");

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

		modifierButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		modifierButton.setBounds(200, 447, 259, 74);
		ArrchiverButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		ArrchiverButton.setBounds(900, 447, 259, 74);

		contentPane.add(modifierButton);
		contentPane.add(ArrchiverButton);

	}

}