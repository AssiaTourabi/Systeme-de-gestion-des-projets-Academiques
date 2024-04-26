package Gestionnaire;

import Persistance.DaoAffectationEtape;

public class GestinAffEt {
	DaoAffectationEtape daoAff=new DaoAffectationEtape();
	
	public String getEtape(String idProjet) {
  return daoAff.getEtape(idProjet);
	}
}
