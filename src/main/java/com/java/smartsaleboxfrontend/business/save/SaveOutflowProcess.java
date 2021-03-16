package com.java.smartsaleboxfrontend.business.save;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JOptionPane;

import com.java.smartsalebox.client.OutflowClient;
import com.java.smartsalebox.models.Outflow;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;
import com.java.smartsaleboxfrontend.utils.SmartSaleBoxClearFields;

public class SaveOutflowProcess {

	public final static String OPERATION_SAVED_SUCCESSFULLY="Operación con éxito";
    public final static String OPERATION_SAVED_FAILED="No es posible crear Stock granel en este momento";
    public final static String NOT_ENOUGH_CASH="No hay efectivo suficiente en caja para retirar";
    private static final String NUMERIC_VALIDATION_ERROR = "Dato debe ser numérico, revise información";
   	private static final String VALIDATION_NUMBER = "java.lang.NumberFormatException";
	
	public static Integer createNewOutflow() {
		Outflow newOutflow = new Outflow();
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", new Locale("es", "ES"));
		String formattedDate = myDateObj.format(myFormatObj);
		Double outflowQuantity = 0.0;
			try {	
				outflowQuantity = Double.parseDouble(SmartSaleBoxMain.txtInOutQuantity.getText());
				
					newOutflow.setIdOutflow(0);
					newOutflow.setAttendee(SmartSaleBoxMain.adminName);
					newOutflow.setConcept(SmartSaleBoxMain.txtInOutConcept.getText());
					newOutflow.setDescription("Operación en No. Venta: "+SmartSaleBoxMain.noSale);
					newOutflow.setOutflowDate(formattedDate);
					newOutflow.setPaymentType((String)SmartSaleBoxMain.cmbPaymentTypeInOut.getSelectedItem());
					newOutflow.setQuantity(outflowQuantity);
					
					if(SmartSaleBoxMain.cmbPaymentTypeInOut.getSelectedItem().toString().equals("EFECTIVO") && SmartSaleBoxMain.cash>outflowQuantity) {
						newOutflow = OutflowClient.addOutflow(newOutflow);
						if(newOutflow.getIdOutflow()!=null) {
							SmartSaleBoxMain.cash = SmartSaleBoxMain.cash-outflowQuantity;
							SmartSaleBoxClearFields.clearInflowsOutflowsSection();
							LoginInitializer.initializeBalanceAndHistory();
							JOptionPane.showMessageDialog(null, OPERATION_SAVED_SUCCESSFULLY+"\nCajón Actualizado: $"+SmartSaleBoxMain.cash);
						}else {
							JOptionPane.showMessageDialog(null,OPERATION_SAVED_FAILED);
						}
					}else if(SmartSaleBoxMain.cmbPaymentTypeInOut.getSelectedItem().toString().equals("EFECTIVO") && SmartSaleBoxMain.cash<outflowQuantity){
						JOptionPane.showMessageDialog(null,NOT_ENOUGH_CASH+" $"+SmartSaleBoxMain.cash);
					}else {
						newOutflow = OutflowClient.addOutflow(newOutflow);
						if(newOutflow.getIdOutflow()!=null) {
							JOptionPane.showMessageDialog(null, OPERATION_SAVED_SUCCESSFULLY);
							SmartSaleBoxMain.cash = SmartSaleBoxMain.cash-outflowQuantity;
							SmartSaleBoxClearFields.clearInflowsOutflowsSection();
							LoginInitializer.initializeBalanceAndHistory();
						}else {
							JOptionPane.showMessageDialog(null,OPERATION_SAVED_FAILED);
						}
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
