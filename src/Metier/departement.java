package Metier;

public class departement {

	private Integer code_depart;
	private String nom_dep;
	private String email_dep;

	public departement(Integer code_depart, String nom_dep, String email_dep) {
		super();
		this.code_depart = code_depart;
		this.nom_dep = nom_dep;
		this.email_dep = email_dep;
	}

	public departement(String nom_dep, String email) {
		super();
		this.nom_dep = nom_dep;
		this.email_dep = email;
	}

	public Integer getCode_depart() {
		return code_depart;
	}

	public void setCode_depart(Integer code_depart) {
		this.code_depart = code_depart;
	}

	public String getNom_dep() {
		return nom_dep;
	}

	public void setNom_dep(String nom_dep) {
		this.nom_dep = nom_dep;
	}

	public String getEmail_dep() {
		return email_dep;
	}

	public void setEmail_dep(String email_dep) {
		this.email_dep = email_dep;
	}

	public departement(Integer code_depart) {
		super();
		this.code_depart = code_depart;
	}

}
