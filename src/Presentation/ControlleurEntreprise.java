package Presentation;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Gestionnaire.GestionEntreprise;
import Gestionnaire.TableModelEntreprise;
import Metier.Entreprise;
import Persistance.DaoEntreprise;

public class ControlleurEntreprise {

	private FenetreEntrepris fenetreEntr;
	private Entreprise entreprise;
	private GestionEntreprise entre;

	public ControlleurEntreprise() {
		super();
		entre = new GestionEntreprise();
	}

	public void demmarrerApplication() {
		this.fenetreEntr = new FenetreEntrepris(this);
		this.fenetreEntr.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.fenetreEntr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.fenetreEntr.setVisible(true);
	}

	public boolean ajouter(Entreprise entrep) {
		// this.profil = new Profil();
		this.fenetreEntr.setVisible(false);

		if (entre.add(entrep.getRaisonSocial(), entrep.getResponsableEntreprise(), entrep.getAdresseEntreprise(),
				entrep.getEmailEntreprise(), entrep.getTelephoneEntreprise()))
			return true;
		return false;

	}

	public void affichertout() {
		ArrayList<Entreprise> entroprises = new ArrayList<Entreprise>();
		DaoEntreprise entre = new DaoEntreprise();
		entroprises = entre.readEntreprise();
		TableModelEntreprise modele = new TableModelEntreprise(entroprises);
		JFrame fenetre = new JFrame();
		JTable table = new JTable(modele);
		JScrollPane sp = new JScrollPane(table);
		// Si on veut définir la taille de la zone d’affichage :
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		fenetre.setExtendedState(JFrame.MAXIMIZED_BOTH);
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fenetre.add(sp);
		fenetre.show();
	}

	public boolean supprimer(String raison) {
		if (entre.delete(raison))
			return true;
		else
			return false;

	}

	public boolean modifier(String raison, String responsable) {
		if (entre.updateRespo(raison, responsable))
			return true;
		return false;

	}

	public boolean modifierTout(String raisonSocial, String responsableEntreprise, String adresseEntreprise,
			String emailEntreprise, String telephoneEntreprise) {
		if (entre.update(raisonSocial, responsableEntreprise, adresseEntreprise, emailEntreprise, telephoneEntreprise))
			return true;
		return false;

	}
}
