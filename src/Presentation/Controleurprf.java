package Presentation;

import java.sql.SQLException;

import javax.swing.JFrame;

import Gestionnaire.GestionProfesseur;
import Metier.professeur;

public class Controleurprf {
	private professeurfr profframe;
	private GestionProfesseur gestprf;

	public Controleurprf() {
		super();
	}

	public void demmarrerApplication() {
		this.profframe = new professeurfr(this);
		this.profframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.profframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.profframe.setVisible(true);
	}

	public void AjouterPr(professeur p) throws SQLException {
		this.gestprf = new GestionProfesseur();
		gestprf.ajouter_Prof(p);
	}

	public void supprimerpr(professeur p) throws SQLException {
		gestprf = new GestionProfesseur();
		gestprf.supprimer_Prof(p);
	}

	public void modifierpr(String Mdp_prof, String Nom_prof) throws SQLException {
		this.gestprf = new GestionProfesseur();

		gestprf.modifier(Mdp_prof, Nom_prof);

	}

	public void archiver(professeur p) {
		gestprf = new GestionProfesseur();
		gestprf.archiver_Prof(p);
	}

}
