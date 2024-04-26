package Persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Metier.Filiere;

public class DAO_Filiere {
	Connection cn;

	public DAO_Filiere() {
		super();
		new connexion();
		cn = connexion.getConnexion();
	}

	// Create :

	public boolean create(String Nom, String Email, Integer idDepartement, String num) {
		try {

			String sql = "INSERT INTO `filiere` (`Nom_Filiere`,`Email_Filiere`,`idDepartement`,`idProf`)" + "VALUES('"
					+ Nom + "','" + Email + "','" + idDepartement + "','" + num + "');";
			Statement statement = cn.createStatement();
			int rows = statement.executeUpdate(sql);
			if (rows > 0) {
				System.out.println(" -->Filiere a été ajouter ...");
				return true;
			}

			cn.close();

		} catch (SQLException ex) {

			ex.printStackTrace();
		}
		return false;
	}

	// Display :

	public boolean DisplayAll() throws SQLException {

		String sql = "SELECT * FROM filiere";
		Statement statement = cn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		if (!result.next()) {
			return false;
		}
		while (result.next()) {
			String Nom_f = result.getString("Nom_Filiere");
			String Email_f = result.getString("Email_Filiere");
			System.out.println(" |Nom Filiere :" + Nom_f + "|Email: " + Email_f + "|");
		}
		return true;
	}

	public ArrayList<Filiere> displayAll() throws SQLException {
		String sql = "SELECT * FROM filiere ;";
		Statement statement = cn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		ArrayList<Filiere> filieres = new ArrayList<Filiere>();
		if (result.next()) {
			String Nom_f = result.getString("Nom_Filiere");
			// Filiere.add(Nom_f);
			String Email_f = result.getString("Email_Filiere");
			String IdDepartement = result.getString("idDepartement");
			String Idprof = result.getString("idProf");

			// Filiere.add(Email_f);
			Filiere f = new Filiere(Nom_f, Email_f, Integer.parseInt(IdDepartement), Idprof);
			filieres.add(f);
			return filieres;
		}
		return null;

	}

	public Filiere serachNom(String nom) throws SQLException {
		String sql = "SELECT * FROM filiere WHERE Nom_Filiere='" + nom + "';";
		Statement statement = cn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		if (result.next()) {
			String Nom_f = result.getString("Nom_Filiere");
			String Email_f = result.getString("Email_Filiere");
			String IdDepartement = result.getString("idDepartement");
			String Idprof = result.getString("idProf");
			Filiere f = new Filiere(Nom_f, Email_f, Integer.parseInt(IdDepartement), Idprof);

			return f;
		}
		return null;

	}

	public ArrayList<Filiere> Disp() throws SQLException {

		String sql = "SELECT * FROM filiere ;";
		Statement statement = cn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		ArrayList<Filiere> filieres = new ArrayList<Filiere>();
		while (result.next()) {

			String Nom_f = result.getString("Nom_Filiere");
			// Filiere.add(Nom_f);
			String Email_f = result.getString("Email_Filiere");
			String IdDepartement = result.getString("idDepartement");
			String Idprof = result.getString("idProf");
			// Filiere.add(Email_f);
			Filiere f = new Filiere(Nom_f, Email_f, Integer.parseInt(IdDepartement), Idprof);
			filieres.add(f);
		}
		return filieres;

	}
	// Update:

	public boolean updateNom(String NewName, String oldName) throws SQLException {
		String sql = "UPDATE filiere SET Nom_Filiere='" + NewName + "' WHERE Nom_Filiere='" + oldName + "';";
		Statement statement = cn.createStatement();
		statement.executeUpdate(sql);
		int rows = statement.executeUpdate(sql);
		if (rows > 0) {
			System.out.println("Le nom a ete bien changer.");
			return true;
		}
		return false;

	}

	public boolean updateEmail(String NewEmail, String nom) throws SQLException {
		String sql = "UPDATE filiere SET Email_Filiere='" + NewEmail + "' WHERE Nom_Filiere='" + nom + "';";
		Statement statement = cn.createStatement();
		statement.executeUpdate(sql);
		int rows = statement.executeUpdate(sql);
		if (rows > 0) {
			System.out.println("L'Email a ete bien  changer.");
			return true;
		}
		return false;
	}

	public boolean delete(String nom) {

		try {

			String sql = "DELETE FROM Filiere WHERE Nom_Filiere='" + nom + "';";
			Statement statement = cn.createStatement();

			int rows = statement.executeUpdate(sql);
			if (rows > 0) {
				System.out.println("La filiere a été supprimée !!");
				return true;

			}

			cn.close();

		} catch (SQLException ex) {

			ex.printStackTrace();
		}
		return false;

	}

	public long NumberofFilliere() {
		PreparedStatement ps;
		long t = 0;
		try {
			ps = cn.prepareStatement("SELECT COUNT(*) FROM filiere");
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
