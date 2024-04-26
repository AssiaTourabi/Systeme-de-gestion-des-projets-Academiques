package Persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Metier.Projet;
import Metier.Projet.projetType;

public class DaoProjet {

	Connection conn = connexion.getConnexion();

	public Projet read(String nomProjet) {

		Projet projet = null;
		PreparedStatement ps = null;
		ResultSet resultat = null;

		try {
			String requet = "SELECT * FROM Projet WHERE titreProjet=?";

			ps = conn.prepareStatement(requet);
			ps.setString(1, nomProjet);
			resultat = ps.executeQuery();

			while (resultat.next()) {
				String Numero = resultat.getString("idprojet");
				String Titre = resultat.getString("titreprojet");
				String dateDebut = resultat.getString("datedebutProjet");
				String dateFin = resultat.getString("datefinProjet");
				String Durée = resultat.getString("duréeProjet");
				String projetype = resultat.getString("projetType");

				String idEncadrant1 = resultat.getString("idEncadrant1");
				String idEncadrant2 = resultat.getString("idEncadrant2");
				String idEtudiant = resultat.getString("idEtudiant");
				String raisonEntreprise = resultat.getString("raisonSocial");
				String idLaboratoire = resultat.getString("idLaboratoire");

				projetType type = projetType.valueOf(projetype);

				projet = new Projet(Numero, Titre, dateDebut, dateFin, Durée, type, idEncadrant1, idEncadrant2,
						idEtudiant, idLaboratoire, raisonEntreprise);

			}

		} catch (Exception e) {

			System.out.print(e);
		}
		return projet;
	}

	public void add(String idProjet, String titreProjet, String datefinProjet, String datedebutProjet,
			String duréeProjet, String projetType, String idEncadrant1, String idEncadrant2, String idEtudiant,
			String raisonSocial, String idLaboratoire) {

		Connection conn = connexion.getConnexion();
		PreparedStatement ps = null;

		try {
			String requet = "INSERT INTO Projet (idProjet,titreProjet,datedebutProjet,datefinProjet, duréeProjet,projetType,idEncadrant1,idEncadrant2,idEtudiant,raisonSocial,idLaboratoire) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

			ps = conn.prepareStatement(requet);
			ps.setString(1, idProjet);
			ps.setString(2, titreProjet);
			ps.setString(3, datedebutProjet);
			ps.setString(4, datefinProjet);
			ps.setString(5, duréeProjet);
			ps.setString(6, projetType);
			ps.setString(7, idEncadrant1);
			ps.setString(8, idEncadrant2);
			ps.setString(9, idEtudiant);
			ps.setString(10, raisonSocial);
			ps.setString(11, idLaboratoire);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void update(String idProjet, String titreProjet, String datefinProjet, String datedebutProjet,
			String duréeProjet, String projetType, String idEncadrant1, String idEncadrant2, String idEtudiant,
			String raisonSocial, String idLaboratoire) {

		Connection conn = connexion.getConnexion();
		PreparedStatement ps = null;

		try {
			String requet = "UPDATE Projet SET titreProjet=?,datedebutProjet=?,datefinProjet=?, duréeProjet=?,projetType=?, idEncadrant1=?, idEncadrant2=?,idEtudiant=?,raisonSocial=?,idLaboratoire=? WHERE idProjet=?";

			ps = conn.prepareStatement(requet);

			ps.setString(1, titreProjet);
			ps.setString(2, datedebutProjet);
			ps.setString(3, datefinProjet);
			ps.setString(4, duréeProjet);
			ps.setString(5, projetType);
			ps.setString(6, idEncadrant1);
			ps.setString(7, idEncadrant2);
			ps.setString(8, idEtudiant);
			ps.setString(9, raisonSocial);
			ps.setString(10, idLaboratoire);
			ps.setString(11, idProjet);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void updateDateFin(String titreProjet, String datefinProjet) {

		Connection conn = connexion.getConnexion();
		PreparedStatement ps = null;

		try {
			String requet = "UPDATE Projet SET datefinProjet=? WHERE titreProjet=?";

			ps = conn.prepareStatement(requet);

			ps.setString(1, datefinProjet);
			ps.setString(2, titreProjet);

			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void delete(String titreProjet) {

		// TODO Auto-generated method stub

		Connection conn = connexion.getConnexion();
		PreparedStatement ps = null;

		try {
			String requet = "DELETE FROM Projet WHERE titreProjet=?";

			ps = conn.prepareStatement(requet);
			ps.setString(1, titreProjet);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public ArrayList readProjet() {

		Projet projet = null;
		PreparedStatement ps = null;
		ResultSet resultat = null;
		ArrayList<Projet> listeProjets = new ArrayList<Projet>();

		try {
			String requet = "SELECT * FROM Projet ";
			ps = conn.prepareStatement(requet);

			resultat = ps.executeQuery();

			while (resultat.next()) {
				String Numero = resultat.getString("idProjet");
				String Titre = resultat.getString("titreProjet");
				String dateDebut = resultat.getString("datedebutProjet");
				String dateFin = resultat.getString("datefinProjet");
				String Durée = resultat.getString("duréeProjet");
				String projetype = resultat.getString("projetType");

				String idEncadrant1 = resultat.getString("idEncadrant1");
				String idEncadrant2 = resultat.getString("idEncadrant2");
				String idEtudiant = resultat.getString("idEtudiant");
				String raisonEntreprise = resultat.getString("raisonSocial");
				String idLaboratoire = resultat.getString("idLaboratoire");

				projetType type = projetType.valueOf(projetype);

				projet = new Projet(Numero, Titre, dateDebut, dateFin, Durée, type, idEncadrant1, idEncadrant2,
						idEtudiant, idLaboratoire, raisonEntreprise);
				listeProjets.add(projet);
			}

		} catch (Exception e) {

			System.out.print(e);
		}

		return listeProjets;
	}

	public Projet readProjetById(String idE) {

		Projet projet = null;
		PreparedStatement ps = null;
		ResultSet resultat = null;
		ArrayList<Projet> listeProjets = new ArrayList<Projet>();

		try {
			String requet = "SELECT * FROM Projet WHERE idEtudiant=? ";
			ps = conn.prepareStatement(requet);
			ps.setString(1, idE);
			resultat = ps.executeQuery();

			while (resultat.next()) {
				String Numero = resultat.getString("idProjet");
				String Titre = resultat.getString("titreProjet");
				String dateDebut = resultat.getString("datedebutProjet");
				String dateFin = resultat.getString("datefinProjet");
				String Durée = resultat.getString("duréeProjet");
				String projetype = resultat.getString("projetType");

				String idEncadrant1 = resultat.getString("idEncadrant1");
				String idEncadrant2 = resultat.getString("idEncadrant2");
				String idEtudiant = resultat.getString("idEtudiant");
				String raisonEntreprise = resultat.getString("raisonSocial");
				String idLaboratoire = resultat.getString("idLaboratoire");

				projetType type = projetType.valueOf(projetype);

				projet = new Projet(Numero, Titre, dateDebut, dateFin, Durée, type, idEncadrant1, idEncadrant2,
						idEtudiant, idLaboratoire, raisonEntreprise);
				;
			}

		} catch (Exception e) {

			System.out.print(e);
		}

		return projet;
	}

	public long numbrOfProj() {
		PreparedStatement ps;
		long t = 0;
		try {
			ps = conn.prepareStatement("SELECT COUNT(*) FROM projet");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				t = rs.getLong("COUNT(*)");
			}
			return t;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

}
