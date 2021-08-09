package com.java.smartsaleboxfrontend.business.read;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.AdministratorClient;
import com.java.smartsalebox.models.Administrator;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;
import com.java.smartsaleboxfrontend.utils.SmartSaleBoxClearFields;

public class ReadAdminInfo {
	
	private static final String ADMIN_NOT_FOUND = "Administrador no existe";
	private static final String VALIDATION_UPDATE_TITLE = "Validación";
	
	public static void getAllAdminTable() {
		Administrator[] admin;
		try {
			admin = AdministratorClient.getAllAdmins();
			if(admin.length>0) {
				SmartSaleBoxMain.tableModelAdmin.setRowCount(0);
				for (Administrator adm : admin) {
					Object[] adminItems = {adm.getIdAdministrator(),adm.getAdminName(),adm.getAdminLastName(),adm.getAdminPhone(),adm.getAdminRole()};
					SmartSaleBoxMain.tableModelAdmin.addRow(adminItems);
				}
				SmartSaleBoxMain.scrollAdmin.setViewportView(SmartSaleBoxMain.tblAdmin);
			}else {
				JOptionPane.showMessageDialog(null,ADMIN_NOT_FOUND,VALIDATION_UPDATE_TITLE, JOptionPane.INFORMATION_MESSAGE);
				SmartSaleBoxClearFields.clearSaleMain();
			}
		}catch(Exception ex) {
			System.out.println("getAllAdminTable error catch: "+ex);
			SmartSaleBoxClearFields.clearAdminProcess();
		}
	}

}
