package Persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Metier.Labo;

public class DAO_Labo {
	Connection cn;

	public DAO_Labo() {
		super();
		cn = new connexion().getConnexion();
	}

	// Create :

	public boolean create(String num, String Nom, String Chef, String Email) {
		try {

			String sql = "INSERT INTO `labo` (`N_Labo`,`Nom_Labo`,`idlabo`,`Email_Labo`)" + "VALUES('" + num + "','"
					+ Nom + "','" + Email + "','" + Chef + "');";
			Statement statement = cn.createStatement();
			int rows = statement.executeUpdate(sql);
			if (rows > 0) {
				System.out.println(" --> Le departement a été ajouter ...");
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

		String sql = "SELECT * FROM labo";
		Statement statement = cn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		if (!result.next()) {
			return false;
		}
		while (result.next()) {
			String N_Labo = result.getString("N_Labo");
			String Nom_l = result.getString("Nom_Labo");
			String Email_l = result.getString("Email_Labo");
			System.out.println(" |Num Labo : " + N_Labo + " | Nom :" + Nom_l + "|Email: " + Email_l + "|");
		}
		return true;

	}

	/*
	 * public ArrayList<Labo> SearchByCode(String num) throws SQLException {
	 * 
	 * String sql = "SELECT * FROM labo WHERE N_Labo='" + num + "';"; Statement
	 * statement = cn.createStatement(); ResultSet result =
	 * statement.executeQuery(sql); ArrayList<Labo> Lab = new ArrayList<Labo>(); if
	 * (result.next()) { String N_Labo = result.getString("N_Labo"); //
	 * Lab.add(N_Labo); String Nom_l = result.getString("Nom_Labo"); //
	 * Lab.add(Nom_l); String Email_l = result.getString("Email_Labo"); //
	 * Lab.add(Email_l); String idChef = result.getString("idChef"); //
	 * Lab.add(idChef); Labo l = new Labo(N_Labo, Nom_l, Email_l, idChef);
	 * Lab.add(l); return Lab; } return null;
	 * 
	 * }
	 */

	public String getNom(String id) {
		PreparedStatement statement = null;
		ResultSet result = null;
		String Nom_l = "";
		try {

			String sql = "SELECT Nom_Labo FROM labo WHERE N_Labo=?";

			statement = cn.prepareStatement(sql);
			statement.setString(1, id);
			result = statement.executeQuery();

			while (result.next()) {
				System.out.println("zzzzzzzzz");
				Nom_l = result.getString("Nom_Labo");
				System.out.println("zzzzzzzzz");
			}
		} catch (Exception e) {

			System.out.print(e);
		}

		return Nom_l;

	}
	// Update:

	public boolean updateNom(String NewName, String num) throws SQLException {
		String sql = "UPDATE labo SET Nom_Labo='" + NewName + "' WHERE N_Labo=" + num + ";";
		Statement statement = cn.createStatement();
		statement.executeUpdate(sql);
		int rows = statement.executeUpdate(sql);
		if (rows > 0) {
			System.out.println("Le nom a ete bien  changer.");
			return true;
		}
		return false;

	}

	public List<Object> SearchByCode(String num) throws SQLException {

		String sql = "SELECT * FROM labo WHERE N_Labo=" + num + ";";
		Statement statement = cn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		List<Object> Lab = new ArrayList<Object>();
		if (result.next()) {
			String N_Labo = result.getString("N_Labo");
			Lab.add(N_Labo);
			String Nom_l = result.getString("Nom_Labo");
			Lab.add(Nom_l);
			String Email_l = result.getString("Email_Labo");
			Lab.add(Email_l);
			String idChef = result.getString("idChef");
			Lab.add(idChef);
			return Lab;
		}
		return null;

	}

	public boolean updateEmail(String NewEmail, String num) throws SQLException {
		String sql = "UPDATE labo SET Email_Labo='" + NewEmail + "' WHERE N_Labo=" + num + ";";
		Statement statement = cn.createStatement();
		statement.executeUpdate(sql);
		int rows = statement.executeUpdate(sql);
		if (rows > 0) {
			System.out.println("L'Email a ete bien  changer.");
			return true;
		}
		return false;
	}

	public ArrayList<Labo> returnAll() throws SQLException {

		String sql = "SELECT * FROM labo ;";
		Statement statement = cn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		ArrayList<Labo> Lab = new ArrayList<Labo>();

		while (result.next()) {
			String N_Labo = result.getString("N_Labo");
			// Lab.add(N_Labo);
			String Nom_l = result.getString("Nom_Labo");
			// Lab.add(Nom_l);
			String Email_l = result.getString("Email_Labo");
			// Lab.add(Email_l);
			String idChef = result.getString("idChef");

			Labo l = new Labo(N_Labo, Nom_l, Email_l, idChef);
			Lab.add(l);

		}
		return Lab;
	}

	// Update:

	public boolean updateNom(String NewName, Integer num) throws SQLException {
		String sql = "UPDATE labo SET Nom_Labo='" + NewName + "' WHERE N_Labo='" + num + "';";
		Statement statement = cn.createStatement();
		statement.executeUpdate(sql);
		int rows = statement.executeUpdate(sql);
		if (rows > 0) {
			System.out.println("Le nom a ete bien  changer.");
			return true;
		}
		return false;

	}

	public boolean updateEmail(String NewEmail, Integer num) throws SQLException {
		String sql = "UPDATE labo SET Email_Labo='" + NewEmail + "' WHERE N_Labo='" + num + "';";
		Statement statement = cn.createStatement();
		statement.executeUpdate(sql);
		int rows = statement.executeUpdate(sql);
		if (rows > 0) {
			System.out.println("L'Email a ete bien  changer.");
			return true;
		}
		return false;
	}

	public String ReturnIdByNom(String nom) throws SQLException {
		String sql = "SELECT N_Labo FROM Labo  where Nom_Labo='" + nom + "';";
		Statement statement = cn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		if (result.next()) {
			String IdDepartement = result.getString("N_Labo");
			return IdDepartement;
		}
		return null;

	}

	public String Search(String nom) throws SQLException {
		String sql = "SELECT N_Labo FROM Labo  where Nom_Labo='" + nom + "';";
		Statement statement = cn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		if (result.next()) {
			String IdDepartement = result.getString("N_Labo");
			return IdDepartement;
		}
		return null;

	}

	public boolean delete(String num) {

		try {

			String sql = "DELETE FROM Labo WHERE N_Labo='" + num + "';";
			Statement statement = cn.createStatement();

			int rows = statement.executeUpdate(sql);
			if (rows > 0) {
				System.out.println("Le labo a été supprimé !!");
				return true;
			}

			cn.close();

		} catch (SQLException ex) {

			ex.printStackTrace();
		}

		return false;

	}

}
