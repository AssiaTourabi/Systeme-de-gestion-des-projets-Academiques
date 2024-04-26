package Presentation;

import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Gestionnaire.Gestion_Filiere;
import Gestionnaire.TableModeleFiliere;
import Metier.Filiere;
import Persistance.DAO_Filiere;

public class filiereControleur {

	private FenetreFiliere fenetreF;

	public filiereControleur() {
		super();
	}

	public void demmarrerApplication() throws HeadlessException, SQLException {
		this.fenetreF = new FenetreFiliere(this);
		this.fenetreF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.fenetreF.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.fenetreF.setVisible(true);
	}

	public boolean ajouter(Filiere f) {
		this.fenetreF.setVisible(false);
		Gestion_Filiere fel = new Gestion_Filiere();
		return fel.createFiliere(f.getNom_Filiere(), f.getEmail_Filiere(), f.getIdDepartement(), f.getIdProf());
	}

	public void affichertout() throws SQLException {
		ArrayList<Filiere> Filieres = new ArrayList<Filiere>();
		DAO_Filiere fel = new DAO_Filiere();
		Filieres = fel.Disp();
		TableModeleFiliere modele = new TableModeleFiliere(Filieres);
		JFrame fenetre = new JFrame();
		JTable table = new JTable(modele);
		JScrollPane sp = new JScrollPane(table);
		fenetre.setBounds(450, 190, 2500, 700);
		// Si on veut définir la taille de la zone d’affichage :
		// table.setPreferredScrollableViewportSize(new Dimension(1400, 1000));
		fenetre.add(sp);
		fenetre.setExtendedState(JFrame.MAXIMIZED_BOTH);
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fenetre.setVisible(true);
	}

	public boolean Supprimer(String i) {
		this.fenetreF.setVisible(false);
		Gestion_Filiere fel = new Gestion_Filiere();
		return fel.supprimerFiliere(i);
	}

	public boolean chercherNom(String nom) throws SQLException {
		this.fenetreF.setVisible(false);
		Gestion_Filiere fel = new Gestion_Filiere();
		return fel.searchNam(nom);
	}

	public boolean chercherEmail(String email) throws SQLException {
		this.fenetreF.setVisible(false);
		Gestion_Filiere fel = new Gestion_Filiere();
		return fel.searchEmail(email);
	}

	public boolean updasteNom(String nom, String newNom) throws SQLException {
		this.fenetreF.setVisible(false);
		Gestion_Filiere fel = new Gestion_Filiere();
		return fel.updateNomFiliere(nom, newNom);
	}

	public boolean updasteEmail(String email, String newEmail) throws SQLException {
		this.fenetreF.setVisible(false);
		Gestion_Filiere fel = new Gestion_Filiere();
		return fel.updateEmailFiliere(email, newEmail);
	}

}
