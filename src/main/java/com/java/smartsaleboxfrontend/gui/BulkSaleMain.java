package com.java.smartsaleboxfrontend.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.java.smartsaleboxfrontend.business.read.ReadBulkSaleInfo;
import com.java.smartsaleboxfrontend.business.save.SaveBulkProductProcess;
import com.java.smartsaleboxfrontend.business.save.SaveSaleProcess;
import com.java.smartsaleboxfrontend.utils.SmartSaleBoxClearFields;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BulkSaleMain extends JFrame {

	private static final long serialVersionUID = 3050354086576961853L;
	
	public static BulkSaleMain frame = new BulkSaleMain();
	
	public static JPanel BulkPane;
	
	public static JTextField txtBulkProductSearch;
	public static JTextField txtBulkBarCode;
	public static JTextField txtKiloGrams;
	public static JTextField txtKiloPrice;
	public static JTextField txtSaleQuantity;
	public static JTextField txtBulkProductSelected;
	public static JTextField txtBulkSaleId;
	public static JTextField txtBulkSaleStock;
	
	public static DefaultTableModel tableModelBulkSale;
	public static JTable tblBulkSale;
	public static JScrollPane scrollBulkSale;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		setBounds(100, 100, 579, 495);
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
		txtBulkProductSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (ReadBulkSaleInfo.validateGetBulkProdName()) {
						ReadBulkSaleInfo.fillBulkSaleTableByName(txtBulkProductSearch.getText());
					} else {
						JOptionPane.showMessageDialog(null, "Ingrese Producto por favor");
					}
				}
			}
		});
		txtBulkProductSearch.setBounds(23, 103, 179, 29);
		MainBulkPanel.add(txtBulkProductSearch);
		txtBulkProductSearch.setColumns(10);
		
		txtBulkBarCode = new JTextField();
		txtBulkBarCode.setColumns(10);
		txtBulkBarCode.setBounds(326, 103, 145, 29);
		MainBulkPanel.add(txtBulkBarCode);
		
		JButton btnClearBulk = new JButton("Limpiar");
		btnClearBulk.setBounds(389, 253, 101, 25);
		MainBulkPanel.add(btnClearBulk);
		
		JButton btnAddBulkSale = new JButton("Ingresar");
		btnAddBulkSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveSaleProcess.addBulkProductToSaleList();
				SmartSaleBoxClearFields.clearBulkSaleMain(SmartSaleBoxMain.bulkSaleMain);
				SmartSaleBoxMain.bulkSaleMain.dispose();
			}
		});
		btnAddBulkSale.setBounds(389, 400, 101, 25);
		MainBulkPanel.add(btnAddBulkSale);
		
		txtKiloGrams = new JTextField();
		txtKiloGrams.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtKiloGrams.setText(null);
			}
		});
		txtKiloGrams.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				ReadBulkSaleInfo.calculatePrice();
			}
		});
		txtKiloGrams.setBounds(113, 374, 77, 29);
		MainBulkPanel.add(txtKiloGrams);
		txtKiloGrams.setColumns(10);
		
		txtKiloPrice = new JTextField();
		txtKiloPrice.setColumns(10);
		txtKiloPrice.setBounds(281, 335, 77, 29);
		MainBulkPanel.add(txtKiloPrice);
		
		txtSaleQuantity = new JTextField();
		txtSaleQuantity.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtSaleQuantity.setText(null);
			}
		});
		txtSaleQuantity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				ReadBulkSaleInfo.calculateGrams();
			}
		});
		txtSaleQuantity.setColumns(10);
		txtSaleQuantity.setBounds(113, 414, 77, 29);
		MainBulkPanel.add(txtSaleQuantity);
		
		JLabel lblProducto_2_6_1_1_1 = new JLabel("Gramos:");
		lblProducto_2_6_1_1_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_6_1_1_1.setBounds(41, 373, 66, 28);
		MainBulkPanel.add(lblProducto_2_6_1_1_1);
		
		JLabel lblProducto_2_6_1_1_1_1 = new JLabel("En Venta: $");
		lblProducto_2_6_1_1_1_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_6_1_1_1_1.setBounds(22, 414, 85, 28);
		MainBulkPanel.add(lblProducto_2_6_1_1_1_1);
		
		JLabel lblProducto_2_6_1_1_1_2 = new JLabel("Precio x Kilo $");
		lblProducto_2_6_1_1_1_2.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_6_1_1_1_2.setBounds(173, 334, 117, 28);
		MainBulkPanel.add(lblProducto_2_6_1_1_1_2);
		
		JLabel lblProducto_2_6_1_1_2 = new JLabel("(F5)");
		lblProducto_2_6_1_1_2.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_6_1_1_2.setBounds(500, 250, 57, 28);
		MainBulkPanel.add(lblProducto_2_6_1_1_2);
		
		JLabel lblProducto_2_6_1_1_2_1 = new JLabel("(ENTER)");
		lblProducto_2_6_1_1_2_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_6_1_1_2_1.setBounds(500, 397, 57, 28);
		MainBulkPanel.add(lblProducto_2_6_1_1_2_1);
		
		txtBulkProductSelected = new JTextField();
		txtBulkProductSelected.setEnabled(false);
		txtBulkProductSelected.setColumns(10);
		txtBulkProductSelected.setBounds(23, 333, 132, 29);
		MainBulkPanel.add(txtBulkProductSelected);
		
		JPanel bulkSalePanel = new JPanel();
		bulkSalePanel.setBounds(23, 144, 354, 135);
		MainBulkPanel.add(bulkSalePanel);
		bulkSalePanel.setLayout(new BorderLayout(0, 0));
		
	    scrollBulkSale = new JScrollPane();
		bulkSalePanel.add(scrollBulkSale, BorderLayout.CENTER);
		
		/////////////// BEGINS CART SALE MODEL BUILDING
		final String bulkSaleColumns[] = {"Producto", "$ Precio x Kilo", "Stock Gr.","idProd" };
		tableModelBulkSale = new DefaultTableModel(bulkSaleColumns, 0);
		tblBulkSale = new JTable(tableModelBulkSale);
		tblBulkSale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SaveBulkProductProcess.addBulkProductToSaleList(e);
			}
		});
		tblBulkSale.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblBulkSale.getColumnModel().getColumn(0).setPreferredWidth(150);
		tblBulkSale.getColumnModel().getColumn(1).setPreferredWidth(120);
		tblBulkSale.getColumnModel().getColumn(2).setPreferredWidth(100);
		tblBulkSale.getColumnModel().getColumn(3).setPreferredWidth(50);
		scrollBulkSale.setViewportView(tblBulkSale);
		
		JLabel lblProducto_2_6_1_1_3 = new JLabel("grs.");
		lblProducto_2_6_1_1_3.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_6_1_1_3.setBounds(195, 375, 57, 28);
		MainBulkPanel.add(lblProducto_2_6_1_1_3);
		
		txtBulkSaleId = new JTextField();
		txtBulkSaleId.setEnabled(false);
		txtBulkSaleId.setColumns(10);
		txtBulkSaleId.setBounds(47, 292, 34, 29);
		MainBulkPanel.add(txtBulkSaleId);
		
		JLabel lblProducto_2_6_1_1_1_3 = new JLabel("Id:");
		lblProducto_2_6_1_1_1_3.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_6_1_1_1_3.setBounds(23, 291, 25, 28);
		MainBulkPanel.add(lblProducto_2_6_1_1_1_3);
		
		txtBulkSaleStock = new JTextField();
		txtBulkSaleStock.setEnabled(false);
		txtBulkSaleStock.setColumns(10);
		txtBulkSaleStock.setBounds(165, 291, 101, 29);
		MainBulkPanel.add(txtBulkSaleStock);
		
		JLabel lblProducto_2_6_1_1_1_3_1 = new JLabel("Stock:");
		lblProducto_2_6_1_1_1_3_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_6_1_1_1_3_1.setBounds(119, 291, 49, 28);
		MainBulkPanel.add(lblProducto_2_6_1_1_1_3_1);
	
	}
}
