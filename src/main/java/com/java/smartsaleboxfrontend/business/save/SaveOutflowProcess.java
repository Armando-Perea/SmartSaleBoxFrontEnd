package com.java.smartsaleboxfrontend.business.save;

import java.sql.Date;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.OutflowClient;
import com.java.smartsalebox.models.Outflow;

public class SaveOutflowProcess {

	public final static String PRODUCT_SAVED_SUCCESSFULLY="Stock generado con éxito";
    public final static String PRODUCT_SAVED_FAILED="No es posible crear Stock granel en este momento";
    private static final String NUMERIC_VALIDATION_ERROR = "Dato debe ser numérico, revise información";
   	private static final String VALIDATION_NUMBER = "java.lang.NumberFormatException";
	
	public static Integer createNewOutflow() {
		Outflow newOutflow = new Outflow();
			try {	
				newOutflow.setIdOutflow(0);
				newOutflow.setAttendee("");
				newOutflow.setConcept("");
				newOutflow.setDescription("");
				newOutflow.setOutflowDate(new Date(5L));
				newOutflow.setPaymentType("");
				newOutflow.setQuantity(0.00);

				newOutflow = OutflowClient.addOutflow(newOutflow);
				if(newOutflow.getIdOutflow()!=null) {
					JOptionPane.showMessageDialog(null, PRODUCT_SAVED_SUCCESSFULLY);
				}else {
					JOptionPane.showMessageDialog(null,PRODUCT_SAVED_FAILED);
				}
			}catch(Exception ex) {
				System.out.println("ISSUE: "+ex);
				if(ex.toString().contains(VALIDATION_NUMBER)) {
				JOptionPane.showMessageDialog(null, NUMERIC_VALIDATION_ERROR,"Validation", JOptionPane.WARNING_MESSAGE);	
				}else {
				JOptionPane.showMessageDialog(null, "Se produjo una excepción al guardar","Validation", JOptionPane.WARNING_MESSAGE);	
				}
			}

		return newOutflow.getIdOutflow();
	}
	
}
