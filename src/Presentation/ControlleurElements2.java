package Presentation;

import javax.swing.JFrame;

import Metier.Projet;

public class ControlleurElements2 {
	private FenetreElemets2 fenetreElm2;
	private Projet projet;

	public ControlleurElements2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void demmarrerApplication() {
		this.fenetreElm2 = new FenetreElemets2(this);
		this.fenetreElm2.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.fenetreElm2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.fenetreElm2.setVisible(true);
	}
}
