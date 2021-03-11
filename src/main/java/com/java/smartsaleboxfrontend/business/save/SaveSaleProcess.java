package com.java.smartsaleboxfrontend.business.save;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.InflowClient;
import com.java.smartsalebox.client.SalesClient;
import com.java.smartsalebox.models.Inflow;
import com.java.smartsalebox.models.Sales;
import com.java.smartsaleboxfrontend.business.read.ReadSaleInfo;
import com.java.smartsaleboxfrontend.gui.BulkSaleMain;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;
import com.java.smartsaleboxfrontend.utils.SmartSaleBoxOperations;

public class SaveSaleProcess {

	public final static String SALE_SAVED_SUCCESSFULLY = " ha sido dado de alta con éxito!";
	public final static String SALE_SAVED_FAILED = "No es posible dar de alta Venta en este momento";
	public final static String GENERAL_TYPE = "GENERAL";
	public final static String BULK_TYPE = "BULK";

	public static void addProductToSaleList(java.awt.event.MouseEvent evt) {
		Sales saleObj = new Sales();
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", new Locale("es", "ES"));
		String formattedDate = myDateObj.format(myFormatObj);
		int fila = SmartSaleBoxMain.tblCartSale.rowAtPoint(evt.getPoint());
		int columna = SmartSaleBoxMain.tblCartSale.columnAtPoint(evt.getPoint());
		int datos = SmartSaleBoxMain.tblCartSale.getSelectedRow();
		String product, price, idProdSale, stockCartSale;
		Integer stock, idProduct;

		if ((fila > -1) && (columna > -1)) {
			idProdSale = (SmartSaleBoxMain.tableModelCartSale.getValueAt(datos, 0)).toString();
			product = (SmartSaleBoxMain.tableModelCartSale.getValueAt(datos, 1)).toString();
			price = (SmartSaleBoxMain.tableModelCartSale.getValueAt(datos, 2)).toString();
			stockCartSale = (SmartSaleBoxMain.tableModelCartSale.getValueAt(datos, 3)).toString();
			stock = Integer.parseInt(stockCartSale);
			idProduct = Integer.parseInt(idProdSale);
			saleObj = SalesClient.getSaleByProductIdAndNoSale(idProduct, SmartSaleBoxMain.noSale);
			System.out.println("Sale obj is null: "+saleObj);
			if (saleObj == null) {
				saleObj = new Sales();
				saleObj.setIdSale(0);
				saleObj.setNoSale(SmartSaleBoxMain.noSale);
				saleObj.setDescription(product);
				saleObj.setUnits(1);
				saleObj.setPrice(Double.parseDouble(price));
				saleObj.setTotal(getTotalSale(saleObj.getUnits(), saleObj.getPrice()));
				saleObj.setIdProduct(idProduct);
				saleObj.setStock(stock);
				saleObj.setType(GENERAL_TYPE);
				saleObj.setSaleDate(formattedDate);
				saveNewProductSale(saleObj, stock);
			} else {
				updateProductSale(saleObj, stock);
			}
		}
	}

	private static void saveNewProductSale(Sales saleObj, Integer stock) {
		if (stock <= 0) {
			JOptionPane.showMessageDialog(null,
					"El producto " + saleObj.getDescription() + " se ha agotado, favor de abastecer producto");
		} else if (stock < 10) {
			JOptionPane.showMessageDialog(null, "Se recomienda abastecer producto " + saleObj.getDescription());
			SalesClient.addSale(saleObj);
			SmartSaleBoxMain.salesList.add(saleObj);
			ReadSaleInfo.getSalesByNoSale();
		} else {
			SalesClient.addSale(saleObj);
			SmartSaleBoxMain.salesList.add(saleObj);
			ReadSaleInfo.getSalesByNoSale();
		}
	}

	private static void updateProductSale(Sales saleObj, Integer stock) {
		if (stock <= 0) {
			JOptionPane.showMessageDialog(null,
					"El producto " + saleObj.getDescription() + " se ha agotado, favor de abastecer producto");
		} else if (stock < 10) {
			JOptionPane.showMessageDialog(null, "Se recomienda abastecer producto " + saleObj.getDescription());
			saleObj.setUnits(saleObj.getUnits() + 1);
			saleObj.setTotal(getTotalSale(saleObj.getUnits(), saleObj.getPrice()));
			SalesClient.updateSale(saleObj);
			ReadSaleInfo.getSalesByNoSale();
		} else {
			saleObj.setUnits(saleObj.getUnits() + 1);
			saleObj.setTotal(getTotalSale(saleObj.getUnits(), saleObj.getPrice()));
			SalesClient.updateSale(saleObj);
			ReadSaleInfo.getSalesByNoSale();
		}

	}

