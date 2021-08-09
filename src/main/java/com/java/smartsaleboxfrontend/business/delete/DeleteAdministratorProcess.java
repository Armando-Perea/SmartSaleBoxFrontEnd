package com.java.smartsaleboxfrontend.business.delete;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.AdministratorClient;
import com.java.smartsaleboxfrontend.business.read.ReadAdminInfo;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;

public class DeleteAdministratorProcess {
	
	private static final String ADMIN_DELETED = "Administrador ha sido borrado!";
	private static final String SELECT_ADMIN = "Seleccione un administrador a eliminar por favor";
	
	public static void removeSelectedAdmin() {
		int row;
		int idAdmin;
		int status=0;
		row = SmartSaleBoxMain.tblAdmin.getSelectedRow();
		if (row > -1) {
			idAdmin = Integer.parseInt(SmartSaleBoxMain.tblAdmin.getValueAt(row, 0).toString());
			status = AdministratorClient.deleteAdmin(idAdmin);
			if(status >=200 && status < 400) {
				SmartSaleBoxMain.tableModelAdmin.setRowCount(0);
				ReadAdminInfo.getAllAdminTable();
				JOptionPane.showMessageDialog(null, ADMIN_DELETED,"Advertencia", JOptionPane.WARNING_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, SELECT_ADMIN,"Advertencia", JOptionPane.WARNING_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, SELECT_ADMIN,"Advertencia", JOptionPane.WARNING_MESSAGE);
		}
	}

}
