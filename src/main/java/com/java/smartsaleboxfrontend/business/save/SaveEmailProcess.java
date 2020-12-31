package com.java.smartsaleboxfrontend.business.save;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.EmailConfigClient;
import com.java.smartsalebox.models.EmailConfig;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;

public class SaveEmailProcess {

	public final static String EMAIL_SAVED_SUCCESSFULLY = " ha sido dado de alta con éxito!";
	public final static String EMAIL_SAVED_FAILED = "No es posible dar de alta Eamil en este momento";
	private static final String NUMERIC_VALIDATION_ERROR = "Dato debe ser numérico, revise información";
	private static final String VALIDATION_NUMBER = "java.lang.NumberFormatException";
	private static final String IS_VALID_EMAIL = "Email no válido";

	public static String createNewEmail() {
		EmailConfig emailConfig = new EmailConfig();
		try {
			emailConfig.setIdEmail(0);
			emailConfig.setEmail(SmartSaleBoxMain.txtEmailNew.getText());
			emailConfig.setPassword(new String(SmartSaleBoxMain.pwdEmailNew.getPassword()));
			emailConfig.setIsActiveService(true);
			if(isValidEmail(emailConfig.getEmail())) {
				emailConfig = EmailConfigClient.addEmailConfig(emailConfig);
				if (emailConfig.getIdEmail() != null) {
					JOptionPane.showMessageDialog(null, emailConfig.getEmail() + EMAIL_SAVED_SUCCESSFULLY);
				} else {
					JOptionPane.showMessageDialog(null, EMAIL_SAVED_FAILED);
				}
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

		return emailConfig.getIdEmail().toString();
	}

	public static boolean isValidEmail(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		if (!email.matches(regex)) {
			JOptionPane.showMessageDialog(null, IS_VALID_EMAIL, "Validación", JOptionPane.INFORMATION_MESSAGE);
		}
		return email.matches(regex);
	}

}
