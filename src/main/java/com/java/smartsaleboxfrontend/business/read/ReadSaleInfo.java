package com.java.smartsaleboxfrontend.business.read;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.SalesClient;
import com.java.smartsalebox.models.Sales;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;
import com.java.smartsaleboxfrontend.utils.SmartSaleBoxOperations;

public class ReadSaleInfo {
	
	private static final String SALE_NOT_FOUND = "No hay ventas";
	private static final String VALIDATION_UPDATE_TITLE = "Validacion";
	
	/**
	 * getAllSaleTable search process to be shown at list table.
	 */
	public static void getAllSaleTable() {
		Sales[] sales;
		try {
			sales = SalesClient.getAllSales();
			if(sales.length>0) {
				SmartSaleBoxMain.tableModelSale.setRowCount(0);
				for (Sales sal : sales) {
					Object[] saletItems = {sal.getIdSale(),sal.getNoSale(),sal.getDescription(),sal.getPrice(),sal.getUnits(),sal.getTotal(),sal.getIdProduct(),sal.getType()};
					SmartSaleBoxMain.tableModelSale.addRow(saletItems);
				}
				SmartSaleBoxMain.scrollCartSale.setViewportView(SmartSaleBoxMain.tblCartSale);
				SmartSaleBoxMain.txtSubTotal.setText(SmartSaleBoxOperations.getTotalSale(sales));
			}else {
				JOptionPane.showMessageDialog(null,SALE_NOT_FOUND,VALIDATION_UPDATE_TITLE, JOptionPane.INFORMATION_MESSAGE);
				SmartSaleBoxMain.txtSubTotal.setText("0.00");
			}
		}catch(Exception ex) {
			System.out.println("getAllSaleTable error catch: "+ex);
			SmartSaleBoxMain.tableModelSale.setRowCount(0);
			SmartSaleBoxMain.txtSubTotal.setText("0.00");
		}
	}

}
