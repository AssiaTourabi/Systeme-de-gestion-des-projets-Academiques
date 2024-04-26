package Gestionnaire;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Metier.Etudiant;

public class TabeleModelEtudiant extends AbstractTableModel {

	private ArrayList<Etudiant> liste;

	public TabeleModelEtudiant(ArrayList<Etudiant> liste) {
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
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex) {
		case 0:
			return this.liste.get(rowIndex).getNomE();
		case 1:
			return this.liste.get(rowIndex).getPrenomE();
		case 2:
			return this.liste.get(rowIndex).getFiliereE();
		case 3:
			return this.liste.get(rowIndex).getCneE();
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
			return "Prenom";
		case 2:
			return "filiere";
		case 3:
			return "Cne";

		}
		return null;
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

		}
		return null;
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex == 2)
			return true;
		return false;
	}
}
