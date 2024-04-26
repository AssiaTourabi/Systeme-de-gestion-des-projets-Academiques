package Persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Metier.Entreprise;
import Metier.Etape;

public class EtapeDao {
	private Connection con = connexion.getConnexion();
	Entreprise entreprise = null;
	PreparedStatement ps = null;
	ResultSet resultat = null;

	public boolean ajouterEtape(Etape eta) {
		try {
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO etape (idEtape,etapeNom,durée,etapeDateDepar,documentation,livraison) values (?,?,?,?,?,?)");
			ps.setString(1, eta.getIdetape());

			ps.setString(2, eta.getEtapeNom());
			ps.setString(3, eta.getDurée());
			ps.setString(4, eta.getEtapeDateDepart());
			ps.setString(5, eta.getDocumentation());
			ps.setString(6, eta.getLivraison());

			return ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean supprimerEtape(Etape eta) {
		try {
			PreparedStatement ps = con.prepareStatement("DELETE FROM etape WHERE idEtape=?");
			ps.setString(1, eta.getIdetape());
			return ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean modifierEtape(Etape eta, String titre, String dure, String Etad, String doc, String liv) {
		try {
			PreparedStatement ps = con.prepareStatement(
					"UPDATE etape SET etapeNom=? ,durée=?,etapeDateDepar=?,documentation=?,livraison=? WHERE idEtape=?");
			ps.setString(1, titre);
			ps.setString(2, dure);
			ps.setString(3, Etad);
			ps.setString(4, doc);
			ps.setString(5, liv);
			ps.setString(6, eta.getIdetape());
			return ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public String readEtap(String idE) {

		ArrayList listEtap = new ArrayList<Etape>();
		Etape etape = new Etape();
		String infoEtap = "";
		try {

			String requet = "SELECT * FROM Etape WHERE idEtape=?";

			ps = con.prepareStatement(requet);
			ps.setString(1, idE);
			resultat = ps.executeQuery();

			while (resultat.next()) {
				String idEtape = resultat.getString("idEtape");
				String etapeNom = resultat.getString("etapeNom");
				String durée = resultat.getString("durée");
				String etapeDateDepar = resultat.getString("etapeDateDepar");
				String documentation = resultat.getString("documentation");
				String livraison = resultat.getString("livraison");

				etape = new Etape(idEtape, etapeNom, durée, etapeDateDepar, documentation, livraison);

				listEtap.add(etape);
				infoEtap = "id etape:" + idEtape + "\t" + "Titre:" + etapeNom + "\n" + "\n" + "durée:" + durée + "\t"
						+ "\t" + "Date de depart:" + etapeDateDepar + "\t" + "\t" + "Documentation:" + documentation
						+ "\t" + "\t" + "\t" + "\t" + "livraison: " + livraison;
			}

		} catch (Exception e) {

			System.out.print(e);
		}
		return infoEtap;
	}
}
