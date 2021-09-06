package com.java.smartsaleboxfrontend.business.save;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.InflowClient;
import com.java.smartsalebox.models.Inflow;
import com.java.smartsaleboxfrontend.business.update.UpdateCashProcess;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;
import com.java.smartsaleboxfrontend.utils.SmartSaleBoxClearFields;

public class SaveInflowProcess {
	
	public final static String OPERATION_SAVED_SUCCESSFULLY="Operación con éxito";
    public final static String OPERATION_SAVED_FAILED="No es posible crear Stock granel en este momento";
    public final static String NOT_ENOUGH_CASH="No hay efectivo suficiente en caja para retirar";
    private static final String NUMERIC_VALIDATION_ERROR = "Dato debe ser numérico, revise información";
   	private static final String VALIDATION_NUMBER = "java.lang.NumberFormatException";
	
	public static Integer createNewInflow() {
		Inflow newInflow = new Inflow();
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", new Locale("es", "ES"));
		String formattedDate = myDateObj.format(myFormatObj);
		Double quantity = Double.parseDouble(SmartSaleBoxMain.txtInOutQuantity.getText());
			try {	
				newInflow.setIdInflow(0);
				newInflow.setAttendee(SmartSaleBoxMain.adminName);
				newInflow.setConcept(SmartSaleBoxMain.txtInOutConcept.getText());
				newInflow.setDescription("Operación en No. Venta: "+SmartSaleBoxMain.noSale);
				newInflow.setInflowDate(formattedDate);
				newInflow.setPaymentType((String)SmartSaleBoxMain.cmbPaymentTypeInOut.getSelectedItem());
				newInflow.setQuantity(quantity);
				
				if(SmartSaleBoxMain.cmbPaymentTypeInOut.getSelectedItem().toString().equals("EFECTIVO")) {
					newInflow = InflowClient.addInflow(newInflow);
					if(newInflow.getIdInflow()!=null) {
						SmartSaleBoxMain.cash = SmartSaleBoxMain.cash+quantity;
						SmartSaleBoxClearFields.clearInflowsOutflowsSection();
						LoginInitializer.initializeBalanceAndHistory();
						UpdateCashProcess.updateCashAndNoSale();
						SmartSaleBoxMain.noSale--;
						JOptionPane.showMessageDialog(null, OPERATION_SAVED_SUCCESSFULLY+"\nCajón Actualizado: $"+SmartSaleBoxMain.cash);
					}else {
						JOptionPane.showMessageDialog(null,OPERATION_SAVED_FAILED);
					}
				}else if(SmartSaleBoxMain.cmbPaymentTypeInOut.getSelectedItem().toString().equals("TARJETA")){
					newInflow = InflowClient.addInflow(newInflow);
					if(newInflow.getIdInflow()!=null) {
						JOptionPane.showMessageDialog(null, OPERATION_SAVED_SUCCESSFULLY);
						SmartSaleBoxClearFields.clearInflowsOutflowsSection();
						LoginInitializer.initializeBalanceAndHistory();
					}else {
						JOptionPane.showMessageDialog(null,OPERATION_SAVED_FAILED);
					}
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
