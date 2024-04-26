package Gestionnaire;

import java.util.ArrayList;

import Metier.Entreprise;
import Persistance.DaoEntreprise;

public class GestionEntreprise {

	private Entreprise entrop = new Entreprise();
	private DaoEntreprise daoentrop = new DaoEntreprise();
	private ArrayList<Entreprise> entroprises = new ArrayList<Entreprise>();
	private DaoEntreprise daoentroprise = new DaoEntreprise();

	public GestionEntreprise() {
		super();
		// TODO Auto-generated constructor stub
	}

	private boolean existe(String raisonSocial) {
		if (daoentrop.read(raisonSocial) == null)
			return false;
		else
			return true;
	}

	public boolean read(String raisonSocial) {
		if (this.existe(raisonSocial)) {
			entrop = daoentrop.read(raisonSocial);
			System.out.println(entrop.afficher());
			return true;
		} else {
			System.out.println("Entreprise n'exist pas");
			return false;
		}
	}

	private boolean existeAll() {
		if ((daoentroprise.readEntreprise()).size() == 0)
			return false;
		else
			return true;
	}

	public boolean readAll() {
		if (this.existeAll()) {
			entroprises = daoentroprise.readEntreprise();
			return true;

		} else {
			System.out.println("Entreprise n'exist pas");
			return false;
		}

	}

	public boolean add(String raisonSocial, String responsableEntreprise, String adresseEntreprise,
			String emailEntreprise, String telephoneEntreprise) {
		if (!this.existe(raisonSocial)) {
			this.daoentrop.add(raisonSocial, responsableEntreprise, adresseEntreprise, emailEntreprise,
					telephoneEntreprise);
			System.out.println("ajout avec succés");
			return true;
		} else {
			System.out.println("Entreprise existe dejat");
			return false;
		}
	}

	public boolean update(String raisonSocial, String responsableEntreprise, String adresseEntreprise,
			String emailEntreprise, String telephoneEntreprise) {
		if (this.existe(raisonSocial)) {
			this.daoentrop.update(raisonSocial, responsableEntreprise, adresseEntreprise, emailEntreprise,
					telephoneEntreprise);
			System.out.println("modification avec succès");
			return true;
		} else {
			System.out.println("Entreprise n'existe pas");
			return false;
		}
	}

	public boolean updateRespo(String raisonSocial, String responsableEntreprise) {
		if (this.existe(raisonSocial)) {
			this.daoentrop.updateRespo(raisonSocial, responsableEntreprise);
			System.out.println("modification avec succès");
			return true;
		} else {
			System.out.println("Entreprise n'existe pas");
			return false;
		}
	}

	public boolean delete(String raisonSocial) {
		if (this.existe(raisonSocial)) {

			daoentrop.delete(raisonSocial);
			System.out.println("Entreprise  supprimée");
			return true;
		} else {
			System.out.println("Entroprise n'existe pas pour le supprimer");
			return false;
		}

	}
}
