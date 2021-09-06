package com.java.smartsaleboxfrontend.business.update;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.CashClient;
import com.java.smartsalebox.models.Cash;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;

public class UpdateCashProcess {

	private static final String CASH_UPDATED = "Operación Realizada!";
	private static final String CASH_NOT_FOUND = "Id no existe!";
	private static final String CASH_UPDATE_FAILED = "No es posible actualizar cajón";
	private static final String NUMERIC_VALIDATION_ERROR = "Dato debe ser numérico, revise información";
	private static final String VALIDATION_UPDATE_TITLE = "Validacion";
	private static final String VALIDATION_NUMBER = "java.lang.NumberFormatException";
	private static final String VALIDATION_TOTAL = "java.lang.NumberFormatException";

	public static void updateCashAndNoSale() {
		int status = 0;
		try {
			Cash cash = CashClient.getCashById(1);
			if (cash != null) {
				cash.setQuantity(SmartSaleBoxMain.cash);
				cash.setNoSale(SmartSaleBoxMain.noSale + 1);
				status = CashClient.updateCash(cash);
				SmartSaleBoxMain.noSale++;
				if (status > 0 && status < 300) {
					JOptionPane.showMessageDialog(null, CASH_UPDATED+"\n Cajón: $"+SmartSaleBoxMain.cash, VALIDATION_UPDATE_TITLE,
							JOptionPane.INFORMATION_MESSAGE);
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
