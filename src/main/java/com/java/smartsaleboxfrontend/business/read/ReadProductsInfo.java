package com.java.smartsaleboxfrontend.business.read;

import javax.swing.JOptionPane;

import com.java.smartsalebox.models.Products;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;

public class ReadProductsInfo {
	
	
	public static boolean validateGetProdName() {
		String pwd = SmartSaleBoxMain.txtSaleProductSaleName.getText();
		if(pwd.isEmpty() || pwd==null) {
			return false;
		}
		return true;
	}
	
//	/**
//	 * searchByStudentId search process to be shown at list table.
//	 */
//	public static void fillCartSaleTableByName(String product) {
//		Products[] products;
//		try {
//			products = ProductsClient.getProductByName(product);
//			if(products.length>0) {
//				SmartSaleBoxMain.tableModelAdmin.setRowCount(0);
//				for (Products std : products) {
//					Object[] studentItems = {std.getIdStudent(),std.getIdCareer(),std.getCareerDescription()};
//					SmartSaleBoxMain.tableModelAdmin.addRow(studentItems);
//				}
//				SmartSaleBoxMain.scrollPaneCartSale.setViewportView(SmartSaleBoxMain.tblUpdateStudent);
//			}else {
//				JOptionPane.showMessageDialog(null,STUDENT_NOT_FOUND,VALIDATION_UPDATE_TITLE, JOptionPane.INFORMATION_MESSAGE);	
//			}
//		}catch(NumberFormatException | ClassCastException ex) {
//			System.out.println("ISSUE: "+ex);
//			if(ex.toString().contains(VALIDATION_NUMBER)) {
//			JOptionPane.showMessageDialog(null, NUMERIC_VALIDATION_ERROR,VALIDATION_UPDATE_TITLE, JOptionPane.WARNING_MESSAGE);	
//			}
//		}
//	}

}
