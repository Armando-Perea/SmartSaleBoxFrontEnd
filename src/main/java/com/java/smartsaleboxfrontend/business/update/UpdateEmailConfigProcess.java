package com.java.smartsaleboxfrontend.business.update;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.EmailConfigClient;
import com.java.smartsalebox.models.EmailConfig;

public class UpdateEmailConfigProcess {

	// tblNewBulkProducts
	private static final String EMAIL_UPDATED = "Pago Actualizado con Éxito!";
	private static final String EMAIL_NOT_FOUND = "Id no existe!";
	private static final String EMAIL_UPDATE_FAILED = "No es posible actualizar Pago";
	private static final String NUMERIC_VALIDATION_ERROR = "Dato debe ser numérico, revise información";
	private static final String VALIDATION_UPDATE_TITLE = "Validacion";
	private static final String VALIDATION_NUMBER = "java.lang.NumberFormatException";
	private static final String VALIDATION_TOTAL = "java.lang.NumberFormatException";

	/**
	 * updateSelectedProductProcess executes the update process for the product
	 * table.
	 */
	// {adm.getIdAdministrator(),adm.getName(),adm.getLastName(),adm.getPosition(),adm.getEmail(),adm.getPassword()};
	public static void updateEmailConfig(EmailConfig emailConfig) {
		int status = 0;
		try {
			emailConfig = EmailConfigClient.getEmailConfigById(emailConfig.getIdEmail());
			if (emailConfig != null) {

				status = EmailConfigClient.updateEmailConfig(emailConfig);
				if (status > 0 && status < 300) {
					JOptionPane.showMessageDialog(null, EMAIL_UPDATED, VALIDATION_UPDATE_TITLE,
							JOptionPane.INFORMATION_MESSAGE);
					// ReadAdministrationInfo.fillAllAdminTable();
				} else {
					JOptionPane.showMessageDialog(null, EMAIL_UPDATE_FAILED, VALIDATION_UPDATE_TITLE,
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, EMAIL_NOT_FOUND, VALIDATION_UPDATE_TITLE,
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception ex) {
			System.out.println("ISSUE: " + ex);
			if (ex.toString().contains(VALIDATION_NUMBER) || ex.toString().contains(VALIDATION_TOTAL)) {
				JOptionPane.showMessageDialog(null, NUMERIC_VALIDATION_ERROR, VALIDATION_UPDATE_TITLE,
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}

}
