package com.java.smartsaleboxfrontend.business.save;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.InflowClient;
import com.java.smartsalebox.models.Inflow;

public class SaveInflowProcess {
	
	public final static String PRODUCT_SAVED_SUCCESSFULLY="Stock generado con éxito";
    public final static String PRODUCT_SAVED_FAILED="No es posible crear Stock granel en este momento";
    private static final String NUMERIC_VALIDATION_ERROR = "Dato debe ser numérico, revise información";
   	private static final String VALIDATION_NUMBER = "java.lang.NumberFormatException";
	
	public static Integer createNewInflow() {
		Inflow newInflow = new Inflow();
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", new Locale("es", "ES"));
		String formattedDate = myDateObj.format(myFormatObj);
			try {	
				newInflow.setIdInflow(0);
				newInflow.setAttendee("PUTIN");
				newInflow.setConcept("COCNEPT");
				newInflow.setDescription("DESCRIPTION");
				newInflow.setInflowDate(formattedDate);
				newInflow.setPaymentType("EFECTIVO");
				newInflow.setQuantity(0.00);

				newInflow = InflowClient.addInflow(newInflow);
				if(newInflow.getIdInflow()!=null) {
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

		return newInflow.getIdInflow();
	}

}
