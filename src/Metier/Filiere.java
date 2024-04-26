package Metier;

public class Filiere {
	private String Nom_Filiere;
	private String Email_Filiere;
	private Integer idDepartement;
	private String idProf;

	public Filiere(String nom_Filiere, String email_Filiere, Integer idDepartement, String idProf) {
		super();
		Nom_Filiere = nom_Filiere;
		Email_Filiere = email_Filiere;
		this.idDepartement = idDepartement;
		this.idProf = idProf;
	}

	public String getIdProf() {
		return idProf;
	}

	public void setIdProf(String idProf) {
		this.idProf = idProf;
	}

	public Filiere() {
		super();
	}

	public Integer getIdDepartement() {
		return idDepartement;
	}

	public void setIdDepartement(Integer idDepartement) {
		this.idDepartement = idDepartement;
	}

	public String getNom_Filiere() {
		return Nom_Filiere;
	}

	public void setNom_Filiere(String nom_Filiere) {
		Nom_Filiere = nom_Filiere;
	}

	public String getEmail_Filiere() {
		return Email_Filiere;
	}

	public void setEmail_Filiere(String email_Filiere) {
		Email_Filiere = email_Filiere;
	}

}
