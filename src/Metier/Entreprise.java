package Metier;

public class Entreprise {

	
	private String raisonSocial ;
	private String responsableEntreprise ;
	private String adresseEntreprise ;
	private String emailEntreprise ;
	private String telephoneEntreprise ;
	
	
	public Entreprise() {
		super();
	}
	public Entreprise(String raisonSocial, String responsableEntreprise,String adresseEntreprise, 
			String emailEntreprise, String telephoneEntreprise)
			 {
		super();
		this.raisonSocial = raisonSocial;
		this.adresseEntreprise = adresseEntreprise;
		this.emailEntreprise = emailEntreprise;
		this.telephoneEntreprise = telephoneEntreprise;
		this.responsableEntreprise = responsableEntreprise;
	}
	public String getRaisonSocial() {
		return raisonSocial;
	}
	public void setRaisonSocial(String raisonSocial) {
		this.raisonSocial = raisonSocial;
	}
	public String getAdresseEntreprise() {
		return adresseEntreprise;
	}
	public void setAdresseEntreprise(String adresseEntreprise) {
		this.adresseEntreprise = adresseEntreprise;
	}
	public String getEmailEntreprise() {
		return emailEntreprise;
	}
	public void setEmailEntreprise(String emailEntreprise) {
		this.emailEntreprise = emailEntreprise;
	}
	public String getTelephoneEntreprise() {
		return telephoneEntreprise;
	}
	public void setTelephoneEntreprise(String telephoneEntreprise) {
		this.telephoneEntreprise = telephoneEntreprise;
	}
	public String getResponsableEntreprise() {
		return responsableEntreprise;
	}
	public void setResponsableEntreprise(String responsableEntreprise) {
		this.responsableEntreprise = responsableEntreprise;
	}
	
	public String afficher() {
		return "Entreprise :raisonSocial=" + raisonSocial + "\n responsableEntreprise=" + responsableEntreprise
				+ "| adresseEntreprise=" + adresseEntreprise + "| emailEntreprise=" + emailEntreprise
				+ "| telephoneEntreprise=" + telephoneEntreprise ;
	}
	
	
}
