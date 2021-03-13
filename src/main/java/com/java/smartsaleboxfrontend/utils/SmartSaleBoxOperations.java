package com.java.smartsaleboxfrontend.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import com.java.smartsalebox.models.Sales;
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
	
	public static boolean validateScannerReading() {
		String name = SmartSaleBoxMain.txtProductCodeSearch.getText();
		if (name.isEmpty() || name == null) {
			return false;
		}
		return true;
	}

}
