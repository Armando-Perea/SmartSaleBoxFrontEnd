package com.java.smartsaleboxfrontend.business.save;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.ControlBulkStockClient;
import com.java.smartsalebox.client.ControlProductStockClient;
import com.java.smartsalebox.models.ControlBulkStock;
import com.java.smartsalebox.models.ControlProductStock;

public class SaveProductStockProcess {

	public final static String PRODUCT_SAVED_SUCCESSFULLY="Stock generado con éxito";
    public final static String PRODUCT_SAVED_FAILED="No es posible crear Stock granel en este momento";
    private static final String NUMERIC_VALIDATION_ERROR = "Dato debe ser numérico, revise información";
   	private static final String VALIDATION_NUMBER = "java.lang.NumberFormatException";
	
	public static Integer createNewProductStock() {
		ControlProductStock newProductStock = new ControlProductStock();
			try {	
				newProductStock.setIdControlProductStock(0);
				newProductStock.setIdProduct(0);
				newProductStock.setStock(0);		

				newProductStock = ControlProductStockClient.addControlProductStock(newProductStock);
				if(newProductStock.getIdControlProductStock()!=null) {
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

		return newProductStock.getIdControlProductStock();
	}
	
}
