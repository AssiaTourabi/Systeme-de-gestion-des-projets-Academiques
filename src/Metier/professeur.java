package Metier;

public class professeur {

	private String nom_prof;
	private String prenm_prof;
	private String depart_prof;
	private String email_prof;
	private String grade;
	private String Etat;
	private String N_somme;
	private String mdp_prof;
	private String fonctionalite;

	public professeur(String nom_prof, String prenm_prof, String depart_prof, String email_prof, String grade,
			String etat, String n_somme, String mdp_prof, String fonctionalite) {
		super();
		this.nom_prof = nom_prof;
		this.prenm_prof = prenm_prof;
		this.depart_prof = depart_prof;
		this.email_prof = email_prof;
		this.grade = grade;
		Etat = etat;
		N_somme = n_somme;
		this.mdp_prof = mdp_prof;
		this.fonctionalite = fonctionalite;
	}

	public String getFonctionalite() {
		return fonctionalite;
	}

	public void setFonctionalite(String fonctionalite) {
		this.fonctionalite = fonctionalite;
	}

	public String getNom_prof() {
		return nom_prof;
	}

	public void setNom_prof(String nom_prof) {
		this.nom_prof = nom_prof;
	}

	public String getPrenm_prof() {
		return prenm_prof;
	}

	public void setPrenm_prof(String prenm_prof) {
		this.prenm_prof = prenm_prof;
	}

	public String getDepart_prof() {
		return depart_prof;
	}

	public void setDepart_prof(String depart_prof) {
		this.depart_prof = depart_prof;
	}

	public String getEmail_prof() {
		return email_prof;
	}

	public void setEmail_prof(String email_prof) {
		this.email_prof = email_prof;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getEtat() {
		return Etat;
	}

	public void setEtat(String etat) {
		Etat = etat;
	}

	public String getN_somme() {
		return N_somme;
	}

	public void setN_somme(String n_somme) {
		N_somme = n_somme;
	}

	public String getMdp_prof() {
		return mdp_prof;
	}

	public void setMdp_prof(String mdp_prof) {
		this.mdp_prof = mdp_prof;
	}

	public professeur(String nom_prof, String prenm_prof, String depart_prof, String email_prof, String grade,
			String Etat, String N_somme, String mdp_prof) {
		super();
		this.nom_prof = nom_prof;
		this.prenm_prof = prenm_prof;
		this.depart_prof = depart_prof;
		this.email_prof = email_prof;
		this.grade = grade;
		this.Etat = Etat;
		this.N_somme = N_somme;
		this.mdp_prof = mdp_prof;
	}

	public professeur(String n_somme) {
		super();
		N_somme = n_somme;
	}

	public professeur() {
		// TODO Auto-generated constructor stub
	}

	public professeur(String nom_prof, String prenm_prof, String depart_prof, String email_prof, String grade,
			String etat) {
		super();
		this.nom_prof = nom_prof;
		this.prenm_prof = prenm_prof;
		this.depart_prof = depart_prof;
		this.email_prof = email_prof;
		this.grade = grade;
		Etat = etat;
	}

	public professeur(String n_somme, String mdp_prof) {
		super();
		N_somme = n_somme;
		this.mdp_prof = mdp_prof;
	}

	public professeur(String etat, String n_somme, String mdp_prof) {
		super();
		Etat = etat;
		N_somme = n_somme;
		this.mdp_prof = mdp_prof;
	}

	public professeur(String nom_prof, String prenm_prof, String depart_prof, String email_prof, String grade,
			String etat, String n_somme) {
		super();
		this.nom_prof = nom_prof;
		this.prenm_prof = prenm_prof;
		this.depart_prof = depart_prof;
		this.email_prof = email_prof;
		this.grade = grade;
		Etat = etat;
		N_somme = n_somme;
	}

	@Override
	public String toString() {
		return "professeur [nom_prof=" + nom_prof + ", prenm_prof=" + prenm_prof + ", depart_prof=" + depart_prof
				+ ", email_prof=" + email_prof + ", grade=" + grade + ", Etat=" + Etat + ", N_somme=" + N_somme
				+ ", getNom_prof()=" + getNom_prof() + ", getPrenm_prof()=" + getPrenm_prof() + ", getDepart_prof()="
				+ getDepart_prof() + ", getEmail_prof()=" + getEmail_prof() + ", getGrade()=" + getGrade()
				+ ", getEtat()=" + getEtat() + ", getN_somme()=" + getN_somme()
				+ ",getMdp_prof()=\" + getMdp_prof() + \"]";
	}

}
