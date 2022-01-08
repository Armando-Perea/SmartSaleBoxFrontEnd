package com.java.smartsaleboxfrontend.business.save;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.ProductsClient;
import com.java.smartsalebox.models.Products;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;

public class SaveProductProcess {
	
    public final static String PRODUCT_SAVED_SUCCESSFULLY=" ha sido dado de alta con éxito!";
    public final static String PRODUCT_ALREADY_EXISTS="Este código de producto ya existe y corresponde a: ";
    public final static String PRODUCT_SAVED_FAILED="No es posible dar de alta Producto en este momento";
    private static final String NUMERIC_VALIDATION_ERROR = "Dato debe ser numérico, revise información";
   	private static final String VALIDATION_NUMBER = "java.lang.NumberFormatException";
	
	public static Integer createNewProduct() {
		Products newProduct = new Products();
		Products productBarCode = new Products();
		productBarCode = ProductsClient.getProductByBarCode(SmartSaleBoxMain.txtNewBarCode.getText());
		if(productBarCode == null) {
			try {	
				newProduct.setIdProduct(0);
				newProduct.setProduct(SmartSaleBoxMain.txtNewProductName.getText());
				newProduct.setSalePrice(Double.parseDouble(SmartSaleBoxMain.txtNewSalePrice.getText()));
				newProduct.setCostPrice(Double.parseDouble(SmartSaleBoxMain.txtNewCostPrice.getText()));
				newProduct.setEarning(Double.parseDouble(SmartSaleBoxMain.txtNewEarning.getText()));
				newProduct.setStock(Integer.parseInt(SmartSaleBoxMain.txtNewStock.getText()));
				newProduct.setBarCode(SmartSaleBoxMain.txtNewBarCode.getText());
				newProduct.setType("GENERAL");
				newProduct = ProductsClient.addProduct(newProduct);
				if(newProduct.getIdProduct()!=null) {
					JOptionPane.showMessageDialog(null, newProduct.getProduct()+PRODUCT_SAVED_SUCCESSFULLY);
				}else {
					JOptionPane.showMessageDialog(null,PRODUCT_SAVED_FAILED);
				}
			}catch(Exception ex) {
				System.out.println("ISSUE: "+ex.getMessage());
				if(ex.toString().contains(VALIDATION_NUMBER)) {
				JOptionPane.showMessageDialog(null, NUMERIC_VALIDATION_ERROR,"Validation", JOptionPane.WARNING_MESSAGE);	
				}else {
				JOptionPane.showMessageDialog(null, "Se produjo una excepción al guardar","Validation", JOptionPane.WARNING_MESSAGE);	
				}
			}
		}else {
			JOptionPane.showMessageDialog(null, PRODUCT_ALREADY_EXISTS+productBarCode.getProduct()+"\n Intente otro código porfavor" ,"Validation", JOptionPane.WARNING_MESSAGE);	
		}

		return newProduct.getIdProduct();
	}

}
