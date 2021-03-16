package com.java.smartsaleboxfrontend.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.java.smartsalebox.models.Sales;
import com.java.smartsaleboxfrontend.business.delete.DeleteSaleProcess;
import com.java.smartsaleboxfrontend.business.read.ReadCartSaleInfo;
import com.java.smartsaleboxfrontend.business.read.ReadInflowProcess;
import com.java.smartsaleboxfrontend.business.read.ReadOutflowProcess;
import com.java.smartsaleboxfrontend.business.read.ReadSaleInfo;
import com.java.smartsaleboxfrontend.business.save.LoginInitializer;
import com.java.smartsaleboxfrontend.business.save.SaveBulkProductProcess;
import com.java.smartsaleboxfrontend.business.save.SaveEmailProcess;
import com.java.smartsaleboxfrontend.business.save.SaveInflowProcess;
import com.java.smartsaleboxfrontend.business.save.SaveOutflowProcess;
import com.java.smartsaleboxfrontend.business.save.SaveProductProcess;
import com.java.smartsaleboxfrontend.business.save.SaveSaleProcess;
import com.java.smartsaleboxfrontend.business.update.UpdateBulkStockProcess;
import com.java.smartsaleboxfrontend.business.update.UpdateCashProcess;
import com.java.smartsaleboxfrontend.business.update.UpdateProductEarningsProcess;
import com.java.smartsaleboxfrontend.business.update.UpdateProductStockProcess;
import com.java.smartsaleboxfrontend.utils.SmartSaleBoxClearFields;
import com.java.smartsaleboxfrontend.utils.SmartSaleBoxOperations;

