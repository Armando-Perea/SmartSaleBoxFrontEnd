package com.java.smartsaleboxfrontend.business.save;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.ClosureClient;
import com.java.smartsalebox.models.Closure;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;

public class SaveClosureProcess {

	public final static String CASH_SAVED_SUCCESSFULLY="Cierre generado con éxito";
    public final static String CASH_SAVED_FAILED="No es posible cerrar en este momento";
    private static final String NUMERIC_VALIDATION_ERROR = "Dato debe ser numérico, revise información";
   	private static final String VALIDATION_NUMBER = "java.lang.NumberFormatException";
	
	public static Closure createNewClosure() {
		
		LocalDateTime myDateObj = LocalDateTime.now();  
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", new Locale("es","ES"));
        String closureDate = myDateObj.format(myFormatObj);
		
		Closure newClosure = new Closure();
			try {	
				newClosure.setIdClosure(0);
				newClosure.setAttendee(SmartSaleBoxMain.adminName);
				newClosure.setCardPayments(Double.parseDouble(SmartSaleBoxMain.txtTotalCardClosure.getText()));
				newClosure.setCashPayments(Double.parseDouble(SmartSaleBoxMain.txtTotalCashClosure.getText()));
				newClosure.setClosureCash(Double.parseDouble(SmartSaleBoxMain.txtTotalCashBoxClosure.getText()));
				newClosure.setClosureDate(closureDate);
				newClosure.setEarning(Double.parseDouble(SmartSaleBoxMain.txtTotalEarningsClosure.getText()));
				newClosure.setInitCash(Double.parseDouble(SmartSaleBoxMain.txtInitialCashClosure.getText()));
				newClosure.setProducts(Double.parseDouble(SmartSaleBoxMain.txtTotalProductClosure.getText()));
				newClosure.setTotalInflow(Double.parseDouble(SmartSaleBoxMain.txtTotalInflowsClosure.getText()));
				newClosure.setTotalOutflow(Double.parseDouble(SmartSaleBoxMain.txtTotalOutflowsClosure.getText()));
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
		return newClosure;
	}
	
}
