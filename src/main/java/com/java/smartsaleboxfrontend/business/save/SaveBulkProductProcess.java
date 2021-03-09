package com.java.smartsaleboxfrontend.business.save;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.BulkProductsClient;
import com.java.smartsalebox.models.BulkProducts;
import com.java.smartsaleboxfrontend.gui.BulkSaleMain;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;

public class SaveBulkProductProcess {

		public final static String PRODUCT_SAVED_SUCCESSFULLY=" ha sido dado de alta con éxito!";
	    public final static String PRODUCT_SAVED_FAILED="No es posible dar de alta Producto en este momento";
	    private static final String NUMERIC_VALIDATION_ERROR = "Dato debe ser numérico, revise información";
	   	private static final String VALIDATION_NUMBER = "java.lang.NumberFormatException";
		
	   	public static void addBulkProductToSaleList(java.awt.event.MouseEvent evt) {
			int fila = BulkSaleMain.tblBulkSale.rowAtPoint(evt.getPoint());
			int columna = BulkSaleMain.tblBulkSale.columnAtPoint(evt.getPoint());
			int datos = BulkSaleMain.tblBulkSale.getSelectedRow();
			String product, price, idProdBulk, stockBulk;

			if ((fila > -1) && (columna > -1)) {
				product = (BulkSaleMain.tableModelBulkSale.getValueAt(datos, 0)).toString();
				price = (BulkSaleMain.tableModelBulkSale.getValueAt(datos, 1)).toString();
				stockBulk = (BulkSaleMain.tableModelBulkSale.getValueAt(datos, 2)).toString();
				idProdBulk = (BulkSaleMain.tableModelBulkSale.getValueAt(datos, 3)).toString();
				BulkSaleMain.txtBulkProductSelected.setText(product);
				BulkSaleMain.txtKiloPrice.setText(price);
				BulkSaleMain.txtBulkSaleId.setText(idProdBulk);
				BulkSaleMain.txtBulkSaleStock.setText(stockBulk);
			}
		}
	   	
		public static Integer createNewBulkProduct() {
			BulkProducts newBulkProduct = new BulkProducts();
				try {	
					newBulkProduct.setIdBulkProduct(0);
					newBulkProduct.setProduct(SmartSaleBoxMain.txtNewBulkProductName.getText());
					newBulkProduct.setKiloPrice(Double.parseDouble(SmartSaleBoxMain.txtNewBulkKiloPrice.getText()));
					newBulkProduct.setCostPrice(Double.parseDouble(SmartSaleBoxMain.txtNewBulkCostPrice.getText()));
					newBulkProduct.setKiloEarning(Double.parseDouble(SmartSaleBoxMain.txtNewBulkKiloEarning.getText()));
					newBulkProduct.setEarning(Double.parseDouble(SmartSaleBoxMain.txtNewBulkEarning.getText()));
					newBulkProduct.setGrStock(Double.parseDouble(SmartSaleBoxMain.txtNewBulkStock.getText()));
					newBulkProduct.setBarCode(SmartSaleBoxMain.txtNewBulkBarCodeProd.getText());
					newBulkProduct.setType("BULK");
					newBulkProduct = BulkProductsClient.addBulkProduct(newBulkProduct);
					if(newBulkProduct.getIdBulkProduct()!=null) {
						JOptionPane.showMessageDialog(null, newBulkProduct.getProduct()+PRODUCT_SAVED_SUCCESSFULLY);
					}else {
						JOptionPane.showMessageDialog(null,PRODUCT_SAVED_FAILED);
					}
				}catch(Exception ex) {
					System.out.println("ISSUE: "+ex);
					if(ex.toString().contains(VALIDATION_NUMBER)) {
					JOptionPane.showMessageDialog(null, NUMERIC_VALIDATION_ERROR,"Validation", JOptionPane.WARNING_MESSAGE);	
					}else {
					JOptionPane.showMessageDialog(null, "Se produjo una excepción al querer guardar","Validation", JOptionPane.WARNING_MESSAGE);	
					}
				}

			return newBulkProduct.getIdBulkProduct();
		}
		
}
