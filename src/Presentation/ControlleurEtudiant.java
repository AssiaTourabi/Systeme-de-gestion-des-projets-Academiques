package Presentation;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Gestionnaire.EtudiantGestionnaire;
import Gestionnaire.TabeleModelEtudiant;
import Metier.Entreprise;
import Metier.Etudiant;
import Persistance.DaoEtudiant;

public class ControlleurEtudiant {

	private FenetreEtudiant fenetreEtu;
	private Entreprise entreprise;
	private EtudiantGestionnaire etudGes;

	public ControlleurEtudiant() {
		super();
		etudGes = new EtudiantGestionnaire();
	}

	public void demmarrerApplication() {
		this.fenetreEtu = new FenetreEtudiant(this);
		this.fenetreEtu.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.fenetreEtu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.fenetreEtu.setVisible(true);
	}

	public boolean ajouter(Etudiant etudiant) throws ClassNotFoundException {
		// this.profil = new Profil();

		if (etudGes.insertEtudiant(etudiant))
			return true;
		return false;

	}

	public void affichertout() {
		ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
		DaoEtudiant entre = new DaoEtudiant();
		etudiants = entre.getEtudiants();
		TabeleModelEtudiant modele = new TabeleModelEtudiant(etudiants);
		JFrame fenetre = new JFrame();
		JTable table = new JTable(modele);
		JScrollPane sp = new JScrollPane(table);
		fenetre.setExtendedState(JFrame.MAXIMIZED_BOTH);
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// Si on veut définir la taille de la zone d’affichage :
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		fenetre.add(sp);
		fenetre.show();
	}

	public boolean supprimer(String code) {
		if (etudGes.deleteEtudiant(code))
			return true;
		else
			return false;

	}

	public boolean modifier(String idE, String nomE, String prenomE, String niveauE, String filiereE, String emailE,
			String cneE, String motPasse) {
		if (etudGes.updateEtudiant(idE, nomE, prenomE, niveauE, filiereE, emailE, cneE, motPasse))
			return true;
		return false;

	}

}
