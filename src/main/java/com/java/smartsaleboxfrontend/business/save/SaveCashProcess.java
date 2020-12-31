package com.java.smartsaleboxfrontend.business.save;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.CashClient;
import com.java.smartsalebox.models.Cash;

import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;

public class SaveCashProcess {

	public final static String CASH_SAVED_SUCCESSFULLY="Caja inicializada!";
    public final static String CASH_SAVED_FAILED="No es posible dar de alta Caja en este momento";
    private static final String NUMERIC_VALIDATION_ERROR = "Dato debe ser numérico, revise información";
   	private static final String VALIDATION_NUMBER = "java.lang.NumberFormatException";
	
	public static Integer createNewSale() {
		Cash newCash = new Cash();
			try {	
				newCash.setIdCash(1);
				newCash.setQuantity(0.00);
				newCash.setNoSale(SmartSaleBoxMain.noSale);
				
				newCash = CashClient.addCash(newCash);
				if(newCash.getIdCash()!=null) {
					JOptionPane.showMessageDialog(null, CASH_SAVED_SUCCESSFULLY);
				}else {
					JOptionPane.showMessageDialog(null,CASH_SAVED_FAILED);
				}
			}catch(Exception ex) {
				System.out.println("ISSUE: "+ex);
				if(ex.toString().contains(VALIDATION_NUMBER)) {
				JOptionPane.showMessageDialog(null, NUMERIC_VALIDATION_ERROR,"Validation", JOptionPane.WARNING_MESSAGE);	
				}else {
				JOptionPane.showMessageDialog(null, "Se produjo una excepción al guardar","Validation", JOptionPane.WARNING_MESSAGE);	
				}
			}

		return newCash.getIdCash();
	}
}
