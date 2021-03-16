package com.java.smartsaleboxfrontend.business.update;

import javax.swing.JOptionPane;
import com.java.smartsalebox.client.CashPaymentClient;
import com.java.smartsalebox.models.CashPayment;

public class UpdateCashPaymentProcess {

	private static final String CASH_PAYMENT_UPDATED = "Pago Actualizado con Éxito!";
	private static final String CASH_PAYMENT_NOT_FOUND = "Id no existe!";
	private static final String CASH_PAYMENT_UPDATE_FAILED = "No es posible actualizar Pago";
	private static final String NUMERIC_VALIDATION_ERROR = "Dato debe ser numérico, revise información";
	private static final String VALIDATION_UPDATE_TITLE = "Validacion";
	private static final String VALIDATION_NUMBER = "java.lang.NumberFormatException";
	private static final String VALIDATION_TOTAL = "java.lang.NumberFormatException";

	public static void updateCashPayment(CashPayment cashPayment) {
		int status = 0;
		try {
			cashPayment = CashPaymentClient.getCashPaymentById(cashPayment.getIdCashPayment());
			if (cashPayment != null) {

				status = CashPaymentClient.updateCashPayment(cashPayment);
				if (status > 0 && status < 300) {
					JOptionPane.showMessageDialog(null, CASH_PAYMENT_UPDATED, VALIDATION_UPDATE_TITLE,
							JOptionPane.INFORMATION_MESSAGE);
					// ReadAdministrationInfo.fillAllAdminTable();
				} else {
					JOptionPane.showMessageDialog(null, CASH_PAYMENT_UPDATE_FAILED, VALIDATION_UPDATE_TITLE,
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, CASH_PAYMENT_NOT_FOUND, VALIDATION_UPDATE_TITLE,
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
