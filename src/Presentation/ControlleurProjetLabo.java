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

public class ControlleurProjetLabo {
	private FenetreProjetLabo fenetreProj;
	private Projet projet;

	private GestionnaireProjet gestProj;

	public ControlleurProjetLabo() {
		super();
	}

	public void demmarrerApplication() {
		this.fenetreProj = new FenetreProjetLabo(this);
		this.fenetreProj.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.fenetreProj.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.fenetreProj.setVisible(true);
	}

	public boolean ajouter(Projet projet) {
		this.fenetreProj.setVisible(false);

		if (gestProj.add(projet.getIdProjet(), projet.getTitreProjet(), projet.getDatefinProjet(),
				projet.getDatedebutProjet(), projet.getDuréeProjet(), (projet.getProjetType()).toString(),
				projet.getIdEncadrant1(), projet.getIdEncadrant2(), projet.getIdEtudiant(), projet.getRaisonSocial(),
				projet.getIdLaboratoire()))
			return true;
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
}
