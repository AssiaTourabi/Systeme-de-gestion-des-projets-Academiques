package Metier;

public class AffectationEtape {
	private String idProjet;
	private Integer idEtape;
	public AffectationEtape(String idProjet, Integer idEtape) {
		super();
		this.idProjet = idProjet;
		this.idEtape = idEtape;
	}
	public String getIdProjet() {
		return idProjet;
	}
	public void setIdProjet(String idProjet) {
		this.idProjet = idProjet;
	}
	public Integer getIdEtape() {
		return idEtape;
	}
	public void setIdEtape(Integer idEtape) {
		this.idEtape = idEtape;
	}
	
	
}
