package com.java.smartsaleboxfrontend.business.save;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import com.java.smartsalebox.client.AdministratorClient;
import com.java.smartsalebox.models.Administrator;

public class LoginInitializer {
	
	public void authenticationProcess() {
		Administrator admin = new Administrator();
		String userName;
		String password=null;
		int passResult;
		JPasswordField pf = new JPasswordField();
		userName=JOptionPane.showInputDialog("Usuario: ");
		passResult=JOptionPane.showConfirmDialog(null, pf, "Contraseña", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (passResult == JOptionPane.OK_OPTION) {
			  password = new String(pf.getPassword());
			}	
		admin = AdministratorClient.getAdminAuthentication(userName,password);
		if(admin != null) {
			systemAccess = true;
			employee = admin.getEmployeeName()+" "+admin.getEmployeeLastName();
			JOptionPane.showMessageDialog(null,"Bienvenid@ " +employee,"NewYork Coffee", JOptionPane.INFORMATION_MESSAGE);
			cashInitializerProcess();
		}else {
			JOptionPane.showMessageDialog(null, "Contraseña Incorrecta","ERROR", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}
	
	public void cashInitializerProcess() {
		Cash cash = new Cash();
		double initCash;
		double inCash;
		boolean initCashOk=false;
		cash= CashClient.getCashById(PaymentTypeCatalog.ID_CASH);
		initCash = cash.getQuantity();
		if(initCash==0.0) {
			inCash=Integer.parseInt(JOptionPane.showInputDialog("Inicialize caja por favor: "));
			if(inCash<100) {
			 JOptionPane.showMessageDialog(null,"Debe iniciar caja con minimo de $100 MXN por favor ","NewYork Coffee", JOptionPane.INFORMATION_MESSAGE);
			 System.exit(0);
			}else {
				initCashOk = initCashIncomeProcess(inCash);
				if (initCashOk) {
					cash.setQuantity(inCash);
					cash = null;
					cash = TempSaleCalculating.updateCashProcess(inCash);
				}
				if (cash != null) {
					cashQuantity = cash.getQuantity();
					noVenta = cash.getNoSale();
					init();
				}
			}
		}else {
			cashQuantity = cash.getQuantity();
			noVenta = TempSaleCalculating.getNoSale();
			JOptionPane.showMessageDialog(null,"Verifique cajón : $" +cashQuantity,"NewYork Coffee", JOptionPane.INFORMATION_MESSAGE);
			init();
		}
	}
	
	/**
	 * initCashIncomeProcess executes the initialization cash on process to be stored at data base.
	 */
	public boolean initCashIncomeProcess(double cash) {
		int incomeStatus=200;
		String saleDate;
		boolean initOk=false;
		saleDate = TempSaleCalculating.getCurrentTimeUsingDate();
		Incomes income = new Incomes();
		income.setNoSale(PaymentTypeCatalog.ID_CASH);
		income.setDescription(PaymentTypeCatalog.INIT_CASH);
		income.setPaymentType(PaymentTypeCatalog.CASH);
		income.setTotal(cash);
		income.setIncomeDate(saleDate);	
		income.setEmployee(employee);
		incomeStatus = IncomesClient.addIncome(income);
		if(incomeStatus==200) {
			initOk=true;
		}
		return initOk;
	}

}
