package com.java.smartsaleboxfrontend.business.read;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.SalesClient;
import com.java.smartsalebox.models.Sales;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;
import com.java.smartsaleboxfrontend.utils.SmartSaleBoxClearFields;
import com.java.smartsaleboxfrontend.utils.SmartSaleBoxOperations;

public class ReadSaleInfo {
	
	private static final String SALE_NOT_FOUND = "No hay ventas";
	private static final String VALIDATION_UPDATE_TITLE = "Validacion";
	
	public static Sales[] getSalesByNoSale() {
		Sales[] sales = null;
		try {
			sales = SalesClient.getSaleByNoSale(SmartSaleBoxMain.noSale);
			if(sales.length>0) {
				List<Sales> salesList = Arrays.stream(sales).collect(Collectors.toList());
				SmartSaleBoxMain.tableModelSale.setRowCount(0);
				SmartSaleBoxMain.salesList = salesList.stream().filter(sal -> sal.getType().equals("GENERAL")).collect(Collectors.toList());
				SmartSaleBoxMain.bulkList = salesList.stream().filter(sal -> sal.getType().equals("BULK")).collect(Collectors.toList());
				for (Sales sal : sales) {
					Object[] saletItems = {sal.getNoSale(),sal.getDescription(),sal.getPrice(),sal.getUnits(),sal.getTotal(),sal.getIdProduct(),sal.getType(),sal.getIdSale()};
					SmartSaleBoxMain.tableModelSale.addRow(saletItems);
				}
				SmartSaleBoxMain.scrollCartSale.setViewportView(SmartSaleBoxMain.tblCartSale);
				SmartSaleBoxMain.txtTotalSale.setText(SmartSaleBoxOperations.getTotalSale(sales));
			}else {
				SmartSaleBoxClearFields.clearSaleMain();
			}
			return sales;
		}catch(Exception ex) {
			System.out.println("getAllSaleTable error catch: "+ex);
			SmartSaleBoxClearFields.clearSaleMain();
			return sales;
		}
	}
	
	public static Sales[] getSaleHistoryByNoSale() {
		Sales[] sales = null;
		Integer noSaleHistory= Integer.parseInt(SmartSaleBoxMain.txtHistoryNoSale.getText());
		try {
			sales = SalesClient.getSaleByNoSale(noSaleHistory);
			if(sales.length>0) {
				SmartSaleBoxMain.tableModelSaleHistory.setRowCount(0);
				for (Sales sal : sales) {
					Object[] saletItems = {sal.getNoSale(),sal.getDescription(),sal.getPrice(),sal.getUnits(),sal.getTotal(),sal.getIdProduct(),sal.getType(),sal.getIdSale()};
					SmartSaleBoxMain.tableModelSaleHistory.addRow(saletItems);
				}
				SmartSaleBoxMain.scrollSaleHistory.setViewportView(SmartSaleBoxMain.tblSaleHistory);
				SmartSaleBoxMain.txtTotalSaleHistory.setText(SmartSaleBoxOperations.getTotalSale(sales));
			}else {
				JOptionPane.showMessageDialog(null,SALE_NOT_FOUND,VALIDATION_UPDATE_TITLE, JOptionPane.INFORMATION_MESSAGE);
				SmartSaleBoxClearFields.clearSaleHistory();
			}
			return sales;
		}catch(Exception ex) {
			System.out.println("getSaleHistoryByNoSale error catch: "+ex);
			SmartSaleBoxClearFields.clearSaleMain();
			return sales;
		}
	}
	
	public static void getAllSaleTable() {
		Sales[] sales;
		try {
			sales = SalesClient.getAllSales();
			if(sales.length>0) {
				List<Sales> salesList = Arrays.stream(sales).collect(Collectors.toList());
				SmartSaleBoxMain.tableModelSale.setRowCount(0);
				SmartSaleBoxMain.salesList = salesList.stream().filter(sal -> sal.getType().equals("GENERAL")).collect(Collectors.toList());
				SmartSaleBoxMain.bulkList = salesList.stream().filter(sal -> sal.getType().equals("BULK")).collect(Collectors.toList());
				for (Sales sal : sales) {
					Object[] saletItems = {sal.getNoSale(),sal.getDescription(),sal.getPrice(),sal.getUnits(),sal.getTotal(),sal.getIdProduct(),sal.getType(),sal.getIdSale()};
					SmartSaleBoxMain.tableModelSale.addRow(saletItems);
				}
				SmartSaleBoxMain.scrollCartSale.setViewportView(SmartSaleBoxMain.tblCartSale);
				SmartSaleBoxMain.txtTotalSale.setText(SmartSaleBoxOperations.getTotalSale(sales));
			}else {
				JOptionPane.showMessageDialog(null,SALE_NOT_FOUND,VALIDATION_UPDATE_TITLE, JOptionPane.INFORMATION_MESSAGE);
				SmartSaleBoxClearFields.clearSaleMain();
			}
		}catch(Exception ex) {
			System.out.println("getAllSaleTable error catch: "+ex);
			SmartSaleBoxClearFields.clearSaleMain();
		}
	}
	
	public static void getAllSaleHistoryTable() {
		Sales[] sales;
		try {
			sales = SalesClient.getAllSales();
			if(sales.length>0) {
				SmartSaleBoxMain.tableModelSaleHistory.setRowCount(0);
				SmartSaleBoxMain.txtTotalSaleHistory.setText(null);
				for (Sales sal : sales) {
					Object[] saletItems = {sal.getNoSale(),sal.getDescription(),sal.getPrice(),sal.getUnits(),sal.getTotal(),sal.getIdProduct(),sal.getType(),sal.getIdSale()};
					SmartSaleBoxMain.tableModelSaleHistory.addRow(saletItems);
				}
				SmartSaleBoxMain.scrollSaleHistory.setViewportView(SmartSaleBoxMain.tblSaleHistory);
				SmartSaleBoxMain.txtTotalSaleHistory.setText(SmartSaleBoxOperations.getTotalSale(sales));
			}else {
				JOptionPane.showMessageDialog(null,SALE_NOT_FOUND,VALIDATION_UPDATE_TITLE, JOptionPane.INFORMATION_MESSAGE);
			}
		}catch(Exception ex) {
			System.out.println("getAllSaleHistoryTable error catch: "+ex);
			SmartSaleBoxClearFields.clearSaleHistory();
		}
	}

}
