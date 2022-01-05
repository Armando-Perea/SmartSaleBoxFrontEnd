package com.java.smartsaleboxfrontend.business.read;

import java.awt.print.PrinterException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.swing.JOptionPane;

import com.java.smartsalebox.client.SalesClient;
import com.java.smartsalebox.models.SaleTicketModel;
import com.java.smartsalebox.models.Sales;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;

public class SaleTicket {
	
	/**
	 * printSaleProcesss executes the print process for the sale table.
	 * @throws PrinterException 
	 * @throws InterruptedException 
	 */
	public static void printSaleProcess() throws PrinterException, InterruptedException {
		SaleTicketModel ticketModel = new SaleTicketModel();
		ticketModel.setChange(SmartSaleBoxMain.txtChangeBack.getText());
		ticketModel.setEmployee(SmartSaleBoxMain.adminName);
		ticketModel.setNoSale(SmartSaleBoxMain.noSale.toString());
		ticketModel.setCardPayment(SmartSaleBoxMain.txtCardPayment.getText());
		ticketModel.setReceived(SmartSaleBoxMain.txtReceived.getText());
		ticketModel.setTotal(SmartSaleBoxMain.txtTotalSale.getText());
		ticketModel.setSales(SalesClient.getSaleByNoSale(SmartSaleBoxMain.noSale));
        salePrintClientTicket(ticketModel);
        Thread.sleep(5000);
        salePrintClientTicket(ticketModel);
	}
	
	public static void salePrintClientTicket(SaleTicketModel saleTicket) throws PrinterException{
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", new Locale("es", "ES"));
		String formattedDate = myDateObj.format(myFormatObj);
		 Sales[] sales = saleTicket.getSales();
	     String total = saleTicket.getTotal();
	     String received = saleTicket.getReceived();
	     String change = saleTicket.getChange();
	     String cardPayment =saleTicket.getCardPayment();
	     ArrayList <String> listaU = new ArrayList<String>();
	     for (Sales tempSale : sales) {
	    	 String description;
	    	 description = tempSale.getDescription();
	    	 if(description.length()<=8) {
	    		 description = description+".......";
	    	 }
	    	 listaU.add(description.substring(0,8)+"     "+tempSale.getUnits().toString()+"      "+tempSale.getTotal().toString()+"\n");	 
		     
		 }
	    Iterator itU= listaU.iterator();
	    StringBuilder cadenaU= new StringBuilder();
	    while(itU.hasNext()){
	     cadenaU.append(itU.next());
	      }
	    
	     String contentTicket = "\n   *** "+SmartSaleBoxMain.ticketTitle+" ***\n"+
	    "\tVenta de Producto\n"+
	    "No.Venta: #"+saleTicket.getNoSale()+"\n"+
	    "--------------------------------\n"+
	    "Producto  Cantidad  Subtotal\n"+
	    cadenaU.toString()+           
	    "--------------------------------"+
	    "\n              TOTAL:"+total+
	    "\n           EFECTIVO:"+received+
	    "\n           TARJETA:"+cardPayment+ 
	    "\n             CAMBIO:"+change+        
	    "\n--------------------------------"+
	    "\n"+formattedDate+ 
	    "\n Gracias por su compra! \n\n\n"; 
	     //Especificamos el tipo de dato a imprimir
	    //Tipo: bytes; Subtipo: autodetectado
	    DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
	    //Aca obtenemos el servicio de impresion por defatul
	    //Si no quieres ver el dialogo de seleccionar impresora usa esto
	    //PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
	    //Si quieres ver el dialogo de seleccionar impresora usalo
	    //Solo mostrara las impresoras que soporte arreglo de bits
	    //PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
	    //PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor,null);
	    PrintService service = PrintServiceLookup.lookupDefaultPrintService();
	    //Creamos un arreglo de tipo byte
	    byte[] bytes;
	    //Aca convertimos el string(cuerpo del ticket) a bytes tal como
	    //lo maneja la impresora(mas bien ticketera :p)
	    bytes = contentTicket.getBytes();
	    //Creamos un documento a imprimir, a el se le appendeara
	    //el arreglo de bytes
	    Doc doc = new SimpleDoc(bytes,flavor,null);
	    //Creamos un trabajo de impresión
	    DocPrintJob job = service.createPrintJob();
	    //Imprimimos dentro de un try de a huevo
	   try {
	      //El metodo print imprime
	      job.print(doc, null);
	    }
	    catch (Exception ex) { 
	             JOptionPane.showMessageDialog(null,"Revise conexion con Impresora");
	    } 
	     
	  }
	
