package com.java.smartsaleboxfrontend.business.delete;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.EmailConfigClient;
import com.java.smartsaleboxfrontend.business.read.ReadEmailInfo;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;

public class DeleteEmailConfigProcess {
	
	private static final String EMAIL_DELETED = "Email ha sido borrado!";
	private static final String SELECT_EMAIL = "Seleccione un email a eliminar por favor";
	
	public static void removeSelectedEmail() {
		int row;
		int idEmail;
		int status=0;
		row = SmartSaleBoxMain.tblEmail.getSelectedRow();
		if (row > -1) {
			idEmail = Integer.parseInt(SmartSaleBoxMain.tblEmail.getValueAt(row, 0).toString());
			status = EmailConfigClient.deleteEmailConfig(idEmail);
			if(status >=200 && status < 400) {
				SmartSaleBoxMain.tableModelEmail.setRowCount(0);
				ReadEmailInfo.getAllEmailTable();
				JOptionPane.showMessageDialog(null, EMAIL_DELETED,"Advertencia", JOptionPane.WARNING_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, SELECT_EMAIL,"Advertencia", JOptionPane.WARNING_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, SELECT_EMAIL,"Advertencia", JOptionPane.WARNING_MESSAGE);
		}
	}

}
