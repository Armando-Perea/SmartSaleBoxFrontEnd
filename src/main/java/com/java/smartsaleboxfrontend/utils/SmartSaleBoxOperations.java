package com.java.smartsaleboxfrontend.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import com.java.smartsalebox.client.CartSaleClient;
import com.java.smartsalebox.client.ProductEarningsClient;
import com.java.smartsalebox.client.ProductsClient;
import com.java.smartsalebox.models.CartSale;
import com.java.smartsalebox.models.ProductEarnings;
import com.java.smartsalebox.models.Products;
import com.java.smartsalebox.models.Sales;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;

public class SmartSaleBoxOperations {
	
	public final static String CASH_PAYMENT= "EFECTIVO";
	public final static String CARD_PAYMENT = "TARJETA";
	public final static String BOTH_PAYMENT = "AMBOS";
	
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
		if(SmartSaleBoxMain.txtReceived.getText().isEmpty()) {
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
	
	// AGREGAR MISMO PROCESO PARA BULK, CONSIDERAR CREAR UNA TABLA PARA GANANCIAS DE BULK
	public void fillProductEarning(List<Sales> salesList) {
//		List<CartSale> cartSaleList = Arrays.asList(CartSaleClient.getAllCartSale());
//		System.out.println("Si hay elementos en el carrito de ventas: ");
		salesList.forEach(System.out::println);
		for(Sales cartSale : salesList) {
			System.out.println("Obteniendo Producto por ID: ");
			Products product = ProductsClient.getProductById(cartSale.getIdProduct());
			if(product != null) {
				System.out.println("Producto Existe!");
				System.out.println("Revisando si el producto ya esta registrado en la lista de ganancias");
				List<ProductEarnings> productEarningsList = Arrays.asList(ProductEarningsClient.getProductEarningsByProductId(cartSale.getIdProduct()));
				System.out.println("Si hay elementos en el reporte de ganancias: "+productEarningsList.size());
				productEarningsList.forEach(System.out::println);
					if(productEarningsList.get(0)==null) {
						System.out.println("Nuevo Producto Para Informe de ganancias");
						addEarning(product,cartSale,product.getStock());
					}else {
						System.out.println("Actualizando Producto para Informe de ganancias");
						updateEarning(productEarningsList.get(0),cartSale,product.getStock());
					}
				
			}else {
				System.out.println("Producto No Existe!");
			}
		}
		System.out.println("Proceso de reporte de ganancias terminado con exito!");
	    
	}
	// ACTUALZIAR FECHA EN PRODUCT EARNING A STRING
	public static void addEarning(Products product,Sales cartSale,Integer stock) {
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", new Locale("es", "ES"));
		String formattedDate = myDateObj.format(myFormatObj);
		ProductEarnings productEarnings = new ProductEarnings();
	    productEarnings.setIdProductEarning(0);
	    productEarnings.setIdProduct(product.getIdProduct());
	    productEarnings.setProductName(product.getProduct());
	    productEarnings.setUnits(cartSale.getUnits());
	    productEarnings.setUnitEarning(product.getEarning());
	    productEarnings.setTotalEarning(getTotalEarning(cartSale.getUnits(),product.getEarning()));
	    productEarnings.setProductStock(stock);
	 // ACTUALZIAR FECHA EN PRODUCT EARNING A STRING
	    productEarnings.setSaleDate(formattedDate);
	 // ACTUALZIAR FECHA EN PRODUCT EARNING A STRING
	    ProductEarningsClient.addProductEarnings(productEarnings);
	}
	
	public static void updateEarning(ProductEarnings productEarnings,Sales cartSale,Integer stock) {
	    productEarnings.setUnits(sumNewQuantity(productEarnings.getUnits(),cartSale.getUnits()));
	    productEarnings.setTotalEarning(getTotalEarning(productEarnings.getUnits(),productEarnings.getUnitEarning()));
	    productEarnings.setProductStock(stock);
	    ProductEarningsClient.updateProductEarnings(productEarnings);
	}
	
	public static Integer sumNewQuantity(Integer quantity, Integer newQuantity) {
		return quantity+newQuantity;
	}
	
	public static Double getTotalEarning(Integer quantity, Double unitEarning) {
		return quantity*unitEarning;
	}

}
