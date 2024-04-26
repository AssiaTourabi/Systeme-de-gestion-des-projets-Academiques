package Presentation;

import javax.swing.JFrame;

import Metier.Projet;

public class ControlleurElements {
	private FenetreElements fenetreElm;
	private Projet projet;

	public ControlleurElements() {
		super();
	}

	public void demmarrerApplication() {
		this.fenetreElm = new FenetreElements(this);
		this.fenetreElm.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.fenetreElm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.fenetreElm.setVisible(true);
	}
}
