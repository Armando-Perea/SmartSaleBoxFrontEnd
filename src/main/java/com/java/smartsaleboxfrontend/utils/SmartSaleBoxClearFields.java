package com.java.smartsaleboxfrontend.utils;


import com.java.smartsaleboxfrontend.gui.BulkSaleMain;

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

}
