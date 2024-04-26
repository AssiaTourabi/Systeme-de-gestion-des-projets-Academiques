package Presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import Gestionnaire.EtapeGestionnaires;
import Gestionnaire.GestinAffEt;
import Gestionnaire.GestionProfesseur;
import Gestionnaire.Gestion_Labo;
import Metier.Etudiant;
import Metier.Projet;
import Metier.professeur;

public class FenetreProjetDet extends JFrame {

	private JPanel contentPane;
	private JLabel ProjetTitre;

	private JLabel titre;

	private JLabel DateDebut;

	private JLabel projetDD;

	private JLabel DateFin;

	private JLabel ProjetDF;

	private JLabel duree;

	private JLabel ProjetDuree;

	private JLabel profEncadrant;

	private JLabel ProjetEnca = new JLabel("ProjetEnca");

	private JLabel lieu = new JLabel("Lieu");

	private JLabel ProjetLieu;
	private JLabel VotreProjetLabel;
	private JTextPane EncadrtextPane;
	private JTextPane LieutextPane;
	private JButton precedentBtn;

	private JButton livrBtn;

	private JLabel etapeLabel;

	private JLabel ProjetEtape;

	private JTextPane EtapeText;
	private ControlleurProjetDet controlleur;

	public FenetreProjetDet(ControlleurProjetDet c, Projet projet, Etudiant etudiant) {
		super();
		this.initialiser(projet);
		this.dessiner();
		this.action(etudiant);
		this.controlleur = c;
	}

	private void initialiser(Projet projet) {
		// ImageIcon leftIcon = new ImageIcon("images/tpReseau.png");
		EtapeGestionnaires gesEt = new EtapeGestionnaires();
		GestinAffEt gesA = new GestinAffEt();
		professeur prof1 = new professeur();
		professeur prof2 = new professeur();
		GestionProfesseur gesProf = new GestionProfesseur();
		prof1 = gesProf.readProf(projet.getIdEncadrant1());
		prof2 = gesProf.readProf(projet.getIdEncadrant2());
		Gestion_Labo geslabo = new Gestion_Labo();

		ProjetTitre = new JLabel(projet.getTitreProjet());

		titre = new JLabel("Titre:");

		DateDebut = new JLabel("Date de Debut:");

		projetDD = new JLabel(projet.getDatedebutProjet());

		DateFin = new JLabel("Date de Fin:");

		ProjetDF = new JLabel(projet.getDatefinProjet());

		duree = new JLabel("Durée");

		ProjetDuree = new JLabel(projet.getDuréeProjet());
		profEncadrant = new JLabel("Prof encadrant");

		EncadrtextPane = new JTextPane();
		if (projet.getIdEncadrant2().equals(null) || projet.getIdEncadrant2().equals("")) {
			EncadrtextPane.setText(prof1.getNom_prof() + " " + prof1.getPrenm_prof());
		}

		else

			EncadrtextPane.setText(prof1.getNom_prof() + "  " + prof1.getPrenm_prof() + " \t et \t"
					+ prof2.getNom_prof() + "/t" + prof2.getPrenm_prof());

		System.out.println(projet.getIdEncadrant2());
		lieu = new JLabel("Lieu");

		LieutextPane = new JTextPane();
		if (projet.getIdLaboratoire().equals(null) || projet.getIdLaboratoire().equals("")) {
			EncadrtextPane.setText("Entreprise:" + projet.getRaisonSocial());
		}

		else if (projet.getRaisonSocial().equals(null) || projet.getRaisonSocial().equals(""))
			LieutextPane.setText("Laboratoire:" + geslabo.getNom(projet.getIdLaboratoire()));
		else
			LieutextPane.setText("Laboratoire:" + geslabo.getNom(projet.getIdLaboratoire()) + "/" + "Entreprise:"
					+ projet.getRaisonSocial());

		VotreProjetLabel = new JLabel("Votre Projet");

		precedentBtn = new JButton("precedent");

		livrBtn = new JButton("");

		etapeLabel = new JLabel("Etapes");

		String idEtape = gesA.getEtape(projet.getIdProjet());
		String etape = gesEt.readEtap(idEtape);

		/* ProjetEtape = new JLabel(etape); */
		EtapeText = new JTextPane();

		EtapeText.setText(etape);

	}