	private static double getTotalSale(Integer units, Double price) {
		return price * units;
	}
	
	
	public static void addBulkProductToSaleList() {
		Sales saleObj = new Sales();
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", new Locale("es", "ES"));
		String formattedDate = myDateObj.format(myFormatObj);
		String product, price, idBulkProdSale, gramsCartSale, stockBulkProduct;
		Integer stock, idProduct;
		Double stockBulkAvailable;
		
		product = BulkSaleMain.txtBulkProductSelected.getText();
		price = BulkSaleMain.txtSaleQuantity.getText();
		gramsCartSale = BulkSaleMain.txtKiloGrams.getText();
		idBulkProdSale = BulkSaleMain.txtBulkSaleId.getText();
		stockBulkProduct = BulkSaleMain.txtBulkSaleStock.getText();
		idProduct = Integer.parseInt(idBulkProdSale);
		stockBulkAvailable = Double.parseDouble(stockBulkProduct);
		stock = (int) Math.round(Double.parseDouble(gramsCartSale));
		
		saleObj.setIdSale(0);
		saleObj.setNoSale(SmartSaleBoxMain.noSale);
		saleObj.setDescription(product+" "+gramsCartSale+"grs.");
		saleObj.setUnits((int) Math.round(stock));
		saleObj.setPrice(Double.parseDouble(price));
		saleObj.setTotal(saleObj.getPrice());
		saleObj.setIdProduct(idProduct);
		saleObj.setStock((int) Math.round(stockBulkAvailable));
		saleObj.setType(BULK_TYPE);
		saleObj.setSaleDate(formattedDate);
		saveNewBulkProductSale(saleObj);
	}
	
	private static void saveNewBulkProductSale(Sales saleObj) {
		if (saleObj.getStock() <= 0) {
			JOptionPane.showMessageDialog(null,
					"El producto " + saleObj.getDescription() + " se ha agotado, favor de abastecer producto");
		} else if (saleObj.getStock() < 1000) {
			JOptionPane.showMessageDialog(null, "Se recomienda abastecer producto " + saleObj.getDescription());
			SalesClient.addSale(saleObj);
			ReadSaleInfo.getSalesByNoSale();
		} else {
			SalesClient.addSale(saleObj);
			ReadSaleInfo.getSalesByNoSale();
		}
	}
	
	public static boolean createNewSaleAndInflow(String paymentType) {
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", new Locale("es", "ES"));
		String formattedDate = myDateObj.format(myFormatObj);
		Double totalSale = Double.parseDouble(SmartSaleBoxMain.txtTotalSale.getText());
		Double cardPayment = Double.parseDouble(SmartSaleBoxMain.txtCardPayment.getText());
		Double cashPayment = Double.parseDouble(SmartSaleBoxMain.txtReceived.getText());
		Inflow inflow = new Inflow();
		inflow.setIdInflow(0);
		inflow.setAttendee("TEST");
		inflow.setConcept("VENTA PRODUCTOS");
		inflow.setDescription("NO. VENTA #"+SmartSaleBoxMain.noSale);
		inflow.setInflowDate(formattedDate);
		if(paymentType.equals(SmartSaleBoxOperations.CARD_PAYMENT)) {
			inflow.setPaymentType(paymentType);
			inflow.setQuantity(cardPayment);
			InflowClient.addInflow(inflow);
			return true;
		}else if(paymentType.equals(SmartSaleBoxOperations.CASH_PAYMENT)) {
			inflow.setPaymentType(paymentType);
			inflow.setQuantity(totalSale);
			InflowClient.addInflow(inflow);
			SmartSaleBoxMain.cash=SmartSaleBoxMain.cash+totalSale;
			return true;
		}
		else if(paymentType.equals(SmartSaleBoxOperations.BOTH_PAYMENT)) {
			inflow.setPaymentType(SmartSaleBoxOperations.CARD_PAYMENT);
			inflow.setQuantity(cardPayment);
			InflowClient.addInflow(inflow);
			
			inflow.setPaymentType(SmartSaleBoxOperations.CASH_PAYMENT);
			inflow.setQuantity(cashPayment);
			InflowClient.addInflow(inflow);
			SmartSaleBoxMain.cash=SmartSaleBoxMain.cash+cashPayment;
			return true;
		}
		return false;
	}
	

}
