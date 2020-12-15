package com.java.smartsaleboxfrontend.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

public class SmartSaleBoxMain extends JFrame {

	private static final long serialVersionUID = -3289141083530735532L;
	
	private JPanel contentPane;
	private JTable tblSale;
	private JTable tableCartSale;
	private JTextField txtSubTotal;
	private JTextField txtTotalSale;
	private JTextField txtReceived;
	private JTextField txtChangeBack;
	private JTextField txtSaleProductSaleName;
	private JTextField txtProductCodeSearch;
	private JTable tblCashPayment;
	private JTextField txtHistoryNoSale;
	private JTextField txtTotalSaleHistory;
	private JTextField txtTotalInflows;
	private JTextField txtTotalOutflows;
	private JTextField txtNewProductName;
	private JTextField txtNewCostPrice;
	private JTextField txtNewSalePrice;
	private JTextField txtNewEarning;
	private JTextField txtNewStock;
	private JTextField txtNewBarCode;
	private JTextField txtNewBulkProductName;
	private JTextField txtNewBulkCostPrice;
	private JTextField txtNewBulkKiloPrice;
	private JTextField txtNewBulkStock;
	private JTextField txtNewBulkBarCodeProd;
	private JTextField txtNewBulkKiloEarning;
	private JTextField txtNewBulkEarning;
	private JTable tblSaleHistory;
	private JTable tblNewProduct;
	private JTable tblNewBulkProducts;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_7;
	private JTextField textField_10;
	private JTable tblEmail;
	private JTextField textField_11;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

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

