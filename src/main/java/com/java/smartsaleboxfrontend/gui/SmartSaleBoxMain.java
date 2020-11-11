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

public class SmartSaleBoxMain extends JFrame {

	private static final long serialVersionUID = -3289141083530735532L;
	
	private JPanel contentPane;
	private JTable tableSale;
	private JTable tableCartSale;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable tblCashPayment;
	private JTextField textField_1;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;

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
		
		tableSale = new JTable();
		salePanel.add(tableSale, BorderLayout.CENTER);
		
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
		
		textField = new JTextField();
		textField.setBounds(450, 486, 87, 28);
		tabbedSale.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(870, 486, 87, 28);
		tabbedSale.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(870, 514, 87, 28);
		tabbedSale.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(870, 542, 87, 28);
		tabbedSale.add(textField_4);
		
		JButton btnNewButton = new JButton("Cobrar");
		btnNewButton.setBounds(840, 582, 117, 39);
		tabbedSale.add(btnNewButton);
		
		JLabel lblEnVenta_1 = new JLabel("En Venta:");
		lblEnVenta_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblEnVenta_1.setBounds(53, 169, 97, 28);
		tabbedSale.add(lblEnVenta_1);
		
		JLabel lblConsultarProducto = new JLabel("Consultar Producto");
		lblConsultarProducto.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblConsultarProducto.setBounds(708, 38, 150, 28);
		tabbedSale.add(lblConsultarProducto);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(677, 78, 212, 28);
		tabbedSale.add(textField_5);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblNombre.setBounds(607, 78, 69, 28);
		tabbedSale.add(lblNombre);
		
		JLabel lblCdigo = new JLabel("Código:");
		lblCdigo.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblCdigo.setBounds(612, 128, 64, 28);
		tabbedSale.add(lblCdigo);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(677, 128, 212, 28);
		tabbedSale.add(textField_6);
		
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
		
