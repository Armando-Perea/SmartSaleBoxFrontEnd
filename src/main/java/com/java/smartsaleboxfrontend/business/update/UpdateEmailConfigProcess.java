package com.java.smartsaleboxfrontend.business.update;

import javax.swing.JOptionPane;
import com.java.smartsalebox.client.EmailConfigClient;
import com.java.smartsalebox.models.EmailConfig;
import com.java.smartsaleboxfrontend.business.read.ReadEmailInfo;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;
import com.java.smartsaleboxfrontend.utils.SmartSaleBoxClearFields;

public class UpdateEmailConfigProcess {

	private static final String EMAIL_UPDATED = "Email Actualizado con Éxito!";
	private static final String EMAIL_NOT_FOUND = "Empleado no existe!";
	private static final String EMAIL_UPDATE_FAILED = "No es posible actualizar Empleado";
	private static final String SELECT_EMAIL = "Seleccione un Email en la Tabla";
	private static final String NUMERIC_VALIDATION_ERROR = "Dato debe ser numérico, revise información";
	private static final String VALIDATION_UPDATE_TITLE = "Validacion";
	private static final String VALIDATION_DATA = "Dato No Valido para Actualizar";
	private static final String VALIDATION_NUMBER = "java.lang.NumberFormatException";
	private static final String VALIDATION_TOTAL = "java.lang.NumberFormatException";

	public static void updateEmailConfig() {
		int row;
		Integer emailId;
		int status = 0;
		String email;
		String password;
		String isActive;
		EmailConfig emailConfig = new EmailConfig();
		row = SmartSaleBoxMain.tblEmail.getSelectedRow();
		try {
			if (row > -1) {
				emailId = Integer.parseInt(SmartSaleBoxMain.tblEmail.getValueAt(row, 0).toString());
				emailConfig = EmailConfigClient.getEmailConfigById(emailId);
				if (emailConfig != null) {
					email = (String) SmartSaleBoxMain.tblEmail.getValueAt(row, 1);
					password = (String) SmartSaleBoxMain.tblEmail.getValueAt(row, 2);
					isActive = (String) SmartSaleBoxMain.tblEmail.getValueAt(row, 3);
					if (!email.isEmpty()) {
						emailConfig.setEmail(email);
					}
					if (!password.isEmpty()) {
						emailConfig.setPassword(password);
					}
					if (isActive.toLowerCase().equals("true") || isActive.toLowerCase().equals("si")) {
						emailConfig.setIsActiveService(true);
					}else {
						emailConfig.setIsActiveService(false);
					}
					status = EmailConfigClient.updateEmailConfig(emailConfig);
					if (status > 0 && status < 300) {
						JOptionPane.showMessageDialog(null, EMAIL_UPDATED, VALIDATION_UPDATE_TITLE,
								JOptionPane.INFORMATION_MESSAGE);
						SmartSaleBoxClearFields.clearEmailProcess();
						ReadEmailInfo.getAllEmailTable();
					} else {
						JOptionPane.showMessageDialog(null, EMAIL_UPDATE_FAILED, VALIDATION_UPDATE_TITLE,
								JOptionPane.INFORMATION_MESSAGE);
						SmartSaleBoxClearFields.clearEmailProcess();
						ReadEmailInfo.getAllEmailTable();
					}
				} else {
					JOptionPane.showMessageDialog(null, EMAIL_NOT_FOUND, VALIDATION_UPDATE_TITLE,
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, SELECT_EMAIL, VALIDATION_UPDATE_TITLE, JOptionPane.WARNING_MESSAGE);
			}
		} catch (Exception ex) {
			System.out.println("ISSUE: " + ex);
			if (ex.toString().contains(VALIDATION_NUMBER) || ex.toString().contains(VALIDATION_TOTAL)) {
				JOptionPane.showMessageDialog(null, NUMERIC_VALIDATION_ERROR, VALIDATION_UPDATE_TITLE,
						JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, VALIDATION_DATA, VALIDATION_UPDATE_TITLE,
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
	public static void activateMailService() {
		int status = 0;
		EmailConfig email = new EmailConfig();
		email = EmailConfigClient.getEmailConfigById(1);
		email.setIsActiveService(true);
		status = EmailConfigClient.updateEmailConfig(email);
		if (status > 0 && status < 300) {
			JOptionPane.showMessageDialog(null, "Envío de Correo Activado!", VALIDATION_UPDATE_TITLE,
					JOptionPane.INFORMATION_MESSAGE);
			SmartSaleBoxMain.txtMailService.setText("ACTIVADO");
			SmartSaleBoxMain.mailService = true;
		}else {
			JOptionPane.showMessageDialog(null, "No se pudo actualizar Servicio de Correo", VALIDATION_UPDATE_TITLE,
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public static void deactivateMailService() {
		int status = 0;
		EmailConfig email = new EmailConfig();
		email = EmailConfigClient.getEmailConfigById(1);
		email.setIsActiveService(false);
		status = EmailConfigClient.updateEmailConfig(email);
		if (status > 0 && status < 300) {
			JOptionPane.showMessageDialog(null, "Envío de Correo Desactivado!", VALIDATION_UPDATE_TITLE,
					JOptionPane.INFORMATION_MESSAGE);
			SmartSaleBoxMain.txtMailService.setText("DESACTIVADO");
			SmartSaleBoxMain.mailService = false;
		}else {
			JOptionPane.showMessageDialog(null, "No se pudo actualizar Servicio de Correo", VALIDATION_UPDATE_TITLE,
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
