package Presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FeneteAdmin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jpane;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JLabel titrLabel;
	// private JButton profBtn;
	// private JButton etudBtn;
	// private JButton projetsBtn;

	private controlleurAdministrateur admin;

	// private ControlleurElements controlleur;

	public FeneteAdmin(controlleurAdministrateur c) throws HeadlessException {
		super();
		this.initialiser();
		this.dessiner();
		this.action();
		this.admin = c;
	}

	private void initialiser() {
		// ImageIcon leftIcon = new ImageIcon("images/tpReseau.png");
		titrLabel = new JLabel(" Administrateur : ");
		titrLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 40));
//titrLabel.setVerticalAlignment(JLabel.TOP);
		// titrLabel.setPreferredSize(new Dimension(250, 100));
		// titrLabel.setAlignmentX(CENTER_ALIGNMENT);
		jpane = new JPanel();
		btn1 = new JButton("Professeurs");
		btn2 = new JButton("Etudiants");
		btn3 = new JButton("Projets");
		btn4 = new JButton("Departemnts");
		btn5 = new JButton("Filieres");
		btn6 = new JButton("Statistiques");
		btn7 = new JButton("Laboratoires");
		btn8 = new JButton("Entreprises");
		btn9 = new JButton("Etapes");

	}

	private void dessiner() {

		setTitle("Administrateur :");
		setBackground(new Color(128, 128, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		titrLabel.setForeground(new Color(255, 255, 255));
		titrLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 40));
		titrLabel.setBounds(100, 31, 600, 50);
		jpane.add(titrLabel);

		jpane.setBackground(new Color(255, 255, 255));
		jpane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(jpane);
		jpane.setLayout(null);

		btn1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn1.setForeground(new Color(255, 255, 255));
		btn1.setBackground(new Color(149, 131, 254));
		btn1.setBounds(600, 250, 400, 53);
		jpane.add(btn1);

		btn2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn2.setForeground(new Color(255, 255, 255));
		btn2.setBackground(new Color(149, 131, 254));
		btn2.setBounds(600, 300, 400, 53);
		jpane.add(btn2);

		btn3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn3.setForeground(new Color(255, 255, 255));
		btn3.setBackground(new Color(149, 131, 254));
		btn3.setBounds(600, 350, 400, 53);
		jpane.add(btn3);

		btn4.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn4.setForeground(new Color(255, 255, 255));
		btn4.setBackground(new Color(149, 131, 254));
		btn4.setBounds(600, 400, 400, 53);
		jpane.add(btn4);

		btn5.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn5.setForeground(new Color(255, 255, 255));
		btn5.setBackground(new Color(149, 131, 254));
		btn5.setBounds(600, 450, 400, 53);
		jpane.add(btn5);

		btn6.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn6.setForeground(new Color(255, 255, 255));
		btn6.setBackground(new Color(149, 131, 254));
		btn6.setBounds(600, 500, 400, 53);
		jpane.add(btn6);

		btn7.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn7.setForeground(new Color(255, 255, 255));
		btn7.setBackground(new Color(149, 131, 254));
		btn7.setBounds(600, 550, 400, 53);
		jpane.add(btn7);

		btn8.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn8.setForeground(new Color(255, 255, 255));
		btn8.setBackground(new Color(149, 131, 254));
		btn8.setBounds(600, 600, 400, 53);
		jpane.add(btn8);

		btn9.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn9.setForeground(new Color(255, 255, 255));
		btn9.setBackground(new Color(149, 131, 254));
		btn9.setBounds(600, 650, 400, 53);
		jpane.add(btn9);

		this.setPreferredSize(new Dimension(1400, 1000));
		this.setBackground(new Color(128, 128, 128));
		this.getContentPane().setBackground(new Color(149, 131, 254));
		this.setBackground(new Color(255, 255, 255));
		this.setBounds(450, 190, 2500, 700);
		// frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);

	}

	public void action() {
		btn5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				filiereControleur controlleurf = new filiereControleur();
				try {
					controlleurf.demmarrerApplication();
				} catch (HeadlessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				;
			}
		}

		);

		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					ControlleurProjet controlleurPr = new ControlleurProjet();
					controlleurPr.demmarrerApplication();
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			};

		}

		);

		btn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ControlleurDepart departControleur = new ControlleurDepart();
				try {
					departControleur.demmarrerApplication();
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			};

		}

		);

		btn7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ControlleurLabo Controleur = new ControlleurLabo();
				try {
					Controleur.demmarrerApplication();
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			};

		}

		);

		btn6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FenetreStatistique fenetre = new FenetreStatistique();

			};

		}

		);

		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Controleurprf fenetre = new Controleurprf();
				fenetre.demmarrerApplication();

			};

		}

		);

		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ControlleurEtudiant controlleurEntr = new ControlleurEtudiant();

				controlleurEntr.demmarrerApplication();
			};

		}

		);

		btn8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ControlleurEntreprise controlleurEntr = new ControlleurEntreprise();

				controlleurEntr.demmarrerApplication();
			};

		}

		);

		btn9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ControlleurEtape controlleur = new ControlleurEtape();
				try {
					controlleur.demmarrerApplication();
				} catch (HeadlessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			};

		}

		);

	}

}
