package Persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Metier.Entreprise;

public class DaoEntreprise {

	Connection conn = connexion.getConnexion();
	Entreprise entreprise = null;
	PreparedStatement ps = null;
	ResultSet resultat = null;

	public Entreprise read(String raisonSocial) {

		try {
			String requet = "SELECT * FROM Entreprise WHERE raisonSocial=?";
			ps = conn.prepareStatement(requet);
			ps.setString(1, raisonSocial);
			resultat = ps.executeQuery();

			while (resultat.next()) {
				String RaisonSocial = resultat.getString("raisonSocial");
				String Responsable = resultat.getString("responsableEntreprise");
				String Adresse = resultat.getString("adresseEntreprise");
				String Telephone = resultat.getString("telephoneEntreprise");
				String Email = resultat.getString("emailEntreprise");

				entreprise = new Entreprise(RaisonSocial, Responsable, Adresse, Email, Telephone);
				/*
				 * System.out.print("RaisonSocial:"+RaisonSocial+"\n"+
				 * "Responsable:"+Responsable+"\n"+"Adresse:"+Adresse+"\n"+"Telephone"+Telephone
				 * +"\n"+"Email:"+Email );
				 */
			}

		} catch (Exception e) {

			System.out.print(e);
		}
		return entreprise;
	}

	public ArrayList readEntreprise() {
		String RaisonSocial;
		String Responsable;
		String Adresse;
		String Telephone;
		String Email;
		ArrayList<Entreprise> listeEntreprises = new ArrayList<Entreprise>();

		try {
			String requet = "SELECT * FROM Entreprise ";
			ps = conn.prepareStatement(requet);

			resultat = ps.executeQuery();

			while (resultat.next()) {
				RaisonSocial = resultat.getString("raisonSocial");
				Responsable = resultat.getString("responsableEntreprise");
				Adresse = resultat.getString("adresseEntreprise");
				Telephone = resultat.getString("telephoneEntreprise");
				Email = resultat.getString("emailEntreprise");

				entreprise = new Entreprise(RaisonSocial, Responsable, Adresse, Email, Telephone);
				listeEntreprises.add(entreprise);
				/*
				 * System.out.print("RaisonSocial:"+RaisonSocial+"\n"+
				 * "Responsable:"+Responsable+"\n"+"Adresse:"+Adresse+"\n"+"Telephone"+Telephone
				 * +"\n"+"Email:"+Email );
				 */
			}

		} catch (Exception e) {

			System.out.print(e);
		}
		return listeEntreprises;
	}

	public void add(String raisonSocial, String responsableEntreprise, String adresseEntreprise, String emailEntreprise,
			String telephoneEntreprise) {

		Connection conn = connexion.getConnexion();
		PreparedStatement ps = null;

		try {
			String requet = "INSERT INTO Entreprise (raisonSocial,responsableEntreprise,adresseEntreprise,emailEntreprise, telephoneEntreprise) VALUES (?,?,?,?,?)";

			ps = conn.prepareStatement(requet);
			ps.setString(1, raisonSocial);
			ps.setString(2, responsableEntreprise);
			ps.setString(3, adresseEntreprise);
			ps.setString(4, emailEntreprise);
			ps.setString(5, telephoneEntreprise);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void update(String raisonSocial, String responsableEntreprise, String adresseEntreprise,
			String emailEntreprise, String telephoneEntreprise) {

		Connection conn = connexion.getConnexion();
		PreparedStatement ps = null;

		try {
			String requet = "UPDATE Entreprise SET  responsableEntreprise=?,adresseEntreprise=?,emailEntreprise=?,telephoneEntreprise=? WHERE raisonSocial=?";

			ps = conn.prepareStatement(requet);

			ps.setString(1, responsableEntreprise);
			ps.setString(2, adresseEntreprise);
			ps.setString(3, emailEntreprise);
			ps.setString(4, telephoneEntreprise);
			ps.setString(5, raisonSocial);

			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void updateRespo(String raisonSocial, String responsableEntreprise) {

		Connection conn = connexion.getConnexion();
		PreparedStatement ps = null;

		try {
			String requet = "UPDATE Entreprise SET raisonSocial=?, responsableEntreprise=?  WHERE raisonSocial=?";

			ps = conn.prepareStatement(requet);
			ps.setString(1, raisonSocial);
			ps.setString(2, responsableEntreprise);

			ps.setString(3, raisonSocial);

			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void delete(String raisonSocial) {

		// TODO Auto-generated method stub

		Connection conn = connexion.getConnexion();
		PreparedStatement ps = null;

		try {
			String requet = "DELETE FROM Entreprise WHERE raisonSocial=?";

			ps = conn.prepareStatement(requet);
			ps.setString(1, raisonSocial);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
