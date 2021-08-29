package com.java.smartsaleboxfrontend.business.read;

import com.java.smartsalebox.client.InflowClient;
import com.java.smartsalebox.client.OutflowClient;
import com.java.smartsalebox.models.Inflow;
import com.java.smartsalebox.models.Outflow;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;
import com.java.smartsaleboxfrontend.utils.SmartSaleBoxOperations;

public class ReadClosureCalculation {
	
	private static final String INITIAL_CASH="INICIO CAJA";
	private static final String PRODUCT_SALE="VENTA PRODUCTO";
	private static final String CASH="EFECTIVO";
	private static final String CARD="TARJETA";
	
	public static void setClosureCalculationInfo() {
		getInitialCash();
		getTotalInflow();
		getTotalInflowCash();
		getTotalInflowCard();
		
		getTotalCashCheck();
		getTotalOutflow();
		getTotalOutflowCash();
		getTotalOutflowCard();
		getTotalProductSale();
		
		getTotalEarningsClosure();
	}
	
	private static void getInitialCash() {
		Inflow[] inflows;
		inflows = InflowClient.getInflowByConcept(INITIAL_CASH);
		SmartSaleBoxMain.txtInitialCashClosure.setText(null);
		SmartSaleBoxMain.txtInitialCashClosure.setText(SmartSaleBoxOperations.getTotalInflows(inflows));
	}
	
	private static void getTotalInflowCash() {
		Inflow[] inflows;
		inflows = InflowClient.getInflowByPaymentType(CASH);
		SmartSaleBoxMain.txtTotalCashClosure.setText(null);
		SmartSaleBoxMain.txtTotalCashClosure.setText(SmartSaleBoxOperations.getTotalInflows(inflows));
	}
	
	private static void getTotalInflowCard() {
		Inflow[] inflows;
		inflows = InflowClient.getInflowByPaymentType(CARD);
		SmartSaleBoxMain.txtTotalCardClosure.setText(null);
		SmartSaleBoxMain.txtTotalCardClosure.setText(SmartSaleBoxOperations.getTotalInflows(inflows));
	}
	
	private static void getTotalInflow() {
		Double totalInflows;
		totalInflows = InflowClient.getTotalInflow();
		SmartSaleBoxMain.txtTotalInflowsClosure.setText(null);
		SmartSaleBoxMain.txtTotalInflowsClosure.setText(String.valueOf(totalInflows));
	}
	
	
	private static void getTotalCashCheck() {
		SmartSaleBoxMain.txtTotalCashBoxClosure.setText(null);
		SmartSaleBoxMain.txtTotalCashBoxClosure.setText(String.valueOf(SmartSaleBoxMain.cash));
	}
	
	private static void getTotalOutflow() {
		Double totalOutflows;
		totalOutflows = OutflowClient.getTotalOutflow();
		SmartSaleBoxMain.txtTotalOutflowsClosure.setText(null);
		SmartSaleBoxMain.txtTotalOutflowsClosure.setText(String.valueOf(totalOutflows));
	}
	
	private static void getTotalOutflowCash() {
		Outflow[] outflows;
		outflows = OutflowClient.getOutflowByPaymentType(CASH);
		SmartSaleBoxMain.txtTotalCashOutClosure.setText(null);
		SmartSaleBoxMain.txtTotalCashOutClosure.setText(SmartSaleBoxOperations.getTotalOutflows(outflows));
	}
	
	private static void getTotalOutflowCard() {
		Outflow[] outflows;
		outflows = OutflowClient.getOutflowByPaymentType(CARD);
		SmartSaleBoxMain.txtTotalCardOutClosure.setText(null);
		SmartSaleBoxMain.txtTotalCardOutClosure.setText(SmartSaleBoxOperations.getTotalOutflows(outflows));
	}
	
	private static void getTotalProductSale() {
		Inflow[] inflows;
		inflows = InflowClient.getInflowByConcept(PRODUCT_SALE);
		SmartSaleBoxMain.txtTotalProductClosure.setText(null);
		SmartSaleBoxMain.txtTotalProductClosure.setText(SmartSaleBoxOperations.getTotalInflows(inflows));
	}
	
	private static void getTotalEarningsClosure() {
		Double totalInflows;
		Double totalOutflows;
		Double totalEarnings = 0.0;
		totalInflows = InflowClient.getTotalInflow();
		totalOutflows = OutflowClient.getTotalOutflow();
		totalEarnings = totalInflows-totalOutflows;
		SmartSaleBoxMain.txtTotalEarningsClosure.setText(null);
		SmartSaleBoxMain.txtTotalEarningsClosure.setText(SmartSaleBoxOperations.getTwoDecimalFormat(totalEarnings));
	}
	
	
	
	

}
