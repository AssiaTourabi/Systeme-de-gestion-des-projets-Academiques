package Gestionnaire;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Metier.departement;

public class TableModeleDepart extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ArrayList<departement> liste;

	public TableModeleDepart(ArrayList<departement> liste) {
		super();
		this.liste = liste;

	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.liste.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return this.liste.get(rowIndex).getCode_depart();
		case 1:
			return this.liste.get(rowIndex).getNom_dep();
		case 2:
			return this.liste.get(rowIndex).getEmail_dep();

		default:
			return null;
		}

	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "Code";
		case 1:
			return "Nom";
		case 2:
			return "Email";

		default:
			return "Object";
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return Integer.class;
		case 1:
			return String.class;
		case 2:
			return String.class;

		default:
			return Object.class;
		}
	}

}