	/**
	 * Create the frame.
	 */
	public SmartSaleBoxMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1068, 747);
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
		lblNewLabel.setBounds(840, 8, 201, 28);
		tabbedSale.add(lblNewLabel);
		
		JLabel lblEnVenta = new JLabel("En venta");
		lblEnVenta.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		lblEnVenta.setBounds(12, 12, 97, 28);
		tabbedSale.add(lblEnVenta);
		
		JPanel salePanel = new JPanel();
		salePanel.setBounds(53, 209, 484, 263);
		tabbedSale.add(salePanel);
		salePanel.setLayout(new BorderLayout(0, 0));
		
		tblSale = new JTable();
		salePanel.add(tblSale, BorderLayout.CENTER);
		
		JPanel cartSalePanel = new JPanel();
		cartSalePanel.setBounds(53, 78, 484, 85);
		tabbedSale.add(cartSalePanel);
		cartSalePanel.setLayout(new BorderLayout(0, 0));
		
		tableCartSale = new JTable();
		cartSalePanel.add(tableCartSale, BorderLayout.CENTER);
		
		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto.setBounds(53, 52, 97, 28);
		tabbedSale.add(lblProducto);
		
		JLabel lblProducto_1 = new JLabel("SubTotal:");
		lblProducto_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_1.setBounds(380, 484, 77, 28);
		tabbedSale.add(lblProducto_1);
		
		JLabel lblProducto_2_1 = new JLabel("Total: $");
		lblProducto_2_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_1.setBounds(811, 484, 64, 28);
		tabbedSale.add(lblProducto_2_1);
		
		JLabel lblProducto_2_1_1 = new JLabel("Recibido: $");
		lblProducto_2_1_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_1_1.setBounds(788, 512, 87, 28);
		tabbedSale.add(lblProducto_2_1_1);
		
		JLabel lblProducto_2_1_1_1 = new JLabel("Cambio: $");
		lblProducto_2_1_1_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_1_1_1.setBounds(796, 540, 79, 28);
		tabbedSale.add(lblProducto_2_1_1_1);
		
		txtSubTotal = new JTextField();
		txtSubTotal.setBounds(450, 486, 87, 28);
		tabbedSale.add(txtSubTotal);
		txtSubTotal.setColumns(10);
		
		txtTotalSale = new JTextField();
		txtTotalSale.setColumns(10);
		txtTotalSale.setBounds(870, 486, 87, 28);
		tabbedSale.add(txtTotalSale);
		
		txtReceived = new JTextField();
		txtReceived.setColumns(10);
		txtReceived.setBounds(870, 514, 87, 28);
		tabbedSale.add(txtReceived);
		
		txtChangeBack = new JTextField();
		txtChangeBack.setColumns(10);
		txtChangeBack.setBounds(870, 542, 87, 28);
		tabbedSale.add(txtChangeBack);
		
		JButton btnExecuteSale = new JButton("Cobrar");
		btnExecuteSale.setBounds(840, 582, 117, 39);
		tabbedSale.add(btnExecuteSale);
		
		JLabel lblEnVenta_1 = new JLabel("En Venta:");
		lblEnVenta_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblEnVenta_1.setBounds(53, 169, 97, 28);
		tabbedSale.add(lblEnVenta_1);
		
		JLabel lblConsultarProducto = new JLabel("Consultar Producto");
		lblConsultarProducto.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblConsultarProducto.setBounds(708, 38, 150, 28);
		tabbedSale.add(lblConsultarProducto);
		
		txtSaleProductSaleName = new JTextField();
		txtSaleProductSaleName.setColumns(10);
		txtSaleProductSaleName.setBounds(677, 78, 212, 28);
		tabbedSale.add(txtSaleProductSaleName);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblNombre.setBounds(607, 78, 69, 28);
		tabbedSale.add(lblNombre);
		
		JLabel lblCdigo = new JLabel("Código:");
		lblCdigo.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblCdigo.setBounds(612, 128, 64, 28);
		tabbedSale.add(lblCdigo);
		
		txtProductCodeSearch = new JTextField();
		txtProductCodeSearch.setColumns(10);
		txtProductCodeSearch.setBounds(677, 128, 212, 28);
		tabbedSale.add(txtProductCodeSearch);
		
		JPanel cashPaymentPanel = new JPanel();
		cashPaymentPanel.setBounds(644, 375, 313, 97);
		tabbedSale.add(cashPaymentPanel);
		cashPaymentPanel.setLayout(new BorderLayout(0, 0));
		
		tblCashPayment = new JTable();
		cashPaymentPanel.add(tblCashPayment, BorderLayout.CENTER);
		
		JLabel lblACobrar = new JLabel("A cobrar");
		lblACobrar.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblACobrar.setBounds(644, 335, 87, 28);
		tabbedSale.add(lblACobrar);
		
		JButton btnVentaKg = new JButton("Venta por Kg");
		btnVentaKg.setBounds(840, 209, 150, 39);
		tabbedSale.add(btnVentaKg);
		
		JButton btnClearSale = new JButton("Borrar Venta");
		btnClearSale.setBounds(53, 484, 140, 39);
		tabbedSale.add(btnClearSale);
		
		JLabel lblF = new JLabel("F9");
		lblF.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblF.setBounds(908, 247, 49, 28);
		tabbedSale.add(lblF);
		
		JLabel lblF_2 = new JLabel("F5");
		lblF_2.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblF_2.setBounds(107, 524, 49, 28);
		tabbedSale.add(lblF_2);
		
		JLabel lblF_1 = new JLabel("F12");
		lblF_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblF_1.setBounds(889, 617, 49, 28);
		tabbedSale.add(lblF_1);
		
		JPanel tabbedSalesHistory = new JPanel();
		tabbedSalesHistory.setBackground(SystemColor.window);
		tabbedPane.addTab("Historial Ventas", null, tabbedSalesHistory, null);
		tabbedSalesHistory.setLayout(null);
		
		JLabel lblVentas = new JLabel("Ventas");
		lblVentas.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		lblVentas.setBounds(46, 26, 97, 28);
		tabbedSalesHistory.add(lblVentas);
		
		JScrollPane paneSaleHistory = new JScrollPane();
		paneSaleHistory.setBounds(44, 134, 644, 469);
		tabbedSalesHistory.add(paneSaleHistory);
		
		tblSaleHistory = new JTable();
		paneSaleHistory.setViewportView(tblSaleHistory);
		
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
		lblTotalVentas.setBounds(480, 615, 120, 28);
		tabbedSalesHistory.add(lblTotalVentas);
		
		txtTotalSaleHistory = new JTextField();
		txtTotalSaleHistory.setColumns(10);
		txtTotalSaleHistory.setBounds(592, 615, 85, 35);
		tabbedSalesHistory.add(txtTotalSaleHistory);
		
		JButton btnBackUpSale = new JButton("Generar Reverso");
		btnBackUpSale.setBounds(707, 553, 164, 39);
		tabbedSalesHistory.add(btnBackUpSale);
		
		JButton btnPrintTicket = new JButton("Imprimir Ticket");
		btnPrintTicket.setBounds(707, 493, 164, 39);
		tabbedSalesHistory.add(btnPrintTicket);
		
		JLabel lblNewLabel_1 = new JLabel("@SmartSaleBox.");
		lblNewLabel_1.setFont(new Font("Lucida Bright", Font.BOLD, 24));
		lblNewLabel_1.setBounds(840, 12, 201, 28);
		tabbedSalesHistory.add(lblNewLabel_1);
		
		JPanel tabbedAdmin = new JPanel();
		tabbedPane.addTab("Administración", null, tabbedAdmin, null);
		tabbedAdmin.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedAdminOptions = new JTabbedPane(JTabbedPane.TOP);
		tabbedAdmin.add(tabbedAdminOptions, BorderLayout.CENTER);
		
		JPanel InOutPanel = new JPanel();
		InOutPanel.setBackground(SystemColor.window);
		tabbedAdminOptions.addTab("Entradas/Salidas", null, InOutPanel, null);
		InOutPanel.setLayout(null);
		
		JScrollPane paneInflows = new JScrollPane();
		paneInflows.setBounds(27, 78, 480, 499);
		InOutPanel.add(paneInflows);
		
		JScrollPane paneOutflows = new JScrollPane();
		paneOutflows.setBounds(537, 78, 480, 499);
		InOutPanel.add(paneOutflows);
		
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
		lblProducto_2_5.setBounds(267, 589, 132, 28);
		InOutPanel.add(lblProducto_2_5);
		
		txtTotalInflows = new JTextField();
		txtTotalInflows.setBounds(393, 583, 114, 34);
		InOutPanel.add(txtTotalInflows);
		txtTotalInflows.setColumns(10);
		
		JLabel lblProducto_2_5_1 = new JLabel("Total Salidas: $");
		lblProducto_2_5_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5_1.setBounds(785, 589, 114, 28);
		InOutPanel.add(lblProducto_2_5_1);
		
		txtTotalOutflows = new JTextField();
		txtTotalOutflows.setColumns(10);
		txtTotalOutflows.setBounds(903, 583, 114, 34);
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
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(146, 225, 216, 34);
		EmailConfigPanel.add(textField_7);
		
		JLabel lblProducto_2_5_2_1_1 = new JLabel("Password:");
		lblProducto_2_5_2_1_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5_2_1_1.setBounds(64, 289, 86, 28);
		EmailConfigPanel.add(lblProducto_2_5_2_1_1);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(146, 288, 216, 34);
		EmailConfigPanel.add(textField_10);
		
		JButton btnNewButton_1 = new JButton("Guardar Email");
		btnNewButton_1.setBounds(169, 355, 153, 34);
		EmailConfigPanel.add(btnNewButton_1);
		
		JScrollPane paneEmail = new JScrollPane();
		paneEmail.setBounds(498, 225, 498, 168);
		EmailConfigPanel.add(paneEmail);
		
		tblEmail = new JTable();
		paneEmail.setViewportView(tblEmail);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(509, 420, 117, 25);
		EmailConfigPanel.add(btnActualizar);
		
		JLabel lblConsultaEmail = new JLabel("Consulta Email");
		lblConsultaEmail.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		lblConsultaEmail.setBounds(647, 173, 153, 28);
		EmailConfigPanel.add(lblConsultaEmail);
		
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
		lblAltaAdministrador.setBounds(135, 136, 192, 28);
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
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(191, 226, 216, 34);
		adminConfigPanel.add(textField_11);
		
		JButton btnNewButton_1_1 = new JButton("Guardar");
		btnNewButton_1_1.setBounds(204, 470, 153, 34);
		adminConfigPanel.add(btnNewButton_1_1);
		
		JLabel lblProducto_2_5_2_1_2_1 = new JLabel("Puesto:");
		lblProducto_2_5_2_1_2_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5_2_1_2_1.setBounds(135, 291, 63, 28);
		adminConfigPanel.add(lblProducto_2_5_2_1_2_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(191, 354, 192, 34);
		adminConfigPanel.add(passwordField);
		
		JLabel lblProducto_2_5_2_1_1_1_1 = new JLabel("Confirma Password:");
		lblProducto_2_5_2_1_1_1_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5_2_1_1_1_1.setBounds(40, 410, 148, 28);
		adminConfigPanel.add(lblProducto_2_5_2_1_1_1_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(191, 409, 192, 34);
		adminConfigPanel.add(passwordField_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(191, 289, 216, 34);
		adminConfigPanel.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(466, 227, 553, 251);
		adminConfigPanel.add(scrollPane);
		
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
		paneGetProduct.setBounds(443, 133, 565, 478);
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
		btnSaveNewProduct.setBounds(155, 475, 117, 34);
		tabbedProducts_1.add(btnSaveNewProduct);
		
		JButton btnNewCalculateEarning = new JButton("Calcular");
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
		paneNewBulk.setBounds(443, 133, 565, 478);
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
		btnSaveNewBulk.setBounds(210, 533, 117, 34);
		tabbedProducts_2.add(btnSaveNewBulk);
		
		JButton btnNewButton_2_1_2 = new JButton("Calcular");
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
	}
}
