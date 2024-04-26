package Persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Metier.ChefDeLabo;
import Metier.ChefDepartement;
import Metier.ChefFilliere;
import Metier.Encadr;
import Metier.professeur;

public class DaoProfesseur {

	Connection cn = connexion.getConnexion();

	public professeur read(String id_prof) {
		professeur prof = null;
		PreparedStatement ps = null;
		ResultSet resultat = null;

		try {
			String requet = "SELECT * FROM Professeur WHERE N_Somme=?";
			ps = cn.prepareStatement(requet);
			ps.setString(1, id_prof);
			resultat = ps.executeQuery();

			while (resultat.next()) {
				String num_prof = resultat.getString("N_somme");
				String nom_prof = resultat.getString("Nom_prof");
				String prenm_prof = resultat.getString("Prenm_prof");
				String depart_prof = resultat.getString("depart_prof");
				String email_prof = resultat.getString("email_prof");
				String grade = resultat.getString("grade");
				String Etat = resultat.getString("Etat");

				prof = new professeur(nom_prof, prenm_prof, depart_prof, email_prof, grade, Etat, num_prof);
			}

		} catch (Exception e) {

			System.out.print(e);
		}
		return prof;
	}

	public boolean ajouter_Prof(professeur e) {
		try {
			PreparedStatement ps = cn.prepareStatement("INSERT INTO professeur( nom_prof,  prenm_prof, depart_prof,"
					+ "email_prof, grade,Etat, N_somme ,mdp_prof,fonctionnalite)" + "VALUES(?,?,?,?,?,?,?,?,?)");
			ps.setString(1, e.getNom_prof());
			ps.setString(2, e.getPrenm_prof());
			ps.setString(3, e.getDepart_prof());
			ps.setString(4, e.getEmail_prof());
			ps.setString(5, e.getGrade());
			ps.setString(6, e.getEtat());
			ps.setString(7, e.getN_somme());
			ps.setString(8, e.getMdp_prof());
			if (e.getClass().getSimpleName().equals("chef_de_departement")) {
				ps.setString(9, "chef_de_departement");
			} else if (e.getClass().getSimpleName().equals("coordinateur")) {
				ps.setString(9, "coordinateur");
			} else {
				ps.setString(9, "encadrant");
			}
			return ps.execute();
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		return false;
	}

	public ArrayList<professeur> getAll() {
		ArrayList<professeur> liste = new ArrayList<professeur>();

		try {
			PreparedStatement ps = cn.prepareStatement("SELECT * FROM professeur ");
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				if (res.getString("fonctionnalite").equals("Chef de Departement")) {
					liste.add(new ChefDepartement(res.getNString("Nom_prof"), res.getNString("prenm_prof"),
							res.getNString("depart_prof"), res.getNString("email_prof"), res.getNString("grade"),
							res.getNString("Etat"), res.getNString("N_somme"), res.getNString("mdp_prof"),
							"Chef de Departement"

					));
				} else if (res.getString("fonctionnalite").equals("encadrant")) {
					liste.add(new Encadr(res.getNString("Nom_prof"), res.getNString("prenm_prof"),
							res.getNString("depart_prof"), res.getNString("email_prof"), res.getNString("grade"),
							res.getNString("Etat"), res.getNString("N_somme"),

							res.getNString("mdp_prof"), "encadrant"));
				} else if (res.getString("fonctionnalite").equals("coordinateur")) {
					liste.add(new ChefFilliere(res.getNString("Nom_prof"), res.getNString("prenm_prof"),
							res.getNString("depart_prof"), res.getNString("email_prof"), res.getNString("grade"),
							res.getNString("Etat"), res.getNString("N_somme"),

							res.getNString("mdp_prof"), "coordinateur"));

				} else if (res.getString("fonctionnalite").equals("resposable laboratoire")) {
					liste.add(new ChefDeLabo(res.getNString("Nom_prof"), res.getNString("prenm_prof"),
							res.getNString("depart_prof"), res.getNString("email_prof"), res.getNString("grade"),
							res.getNString("Etat"), res.getNString("N_somme"),

							res.getNString("mdp_prof"), "resposable laboratoire"));

				} else {
					liste.add(new professeur(res.getNString("Nom_prof"), res.getNString("prenm_prof"),
							res.getNString("depart_prof"), res.getNString("email_prof"), res.getNString("grade"),
							res.getNString("Etat"), res.getNString("N_somme"),

							res.getNString("mdp_prof"), "admin"));

				}
			}
			return liste;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean supprimer_Prof(professeur e) {
		String st = "DELETE FROM professeur WHERE N_somme=?";
		try {
			PreparedStatement ps = cn.prepareStatement(st);
			ps.setString(1, e.getN_somme());
			return ps.execute();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}

	public boolean modifier(String N_somme, String depart_prof, String Mdp_prof, String Nom_prof, String Prenm_prof,
			String Email_prof, String Grade, String Etat) {
		String st = "UPDATE professeur set N_somme=? , depart_prof=? , Mdp_prof=? ,  Nom_prof=?,Prenm_prof =?, Email_prof =? , Grade = ? , Etat = ?"
				+ "WHERE N_somme=?";

		try {
			PreparedStatement ps = cn.prepareStatement(st);
			ps.setString(1, N_somme);
			ps.setString(2, depart_prof);
			ps.setString(3, Mdp_prof);
			ps.setString(4, Nom_prof);
			ps.setString(5, Prenm_prof);
			ps.setString(6, Email_prof);
			ps.setString(7, Grade);
			ps.setString(8, Etat);
			ps.setString(9, N_somme);
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public boolean archiver_Prof(professeur Prof) {
		PreparedStatement ps;
		try {
			ps = cn.prepareStatement("UPDATE professeur SET Etat=? WHERE professeur.N_somme=?");
			ps.setNString(1, "Archive");
			ps.setNString(2, Prof.getN_somme());
			ps.execute();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<professeur> members_archiver() {
		PreparedStatement ps;
		try {
			ps = cn.prepareStatement("Select * FROM professeur WHERE Etat=?");
			ArrayList<professeur> liste = new ArrayList<professeur>();
			ResultSet res;
			ps.setString(1, "Archive");
			res = ps.executeQuery();
			while (res.next()) {

				if (res.getString("fonctionnalite").equals("Chef de Departement")) {
					liste.add(new ChefDepartement(res.getNString("Nom_prof"), res.getNString("prenm_prof"),
							res.getNString("depart_prof"), res.getNString("email_prof"), res.getNString("grade"),
							res.getNString("Etat"), res.getNString("N_somme"),

							res.getNString("mdp_prof"), "resposable laboratoire"));
				} else if (res.getString("fonctionnalite").equals("coordinateur")) {
					liste.add(new ChefFilliere(res.getNString("Nom_prof"), res.getNString("prenm_prof"),
							res.getNString("depart_prof"), res.getNString("email_prof"), res.getNString("grade"),
							res.getNString("Etat"), res.getNString("N_somme"),

							res.getNString("mdp_prof"), "resposable laboratoire"));
				}

				else if (res.getString("fonctionnalite").equals("resposable laboratoire")) {
					liste.add(new ChefDeLabo(res.getNString("Nom_prof"), res.getNString("prenm_prof"),
							res.getNString("depart_prof"), res.getNString("email_prof"), res.getNString("grade"),
							res.getNString("Etat"), res.getNString("N_somme"),

							res.getNString("mdp_prof"), "resposable laboratoire"));
				} else {
					liste.add(new Encadr(res.getNString("Nom_prof"), res.getNString("prenm_prof"),
							res.getNString("depart_prof"), res.getNString("email_prof"), res.getNString("grade"),
							res.getNString("Etat"), res.getNString("N_somme"), res.getNString("mdp_prof"),
							"resposable laboratoire"));
				}
			}
			return liste;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error");
			return null;
		}

	}

	public long getNumberofProf() {
		PreparedStatement ps;
		long t = 0;
		try {
			ps = cn.prepareStatement("SELECT COUNT(*) FROM professeur");
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

	public boolean modifier(String Mdp_prof, String num) throws SQLException {

		String sql = "UPDATE professeur SET mdp_prof='" + Mdp_prof + "' WHERE N_somme=" + num + ";";
		Statement statement = cn.createStatement();
		statement.executeUpdate(sql);
		int rows = statement.executeUpdate(sql);
		if (rows > 0) {
			// System.out.println("L'Email de departement a ete bien changer.");
			return true;
		}
		return false;
	}

	public boolean login(String cne, String mp) throws SQLException {
		String sql = "SELECT * FROM  professeur WHERE N_somme = '" + cne + "' AND mdp_prof = '" + mp + "';";
		Statement statement = cn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		if (result.next()) {
			return true;

		}
		return false;

	}

}
