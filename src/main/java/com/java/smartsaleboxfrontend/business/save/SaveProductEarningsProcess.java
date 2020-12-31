package com.java.smartsaleboxfrontend.business.save;

import java.sql.Date;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.ProductEarningsClient;
import com.java.smartsalebox.models.ProductEarnings;

public class SaveProductEarningsProcess {

	public final static String EARNING_SAVED_SUCCESSFULLY="Ganancia generado con éxito";
    public final static String EARNING_SAVED_FAILED="No es posible crear ganancia en este momento";
    private static final String NUMERIC_VALIDATION_ERROR = "Dato debe ser numérico, revise información";
   	private static final String VALIDATION_NUMBER = "java.lang.NumberFormatException";
	
	public static Integer createNewOutflow() {
		ProductEarnings newProductEarning = new ProductEarnings();
			try {	
				newProductEarning.setIdProductEarning(0);
				newProductEarning.setIdProductEarning(0);
				newProductEarning.setProductName("TEST");
				newProductEarning.setProductStock(50);
				newProductEarning.setSaleDate(new Date(5L));
				newProductEarning.setTotalEarning(500.00);
				newProductEarning.setUnitEarning(250.00);
				newProductEarning.setUnits(0);

				newProductEarning = ProductEarningsClient.addProductEarnings(newProductEarning);
				if(newProductEarning.getIdProductEarning()!=null) {
					JOptionPane.showMessageDialog(null, EARNING_SAVED_SUCCESSFULLY);
				}else {
					JOptionPane.showMessageDialog(null,EARNING_SAVED_FAILED);
				}
			}catch(Exception ex) {
				System.out.println("ISSUE: "+ex);
				if(ex.toString().contains(VALIDATION_NUMBER)) {
				JOptionPane.showMessageDialog(null, NUMERIC_VALIDATION_ERROR,"Validation", JOptionPane.WARNING_MESSAGE);	
				}else {
				JOptionPane.showMessageDialog(null, "Se produjo una excepción al guardar","Validation", JOptionPane.WARNING_MESSAGE);	
				}
			}

		return newProductEarning.getIdProductEarning();
	}
	
}
