package com.java.smartsaleboxfrontend.business.read;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.BulkProductsClient;
import com.java.smartsalebox.models.BulkProducts;
import com.java.smartsaleboxfrontend.gui.BulkSaleMain;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;
import com.java.smartsaleboxfrontend.utils.SmartSaleBoxOperations;

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
	
	//{"idProduct","Producto","PrecioCosto","PrecioKilo","Stock grs.","GananciaxKilo","GananciaGranel","CódigoBarras"}
	public static void fillProductBulkTable() {
		BulkProducts[] products;
		try {
			products = BulkProductsClient.getAllBulkProducts();
			if (products.length > 0) {
				SmartSaleBoxMain.tableModelNewBulkProducts.setRowCount(0);
				for (BulkProducts prod : products) {
					Object[] productItems = { prod.getIdBulkProduct(), prod.getProduct(), prod.getCostPrice(), prod.getKiloPrice(),prod.getGrStock(),
							prod.getKiloEarning(),prod.getEarning(),prod.getBarCode() };
					SmartSaleBoxMain.tableModelNewBulkProducts.addRow(productItems);
				}
				SmartSaleBoxMain.scrollNewBulk.setViewportView(SmartSaleBoxMain.tblNewBulkProducts);
			} else {
				JOptionPane.showMessageDialog(null, PRODUCT_NOT_FOUND, VALIDATION_UPDATE_TITLE,
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception ex) {
			System.out.println("ISSUE fillProductBulkTable: " + ex);
		}
	}
	
	public static void fillProductBulkTableByName(String name) {
		BulkProducts[] products;
		try {
			products = BulkProductsClient.getBulkProductByName(name);
			if (products.length > 0) {
				SmartSaleBoxMain.tableModelNewBulkProducts.setRowCount(0);
				for (BulkProducts prod : products) {
					Object[] productItems = { prod.getIdBulkProduct(), prod.getProduct(), prod.getCostPrice(), prod.getKiloPrice(),prod.getGrStock(),
							prod.getKiloEarning(),prod.getEarning(),prod.getBarCode() };
					SmartSaleBoxMain.tableModelNewBulkProducts.addRow(productItems);
				}
				SmartSaleBoxMain.scrollNewBulk.setViewportView(SmartSaleBoxMain.tblNewBulkProducts);
			} else {
				JOptionPane.showMessageDialog(null, PRODUCT_NOT_FOUND, VALIDATION_UPDATE_TITLE,
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception ex) {
			System.out.println("ISSUE fillProductBulkTableByName: " + ex);
		}
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
	
	/**
	 * fillCartSaleTableByName search process to be shown at list table.
	 */
	public static void fillBulkSaleTableByBarCode(String barCode) {
		BulkProducts product;
		try {
			product = BulkProductsClient.getBulkProductByBarCode(barCode);
			if (product != null) {
				BulkSaleMain.tableModelBulkSale.setRowCount(0);

					Object[] productItems = { product.getProduct(), product.getKiloPrice(),
							product.getGrStock(),product.getIdBulkProduct() };
					BulkSaleMain.tableModelBulkSale.addRow(productItems);

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
			BulkSaleMain.txtSaleQuantity.setText(SmartSaleBoxOperations.roundDouble(saleQuantity));
		}catch(Exception ex) {
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
			BulkSaleMain.txtKiloGrams.setText(SmartSaleBoxOperations.roundDouble(kiloGrams));
		}catch(Exception ex) {
			BulkSaleMain.txtKiloGrams.setText("0.00");
		}

	}

}
