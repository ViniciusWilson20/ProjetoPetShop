package com.curso.entity;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {

	@Override
	public int getColumnCount() {
		return 0;
	}

	@Override
	public String getColumnName(int column) {

		return super.getColumnName(column);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return super.getColumnClass(columnIndex);
	}

	@Override
	public int getRowCount() {
		return 0;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		return null;
	}

}
