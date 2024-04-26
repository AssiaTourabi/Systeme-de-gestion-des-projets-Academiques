package Presentation;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Gestionnaire.EtapeGestionnaires;
import Gestionnaire.Gestion_Departement;
import Gestionnaire.Gestion_Filiere;
import Gestionnaire.TableModeleDepart;
import Metier.Etape;
import Metier.departement;
import Persistance.DAO_Depart;

public class ControlleurEtape {
	private FenetreEtape fenetre;

	public ControlleurEtape() {
		super();

	}

	public void demmarrerApplication() throws HeadlessException, SQLException {
		this.fenetre = new FenetreEtape(this);
		this.fenetre.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.fenetre.setVisible(true);

	}

	public boolean ajouter(Etape etape) {
		this.fenetre.setVisible(true);
		EtapeGestionnaires et = new EtapeGestionnaires();
		return et.ajouterEtape(etape);

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
		this.fenetre.setVisible(false);
		Gestion_Departement dep = new Gestion_Departement();
		return dep.supprimerDepart(i);
	}

	public boolean chercherNom(String input1) throws SQLException {
		this.fenetre.setVisible(false);
		Gestion_Departement dep = new Gestion_Departement();
		return dep.searchNam(input1);
	}

	public boolean chercherEmail(String input1) throws SQLException {
		this.fenetre.setVisible(false);
		Gestion_Departement dep = new Gestion_Departement();
		return dep.searchEmail(input1);
	}

	public boolean updasteNom(Integer num, String newNom) throws SQLException {
		this.fenetre.setVisible(false);
		Gestion_Departement dep = new Gestion_Departement();
		return dep.updateEmailDepart(newNom, num);
	}

	public boolean updasteEmail(String email, String newEmail) throws SQLException {
		this.fenetre.setVisible(false);
		Gestion_Filiere fel = new Gestion_Filiere();
		return fel.updateEmailFiliere(email, newEmail);
	}

	public Integer ReturnId(String nom) throws SQLException {
		this.fenetre.setVisible(false);
		Gestion_Departement dep = new Gestion_Departement();
		return dep.ReturnIdBySearchNom(nom);
	}

}
