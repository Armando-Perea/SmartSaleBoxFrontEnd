package com.java.smartsaleboxfrontend.utils;


import com.java.smartsaleboxfrontend.gui.BulkSaleMain;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;

public class SmartSaleBoxClearFields {
	
	public static void clearBulkSaleMain(BulkSaleMain bulkSaleMain) {
		BulkSaleMain.txtBulkProductSearch.setText(null);
		BulkSaleMain.txtBulkBarCode.setText(null);
		BulkSaleMain.txtKiloGrams.setText(null);
		BulkSaleMain.txtKiloPrice.setText(null);
		BulkSaleMain.txtSaleQuantity.setText(null);
		BulkSaleMain.txtBulkProductSelected.setText(null);
		BulkSaleMain.txtBulkSaleId.setText(null);
		BulkSaleMain.txtBulkSaleStock.setText(null);
		BulkSaleMain.tableModelBulkSale.setRowCount(0);
	}
	
	public static void clearSaleMain() {
		SmartSaleBoxMain.tableModelSale.setRowCount(0);
		SmartSaleBoxMain.tableModelCartSale.setRowCount(0);
		SmartSaleBoxMain.txtTotalSale.setText("0.00");
		SmartSaleBoxMain.txtCardPayment.setText("0.00");
		SmartSaleBoxMain.txtReceived.setText("0.00");
		SmartSaleBoxMain.txtChangeBack.setText("0.00");
		SmartSaleBoxMain.txtSaleProductSaleName.setText(null);
		SmartSaleBoxMain.txtProductCodeSearch.setText(null);
		SmartSaleBoxMain.txtCardPayment.setEnabled(false);
	}

}
