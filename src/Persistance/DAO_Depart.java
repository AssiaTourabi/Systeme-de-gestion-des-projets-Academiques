package Persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Metier.departement;

public class DAO_Depart {
	Connection cn;

	public DAO_Depart() {
		super();
		new connexion();
		cn = connexion.getConnexion();
	}

	// Create :

	public boolean create(Integer num, String Nom, String Email) {
		try {

			String sql = "INSERT INTO `departement` (`code_depart`,`nom_dep`,`email_dep`)" + "VALUES('" + num + "','"
					+ Nom + "','" + Email + "');";
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

		String sql = "SELECT * FROM departement";
		Statement statement = cn.createStatement();
		ResultSet result = statement.executeQuery(sql);

		if (!result.next()) {
			return false;
		} else {
			while (result.next()) {

				Integer code_d = result.getInt("code_depart");
				String Nom_d = result.getString("nom_dep");
				String Email_d = result.getString("email_dep");
				System.out.println(" |Code Departement : " + code_d + " | Nom :" + Nom_d + "|Email: " + Email_d + "|");
			}
			return true;
		}

	}

	public departement SearchByCode(Integer num) throws SQLException {

		String sql = "SELECT * FROM departement WHERE code_depart=" + num + ";";
		Statement statement = cn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		// ArrayList<Departement> Depart = new ArrayList<Departement>();

		if (result.next()) {

			Integer code_d = result.getInt("code_depart");
			// Depart.add(code_d);
			String Nom_d = result.getString("nom_dep");
			// Depart.add(Nom_d);
			String Email_d = result.getString("email_dep");
			// Depart.add(Email_d);
			departement d = new departement(code_d, Nom_d, Email_d);

			return d;
		}
		return null;

	}

	public ArrayList<departement> disp() throws SQLException {

		String sql = "SELECT * FROM departement ;";
		Statement statement = cn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		ArrayList<departement> Depart = new ArrayList<departement>();

		while (result.next()) {
			Integer code_d = result.getInt("code_depart");
			// Depart.add(code_d);
			String Nom_d = result.getString("nom_dep");
			// Depart.add(Nom_d);
			String Email_d = result.getString("email_dep");
			// Depart.add(Email_d);
			departement dep = new departement(code_d, Nom_d, Email_d);
			Depart.add(dep);

		}
		return Depart;

	}

	public ArrayList<String> dispNom() throws SQLException {

		String sql = "SELECT * FROM departement ;";
		Statement statement = cn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		ArrayList<String> Depart = new ArrayList<String>();

		while (result.next()) {
			String Nom_d = result.getString("nom_dep");
			Depart.add(Nom_d);

		}
		return Depart;

	}

	public Integer ReturnIdDepart(String nom) throws SQLException {

		String sql = "SELECT code_depart FROM departement where nom_dep='" + nom + "';";
		Statement statement = cn.createStatement();
		ResultSet result = statement.executeQuery(sql);

		if (result.next()) {
			String IdDepartement = result.getString("code_depart");
			return Integer.parseInt(IdDepartement);
		}
		return null;

	}

	// Update:

	public boolean updateNom(String NewName, Integer num) throws SQLException {

		String sql = "UPDATE departement SET nom_dep='" + NewName + "' WHERE code_depart='" + num + "';";
		Statement statement = cn.createStatement();
		statement.executeUpdate(sql);
		int rows = statement.executeUpdate(sql);
		if (rows > 0) {
			System.out.println("Le nom de departement a ete bien  changer.");
			return true;
		}
		return false;

	}

	public boolean updateEmail(String NewEmail, Integer num) throws SQLException {
		String sql = "UPDATE departement SET email_dep='" + NewEmail + "' WHERE code_depart='" + num + "';";
		Statement statement = cn.createStatement();
		statement.executeUpdate(sql);
		int rows = statement.executeUpdate(sql);
		if (rows > 0) {

			return true;
		}
		return false;
	}

	// Delete:

	public boolean delete(Integer num) {

		try {

			String sql = "DELETE FROM departement WHERE code_depart='" + num + "';";
			Statement statement = cn.createStatement();

			int rows = statement.executeUpdate(sql);
			if (rows > 0) {
				System.out.println("Le departement a été supprimée !!");
				return true;
			}

			cn.close();

		} catch (SQLException ex) {

			ex.printStackTrace();
		}

		return false;

	}

	public long countTotalDep() {
		PreparedStatement ps;
		long t = 0;
		try {
			ps = cn.prepareStatement("SELECT COUNT(*) FROM departement");
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
