package com.java.smartsaleboxfrontend.business.delete;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.SalesClient;
import com.java.smartsalebox.models.Sales;
import com.java.smartsaleboxfrontend.business.read.ReadSaleInfo;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;
import com.java.smartsaleboxfrontend.utils.SmartSaleBoxClearFields;

public class DeleteSaleProcess {
	
	private static final String SELECT_PRODUCT = "Seleccione un producto a eliminar por favor";
	/**
	 * removeSelectedSaleProcess executes the removal process for the tempSale table.
	 */
	public static void removeSelectedSaleProcess() {
		int row;
		int idSale;
		row = SmartSaleBoxMain.tblSale.getSelectedRow();
		if (row > -1) {
			idSale = (Integer) SmartSaleBoxMain.tblSale.getValueAt(row, 7);
			SalesClient.deleteSale(idSale);
			SmartSaleBoxMain.tableModelSale.setRowCount(0);
			Sales[] sales;
			sales = SalesClient.getSaleByNoSale(SmartSaleBoxMain.noSale);
			if (sales.length == 0) {
				SalesClient.truncateSales();
				SmartSaleBoxClearFields.clearSaleMain();
			} else {
				ReadSaleInfo.getSalesByNoSale();
			}
		} else {
			JOptionPane.showMessageDialog(null, SELECT_PRODUCT,"Advertencia", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	/**
	 * removeSelectedSaleProcess executes the removal process for the tempSale table.
	 */
	public static void removeCurrentSaleProcess() {
		//BulkProductsClient.
		SmartSaleBoxClearFields.clearSaleMain();
	}

}
