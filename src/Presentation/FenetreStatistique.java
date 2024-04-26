package Presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Gestionnaire.EtudiantGestionnaire;
import Gestionnaire.GestionProfesseur;
import Gestionnaire.Gestion_Departement;
import Gestionnaire.Gestion_Filiere;
import Gestionnaire.GestionnaireProjet;

public class FenetreStatistique extends JFrame {

	private JPanel contentPane;
	private JPanel ProfPanel;
	private JPanel Etudiantspanel;
	private JPanel Deppartementpanel;
	private JPanel Filierepanel;
	private JPanel panelProjet;

	private JLabel professerSt;
	private JLabel EtudiantSt;
	private JLabel etudText;
	private JLabel departementSta;
	private JLabel filliereSta;
	private JLabel filiereText;
	private JLabel StatistiqueTitle;
	private JLabel departText;
	private JLabel projetText;
	private JLabel profText;

	private JLabel projetStat;

	public FenetreStatistique() throws HeadlessException {
		this.initialiser();
		this.dessiner();
		this.setVisible(true);

	}

	private void initialiser() {

		GestionProfesseur gesPr = new GestionProfesseur();
		Gestion_Departement gesDe = new Gestion_Departement();
		GestionnaireProjet gesProjet = new GestionnaireProjet();
		EtudiantGestionnaire gesEtud = new EtudiantGestionnaire();
		Gestion_Filiere gesFil = new Gestion_Filiere();

		String numbProf = String.valueOf(gesPr.countProf());
		String numbDepart = String.valueOf(gesDe.countTotalDep());
		String numProj = String.valueOf(gesProjet.numbrOfProj());
		String numEtud = String.valueOf(gesEtud.NumberofStudent());
		String numFil = String.valueOf(gesFil.NumberofFilliere());

		ProfPanel = new JPanel();
		Etudiantspanel = new JPanel();
		Deppartementpanel = new JPanel();
		Filierepanel = new JPanel();
		panelProjet = new JPanel();
		professerSt = new JLabel("Professeur:");
		EtudiantSt = new JLabel("Etudiant:");
		etudText = new JLabel(numEtud);
		departementSta = new JLabel("Departement:");
		filliereSta = new JLabel("Filiere:");
		filiereText = new JLabel(numFil);
		StatistiqueTitle = new JLabel("Statistiques:");
		projetStat = new JLabel("Projet:");

		departText = new JLabel(numbDepart);
		projetText = new JLabel(numProj);

		profText = new JLabel(numbProf);

	}

	private void dessiner() {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 190, 2500, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		ProfPanel.setBackground(new Color(0, 255, 64));
		ProfPanel.setBounds(281, 146, 383, 54);
		contentPane.add(ProfPanel);
		ProfPanel.setLayout(null);

		professerSt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		professerSt.setBounds(24, 11, 99, 32);
		ProfPanel.add(professerSt);

		profText.setFont(new Font("Tahoma", Font.PLAIN, 24));
		profText.setBounds(206, 22, 70, 21);
		ProfPanel.add(profText);

		Etudiantspanel.setBackground(new Color(255, 128, 128));
		Etudiantspanel.setBounds(281, 246, 383, 54);
		contentPane.add(Etudiantspanel);
		Etudiantspanel.setLayout(null);

		EtudiantSt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		EtudiantSt.setBounds(27, 11, 97, 21);
		Etudiantspanel.add(EtudiantSt);

		etudText.setFont(new Font("Tahoma", Font.PLAIN, 24));
		etudText.setBounds(206, 13, 97, 21);
		Etudiantspanel.add(etudText);

		Deppartementpanel.setBackground(new Color(128, 128, 255));
		Deppartementpanel.setBounds(281, 346, 383, 54);
		contentPane.add(Deppartementpanel);
		Deppartementpanel.setLayout(null);

		departementSta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		departementSta.setBounds(34, 11, 129, 32);
		Deppartementpanel.add(departementSta);

		departText.setFont(new Font("Tahoma", Font.PLAIN, 24));
		departText.setBounds(206, 11, 97, 21);
		Deppartementpanel.add(departText);

		Filierepanel.setBackground(new Color(128, 255, 255));
		Filierepanel.setBounds(281, 426, 383, 54);
		contentPane.add(Filierepanel);
		Filierepanel.setLayout(null);

		filliereSta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		filliereSta.setBounds(37, 11, 107, 32);
		Filierepanel.add(filliereSta);

		filiereText.setFont(new Font("Tahoma", Font.PLAIN, 24));
		filiereText.setBounds(204, 22, 97, 21);
		Filierepanel.add(filiereText);

		panelProjet.setBackground(new Color(255, 255, 0));
		panelProjet.setBounds(281, 518, 383, 44);
		contentPane.add(panelProjet);
		panelProjet.setLayout(null);

		projetStat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		projetStat.setBounds(31, 11, 61, 22);
		panelProjet.add(projetStat);

		projetText.setFont(new Font("Tahoma", Font.PLAIN, 24));
		projetText.setBounds(207, 17, 97, 21);
		panelProjet.add(projetText);

		StatistiqueTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
		StatistiqueTitle.setBounds(134, 39, 205, 35);
		contentPane.add(StatistiqueTitle);

	}
}