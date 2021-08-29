package com.java.smartsaleboxfrontend.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.java.smartsalebox.client.EmailConfigClient;
import com.java.smartsalebox.client.ReportClient;
import com.java.smartsalebox.mail.SendClosureMail;
import com.java.smartsalebox.models.Closure;
import com.java.smartsalebox.models.Sales;
import com.java.smartsaleboxfrontend.business.delete.DeleteAdministratorProcess;
import com.java.smartsaleboxfrontend.business.delete.DeleteEmailConfigProcess;
import com.java.smartsaleboxfrontend.business.delete.DeleteProductProcess;
import com.java.smartsaleboxfrontend.business.delete.DeleteSaleProcess;
import com.java.smartsaleboxfrontend.business.delete.DeleteSystemPathsProcess;
import com.java.smartsaleboxfrontend.business.read.ReadAdminInfo;
import com.java.smartsaleboxfrontend.business.read.ReadBulkSaleInfo;
import com.java.smartsaleboxfrontend.business.read.ReadCartSaleInfo;
import com.java.smartsaleboxfrontend.business.read.ReadClosureCalculation;
import com.java.smartsaleboxfrontend.business.read.ReadEmailInfo;
import com.java.smartsaleboxfrontend.business.read.ReadInflowProcess;
import com.java.smartsaleboxfrontend.business.read.ReadOutflowProcess;
import com.java.smartsaleboxfrontend.business.read.ReadProductsInfo;
import com.java.smartsaleboxfrontend.business.read.ReadSaleInfo;
import com.java.smartsaleboxfrontend.business.read.ReadSystemPathsInfo;
import com.java.smartsaleboxfrontend.business.save.LoginInitializer;
import com.java.smartsaleboxfrontend.business.save.SaveAdminProcess;
import com.java.smartsaleboxfrontend.business.save.SaveBulkProductProcess;
import com.java.smartsaleboxfrontend.business.save.SaveClosureProcess;
import com.java.smartsaleboxfrontend.business.save.SaveEmailProcess;
import com.java.smartsaleboxfrontend.business.save.SaveInflowProcess;
import com.java.smartsaleboxfrontend.business.save.SaveOutflowProcess;
import com.java.smartsaleboxfrontend.business.save.SaveProductProcess;
import com.java.smartsaleboxfrontend.business.save.SaveSaleProcess;
import com.java.smartsaleboxfrontend.business.save.SaveSystemPathsProcess;
import com.java.smartsaleboxfrontend.business.update.UpdateAdminProcess;
import com.java.smartsaleboxfrontend.business.update.UpdateBulkStockProcess;
import com.java.smartsaleboxfrontend.business.update.UpdateCashProcess;
import com.java.smartsaleboxfrontend.business.update.UpdateEmailConfigProcess;
import com.java.smartsaleboxfrontend.business.update.UpdateProductEarningsProcess;
import com.java.smartsaleboxfrontend.business.update.UpdateProductProcess;
import com.java.smartsaleboxfrontend.business.update.UpdateProductStockProcess;
import com.java.smartsaleboxfrontend.business.update.UpdateSystemPathsProcess;
import com.java.smartsaleboxfrontend.utils.SmartSaleBoxClearFields;
import com.java.smartsaleboxfrontend.utils.SmartSaleBoxOperations;

