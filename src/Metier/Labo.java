package Metier;

public class Labo {
	private String N_Labo;
	private String Nom_Labo;
	private String Email_Labo;
	private String idChef;

	public Labo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Labo(String n_Labo, String nom_Labo, String email_Labo, String idChef) {
		super();
		N_Labo = n_Labo;
		Nom_Labo = nom_Labo;
		Email_Labo = email_Labo;
		this.idChef = idChef;
	}

	public String getN_Labo() {
		return N_Labo;
	}

	public void setN_Labo(String n_Labo) {
		N_Labo = n_Labo;
	}

	public String getNom_Labo() {
		return Nom_Labo;
	}

	public void setNom_Labo(String nom_Labo) {
		Nom_Labo = nom_Labo;
	}

	public String getEmail_Labo() {
		return Email_Labo;
	}

	public void setEmail_Labo(String email_Labo) {
		Email_Labo = email_Labo;
	}

	public String getIdChef() {
		return idChef;
	}

	public void setIdChef(String idChef) {
		this.idChef = idChef;
	}

}
