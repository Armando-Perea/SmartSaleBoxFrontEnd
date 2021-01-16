package com.java.smartsaleboxfrontend.business.save;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.SalesClient;
import com.java.smartsalebox.models.Sales;
import com.java.smartsaleboxfrontend.business.read.ReadSaleInfo;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;

public class SaveSaleProcess {

	public final static String SALE_SAVED_SUCCESSFULLY = " ha sido dado de alta con éxito!";
	public final static String SALE_SAVED_FAILED = "No es posible dar de alta Venta en este momento";

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
			saleObj = SalesClient.getSaleByProductId(idProduct);
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
				saleObj.setType("GENERAL");
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
			// Consider this for each producto type while applying the sale execution, this is temporary.
			SmartSaleBoxMain.salesList.add(saleObj);
			SmartSaleBoxMain.bulkList.add(saleObj);
			//
			ReadSaleInfo.getAllSaleTable();
		} else {
			SalesClient.addSale(saleObj);
			ReadSaleInfo.getAllSaleTable();
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
			ReadSaleInfo.getAllSaleTable();
		} else {
			saleObj.setUnits(saleObj.getUnits() + 1);
			saleObj.setTotal(getTotalSale(saleObj.getUnits(), saleObj.getPrice()));
			SalesClient.updateSale(saleObj);
			ReadSaleInfo.getAllSaleTable();
		}

	}

	private static double getTotalSale(Integer units, Double price) {
		return price * units;
	}

}
