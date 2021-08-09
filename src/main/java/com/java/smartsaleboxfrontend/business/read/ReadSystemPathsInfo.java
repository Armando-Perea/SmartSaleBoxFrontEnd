package com.java.smartsaleboxfrontend.business.read;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.SystemPathsClient;
import com.java.smartsalebox.models.SystemPaths;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;
import com.java.smartsaleboxfrontend.utils.SmartSaleBoxClearFields;

public class ReadSystemPathsInfo {
	
	private static final String SYSTEM_PATH_NOT_FOUND = "Path no existe";
	private static final String VALIDATION_UPDATE_TITLE = "Validación";
	
	public static void getAllSystemPathsTable() {
		SystemPaths[] systemPaths;
		try {
			systemPaths = SystemPathsClient.getAllSystemPaths();
			if(systemPaths.length>0) {
				SmartSaleBoxMain.tableModelPaths.setRowCount(0);
				for (SystemPaths systemPat : systemPaths) {
					Object[] systemP = {systemPat.getIdPath(),systemPat.getClosurePdf(),systemPat.getInflowsPdf(),
							systemPat.getOutflowsPdf(),systemPat.getProductEarningsPdf(),systemPat.getProductsPdf(),systemPat.getSalesPdf()};
					SmartSaleBoxMain.tableModelPaths.addRow(systemP);
				}
				SmartSaleBoxMain.scrollPaths.setViewportView(SmartSaleBoxMain.tblPaths);
			}else {
				JOptionPane.showMessageDialog(null,SYSTEM_PATH_NOT_FOUND,VALIDATION_UPDATE_TITLE, JOptionPane.INFORMATION_MESSAGE);
				SmartSaleBoxClearFields.clearEmailProcess();
			}
		}catch(Exception ex) {
			System.out.println("getAllSystemPathsTable error catch: "+ex);
			SmartSaleBoxClearFields.clearEmailProcess();
		}
	}

}
