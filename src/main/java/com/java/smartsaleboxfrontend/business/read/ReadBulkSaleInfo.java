package com.java.smartsaleboxfrontend.business.read;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.BulkProductsClient;
import com.java.smartsalebox.models.BulkProducts;
import com.java.smartsaleboxfrontend.gui.BulkSaleMain;

public class ReadBulkSaleInfo {

	private static final String PRODUCT_NOT_FOUND = "Producto no existe!";
	private static final String VALIDATION_UPDATE_TITLE = "Validacion";

	public static boolean validateGetBulkProdName() {
		String pwd = BulkSaleMain.txtBulkProductSearch.getText();
		if (pwd.isEmpty() || pwd == null) {
			return false;
		}
		return true;
	}

	/**
	 * fillCartSaleTableByName search process to be shown at list table.
	 */
	public static void fillBulkSaleTableByName(String product) {
		BulkProducts[] products;
		try {
			products = BulkProductsClient.getBulkProductByName(product);
			if (products.length > 0) {
				BulkSaleMain.tableModelBulkSale.setRowCount(0);
				for (BulkProducts prod : products) {
					Object[] productItems = { prod.getProduct(), prod.getKiloPrice(),
							prod.getGrStock(),prod.getIdBulkProduct() };
					BulkSaleMain.tableModelBulkSale.addRow(productItems);
				}
				BulkSaleMain.scrollBulkSale.setViewportView(BulkSaleMain.tblBulkSale);
			} else {
				JOptionPane.showMessageDialog(null, PRODUCT_NOT_FOUND, VALIDATION_UPDATE_TITLE,
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception ex) {
			System.out.println("ISSUE: " + ex);
		}
	}
	
	public static void calculatePrice() {
		Double kiloPrice, kiloGrams ,saleQuantity, kilo;
		kilo=1000.0;
		try {
			kiloGrams = Double.parseDouble(BulkSaleMain.txtKiloGrams.getText());
			kiloPrice = Double.parseDouble(BulkSaleMain.txtKiloPrice.getText());
			saleQuantity = (kiloGrams*kiloPrice)/kilo;
			BulkSaleMain.txtSaleQuantity.setText(roundDouble(saleQuantity));
		}catch(Exception ex) {
			BulkSaleMain.txtKiloGrams.setText("0.00");
			BulkSaleMain.txtSaleQuantity.setText("0.00");
		}

	}
	
	public static void calculateGrams() {
		Double kiloPrice, kiloGrams ,saleQuantity, kilo;
		kilo=1000.0;
		try {
			saleQuantity = Double.parseDouble(BulkSaleMain.txtSaleQuantity.getText());
			kiloPrice = Double.parseDouble(BulkSaleMain.txtKiloPrice.getText());
			kiloGrams = (saleQuantity*kilo)/kiloPrice;
			BulkSaleMain.txtKiloGrams.setText(roundDouble(kiloGrams));
		}catch(Exception ex) {
			BulkSaleMain.txtKiloGrams.setText("0.00");
			BulkSaleMain.txtSaleQuantity.setText("0.00");
		}

	}

	private static String roundDouble(double d) {
		BigDecimal bigDecimal = new BigDecimal(Double.toString(d));
		bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);
		return bigDecimal.toString();
	}

}
