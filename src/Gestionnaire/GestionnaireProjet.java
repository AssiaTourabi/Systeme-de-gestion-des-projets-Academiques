package Gestionnaire;

import java.sql.SQLException;

import Metier.Projet;
import Persistance.DAO_Labo;
import Persistance.DaoEntreprise;
import Persistance.DaoProjet;

public class GestionnaireProjet {

	private DaoProjet daoprojet = new DaoProjet();
	private Projet projet;
	private GestionProfesseur gestionpr;

	private boolean existeP(String titre) {

		if (daoprojet.read(titre) == null) {

			return false;
		} else {
			;
			return true;
		}
	}

	public Projet read(String titre) throws SQLException {
		gestionpr = new GestionProfesseur();
		GestionEntreprise gestionEntrep = new GestionEntreprise();
		DaoEntreprise daoEntrep = new DaoEntreprise();
		DAO_Labo daoLabo = new DAO_Labo();
		if (this.existeP(titre)) {

			this.projet = daoprojet.read(titre);
			System.out.println(projet.afficher());
			gestionEntrep.read(projet.getRaisonSocial());
			// infos encadrant 1
			System.out.println("Encadrant 1");
			gestionpr.read(projet.getIdEncadrant1());
			// info encadrant 2 s'il existe
			if (!(this.projet.getIdEncadrant2() == null)) {
				System.out.println("Encadrant 2");
				gestionpr.read(projet.getIdEncadrant2());
			}
			// info labo
			if (!(this.projet.getIdLaboratoire() == null)) {

				if (daoLabo.SearchByCode(projet.getIdLaboratoire()) != null) {
					Gestion_Labo gestLab = new Gestion_Labo();
					gestLab.SearchByCodeLabo(projet.getIdLaboratoire());

				}
				;
			}
			/*
			 * read(laboratoire) read(etudiant)
			 */

			return this.projet;
		} else
			System.out.println("projet n'existe pas");
		return null;
	}

	public boolean add(String idProjet, String titreProjet, String datefinProjet, String datedebutProjet,
			String duréeProjet, String projetType, String idEncadrant1, String idEncadrant2, String idEtudiant,
			String raisonSocial, String idLaboratoire) {
		if (!this.existeP(titreProjet)) {
			this.daoprojet.add(idProjet, titreProjet, datedebutProjet, datefinProjet, duréeProjet, projetType,
					idEncadrant1, idEncadrant2, idEtudiant, raisonSocial, idLaboratoire);
			System.out.println("ajout avec succés");
			return true;
		} else {
			System.out.println("projet existe dejat");
			return false;
		}
	}

	public boolean updateDedline(String titreProjet, String datefinProjet) {
		if (this.existeP(titreProjet)) {
			this.daoprojet.updateDateFin(titreProjet, datefinProjet);
			System.out.println("modification avec succès");
			return true;
		} else {
			System.out.println("projet n'existe pas");
			return false;
		}
	}

	public boolean update(String idProjet, String titreProjet, String datefinProjet, String datedebutProjet,
			String duréeProjet, String projetType, String idEncadrant1, String idEncadrant2, String idEtudiant,
			String raisonSocial, String idLaboratoire) {
		if (this.existeP(titreProjet)) {
			this.daoprojet.update(idProjet, titreProjet, datedebutProjet, datefinProjet, duréeProjet, projetType,
					idEncadrant1, idEncadrant2, idEtudiant, raisonSocial, idLaboratoire);
			System.out.println("modification avec succès");
			return true;
		} else {
			System.out.println("projet n'existe pas");
			return false;
		}
	}

	public boolean delete(String titreProjet) {
		if (this.existeP(titreProjet)) {

			daoprojet.delete(titreProjet);
			System.out.println("Entreprise  supprimée");
			return true;
		} else {
			System.out.println("Entreprise n'existe pas pour le supprimer");
			return false;
		}
	}

	public Projet readProjetById(String idE) {

		return daoprojet.readProjetById(idE);
	}

	public long numbrOfProj() {
		return daoprojet.numbrOfProj();
	}
}
