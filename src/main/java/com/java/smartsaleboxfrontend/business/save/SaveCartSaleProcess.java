package com.java.smartsaleboxfrontend.business.save;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.CartSaleClient;
import com.java.smartsalebox.models.CartSale;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;

public class SaveCartSaleProcess {
	
	public final static String CASH_SAVED_SUCCESSFULLY="Caja inicializada!";
    public final static String CASH_SAVED_FAILED="No es posible dar de alta Caja en este momento";
    private static final String NUMERIC_VALIDATION_ERROR = "Dato debe ser numérico, revise información";
   	private static final String VALIDATION_NUMBER = "java.lang.NumberFormatException";
	
	public static Integer createNewSale() {
		CartSale newCart = new CartSale();
			try {	
				newCart.setIdCartSale(0);
				newCart.setIdProduct(1);
				newCart.setNoSale(SmartSaleBoxMain.noSale);
				newCart.setDescription("Description");
				newCart.setPrice(0.00);
				newCart.setUnits(1);
				newCart.setTotal(0.00);

				newCart = CartSaleClient.addCartSale(newCart);
				if(newCart.getIdCartSale()!=null) {
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

		return newCart.getIdCartSale();
	}

}
