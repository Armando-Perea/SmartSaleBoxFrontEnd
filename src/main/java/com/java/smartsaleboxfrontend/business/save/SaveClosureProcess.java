package com.java.smartsaleboxfrontend.business.save;

import java.sql.Date;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.ClosureClient;
import com.java.smartsalebox.models.Closure;

public class SaveClosureProcess {

	public final static String CASH_SAVED_SUCCESSFULLY="Cierre generado con éxito";
    public final static String CASH_SAVED_FAILED="No es posible cerrar en este momento";
    private static final String NUMERIC_VALIDATION_ERROR = "Dato debe ser numérico, revise información";
   	private static final String VALIDATION_NUMBER = "java.lang.NumberFormatException";
	
	public static Integer createNewClosure() {
		Closure newClosure = new Closure();
			try {	
				newClosure.setIdClosure(0);
				newClosure.setAttendee("PUTIN VLADIMIR");
				newClosure.setCardPayments(0.00);
				newClosure.setCashPayments(0.00);
				newClosure.setClosureCash(0.00);
				newClosure.setClosureDate(new Date(5L));
				newClosure.setEarning(0.00);
				newClosure.setInitCash(0.00);
				newClosure.setProducts(0.00);
				newClosure.setTotalInflow(0.00);
				newClosure.setTotalOutflow(0.00);

				newClosure = ClosureClient.addClosure(newClosure);
				if(newClosure.getIdClosure()!=null) {
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

		return newClosure.getIdClosure();
	}
	
}
