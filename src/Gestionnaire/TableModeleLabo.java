package Gestionnaire;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Metier.Labo;

public class TableModeleLabo extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ArrayList<Labo> liste;

	public TableModeleLabo(ArrayList<Labo> liste) {
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
			return this.liste.get(rowIndex).getN_Labo();
		case 1:
			return this.liste.get(rowIndex).getNom_Labo();
		case 2:
			return this.liste.get(rowIndex).getEmail_Labo();

		default:
			return null;
		}

	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "Id Labo";
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
			return String.class;
		case 1:
			return String.class;
		case 2:
			return String.class;

		default:
			return Object.class;
		}
	}

}
