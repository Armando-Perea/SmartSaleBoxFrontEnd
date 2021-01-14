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

		public final static String SALE_SAVED_SUCCESSFULLY=" ha sido dado de alta con éxito!";
	    public final static String SALE_SAVED_FAILED="No es posible dar de alta Venta en este momento";
	    private static final String NUMERIC_VALIDATION_ERROR = "Dato debe ser numérico, revise información";
	   	private static final String VALIDATION_NUMBER = "java.lang.NumberFormatException";
	   	
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
				//SalesClient
				
				stock = Integer.parseInt(stockCartSale);
				idProduct = Integer.parseInt(idProdSale);
				
				saleObj = SalesClient.getSaleByProductId(idProduct);
				if(!saleObj.getDescription().equals(product)) {
					System.out.println("New product added");
					saleObj.setIdSale(0);
					saleObj.setNoSale(SmartSaleBoxMain.noSale);
					saleObj.setDescription(product);
					saleObj.setUnits(1);
					saleObj.setPrice(Double.parseDouble(price));
					saleObj.setTotal(getTotalSale(saleObj.getUnits(),saleObj.getPrice()));
					saleObj.setIdProduct(idProduct);
					saleObj.setStock(stock);
					saleObj.setSaleDate(formattedDate);
	
					if (stock <= 0) {
						JOptionPane.showMessageDialog(null,
								"El producto " + product + " se ha agotado, favor de abastecer producto");
					} else if (stock < 10) {
						JOptionPane.showMessageDialog(null, "Se recomienda abastecer producto " + product);
						SalesClient.addSale(saleObj);
						SmartSaleBoxMain.salesList.add(saleObj);
						ReadSaleInfo.getAllSaleTable();
					} else {
						JOptionPane.showMessageDialog(null, "Se guardo en venta ");
						SalesClient.addSale(saleObj);
						ReadSaleInfo.getAllSaleTable();
					}
				}else {
					System.out.println("Update product stock");
					saleObj.setUnits(saleObj.getUnits()+1);
					if (stock <= 0) {
						JOptionPane.showMessageDialog(null,
								"El producto " + product + " se ha agotado, favor de abastecer producto");
					} else if (stock < 10) {
						JOptionPane.showMessageDialog(null, "Se recomienda abastecer producto " + product);
						SalesClient.updateSale(saleObj);
						ReadSaleInfo.getAllSaleTable();
					} else {
						JOptionPane.showMessageDialog(null, "Se guardo en venta ");
						SalesClient.updateSale(saleObj);
						ReadSaleInfo.getAllSaleTable();
					}
				}
			}
		}
		
		private static double getTotalSale(Integer units,Double price) {
			return price*units;
		}
		
		public static Integer createNewSale() {
			Sales newSale = new Sales();
			LocalDateTime myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", new Locale("es", "ES"));
			String formattedDate = myDateObj.format(myFormatObj);
				try {	
					newSale.setIdSale(0);
					newSale.setNoSale(SmartSaleBoxMain.noSale);
					newSale.setDescription("");
					newSale.setPrice(00.00);
					newSale.setTotal(00.00);
					newSale.setUnits(8);
					newSale.setSaleDate(formattedDate);
					newSale = SalesClient.addSale(newSale);
					if(newSale.getIdSale()!=null) {
						JOptionPane.showMessageDialog(null, SALE_SAVED_SUCCESSFULLY);
					}else {
						JOptionPane.showMessageDialog(null,SALE_SAVED_FAILED);
					}
				}catch(Exception ex) {
					System.out.println("ISSUE: "+ex);
					if(ex.toString().contains(VALIDATION_NUMBER)) {
					JOptionPane.showMessageDialog(null, NUMERIC_VALIDATION_ERROR,"Validation", JOptionPane.WARNING_MESSAGE);	
					}else {
					JOptionPane.showMessageDialog(null, "Se produjo una excepción al guardar","Validation", JOptionPane.WARNING_MESSAGE);	
					}
				}

			return newSale.getIdSale();
		}
		
}
