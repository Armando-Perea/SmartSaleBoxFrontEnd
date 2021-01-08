package com.java.smartsaleboxfrontend.business.update;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.BulkProductsClient;
import com.java.smartsalebox.models.BulkProducts;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;

public class UpdateBulkProductProcess {
	
	// tblNewBulkProducts
	private static final String PRODUCT_UPDATED = "Producto Actualizado con Éxito!";
	private static final String PRODUCT_NOT_FOUND = "Producto no existe!";
	private static final String PRODUCT_UPDATE_FAILED = "No es posible actualizar producto";
	private static final String SELECT_PRODUCT = "Seleccione un producto en la tabla";
	private static final String NUMERIC_VALIDATION_ERROR = "Dato debe ser numérico, revise información";
	private static final String VALIDATION_UPDATE_TITLE = "Validacion";
   	private static final String VALIDATION_NUMBER = "java.lang.NumberFormatException";
	private static final String VALIDATION_TOTAL = "java.lang.NumberFormatException";
	
	/**
	 * updateSelectedProductProcess executes the update process for the product table. 
	 */
	//  {adm.getIdAdministrator(),adm.getName(),adm.getLastName(),adm.getPosition(),adm.getEmail(),adm.getPassword()};
	public static void updateBulkProduct() {
		int row;
		Integer bulkProdId;
		int status = 0;
		String barCode,prodName;
		Double costPrice,kiloPrice,earning,grStock,kiloEarning;

		BulkProducts bulkProducts = new BulkProducts();
		row = SmartSaleBoxMain.tblNewBulkProducts.getSelectedRow();
		try {
		if (row > -1) {
			bulkProdId = Integer.parseInt(SmartSaleBoxMain.tblNewBulkProducts.getValueAt(row, 0).toString());
			bulkProducts = BulkProductsClient.getBulkProductById(bulkProdId);
			if(bulkProducts!=null) {
				prodName = (String) SmartSaleBoxMain.tblNewBulkProducts.getValueAt(row, 1);
				costPrice = Double.parseDouble((String) SmartSaleBoxMain.tblNewBulkProducts.getValueAt(row, 2));
				kiloPrice = Double.parseDouble((String) SmartSaleBoxMain.tblNewBulkProducts.getValueAt(row, 3));
				earning = Double.parseDouble((String) SmartSaleBoxMain.tblNewBulkProducts.getValueAt(row, 4));
				grStock = Double.parseDouble((String) SmartSaleBoxMain.tblNewBulkProducts.getValueAt(row, 5));
				kiloEarning = Double.parseDouble((String) SmartSaleBoxMain.tblNewBulkProducts.getValueAt(row, 6));
				barCode = (String) SmartSaleBoxMain.tblNewBulkProducts.getValueAt(row, 7);
					//// SETTING THE VALUES TO CAREER  OBJECT
					if(!prodName.isEmpty()) {
						bulkProducts.setProduct(prodName);
					}
					if(!costPrice.isNaN()) {
						bulkProducts.setCostPrice(costPrice);
					}
					if(!kiloPrice.isNaN()) {
						bulkProducts.setKiloPrice(kiloPrice);
					}
					
					if(!earning.isNaN()) {
						bulkProducts.setEarning(kiloEarning);
					}
					
					if(!grStock.isNaN()) {
						bulkProducts.setGrStock(grStock);
					}
					
					if(!kiloEarning.isNaN()) {
						bulkProducts.setKiloEarning(kiloEarning);
					}

					if(!barCode.isEmpty()) {
						bulkProducts.setBarCode(barCode);
					}

					status = BulkProductsClient.updateBulkProduct(bulkProducts);
					if(status>0 && status<300) {
					JOptionPane.showMessageDialog(null,PRODUCT_UPDATED,VALIDATION_UPDATE_TITLE, JOptionPane.INFORMATION_MESSAGE);
					//ReadAdministrationInfo.fillAllAdminTable();
					}else {
						JOptionPane.showMessageDialog(null,PRODUCT_UPDATE_FAILED,VALIDATION_UPDATE_TITLE, JOptionPane.INFORMATION_MESSAGE);	
					}
					}else {
						JOptionPane.showMessageDialog(null,PRODUCT_NOT_FOUND,VALIDATION_UPDATE_TITLE, JOptionPane.INFORMATION_MESSAGE);	
					}
			}
		else {
			JOptionPane.showMessageDialog(null, SELECT_PRODUCT,VALIDATION_UPDATE_TITLE, JOptionPane.WARNING_MESSAGE);
		}
		}catch(Exception ex) {
			System.out.println("ISSUE: "+ex);
			if(ex.toString().contains(VALIDATION_NUMBER) || ex.toString().contains(VALIDATION_TOTAL)) {
			JOptionPane.showMessageDialog(null, NUMERIC_VALIDATION_ERROR,VALIDATION_UPDATE_TITLE, JOptionPane.WARNING_MESSAGE);	
			}
		}
	}
	
}
