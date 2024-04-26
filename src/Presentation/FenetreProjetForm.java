package Presentation;






	import java.awt.EventQueue;

	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
	import java.awt.Color;
	import javax.swing.JLabel;
	import java.awt.Font;
	import java.awt.HeadlessException;

	import javax.swing.JButton;
	import javax.swing.JTextField;

	
		public class FenetreProjetForm extends JFrame {

			private JPanel contentPane;
			private JTextField ddText;
			private JTextField idtextField;
			private JTextField titreTextField;
			private JTextField textField;
			private JTextField textField_1;
			private JTextField typeTextField;
			private JTextField etudiantTextField;
			private JTextField encadrant1TextField;
			private JTextField encadrant2TextField;
			private JTextField entrepriseTextField;
			private JTextField laboTextField;
			private JLabel OperatLabel ;
			private JLabel titreLabel ;
			private JLabel idProjetLabel;
		
			
			private JLabel DateFLabel;
			
			private JLabel dureeLabel ;
			
			private JLabel typeLabel ;
			
			private JLabel etudiantLabel;
			
			private JLabel encadrant1;
			
			private JLabel encadrant2;
			
			private JLabel entrepriseLabel;
			private JLabel laboratoireLabel;
			private JLabel DateDLabel;
			private JButton precedentBtn ;
			private JButton ajouterBtn ;
			private JButton modifierBtn ;
			
			private JButton supprimerBtn;
			
			private JButton afficherBtn;
				private ControlleurProjet controlleur;
				
				public  FenetreProjetForm (ControlleurProjet  c) throws HeadlessException {
					super();
					this.initialiser();
					this.dessiner();
					this.action();
					this.controlleur = c;	
				}
				 
					
				private void initialiser() {
					//ImageIcon leftIcon = new ImageIcon("images/tpReseau.png");
					
					OperatLabel= new JLabel("Operation sur projet");
					precedentBtn = new JButton("precedent");
					titreLabel = new JLabel("Titre:");
					idProjetLabel = new JLabel("id de projet:");
					 DateDLabel = new JLabel("Date de Debut:");
					 DateFLabel= new JLabel("Date de fin:");
					 dureeLabel = new JLabel("Durée:");
					 typeLabel = new JLabel("Type:");
					 etudiantLabel = new JLabel("Etudiant:");
					 encadrant1 = new JLabel("Professeur encadrant 1:");
					 encadrant2 = new JLabel("Professeur encadrant 2:");
					 entrepriseLabel = new JLabel("Entreprise:");
					 laboratoireLabel = new JLabel("Laboratoire:");
					 ddText = new JTextField();
						
						idtextField = new JTextField();
						
						
						titreTextField = new JTextField();
						
						textField = new JTextField();
						
						textField_1 = new JTextField();
						
					
						
						typeTextField = new JTextField();
						
						
						etudiantTextField = new JTextField();
						
						
						encadrant1TextField = new JTextField();
						
						
						encadrant2TextField = new JTextField();
						
						
						entrepriseTextField = new JTextField();
						
						laboTextField = new JTextField();
						
						 ajouterBtn = new JButton("Ajouter");
						
						
						 modifierBtn = new JButton("Modifier");
						
						 supprimerBtn = new JButton("Supprimer");
						
						
						JButton afficherBtn = new JButton("Afficher");
						
				}
				private void dessiner() {
					
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					setBounds(450,190,2500,700);
					//setBounds(100, 100, 450, 300);
					contentPane = new JPanel();
					contentPane.setBackground(new Color(255, 255, 255));
					contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

					setContentPane(contentPane);
					contentPane.setLayout(null);
					
					JPanel panel = new JPanel();
					panel.setBackground(new Color(128, 0, 255));
					panel.setBounds(0, 39, 1370, 25);
					contentPane.add(panel);
					
					
					OperatLabel .setFont(new Font("Tahoma", Font.BOLD, 16));
					OperatLabel .setForeground(new Color(255, 255, 255));
					panel.add(OperatLabel );
					
					
					precedentBtn.setBackground(new Color(128, 0, 255));
					precedentBtn.setForeground(new Color(255, 255, 255));
					precedentBtn.setBounds(10, 11, 89, 23);
					contentPane.add(precedentBtn);
					
					
					titreLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
					titreLabel.setBounds(353, 140, 46, 14);
					contentPane.add(titreLabel);
					
					
					idProjetLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
					idProjetLabel.setBounds(353, 90, 83, 14);
					contentPane.add(idProjetLabel);
					
					
					DateDLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
					DateDLabel.setBounds(353, 190, 107, 14);
					contentPane.add(DateDLabel);
					
					
					DateFLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
					DateFLabel.setBounds(353, 258, 83, 14);
					contentPane.add(DateFLabel);
					
					
					dureeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
					dureeLabel.setBounds(353, 308, 46, 25);
					contentPane.add(dureeLabel);
					
					
					typeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
					typeLabel.setBounds(353, 356, 83, 25);
					contentPane.add(typeLabel);
					
					
					etudiantLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
					etudiantLabel.setBounds(353, 411, 83, 14);
					contentPane.add(etudiantLabel);
					
					
					encadrant1.setFont(new Font("Tahoma", Font.BOLD, 13));
					encadrant1.setBounds(353, 451, 165, 25);
					contentPane.add(encadrant1);
					
					
					encadrant2.setFont(new Font("Tahoma", Font.BOLD, 13));
					encadrant2.setBounds(353, 503, 165, 25);
					contentPane.add(encadrant2);
					
					
					entrepriseLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
					entrepriseLabel.setBounds(353, 550, 107, 24);
					contentPane.add(entrepriseLabel);
					
				
					laboratoireLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
					laboratoireLabel.setBounds(353, 596, 107, 14);
					contentPane.add(laboratoireLabel);
					
					ddText = new JTextField();
					ddText.setBounds(592, 188, 137, 20);
					contentPane.add(ddText);
					ddText.setColumns(10);
					
					idtextField = new JTextField();
					idtextField.setBounds(585, 89, 144, 20);
					contentPane.add(idtextField);
					idtextField.setColumns(10);
					
					titreTextField = new JTextField();
					titreTextField.setBounds(585, 139, 144, 20);
					contentPane.add(titreTextField);
					titreTextField.setColumns(10);
					
					textField = new JTextField();
					textField.setBounds(592, 244, 137, 20);
					contentPane.add(textField);
					textField.setColumns(10);
					
					textField_1 = new JTextField();
					textField_1.setBounds(592, 312, 137, 20);
					contentPane.add(textField_1);
					textField_1.setColumns(10);
					
					typeTextField = new JTextField();
					typeTextField.setBounds(592, 360, 137, 20);
					contentPane.add(typeTextField);
					typeTextField.setColumns(10);
					
					etudiantTextField = new JTextField();
					etudiantTextField.setBounds(589, 410, 140, 20);
					contentPane.add(etudiantTextField);
					etudiantTextField.setColumns(10);
					
					encadrant1TextField = new JTextField();
					encadrant1TextField.setBounds(592, 454, 137, 20);
					contentPane.add(encadrant1TextField);
					encadrant1TextField.setColumns(10);
					
					encadrant2TextField = new JTextField();
					encadrant2TextField.setBounds(592, 506, 137, 20);
					contentPane.add(encadrant2TextField);
					encadrant2TextField.setColumns(10);
					
					entrepriseTextField = new JTextField();
					entrepriseTextField.setBounds(592, 554, 137, 20);
					contentPane.add(entrepriseTextField);
					entrepriseTextField.setColumns(10);
					
					laboTextField = new JTextField();
					laboTextField.setBounds(592, 595, 137, 20);
					contentPane.add(laboTextField);
					laboTextField.setColumns(10);
					
					JButton ajouterBtn = new JButton("Ajouter");
					ajouterBtn.setBounds(957, 287, 137, 23);
					contentPane.add(ajouterBtn);
					
					JButton modifierBtn = new JButton("Modifier");
					modifierBtn.setBounds(957, 359, 137, 23);
					contentPane.add(modifierBtn);
					
					JButton supprimerBtn = new JButton("Supprimer");
					supprimerBtn.setBounds(957, 440, 137, 23);
					contentPane.add(supprimerBtn);
					
					JButton afficherBtn = new JButton("Afficher");
					afficherBtn.setBounds(957, 505, 137, 23);
					contentPane.add(afficherBtn);
					
				}
				
				public void action() {
					
				}

			}




