package com.java.smartsaleboxfrontend.business.read;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.ProductsClient;
import com.java.smartsalebox.models.Products;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;

public class ReadProductsInfo {
	
	private static final String PRODUCT_NOT_FOUND = "Producto no existe!";
	private static final String VALIDATION_UPDATE_TITLE = "Validacion";

	// {"idProduct","Producto","Tipo","PrecioCosto","PrecioVenta","Ganancia","Stock","CódigoBarras"};
	public static void fillProductTable() {
		Products[] products;
		try {
			products = ProductsClient.getAllProducts();
			if (products.length > 0) {
				SmartSaleBoxMain.tableModelNewProduct.setRowCount(0);
				for (Products prod : products) {
					Object[] productItems = { prod.getIdProduct(), prod.getProduct(), prod.getCostPrice(), prod.getSalePrice(), prod.getEarning(),
							prod.getStock(),prod.getBarCode() };
					SmartSaleBoxMain.tableModelNewProduct.addRow(productItems);
				}
				SmartSaleBoxMain.scrollGetProduct.setViewportView(SmartSaleBoxMain.tblNewProduct);
			} else {
				JOptionPane.showMessageDialog(null, PRODUCT_NOT_FOUND, VALIDATION_UPDATE_TITLE,
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception ex) {
			System.out.println("ISSUE fillProductTable: " + ex);
		}
	}
	
	
	public static void fillProductTableByName(String product) {
		Products[] products;
		try {
			products = ProductsClient.getProductByName(product);
			if (products.length > 0) {
				SmartSaleBoxMain.tableModelNewProduct.setRowCount(0);
				for (Products prod : products) {
					Object[] productItems = { prod.getIdProduct(), prod.getProduct(), prod.getCostPrice(), prod.getSalePrice(), prod.getEarning(),
							prod.getStock(),prod.getBarCode() };
					SmartSaleBoxMain.tableModelNewProduct.addRow(productItems);
				}
				SmartSaleBoxMain.scrollGetProduct.setViewportView(SmartSaleBoxMain.tblNewProduct);
			} else {
				JOptionPane.showMessageDialog(null, PRODUCT_NOT_FOUND, VALIDATION_UPDATE_TITLE,
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception ex) {
			System.out.println("ISSUE fillProductTableByName: " + ex);
		}
	}

}
