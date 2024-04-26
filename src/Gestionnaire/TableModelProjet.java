
	package Gestionnaire;

	import java.util.ArrayList;

	import javax.swing.table.AbstractTableModel;

    import Metier.Projet;

	public class TableModelProjet  extends AbstractTableModel {
		public ArrayList<Projet> liste;
		

		public TableModelProjet(ArrayList<Projet> liste) {
			super();
			this.liste = liste;
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return liste.size();
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 11;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			switch (columnIndex){
			case 0 : return this.liste.get(rowIndex).getIdProjet() ;
			case 1 : return this.liste.get(rowIndex).getTitreProjet(); 
			case 2 : return this.liste.get(rowIndex).getDatefinProjet(); 
			case 3 : return this.liste.get(rowIndex).getDatedebutProjet();
			case 4 : return this.liste.get(rowIndex).getDuréeProjet();
			case 5 : return this.liste.get(rowIndex).getProjetType(); 
			case 6 : return this.liste.get(rowIndex).getIdEncadrant1(); 
			case 7 : return this.liste.get(rowIndex).getIdEncadrant2(); 
			case 8 : return this.liste.get(rowIndex).getIdEtudiant();
			case 9 : return this.liste.get(rowIndex).getRaisonSocial();
			case 10 : return this.liste.get(rowIndex).getIdLaboratoire(); 
			
			
			
			default : return null;
		}
			
		}
		@Override
		public String getColumnName(int columnIndex) {
			switch (columnIndex){
			case 0 : return "id projet"; 
			case 1 : return "titre projet"; 
			case 2 : return "date final"; 
			case 3 : return "date de debut"; 
			case 4 : return "durée projet" ; 
			case 5 : return "type de projet"; 
			case 6 : return "encadrant 1"; 
			case 7 : return "encadrant 1"; 
			case 8 : return "etudiant"; 
			case 9 : return "raison social" ; 
			case 10 : return "Laboratoire" ; 
			
			default : return "Object";
			}
		}
		@Override
		public Class getColumnClass(int columnIndex) {
			switch (columnIndex){
			case 0 : return String.class; 
			case 1 : return String.class;
			case 2 : return String.class;
			case 3 : return String.class;
			case 4 : return String.class;
			case 5 : return String.class; 
			case 6 : return String.class;
			case 7 : return String.class;
			case 8 : return String.class;
			case 9 : return String.class;
			case 10 : return String.class;
			default : return Object.class;
			}
		}

	}


