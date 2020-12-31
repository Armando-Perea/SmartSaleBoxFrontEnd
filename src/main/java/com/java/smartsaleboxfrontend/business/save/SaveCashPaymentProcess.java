package com.java.smartsaleboxfrontend.business.save;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.CartSaleClient;
import com.java.smartsalebox.client.CashPaymentClient;
import com.java.smartsalebox.models.CartSale;
import com.java.smartsalebox.models.CashPayment;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;

public class SaveCashPaymentProcess {
	
	public final static String CASH_SAVED_SUCCESSFULLY="Guardado con éxito";
    public final static String CASH_SAVED_FAILED="No es posible dar de alta tipo pago en este momento";
    private static final String NUMERIC_VALIDATION_ERROR = "Dato debe ser numérico, revise información";
   	private static final String VALIDATION_NUMBER = "java.lang.NumberFormatException";
	
	public static Integer createNewSale() {
		CashPayment newCashPayment = new CashPayment();
			try {	
				newCashPayment.setIdCashPayment(0);
				newCashPayment.setPaymentType("EFECTIVO");
				newCashPayment.setQuantity(0.00);

				newCashPayment = CashPaymentClient.addCashPayment(newCashPayment);
				if(newCashPayment.getIdCashPayment()!=null) {
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

		return newCashPayment.getIdCashPayment();
	}

}
