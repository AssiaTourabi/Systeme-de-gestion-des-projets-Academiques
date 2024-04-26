package Persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoAffectationEtape {
	Connection conn = connexion.getConnexion();

	PreparedStatement ps = null;
	ResultSet resultat = null;

	public void affecterE(String idProjet, String idEtape) {

		conn = connexion.getConnexion();
		PreparedStatement ps = null;

		try {
			String requet = "INSERT INTO AffecterEtape (idProjet, idEtape) VALUES (?,?)";

			ps = conn.prepareStatement(requet);
			ps.setString(1, idProjet);
			ps.setString(2, idEtape);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public String getEtape(String idProjet) {

		String IdE = "";

		try {
			String requet = "Select AffecterEtape.idEtape From AffecterEtape  where idProjet=? ";

			ps = conn.prepareStatement(requet);
			ps.setString(1, idProjet);

			resultat = ps.executeQuery();

			while (resultat.next()) {
				IdE = resultat.getString("idEtape");

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return IdE;
	}
}
