package com.java.smartsaleboxfrontend.business.save;

import java.sql.Date;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.SalesClient;
import com.java.smartsalebox.models.Sales;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;

public class SaveSaleProcess {

		public final static String SALE_SAVED_SUCCESSFULLY=" ha sido dado de alta con éxito!";
	    public final static String SALE_SAVED_FAILED="No es posible dar de alta Venta en este momento";
	    private static final String NUMERIC_VALIDATION_ERROR = "Dato debe ser numérico, revise información";
	   	private static final String VALIDATION_NUMBER = "java.lang.NumberFormatException";
		
		public static Integer createNewSale() {
			Sales newSale = new Sales();
				try {	
					newSale.setIdSale(0);
					newSale.setNoSale(SmartSaleBoxMain.noSale);
					newSale.setCardFare(00.00);
					newSale.setDescription("");
					newSale.setPaymentType("");
					newSale.setPrice(00.00);
					newSale.setTotal(00.00);
					newSale.setUnits(8);
					newSale.setSaleDate(new Date(12L));
					
					newSale = SalesClient.addSale(newSale);
					if(newSale.getIdSale()!=null) {
						JOptionPane.showMessageDialog(null, SALE_SAVED_SUCCESSFULLY);
					}else {
						JOptionPane.showMessageDialog(null,SALE_SAVED_FAILED);
					}
				}catch(Exception ex) {
					System.out.println("ISSUE: "+ex);
					if(ex.toString().contains(VALIDATION_NUMBER)) {
					JOptionPane.showMessageDialog(null, NUMERIC_VALIDATION_ERROR,"Validation", JOptionPane.WARNING_MESSAGE);	
					}else {
					JOptionPane.showMessageDialog(null, "Se produjo una excepción al guardar","Validation", JOptionPane.WARNING_MESSAGE);	
					}
				}

			return newSale.getIdSale();
		}
		
}
