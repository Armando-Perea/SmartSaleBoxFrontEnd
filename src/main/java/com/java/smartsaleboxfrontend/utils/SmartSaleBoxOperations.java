package com.java.smartsaleboxfrontend.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.java.smartsalebox.models.Inflow;
import com.java.smartsalebox.models.Outflow;
import com.java.smartsalebox.models.Sales;
import java.text.DecimalFormat;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;

public class SmartSaleBoxOperations {
	
	public final static String CASH_PAYMENT= "EFECTIVO";
	public final static String CARD_PAYMENT = "TARJETA";
	public final static String BOTH_PAYMENT = "AMBOS";
	public final static String GENERAL_TYPE = "GENERAL";
	public final static String BULK_TYPE = "BULK";
	
	public static String calculateProductEarning(Double salePrice, Double costPrice) {
		Double earning = salePrice-costPrice;
		return earning.toString();
	}
	
	public static String calculateBulkProductKiloEarning(Double costPrice, Double stock, Double kiloPrice) {
		Double earning = kiloPrice- (costPrice/ (stock/1000));
		return earning.toString();
	}
	
	public static String calculateBulkProductEarning(Double costPrice, Double stock, Double kiloPrice) {
		Double earning = (kiloPrice*(stock/1000))-costPrice;
		return earning.toString();
	}
	
	public static String getTotalSale(Sales[] sales) {
		double cantidad=0.0;
		String finalTotal;
		for (Sales temporarySale : sales) {
			cantidad = cantidad+temporarySale.getTotal();
		}
		
		finalTotal =roundDouble(cantidad);
		return finalTotal;
	}
	
	public static String roundDouble(double d) {
		BigDecimal bigDecimal = new BigDecimal(Double.toString(d));
		bigDecimal = bigDecimal.setScale(0, RoundingMode.CEILING);
		return bigDecimal.toString();
	}
	
	public static String getTwoDecimalFormat(double quantity) {
		DecimalFormat df2 = new DecimalFormat("#.##");
		return df2.format(quantity);
	}
	
	public static void saleReceivedCashProcess() {
		if(SmartSaleBoxMain.txtReceived.getText().isEmpty() || SmartSaleBoxMain.txtCardPayment.getText().isEmpty()) {
			SmartSaleBoxMain.txtChangeBack.setText("0.00");
		}
		else {
			SmartSaleBoxMain.txtChangeBack.setText(getChangeSale());
		}
	}
	
	public static String getChangeSale() {
		double total;
		double cardPayment;
		double received;
		double change;
		String finalChange="0.0";
		try {
		total = Double.parseDouble(SmartSaleBoxMain.txtTotalSale.getText());
		cardPayment = Double.parseDouble(SmartSaleBoxMain.txtCardPayment.getText());
		received = Double.parseDouble(SmartSaleBoxMain.txtReceived.getText());
		change = (cardPayment+received)-total;
		finalChange = String.valueOf(change);
		}catch(NumberFormatException nf) {
			System.out.println("Number Format not valid, no letters allowed at change field");
		}
		return finalChange;
	}
	
	public static boolean isValidSaleQuantity() {
		double total;
		double cardPayment;
		double received;
		double totalReceived;
		try {
		total = Double.parseDouble(SmartSaleBoxMain.txtTotalSale.getText());
		cardPayment = Double.parseDouble(SmartSaleBoxMain.txtCardPayment.getText());
		received = Double.parseDouble(SmartSaleBoxMain.txtReceived.getText());
		totalReceived = cardPayment+received;
		return totalReceived>=total;
		}catch(NumberFormatException nf) {
			System.out.println("Number Format not valid, no letters allowed at change field");
		}
		return false;
	}
	
	public static boolean isValidCashChange() {
		try {
			return SmartSaleBoxMain.cash > Double.parseDouble(SmartSaleBoxMain.txtChangeBack.getText());
		} catch (NumberFormatException nf) {
			System.out.println("Number Format not valid, no letters allowed at change field");
			return false;
		}
	}
	
	public static String getPaymentType() {
		Double paymentCard = Double.parseDouble(SmartSaleBoxMain.txtCardPayment.getText());
		Double paymentCash = Double.parseDouble(SmartSaleBoxMain.txtReceived.getText());
		if(paymentCash==0.0 && paymentCard>0.0) {
			return CARD_PAYMENT;
		}else if(paymentCash>0.0 && paymentCard>0.0){
			return BOTH_PAYMENT;
		}
		return CASH_PAYMENT;
	}
	
	public static boolean validateAdminPasswords() {
		String pass1 = new String(SmartSaleBoxMain.pwdAdmin1.getPassword());
		String pass2 = new String(SmartSaleBoxMain.pwdAdmin2.getPassword());
		if (pass1.equals(pass2)) {
			return true;
		}
		return false;
	}
	
	public static Integer sumNewQuantity(Integer quantity, Integer newQuantity) {
		return quantity+newQuantity;
	}
	
	public static Double getTotalEarning(Integer quantity, Double unitEarning) {
		return quantity*unitEarning;
	}
	
	public static Double getTotalBulkEarning(Integer quantity, Double kiloEarning) {
		return (quantity*kiloEarning)/1000;
	}
	
