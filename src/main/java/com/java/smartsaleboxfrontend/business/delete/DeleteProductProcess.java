package com.java.smartsaleboxfrontend.business.delete;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.ProductsClient;
import com.java.smartsaleboxfrontend.business.read.ReadProductsInfo;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;

public class DeleteProductProcess {
	
	private static final String PRODUCT_DELETED = "Producto ha sido borrado!";
	private static final String PRODUCT_NOT_DELETED = "No es posible borrar producto en este momento";
	private static final String SELECT_PRODUCT = "Seleccione un producto a eliminar por favor";

	public static void removeSelectedProduct() {
		int row;
		int idProduct;
		int status=0;
		row = SmartSaleBoxMain.tblNewProduct.getSelectedRow();
		if (row > -1) {
			idProduct = Integer.parseInt(SmartSaleBoxMain.tblNewProduct.getValueAt(row, 0).toString());
			status = ProductsClient.deleteProduct(idProduct);
			if(status >=200 && status < 400) {
				SmartSaleBoxMain.tableModelNewProduct.setRowCount(0);
				ReadProductsInfo.fillProductTable();
				JOptionPane.showMessageDialog(null, PRODUCT_DELETED,"Advertencia", JOptionPane.WARNING_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, PRODUCT_NOT_DELETED,"Advertencia", JOptionPane.WARNING_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, SELECT_PRODUCT,"Advertencia", JOptionPane.WARNING_MESSAGE);
		}
	}

}
