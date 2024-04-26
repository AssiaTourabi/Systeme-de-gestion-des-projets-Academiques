package Gestionnaire;

import java.util.ArrayList;

import Metier.Etudiant;
import Persistance.DaoEtudiant;

public class EtudiantGestionnaire {
	private static final String String = null;
	private DaoEtudiant etud;

	public EtudiantGestionnaire(DaoEtudiant etud) {
		super();
		this.etud = etud;
	}

	public EtudiantGestionnaire() {
		super();
		etud = new DaoEtudiant();
	}

	public boolean insertEtudiant(Etudiant e) throws ClassNotFoundException {
		return etud.insertEtudiant(e);
	}

	public boolean deleteEtudiant(String idE) {
		return etud.deleteEtudiant(idE);
	}

	public boolean updateEtudiant(String idE, String nomE, String prenomE, String niveauE, String filiereE,
			String emailE, String cneE, String motPasse) {
		return etud.updateEtudiant(idE, nomE, prenomE, niveauE, filiereE, emailE, cneE, motPasse);
	}

	public Etudiant getEtudiantByIde(String idE) {
		return etud.getEtudiantByIde(idE);
	}

	public ArrayList getEtudiants() {
		return etud.getEtudiants();
	}

	public String getEtudiantByCNE(String cne) {
		return etud.getEtudiantByCNE(cne);
	}

	public long NumberofStudent() {
		return etud.NumberofStudent();
	}
}