	public static boolean validateGetProdName() {
		String name = SmartSaleBoxMain.txtSaleProductSaleName.getText();
		if (name.isEmpty() || name == null) {
			return false;
		}
		return true;
	}
	
	public static boolean validateGetProdNameSearch() {
		String name = SmartSaleBoxMain.txtGetProductNameSearch.getText();
		if (name.isEmpty() || name == null) {
			return false;
		}
		return true;
	}
	
	public static boolean validateGetBulkProdNameSearch() {
		String name = SmartSaleBoxMain.txtBulkProdSearch.getText();
		if (name.isEmpty() || name == null) {
			return false;
		}
		return true;
	}
	
	public static boolean validateGetSaleHistoryByNoSale() {
		String noSale = SmartSaleBoxMain.txtHistoryNoSale.getText();
		if (noSale.isEmpty() || noSale == null) {
			return false;
		}
		return true;
	}

	public static boolean validateEmailConfig() {
		
		String email = SmartSaleBoxMain.txtEmailNew.getText();
		String pass = new String(SmartSaleBoxMain.pwdAdmin1.getPassword());
		
		if (email.isEmpty() || email == null &&
				pass.isEmpty() || pass == null	) {
			return false;
		}
		return true;
	}
	
	public static boolean validateAdminFields() {
		String name = SmartSaleBoxMain.txtAdminName.getText();
		String lastName = SmartSaleBoxMain.txtAdminLast.getText();
		String phone = SmartSaleBoxMain.txtAdminPhone.getText();
		String role = ((String) SmartSaleBoxMain.cmbAdminRole.getSelectedItem());
		String pass = new String(SmartSaleBoxMain.pwdAdmin1.getPassword());
		
		if (name.isEmpty() || name == null && 
			lastName.isEmpty() || lastName == null &&
			phone.isEmpty() || phone == null &&
			role.isEmpty() || role == null &&
			pass.isEmpty() || pass == null) {
			return false;
		}
		return true;
	}
	
	public static boolean validateSystemPaths() {
		
		String closure = SmartSaleBoxMain.txtSystemPathsClosure.getText();
		String inflows = SmartSaleBoxMain.txtSystemPathsInflows.getText();
		String outflows = SmartSaleBoxMain.txtSystemPathsOutflows.getText();
		String earnings = SmartSaleBoxMain.txtSystemPathsEarnings.getText();
		String products = SmartSaleBoxMain.txtSystemPathsProducts.getText();
		String sales = SmartSaleBoxMain.txtSystemPathsSales.getText();
		if (closure.isEmpty() || closure == null &&
			inflows.isEmpty() || closure == null &&
			outflows.isEmpty() || closure == null &&
			earnings.isEmpty() || closure == null &&
			products.isEmpty() || closure == null &&
			sales.isEmpty() || closure == null ) {
			return false;
		}
		return true;
	}
	
public static boolean validateClosure() {
		
		String txtTotalCardClosure = SmartSaleBoxMain.txtTotalCardClosure.getText();
		String txtTotalCashClosure = SmartSaleBoxMain.txtTotalCashClosure.getText();
		String txtTotalCashBoxClosure = SmartSaleBoxMain.txtTotalCashBoxClosure.getText();
		String txtTotalEarningsClosure = SmartSaleBoxMain.txtTotalEarningsClosure.getText();
		String txtInitialCashClosure = SmartSaleBoxMain.txtInitialCashClosure.getText();
		String txtTotalProductClosure = SmartSaleBoxMain.txtTotalProductClosure.getText();
		String txtTotalInflowsClosure = SmartSaleBoxMain.txtTotalInflowsClosure.getText();
		String txtTotalOutflowsClosure = SmartSaleBoxMain.txtTotalOutflowsClosure.getText();
		if (txtTotalCardClosure.isEmpty() || txtTotalCardClosure == null &&
			txtTotalCashClosure.isEmpty() || txtTotalCashClosure == null &&
			txtTotalCashBoxClosure.isEmpty() || txtTotalCashBoxClosure == null &&
			txtTotalEarningsClosure.isEmpty() || txtTotalEarningsClosure == null &&
			txtInitialCashClosure.isEmpty() || txtInitialCashClosure == null &&
			txtTotalProductClosure.isEmpty() || txtTotalProductClosure == null &&
			txtTotalInflowsClosure.isEmpty() || txtTotalInflowsClosure == null &&
			txtTotalOutflowsClosure.isEmpty() || txtTotalOutflowsClosure == null) {
			return false;
		}
		return true;
	}
	
	public static boolean validateScannerReading() {
		String name = SmartSaleBoxMain.txtProductCodeSearch.getText();
		if (name.isEmpty() || name == null) {
			return false;
		}
		return true;
	}
	
	public static String getTotalInflows(Inflow[] inflows) {
		double quantity=0.0;
		String finalTotal;
		for (Inflow ins : inflows) {
			quantity = quantity+ins.getQuantity();
		}
		finalTotal = String.valueOf(quantity);
		return finalTotal;
	}
	
	public static String getTotalOutflows(Outflow[] outflows) {
		double quantity=0.0;
		String finalTotal;
		for (Outflow outs : outflows) {
			quantity = quantity+outs.getQuantity();
		}
		finalTotal = String.valueOf(quantity);
		return finalTotal;
	}

}
