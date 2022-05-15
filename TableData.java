package autotrade;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class TableData extends DefaultTableModel {

	JTable table;
	JScrollPane scrollPane;
	ArrayList<String> columnName = new ArrayList<String>();

	TableData() {

	}

	TableData(String[] columnName) {
		super(columnName, 0);
		for (int i = 0; i < columnName.length; i++) {
			this.columnName.add(columnName[i]);
		}

		table = new JTable(this);
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400, 200));

	}

	TableData(String[][] data_item, ArrayList<String> header) {
		// TODO Auto-generated constructor stub
		super(data_item, header.toArray());
//		JTable table = new JTable(data_item, header.toArray());
		table = new JTable(this);
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400, 200));
		
		
//		panel.add(scrollPane);

	}

	public ArrayList<String> getHeader() {
		return columnName;
	}

	public void addColumn(String name, Vector<String> data) {
		if (findColumn(name) == -1) {
			super.addColumn(name, data);
			columnName.add(name);
		} else {
			int col = super.findColumn(name);
			for (int i = 0; i < this.getRowCount(); i++) {
				this.setValueAt(data.get(i), i, col);
//				System.out.println(this.getDataVector().get(i));
			}

		}
//		System.out.println(getHeader());
//		
	}

	public DefaultTableModel getModel() {
		return this;
	}

	public JScrollPane getScroll() {
		return scrollPane;
	}

	public void clear() {
		if (this.getRowCount() > 0) {
			for (int i = this.getRowCount() - 1; i > -1; i--) {
				this.removeRow(i);
			}
		}
	}

	public void setScrollToTop() {
		scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMinimum());
	}

	public void setScrollToButtom() {
		scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
	}
}
