package com.java.smartsaleboxfrontend.business.update;

import com.java.smartsalebox.client.ProductsClient;
import com.java.smartsalebox.models.Products;
import com.java.smartsalebox.models.Sales;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;

public class UpdateProductStockProcess {

	public static void updateGeneralProductStock() {
		for (Sales sale : SmartSaleBoxMain.salesList) {
			Products product = ProductsClient.getProductById(sale.getIdProduct());
			product.setStock(product.getStock() - sale.getUnits());
			ProductsClient.updateProduct(product);
		}
	}

	

}
