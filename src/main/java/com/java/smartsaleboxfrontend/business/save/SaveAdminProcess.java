package com.java.smartsaleboxfrontend.business.save;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.AdministratorClient;
import com.java.smartsalebox.models.Administrator;
import com.java.smartsaleboxfrontend.business.read.ReadAdminInfo;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;
import com.java.smartsaleboxfrontend.utils.SmartSaleBoxClearFields;
import com.java.smartsaleboxfrontend.utils.SmartSaleBoxOperations;

public class SaveAdminProcess {

	public final static String ADMIN_SAVED_SUCCESSFULLY = " ha sido dado de alta con éxito!";
	public final static String ADMIN_SAVED_FAILED = "No es posible dar de alta Administrador en este momento";
	private static final String NUMERIC_VALIDATION_ERROR = "Dato debe ser numérico, revise información";
	private static final String VALIDATION_NUMBER = "java.lang.NumberFormatException";

	public static Integer createNewAdmin() {
		Administrator newAdmin = new Administrator();
		if(SmartSaleBoxOperations.validateAdminPasswords()) {	
				try {
					newAdmin.setIdAdministrator(0);
					newAdmin.setAdminName(SmartSaleBoxMain.txtAdminName.getText());
					newAdmin.setAdminLastName(SmartSaleBoxMain.txtAdminLast.getText());
					newAdmin.setAdminPhone(SmartSaleBoxMain.txtAdminPhone.getText());
					newAdmin.setAdminRole((String) SmartSaleBoxMain.cmbAdminRole.getSelectedItem());
					newAdmin.setAdminPassword(new String(SmartSaleBoxMain.pwdAdmin1.getPassword()));
					newAdmin = AdministratorClient.addAdmin(newAdmin);
					if (newAdmin.getIdAdministrator() != null) {
						JOptionPane.showMessageDialog(null, newAdmin.getAdminName() + ADMIN_SAVED_SUCCESSFULLY);
						SmartSaleBoxClearFields.clearAdminProcess();
						ReadAdminInfo.getAllAdminTable();
					} else {
						JOptionPane.showMessageDialog(null, ADMIN_SAVED_FAILED);
					}
				} catch (Exception ex) {
					System.out.println("ISSUE: " + ex);
					if (ex.toString().contains(VALIDATION_NUMBER)) {
						JOptionPane.showMessageDialog(null, NUMERIC_VALIDATION_ERROR, "Validation",
								JOptionPane.WARNING_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Se produjo una excepción al guardar", "Validation",
								JOptionPane.WARNING_MESSAGE);
					}
				}
		}else {
			JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Validation",
					JOptionPane.WARNING_MESSAGE);
		}
		return newAdmin.getIdAdministrator();
	}
}
