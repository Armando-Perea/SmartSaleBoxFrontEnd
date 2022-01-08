package com.java.smartsaleboxfrontend.business.read;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.EmailConfigClient;
import com.java.smartsalebox.models.EmailConfig;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;
import com.java.smartsaleboxfrontend.utils.SmartSaleBoxClearFields;

public class ReadEmailInfo {
	
	private static final String EMAIL_NOT_FOUND = "Email no existe";
	private static final String VALIDATION_UPDATE_TITLE = "Validación";
	
	public static void getAllEmailTable() {
		EmailConfig[] email;
		try {
			email = EmailConfigClient.getAllEmailConfig();
			if(email.length>0) {
				SmartSaleBoxMain.tableModelEmail.setRowCount(0);
				for (EmailConfig em : email) {
					Object[] emailItems = {em.getIdEmail(),em.getEmail(),em.getPassword(),em.getIsActiveService()};
					SmartSaleBoxMain.tableModelEmail.addRow(emailItems);
				}
				SmartSaleBoxMain.scrollEmail.setViewportView(SmartSaleBoxMain.tblEmail);
			}else {
				JOptionPane.showMessageDialog(null,EMAIL_NOT_FOUND,VALIDATION_UPDATE_TITLE, JOptionPane.INFORMATION_MESSAGE);
				SmartSaleBoxClearFields.clearEmailProcess();
			}
		}catch(Exception ex) {
			System.out.println("getAllEmailTable error catch: "+ex);
			SmartSaleBoxClearFields.clearEmailProcess();
		}
	}

}
