package com.java.smartsaleboxfrontend.business.save;

import java.sql.Date;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.ClosureClient;
import com.java.smartsalebox.client.ControlBulkStockClient;
import com.java.smartsalebox.models.Closure;
import com.java.smartsalebox.models.ControlBulkStock;

public class SaveBulkStockProcess {

	public final static String BULK_SAVED_SUCCESSFULLY="Stock granel generado con éxito";
    public final static String BULK_SAVED_FAILED="No es posible crear Stock granel en este momento";
    private static final String NUMERIC_VALIDATION_ERROR = "Dato debe ser numérico, revise información";
   	private static final String VALIDATION_NUMBER = "java.lang.NumberFormatException";
	
	public static Integer createNewBulkStock() {
		ControlBulkStock newBulkStock = new ControlBulkStock();
			try {	
				newBulkStock.setIdControlBulkStock(0);
				newBulkStock.setIdBulkProduct(0);
				newBulkStock.setGrStock(1000.00);		

				newBulkStock = ControlBulkStockClient.addControlBulkStock(newBulkStock);
				if(newBulkStock.getIdControlBulkStock()!=null) {
					JOptionPane.showMessageDialog(null, BULK_SAVED_SUCCESSFULLY);
				}else {
					JOptionPane.showMessageDialog(null,BULK_SAVED_FAILED);
				}
			}catch(Exception ex) {
				System.out.println("ISSUE: "+ex);
				if(ex.toString().contains(VALIDATION_NUMBER)) {
				JOptionPane.showMessageDialog(null, NUMERIC_VALIDATION_ERROR,"Validation", JOptionPane.WARNING_MESSAGE);	
				}else {
				JOptionPane.showMessageDialog(null, "Se produjo una excepción al guardar","Validation", JOptionPane.WARNING_MESSAGE);	
				}
			}

		return newBulkStock.getIdControlBulkStock();
	}
	
}
