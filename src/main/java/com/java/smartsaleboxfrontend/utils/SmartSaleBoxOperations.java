package com.java.smartsaleboxfrontend.utils;

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

}
