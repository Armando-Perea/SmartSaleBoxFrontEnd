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
	
	public static void clearSaleHistory() {
		SmartSaleBoxMain.tableModelSaleHistory.setRowCount(0);
		SmartSaleBoxMain.txtTotalSaleHistory.setText("0.00");
		SmartSaleBoxMain.txtHistoryNoSale.setText(null);
	}
	
	public static void clearInflowsOutflowsSection() {
		SmartSaleBoxMain.cmbOperationType.setSelectedIndex(0);
		SmartSaleBoxMain.cmbPaymentTypeInOut.setSelectedIndex(0);
		SmartSaleBoxMain.txtInOutConcept.setText(null);
		SmartSaleBoxMain.txtInOutQuantity.setText(null);
	}
	
	public static void clearAdminProcess() {
		SmartSaleBoxMain.tableModelAdmin.setRowCount(0);
		SmartSaleBoxMain.txtAdminName.setText(null);
		SmartSaleBoxMain.txtAdminLast.setText(null);
		SmartSaleBoxMain.txtAdminPhone.setText(null);
		SmartSaleBoxMain.pwdAdmin1.setText(null);
		SmartSaleBoxMain.pwdAdmin2.setText(null);
		SmartSaleBoxMain.cmbAdminRole.setSelectedIndex(0);
	}
	
	public static void clearEmailProcess() {
		SmartSaleBoxMain.tableModelEmail.setRowCount(0);
		SmartSaleBoxMain.txtEmailNew.setText(null);
		SmartSaleBoxMain.pwdEmailNew.setText(null);
	}
	
	public static void clearSystemPathsProcess() {
		SmartSaleBoxMain.tableModelPaths.setRowCount(0);
		SmartSaleBoxMain.txtSystemPathsClosure.setText(null);
		SmartSaleBoxMain.txtSystemPathsInflows.setText(null);
		SmartSaleBoxMain.txtSystemPathsOutflows.setText(null);
		SmartSaleBoxMain.txtSystemPathsEarnings.setText(null);
		SmartSaleBoxMain.txtSystemPathsSales.setText(null);
		SmartSaleBoxMain.txtSystemPathsProducts.setText(null);
	}
	
}
