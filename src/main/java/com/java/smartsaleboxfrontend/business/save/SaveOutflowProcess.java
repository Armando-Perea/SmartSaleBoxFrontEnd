package com.java.smartsaleboxfrontend.business.save;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JOptionPane;

import com.java.smartsalebox.client.OutflowClient;
import com.java.smartsalebox.models.Outflow;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;

public class SaveOutflowProcess {

	public final static String OPERATION_SAVED_SUCCESSFULLY="Operación con éxito";
    public final static String OPERATION_SAVED_FAILED="No es posible crear Stock granel en este momento";
    private static final String NUMERIC_VALIDATION_ERROR = "Dato debe ser numérico, revise información";
   	private static final String VALIDATION_NUMBER = "java.lang.NumberFormatException";
	
	public static Integer createNewOutflow() {
		Outflow newOutflow = new Outflow();
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", new Locale("es", "ES"));
		String formattedDate = myDateObj.format(myFormatObj);
			try {	
				newOutflow.setIdOutflow(0);
				newOutflow.setAttendee("PUTIN");
				newOutflow.setConcept(SmartSaleBoxMain.txtInOutConcept.getText());
				newOutflow.setDescription("Operación en No. Venta: "+SmartSaleBoxMain.noSale);
				newOutflow.setOutflowDate(formattedDate);
				newOutflow.setPaymentType((String)SmartSaleBoxMain.cmbPaymentTypeInOut.getSelectedItem());
				newOutflow.setQuantity(Double.parseDouble(SmartSaleBoxMain.txtInOutQuantity.getText()));

				newOutflow = OutflowClient.addOutflow(newOutflow);
				if(newOutflow.getIdOutflow()!=null) {
					JOptionPane.showMessageDialog(null, OPERATION_SAVED_SUCCESSFULLY);
				}else {
					JOptionPane.showMessageDialog(null,OPERATION_SAVED_FAILED);
				}
			}catch(Exception ex) {
				System.out.println("ISSUE createNewOutflow: "+ex);
				if(ex.toString().contains(VALIDATION_NUMBER)) {
				JOptionPane.showMessageDialog(null, NUMERIC_VALIDATION_ERROR,"Validation", JOptionPane.WARNING_MESSAGE);	
				}else {
				JOptionPane.showMessageDialog(null, "Excepción al guardar operación","Validation", JOptionPane.WARNING_MESSAGE);	
				}
			}
		return newOutflow.getIdOutflow();
	}
	
}
