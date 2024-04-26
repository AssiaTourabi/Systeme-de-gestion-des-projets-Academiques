package Presentation;

import java.util.ArrayList;

import javax.swing.JFrame;

import Gestionnaire.EtudiantGestionnaire;
import Gestionnaire.GestionEntreprise;
import Gestionnaire.GestionProfesseur;
import Gestionnaire.GestionnaireProjet;
import Metier.Entreprise;
import Metier.Etudiant;
import Metier.Projet;
import Metier.professeur;

public class Controlleurlogin {

	private FenetreProjetDet fentPrD;
	private FentreLogin fenetreLog;
	private Entreprise entreprise;
	private GestionEntreprise entre;

	public Controlleurlogin() {
		super();

	}

	public void demmarrerApplication() {

		this.fenetreLog = new FentreLogin(this);
		this.fenetreLog.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.fenetreLog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.fenetreLog.setVisible(true);

	}

	public void afficherProjerDetail(Etudiant etudiant) {
		String idEt;

		this.fenetreLog.dispose();

		EtudiantGestionnaire gesE = new EtudiantGestionnaire();
		idEt = gesE.getEtudiantByCNE(etudiant.getCneE());
		GestionnaireProjet gespro = new GestionnaireProjet();
		Projet projet = new Projet();
		projet = gespro.readProjetById(idEt);
		ControlleurProjetDet contrPrDet = new ControlleurProjetDet();

		contrPrDet.demmarrerApplication(projet, etudiant);

		this.fenetreLog.setVisible(true);
	}

	public boolean login(Etudiant etud) {
		EtudiantGestionnaire gesEtud = new EtudiantGestionnaire();
		ArrayList<Etudiant> listeEtudiant = new ArrayList<Etudiant>();
		listeEtudiant = gesEtud.getEtudiants();

		for (Etudiant etudint : listeEtudiant) {
			if (etudint.getCneE().equals(etud.getCneE()) && etudint.getMotPass().equals(etud.getMotPass())) {

				return true;
			}
		}

		return false;

	}

	public boolean loginProf(professeur p) {
		GestionProfesseur gp = new GestionProfesseur();
		ArrayList<professeur> list = new ArrayList<professeur>();
		list = gp.getAll();

		for (professeur prof : list) {
			if (prof.getN_somme().equals(p.getN_somme()) && prof.getMdp_prof().equals(p.getMdp_prof())) {
				return true;
			}
		}

		return false;

	}

	public professeur loginInfo(professeur p) {
		GestionProfesseur gp = new GestionProfesseur();
		ArrayList<professeur> list = new ArrayList<professeur>();
		list = gp.getAll();

		for (professeur prof : list) {
			if (prof.getN_somme().equals(p.getN_somme()) && prof.getMdp_prof().equals(p.getMdp_prof())) {

				return prof;
			}
		}

		return null;

	}

}
