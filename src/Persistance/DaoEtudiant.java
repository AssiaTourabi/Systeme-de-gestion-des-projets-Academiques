package Persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Metier.Etudiant;

public class DaoEtudiant {

	Connection conn = connexion.getConnexion();
	Statement getConnetion = null;
	PreparedStatement ps;

	public boolean insertEtudiant(Etudiant e) throws ClassNotFoundException {
		String sql = "insert into Etudiant values (?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, e.getIdE());
			ps.setString(2, e.getCneE());
			ps.setString(3, e.getNomE());
			ps.setString(4, e.getPrenomE());
			ps.setString(5, e.getFiliereE());
			ps.setString(6, e.getNiveauE());
			ps.setString(7, e.getEmailE());
			ps.setString(8, e.getMotPass());
			return ps.executeLargeUpdate() > 0;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}

	public boolean deleteEtudiant(String idE) {

		try {
			String sql = "delete from Etudiant where idE=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, idE);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateEtudiant(String idE, String nomE, String prenomE, String niveauE, String filiereE,
			String emailE, String cneE, String motPasse) {

		try {
			String sql = "update Etudiant set nomE=?,prenom=?, niveauE=?,filiereE=?,emailE=?,cneE=?, motPasse=? where idE=?";
			ps = conn.prepareStatement(sql);

			ps.setString(1, nomE);
			ps.setString(2, prenomE);
			ps.setString(3, niveauE);
			ps.setString(4, filiereE);
			ps.setString(5, emailE);
			ps.setString(6, cneE);
			ps.setString(7, motPasse);
			ps.setString(8, idE);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Etudiant getEtudiantByIde(String idE) {

		try {
			String sql = "SELECT *from Etudiant WHERE idE=?";
			ResultSet resultat = null;

			resultat = ps.executeQuery();
			while (resultat.next()) {
				String IdE = resultat.getString("idE");
				String cneE = resultat.getString("cneE");
				String nomE = resultat.getString("nomE");
				String filiereE = resultat.getString("filiereE");
				String prenomE = resultat.getString("prenomE");
				String niveauE = resultat.getString("niveauE");
				String emailE = resultat.getString("emailE");
				Etudiant e = new Etudiant(IdE, cneE, nomE, prenomE, filiereE, niveauE, emailE);
			}
		}

		catch (Exception e) {

			System.out.print(e);
		}

		Etudiant e = null;
		return e;
	}

	public ArrayList getEtudiants() {
//List<Etudiant> list;
		ArrayList<Etudiant> list = new ArrayList<Etudiant>();
		try {

			String sql = " select * FROM Etudiant";

			ps = conn.prepareStatement(sql);
			ResultSet resultat = ps.executeQuery();
			while (resultat.next()) {

				String IdE = resultat.getString("idE");
				String cneE = resultat.getString("cneE");
				String nomE = resultat.getString("nomE");
				String filiereE = resultat.getString("filiereE");
				String prenomE = resultat.getString("prenom");
				String niveauE = resultat.getString("niveauE");
				String emailE = resultat.getString("emailE");
				String motPass = resultat.getString("motPasse");

				Etudiant etudiant = new Etudiant(IdE, nomE, prenomE, prenomE, niveauE, cneE, emailE, motPass);

				list.add(etudiant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public String getEtudiantByCNE(String cne) {
		String IdE = "";
		try {
			String sql = "SELECT Etudiant.idE from Etudiant WHERE cneE=?";

			ps = conn.prepareStatement(sql);
			ps.setString(1, cne);
			ResultSet resultat = ps.executeQuery();
			// resultat = ps.executeQuery();
			while (resultat.next()) {
				IdE = resultat.getString("idE");

			}
		}

		catch (Exception e) {

			System.out.print(e);
		}

		Etudiant e = null;
		return IdE;
	}

	public long NumberofStudent() {
		PreparedStatement ps;
		long t = 0;
		try {
			ps = conn.prepareStatement("SELECT COUNT(*) FROM etudiant");
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