import javax.swing.JTabbedPane;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class SmartSaleBoxMain extends JFrame {

	private static final long serialVersionUID = -3289141083530735532L;
	
	public static BulkSaleMain bulkSaleMain = new BulkSaleMain();
	
	public static Integer noSale = 0;
	public static Double cash = 500.00;
	public static String adminName;
	public static String ticketTitle;
	public static List<Sales> salesList = new ArrayList<>();
	public static List<Sales> bulkList = new ArrayList<>();
	
	private JPanel contentPane;
	
	/// TABLES CREATION  /////
	public static JTable tblSale;
	public static JTable tblCartSale;
	public static JTable tblSaleHistory;
	public static JTable tblNewProduct;
	public static JTable tblNewBulkProducts;
	public static JTable tblEmail;
	public static JTable tblAdmin;
	public static JTable tblInflows;
	public static JTable tblOutflows;
	
	/// TABLE MODEL CREATION  /////
	public static DefaultTableModel tableModelSale;  
	public static DefaultTableModel tableModelCartSale; 
	public static DefaultTableModel tableModelCashPayment; 
	public static DefaultTableModel tableModelSaleHistory;
	public static DefaultTableModel tableModelNewProduct;
	public static DefaultTableModel tableModelNewBulkProducts;
	public static DefaultTableModel tableModelEmail;
	public static DefaultTableModel tableModelAdmin;
	public static DefaultTableModel tableModelInflows;
	public static DefaultTableModel tableModelOutflows;
	
	// SCROLL SECTION
	public static JScrollPane scrollCartSale;
	public static JScrollPane scrollSale;
	public static JScrollPane scrollSaleHistory;
	public static JScrollPane scrollInflows;
	public static JScrollPane scrollOutflows;
	public static JTextField txtCardPayment;
	public static JTextField txtTotalSale;
	public static JTextField txtReceived;
	public static JTextField txtChangeBack;
	public static JTextField txtSaleProductSaleName;
	public static JTextField txtProductCodeSearch;
	
	public static JTextField txtHistoryNoSale;
	public static JTextField txtTotalSaleHistory;
	public static JTextField txtTotalInflows;
	public static JTextField txtTotalOutflows;
	
	public static JTextField txtNewProductName;
	public static JTextField txtNewCostPrice;
	public static JTextField txtNewSalePrice;
	public static JTextField txtNewEarning;
	public static JTextField txtNewStock;
	public static JTextField txtNewBarCode;
	
	public static JTextField txtNewBulkProductName;
	public static JTextField txtNewBulkCostPrice;
	public static JTextField txtNewBulkKiloPrice;
	public static JTextField txtNewBulkStock;
	public static JTextField txtNewBulkBarCodeProd;
	public static JTextField txtNewBulkKiloEarning;
	public static JTextField txtNewBulkEarning;
	
	public static JTextField textField;
	public static JTextField textField_1;
	public static JTextField textField_2;
	public static JTextField textField_3;
	public static JTextField textField_4;
	public static JTextField textField_5;
	public static JTextField textField_6;
	public static JTextField textField_8;
	public static JTextField textField_9;
	public static JTextField txtEmailNew;
	
	public static JTextField txtAdminName;
	public static JPasswordField pwdAdmin1;
	public static JPasswordField pwdAdmin2;
	public static JTextField txtInOutConcept;
	public static JTextField txtInOutQuantity;
	public static JPasswordField pwdEmailNew;
	
	public static JComboBox<String> cmbAdminRole;
	public static JComboBox<String> cmbOperationType;
	public static JComboBox<String> cmbPaymentTypeInOut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SmartSaleBoxMain frame = new SmartSaleBoxMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SmartSaleBoxMain() {
		LoginInitializer.authenticationProcess();
		initializeSmartSaleBoxComponents();
		LoginInitializer.initializeBalanceAndHistory();
		LoginInitializer.checkPendingSales();
	}
	
	public void initializeSmartSaleBoxComponents() {
		setTitle("Punto de Venta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1063, 718);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel tabbedSale = new JPanel();
		tabbedSale.setBackground(SystemColor.window);
		tabbedPane.addTab("Venta", null, tabbedSale, null);
		tabbedSale.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("@SmartSaleBox.");
		lblNewLabel.setFont(new Font("Lucida Bright", Font.BOLD, 24));
		lblNewLabel.setBounds(726, 10, 201, 28);
		tabbedSale.add(lblNewLabel);
		
		JLabel lblEnVenta = new JLabel("En venta");
		lblEnVenta.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		lblEnVenta.setBounds(12, 12, 97, 28);
		tabbedSale.add(lblEnVenta);
		
		JPanel salePanel = new JPanel();
		salePanel.setBounds(53, 209, 464, 214);
		tabbedSale.add(salePanel);
		salePanel.setLayout(new BorderLayout(0, 0));
		
		scrollSale = new JScrollPane();
		salePanel.add(scrollSale, BorderLayout.CENTER);
		
		tblSale = new JTable();
		scrollSale.setViewportView(tblSale);
		
		JPanel cartSalePanel = new JPanel();
		cartSalePanel.setBounds(53, 78, 484, 85);
		tabbedSale.add(cartSalePanel);
		cartSalePanel.setLayout(new BorderLayout(0, 0));
		
		scrollCartSale = new JScrollPane();
		cartSalePanel.add(scrollCartSale, BorderLayout.CENTER);
		
		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto.setBounds(53, 52, 97, 28);
		tabbedSale.add(lblProducto);
		
		JLabel lblProducto_2_1 = new JLabel("Total: $");
		lblProducto_2_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_1.setBounds(368, 435, 64, 28);
		tabbedSale.add(lblProducto_2_1);
		
		JLabel lblProducto_2_1_1 = new JLabel("  Efectivo: $");
		lblProducto_2_1_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_1_1.setBounds(421, 504, 87, 28);
		tabbedSale.add(lblProducto_2_1_1);
		
		JLabel lblProducto_2_1_1_1 = new JLabel("Cambio: $");
		lblProducto_2_1_1_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_1_1_1.setBounds(438, 538, 79, 28);
		tabbedSale.add(lblProducto_2_1_1_1);
		
		JLabel lblProducto_1_1 = new JLabel("Tarjeta: $");
		lblProducto_1_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_1_1.setBounds(440, 473, 77, 28);
		tabbedSale.add(lblProducto_1_1);
		
		txtTotalSale = new JTextField();
		txtTotalSale.setEditable(false);
		txtTotalSale.setText("0.00");
		txtTotalSale.setFont(new Font("Dialog", Font.BOLD, 14));
		txtTotalSale.setColumns(10);
		txtTotalSale.setBounds(432, 437, 87, 28);
		tabbedSale.add(txtTotalSale);
		
		txtCardPayment = new JTextField();
		txtCardPayment.setEnabled(false);
		txtCardPayment.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				SmartSaleBoxOperations.saleReceivedCashProcess();
			}
		});
		txtCardPayment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtCardPayment.isEnabled())
					txtCardPayment.setText(null);
			}
		});
		txtCardPayment.setFont(new Font("Dialog", Font.BOLD, 14));
		txtCardPayment.setText("0.00");
		txtCardPayment.setColumns(10);
		txtCardPayment.setBounds(517, 475, 87, 28);
		tabbedSale.add(txtCardPayment);
		
		txtReceived = new JTextField();
		txtReceived.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtReceived.setText(null);
			}
		});
		txtReceived.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				SmartSaleBoxOperations.saleReceivedCashProcess();
			}
		});
		txtReceived.setFont(new Font("Dialog", Font.BOLD, 14));
		txtReceived.setText("0.00");
		txtReceived.setColumns(10);
		txtReceived.setBounds(517, 506, 87, 28);
		tabbedSale.add(txtReceived);
		
		txtChangeBack = new JTextField();
		txtChangeBack.setEditable(false);
		txtChangeBack.setFont(new Font("Dialog", Font.BOLD, 14));
		txtChangeBack.setText("0.00");
		txtChangeBack.setColumns(10);
		txtChangeBack.setBounds(517, 540, 87, 28);
		tabbedSale.add(txtChangeBack);
		
		JButton btnExecuteSale = new JButton("Cobrar");
		btnExecuteSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!SmartSaleBoxOperations.isValidSaleQuantity()) {
					JOptionPane.showMessageDialog(null,"La cantidad recibida es menor, verifique!");
				}else if(!SmartSaleBoxOperations.isValidCashChange()) {
					JOptionPane.showMessageDialog(null,"El cambio a dar excede la cantidad \ndisponible en cajón $"+cash+" , \nintroduzca más efectivo en caja!");
				}
				else {
					if(SaveSaleProcess.createNewSaleAndInflow(SmartSaleBoxOperations.getPaymentType())) {
						UpdateProductStockProcess.updateGeneralProductStock();
						UpdateBulkStockProcess.updateBulkProductStock();
						UpdateProductEarningsProcess.addGeneralProductEarning();
						UpdateProductEarningsProcess.addBulkProductEarning();
						UpdateCashProcess.updateCashAndNoSale();
						SmartSaleBoxClearFields.clearSaleMain();
						ReadInflowProcess.initInflowBalanceProcess();
						ReadOutflowProcess.initOutflowBalanceProcess();
						ReadSaleInfo.getAllSaleHistoryTable();
					}else {
						JOptionPane.showMessageDialog(null,"No es posible guardar la compra por el momento!");
					}
				}
			}
		});
		btnExecuteSale.setBounds(620, 538, 115, 39);
		tabbedSale.add(btnExecuteSale);
		
		JLabel lblEnVenta_1 = new JLabel("En Venta:");
		lblEnVenta_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblEnVenta_1.setBounds(53, 169, 97, 28);
		tabbedSale.add(lblEnVenta_1);
		
		JLabel lblConsultarProducto = new JLabel("Consultar Producto");
		lblConsultarProducto.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblConsultarProducto.setBounds(652, 40, 150, 28);
		tabbedSale.add(lblConsultarProducto);
		
		txtSaleProductSaleName = new JTextField();
		txtSaleProductSaleName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (SmartSaleBoxOperations.validateGetProdName()) {
						ReadCartSaleInfo.fillCartSaleTableByName(txtSaleProductSaleName.getText());
					} else {
						JOptionPane.showMessageDialog(null, "Ingrese Producto por favor");
					}
				}
			}
		});
		txtSaleProductSaleName.setColumns(10);
		txtSaleProductSaleName.setBounds(624, 80, 212, 28);
		tabbedSale.add(txtSaleProductSaleName);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblNombre.setBounds(555, 78, 69, 28);
		tabbedSale.add(lblNombre);
		
		JLabel lblCdigo = new JLabel("Código:");
		lblCdigo.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblCdigo.setBounds(555, 135, 64, 28);
		tabbedSale.add(lblCdigo);
		
		txtProductCodeSearch = new JTextField();
		txtProductCodeSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtProductCodeSearch.setText(null);
			}
		});
		txtProductCodeSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (SmartSaleBoxOperations.validateScannerReading()) {
						SaveSaleProcess.addProductToSaleListByScanner();
					} else {
						JOptionPane.showMessageDialog(null, "Ingrese código de barras por favor");
					}
				}
			}
		});
		txtProductCodeSearch.setColumns(10);
		txtProductCodeSearch.setBounds(624, 135, 212, 28);
		tabbedSale.add(txtProductCodeSearch);
		
		JButton btnVentaKg = new JButton("Venta por Kg");
		btnVentaKg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bulkSaleMain.setVisible(true);
				bulkSaleMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVentaKg.setBounds(529, 254, 150, 28);
		tabbedSale.add(btnVentaKg);
		
		JButton btnClearSale = new JButton("Borrar Venta");
		btnClearSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteSaleProcess.removeCurrentSaleProcess();
			}
		});
		btnClearSale.setBounds(53, 446, 140, 39);
		tabbedSale.add(btnClearSale);
		
		JLabel lblF = new JLabel("F9");
		lblF.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblF.setBounds(591, 279, 34, 28);
		tabbedSale.add(lblF);
		
		JLabel lblF_2 = new JLabel("F5");
		lblF_2.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblF_2.setBounds(115, 490, 49, 28);
		tabbedSale.add(lblF_2);
		
		JLabel lblF_1 = new JLabel("F12");
		lblF_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblF_1.setBounds(652, 579, 49, 28);
		tabbedSale.add(lblF_1);
		
		JPanel tabbedSalesHistory = new JPanel();
		tabbedSalesHistory.setBackground(SystemColor.window);
		tabbedPane.addTab("Historial Ventas", null, tabbedSalesHistory, null);
		tabbedSalesHistory.setLayout(null);
		
		JLabel lblVentas = new JLabel("Ventas");
		lblVentas.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		lblVentas.setBounds(46, 26, 97, 28);
		tabbedSalesHistory.add(lblVentas);
		
		scrollSaleHistory = new JScrollPane();
		scrollSaleHistory.setBounds(44, 134, 644, 415);
		tabbedSalesHistory.add(scrollSaleHistory);
		
		tblSaleHistory = new JTable();
		scrollSaleHistory.setViewportView(tblSaleHistory);
		
		JLabel lblNoVenta = new JLabel("No. Venta:");
		lblNoVenta.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblNoVenta.setBounds(46, 82, 85, 28);
		tabbedSalesHistory.add(lblNoVenta);
		
		txtHistoryNoSale = new JTextField();
		txtHistoryNoSale.setBounds(128, 84, 85, 28);
		tabbedSalesHistory.add(txtHistoryNoSale);
		txtHistoryNoSale.setColumns(10);
		
		JButton btnHistorySearchSale = new JButton("Consultar");
		btnHistorySearchSale.setBounds(225, 85, 109, 25);
		tabbedSalesHistory.add(btnHistorySearchSale);
		
		JLabel lblTotalVentas = new JLabel("Total Ventas: $");
		lblTotalVentas.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblTotalVentas.setBounds(487, 561, 120, 28);
		tabbedSalesHistory.add(lblTotalVentas);
		
		txtTotalSaleHistory = new JTextField();
		txtTotalSaleHistory.setColumns(10);
		txtTotalSaleHistory.setBounds(603, 561, 85, 35);
		tabbedSalesHistory.add(txtTotalSaleHistory);
		
		JButton btnBackUpSale = new JButton("Generar Reverso");
		btnBackUpSale.setBounds(737, 494, 164, 39);
		tabbedSalesHistory.add(btnBackUpSale);
		
		JButton btnPrintTicket = new JButton("Imprimir Ticket");
		btnPrintTicket.setBounds(737, 406, 164, 39);
		tabbedSalesHistory.add(btnPrintTicket);
		
		JLabel lblNewLabel_1 = new JLabel("@SmartSaleBox.");
		lblNewLabel_1.setFont(new Font("Lucida Bright", Font.BOLD, 24));
		lblNewLabel_1.setBounds(840, 12, 201, 28);
		tabbedSalesHistory.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Productos", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		panel.add(tabbedPane_1, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		tabbedPane_1.addTab("Productos", null, panel_1, null);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel tabbedProducts_1 = new JPanel();
		tabbedProducts_1.setLayout(null);
		tabbedProducts_1.setBackground(SystemColor.window);
		panel_1.add(tabbedProducts_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("@SmartSaleBox.");
		lblNewLabel_1_1_1.setFont(new Font("Lucida Bright", Font.BOLD, 24));
		lblNewLabel_1_1_1.setBounds(840, 12, 201, 28);
		tabbedProducts_1.add(lblNewLabel_1_1_1);
		
		JLabel lblAltaProducto_1 = new JLabel("Alta Producto");
		lblAltaProducto_1.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		lblAltaProducto_1.setBounds(112, 58, 140, 28);
		tabbedProducts_1.add(lblAltaProducto_1);
		
		JLabel lblConsultaProducto_1 = new JLabel("Consulta Producto");
		lblConsultaProducto_1.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		lblConsultaProducto_1.setBounds(645, 58, 189, 28);
		tabbedProducts_1.add(lblConsultaProducto_1);
		
		JScrollPane paneGetProduct = new JScrollPane();
		paneGetProduct.setBounds(443, 133, 565, 370);
		tabbedProducts_1.add(paneGetProduct);
		
		tblNewProduct = new JTable();
		paneGetProduct.setViewportView(tblNewProduct);
		
		JLabel lblProducto_2_6 = new JLabel("Producto:");
		lblProducto_2_6.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_6.setBounds(55, 133, 85, 28);
		tabbedProducts_1.add(lblProducto_2_6);
		
		JLabel lblProducto_2_2_1 = new JLabel("Precio Costo: $");
		lblProducto_2_2_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_2_1.setBounds(32, 191, 108, 28);
		tabbedProducts_1.add(lblProducto_2_2_1);
		
		JLabel lblProducto_2_3_1 = new JLabel("Precio Venta: $");
		lblProducto_2_3_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_3_1.setBounds(32, 242, 108, 28);
		tabbedProducts_1.add(lblProducto_2_3_1);
		
		JLabel lblProducto_2_4_3 = new JLabel("Ganancia: $");
		lblProducto_2_4_3.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_4_3.setBounds(55, 296, 85, 28);
		tabbedProducts_1.add(lblProducto_2_4_3);
		
		JLabel lblProducto_2_4_1_1 = new JLabel("Stock:");
		lblProducto_2_4_1_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_4_1_1.setBounds(97, 346, 52, 28);
		tabbedProducts_1.add(lblProducto_2_4_1_1);
		
		JLabel lblProducto_2_4_2_1 = new JLabel("Codigo Barras:");
		lblProducto_2_4_2_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_4_2_1.setBounds(32, 402, 108, 28);
		tabbedProducts_1.add(lblProducto_2_4_2_1);
		
		JButton btnSaveNewProduct = new JButton("Guardar");
		btnSaveNewProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveProductProcess.createNewProduct();
			}
		});
		btnSaveNewProduct.setBounds(155, 475, 117, 34);
		tabbedProducts_1.add(btnSaveNewProduct);
		
		JButton btnNewCalculateEarning = new JButton("Calcular");
		btnNewCalculateEarning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNewEarning.setText(null);
				txtNewEarning.setText(SmartSaleBoxOperations.calculateProductEarning(
						Double.parseDouble(SmartSaleBoxMain.txtNewSalePrice.getText())
						,Double.parseDouble(SmartSaleBoxMain.txtNewCostPrice.getText())));
			}
		});
		btnNewCalculateEarning.setFont(new Font("Dialog", Font.BOLD, 10));
		btnNewCalculateEarning.setBounds(261, 296, 85, 25);
		tabbedProducts_1.add(btnNewCalculateEarning);
		
		txtNewProductName = new JTextField();
		txtNewProductName.setColumns(10);
		txtNewProductName.setBounds(138, 133, 270, 34);
		tabbedProducts_1.add(txtNewProductName);
		
		txtNewCostPrice = new JTextField();
		txtNewCostPrice.setColumns(10);
		txtNewCostPrice.setBounds(157, 193, 95, 28);
		tabbedProducts_1.add(txtNewCostPrice);
		
		txtNewSalePrice = new JTextField();
		txtNewSalePrice.setColumns(10);
		txtNewSalePrice.setBounds(157, 244, 95, 28);
		tabbedProducts_1.add(txtNewSalePrice);
		
		txtNewEarning = new JTextField();
		txtNewEarning.setColumns(10);
		txtNewEarning.setBounds(158, 298, 94, 28);
		tabbedProducts_1.add(txtNewEarning);
		
		txtNewStock = new JTextField();
		txtNewStock.setColumns(10);
		txtNewStock.setBounds(158, 348, 94, 28);
		tabbedProducts_1.add(txtNewStock);
		
		txtNewBarCode = new JTextField();
		txtNewBarCode.setColumns(10);
		txtNewBarCode.setBounds(138, 401, 270, 34);
		tabbedProducts_1.add(txtNewBarCode);
		
		JButton btnUpdateProd = new JButton("Actualizar");
		btnUpdateProd.setBounds(465, 515, 117, 34);
		tabbedProducts_1.add(btnUpdateProd);
		
		JButton btnDeleteProd = new JButton("Borrar");
		btnDeleteProd.setBounds(891, 515, 117, 34);
		tabbedProducts_1.add(btnDeleteProd);
		
		JPanel panel_2 = new JPanel();
		tabbedPane_1.addTab("Productos a Granel", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel tabbedProducts_2 = new JPanel();
		tabbedProducts_2.setLayout(null);
		tabbedProducts_2.setBackground(SystemColor.window);
		panel_2.add(tabbedProducts_2, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("@SmartSaleBox.");
		lblNewLabel_1_1_2.setFont(new Font("Lucida Bright", Font.BOLD, 24));
		lblNewLabel_1_1_2.setBounds(840, 12, 201, 28);
		tabbedProducts_2.add(lblNewLabel_1_1_2);
		
		JLabel lblAltaProductoGranel = new JLabel("Alta Producto Granel");
		lblAltaProductoGranel.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		lblAltaProductoGranel.setBounds(112, 58, 215, 28);
		tabbedProducts_2.add(lblAltaProductoGranel);
		
		JLabel lblConsultaProductoGranel = new JLabel("Consulta Producto Granel");
		lblConsultaProductoGranel.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		lblConsultaProductoGranel.setBounds(645, 58, 263, 28);
		tabbedProducts_2.add(lblConsultaProductoGranel);
		
		JScrollPane paneNewBulk = new JScrollPane();
		paneNewBulk.setBounds(443, 133, 565, 380);
		tabbedProducts_2.add(paneNewBulk);
		
		tblNewBulkProducts = new JTable();
		paneNewBulk.setViewportView(tblNewBulkProducts);
		
		JLabel lblProducto_2_7 = new JLabel("Producto:");
		lblProducto_2_7.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_7.setBounds(55, 133, 85, 28);
		tabbedProducts_2.add(lblProducto_2_7);
		
		JLabel lblProducto_2_2_2 = new JLabel("Precio Costo: $");
		lblProducto_2_2_2.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_2_2.setBounds(85, 189, 108, 28);
		tabbedProducts_2.add(lblProducto_2_2_2);
		
		JLabel lblProducto_2_4_4 = new JLabel("Ganancia a Granel $");
		lblProducto_2_4_4.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_4_4.setBounds(57, 392, 146, 28);
		tabbedProducts_2.add(lblProducto_2_4_4);
		
		JLabel lblProducto_2_4_1_2 = new JLabel("Stock:");
		lblProducto_2_4_1_2.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_4_1_2.setBounds(141, 292, 52, 28);
		tabbedProducts_2.add(lblProducto_2_4_1_2);
		
		JLabel lblProducto_2_4_2_2 = new JLabel("Codigo Barras:");
		lblProducto_2_4_2_2.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_4_2_2.setBounds(33, 465, 108, 28);
		tabbedProducts_2.add(lblProducto_2_4_2_2);
		
		JButton btnSaveNewBulk = new JButton("Guardar");
		btnSaveNewBulk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveBulkProductProcess.createNewBulkProduct();
			}
		});
		btnSaveNewBulk.setBounds(210, 533, 117, 34);
		tabbedProducts_2.add(btnSaveNewBulk);
		
		JButton btnNewButton_2_1_2 = new JButton("Calcular");
		btnNewButton_2_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNewBulkKiloEarning.setText(SmartSaleBoxOperations.calculateBulkProductKiloEarning(
						Double.parseDouble(SmartSaleBoxMain.txtNewBulkCostPrice.getText()), 
						Double.parseDouble(SmartSaleBoxMain.txtNewBulkStock.getText()), 
						Double.parseDouble(SmartSaleBoxMain.txtNewBulkKiloPrice.getText())));
				txtNewBulkEarning.setText(SmartSaleBoxOperations.calculateBulkProductEarning(
						Double.parseDouble(SmartSaleBoxMain.txtNewBulkCostPrice.getText()), 
						Double.parseDouble(SmartSaleBoxMain.txtNewBulkStock.getText()), 
						Double.parseDouble(SmartSaleBoxMain.txtNewBulkKiloPrice.getText())));
			}
		});
		btnNewButton_2_1_2.setFont(new Font("Dialog", Font.BOLD, 10));
		btnNewButton_2_1_2.setBounds(325, 365, 85, 25);
		tabbedProducts_2.add(btnNewButton_2_1_2);
		
		txtNewBulkProductName = new JTextField();
		txtNewBulkProductName.setColumns(10);
		txtNewBulkProductName.setBounds(138, 133, 270, 34);
		tabbedProducts_2.add(txtNewBulkProductName);
		
		txtNewBulkCostPrice = new JTextField();
		txtNewBulkCostPrice.setColumns(10);
		txtNewBulkCostPrice.setBounds(210, 191, 95, 28);
		tabbedProducts_2.add(txtNewBulkCostPrice);
		
		txtNewBulkKiloPrice = new JTextField();
		txtNewBulkKiloPrice.setColumns(10);
		txtNewBulkKiloPrice.setBounds(210, 242, 95, 28);
		tabbedProducts_2.add(txtNewBulkKiloPrice);
		
		txtNewBulkStock = new JTextField();
		txtNewBulkStock.setColumns(10);
		txtNewBulkStock.setBounds(210, 294, 94, 28);
		tabbedProducts_2.add(txtNewBulkStock);
		
		txtNewBulkBarCodeProd = new JTextField();
		txtNewBulkBarCodeProd.setColumns(10);
		txtNewBulkBarCodeProd.setBounds(140, 464, 270, 34);
		tabbedProducts_2.add(txtNewBulkBarCodeProd);
		
		JLabel lblProducto_2_4_4_1 = new JLabel("Venta x Kilo: $");
		lblProducto_2_4_4_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_4_4_1.setBounds(85, 240, 108, 28);
		tabbedProducts_2.add(lblProducto_2_4_4_1);
		
		txtNewBulkKiloEarning = new JTextField();
		txtNewBulkKiloEarning.setColumns(10);
		txtNewBulkKiloEarning.setBounds(211, 343, 94, 28);
		tabbedProducts_2.add(txtNewBulkKiloEarning);
		
		JLabel lblProducto_2_4_4_1_1 = new JLabel("Ganancia x Kilo: $");
		lblProducto_2_4_4_1_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_4_4_1_1.setBounds(71, 341, 143, 28);
		tabbedProducts_2.add(lblProducto_2_4_4_1_1);
		
		txtNewBulkEarning = new JTextField();
		txtNewBulkEarning.setColumns(10);
		txtNewBulkEarning.setBounds(211, 394, 94, 28);
		tabbedProducts_2.add(txtNewBulkEarning);
		
		JLabel lblProducto_2_4_1_2_1 = new JLabel("gramos");
		lblProducto_2_4_1_2_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_4_1_2_1.setBounds(325, 292, 52, 28);
		tabbedProducts_2.add(lblProducto_2_4_1_2_1);
		
		JButton btnUpdateBulkProd = new JButton("Actualizar");
		btnUpdateBulkProd.setBounds(453, 525, 117, 34);
		tabbedProducts_2.add(btnUpdateBulkProd);
		
		JButton btnDeleteBulkProd = new JButton("Borrar");
		btnDeleteBulkProd.setBounds(879, 525, 117, 34);
		tabbedProducts_2.add(btnDeleteBulkProd);
		
		JPanel tabbedAdmin = new JPanel();
		tabbedPane.addTab("Administración", null, tabbedAdmin, null);
		tabbedAdmin.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedAdminOptions = new JTabbedPane(JTabbedPane.TOP);
		tabbedAdmin.add(tabbedAdminOptions, BorderLayout.CENTER);
		
		JPanel InOutPanel = new JPanel();
		InOutPanel.setBackground(SystemColor.window);
		tabbedAdminOptions.addTab("Balance", null, InOutPanel, null);
		InOutPanel.setLayout(null);
		
		scrollInflows = new JScrollPane();
		scrollInflows.setBounds(27, 78, 480, 472);
		InOutPanel.add(scrollInflows);
		
		tblInflows = new JTable();
		scrollInflows.setViewportView(tblInflows);
		
		scrollOutflows = new JScrollPane();
		scrollOutflows.setBounds(537, 78, 480, 472);
		InOutPanel.add(scrollOutflows);
		
		tblOutflows = new JTable();
		scrollOutflows.setViewportView(tblOutflows);
		
		JLabel lblEntadas = new JLabel("Entadas");
		lblEntadas.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		lblEntadas.setBounds(42, 28, 79, 28);
		InOutPanel.add(lblEntadas);
		
		JLabel lblSalidas = new JLabel("Salidas");
		lblSalidas.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		lblSalidas.setBounds(552, 28, 79, 28);
		InOutPanel.add(lblSalidas);
		
		JLabel lblProducto_2_5 = new JLabel("Total Entradas: $");
		lblProducto_2_5.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5.setBounds(267, 564, 132, 28);
		InOutPanel.add(lblProducto_2_5);
		
		txtTotalInflows = new JTextField();
		txtTotalInflows.setBounds(393, 558, 114, 34);
		InOutPanel.add(txtTotalInflows);
		txtTotalInflows.setColumns(10);
		
		JLabel lblProducto_2_5_1 = new JLabel("Total Salidas: $");
		lblProducto_2_5_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5_1.setBounds(785, 564, 114, 28);
		InOutPanel.add(lblProducto_2_5_1);
		
		txtTotalOutflows = new JTextField();
		txtTotalOutflows.setColumns(10);
		txtTotalOutflows.setBounds(903, 558, 114, 34);
		InOutPanel.add(txtTotalOutflows);
		
		JPanel closurePanel = new JPanel();
		closurePanel.setBackground(SystemColor.window);
		tabbedAdminOptions.addTab("Corte", null, closurePanel, null);
		closurePanel.setLayout(null);
		
		JLabel lblCorteDeCaja = new JLabel("Corte de Caja");
		lblCorteDeCaja.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		lblCorteDeCaja.setBounds(40, 12, 142, 28);
		closurePanel.add(lblCorteDeCaja);
		
		JLabel lblNewLabel_1_1 = new JLabel("@SmartSaleBox.");
		lblNewLabel_1_1.setFont(new Font("Lucida Bright", Font.BOLD, 24));
		lblNewLabel_1_1.setBounds(847, 12, 201, 28);
		closurePanel.add(lblNewLabel_1_1);
		
		JLabel lblProducto_2_5_2 = new JLabel("Inicio Caja: $");
		lblProducto_2_5_2.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5_2.setBounds(126, 145, 106, 28);
		closurePanel.add(lblProducto_2_5_2);
		
		JLabel lblProducto_2_5_3 = new JLabel("Total Efectivo: $");
		lblProducto_2_5_3.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5_3.setBounds(102, 208, 132, 28);
		closurePanel.add(lblProducto_2_5_3);
		
		JLabel lblProducto_2_5_4 = new JLabel("Total Tarjeta: $");
		lblProducto_2_5_4.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5_4.setBounds(112, 277, 132, 28);
		closurePanel.add(lblProducto_2_5_4);
		
		JLabel lblProducto_2_5_5 = new JLabel("Corte Caja: $");
		lblProducto_2_5_5.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5_5.setBounds(588, 145, 100, 28);
		closurePanel.add(lblProducto_2_5_5);
		
		JLabel lblProducto_2_5_6 = new JLabel("Total Entradas: $");
		lblProducto_2_5_6.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5_6.setBounds(100, 349, 132, 28);
		closurePanel.add(lblProducto_2_5_6);
		
		JLabel lblProducto_2_5_3_1 = new JLabel("Total Salida Efectivo: $");
		lblProducto_2_5_3_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5_3_1.setBounds(520, 208, 180, 28);
		closurePanel.add(lblProducto_2_5_3_1);
		
		JLabel lblProducto_2_5_4_1 = new JLabel("Total Salida Tarjeta: $");
		lblProducto_2_5_4_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5_4_1.setBounds(530, 277, 170, 28);
		closurePanel.add(lblProducto_2_5_4_1);
		
		JLabel lblProducto_2_5_6_1 = new JLabel("Total Salidas: $");
		lblProducto_2_5_6_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5_6_1.setBounds(577, 349, 132, 28);
		closurePanel.add(lblProducto_2_5_6_1);
		
		JLabel lblEntradas = new JLabel("Entradas");
		lblEntradas.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		lblEntradas.setBounds(191, 62, 93, 28);
		closurePanel.add(lblEntradas);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(233, 139, 114, 34);
		closurePanel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(233, 202, 114, 34);
		closurePanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(233, 271, 114, 34);
		closurePanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(706, 139, 114, 34);
		closurePanel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(233, 348, 114, 34);
		closurePanel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(706, 207, 114, 34);
		closurePanel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(706, 276, 114, 34);
		closurePanel.add(textField_6);
		
		JLabel lblSalidas_1 = new JLabel("Salidas");
		lblSalidas_1.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		lblSalidas_1.setBounds(702, 62, 93, 28);
		closurePanel.add(lblSalidas_1);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(706, 348, 114, 34);
		closurePanel.add(textField_8);
		
		JButton btnNewButton = new JButton("Generar Corte");
		btnNewButton.setBounds(675, 489, 153, 44);
		closurePanel.add(btnNewButton);
		
		JLabel lblProducto_2_5_6_2 = new JLabel("Ganacia productos: $");
		lblProducto_2_5_6_2.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5_6_2.setBounds(74, 411, 153, 28);
		closurePanel.add(lblProducto_2_5_6_2);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(233, 410, 114, 34);
		closurePanel.add(textField_9);
		
		JButton btnCalcularCorte = new JButton("Calcular Corte");
		btnCalcularCorte.setBounds(210, 489, 153, 44);
		closurePanel.add(btnCalcularCorte);
		
		JPanel inOutControlPanel = new JPanel();
		inOutControlPanel.setBackground(SystemColor.window);
		tabbedAdminOptions.addTab("Entradas/Salidas", null, inOutControlPanel, null);
		inOutControlPanel.setLayout(null);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("@SmartSaleBox.");
		lblNewLabel_1_1_4.setFont(new Font("Lucida Bright", Font.BOLD, 24));
		lblNewLabel_1_1_4.setBounds(835, 12, 201, 28);
		inOutControlPanel.add(lblNewLabel_1_1_4);
		
		JLabel lblControlEntradassalidas = new JLabel("Control Entradas/Salidas");
		lblControlEntradassalidas.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		lblControlEntradassalidas.setBounds(28, 12, 244, 28);
		inOutControlPanel.add(lblControlEntradassalidas);
		
		JLabel lblGenerarEntradasalida = new JLabel("Generar Entrada/Salida");
		lblGenerarEntradasalida.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		lblGenerarEntradasalida.setBounds(357, 105, 228, 28);
		inOutControlPanel.add(lblGenerarEntradasalida);
		
		JLabel lblProducto_2_5_2_2 = new JLabel("Tipo Operación:");
		lblProducto_2_5_2_2.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5_2_2.setBounds(259, 186, 123, 28);
		inOutControlPanel.add(lblProducto_2_5_2_2);
		
		JLabel lblProducto_2_5_2_2_1 = new JLabel("Concepto:");
		lblProducto_2_5_2_2_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5_2_2_1.setBounds(305, 341, 78, 28);
		inOutControlPanel.add(lblProducto_2_5_2_2_1);
		
		JLabel lblProducto_2_5_2_2_1_1 = new JLabel("Cantitdad: $");
		lblProducto_2_5_2_2_1_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5_2_2_1_1.setBounds(298, 414, 97, 28);
		inOutControlPanel.add(lblProducto_2_5_2_2_1_1);
		
		JButton btnGenerateOperation = new JButton("Generar Operación");
		btnGenerateOperation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cmbOperationType.getSelectedIndex()==0) {
					SaveInflowProcess.createNewInflow();
				}else if(cmbOperationType.getSelectedIndex()==1) {
					SaveOutflowProcess.createNewOutflow();
				}
			}
		});
		btnGenerateOperation.setBounds(393, 486, 174, 35);
		inOutControlPanel.add(btnGenerateOperation);
		
		txtInOutConcept = new JTextField();
		txtInOutConcept.setBounds(387, 339, 180, 35);
		inOutControlPanel.add(txtInOutConcept);
		txtInOutConcept.setColumns(10);
		
		txtInOutQuantity = new JTextField();
		txtInOutQuantity.setFont(new Font("Dialog", Font.BOLD, 14));
		txtInOutQuantity.setColumns(10);
		txtInOutQuantity.setBounds(385, 412, 180, 35);
		inOutControlPanel.add(txtInOutQuantity);
		
		cmbOperationType = new JComboBox();
		cmbOperationType.setModel(new DefaultComboBoxModel(new String[] {"ENTRADA", "SALIDA"}));
		cmbOperationType.setBounds(387, 176, 180, 38);
		inOutControlPanel.add(cmbOperationType);
		
		JLabel Tipo = new JLabel("Denominación:");
		Tipo.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		Tipo.setBounds(259, 254, 123, 28);
		inOutControlPanel.add(Tipo);
		
		cmbPaymentTypeInOut = new JComboBox();
		cmbPaymentTypeInOut.setModel(new DefaultComboBoxModel(new String[] {"EFECTIVO", "TARJETA"}));
		cmbPaymentTypeInOut.setBounds(387, 250, 180, 38);
		inOutControlPanel.add(cmbPaymentTypeInOut);
		
		JPanel EmailConfigPanel = new JPanel();
		EmailConfigPanel.setBackground(SystemColor.window);
		tabbedAdminOptions.addTab("Configuración Email", null, EmailConfigPanel, null);
		EmailConfigPanel.setLayout(null);
		
		JLabel lblConfiguracinEmail = new JLabel("Configuración Email");
		lblConfiguracinEmail.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		lblConfiguracinEmail.setBounds(135, 136, 192, 28);
		EmailConfigPanel.add(lblConfiguracinEmail);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("@SmartSaleBox.");
		lblNewLabel_1_1_3.setFont(new Font("Lucida Bright", Font.BOLD, 24));
		lblNewLabel_1_1_3.setBounds(835, 12, 201, 28);
		EmailConfigPanel.add(lblNewLabel_1_1_3);
		
		JLabel lblProducto_2_5_2_1 = new JLabel("Email:");
		lblProducto_2_5_2_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5_2_1.setBounds(78, 226, 63, 28);
		EmailConfigPanel.add(lblProducto_2_5_2_1);
		
		txtEmailNew = new JTextField();
		txtEmailNew.setColumns(10);
		txtEmailNew.setBounds(146, 225, 216, 34);
		EmailConfigPanel.add(txtEmailNew);
		
		JLabel lblProducto_2_5_2_1_1 = new JLabel("Password:");
		lblProducto_2_5_2_1_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5_2_1_1.setBounds(64, 289, 86, 28);
		EmailConfigPanel.add(lblProducto_2_5_2_1_1);
		
		JButton btnSaveEmail = new JButton("Guardar Email");
		btnSaveEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveEmailProcess.createNewEmail();
			}
		});
		btnSaveEmail.setBounds(169, 355, 153, 34);
		EmailConfigPanel.add(btnSaveEmail);
		
		JScrollPane paneEmail = new JScrollPane();
		paneEmail.setBounds(498, 225, 498, 168);
		EmailConfigPanel.add(paneEmail);
		
		tblEmail = new JTable();
		paneEmail.setViewportView(tblEmail);
		
		JButton btnUpdateEmail = new JButton("Actualizar");
		btnUpdateEmail.setBounds(509, 420, 117, 25);
		EmailConfigPanel.add(btnUpdateEmail);
		
		JLabel lblConsultaEmail = new JLabel("Consulta Email");
		lblConsultaEmail.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		lblConsultaEmail.setBounds(647, 173, 153, 28);
		EmailConfigPanel.add(lblConsultaEmail);
		
		pwdEmailNew = new JPasswordField();
		pwdEmailNew.setBounds(146, 289, 211, 34);
		EmailConfigPanel.add(pwdEmailNew);
		
		JButton btnDeleteEmail = new JButton("Borrar");
		btnDeleteEmail.setBounds(879, 420, 117, 25);
		EmailConfigPanel.add(btnDeleteEmail);
		
		JPanel adminConfigPanel = new JPanel();
		adminConfigPanel.setBackground(SystemColor.window);
		tabbedAdminOptions.addTab("Configuración Administracion", null, adminConfigPanel, null);
		adminConfigPanel.setLayout(null);
		
		JLabel lblNewLabel_1_1_3_1 = new JLabel("@SmartSaleBox.");
		lblNewLabel_1_1_3_1.setFont(new Font("Lucida Bright", Font.BOLD, 24));
		lblNewLabel_1_1_3_1.setBounds(835, 12, 201, 28);
		adminConfigPanel.add(lblNewLabel_1_1_3_1);
		
		JLabel lblAltaAdministrador = new JLabel("Alta Administrador");
		lblAltaAdministrador.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		lblAltaAdministrador.setBounds(203, 122, 192, 28);
		adminConfigPanel.add(lblAltaAdministrador);
		
		JLabel lblConsultaAdministrador = new JLabel("Consulta Administrador");
		lblConsultaAdministrador.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		lblConsultaAdministrador.setBounds(622, 175, 248, 28);
		adminConfigPanel.add(lblConsultaAdministrador);
		
		JLabel lblProducto_2_5_2_1_2 = new JLabel("Nombre:");
		lblProducto_2_5_2_1_2.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5_2_1_2.setBounds(125, 227, 63, 28);
		adminConfigPanel.add(lblProducto_2_5_2_1_2);
		
		JLabel lblProducto_2_5_2_1_1_1 = new JLabel("Password:");
		lblProducto_2_5_2_1_1_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5_2_1_1_1.setBounds(112, 355, 86, 28);
		adminConfigPanel.add(lblProducto_2_5_2_1_1_1);
		
		txtAdminName = new JTextField();
		txtAdminName.setColumns(10);
		txtAdminName.setBounds(191, 226, 216, 34);
		adminConfigPanel.add(txtAdminName);
		
		JButton btnSaveAdmin = new JButton("Guardar");
		btnSaveAdmin.setBounds(204, 470, 153, 34);
		adminConfigPanel.add(btnSaveAdmin);
		
		JLabel lblProducto_2_5_2_1_2_1 = new JLabel("Puesto:");
		lblProducto_2_5_2_1_2_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5_2_1_2_1.setBounds(135, 291, 63, 28);
		adminConfigPanel.add(lblProducto_2_5_2_1_2_1);
		
		pwdAdmin1 = new JPasswordField();
		pwdAdmin1.setBounds(191, 354, 192, 34);
		adminConfigPanel.add(pwdAdmin1);
		
		JLabel lblProducto_2_5_2_1_1_1_1 = new JLabel("Confirma Password:");
		lblProducto_2_5_2_1_1_1_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5_2_1_1_1_1.setBounds(40, 410, 148, 28);
		adminConfigPanel.add(lblProducto_2_5_2_1_1_1_1);
		
		pwdAdmin2 = new JPasswordField();
		pwdAdmin2.setBounds(191, 409, 192, 34);
		adminConfigPanel.add(pwdAdmin2);
		
		cmbAdminRole = new JComboBox();
		cmbAdminRole.setBounds(191, 289, 216, 34);
		adminConfigPanel.add(cmbAdminRole);
		
		JScrollPane paneAdmin = new JScrollPane();
		paneAdmin.setBounds(466, 227, 553, 251);
		adminConfigPanel.add(paneAdmin);
		
		tblAdmin = new JTable();
		paneAdmin.setViewportView(tblAdmin);
		
		JButton btnUpdateAdmin = new JButton("Actualizar");
		btnUpdateAdmin.setBounds(476, 490, 153, 34);
		adminConfigPanel.add(btnUpdateAdmin);
		
		JButton btnDeleteAdmin = new JButton("Borrar");
		btnDeleteAdmin.setBounds(866, 490, 123, 34);
		adminConfigPanel.add(btnDeleteAdmin);
		
		JButton btnGetCashQuantity = new JButton("Consulta Cajón");
		btnGetCashQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Negocio: #"+ticketTitle+"\n Cajón: $"+cash+" \n No. Venta: #"+noSale);
			}
		});
		btnGetCashQuantity.setBounds(53, 561, 150, 36);
		tabbedSale.add(btnGetCashQuantity);
		
		JButton btnDeleteProduct = new JButton("Borrar Producto");
		btnDeleteProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteSaleProcess.removeSelectedSaleProcess();
			}
		});
		btnDeleteProduct.setBounds(529, 380, 150, 28);
		tabbedSale.add(btnDeleteProduct);
		
		JButton btnEnableCardPayment = new JButton("Tarjeta");
		btnEnableCardPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCardPayment.setEnabled(true);
			}
		});
		btnEnableCardPayment.setBounds(616, 476, 85, 25);
		tabbedSale.add(btnEnableCardPayment);
		
	final String cartSaleColumns[] = { "idProd", "Producto", "Precio", "Stock" };
	tableModelCartSale = new DefaultTableModel(cartSaleColumns, 0);
	tblCartSale = new JTable(tableModelCartSale);
	tblCartSale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SaveSaleProcess.addProductToSaleList(e);
		}
	});
	tblCartSale.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	tblCartSale.getColumnModel().getColumn(0).setPreferredWidth(50);
	tblCartSale.getColumnModel().getColumn(1).setPreferredWidth(230);
	tblCartSale.getColumnModel().getColumn(2).setPreferredWidth(100);
	tblCartSale.getColumnModel().getColumn(3).setPreferredWidth(100);
	scrollCartSale.setViewportView(tblCartSale);
		
	final String saleColumns[] = {"noSale","Description","Precio","Unidades","total","idProd","Tipo","idSale"};
	tableModelSale = new DefaultTableModel(saleColumns, 0);
	tblSale = new JTable(tableModelSale);
	tblSale.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	tblSale.getColumnModel().getColumn(0).setPreferredWidth(50);
	tblSale.getColumnModel().getColumn(1).setPreferredWidth(180);
	tblSale.getColumnModel().getColumn(2).setPreferredWidth(70);
	tblSale.getColumnModel().getColumn(3).setPreferredWidth(70);
	tblSale.getColumnModel().getColumn(4).setPreferredWidth(70);
	tblSale.getColumnModel().getColumn(5).setPreferredWidth(50);
	tblSale.getColumnModel().getColumn(6).setPreferredWidth(50);
	tblSale.getColumnModel().getColumn(7).setPreferredWidth(50);
	scrollSale.setViewportView(tblSale);
		
	final String inflowsColumns[] = { "Id", "Concepto", "Descripción", "Cantidad", "Tipo pago", "Atendió",
				"Fecha" };
	tableModelInflows = new DefaultTableModel(inflowsColumns, 0);
	tblInflows = new JTable(tableModelInflows);
	tblInflows.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	tblInflows.getColumnModel().getColumn(0).setPreferredWidth(50);
	tblInflows.getColumnModel().getColumn(1).setPreferredWidth(180);
	tblInflows.getColumnModel().getColumn(2).setPreferredWidth(70);
	tblInflows.getColumnModel().getColumn(3).setPreferredWidth(70);
	tblInflows.getColumnModel().getColumn(4).setPreferredWidth(70);
	tblInflows.getColumnModel().getColumn(5).setPreferredWidth(50);
	tblInflows.getColumnModel().getColumn(6).setPreferredWidth(50);
	scrollInflows.setViewportView(tblInflows);
		

	final String outflowsColumns[] =  { "Id", "Concepto", "Descripción", "Cantidad", "Tipo pago","Atendió","Fecha" };
	tableModelOutflows = new DefaultTableModel(outflowsColumns, 0);
	tblOutflows = new JTable(tableModelOutflows);
	tblOutflows.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	tblOutflows.getColumnModel().getColumn(0).setPreferredWidth(50);
	tblOutflows.getColumnModel().getColumn(1).setPreferredWidth(180);
	tblOutflows.getColumnModel().getColumn(2).setPreferredWidth(70);
	tblOutflows.getColumnModel().getColumn(3).setPreferredWidth(70);
	tblOutflows.getColumnModel().getColumn(4).setPreferredWidth(70);
	tblOutflows.getColumnModel().getColumn(5).setPreferredWidth(50);
	tblOutflows.getColumnModel().getColumn(6).setPreferredWidth(50);
	scrollOutflows.setViewportView(tblOutflows);
	
	final String saleHistoryColumns[] = {"noSale","Description","Precio","Unidades","total","idProd","Tipo","idSale"};
	tableModelSaleHistory = new DefaultTableModel(saleHistoryColumns, 0);
	tblSaleHistory = new JTable(tableModelSaleHistory);
	tblSaleHistory.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	tblSaleHistory.getColumnModel().getColumn(0).setPreferredWidth(50);
	tblSaleHistory.getColumnModel().getColumn(1).setPreferredWidth(180);
	tblSaleHistory.getColumnModel().getColumn(2).setPreferredWidth(70);
	tblSaleHistory.getColumnModel().getColumn(3).setPreferredWidth(70);
	tblSaleHistory.getColumnModel().getColumn(4).setPreferredWidth(70);
	tblSaleHistory.getColumnModel().getColumn(5).setPreferredWidth(50);
	tblSaleHistory.getColumnModel().getColumn(6).setPreferredWidth(50);
	scrollSaleHistory.setViewportView(tblSaleHistory);
		
	}
}
