package Metier;

public class Etudiant {
	private String idE;
	private String nomE;
	private String prenomE;
	private String filiereE;
	private String niveauE;
	private String cneE;
	private String emailE;
	private String motPass;
	public Etudiant() {
		// TODO Auto-generated constructor stub
	}
	public Etudiant(String idE, String nomE, String prenomE, String filiereE, String niveauE, String cneE,
			String emailE) {
		super();
		this.idE = idE;
		this.nomE = nomE;
		this.prenomE = prenomE;
		this.filiereE = filiereE;
		this.niveauE = niveauE;
		this.cneE = cneE;
		this.emailE = emailE;
	}
	
	
	public Etudiant(String idE, String nomE, String prenomE, String filiereE, String niveauE, String cneE,
			String emailE, String motPass) {
		super();
		this.idE = idE;
		this.nomE = nomE;
		this.prenomE = prenomE;
		this.filiereE = filiereE;
		this.niveauE = niveauE;
		this.cneE = cneE;
		this.emailE = emailE;
		this.motPass = motPass;
	}
	public Etudiant(String cneE, String motPass) {
		super();
		this.cneE = cneE;
		this.motPass = motPass;
	}
	public String getIdE() {
		return idE;
	}
	public void setIdE(String idE) {
		this.idE = idE;
	}
	public String getNomE() {
		return nomE;
	}
	public void setNomE(String nomE) {
		this.nomE = nomE;
	}
	public String getPrenomE() {
		return prenomE;
	}
	public void setPrenomE(String prenomE) {
		this.prenomE = prenomE;
	}
	public String getFiliereE() {
		return filiereE;
	}
	public void setFiliereE(String filiereE) {
		this.filiereE = filiereE;
	}
	public String getNiveauE() {
		return niveauE;
	}
	public void setNiveauE(String niveauE) {
		this.niveauE = niveauE;
	}
	public String getCneE() {
		return cneE;
	}
	public void setCneE(String cneE) {
		this.cneE = cneE;
	}
	public String getEmailE() {
		return emailE;
	}
	public void setEmailE(String emailE) {
		this.emailE = emailE;
	}
	
	public String getMotPass() {
		return motPass;
	}
	public void setMotPass(String motPass) {
		this.motPass = motPass;
	}
	@Override
	public String toString() {
		return "Etudiant [idE=" + idE + ", nomE=" + nomE + ", prenomE=" + prenomE + ", filiereE=" + filiereE
				+ ", niveauE=" + niveauE + ", cneE=" + cneE + ", emailE=" + emailE + ", motPass=" + motPass + "]";
	}
	
	
	
	

}
