package Metier;

public class Etape {

	private String idEtape ;
	private String etapeNom;
	private String durée ;
	private String etapeDateDepart ;
	private String documentation;
	private String livraison;
	
	
	public Etape(String idetape, String etapeNom, String durée, String etapeDateDepart,
			String documentation, String livraison) {
		super();
		this.idEtape = idetape;
		this.etapeNom = etapeNom;
		this.durée = durée;
		this.etapeDateDepart = etapeDateDepart;
		this.documentation = documentation;
		this.livraison = livraison;
	}


	public Etape() {
		super();
	}


	public String getIdetape() {
		return idEtape;
	}


	public void setIdetape(String idetape) {
		this.idEtape = idetape;
	}


	public String getEtapeNom() {
		return etapeNom;
	}


	public void setEtapeNom(String etapeNom) {
		this.etapeNom = etapeNom;
	}


	public String getDurée() {
		return durée;
	}


	public void setDurée(String durée) {
		this.durée = durée;
	}


	public String getEtapeDateDepart() {
		return etapeDateDepart;
	}


	public void setEtapeDateDepart(String etapeDateDepart) {
		this.etapeDateDepart = etapeDateDepart;
	}


	public String getDocumentation() {
		return documentation;
	}


	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}


	public String getLivraison() {
		return livraison;
	}


	public void setLivraison(String livraison) {
		this.livraison = livraison;
	}


	@Override
	public String toString() {
		return " Information d'Etape \n"
				+ "id d'etape:" + idEtape + "    Nom d'etape:" + etapeNom + " durée d'etape" + durée + 
				" Date de Depart:"
				+ etapeDateDepart + "   documentation=" + documentation + "  livraison=" + livraison + "]";
	}
	
	
}
