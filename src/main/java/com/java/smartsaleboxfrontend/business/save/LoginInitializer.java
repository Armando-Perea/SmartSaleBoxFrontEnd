package com.java.smartsaleboxfrontend.business.save;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import org.apache.commons.collections.CollectionUtils;

import com.java.smartsalebox.client.AdministratorClient;
import com.java.smartsalebox.client.CashClient;
import com.java.smartsalebox.client.EmailConfigClient;
import com.java.smartsalebox.client.InflowClient;
import com.java.smartsalebox.models.Administrator;
import com.java.smartsalebox.models.Cash;
import com.java.smartsalebox.models.Inflow;
import com.java.smartsalebox.models.Sales;
import com.java.smartsaleboxfrontend.business.read.ReadEmailInfo;
import com.java.smartsaleboxfrontend.business.read.ReadInflowProcess;
import com.java.smartsaleboxfrontend.business.read.ReadOutflowProcess;
import com.java.smartsaleboxfrontend.business.read.ReadSaleInfo;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;

public class LoginInitializer {

	private static final Integer ID_CASH = 1;
	private static final Double MINIMUM_CASH = 1.00;
	private static final String SYSTEM_TITLE = "SmartSaleBox";
	private static final String MINIMUM_INIT_CASH_MSG = "Debe iniciar caja con minimo de $1 MXN por favor ";
	private static final String USER_PASS_NOT_FOUND = "Usuario y Constraseña no existen";

	public static void authenticationProcess() {
		List<Administrator> admin = new ArrayList<>();
		String userName;
		String password = null;
		int passResult;
		JPasswordField pf = new JPasswordField();
		userName = JOptionPane.showInputDialog("Usuario: ");
		passResult = JOptionPane.showConfirmDialog(null, pf, "Contraseña", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);
		if (passResult == JOptionPane.OK_OPTION) {
			password = new String(pf.getPassword());
		}
		admin = Arrays.asList(AdministratorClient.getAdminByNameAndPassword(userName, password));
		if (!CollectionUtils.isEmpty(admin)) {
			SmartSaleBoxMain.adminName = admin.get(0).getAdminName() + " " + admin.get(0).getAdminLastName();
			JOptionPane.showMessageDialog(null, "Bienvenid@ " + SmartSaleBoxMain.adminName, SYSTEM_TITLE,
					JOptionPane.INFORMATION_MESSAGE);
			cashInitializerProcess();
		} else {
			JOptionPane.showMessageDialog(null, USER_PASS_NOT_FOUND, "ERROR", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}

	private static void cashInitializerProcess() {
		Cash cash = new Cash();
		double initCash = 0.0;
		double inCash;
		cash = CashClient.getCashById(ID_CASH);
		if (cash == null) {
			cash = initializeCashSystem();
		}
		initCash = cash.getQuantity();
		if (initCash <= 0.0) {
			inCash = Integer.parseInt(JOptionPane.showInputDialog("Inicialize caja por favor: "));
			if (inCash < MINIMUM_CASH) {
				JOptionPane.showMessageDialog(null, MINIMUM_INIT_CASH_MSG, SYSTEM_TITLE,
						JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			} else {
				if (initCashIncomeProcess(inCash)) {
					SmartSaleBoxMain.cash = cash.getQuantity() + inCash;
					cash.setQuantity(SmartSaleBoxMain.cash);
					CashClient.updateCash(cash);
					SmartSaleBoxMain.noSale++;
					SmartSaleBoxMain.ticketTitle = cash.getTicketTitle();
					SmartSaleBoxMain.ticketService = cash.getTicketService();
					SmartSaleBoxMain.mailService = EmailConfigClient.getEmailConfigById(1).getIsActiveService();
				}
			}
		} else {
			SmartSaleBoxMain.cash = cash.getQuantity();
			SmartSaleBoxMain.noSale = cash.getNoSale();
			SmartSaleBoxMain.ticketTitle = cash.getTicketTitle();
			SmartSaleBoxMain.ticketService = cash.getTicketService();
			SmartSaleBoxMain.mailService = EmailConfigClient.getEmailConfigById(1).getIsActiveService();
			JOptionPane.showMessageDialog(null, "Verifique cajón : $" + SmartSaleBoxMain.cash, SYSTEM_TITLE,
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private static Cash initializeCashSystem() {
		CashClient.truncateCash();
		String storeTitle;
		storeTitle = JOptionPane.showInputDialog("Nombre del Negocio: ");
		Cash cash = new Cash();
		cash.setQuantity(0.0);
		cash.setNoSale(0);
		cash.setTicketTitle(storeTitle);
		return CashClient.addCash(cash);
	}

	private static boolean initCashIncomeProcess(double cash) {
		Inflow newInflow = new Inflow();
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", new Locale("es", "ES"));
		String formattedDate = myDateObj.format(myFormatObj);
		Inflow inflow = new Inflow();
		newInflow.setIdInflow(0);
		newInflow.setAttendee(SmartSaleBoxMain.adminName);
		newInflow.setConcept("INICIO CAJA");
		newInflow.setDescription("NUEVO TURNO");
		newInflow.setInflowDate(formattedDate);
		newInflow.setPaymentType("EFECTIVO");
		newInflow.setQuantity(cash);
		inflow = InflowClient.addInflow(newInflow);
		return inflow.getIdInflow() != null;
	}
	
	public static void initializeBalanceAndHistory() {
		ReadInflowProcess.initInflowBalanceProcess();
		ReadOutflowProcess.initOutflowBalanceProcess();
		ReadSaleInfo.getAllSaleHistoryTable();
	}
	
	public static void checkPendingSales() {
		Sales[] sales = ReadSaleInfo.getSalesByNoSale();
		List<Sales> salesList = Arrays.stream(sales).collect(Collectors.toList());
		if(!CollectionUtils.isEmpty(salesList)) {
			JOptionPane.showMessageDialog(null, "Hay Ventas Pendientes!", SYSTEM_TITLE,
					JOptionPane.INFORMATION_MESSAGE);
		}
		
	}

}
