package com.java.smartsaleboxfrontend.business.save;

import javax.swing.JOptionPane;

import com.java.smartsalebox.client.SystemPathsClient;
import com.java.smartsalebox.models.SystemPaths;



public class SaveSystemPathsProcess {

	public final static String PATH_SAVED_SUCCESSFULLY="Path guardado con éxito";
    public final static String PATH_SAVED_FAILED="No es posible crear path en este momento";
    private static final String NUMERIC_VALIDATION_ERROR = "Dato debe ser numérico, revise información";
   	private static final String VALIDATION_NUMBER = "java.lang.NumberFormatException";
	
	public static Integer createNewOutflow() {
		SystemPaths newSystemPaths = new SystemPaths();
			try {	
				newSystemPaths.setIdPath(0);
				newSystemPaths.setClosurePdf("");
				newSystemPaths.setInflowsPdf("");
				newSystemPaths.setOutflowsPdf("");
				newSystemPaths.setProductEarningsPdf("");
				newSystemPaths.setProductsPdf("");
				newSystemPaths.setSalesPdf("");
				
				newSystemPaths = SystemPathsClient.addSystemPath(newSystemPaths);
				if(newSystemPaths.getIdPath()!=null) {
					JOptionPane.showMessageDialog(null, PATH_SAVED_SUCCESSFULLY);
				}else {
					JOptionPane.showMessageDialog(null,PATH_SAVED_FAILED);
				}
			}catch(Exception ex) {
				System.out.println("ISSUE: "+ex);
				if(ex.toString().contains(VALIDATION_NUMBER)) {
				JOptionPane.showMessageDialog(null, NUMERIC_VALIDATION_ERROR,"Validation", JOptionPane.WARNING_MESSAGE);	
				}else {
				JOptionPane.showMessageDialog(null, "Se produjo una excepción al guardar","Validation", JOptionPane.WARNING_MESSAGE);	
				}
			}

		return newSystemPaths.getIdPath();
	}
	
}
