package Presentation;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Gestionnaire.GestionnaireProjet;
import Gestionnaire.TableModelProjet;
import Metier.Projet;
import Persistance.DaoProjet;

public class ControlleurProjet {
	private FenetreProjet fenetreProj;
	private Projet projet;
	private GestionnaireProjet gestProj;

	public ControlleurProjet() {
		super();
		gestProj = new GestionnaireProjet();
	}

	public void demmarrerApplication() {
		this.fenetreProj = new FenetreProjet(this);
		this.fenetreProj.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.fenetreProj.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.fenetreProj.setVisible(true);
	}

	public boolean ajouter(Projet projet) {
		this.fenetreProj.setVisible(true);

		if (gestProj.add(projet.getIdProjet(), projet.getTitreProjet(), projet.getDatefinProjet(),
				projet.getDatedebutProjet(), projet.getDuréeProjet(), (projet.getProjetType()).toString(),
				projet.getIdEncadrant1(), projet.getIdEncadrant2(), projet.getIdEtudiant(), projet.getRaisonSocial(),
				projet.getIdLaboratoire())) {
			System.out.println("eeeeeeeeeeeeeee");
			return true;
		} else
			return false;

	}

	public void affichertout() {
		ArrayList<Projet> projets = new ArrayList<Projet>();
		DaoProjet projetDao = new DaoProjet();
		projets = projetDao.readProjet();
		TableModelProjet modele = new TableModelProjet(projets);
		JFrame fenetre = new JFrame();
		JTable table = new JTable(modele);
		JScrollPane sp = new JScrollPane(table);
		// Si on veut définir la taille de la zone d’affichage :
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		fenetre.setExtendedState(JFrame.MAXIMIZED_BOTH);
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fenetre.add(sp);
		fenetre.show();
	}

	public boolean supprimer(String titre) {
		if (gestProj.delete(titre))
			return true;
		return false;

	}

	public boolean modifier(String titre, String dateFin) {
		if (gestProj.updateDedline(titre, dateFin))
			return true;
		return false;
	}

	public boolean modifierTout(String idProjet, String titreProjet, String datefinProjet, String datedebutProjet,
			String duréeProjet, String projetType, String idEncadrant1, String idEncadrant2, String idEtudiant,
			String raisonSocial, String idLaboratoire) {
		if (gestProj.update(idProjet, titreProjet, datefinProjet, datedebutProjet, duréeProjet, projetType,
				idEncadrant1, idEncadrant2, idEtudiant, raisonSocial, idLaboratoire))
			return true;
		return false;
	}
}
