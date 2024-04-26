package Gestionnaire;

import java.sql.SQLException;
import java.util.ArrayList;

import Metier.professeur;
import Persistance.DaoProfesseur;

public class GestionProfesseur {

	private DaoProfesseur DF = new DaoProfesseur();
	professeur prof = new professeur();

	private boolean existeProf(String idProf) {
		if (DF.read(idProf) == null)
			return false;
		else
			return true;
	}

	public boolean modifierprofesseur(String md, String nom) throws SQLException {
		return DF.modifier(md, nom);
	}

	public boolean read(String idProf) {
		if (this.existeProf(idProf)) {
			prof = DF.read(idProf);
			System.out.println(prof.toString());
			return true;
		} else {
			System.out.println("Professeur n'exist pas");
			return false;
		}
	}

	public professeur readProf(String idProf) {
		if (this.existeProf(idProf)) {
			prof = DF.read(idProf);
			System.out.println(prof.toString());
			return prof;
		} else {
			System.out.println("Professeur n'exist pas");
			return null;
		}
	}
	// verifier le nom de gestion_projet et DAO_profs

	// les definitions des methodes qu'ils sont creer en DAO

	public ArrayList<professeur> getAll() {
		return DF.getAll();
	}

	public boolean ajouter_Prof(professeur e) {
		if (!this.existeProf(e.getN_somme()))
			return DF.ajouter_Prof(e);
		return false;
	}

	public boolean supprimer_Prof(professeur e) {
		if (this.existeProf(e.getN_somme()))
			return DF.supprimer_Prof(e);
		return false;
	}

	public boolean modifier(String Mdp_prof, String nom_prof) throws SQLException {
		return DF.modifier(Mdp_prof, nom_prof);
	}

	public long countProf() {
		return DF.getNumberofProf();
	}

	public boolean archiver_Prof(professeur Prof) {
		return DF.archiver_Prof(Prof);
	}

	public ArrayList<professeur> members_archiver() {
		return DF.members_archiver();
	}

}
