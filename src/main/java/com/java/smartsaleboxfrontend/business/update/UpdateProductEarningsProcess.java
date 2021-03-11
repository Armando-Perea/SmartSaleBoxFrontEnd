package com.java.smartsaleboxfrontend.business.update;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.BulkProductsClient;
import com.java.smartsalebox.client.ProductEarningsClient;
import com.java.smartsalebox.client.ProductsClient;
import com.java.smartsalebox.models.BulkProducts;
import com.java.smartsalebox.models.ProductEarnings;
import com.java.smartsalebox.models.Products;
import com.java.smartsalebox.models.Sales;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;
import com.java.smartsaleboxfrontend.utils.SmartSaleBoxOperations;

public class UpdateProductEarningsProcess {

	public static void addGeneralProductEarning() {
		for (Sales sale : SmartSaleBoxMain.salesList) {
			Products product = ProductsClient.getProductById(sale.getIdProduct());
			if (product != null) {
				List<ProductEarnings> productEarningsList = Arrays
						.asList(ProductEarningsClient.getGeneralProductEarningsByProductId(sale.getIdProduct()));
				if (productEarningsList.get(0) == null) {
					addGeneralEarning(product, sale);
				} else {
					updateGeneralEarning(productEarningsList.get(0), sale, product.getStock());
				}
			} else {
				JOptionPane.showMessageDialog(null, "Producto No Existe!");
			}
		}
		SmartSaleBoxMain.salesList = new ArrayList<>();
	}

	public static void addBulkProductEarning() {
		for (Sales sale : SmartSaleBoxMain.bulkList) {
			BulkProducts bulkProduct = BulkProductsClient.getBulkProductById(sale.getIdProduct());
			if (bulkProduct != null) {
				List<ProductEarnings> productEarningsList = Arrays
						.asList(ProductEarningsClient.getBulkProductEarningsByProductId(sale.getIdProduct()));
				if (productEarningsList.get(0) == null) {
					addBulkEarning(bulkProduct, sale);
				} else {
					updateBulkEarning(productEarningsList.get(0), sale, bulkProduct);
				}

			} else {
				JOptionPane.showMessageDialog(null, "Producto No Existe!");
			}
		}
		SmartSaleBoxMain.bulkList = new ArrayList<>();
	}

	public static void addBulkEarning(BulkProducts bulkProduct, Sales sale) {
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", new Locale("es", "ES"));
		String formattedDate = myDateObj.format(myFormatObj);
		ProductEarnings productEarnings = new ProductEarnings();
		productEarnings.setIdProductEarning(0);
		productEarnings.setIdProduct(bulkProduct.getIdBulkProduct());
		productEarnings.setProductName(bulkProduct.getProduct());
		productEarnings.setUnits(sale.getUnits());
		productEarnings.setUnitEarning(bulkProduct.getKiloEarning());
		productEarnings.setTotalEarning(
				SmartSaleBoxOperations.getTotalBulkEarning(sale.getUnits(), bulkProduct.getKiloEarning()));
		productEarnings.setProductStock((int) Math.round(bulkProduct.getGrStock()));
		productEarnings.setProductType(SmartSaleBoxOperations.BULK_TYPE);
		productEarnings.setSaleDate(formattedDate);
		ProductEarningsClient.addProductEarnings(productEarnings);
	}

	public static void addGeneralEarning(Products product, Sales sale) {
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", new Locale("es", "ES"));
		String formattedDate = myDateObj.format(myFormatObj);
		ProductEarnings productEarnings = new ProductEarnings();
		productEarnings.setIdProductEarning(0);
		productEarnings.setIdProduct(product.getIdProduct());
		productEarnings.setProductName(product.getProduct());
		productEarnings.setUnits(sale.getUnits());
		productEarnings.setUnitEarning(product.getEarning());
		productEarnings.setTotalEarning(SmartSaleBoxOperations.getTotalEarning(sale.getUnits(), product.getEarning()));
		productEarnings.setProductStock(product.getStock());
		productEarnings.setProductType(SmartSaleBoxOperations.GENERAL_TYPE);
		productEarnings.setSaleDate(formattedDate);
		ProductEarningsClient.addProductEarnings(productEarnings);
	}

	public static void updateGeneralEarning(ProductEarnings productEarnings, Sales sale, Integer stock) {
		productEarnings.setUnits(SmartSaleBoxOperations.sumNewQuantity(productEarnings.getUnits(), sale.getUnits()));
		productEarnings.setTotalEarning(
				SmartSaleBoxOperations.getTotalEarning(productEarnings.getUnits(), productEarnings.getUnitEarning()));
		productEarnings.setProductStock(stock);
		ProductEarningsClient.updateProductEarnings(productEarnings);
	}

	public static void updateBulkEarning(ProductEarnings productEarnings, Sales sale, BulkProducts bulkProduct) {
		productEarnings.setUnits(SmartSaleBoxOperations.sumNewQuantity(productEarnings.getUnits(), sale.getUnits()));
		productEarnings.setTotalEarning(
				SmartSaleBoxOperations.getTotalBulkEarning(productEarnings.getUnits(), bulkProduct.getKiloEarning()));
		productEarnings.setProductStock((int) Math.round(bulkProduct.getGrStock()));
		ProductEarningsClient.updateProductEarnings(productEarnings);
	}

}
