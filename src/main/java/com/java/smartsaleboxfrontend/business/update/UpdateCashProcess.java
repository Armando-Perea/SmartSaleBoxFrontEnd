package com.java.smartsaleboxfrontend.business.update;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.CashClient;
import com.java.smartsalebox.models.Cash;

public class UpdateCashProcess {

	// tblNewBulkProducts
	private static final String CASH_UPDATED = "Cajón Actualizado con Éxito!";
	private static final String CASH_NOT_FOUND = "Id no existe!";
	private static final String CASH_UPDATE_FAILED = "No es posible actualizar cajón";
	private static final String NUMERIC_VALIDATION_ERROR = "Dato debe ser numérico, revise información";
	private static final String VALIDATION_UPDATE_TITLE = "Validacion";
	private static final String VALIDATION_NUMBER = "java.lang.NumberFormatException";
	private static final String VALIDATION_TOTAL = "java.lang.NumberFormatException";

	/**
	 * updateSelectedProductProcess executes the update process for the product
	 * table.
	 */
	// {adm.getIdAdministrator(),adm.getName(),adm.getLastName(),adm.getPosition(),adm.getEmail(),adm.getPassword()};
	public static void updateCash(Cash cash) {
		int status = 0;
		try {
			cash = CashClient.getCashById(cash.getIdCash());
			if (cash != null) {

				status = CashClient.updateCash(cash);
				if (status > 0 && status < 300) {
					JOptionPane.showMessageDialog(null, CASH_UPDATED, VALIDATION_UPDATE_TITLE,
							JOptionPane.INFORMATION_MESSAGE);
					// ReadAdministrationInfo.fillAllAdminTable();
				} else {
					JOptionPane.showMessageDialog(null, CASH_UPDATE_FAILED, VALIDATION_UPDATE_TITLE,
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, CASH_NOT_FOUND, VALIDATION_UPDATE_TITLE,
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
