package Presentation;

import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Gestionnaire.Gestion_Departement;
import Gestionnaire.TableModeleDepart;
import Metier.departement;
import Persistance.DAO_Depart;

public class ControlleurDepart {
	private FenetreDepart fenetreDep;

	public ControlleurDepart() {
		super();

	}

	public void demmarrerApplication() {
		this.fenetreDep = new FenetreDepart(this);
		this.fenetreDep.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.fenetreDep.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.fenetreDep.setVisible(true);

	}

	public boolean ajouter(departement depart) {
		this.fenetreDep.setVisible(true);
		Gestion_Departement dep = new Gestion_Departement();
		return dep.createDepart(depart.getCode_depart(), depart.getNom_dep(), depart.getEmail_dep());

	}

	public void affichertout() throws SQLException {
		ArrayList<departement> Departements = new ArrayList<departement>();
		DAO_Depart depart = new DAO_Depart();
		Departements = depart.disp();
		TableModeleDepart modele = new TableModeleDepart(Departements);
		JFrame fenetre = new JFrame();
		JTable table = new JTable(modele);
		JScrollPane sp = new JScrollPane(table);
		// Si on veut définir la taille de la zone d’affichage :
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		fenetre.add(sp);
		// fenetre.setPreferredSize(new Dimension(1400, 1000));
		fenetre.setExtendedState(JFrame.MAXIMIZED_BOTH);
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fenetre.setVisible(true);
	}

	public boolean Supprimer(Integer i) {
		this.fenetreDep.setVisible(false);
		Gestion_Departement dep = new Gestion_Departement();
		return dep.supprimerDepart(i);
	}

	public boolean chercherNom(String input1) throws SQLException {
		this.fenetreDep.setVisible(false);
		Gestion_Departement dep = new Gestion_Departement();
		return dep.searchNam(input1);
	}

	public boolean chercherEmail(String input1) throws SQLException {
		this.fenetreDep.setVisible(false);
		Gestion_Departement dep = new Gestion_Departement();
		return dep.searchEmail(input1);
	}

	public boolean updasteNom(Integer num, String newNom) throws SQLException {
		this.fenetreDep.setVisible(false);
		Gestion_Departement dep = new Gestion_Departement();
		return dep.updateNomDepart(newNom, num);
	}

	public boolean updasteEmail(String email, Integer newEmail) throws SQLException {
		this.fenetreDep.setVisible(false);
		Gestion_Departement dep = new Gestion_Departement();
		return dep.updateEmailDepart(email, newEmail);
	}

	public Integer ReturnId(String nom) throws SQLException {
		this.fenetreDep.setVisible(false);
		Gestion_Departement dep = new Gestion_Departement();
		return dep.ReturnIdBySearchNom(nom);
	}

}
