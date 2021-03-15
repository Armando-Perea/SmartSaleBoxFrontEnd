package com.java.smartsaleboxfrontend.business.read;

import com.java.smartsalebox.client.OutflowClient;
import com.java.smartsalebox.models.Outflow;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;
import com.java.smartsaleboxfrontend.utils.SmartSaleBoxOperations;

public class ReadOutflowProcess {
	
	public static void initOutflowBalanceProcess() {
		Outflow[] outflows;
		outflows = OutflowClient.getAllOutflow();
		SmartSaleBoxMain.tableModelOutflows.setRowCount(0);
		SmartSaleBoxMain.txtTotalOutflows.setText(null);
		for (Outflow outs : outflows) {
			Object[] outflowItems = { outs.getIdOutflow(),outs.getConcept(),outs.getDescription(), outs.getQuantity(), 
					outs.getPaymentType(),outs.getAttendee(), outs.getOutflowDate()};
			SmartSaleBoxMain.tableModelOutflows.addRow(outflowItems);
		}
		SmartSaleBoxMain.txtTotalOutflows.setText(SmartSaleBoxOperations.getTotalOutflows(outflows));
		SmartSaleBoxMain.scrollOutflows.setViewportView(SmartSaleBoxMain.tblOutflows);
	}

}