	/**
	 * printSaleProcesss executes the print process for the sale table.
	 * @throws PrinterException 
	 * @throws InterruptedException 
	 */
	public static void printSaleProcessChecked() throws PrinterException, InterruptedException {
		SaleTicketModel ticketModel = new SaleTicketModel();
		Integer noSale = Integer.parseInt(SmartSaleBoxMain.txtHistoryNoSale.getText());
		ticketModel.setChange("0.0");
		ticketModel.setEmployee(SmartSaleBoxMain.adminName);
		ticketModel.setNoSale(noSale.toString());
		ticketModel.setCardPayment("0.0");
		ticketModel.setReceived(SmartSaleBoxMain.txtTotalSaleHistory.getText());
		ticketModel.setTotal(SmartSaleBoxMain.txtTotalSaleHistory.getText());
		ticketModel.setSales(SalesClient.getSaleByNoSale(noSale));
		salePrintClientTicketChecked(ticketModel);
        Thread.sleep(5000);
        salePrintClientTicketChecked(ticketModel);
	}
	
	public static void salePrintClientTicketChecked(SaleTicketModel saleTicket) throws PrinterException{
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", new Locale("es", "ES"));
		String formattedDate = myDateObj.format(myFormatObj);
		 Sales[] sales = saleTicket.getSales();
	     String total = saleTicket.getTotal();
	     ArrayList <String> listaU = new ArrayList<String>();
	     for (Sales tempSale : sales) {
	    	 String description;
	    	 description = tempSale.getDescription();
	    	 if(description.length()<=8) {
	    		 description = description+".......";
	    	 }
	    	 listaU.add(description.substring(0,8)+"     "+tempSale.getUnits().toString()+"      "+tempSale.getTotal().toString()+"\n");	 
		     
		 }
	    Iterator itU= listaU.iterator();
	    StringBuilder cadenaU= new StringBuilder();
	    while(itU.hasNext()){
	     cadenaU.append(itU.next());
	      }
	    
	     String contentTicket = "\n   *** "+SmartSaleBoxMain.ticketTitle+" ***\n"+
	    "\tVenta de Producto\n"+
	    "No.Venta: #"+saleTicket.getNoSale()+"\n"+
	    "--------------------------------\n"+
	    "Producto  Cantidad  Subtotal\n"+
	    cadenaU.toString()+           
	    "--------------------------------"+
	    "\n              TOTAL:"+total+        
	    "\n--------------------------------"+
	    "\n"+formattedDate+ 
	    "\n\n\n"; 
	     //Especificamos el tipo de dato a imprimir
	    //Tipo: bytes; Subtipo: autodetectado
	    DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
	    //Aca obtenemos el servicio de impresion por defatul
	    //Si no quieres ver el dialogo de seleccionar impresora usa esto
	    //PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
	    //Si quieres ver el dialogo de seleccionar impresora usalo
	    //Solo mostrara las impresoras que soporte arreglo de bits
	    //PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
	    //PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor,null);
	    PrintService service = PrintServiceLookup.lookupDefaultPrintService();
	    //Creamos un arreglo de tipo byte
	    byte[] bytes;
	    //Aca convertimos el string(cuerpo del ticket) a bytes tal como
	    //lo maneja la impresora(mas bien ticketera :p)
	    bytes = contentTicket.getBytes();
	    //Creamos un documento a imprimir, a el se le appendeara
	    //el arreglo de bytes
	    Doc doc = new SimpleDoc(bytes,flavor,null);
	    //Creamos un trabajo de impresión
	    DocPrintJob job = service.createPrintJob();
	    //Imprimimos dentro de un try de a huevo
	   try {
	      //El metodo print imprime
	      job.print(doc, null);
	    }
	    catch (Exception ex) { 
	             JOptionPane.showMessageDialog(null,"Revise conexion con Impresora");
	    } 
	     
	  }

}
