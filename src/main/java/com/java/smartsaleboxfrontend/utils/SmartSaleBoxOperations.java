package com.java.smartsaleboxfrontend.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.java.smartsalebox.models.Sales;

public class SmartSaleBoxOperations {
	
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

}
