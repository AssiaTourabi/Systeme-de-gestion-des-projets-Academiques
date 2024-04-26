package Metier;

public class Projet {

	private String idProjet;
	private String titreProjet;
	private String datefinProjet;
	private String datedebutProjet;
	private String duréeProjet;
	private projetType projetType;
	private String idEncadrant1;
	private String idEncadrant2;
	private String idEtudiant;
	private String idLaboratoire;
	private String raisonSocial;

	public enum projetType {
		pfa, pfe, doctorat;
	}

	public Projet() {
		super();
	}

	public Projet(String idProjet, String titreProjet, String datefinProjet, String datedebutProjet, String duréeProjet,
			Metier.Projet.projetType projetType, String idEncadrant1, String idEncadrant2, String idEtudiant,
			String idLaboratoire, String raisonSocial) {
		super();
		this.idProjet = idProjet;
		this.titreProjet = titreProjet;
		this.datefinProjet = datefinProjet;
		this.datedebutProjet = datedebutProjet;
		this.duréeProjet = duréeProjet;
		this.projetType = projetType;
		this.idEncadrant1 = idEncadrant1;
		this.idEncadrant2 = idEncadrant2;
		this.idEtudiant = idEtudiant;
		this.idLaboratoire = idLaboratoire;
		this.raisonSocial = raisonSocial;
	}

	public Projet(String idProjet, String titreProjet, String datefinProjet, String datedebutProjet, String duréeProjet,
			Metier.Projet.projetType projetType) {
		super();
		this.idProjet = idProjet;
		this.titreProjet = titreProjet;
		this.datefinProjet = datefinProjet;
		this.datedebutProjet = datedebutProjet;
		this.duréeProjet = duréeProjet;
		this.projetType = projetType;
	}

	public String getIdProjet() {
		return idProjet;
	}

	public void setIdProjet(String idProjet) {
		this.idProjet = idProjet;
	}

	public String getTitreProjet() {
		return titreProjet;
	}

	public void setTitreProjet(String titreProjet) {
		this.titreProjet = titreProjet;
	}

	public String getDatefinProjet() {
		return datefinProjet;
	}

	public void setDatefinProjet(String datefinProjet) {
		this.datefinProjet = datefinProjet;
	}

	public String getDatedebutProjet() {
		return datedebutProjet;
	}

	public void setDatedebutProjet(String datedebutProjet) {
		this.datedebutProjet = datedebutProjet;
	}

	public String getDuréeProjet() {
		return duréeProjet;
	}

	public void setDuréeProjet(String duréeProjet) {
		this.duréeProjet = duréeProjet;
	}

	public projetType getProjetType() {
		return projetType;
	}

	public void setProjetType(projetType projetType) {
		this.projetType = projetType;
	}

	public String getIdEncadrant1() {
		return idEncadrant1;
	}

	public void setIdEncadrant1(String idEncadrant1) {
		this.idEncadrant1 = idEncadrant1;
	}

	public String getIdEncadrant2() {
		return idEncadrant2;
	}

	public void setIdEncadrant2(String idEncadrant2) {
		this.idEncadrant2 = idEncadrant2;
	}

	public String getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(String idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	public String getIdLaboratoire() {
		return idLaboratoire;
	}

	public void setIdLaboratoire(String idLaboratoire) {
		this.idLaboratoire = idLaboratoire;
	}

	public String getRaisonSocial() {
		return raisonSocial;
	}

	public void setRaisonSocial(String idEntreprise) {
		this.raisonSocial = idEntreprise;
	}

	public String afficher() {
		return "Projet: idProjet:" + idProjet + "\n nom de projet:" + titreProjet + "| date de fin de Projet:"
				+ datefinProjet + "| date de debut du Projet:" + datedebutProjet + "| durée de Projet:" + duréeProjet
				+ "| Type:" + projetType;
	}

}