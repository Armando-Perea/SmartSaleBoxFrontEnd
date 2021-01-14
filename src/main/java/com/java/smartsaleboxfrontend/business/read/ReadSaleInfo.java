package com.java.smartsaleboxfrontend.business.read;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.SalesClient;
import com.java.smartsalebox.models.Sales;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;

public class ReadSaleInfo {
	
	private static final String SALE_NOT_FOUND = "No hay ventas";
	private static final String VALIDATION_UPDATE_TITLE = "Validacion";
	
	/**
	 * searchByStudentId search process to be shown at list table.
	 */
	public static void getAllSaleTable() {
		Sales[] sales;
		try {
			sales = SalesClient.getAllSales();
			if(sales.length>0) {
				SmartSaleBoxMain.tableModelSale.setRowCount(0);
				for (Sales sal : sales) {
					Object[] saletItems = {sal.getIdSale(),sal.getNoSale(),sal.getDescription(),sal.getPrice(),sal.getUnits(),sal.getTotal()};
					SmartSaleBoxMain.tableModelSale.addRow(saletItems);
				//  {"idSale","noSale","Description","Precio","Unidades","total" };
				}
				SmartSaleBoxMain.scrollCartSale.setViewportView(SmartSaleBoxMain.tblCartSale);
			}else {
				JOptionPane.showMessageDialog(null,SALE_NOT_FOUND,VALIDATION_UPDATE_TITLE, JOptionPane.INFORMATION_MESSAGE);	
			}
		}catch(Exception ex) {
			System.out.println("ISSUE: "+ex);
		}
	}

}
