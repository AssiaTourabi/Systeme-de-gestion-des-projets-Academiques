package Presentation;

import javax.swing.JFrame;

import Gestionnaire.EtudiantGestionnaire;
import Gestionnaire.GestionnaireProjet;
import Metier.Etudiant;
import Metier.Projet;


public class ControlleurProjetButtons {
	private FenetreProjetsButtons fenetreProj;
	private Projet projet;
	ControlleurProjetDet contrPrDet=new ControlleurProjetDet();
	public ControlleurProjetButtons() {
		super();
	}
	public void demmarrerApplication(Etudiant etudiant) {
		this.fenetreProj= new FenetreProjetsButtons(this,etudiant);
		//this.fenetreProj.pack();
		this.fenetreProj.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.fenetreProj.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.fenetreProj.setVisible(true);
	}
	public boolean affichetDoctorat(Etudiant  etudiant) {
       String idEt;
		
		
		
		EtudiantGestionnaire gesE=new EtudiantGestionnaire();
		idEt=gesE.getEtudiantByCNE(etudiant.getCneE());
		
		GestionnaireProjet gespro=new GestionnaireProjet();
		Projet projet= new Projet();
		
		projet=gespro.readProjetById(idEt);
		System.out.print(projet.getProjetType());
		if(((projet.getProjetType()).toString()).equals("doctorat")) {
			
		contrPrDet.demmarrerApplication(projet,etudiant);
		return true;}
		return false;
		
		}
	public boolean affichetPfa(Etudiant  etudiant) {
	       String idEt;
			
			
			
			EtudiantGestionnaire gesE=new EtudiantGestionnaire();
			idEt=gesE.getEtudiantByCNE(etudiant.getCneE());
			
			GestionnaireProjet gespro=new GestionnaireProjet();
			Projet projet= new Projet();
			
			projet=gespro.readProjetById(idEt);
			System.out.print(projet.getProjetType());
			if(((projet.getProjetType()).toString()).equals("pfa")) {
				
			contrPrDet.demmarrerApplication(projet,etudiant);
			return true;}
			return false;
			
			}
	public boolean affichetPfe(Etudiant  etudiant) {
	       String idEt;
			
			
			
			EtudiantGestionnaire gesE=new EtudiantGestionnaire();
			idEt=gesE.getEtudiantByCNE(etudiant.getCneE());
			
			GestionnaireProjet gespro=new GestionnaireProjet();
			Projet projet= new Projet();
			
			projet=gespro.readProjetById(idEt);
			System.out.print(projet.getProjetType());
			if(((projet.getProjetType()).toString()).equals("pfe")) {
				
			contrPrDet.demmarrerApplication(projet,etudiant);
			return true;}
			return false;
			
			}
}
