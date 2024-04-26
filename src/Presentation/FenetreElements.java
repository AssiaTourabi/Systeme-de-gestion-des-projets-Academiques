package Presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FenetreElements extends JFrame {

	private JPanel jpane;
	private JLabel titrLabel;
	private JButton profBtn;
	private JButton etudBtn;
	private JButton projetsBtn;

	private ControlleurElements controlleur;

	public FenetreElements(ControlleurElements c) throws HeadlessException {
		super();
		this.initialiser();
		this.dessiner();
		this.action();
		this.controlleur = c;
	}

	private void initialiser() {
		// ImageIcon leftIcon = new ImageIcon("images/tpReseau.png");

		jpane = new JPanel();
		profBtn = new JButton("Professeur");
		etudBtn = new JButton("Etudiants");
		projetsBtn = new JButton("Projet fin d'etudes");
		titrLabel = new JLabel("Gérer");

	}

	private void dessiner() {

		setTitle("Gerer");
		setBackground(new Color(98, 80, 197));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		jpane.setBackground(new Color(255, 255, 255));
		jpane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(jpane);
		jpane.setLayout(null);

		titrLabel.setForeground(new Color(128, 0, 255));
		titrLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		titrLabel.setBounds(10, 31, 424, 14);
		jpane.add(titrLabel);

		profBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		profBtn.setForeground(new Color(255, 255, 255));
		profBtn.setBackground(new Color(128, 0, 255));

		profBtn.setBounds(470, 200, 246, 53);
		jpane.add(profBtn);

		etudBtn.setForeground(new Color(255, 255, 255));
		etudBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		etudBtn.setBackground(new Color(128, 0, 255));
		etudBtn.setBounds(470, 300, 246, 53);
		jpane.add(etudBtn);

		projetsBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		projetsBtn.setForeground(new Color(255, 255, 255));
		projetsBtn.setBackground(new Color(128, 0, 255));
		projetsBtn.setBounds(470, 400, 246, 53);
		jpane.add(projetsBtn);

	}

	public void action() {

		profBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// Controlleur prof

				Controleurprf fenetre = new Controleurprf();
				fenetre.demmarrerApplication();

			}

		});

		etudBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// Controlleur etudiant
				ControlleurEtudiant controlleurEntr = new ControlleurEtudiant();

				controlleurEntr.demmarrerApplication();
			}

		});

		projetsBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// Controlleur projet
				ControlleurProjet controlleurPr = new ControlleurProjet();
				controlleurPr.demmarrerApplication();
			}

		});
	}

}