import javax.swing.JTabbedPane;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

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
	public static JTable tblPaths;
	
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
	public static DefaultTableModel tableModelPaths;
	
	public static JScrollPane scrollCartSale;
	public static JScrollPane scrollSale;
	public static JScrollPane scrollSaleHistory;
	public static JScrollPane scrollInflows;
	public static JScrollPane scrollOutflows;
	public static JScrollPane scrollGetProduct;
	public static JScrollPane scrollNewBulk;
	public static JScrollPane scrollAdmin;
	public static JScrollPane scrollEmail;
	public static JScrollPane scrollPaths;
	
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
	
	public static JTextField txtGetProductNameSearch;
	public static JTextField txtNewProductName;
	public static JTextField txtNewCostPrice;
	public static JTextField txtNewSalePrice;
	public static JTextField txtNewEarning;
	public static JTextField txtNewStock;
	public static JTextField txtNewBarCode;
	
	public static JTextField txtBulkProdSearch;
	public static JTextField txtNewBulkProductName;
	public static JTextField txtNewBulkCostPrice;
	public static JTextField txtNewBulkKiloPrice;
	public static JTextField txtNewBulkStock;
	public static JTextField txtNewBulkBarCodeProd;
	public static JTextField txtNewBulkKiloEarning;
	public static JTextField txtNewBulkEarning;
	
	public static JTextField txtInitialCashClosure;
	public static JTextField txtTotalCashClosure;
	public static JTextField txtTotalCardClosure;
	public static JTextField txtTotalCashBoxClosure;
	public static JTextField txtTotalInflowsClosure;
	public static JTextField txtTotalCashOutClosure;
	public static JTextField txtTotalCardOutClosure;
	public static JTextField txtTotalOutflowsClosure;
	public static JTextField txtTotalProductClosure;
	public static JTextField txtEmailNew;
	
	public static JTextField txtAdminName;
	public static JTextField txtAdminLast;
	public static JTextField txtAdminPhone;
	public static JPasswordField pwdAdmin1;
	public static JPasswordField pwdAdmin2;
	public static JTextField txtInOutConcept;
	public static JTextField txtInOutQuantity;
	public static JPasswordField pwdEmailNew;
	
	public static JComboBox<String> cmbAdminRole;
	public static JComboBox<String> cmbOperationType;
	public static JComboBox<String> cmbPaymentTypeInOut;
	
	public static JTextField txtSystemPathsClosure;
	public static JTextField txtSystemPathsInflows;
	public static JTextField txtSystemPathsOutflows;
	public static JTextField txtSystemPathsEarnings;
	public static JTextField txtSystemPathsSales;
	public static JTextField txtSystemPathsProducts;
	public static JTextField txtTotalEarningsClosure;

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
		btnHistorySearchSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (SmartSaleBoxOperations.validateGetSaleHistoryByNoSale()) {
					ReadSaleInfo.getSaleHistoryByNoSale();
				} else {
					JOptionPane.showMessageDialog(null, "Ingrese número de venta por favor");
				}
			}
		});
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
		
		scrollGetProduct = new JScrollPane();
		scrollGetProduct.setBounds(443, 133, 565, 370);
		tabbedProducts_1.add(scrollGetProduct);
		
		tblNewProduct = new JTable();
		scrollGetProduct.setViewportView(tblNewProduct);
		
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
		btnUpdateProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateProductProcess.updateSelectedProduct();
			}
		});
		btnUpdateProd.setBounds(465, 515, 117, 34);
		tabbedProducts_1.add(btnUpdateProd);
		
		JButton btnDeleteProd = new JButton("Borrar");
		btnDeleteProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteProductProcess.removeSelectedProduct();
			}
		});
		btnDeleteProd.setBounds(891, 515, 117, 34);
		tabbedProducts_1.add(btnDeleteProd);
		
		JButton btnShowAllprods = new JButton("Mostrar Todos");
		btnShowAllprods.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReadProductsInfo.fillProductTable();
			}
		});
		btnShowAllprods.setBounds(672, 543, 137, 34);
		tabbedProducts_1.add(btnShowAllprods);
		
		txtGetProductNameSearch = new JTextField();
		txtGetProductNameSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (SmartSaleBoxOperations.validateGetProdNameSearch()) {
						ReadProductsInfo.fillProductTableByName(txtGetProductNameSearch.getText());
					} else {
						JOptionPane.showMessageDialog(null, "Ingrese Producto por favor");
					}
				}
			}
		});
		txtGetProductNameSearch.setColumns(10);
		txtGetProductNameSearch.setBounds(582, 87, 270, 34);
		tabbedProducts_1.add(txtGetProductNameSearch);
		
		JLabel lblProducto_2_6_1 = new JLabel("Producto:");
		lblProducto_2_6_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_6_1.setBounds(503, 87, 85, 28);
		tabbedProducts_1.add(lblProducto_2_6_1);
		
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
		lblConsultaProductoGranel.setBounds(628, 52, 263, 28);
		tabbedProducts_2.add(lblConsultaProductoGranel);
		
		scrollNewBulk = new JScrollPane();
		scrollNewBulk.setBounds(443, 133, 565, 380);
		tabbedProducts_2.add(scrollNewBulk);
		
		tblNewBulkProducts = new JTable();
		scrollNewBulk.setViewportView(tblNewBulkProducts);
		
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
		
		JButton btnShowAllBulkProd = new JButton("Mostrar Todos");
		btnShowAllBulkProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReadBulkSaleInfo.fillProductBulkTable();
			}
		});
		btnShowAllBulkProd.setBounds(663, 543, 143, 34);
		tabbedProducts_2.add(btnShowAllBulkProd);
		
		txtBulkProdSearch = new JTextField();
		txtBulkProdSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (SmartSaleBoxOperations.validateGetBulkProdNameSearch()) {
						ReadBulkSaleInfo.fillProductBulkTableByName(txtBulkProdSearch.getText());
					} else {
						JOptionPane.showMessageDialog(null, "Ingrese Producto por favor");
					}
				}
			}
		});
		txtBulkProdSearch.setColumns(10);
		txtBulkProdSearch.setBounds(605, 87, 270, 34);
		tabbedProducts_2.add(txtBulkProdSearch);
		
		JLabel lblProducto_2_7_1 = new JLabel("Producto:");
		lblProducto_2_7_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_7_1.setBounds(525, 87, 85, 28);
		tabbedProducts_2.add(lblProducto_2_7_1);
		
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
		
		txtInitialCashClosure = new JTextField();
		txtInitialCashClosure.setEnabled(false);
		txtInitialCashClosure.setFont(new Font("Dialog", Font.BOLD, 14));
		txtInitialCashClosure.setColumns(10);
		txtInitialCashClosure.setBounds(233, 139, 114, 34);
		closurePanel.add(txtInitialCashClosure);
		
		txtTotalCashClosure = new JTextField();
		txtTotalCashClosure.setEnabled(false);
		txtTotalCashClosure.setFont(new Font("Dialog", Font.BOLD, 14));
		txtTotalCashClosure.setColumns(10);
		txtTotalCashClosure.setBounds(233, 202, 114, 34);
		closurePanel.add(txtTotalCashClosure);
		
		txtTotalCardClosure = new JTextField();
		txtTotalCardClosure.setEnabled(false);
		txtTotalCardClosure.setFont(new Font("Dialog", Font.BOLD, 14));
		txtTotalCardClosure.setColumns(10);
		txtTotalCardClosure.setBounds(233, 271, 114, 34);
		closurePanel.add(txtTotalCardClosure);
		
		txtTotalCashBoxClosure = new JTextField();
		txtTotalCashBoxClosure.setEnabled(false);
		txtTotalCashBoxClosure.setFont(new Font("Dialog", Font.BOLD, 14));
		txtTotalCashBoxClosure.setColumns(10);
		txtTotalCashBoxClosure.setBounds(706, 139, 114, 34);
		closurePanel.add(txtTotalCashBoxClosure);
		
		txtTotalInflowsClosure = new JTextField();
		txtTotalInflowsClosure.setEnabled(false);
		txtTotalInflowsClosure.setFont(new Font("Dialog", Font.BOLD, 14));
		txtTotalInflowsClosure.setColumns(10);
		txtTotalInflowsClosure.setBounds(233, 348, 114, 34);
		closurePanel.add(txtTotalInflowsClosure);
		
		txtTotalCashOutClosure = new JTextField();
		txtTotalCashOutClosure.setEnabled(false);
		txtTotalCashOutClosure.setFont(new Font("Dialog", Font.BOLD, 14));
		txtTotalCashOutClosure.setColumns(10);
		txtTotalCashOutClosure.setBounds(706, 207, 114, 34);
		closurePanel.add(txtTotalCashOutClosure);
		
		txtTotalCardOutClosure = new JTextField();
		txtTotalCardOutClosure.setEnabled(false);
		txtTotalCardOutClosure.setFont(new Font("Dialog", Font.BOLD, 14));
		txtTotalCardOutClosure.setColumns(10);
		txtTotalCardOutClosure.setBounds(706, 276, 114, 34);
		closurePanel.add(txtTotalCardOutClosure);
		
		JLabel lblSalidas_1 = new JLabel("Salidas");
		lblSalidas_1.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		lblSalidas_1.setBounds(702, 62, 93, 28);
		closurePanel.add(lblSalidas_1);
		
		txtTotalOutflowsClosure = new JTextField();
		txtTotalOutflowsClosure.setEnabled(false);
		txtTotalOutflowsClosure.setFont(new Font("Dialog", Font.BOLD, 14));
		txtTotalOutflowsClosure.setColumns(10);
		txtTotalOutflowsClosure.setBounds(706, 348, 114, 34);
		closurePanel.add(txtTotalOutflowsClosure);
		
		JButton btnNewButton = new JButton("Generar Corte");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(SmartSaleBoxOperations.validateClosure()) {
				Closure newClosure = SaveClosureProcess.createNewClosure();
				if(newClosure.getIdClosure()!=null) {
					if(ReportClient.generateClosureReports()) {
						JOptionPane.showMessageDialog(null,"Reportes PDFs Generados");
						try {
							if(EmailConfigClient.sendEmailReports(newClosure)) {
								JOptionPane.showMessageDialog(null,"Email enviado a Administrador");
							}else {
								JOptionPane.showMessageDialog(null,"Email no pudo ser enviado, favor de enviar manualmente a Administrador");
							}
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,"Corte Generado sin envio de Email por error conexion a Internet");
						} 
					}
				}
			}else {
				JOptionPane.showMessageDialog(null,"Calcule Primero el Corte");
			}
		}
		});
		btnNewButton.setBounds(517, 533, 153, 44);
		closurePanel.add(btnNewButton);
		
		JLabel lblProducto_2_5_6_2 = new JLabel("Total Venta Producto: $");
		lblProducto_2_5_6_2.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5_6_2.setBounds(58, 411, 180, 28);
		closurePanel.add(lblProducto_2_5_6_2);
		
		txtTotalProductClosure = new JTextField();
		txtTotalProductClosure.setEnabled(false);
		txtTotalProductClosure.setFont(new Font("Dialog", Font.BOLD, 14));
		txtTotalProductClosure.setColumns(10);
		txtTotalProductClosure.setBounds(233, 410, 114, 34);
		closurePanel.add(txtTotalProductClosure);
		
		JButton btnCalcularCorte = new JButton("Calcular Corte");
		btnCalcularCorte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReadClosureCalculation.setClosureCalculationInfo();
			}
		});
		btnCalcularCorte.setBounds(324, 533, 153, 44);
		closurePanel.add(btnCalcularCorte);
		
		txtTotalEarningsClosure = new JTextField();
		txtTotalEarningsClosure.setEnabled(false);
		txtTotalEarningsClosure.setFont(new Font("Dialog", Font.BOLD, 14));
		txtTotalEarningsClosure.setColumns(10);
		txtTotalEarningsClosure.setBounds(496, 465, 114, 34);
		closurePanel.add(txtTotalEarningsClosure);
		
		JLabel lblProducto_2_5_6_2_1 = new JLabel("Total Ganancias: $");
		lblProducto_2_5_6_2_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5_6_2_1.setBounds(352, 466, 142, 28);
		closurePanel.add(lblProducto_2_5_6_2_1);
		
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
				if(SmartSaleBoxOperations.validateEmailConfig()) {
					SaveEmailProcess.createNewEmail();
				}else {
					JOptionPane.showMessageDialog(null, "Favor de llenar los campos");
				}
			}
		});
		btnSaveEmail.setBounds(169, 355, 153, 34);
		EmailConfigPanel.add(btnSaveEmail);
		
		scrollEmail = new JScrollPane();
		scrollEmail.setBounds(498, 225, 498, 168);
		EmailConfigPanel.add(scrollEmail);
		
		tblEmail = new JTable();
		scrollEmail.setViewportView(tblEmail);
		
		JButton btnUpdateEmail = new JButton("Actualizar");
		btnUpdateEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateEmailConfigProcess.updateEmailConfig();
			}
		});
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
		btnDeleteEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteEmailConfigProcess.removeSelectedEmail();
			}
		});
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
		lblProducto_2_5_2_1_2.setBounds(124, 197, 63, 28);
		adminConfigPanel.add(lblProducto_2_5_2_1_2);
		
		JLabel lblProducto_2_5_2_1_1_1 = new JLabel("Password:");
		lblProducto_2_5_2_1_1_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5_2_1_1_1.setBounds(124, 415, 86, 28);
		adminConfigPanel.add(lblProducto_2_5_2_1_1_1);
		
		txtAdminName = new JTextField();
		txtAdminName.setColumns(10);
		txtAdminName.setBounds(187, 196, 216, 34);
		adminConfigPanel.add(txtAdminName);
		
		JButton btnSaveAdmin = new JButton("Guardar");
		btnSaveAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(SmartSaleBoxOperations.validateAdminFields()) {
					SaveAdminProcess.createNewAdmin();
				}else {
					JOptionPane.showMessageDialog(null, "Favor de llenar los campos");
				}
			}
		});
		btnSaveAdmin.setBounds(199, 526, 153, 34);
		adminConfigPanel.add(btnSaveAdmin);
		
		JLabel lblProducto_2_5_2_1_2_1 = new JLabel("Puesto:");
		lblProducto_2_5_2_1_2_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5_2_1_2_1.setBounds(145, 359, 63, 28);
		adminConfigPanel.add(lblProducto_2_5_2_1_2_1);
		
		pwdAdmin1 = new JPasswordField();
		pwdAdmin1.setBounds(203, 414, 192, 34);
		adminConfigPanel.add(pwdAdmin1);
		
		JLabel lblProducto_2_5_2_1_1_1_1 = new JLabel("Confirma Password:");
		lblProducto_2_5_2_1_1_1_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5_2_1_1_1_1.setBounds(52, 470, 148, 28);
		adminConfigPanel.add(lblProducto_2_5_2_1_1_1_1);
		
		pwdAdmin2 = new JPasswordField();
		pwdAdmin2.setBounds(203, 469, 192, 34);
		adminConfigPanel.add(pwdAdmin2);
		
		cmbAdminRole = new JComboBox();
		cmbAdminRole.setModel(new DefaultComboBoxModel(new String[] {"Administrador"}));
		cmbAdminRole.setBounds(201, 357, 216, 34);
		adminConfigPanel.add(cmbAdminRole);
		
		scrollAdmin = new JScrollPane();
		scrollAdmin.setBounds(466, 227, 553, 251);
		adminConfigPanel.add(scrollAdmin);
		
		tblAdmin = new JTable();
		scrollAdmin.setViewportView(tblAdmin);
		
		JButton btnUpdateAdmin = new JButton("Actualizar");
		btnUpdateAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateAdminProcess.updateEmployee();
			}
		});
		btnUpdateAdmin.setBounds(476, 490, 153, 34);
		adminConfigPanel.add(btnUpdateAdmin);
		
		JButton btnDeleteAdmin = new JButton("Borrar");
		btnDeleteAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteAdministratorProcess.removeSelectedAdmin();
			}
		});
		btnDeleteAdmin.setBounds(896, 490, 123, 34);
		adminConfigPanel.add(btnDeleteAdmin);
		
		JLabel lblProducto_2_5_2_1_2_2 = new JLabel("Apellido:");
		lblProducto_2_5_2_1_2_2.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5_2_1_2_2.setBounds(112, 256, 77, 28);
		adminConfigPanel.add(lblProducto_2_5_2_1_2_2);
		
		JLabel lblProducto_2_5_2_1_2_2_1 = new JLabel("Telefono:");
		lblProducto_2_5_2_1_2_2_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5_2_1_2_2_1.setBounds(111, 307, 76, 28);
		adminConfigPanel.add(lblProducto_2_5_2_1_2_2_1);
		
		txtAdminLast = new JTextField();
		txtAdminLast.setColumns(10);
		txtAdminLast.setBounds(187, 255, 216, 34);
		adminConfigPanel.add(txtAdminLast);
		
		txtAdminPhone = new JTextField();
		txtAdminPhone.setColumns(10);
		txtAdminPhone.setBounds(187, 301, 216, 34);
		adminConfigPanel.add(txtAdminPhone);
		
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
		
		JButton btnGetAllAdmin = new JButton("Mostrar Todos");
		btnGetAllAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReadAdminInfo.getAllAdminTable();
			}
		});
		btnGetAllAdmin.setBounds(676, 490, 153, 34);
		adminConfigPanel.add(btnGetAllAdmin);
		
		JButton btnShowAllEmail = new JButton("Mostrar Todos");
		btnShowAllEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReadEmailInfo.getAllEmailTable();
			}
		});
		btnShowAllEmail.setBounds(681, 420, 137, 25);
		EmailConfigPanel.add(btnShowAllEmail);
		
		JPanel SystemPathsConfigPanel = new JPanel();
		SystemPathsConfigPanel.setLayout(null);
		SystemPathsConfigPanel.setBackground(SystemColor.window);
		tabbedAdminOptions.addTab("Configuración Directorios", null, SystemPathsConfigPanel, null);
		
		JLabel lblConfiguracinDirectorios = new JLabel("Configuración Directorios");
		lblConfiguracinDirectorios.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		lblConfiguracinDirectorios.setBounds(135, 36, 253, 28);
		SystemPathsConfigPanel.add(lblConfiguracinDirectorios);
		
		JLabel lblNewLabel_1_1_3_2 = new JLabel("@SmartSaleBox.");
		lblNewLabel_1_1_3_2.setFont(new Font("Lucida Bright", Font.BOLD, 24));
		lblNewLabel_1_1_3_2.setBounds(835, 12, 201, 28);
		SystemPathsConfigPanel.add(lblNewLabel_1_1_3_2);
		
		JLabel lblProducto_2_5_2_1_3 = new JLabel("Cierre:");
		lblProducto_2_5_2_1_3.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5_2_1_3.setBounds(61, 205, 62, 28);
		SystemPathsConfigPanel.add(lblProducto_2_5_2_1_3);
		
		JButton btnGuardarDirectorio = new JButton("Guardar Directorio");
		btnGuardarDirectorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(SmartSaleBoxOperations.validateSystemPaths()) {
					SaveSystemPathsProcess.createPaths();
				}else {
					JOptionPane.showMessageDialog(null, "Favor de llenar los campos");
				}
			}
		});
		btnGuardarDirectorio.setBounds(148, 495, 192, 34);
		SystemPathsConfigPanel.add(btnGuardarDirectorio);
		
		scrollPaths = new JScrollPane();
		scrollPaths.setBounds(450, 194, 546, 199);
		SystemPathsConfigPanel.add(scrollPaths);
		
		tblPaths = new JTable();
		scrollPaths.setViewportView(tblPaths);
		
		JButton btnUpdateEmail_1 = new JButton("Actualizar");
		btnUpdateEmail_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateSystemPathsProcess.updateSystemPaths();
			}
		});
		btnUpdateEmail_1.setBounds(472, 405, 117, 25);
		SystemPathsConfigPanel.add(btnUpdateEmail_1);
		
		JLabel lblConsultaDirectorios = new JLabel("Consulta Directorios");
		lblConsultaDirectorios.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		lblConsultaDirectorios.setBounds(619, 132, 211, 28);
		SystemPathsConfigPanel.add(lblConsultaDirectorios);
		
		JButton btnDeleteEmail_1 = new JButton("Borrar");
		btnDeleteEmail_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteSystemPathsProcess.removeSelectedPath();
			}
		});
		btnDeleteEmail_1.setBounds(858, 405, 117, 25);
		SystemPathsConfigPanel.add(btnDeleteEmail_1);
		
		JButton btnShowAllEmail_1 = new JButton("Mostrar Todos");
		btnShowAllEmail_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReadSystemPathsInfo.getAllSystemPathsTable();
			}
		});
		btnShowAllEmail_1.setBounds(662, 418, 137, 25);
		SystemPathsConfigPanel.add(btnShowAllEmail_1);
		
		JLabel lblSeRecomiendaCrear = new JLabel("*** Se recomienda crear una carpeta  C:\\SmartSaleBox");
		lblSeRecomiendaCrear.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblSeRecomiendaCrear.setBounds(47, 95, 364, 28);
		SystemPathsConfigPanel.add(lblSeRecomiendaCrear);
		
		txtSystemPathsClosure = new JTextField();
		txtSystemPathsClosure.setColumns(10);
		txtSystemPathsClosure.setBounds(113, 204, 298, 34);
		SystemPathsConfigPanel.add(txtSystemPathsClosure);
		
		txtSystemPathsInflows = new JTextField();
		txtSystemPathsInflows.setColumns(10);
		txtSystemPathsInflows.setBounds(113, 250, 298, 34);
		SystemPathsConfigPanel.add(txtSystemPathsInflows);
		
		txtSystemPathsOutflows = new JTextField();
		txtSystemPathsOutflows.setColumns(10);
		txtSystemPathsOutflows.setBounds(113, 293, 298, 34);
		SystemPathsConfigPanel.add(txtSystemPathsOutflows);
		
		txtSystemPathsEarnings = new JTextField();
		txtSystemPathsEarnings.setColumns(10);
		txtSystemPathsEarnings.setBounds(113, 336, 298, 34);
		SystemPathsConfigPanel.add(txtSystemPathsEarnings);
		
		txtSystemPathsSales = new JTextField();
		txtSystemPathsSales.setColumns(10);
		txtSystemPathsSales.setBounds(113, 431, 298, 34);
		SystemPathsConfigPanel.add(txtSystemPathsSales);
		
		JLabel lblProducto_2_5_2_1_3_1 = new JLabel("Entradas:");
		lblProducto_2_5_2_1_3_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5_2_1_3_1.setBounds(47, 245, 66, 28);
		SystemPathsConfigPanel.add(lblProducto_2_5_2_1_3_1);
		
		JLabel lblProducto_2_5_2_1_3_2 = new JLabel("Salidas:");
		lblProducto_2_5_2_1_3_2.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5_2_1_3_2.setBounds(51, 293, 62, 28);
		SystemPathsConfigPanel.add(lblProducto_2_5_2_1_3_2);
		
		JLabel lblProducto_2_5_2_1_3_3 = new JLabel("Ganancias:");
		lblProducto_2_5_2_1_3_3.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5_2_1_3_3.setBounds(29, 337, 77, 28);
		SystemPathsConfigPanel.add(lblProducto_2_5_2_1_3_3);
		
		JLabel lblProducto_2_5_2_1_3_4 = new JLabel("Products:");
		lblProducto_2_5_2_1_3_4.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5_2_1_3_4.setBounds(39, 382, 74, 28);
		SystemPathsConfigPanel.add(lblProducto_2_5_2_1_3_4);
		
		JLabel lblProducto_2_5_2_1_3_4_1 = new JLabel("Ventas:");
		lblProducto_2_5_2_1_3_4_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5_2_1_3_4_1.setBounds(51, 437, 62, 28);
		SystemPathsConfigPanel.add(lblProducto_2_5_2_1_3_4_1);
		
		txtSystemPathsProducts = new JTextField();
		txtSystemPathsProducts.setColumns(10);
		txtSystemPathsProducts.setBounds(113, 382, 298, 34);
		SystemPathsConfigPanel.add(txtSystemPathsProducts);
		
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
	
	
	final String productColumns[] = {"idProduct","Producto","PrecioCosto","PrecioVenta","Ganancia","Stock","CódigoBarras"};
	tableModelNewProduct = new DefaultTableModel(productColumns, 0);
	tblNewProduct = new JTable(tableModelNewProduct);
	tblNewProduct.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	tblNewProduct.getColumnModel().getColumn(0).setPreferredWidth(50);
	tblNewProduct.getColumnModel().getColumn(1).setPreferredWidth(150);
	tblNewProduct.getColumnModel().getColumn(2).setPreferredWidth(80);
	tblNewProduct.getColumnModel().getColumn(3).setPreferredWidth(80);
	tblNewProduct.getColumnModel().getColumn(4).setPreferredWidth(80);
	tblNewProduct.getColumnModel().getColumn(5).setPreferredWidth(80);
	tblNewProduct.getColumnModel().getColumn(6).setPreferredWidth(80);
	scrollSaleHistory.setViewportView(tblNewProduct);
	
	final String bulkProductColumns[] = {"idProduct","Producto","PrecioCosto","PrecioKilo","Stock grs.","GananciaxKilo","GananciaGranel","CódigoBarras"};
	tableModelNewBulkProducts = new DefaultTableModel(bulkProductColumns, 0);
	tblNewBulkProducts = new JTable(tableModelNewBulkProducts);
	tblNewBulkProducts.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	tblNewBulkProducts.getColumnModel().getColumn(0).setPreferredWidth(50);
	tblNewBulkProducts.getColumnModel().getColumn(1).setPreferredWidth(130);
	tblNewBulkProducts.getColumnModel().getColumn(2).setPreferredWidth(80);
	tblNewBulkProducts.getColumnModel().getColumn(3).setPreferredWidth(80);
	tblNewBulkProducts.getColumnModel().getColumn(4).setPreferredWidth(80);
	tblNewBulkProducts.getColumnModel().getColumn(5).setPreferredWidth(80);
	tblNewBulkProducts.getColumnModel().getColumn(6).setPreferredWidth(80);
	tblNewBulkProducts.getColumnModel().getColumn(7).setPreferredWidth(80);
	scrollNewBulk.setViewportView(tblNewBulkProducts);
		
	final String AdminColumns[] = {"idAdmin","Nombre","Apellido","Telefono","Puesto"};
	tableModelAdmin = new DefaultTableModel(AdminColumns, 0);
	tblAdmin = new JTable(tableModelAdmin);
	tblAdmin.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	tblAdmin.getColumnModel().getColumn(0).setPreferredWidth(60);
	tblAdmin.getColumnModel().getColumn(1).setPreferredWidth(120);
	tblAdmin.getColumnModel().getColumn(2).setPreferredWidth(120);
	tblAdmin.getColumnModel().getColumn(3).setPreferredWidth(120);
	tblAdmin.getColumnModel().getColumn(4).setPreferredWidth(100);
	scrollAdmin.setViewportView(tblAdmin);
	
	final String EmailColumns[] = {"idEmail","Email","Activado?"};
	tableModelEmail = new DefaultTableModel(EmailColumns, 0);
	tblEmail = new JTable(tableModelEmail);
	tblEmail.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	tblEmail.getColumnModel().getColumn(0).setPreferredWidth(100);
	tblEmail.getColumnModel().getColumn(1).setPreferredWidth(150);
	tblEmail.getColumnModel().getColumn(2).setPreferredWidth(150);
	scrollEmail.setViewportView(tblEmail);
	
	final String SystemPathsColumns[] = {"id","Cierre","Entradas","Salidas","Ganancias","Productos","Ventas"};
	tableModelPaths = new DefaultTableModel(SystemPathsColumns, 0);
	tblPaths = new JTable(tableModelPaths);
	tblPaths.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	tblPaths.getColumnModel().getColumn(0).setPreferredWidth(100);
	tblPaths.getColumnModel().getColumn(1).setPreferredWidth(150);
	tblPaths.getColumnModel().getColumn(2).setPreferredWidth(150);
	tblPaths.getColumnModel().getColumn(3).setPreferredWidth(150);
	tblPaths.getColumnModel().getColumn(4).setPreferredWidth(150);
	tblPaths.getColumnModel().getColumn(5).setPreferredWidth(150);
	scrollPaths.setViewportView(tblPaths);
	
	}
}
