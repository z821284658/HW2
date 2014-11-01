import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String[] columnNames = { "text", "user_name", "user_id" };
		ArrayList<Tuple_info> list = null;

		TableModel(ArrayList<Tuple_info> list) {
			this.list = list;
		}

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return list.size();
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

		public Object getValueAt(int row, int col) {

			Tuple_info object = list.get(row);

			switch (col) {
				case 0:
					return object.getText();
				case 1:
					return object.getUser_name();
				case 2:
					return object.getUser_id();
     	   		default:
     	   			return "unknown";
			}
		}

	}
