package com.java.smartsaleboxfrontend.business.save;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.AdministratorClient;
import com.java.smartsalebox.client.ProductsClient;
import com.java.smartsalebox.models.Administrator;
import com.java.smartsalebox.models.Products;
import com.java.smartsaleboxfrontend.gui.SmartSaleBoxMain;

public class SaveEmployeeProcess {

	 public final static String ADMIN_SAVED_SUCCESSFULLY=" ha sido dado de alta con éxito!";
	    public final static String ADMIN_SAVED_FAILED="No es posible dar de alta Administrador en este momento";
	    private static final String NUMERIC_VALIDATION_ERROR = "Dato debe ser numérico, revise información";
	   	private static final String VALIDATION_NUMBER = "java.lang.NumberFormatException";
		
		public static Integer createNewAdmin() {
			Administrator newEmployee = new Administrator();
				try {	
					newEmployee.setIdEmployee(0);
					newEmployee.setEmployeeName(SmartSaleBoxMain.txtAdminName.getText());
					newEmployee.setEmployeeLastName(SmartSaleBoxMain.txtAdminName.getText());
					newEmployee.setEmployeePhone(SmartSaleBoxMain.txtAdminName.getText());
					newEmployee.setEmployeeRole((String) SmartSaleBoxMain.cmbAdminRole.getSelectedItem());
					newEmployee.setEmployeePassword(new String(SmartSaleBoxMain.pwdAdmin1.getPassword()));
					newEmployee = AdministratorClient.addEmployee(newEmployee);
					if(newEmployee.getIdEmployee()!=null) {
						JOptionPane.showMessageDialog(null, newEmployee.getEmployeeName()+ADMIN_SAVED_SUCCESSFULLY);
					}else {
						JOptionPane.showMessageDialog(null,ADMIN_SAVED_FAILED);
					}
				}catch(Exception ex) {
					System.out.println("ISSUE: "+ex);
					if(ex.toString().contains(VALIDATION_NUMBER)) {
					JOptionPane.showMessageDialog(null, NUMERIC_VALIDATION_ERROR,"Validation", JOptionPane.WARNING_MESSAGE);	
					}else {
					JOptionPane.showMessageDialog(null, "Se produjo una excepción al guardar","Validation", JOptionPane.WARNING_MESSAGE);	
					}
				}

			return newEmployee.getIdEmployee();
		}
}