		JButton btnLimpiarVenta = new JButton("Borrar Venta");
		btnLimpiarVenta.setBounds(53, 484, 140, 39);
		tabbedSale.add(btnLimpiarVenta);
		
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 134, 644, 469);
		tabbedSalesHistory.add(scrollPane);
		
		JLabel lblNoVenta = new JLabel("No. Venta:");
		lblNoVenta.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblNoVenta.setBounds(46, 82, 85, 28);
		tabbedSalesHistory.add(lblNoVenta);
		
		textField_1 = new JTextField();
		textField_1.setBounds(128, 84, 85, 28);
		tabbedSalesHistory.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Consultar");
		btnNewButton_1.setBounds(225, 85, 109, 25);
		tabbedSalesHistory.add(btnNewButton_1);
		
		JLabel lblTotalVentas = new JLabel("Total Ventas: $");
		lblTotalVentas.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblTotalVentas.setBounds(480, 615, 120, 28);
		tabbedSalesHistory.add(lblTotalVentas);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(592, 615, 85, 35);
		tabbedSalesHistory.add(textField_7);
		
		JButton btnNewButton_1_1 = new JButton("Generar Reverso");
		btnNewButton_1_1.setBounds(707, 553, 164, 39);
		tabbedSalesHistory.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Imprimir Ticket");
		btnNewButton_1_2.setBounds(707, 493, 164, 39);
		tabbedSalesHistory.add(btnNewButton_1_2);
		
		JLabel lblNewLabel_1 = new JLabel("@SmartSaleBox.");
		lblNewLabel_1.setFont(new Font("Lucida Bright", Font.BOLD, 24));
		lblNewLabel_1.setBounds(840, 12, 201, 28);
		tabbedSalesHistory.add(lblNewLabel_1);
		
		JPanel tabbedProducts = new JPanel();
		tabbedProducts.setBackground(SystemColor.window);
		tabbedPane.addTab("Productos", null, tabbedProducts, null);
		tabbedProducts.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("@SmartSaleBox.");
		lblNewLabel_1_1.setFont(new Font("Lucida Bright", Font.BOLD, 24));
		lblNewLabel_1_1.setBounds(840, 12, 201, 28);
		tabbedProducts.add(lblNewLabel_1_1);
		
		JLabel lblAltaProducto = new JLabel("Alta Producto");
		lblAltaProducto.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		lblAltaProducto.setBounds(112, 58, 140, 28);
		tabbedProducts.add(lblAltaProducto);
		
		JLabel lblConsultaProducto = new JLabel("Consulta Producto");
		lblConsultaProducto.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		lblConsultaProducto.setBounds(645, 58, 189, 28);
		tabbedProducts.add(lblConsultaProducto);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(443, 133, 565, 478);
		tabbedProducts.add(scrollPane_1);
		
		JLabel lblProducto_2 = new JLabel("Producto:");
		lblProducto_2.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2.setBounds(55, 133, 85, 28);
		tabbedProducts.add(lblProducto_2);
		
		JLabel lblProducto_2_2 = new JLabel("Precio Costo: $");
		lblProducto_2_2.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_2.setBounds(32, 191, 108, 28);
		tabbedProducts.add(lblProducto_2_2);
		
		JLabel lblProducto_2_3 = new JLabel("Precio Venta: $");
		lblProducto_2_3.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_3.setBounds(32, 242, 108, 28);
		tabbedProducts.add(lblProducto_2_3);
		
		JLabel lblProducto_2_4 = new JLabel("Ganancia: $");
		lblProducto_2_4.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_4.setBounds(55, 296, 85, 28);
		tabbedProducts.add(lblProducto_2_4);
		
		JLabel lblProducto_2_4_1 = new JLabel("Stock:");
		lblProducto_2_4_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_4_1.setBounds(97, 346, 52, 28);
		tabbedProducts.add(lblProducto_2_4_1);
		
		JLabel lblProducto_2_4_2 = new JLabel("Codigo Barras:");
		lblProducto_2_4_2.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_4_2.setBounds(32, 402, 108, 28);
		tabbedProducts.add(lblProducto_2_4_2);
		
		JButton btnNewButton_2 = new JButton("Guardar");
		btnNewButton_2.setBounds(155, 475, 117, 34);
		tabbedProducts.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Calcular");
		btnNewButton_2_1.setFont(new Font("Dialog", Font.BOLD, 10));
		btnNewButton_2_1.setBounds(261, 296, 85, 25);
		tabbedProducts.add(btnNewButton_2_1);
		
		textField_8 = new JTextField();
		textField_8.setBounds(138, 133, 270, 34);
		tabbedProducts.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(157, 193, 95, 28);
		tabbedProducts.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(157, 244, 95, 28);
		tabbedProducts.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(158, 298, 94, 28);
		tabbedProducts.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(158, 348, 94, 28);
		tabbedProducts.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(138, 401, 270, 34);
		tabbedProducts.add(textField_13);
		
		JPanel tabbedAdmin = new JPanel();
		tabbedPane.addTab("Administración", null, tabbedAdmin, null);
		tabbedAdmin.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedAdminOptions = new JTabbedPane(JTabbedPane.TOP);
		tabbedAdmin.add(tabbedAdminOptions, BorderLayout.CENTER);
		
		JPanel InOutPanel = new JPanel();
		InOutPanel.setBackground(SystemColor.window);
		tabbedAdminOptions.addTab("Entradas/Salidas", null, InOutPanel, null);
		InOutPanel.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(27, 78, 480, 499);
		InOutPanel.add(scrollPane_2);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(537, 78, 480, 499);
		InOutPanel.add(scrollPane_3);
		
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
		
		textField_14 = new JTextField();
		textField_14.setBounds(393, 583, 114, 34);
		InOutPanel.add(textField_14);
		textField_14.setColumns(10);
		
		JLabel lblProducto_2_5_1 = new JLabel("Total Salidas: $");
		lblProducto_2_5_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_5_1.setBounds(785, 589, 114, 28);
		InOutPanel.add(lblProducto_2_5_1);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(903, 583, 114, 34);
		InOutPanel.add(textField_15);
		
		JPanel closurePanel = new JPanel();
		tabbedAdminOptions.addTab("Corte", null, closurePanel, null);
		
		JPanel EmailConfigPanel = new JPanel();
		tabbedAdminOptions.addTab("Configuración Email", null, EmailConfigPanel, null);
		
		JPanel adminConfigPanel = new JPanel();
		tabbedAdminOptions.addTab("Configuración Administracion", null, adminConfigPanel, null);
	}
}
