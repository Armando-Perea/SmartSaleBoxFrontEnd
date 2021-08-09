package com.java.smartsaleboxfrontend.business.update;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.AdministratorClient;
import com.java.smartsalebox.models.Administrator;
import com.java.smartsaleboxfrontend.business.read.ReadAdminInfo;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;
import com.java.smartsaleboxfrontend.utils.SmartSaleBoxClearFields;

public class UpdateAdminProcess {

	// tblAdminInfoSearch

	private static final String ADMINISTRATOR_UPDATED = "Empleado Actualizado con Éxito!";
	private static final String ADMINISTRATOR_NOT_FOUND = "Empleado no existe!";
	private static final String ADMINISTRATOR_UPDATE_FAILED = "No es posible actualizar Empleado";
	private static final String SELECT_ADMINISTRATOR = "Seleccione un Empleado en la Tabla";
	private static final String NUMERIC_VALIDATION_ERROR = "Dato debe ser numérico, revise información";
	private static final String VALIDATION_UPDATE_TITLE = "Validacion";
	private static final String VALIDATION_PASSWORD = "Password No Valido para Actualizar";
	private static final String VALIDATION_NUMBER = "java.lang.NumberFormatException";
	private static final String VALIDATION_TOTAL = "java.lang.NumberFormatException";

	/**
	 * updateSelectedProductProcess executes the update process for the product
	 * table.
	 */
	// {adm.getIdAdministrator(),adm.getName(),adm.getLastName(),adm.getPosition(),adm.getEmail(),adm.getPassword()};
	public static void updateEmployee() {
		int row;
		Integer employeeId;
		int status = 0;
		String employeeName, employeeLast, employeePhone, employeeRole;

		Administrator employee = new Administrator();
		row = SmartSaleBoxMain.tblAdmin.getSelectedRow();
		try {
			if (row > -1) {
				employeeId = Integer.parseInt(SmartSaleBoxMain.tblAdmin.getValueAt(row, 0).toString());
				employee = AdministratorClient.getAdminById(employeeId);
				if (employee != null) {
					employeeName = (String) SmartSaleBoxMain.tblAdmin.getValueAt(row, 1);
					employeeLast = (String) SmartSaleBoxMain.tblAdmin.getValueAt(row, 2);
					employeePhone = (String) SmartSaleBoxMain.tblAdmin.getValueAt(row, 3);
					employeeRole = (String) SmartSaleBoxMain.tblAdmin.getValueAt(row, 4);
					//// SETTING THE VALUES TO CAREER OBJECT
					if (!employeeName.isEmpty()) {
						employee.setAdminName(employeeName);
					}
					if (!employeeLast.isEmpty()) {
						employee.setAdminLastName(employeeLast);
					}
					if (!employeePhone.isEmpty()) {
						employee.setAdminPhone(employeePhone);
					}
					if (!employeeRole.isEmpty()) {
						employee.setAdminRole(employeeRole);
					}

					status = AdministratorClient.updateAdmin(employee);
					if (status > 0 && status < 300) {
						JOptionPane.showMessageDialog(null, ADMINISTRATOR_UPDATED, VALIDATION_UPDATE_TITLE,
								JOptionPane.INFORMATION_MESSAGE);
						SmartSaleBoxClearFields.clearAdminProcess();
						ReadAdminInfo.getAllAdminTable();
					} else {
						JOptionPane.showMessageDialog(null, ADMINISTRATOR_UPDATE_FAILED, VALIDATION_UPDATE_TITLE,
								JOptionPane.INFORMATION_MESSAGE);
						SmartSaleBoxClearFields.clearAdminProcess();
						ReadAdminInfo.getAllAdminTable();
					}
				} else {
					JOptionPane.showMessageDialog(null, ADMINISTRATOR_NOT_FOUND, VALIDATION_UPDATE_TITLE,
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, SELECT_ADMINISTRATOR, VALIDATION_UPDATE_TITLE,
						JOptionPane.WARNING_MESSAGE);
			}
		} catch (Exception ex) {
			System.out.println("ISSUE: " + ex);
			if (ex.toString().contains(VALIDATION_NUMBER) || ex.toString().contains(VALIDATION_TOTAL)) {
				JOptionPane.showMessageDialog(null, NUMERIC_VALIDATION_ERROR, VALIDATION_UPDATE_TITLE,
						JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, VALIDATION_PASSWORD, VALIDATION_UPDATE_TITLE,
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}

}
