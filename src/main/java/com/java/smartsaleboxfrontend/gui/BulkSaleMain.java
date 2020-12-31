package com.java.smartsaleboxfrontend.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class BulkSaleMain extends JFrame {

	private JPanel BulkPane;
	private JTextField txtBulkProductSearch;
	private JTextField txtBulkBarCode;
	private JTable tableBulkSale;
	
	private JTextField txtKiloGrams;
	private JTextField txtKiloPrice;
	private JTextField txtSaleQuantity;
	private JTextField txtTotalBulkSale;
	private JTextField txtBulkProductSelected;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BulkSaleMain frame = new BulkSaleMain();
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
	public BulkSaleMain() {
		setTitle("Producto a Granel");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 495);
		BulkPane = new JPanel();
		BulkPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(BulkPane);
		BulkPane.setLayout(new BorderLayout(0, 0));
		
		JPanel MainBulkPanel = new JPanel();
		MainBulkPanel.setBackground(SystemColor.window);
		BulkPane.add(MainBulkPanel, BorderLayout.CENTER);
		MainBulkPanel.setLayout(null);
		
		JLabel lblBulkLogo = new JLabel("@SmartSaleBox.");
		lblBulkLogo.setBounds(340, 12, 188, 29);
		lblBulkLogo.setFont(new Font("Lucida Bright", Font.BOLD, 24));
		MainBulkPanel.add(lblBulkLogo);
		
		JLabel lblConsultaProducto_1 = new JLabel("Venta a Granel");
		lblConsultaProducto_1.setBounds(23, 29, 145, 22);
		lblConsultaProducto_1.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		MainBulkPanel.add(lblConsultaProducto_1);
		
		JLabel lblProducto_2_6 = new JLabel("Producto:");
		lblProducto_2_6.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_6.setBounds(23, 63, 85, 28);
		MainBulkPanel.add(lblProducto_2_6);
		
		JLabel lblProducto_2_6_1 = new JLabel("Código:");
		lblProducto_2_6_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_6_1.setBounds(326, 63, 85, 28);
		MainBulkPanel.add(lblProducto_2_6_1);
		
		txtBulkProductSearch = new JTextField();
		txtBulkProductSearch.setBounds(23, 103, 179, 29);
		MainBulkPanel.add(txtBulkProductSearch);
		txtBulkProductSearch.setColumns(10);
		
		txtBulkBarCode = new JTextField();
		txtBulkBarCode.setColumns(10);
		txtBulkBarCode.setBounds(326, 103, 145, 29);
		MainBulkPanel.add(txtBulkBarCode);
		
		JScrollPane bulkSalePane = new JScrollPane();
		bulkSalePane.setBounds(23, 144, 276, 134);
		MainBulkPanel.add(bulkSalePane);
		
		tableBulkSale = new JTable();
		bulkSalePane.setViewportView(tableBulkSale);
		
		JButton btnClearBulk = new JButton("Limpiar");
		btnClearBulk.setBounds(326, 253, 101, 25);
		MainBulkPanel.add(btnClearBulk);
		
		JButton btnAddBulkSale = new JButton("Ingresar");
		btnAddBulkSale.setBounds(326, 400, 101, 25);
		MainBulkPanel.add(btnAddBulkSale);
		
		txtKiloGrams = new JTextField();
		txtKiloGrams.setBounds(78, 357, 77, 29);
		MainBulkPanel.add(txtKiloGrams);
		txtKiloGrams.setColumns(10);
		
		txtKiloPrice = new JTextField();
		txtKiloPrice.setColumns(10);
		txtKiloPrice.setBounds(221, 357, 77, 29);
		MainBulkPanel.add(txtKiloPrice);
		
		txtSaleQuantity = new JTextField();
		txtSaleQuantity.setColumns(10);
		txtSaleQuantity.setBounds(78, 398, 77, 29);
		MainBulkPanel.add(txtSaleQuantity);
		
		txtTotalBulkSale = new JTextField();
		txtTotalBulkSale.setColumns(10);
		txtTotalBulkSale.setBounds(222, 398, 77, 29);
		MainBulkPanel.add(txtTotalBulkSale);
		
		JLabel lblProducto_2_6_1_1 = new JLabel("Total $");
		lblProducto_2_6_1_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_6_1_1.setBounds(165, 398, 57, 28);
		MainBulkPanel.add(lblProducto_2_6_1_1);
		
		JLabel lblProducto_2_6_1_1_1 = new JLabel("Kilo gr");
		lblProducto_2_6_1_1_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_6_1_1_1.setBounds(23, 357, 57, 28);
		MainBulkPanel.add(lblProducto_2_6_1_1_1);
		
		JLabel lblProducto_2_6_1_1_1_1 = new JLabel("Venta:$");
		lblProducto_2_6_1_1_1_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_6_1_1_1_1.setBounds(23, 398, 57, 28);
		MainBulkPanel.add(lblProducto_2_6_1_1_1_1);
		
		JLabel lblProducto_2_6_1_1_1_2 = new JLabel("$");
		lblProducto_2_6_1_1_1_2.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_6_1_1_1_2.setBounds(205, 356, 19, 28);
		MainBulkPanel.add(lblProducto_2_6_1_1_1_2);
		
		JLabel lblProducto_2_6_1_1_2 = new JLabel("(F5)");
		lblProducto_2_6_1_1_2.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_6_1_1_2.setBounds(448, 250, 57, 28);
		MainBulkPanel.add(lblProducto_2_6_1_1_2);
		
		JLabel lblProducto_2_6_1_1_2_1 = new JLabel("(ENTER)");
		lblProducto_2_6_1_1_2_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_6_1_1_2_1.setBounds(445, 397, 57, 28);
		MainBulkPanel.add(lblProducto_2_6_1_1_2_1);
		
		txtBulkProductSelected = new JTextField();
		txtBulkProductSelected.setEnabled(false);
		txtBulkProductSelected.setColumns(10);
		txtBulkProductSelected.setBounds(23, 290, 179, 29);
		MainBulkPanel.add(txtBulkProductSelected);
	}

}
