package com.java.smartsaleboxfrontend.business.save;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.InflowClient;
import com.java.smartsalebox.models.Inflow;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;
import com.java.smartsaleboxfrontend.utils.SmartSaleBoxClearFields;

public class SaveInflowProcess {
	
	public final static String OPERATION_SAVED_SUCCESSFULLY="Operación generada con éxito";
    public final static String OPERATION_SAVED_FAILED="No es posible operación en este momento";
    private static final String NUMERIC_VALIDATION_ERROR = "Dato debe ser numérico, revise información";
   	private static final String VALIDATION_NUMBER = "java.lang.NumberFormatException";
	
	public static Integer createNewInflow() {
		Inflow newInflow = new Inflow();
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", new Locale("es", "ES"));
		String formattedDate = myDateObj.format(myFormatObj);
			try {	
				newInflow.setIdInflow(0);
				newInflow.setAttendee(SmartSaleBoxMain.adminName);
				newInflow.setConcept(SmartSaleBoxMain.txtInOutConcept.getText());
				newInflow.setDescription("Operación en No. Venta: "+SmartSaleBoxMain.noSale);
				newInflow.setInflowDate(formattedDate);
				newInflow.setPaymentType((String)SmartSaleBoxMain.cmbPaymentTypeInOut.getSelectedItem());
				newInflow.setQuantity(Double.parseDouble(SmartSaleBoxMain.txtInOutQuantity.getText()));

				newInflow = InflowClient.addInflow(newInflow);
				if(newInflow.getIdInflow()!=null) {
					JOptionPane.showMessageDialog(null, OPERATION_SAVED_SUCCESSFULLY);
					SmartSaleBoxClearFields.clearInflowsOutflowsSection();
					LoginInitializer.initializeBalanceAndHistory();
				}else {
					JOptionPane.showMessageDialog(null,OPERATION_SAVED_FAILED);
				}
			}catch(Exception ex) {
				System.out.println("ISSUE createNewInflow: "+ex);
				if(ex.toString().contains(VALIDATION_NUMBER)) {
				JOptionPane.showMessageDialog(null, NUMERIC_VALIDATION_ERROR,"Validation", JOptionPane.WARNING_MESSAGE);	
				}else {
				JOptionPane.showMessageDialog(null, "Excepción al guardar operación","Validation", JOptionPane.WARNING_MESSAGE);	
				}
			}

		return newInflow.getIdInflow();
	}

}
