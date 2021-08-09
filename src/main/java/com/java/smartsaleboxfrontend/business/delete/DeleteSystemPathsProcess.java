package com.java.smartsaleboxfrontend.business.delete;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.SystemPathsClient;
import com.java.smartsaleboxfrontend.business.read.ReadSystemPathsInfo;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;

public class DeleteSystemPathsProcess {
	
	private static final String PATH_DELETED = "Path ha sido borrado!";
	private static final String SELECT_PATH = "Seleccione un path a eliminar por favor";
	
	public static void removeSelectedPath() {
		int row;
		int idPath;
		int status=0;
		row = SmartSaleBoxMain.tblPaths.getSelectedRow();
		if (row > -1) {
			idPath = Integer.parseInt(SmartSaleBoxMain.tblPaths.getValueAt(row, 0).toString());
			status = SystemPathsClient.deleteSystemPath(idPath);
			if(status >=200 && status < 400) {
				SmartSaleBoxMain.tableModelPaths.setRowCount(0);
				ReadSystemPathsInfo.getAllSystemPathsTable();
				JOptionPane.showMessageDialog(null, PATH_DELETED,"Advertencia", JOptionPane.WARNING_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, SELECT_PATH,"Advertencia", JOptionPane.WARNING_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, SELECT_PATH,"Advertencia", JOptionPane.WARNING_MESSAGE);
		}
	}

}
