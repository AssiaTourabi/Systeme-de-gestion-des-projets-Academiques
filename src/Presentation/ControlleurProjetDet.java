package Presentation;

import javax.swing.JFrame;

import Metier.Etudiant;
import Metier.Projet;

public class ControlleurProjetDet {
	
		private FenetreProjetDet fenetreProj;
		private Projet projet;
		
		public ControlleurProjetDet() {
			super();
		}
		public void demmarrerApplication(Projet projet,Etudiant etudiant) {
			this.fenetreProj= new FenetreProjetDet(this,projet, etudiant);
			//this.fenetreProj.pack();
			this.fenetreProj.setExtendedState(JFrame.MAXIMIZED_BOTH);
			this.fenetreProj.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.fenetreProj.setVisible(true);
		}
}
