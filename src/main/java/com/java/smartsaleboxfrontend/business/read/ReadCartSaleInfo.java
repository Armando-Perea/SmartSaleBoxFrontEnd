package com.java.smartsaleboxfrontend.business.read;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.ProductsClient;
import com.java.smartsalebox.client.SalesClient;
import com.java.smartsalebox.models.Products;
import com.java.smartsalebox.models.Sales;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;

public class ReadCartSaleInfo {

	private static final String PRODUCT_NOT_FOUND = "Producto no existe!";
	private static final String VALIDATION_UPDATE_TITLE = "Validacion";

	public static boolean validateGetProdName() {
		String pwd = SmartSaleBoxMain.txtSaleProductSaleName.getText();
		if (pwd.isEmpty() || pwd == null) {
			return false;
		}
		return true;
	}

	/**
	 * searchByStudentId search process to be shown at list table.
	 */
	public static void fillCartSaleTableByName(String product) {
		Products[] products;
		try {
			products = ProductsClient.getProductByName(product);
			if (products.length > 0) {
				SmartSaleBoxMain.tableModelCartSale.setRowCount(0);
				for (Products prod : products) {
					Object[] productItems = { prod.getIdProduct(), prod.getProduct(), prod.getSalePrice(),
							prod.getStock() };
					SmartSaleBoxMain.tableModelCartSale.addRow(productItems);
				}
				SmartSaleBoxMain.scrollCartSale.setViewportView(SmartSaleBoxMain.tblCartSale);
			} else {
				JOptionPane.showMessageDialog(null, PRODUCT_NOT_FOUND, VALIDATION_UPDATE_TITLE,
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception ex) {
			System.out.println("ISSUE: " + ex);
		}
	}


}
