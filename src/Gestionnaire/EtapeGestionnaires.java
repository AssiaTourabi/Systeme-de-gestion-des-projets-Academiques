package Gestionnaire;
import Metier.Etape;
import Persistance.EtapeDao;
public class EtapeGestionnaires {
	
	EtapeDao etap;

	public EtapeGestionnaires() {
	
		etap= new EtapeDao();
	}
	
	public boolean ajouterEtape(Etape eta) {
		return etap.ajouterEtape(eta);
	}
	
	public boolean supprimerEtape(Etape eta) {
		return etap.supprimerEtape(eta);
	}
	
	public boolean modifierEtape(Etape eta,String titre,String dure,String Etad,String doc,String liv) {
		return etap.modifierEtape( eta, titre, dure, Etad, doc, liv);
	}
	public String readEtap(String idE) {
		
		return etap.readEtap(idE);
	}
}
