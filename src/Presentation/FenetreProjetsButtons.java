package Presentation;








	import java.awt.EventQueue;

	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;

import Metier.Etudiant;

import java.awt.Color;
	import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
	import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
	import javax.swing.JTextField;

	
		public class FenetreProjetsButtons extends JFrame {

			private JPanel jpane ;
			private JLabel titrLabel;
			private JButton doctoratBtn;
			private JButton prFDBtn ;
			private JButton prFEBtn;
			
			
				private ControlleurProjetButtons controlleur;
				
				public  FenetreProjetsButtons (ControlleurProjetButtons  c,Etudiant etudiant) throws HeadlessException {
					super();
					this.initialiser();
					this.dessiner();
					this.action(etudiant);
					this.controlleur = c;	
				}
				 
					
				private void initialiser() {
					//ImageIcon leftIcon = new ImageIcon("images/tpReseau.png");
					
					jpane= new JPanel();
					doctoratBtn = new JButton("Doctorat");
					 prFDBtn = new JButton("projet fin d'année");
					 prFEBtn = new JButton("Projet fin d'etudes");
					 titrLabel = new JLabel("Votre Projets");
						
				}
				private void dessiner() {
					
					setTitle("Projets");
					setBackground(new Color(98, 80, 197));
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					setBounds(100, 100, 450, 300);
					
					jpane.setBackground(new Color(255, 255, 255));
					jpane.setBorder(new EmptyBorder(5, 5, 5, 5));

					setContentPane(jpane);
					jpane.setLayout(null);
					
					
					 titrLabel.setForeground(new Color(128, 0, 255));
					 titrLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
					 titrLabel.setBounds(10, 31, 424, 14);
					jpane.add(titrLabel);
					
					
					doctoratBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
					doctoratBtn.setForeground(new Color(255, 255, 255));
					doctoratBtn.setBackground(new Color(128, 0, 255));
					
					doctoratBtn.setBounds(470, 200, 246, 53);
					jpane.add(doctoratBtn);
					
					 
					 prFDBtn.setForeground(new Color(255, 255, 255));
					 prFDBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
					 prFDBtn.setBackground(new Color(128, 0, 255));
					 prFDBtn.setBounds(470, 300, 246, 53);
					jpane.add(prFDBtn);
					
					 
					 prFEBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
					 prFEBtn.setForeground(new Color(255, 255, 255));
					 prFEBtn.setBackground(new Color(128, 0, 255));
					 prFEBtn.setBounds(470, 400, 246, 53);
					jpane.add( prFEBtn);
					
				}
				
				public void action(Etudiant etudiant) {
					doctoratBtn.addActionListener(new  ActionListener () {

						@Override
						public void actionPerformed(ActionEvent e) {
							ControlleurProjetButtons contProjButt=new ControlleurProjetButtons();
							if(!(contProjButt.affichetDoctorat(etudiant)))
							{JOptionPane.showMessageDialog(doctoratBtn, "Vous n'avez aucun projet Doctorat");}
						}
						
						
					});
					prFDBtn.addActionListener(new  ActionListener () {

						@Override
						public void actionPerformed(ActionEvent e) {
							ControlleurProjetButtons contProjButt=new ControlleurProjetButtons();
							if(!(contProjButt.affichetPfa(etudiant)))
							{JOptionPane.showMessageDialog(doctoratBtn, "Vous n'avez aucun projet Pfa");}
						}
						
						
					});
					prFEBtn.addActionListener(new  ActionListener () {

						@Override
						public void actionPerformed(ActionEvent e) {
							ControlleurProjetButtons contProjButt=new ControlleurProjetButtons();
							if(!(contProjButt.affichetPfe(etudiant)))
							{JOptionPane.showMessageDialog(doctoratBtn, "Vous n'avez aucun projet Pfe");}
						}
						
						
					});
					

					}

			}




