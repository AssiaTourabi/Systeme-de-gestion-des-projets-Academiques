package Metier;

public class chef_de_departement extends professeur {
	private double ID_chef;

	public double getID_chef() {
		return ID_chef;
	}

	public void setID_chef(double iD_chef) {
		ID_chef = iD_chef;
	}

	public chef_de_departement(String nom_prof, String prenm_prof, String depart_prof, String email_prof, String grade,
			String Etat, String N_somme, double ID_chef, String mdp_prof, String fonctionnalite) {
		super(nom_prof, prenm_prof, depart_prof, email_prof, grade, Etat, N_somme, mdp_prof, fonctionnalite);
		this.ID_chef = ID_chef;

	}

	public chef_de_departement() {
		super();

	}

}
