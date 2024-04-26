package Gestionnaire;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Metier.Filiere;

public class TableModeleFiliere extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ArrayList<Filiere> liste;

	public TableModeleFiliere(ArrayList<Filiere> liste) {
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
		return 2;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return this.liste.get(rowIndex).getNom_Filiere();
		case 1:
			return this.liste.get(rowIndex).getEmail_Filiere();

		default:
			return null;
		}

	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "Nom";
		case 1:
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

		default:
			return Object.class;
		}
	}

}