	private void dessiner() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 563, 460);
		setBounds(450, 190, 2500, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		ProjetTitre.setBackground(Color.BLUE);
		ProjetTitre.setBounds(478, 157, 118, 14);
		contentPane.add(ProjetTitre);

		titre.setForeground(new Color(128, 0, 255));
		titre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		titre.setBounds(335, 155, 61, 14);
		contentPane.add(titre);

		DateDebut.setForeground(new Color(128, 0, 255));
		DateDebut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		DateDebut.setBounds(332, 203, 108, 14);
		contentPane.add(DateDebut);

		projetDD.setBounds(478, 205, 266, 25);
		contentPane.add(projetDD);

		DateFin.setForeground(new Color(128, 0, 255));
		DateFin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		DateFin.setBounds(643, 201, 108, 14);
		contentPane.add(DateFin);

		ProjetDF.setBounds(819, 205, 266, 25);
		contentPane.add(ProjetDF);

		duree.setForeground(new Color(128, 0, 255));
		duree.setFont(new Font("Tahoma", Font.PLAIN, 14));
		duree.setBounds(335, 249, 46, 14);
		contentPane.add(duree);

		ProjetDuree.setBounds(478, 251, 266, 25);
		contentPane.add(ProjetDuree);

		profEncadrant.setForeground(new Color(128, 0, 255));
		profEncadrant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		profEncadrant.setBounds(643, 157, 108, 14);
		contentPane.add(profEncadrant);

		EncadrtextPane.setBounds(785, 157, 292, 20);
		contentPane.add(EncadrtextPane);

		lieu.setForeground(new Color(128, 0, 255));
		lieu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lieu.setBounds(643, 249, 46, 14);
		contentPane.add(lieu);

		LieutextPane.setBounds(747, 243, 330, 20);
		contentPane.add(LieutextPane);

		VotreProjetLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		VotreProjetLabel.setForeground(new Color(128, 0, 255));
		VotreProjetLabel.setBackground(new Color(128, 0, 255));
		VotreProjetLabel.setBounds(524, 22, 148, 25);
		contentPane.add(VotreProjetLabel);

		precedentBtn.setForeground(new Color(255, 255, 255));
		precedentBtn.setBackground(new Color(128, 0, 255));
		precedentBtn.setBounds(10, 27, 89, 23);
		contentPane.add(precedentBtn);

		livrBtn = new JButton("");
		livrBtn.setBackground(new Color(255, 255, 255));
		livrBtn.setIcon(new ImageIcon("C:\\Users\\oki\\Desktop\\File_Add.png"));
		livrBtn.setBounds(557, 94, 46, 52);
		contentPane.add(livrBtn);

		etapeLabel.setForeground(new Color(128, 0, 255));
		etapeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		etapeLabel.setBounds(582, 284, 46, 14);
		contentPane.add(etapeLabel);

		EtapeText.setBounds(62, 318, 1100, 248);

		contentPane.add(EtapeText);

	}

	public void action(Etudiant etudiant) {

		precedentBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ControlleurProjetButtons controlleurB = new ControlleurProjetButtons();

				controlleurB.demmarrerApplication(etudiant);
			}

		});

		livrBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int option = fileChooser.showOpenDialog(contentPane);
				if (option == JFileChooser.APPROVE_OPTION) {
					String filePath = fileChooser.getSelectedFile().getAbsolutePath();
					// Faites quelque chose avec le chemin du fichier sélectionné
					System.out.println("Chemin du fichier sélectionné : " + filePath);
				}
			}
		});

	}

}
