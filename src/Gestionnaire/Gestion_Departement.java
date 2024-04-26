package Gestionnaire;

import java.sql.SQLException;
import java.util.ArrayList;

import Metier.departement;
import Persistance.DAO_Depart;

public class Gestion_Departement {
	DAO_Depart depart;

	public Gestion_Departement() {
		super();
		depart = new DAO_Depart();
	}

	public boolean createDepart(Integer num, String Nom, String Email) {
		return depart.create(num, Nom, Email);
	}

	public boolean DisplayAllDepart() throws SQLException {
		return depart.DisplayAll();
	}

	public departement SearchByCodeDepart(Integer num) throws SQLException {
		return depart.SearchByCode(num);
	}

	public boolean updateNomDepart(String NewName, Integer num) throws SQLException {
		return depart.updateNom(NewName, num);
	}

	public boolean updateEmailDepart(String NewEmail, Integer num) throws SQLException {
		return depart.updateEmail(NewEmail, num);
	}

	public boolean supprimerDepart(Integer i) {
		return depart.delete(i);
	}

	public Integer ReturnIdBySearchNom(String nom) throws SQLException {
		return depart.ReturnIdDepart(nom);
	}

	public ArrayList<String> dispNom() throws SQLException {
		return depart.dispNom();
	}

	public boolean searchNam(String nom) throws SQLException {
		ArrayList<departement> departements = new ArrayList<departement>();
		departements = depart.disp();
		for (departement d : departements) {
			if (d.getNom_dep().equals(nom)) {
				return true;
			}
		}

		return false;
	}

	public boolean searchEmail(String email) throws SQLException {
		ArrayList<departement> departements = new ArrayList<departement>();
		departements = depart.disp();
		for (departement d : departements) {
			if (d.getNom_dep().equals(email)) {
				return true;
			}
		}

		return false;
	}

	public long countTotalDep() {
		return depart.countTotalDep();
	}
}
