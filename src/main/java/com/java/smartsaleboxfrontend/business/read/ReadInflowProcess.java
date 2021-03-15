package com.java.smartsaleboxfrontend.business.read;

import com.java.smartsalebox.client.InflowClient;
import com.java.smartsalebox.models.Inflow;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;
import com.java.smartsaleboxfrontend.utils.SmartSaleBoxOperations;

public class ReadInflowProcess {
	
	
	public static void initInflowBalanceProcess() {
		Inflow[] inflows;
		inflows = InflowClient.getAllInflow();
		SmartSaleBoxMain.tableModelInflows.setRowCount(0);
		SmartSaleBoxMain.txtTotalInflows.setText(null);
		for (Inflow ins : inflows) {
			Object[] incomeItems = { ins.getIdInflow(),ins.getConcept(),ins.getDescription(), ins.getQuantity(), 
					ins.getPaymentType(),ins.getAttendee(), ins.getInflowDate()};
			SmartSaleBoxMain.tableModelInflows.addRow(incomeItems);
		}
		SmartSaleBoxMain.txtTotalInflows.setText(SmartSaleBoxOperations.getTotalInflows(inflows));
		SmartSaleBoxMain.scrollInflows.setViewportView(SmartSaleBoxMain.tblInflows);
	}
	


}
