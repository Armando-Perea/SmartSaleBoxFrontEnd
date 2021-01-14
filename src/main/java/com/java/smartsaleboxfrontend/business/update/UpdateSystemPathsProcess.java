package com.java.smartsaleboxfrontend.business.update;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.SystemPathsClient;
import com.java.smartsalebox.models.SystemPaths;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;

public class UpdateSystemPathsProcess {

	// tblAdminInfoSearch

	private static final String PATHS_UPDATED = "Path Actualizado con Éxito!";
	private static final String PATHS_NOT_FOUND = "Path no existe!";
	private static final String PATHS_UPDATE_FAILED = "No es posible actualizar Path";
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
	public static void updateSystemPaths() {
		int row;
		Integer idPath;
		int status = 0;
		String inflowsPdf, outflowsPdf, earningsPdf, productsPdf, salesPdf;

		SystemPaths paths = new SystemPaths();
		row = SmartSaleBoxMain.tblAdmin.getSelectedRow();
		try {
			if (row > -1) {
				idPath = Integer.parseInt(SmartSaleBoxMain.tblAdmin.getValueAt(row, 0).toString());
				paths = SystemPathsClient.getSystemPathById(idPath);
				if (paths != null) {
					inflowsPdf = (String) SmartSaleBoxMain.tblAdmin.getValueAt(row, 1);
					outflowsPdf = (String) SmartSaleBoxMain.tblAdmin.getValueAt(row, 2);
					earningsPdf = (String) SmartSaleBoxMain.tblAdmin.getValueAt(row, 3);
					productsPdf = (String) SmartSaleBoxMain.tblAdmin.getValueAt(row, 4);
					salesPdf = (String) SmartSaleBoxMain.tblAdmin.getValueAt(row, 5);
					//// SETTING THE VALUES TO CAREER OBJECT
					if (!inflowsPdf.isEmpty()) {
						paths.setInflowsPdf(inflowsPdf);
					}
					if (!outflowsPdf.isEmpty()) {
						paths.setOutflowsPdf(outflowsPdf);
					}
					if (!earningsPdf.isEmpty()) {
						paths.setProductEarningsPdf(earningsPdf);
					}

					if (!productsPdf.isEmpty()) {
						paths.setProductsPdf(productsPdf);
					}

					if (!salesPdf.isEmpty()) {
						paths.setSalesPdf(salesPdf);
					}

					status = SystemPathsClient.updateSystemPath(paths);
					if (status > 0 && status < 300) {
						JOptionPane.showMessageDialog(null, PATHS_UPDATED, VALIDATION_UPDATE_TITLE,
								JOptionPane.INFORMATION_MESSAGE);
						// ReadAdministrationInfo.fillAllAdminTable();
					} else {
						JOptionPane.showMessageDialog(null, PATHS_UPDATE_FAILED, VALIDATION_UPDATE_TITLE,
								JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, PATHS_NOT_FOUND, VALIDATION_UPDATE_TITLE,
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
