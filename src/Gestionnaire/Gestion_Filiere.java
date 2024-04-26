package Gestionnaire;

import java.sql.SQLException;
import java.util.ArrayList;

import Metier.Filiere;
import Persistance.DAO_Filiere;

public class Gestion_Filiere {
	DAO_Filiere filiere;

	public Gestion_Filiere() {
		super();
		filiere = new DAO_Filiere();
	}

	public boolean createFiliere(String Nom, String Email, Integer idDepartement, String idprof) {
		return filiere.create(Nom, Email, idDepartement, idprof);
	}

	public boolean DisplayAllFiliere() throws SQLException {
		return filiere.DisplayAll();
	}

	public boolean updateNomFiliere(String NewName, String oldName) throws SQLException {
		return filiere.updateNom(NewName, oldName);
	}

	public boolean updateEmailFiliere(String NewEmail, String Nom) throws SQLException {
		return filiere.updateEmail(NewEmail, Nom);
	}

	public boolean supprimerFiliere(String f) {
		return filiere.delete(f);
	}

	public boolean searchNam(String nom) throws SQLException {
		ArrayList<Filiere> filieres = new ArrayList<Filiere>();
		filieres = filiere.Disp();
		for (Filiere f : filieres) {
			if (f.getNom_Filiere().equals(nom)) {
				return true;
			}
		}

		return false;
	}

	public boolean searchEmail(String email) throws SQLException {
		ArrayList<Filiere> filieres = new ArrayList<Filiere>();
		filieres = filiere.Disp();
		for (Filiere f : filieres) {
			if (f.getEmail_Filiere().equals(email)) {
				return true;
			}
		}

		return false;
	}

	public long NumberofFilliere() {
		return filiere.NumberofFilliere();
	}
}
