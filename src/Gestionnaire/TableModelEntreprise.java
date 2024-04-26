package Gestionnaire;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Metier.Entreprise;

public class TableModelEntreprise extends AbstractTableModel {
	public ArrayList<Entreprise> liste;

	public TableModelEntreprise(ArrayList<Entreprise> liste) {
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
		return 5;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return this.liste.get(rowIndex).getRaisonSocial();
		case 1:
			return this.liste.get(rowIndex).getResponsableEntreprise();
		case 2:
			return this.liste.get(rowIndex).getAdresseEntreprise();
		case 3:
			return this.liste.get(rowIndex).getEmailEntreprise();
		case 4:
			return this.liste.get(rowIndex).getTelephoneEntreprise();

		default:
			return null;
		}

	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "Raison Social";
		case 1:
			return "Responsable";
		case 2:
			return "Adresse d'entreprise";
		case 3:
			return "Email d'entreprise";
		case 4:
			return "Numero de telephone";
		default:
			return "Object";
		}
	}

	@Override
	public Class getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return String.class;
		case 1:
			return String.class;
		case 2:
			return String.class;
		case 3:
			return String.class;
		case 4:
			return String.class;
		default:
			return Object.class;
		}
	}

}
