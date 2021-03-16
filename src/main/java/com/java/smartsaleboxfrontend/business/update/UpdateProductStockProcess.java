package com.java.smartsaleboxfrontend.business.update;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.ControlProductStockClient;
import com.java.smartsalebox.client.ProductsClient;
import com.java.smartsalebox.models.ControlProductStock;
import com.java.smartsalebox.models.Products;
import com.java.smartsalebox.models.Sales;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;
import com.java.smartsaleboxfrontend.utils.SmartSaleBoxOperations;

public class UpdateProductStockProcess {

	private static final String STOCK_UPDATED = "Stock Actualizado con Éxito!";
	private static final String STOCK_NOT_FOUND = "Id no existe!";
	private static final String STOCK_UPDATE_FAILED = "No es posible actualizar Stock";
	private static final String NUMERIC_VALIDATION_ERROR = "Dato debe ser numérico, revise información";
	private static final String VALIDATION_UPDATE_TITLE = "Validacion";
	private static final String VALIDATION_NUMBER = "java.lang.NumberFormatException";
	private static final String VALIDATION_TOTAL = "java.lang.NumberFormatException";

	public static void updateGeneralProductStock() {
		for (Sales sale : SmartSaleBoxMain.salesList) {
			Products product = ProductsClient.getProductById(sale.getIdProduct());
			product.setStock(product.getStock() - sale.getUnits());
			ProductsClient.updateProduct(product);
		}
	}

	public static void updateProductStock(ControlProductStock productStock) {
		int status = 0;
		try {
			productStock = ControlProductStockClient
					.getControlProductStockById(productStock.getIdControlProductStock());
			if (productStock != null) {

				status = ControlProductStockClient.updateControlProductStock(productStock);
				if (status > 0 && status < 300) {
					JOptionPane.showMessageDialog(null, STOCK_UPDATED, VALIDATION_UPDATE_TITLE,
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, STOCK_UPDATE_FAILED, VALIDATION_UPDATE_TITLE,
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, STOCK_NOT_FOUND, VALIDATION_UPDATE_TITLE,
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception ex) {
			System.out.println("ISSUE: " + ex);
			if (ex.toString().contains(VALIDATION_NUMBER) || ex.toString().contains(VALIDATION_TOTAL)) {
				JOptionPane.showMessageDialog(null, NUMERIC_VALIDATION_ERROR, VALIDATION_UPDATE_TITLE,
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}

}
