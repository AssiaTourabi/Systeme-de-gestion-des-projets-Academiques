package Presentation;

import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Gestionnaire.Gestion_Labo;
import Gestionnaire.TableModeleLabo;
import Metier.Labo;
import Persistance.DAO_Labo;

public class ControlleurLabo {

	private FenetreLabo fenetre;

	public ControlleurLabo() {
		super();

	}

	public void demmarrerApplication() throws HeadlessException, SQLException {
		this.fenetre = new FenetreLabo(this);
		this.fenetre.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.fenetre.setVisible(true);
	}

	public boolean ajouter(Labo l) {
		this.fenetre.setVisible(true);
		Gestion_Labo lab = new Gestion_Labo();
		return lab.createLabo(l.getN_Labo(), l.getNom_Labo(), l.getEmail_Labo(), null);
	}

	public void affichertout() throws SQLException {
		ArrayList<Labo> labs = new ArrayList<Labo>();
		DAO_Labo labo = new DAO_Labo();
		labs = labo.returnAll();
		TableModeleLabo modele = new TableModeleLabo(labs);
		JFrame f = new JFrame();
		JTable table = new JTable(modele);
		JScrollPane sp = new JScrollPane(table);
		// Si on veut définir la taille de la zone d’affichage :
		// table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		f.add(sp);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setVisible(true);

	}

	public boolean Supprimer(String i) {
		this.fenetre.setVisible(false);
		Gestion_Labo lab = new Gestion_Labo();
		return lab.supprimerLabo(i);
	}

	public boolean chercherId(String input1) throws SQLException {
		this.fenetre.setVisible(false);
		Gestion_Labo lab = new Gestion_Labo();
		return lab.searchId(input1);
	}

	public boolean chercherEmail(String input1) throws SQLException {
		this.fenetre.setVisible(false);
		Gestion_Labo lab = new Gestion_Labo();
		return lab.searchEmail(input1);
	}

	public boolean updasteNom(String num, String newNom) throws SQLException {
		this.fenetre.setVisible(false);
		Gestion_Labo lab = new Gestion_Labo();
		return lab.updateEmailLabo(newNom, num);
	}

	public boolean updasteEmail(String id, String newEmail) throws SQLException {
		this.fenetre.setVisible(false);
		Gestion_Labo lab = new Gestion_Labo();
		return lab.updateEmailLabo(newEmail, id);
	}

	public String ReturnId(String nom) throws SQLException {
		this.fenetre.setVisible(false);
		Gestion_Labo lab = new Gestion_Labo();
		return lab.ReturnIdBySearchNom(nom);
	}

}
