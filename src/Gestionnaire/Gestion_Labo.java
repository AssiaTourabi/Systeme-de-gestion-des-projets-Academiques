package Gestionnaire;

import java.sql.SQLException;
import java.util.ArrayList;

import Metier.Labo;
import Persistance.DAO_Labo;

public class Gestion_Labo {
	DAO_Labo labo;

	public Gestion_Labo() {
		super();
		labo = new DAO_Labo();
	}

	public boolean updateNomLabo(String NewName, String num) throws SQLException {
		return labo.updateNom(NewName, num);
	}

	public boolean updateEmailLabo(String NewEmail, String num) throws SQLException {
		return labo.updateEmail(NewEmail, num);
	}

	public boolean SearchByCodeLabo(String num) throws SQLException {
		if (labo.SearchByCode(num) != null) {
			GestionProfesseur gestionpr = new GestionProfesseur();
			gestionpr.read(((String) (labo.SearchByCode(num).get(3))));

		}

		return false;
	}

	public boolean supprimerLabo(Labo l) {
		return labo.delete(l.getN_Labo());
	}

	public String getNom(String id) {

		return labo.getNom(id);

	}

	public boolean createLabo(String num, String Nom, String Email, String chef) {
		return labo.create(num, Nom, Email, chef);
	}

	public ArrayList<Labo> DisplayAllLabo() throws SQLException {
		return labo.returnAll();
	}

	public boolean updateNomLabo(String NewName, Integer num) throws SQLException {
		return labo.updateEmail(NewName, num);
	}

	public boolean updateEmailLabo(String NewEmail, Integer num) throws SQLException {
		return labo.updateEmail(NewEmail, num);
	}

	public boolean supprimerLabo(String i) {
		return labo.delete(i);
	}

	public String Search(String i) throws SQLException {
		return labo.Search(i);
	}

	public String ReturnIdBySearchNom(String nom) throws SQLException {
		return labo.ReturnIdByNom(nom);
	}

	public boolean searchId(String id) throws SQLException {
		ArrayList<Labo> labos = new ArrayList<Labo>();
		labos = labo.returnAll();
		for (Labo l : labos) {
			if (l.getN_Labo().equals(id)) {
				return true;
			}
		}

		return false;
	}

	public boolean searchEmail(String id) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Labo> labos = new ArrayList<Labo>();
		labos = labo.returnAll();
		for (Labo l : labos) {
			if (l.getEmail_Labo().equals(id)) {
				return true;
			}
		}
		return false;
	}

}
