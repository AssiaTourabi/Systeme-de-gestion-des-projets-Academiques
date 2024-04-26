package Presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Gestionnaire.EtapeGestionnaires;
import Metier.Etape;

public class FenetreEtape extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel idetape;
	private JLabel livraison;
	private JLabel documentation;
	private JLabel etapeDateDepar;
	private JLabel durée;
	private JLabel etapeNom;

	private JTextField idetapeTexte;
	private JTextField livraisonTexte;
	private JTextField documentationTexte;
	private JTextField etapeDateDeparTexte;
	private JTextField duréeTexte;
	private JTextField etapeNomTexte;

	private JButton Supprime;
	private JButton updateNom;
	private JButton ajouter;
	private JButton afficherTout;
	private FenetreDepart fenetreDep;
	private ControlleurEtape controlleur;
	private EtapeGestionnaires etape;

	private JTextField field1 = new JTextField();
	private JTextField field2 = new JTextField();
	private JPanel panel = new JPanel(new GridLayout(2, 2));

	public FenetreEtape(ControlleurEtape c) throws HeadlessException, SQLException {
		super();
		this.initialiser();
		this.dessiner();
		this.action();
		this.controlleur = c;
	}

	public FenetreEtape(ControlleurEtape c, Etape e) throws HeadlessException, SQLException {
		this(c);
		this.etapeNom.setText(e.getEtapeNom());
		this.durée.setText(e.getDurée());

	}

	private void initialiser() throws SQLException {

		idetape = new JLabel("idetape :");
		livraison = new JLabel("livraison :");
		documentation = new JLabel("documentation :");
		etapeDateDepar = new JLabel("etape Date de Depart :");
		durée = new JLabel("durée :");
		etapeNom = new JLabel("etapeNom :");

		idetapeTexte = new JTextField(45);
		livraisonTexte = new JTextField(45);
		documentationTexte = new JTextField(45);
		etapeDateDeparTexte = new JTextField(45);
		duréeTexte = new JTextField(45);
		etapeNomTexte = new JTextField(45);

		Supprime = new JButton("Supprimer par nom");
		updateNom = new JButton("update nom");
		ajouter = new JButton("ajouter");
		afficherTout = new JButton("Afficher Tout");
		panel.add(new JLabel("Old one:"));
		panel.add(new JLabel("New one:"));

	}

	private void dessiner() {

//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panelNord = new JPanel();
		panelNord.setLayout(new GridLayout(3, 3));
		panelNord.add(idetape);
		panelNord.add(idetapeTexte);
		panelNord.add(livraison);
		panelNord.add(livraisonTexte);
		panelNord.add(documentation);
		panelNord.add(documentationTexte);
		panelNord.add(etapeDateDepar);
		panelNord.add(etapeDateDeparTexte);
		panelNord.add(durée);
		panelNord.add(duréeTexte);
		panelNord.add(etapeNom);
		panelNord.add(etapeNomTexte);

		panelNord.setBackground(Color.LIGHT_GRAY);
		JPanel panelSud = new JPanel();
		panelSud.add(ajouter);
		panelSud.add(Supprime);
		panelSud.add(updateNom);
		panelSud.add(afficherTout);
		panelSud.setBackground(Color.gray);

		this.setLayout(new BorderLayout());
		this.add(panelSud, BorderLayout.CENTER);
		this.add(panelNord, BorderLayout.NORTH);
		// this.add(panelOuest, BorderLayout.WEST);
		this.setPreferredSize(new Dimension(1400, 1000));
		panel.add(field1);
		panel.add(field2);

	}

	public void action() {

	}

}