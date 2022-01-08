package com.java.smartsaleboxfrontend.business.update;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.ProductsClient;
import com.java.smartsalebox.models.Products;
import com.java.smartsaleboxfrontend.business.read.ReadProductsInfo;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;

public class UpdateProductProcess {

	// tblNewBulkProducts
	private static final String PRODUCT_UPDATED = "Producto Actualizado con Éxito!";
	private static final String BARCODE_ALREADYEXISTS = "El código de barras ya existe y corresponde al producto: ";
	private static final String PRODUCT_NOT_FOUND = "Producto no existe!";
	private static final String PRODUCT_UPDATE_FAILED = "No es posible actualizar producto";
	private static final String SELECT_PRODUCT = "Seleccione un producto en la tabla";
	private static final String NUMERIC_VALIDATION_ERROR = "Dato debe ser numérico, revise información";
	private static final String VALIDATION_UPDATE_TITLE = "Validacion";
	private static final String VALIDATION_NUMBER = "java.lang.NumberFormatException";
	private static final String VALIDATION_TOTAL = "java.lang.NumberFormatException";

	/**
	 * updateSelectedProductProcess executes the update process for the product
	 * table.
	 */
	// {"idProduct","Producto","Tipo","PrecioCosto","PrecioVenta","Ganancia","Stock","CódigoBarras"};
	public static void updateSelectedProduct() {
		int row;
		Integer productId, stock;
		int status = 0;
		String barCode, prodName;
		Double costPrice, saleprice, earning;
		Boolean updateProd = true;

		Products product = new Products();
		Products productBarcode = new Products();
		row = SmartSaleBoxMain.tblNewProduct.getSelectedRow();
		try {
			if (row > -1) {
				productId = Integer.parseInt(SmartSaleBoxMain.tblNewProduct.getValueAt(row, 0).toString());
				product = ProductsClient.getProductById(productId);
				if (product != null) {
					prodName = (String) SmartSaleBoxMain.tblNewProduct.getValueAt(row, 1);
					costPrice = Double.parseDouble(SmartSaleBoxMain.tblNewProduct.getValueAt(row, 2).toString());
					saleprice = Double.parseDouble(SmartSaleBoxMain.tblNewProduct.getValueAt(row, 3).toString());
					earning = Double.parseDouble(SmartSaleBoxMain.tblNewProduct.getValueAt(row, 4).toString());
					stock = Integer.parseInt(SmartSaleBoxMain.tblNewProduct.getValueAt(row, 5).toString());
					barCode = (String) SmartSaleBoxMain.tblNewProduct.getValueAt(row, 6);
					//// SETTING THE VALUES TO CAREER OBJECT
					if (!barCode.isEmpty()) {
						productBarcode = ProductsClient.getProductByBarCode(barCode);
						if(productBarcode != null) {
							if(productBarcode.getProduct() == product.getProduct()) 
								product.setBarCode(barCode);
							else
								updateProd =false;
						}else {
							product.setBarCode(barCode);
						}
					}
					if (!prodName.isEmpty() && updateProd) {
						product.setProduct(prodName);
					}
					if (!costPrice.isNaN() && updateProd) {
						product.setCostPrice(costPrice);
					}
					if (!saleprice.isNaN() && updateProd) {
						product.setSalePrice(saleprice);
					}

					if (!earning.isNaN() && updateProd) {
						product.setEarning(saleprice-costPrice);
					}

					if (stock > -1  && updateProd) {
						product.setStock(stock);
					}
						
					if(updateProd) {
						status = ProductsClient.updateProduct(product);
						if (status > 0 && status < 300) {
							JOptionPane.showMessageDialog(null, PRODUCT_UPDATED, VALIDATION_UPDATE_TITLE,
									JOptionPane.INFORMATION_MESSAGE);
							ReadProductsInfo.fillProductTable();
						} else {
							JOptionPane.showMessageDialog(null, PRODUCT_UPDATE_FAILED, VALIDATION_UPDATE_TITLE,
									JOptionPane.INFORMATION_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null, BARCODE_ALREADYEXISTS+productBarcode.getProduct()+"\n Intente otro código porfavor", VALIDATION_UPDATE_TITLE,
								JOptionPane.INFORMATION_MESSAGE);
						ReadProductsInfo.fillProductTable();
					}
					
				} else {
					JOptionPane.showMessageDialog(null, PRODUCT_NOT_FOUND, VALIDATION_UPDATE_TITLE,
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, SELECT_PRODUCT, VALIDATION_UPDATE_TITLE,
						JOptionPane.WARNING_MESSAGE);
			}
		} catch (Exception ex) {
			System.out.println("ISSUE updateSelectedProduct: " + ex.getMessage());
			if (ex.toString().contains(VALIDATION_NUMBER) || ex.toString().contains(VALIDATION_TOTAL)) {
				JOptionPane.showMessageDialog(null, NUMERIC_VALIDATION_ERROR, VALIDATION_UPDATE_TITLE,
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}

}
