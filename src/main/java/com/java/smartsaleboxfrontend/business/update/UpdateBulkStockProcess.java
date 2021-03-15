package com.java.smartsaleboxfrontend.business.update;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.BulkProductsClient;
import com.java.smartsalebox.client.ControlBulkStockClient;
import com.java.smartsalebox.models.BulkProducts;
import com.java.smartsalebox.models.ControlBulkStock;
import com.java.smartsalebox.models.Sales;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;
import com.java.smartsaleboxfrontend.utils.SmartSaleBoxOperations;

public class UpdateBulkStockProcess {

	private static final String STOCK_UPDATED = "Stock Actualizado con Éxito!";
	private static final String STOCK_NOT_FOUND = "Id no existe!";
	private static final String STOCK_UPDATE_FAILED = "No es posible actualizar Stock";
	private static final String NUMERIC_VALIDATION_ERROR = "Dato debe ser numérico, revise información";
	private static final String VALIDATION_UPDATE_TITLE = "Validacion";
	private static final String VALIDATION_NUMBER = "java.lang.NumberFormatException";
	private static final String VALIDATION_TOTAL = "java.lang.NumberFormatException";

	public static void updateBulkProductStock() {
		for (Sales sale : SmartSaleBoxMain.bulkList) {
			BulkProducts bulkProduct = BulkProductsClient.getBulkProductById(sale.getIdProduct());
			bulkProduct.setGrStock(bulkProduct.getGrStock() - sale.getUnits());
			BulkProductsClient.updateBulkProduct(bulkProduct);
		}
	}

	public static void updateBulkStock(ControlBulkStock productBulk) {
		int status = 0;
		try {
			productBulk = ControlBulkStockClient.getControlBulkStockById(productBulk.getIdBulkProduct());
			if (productBulk != null) {

				status = ControlBulkStockClient.updateControlBulkStock(productBulk);
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
