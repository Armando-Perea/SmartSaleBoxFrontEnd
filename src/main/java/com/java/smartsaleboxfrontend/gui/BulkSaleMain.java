package com.java.smartsaleboxfrontend.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.java.smartsaleboxfrontend.business.delete.DeleteSaleProcess;
import com.java.smartsaleboxfrontend.business.read.ReadBulkSaleInfo;
import com.java.smartsaleboxfrontend.business.save.SaveBulkProductProcess;
import com.java.smartsaleboxfrontend.business.save.SaveSaleProcess;
import com.java.smartsaleboxfrontend.utils.SmartSaleBoxClearFields;
import com.java.smartsaleboxfrontend.utils.SmartSaleBoxOperations;

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
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;

public class BulkSaleMain extends JFrame {

	private static final long serialVersionUID = 3050354086576961853L;
	
	public static BulkSaleMain frame = new BulkSaleMain();
	
	public static JPanel BulkPane;
	
	public static String scannerIn="";
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
		setBounds(100, 100, 661, 602);
		BulkPane = new JPanel();
		BulkPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(BulkPane);
		
		/////////////// BEGINS CART SALE MODEL BUILDING
		final String bulkSaleColumns[] = {"Producto", "$ Precio x Kilo", "Stock Gr.","idProd" };
		tableModelBulkSale = new DefaultTableModel(bulkSaleColumns, 0);
		BulkPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabBulkSale = new JTabbedPane(JTabbedPane.TOP);
		BulkPane.add(tabBulkSale);
		tabBulkSale.addKeyListener(new KeyListener() {
			@Override public void keyTyped(KeyEvent e) {
			}
			@Override public void keyReleased(KeyEvent e) {
			}
			@Override public void keyPressed(KeyEvent e) { 
				System.out.println("Key Character: " + e.getKeyChar() + "; Key Code: " + KeyEvent.getKeyText(e.getKeyCode())); 
				scannerIn = scannerIn+e.getKeyChar();
	            System.out.println("ScannerIn: "+scannerIn);
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					txtBulkBarCode.setText(null);
					scannerIn = scannerIn.trim();
		            System.out.println("Pressed " + e.getKeyCode());
		            System.out.println("ScannerIn: "+scannerIn);
		            txtBulkBarCode.setText(scannerIn);
					if (SmartSaleBoxOperations.validateScannerBulkReading()) {
						ReadBulkSaleInfo.fillBulkSaleTableByBarCode(txtBulkBarCode.getText());
						scannerIn="";
						tabBulkSale.requestFocus();
					} else {
						JOptionPane.showMessageDialog(null, "Ingrese código de barras por favor");
					}
				}
				
				
				
				
				
				
				
				if (e.getKeyCode() == KeyEvent.VK_F5) {
					SmartSaleBoxClearFields.clearBulkSaleMain(SmartSaleBoxMain.bulkSaleMain);
					tabBulkSale.requestFocus();
		        }
				
			} });
		
		JPanel MainBulkPanel = new JPanel();
		tabBulkSale.addTab("Venta Granel", null, MainBulkPanel, null);
		MainBulkPanel.setBackground(SystemColor.window);
		MainBulkPanel.setLayout(null);
		
		
		JLabel lblBulkLogo = new JLabel("@SmartSaleBox.");
		lblBulkLogo.setBounds(317, 12, 211, 29);
		lblBulkLogo.setFont(new Font("Lucida Bright", Font.BOLD, 24));
		MainBulkPanel.add(lblBulkLogo);
		
		JLabel lblConsultaProducto_1 = new JLabel("Venta a Granel");
		lblConsultaProducto_1.setBounds(23, 29, 145, 22);
		lblConsultaProducto_1.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		MainBulkPanel.add(lblConsultaProducto_1);
		
		JLabel lblProducto_2_6 = new JLabel("Producto:");
		lblProducto_2_6.setBounds(23, 63, 85, 28);
		lblProducto_2_6.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		MainBulkPanel.add(lblProducto_2_6);
		
		JLabel lblProducto_2_6_1 = new JLabel("Código:");
		lblProducto_2_6_1.setBounds(326, 63, 85, 28);
		lblProducto_2_6_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		MainBulkPanel.add(lblProducto_2_6_1);
		
		txtBulkProductSearch = new JTextField();
		txtBulkProductSearch.setBounds(23, 103, 179, 29);
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
		MainBulkPanel.add(txtBulkProductSearch);
		txtBulkProductSearch.setColumns(10);
		
		txtBulkBarCode = new JTextField();
		txtBulkBarCode.setBounds(326, 103, 214, 29);
		txtBulkBarCode.setColumns(10);
		MainBulkPanel.add(txtBulkBarCode);
		txtBulkBarCode.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtBulkBarCode.setText(null);
			}
		});
		txtBulkBarCode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					System.out.println("Pressed " + e.getKeyCode());
					if (SmartSaleBoxOperations.validateScannerBulkReading()) {
						ReadBulkSaleInfo.fillBulkSaleTableByBarCode(txtBulkBarCode.getText());
						txtBulkBarCode.setText(null);
						tabBulkSale.requestFocus();
					} else {
						JOptionPane.showMessageDialog(null, "Ingrese código de barras por favor");
					}
				}
			}
		});
		
		JButton btnClearBulk = new JButton("Limpiar");
		btnClearBulk.setBounds(439, 253, 101, 25);
		btnClearBulk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SmartSaleBoxClearFields.clearBulkSaleMain(SmartSaleBoxMain.bulkSaleMain);
				tabBulkSale.requestFocus();
			}
		});
		MainBulkPanel.add(btnClearBulk);
		
		JButton btnAddBulkSale = new JButton("Ingresar");
		btnAddBulkSale.setBounds(281, 407, 101, 43);
		btnAddBulkSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(SmartSaleBoxOperations.isValidBulkSale()) {
					SaveSaleProcess.addBulkProductToSaleList();
					SmartSaleBoxClearFields.clearBulkSaleMain(SmartSaleBoxMain.bulkSaleMain);
					SmartSaleBoxMain.bulkSaleMain.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Favor de revisar que todas las cantidades esten con valor");
				}
			}
		});
		MainBulkPanel.add(btnAddBulkSale);
		
		txtKiloGrams = new JTextField();
		txtKiloGrams.setBounds(113, 374, 77, 29);
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
		MainBulkPanel.add(txtKiloGrams);
		txtKiloGrams.setColumns(10);
		
		txtKiloPrice = new JTextField();
		txtKiloPrice.setBounds(281, 335, 77, 29);
		txtKiloPrice.setColumns(10);
		MainBulkPanel.add(txtKiloPrice);
		txtKiloGrams.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					System.out.println("Pressed " + e.getKeyCode());
					if(SmartSaleBoxOperations.isValidBulkSale()) {
						SaveSaleProcess.addBulkProductToSaleList();
						SmartSaleBoxClearFields.clearBulkSaleMain(SmartSaleBoxMain.bulkSaleMain);
						SmartSaleBoxMain.bulkSaleMain.dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Favor de revisar que todas las cantidades esten con valor");
					}
				}
			}
		});
		
		txtSaleQuantity = new JTextField();
		txtSaleQuantity.setBounds(113, 414, 77, 29);
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
		MainBulkPanel.add(txtSaleQuantity);
		txtSaleQuantity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					System.out.println("Pressed " + e.getKeyCode());
					if(SmartSaleBoxOperations.isValidBulkSale()) {
						SaveSaleProcess.addBulkProductToSaleList();
						SmartSaleBoxClearFields.clearBulkSaleMain(SmartSaleBoxMain.bulkSaleMain);
						SmartSaleBoxMain.bulkSaleMain.dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Favor de revisar que todas las cantidades esten con valor");
					}
				}
			}
		});
		
		JLabel lblProducto_2_6_1_1_1 = new JLabel("Gramos:");
		lblProducto_2_6_1_1_1.setBounds(41, 373, 66, 28);
		lblProducto_2_6_1_1_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		MainBulkPanel.add(lblProducto_2_6_1_1_1);
		
		JLabel lblProducto_2_6_1_1_1_1 = new JLabel("En Venta: $");
		lblProducto_2_6_1_1_1_1.setBounds(22, 414, 85, 28);
		lblProducto_2_6_1_1_1_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		MainBulkPanel.add(lblProducto_2_6_1_1_1_1);
		
		JLabel lblProducto_2_6_1_1_1_2 = new JLabel("Precio x Kilo $");
		lblProducto_2_6_1_1_1_2.setBounds(173, 334, 117, 28);
		lblProducto_2_6_1_1_1_2.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		MainBulkPanel.add(lblProducto_2_6_1_1_1_2);
		
		JLabel lblProducto_2_6_1_1_2 = new JLabel("(F5)");
		lblProducto_2_6_1_1_2.setBounds(550, 249, 57, 28);
		lblProducto_2_6_1_1_2.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		MainBulkPanel.add(lblProducto_2_6_1_1_2);
		
		JLabel lblProducto_2_6_1_1_2_1 = new JLabel("(ENTER)");
		lblProducto_2_6_1_1_2_1.setBounds(392, 412, 57, 28);
		lblProducto_2_6_1_1_2_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		MainBulkPanel.add(lblProducto_2_6_1_1_2_1);
		
		txtBulkProductSelected = new JTextField();
		txtBulkProductSelected.setBounds(23, 333, 132, 29);
		txtBulkProductSelected.setEnabled(false);
		txtBulkProductSelected.setColumns(10);
		MainBulkPanel.add(txtBulkProductSelected);
		
		JPanel bulkSalePanel = new JPanel();
		bulkSalePanel.setBounds(23, 144, 388, 135);
		MainBulkPanel.add(bulkSalePanel);
		bulkSalePanel.setLayout(new BorderLayout(0, 0));
		
	    scrollBulkSale = new JScrollPane();
	    bulkSalePanel.add(scrollBulkSale, BorderLayout.CENTER);
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
	    lblProducto_2_6_1_1_3.setBounds(195, 375, 57, 28);
	    lblProducto_2_6_1_1_3.setFont(new Font("Lucida Bright", Font.BOLD, 14));
	    MainBulkPanel.add(lblProducto_2_6_1_1_3);
	    
	    txtBulkSaleId = new JTextField();
	    txtBulkSaleId.setBounds(47, 292, 34, 29);
	    txtBulkSaleId.setEnabled(false);
	    txtBulkSaleId.setColumns(10);
	    MainBulkPanel.add(txtBulkSaleId);
	    
	    JLabel lblProducto_2_6_1_1_1_3 = new JLabel("Id:");
	    lblProducto_2_6_1_1_1_3.setBounds(23, 291, 25, 28);
	    lblProducto_2_6_1_1_1_3.setFont(new Font("Lucida Bright", Font.BOLD, 14));
	    MainBulkPanel.add(lblProducto_2_6_1_1_1_3);
	    
	    txtBulkSaleStock = new JTextField();
	    txtBulkSaleStock.setBounds(165, 291, 101, 29);
	    txtBulkSaleStock.setEnabled(false);
	    txtBulkSaleStock.setColumns(10);
	    MainBulkPanel.add(txtBulkSaleStock);
	    
	    JLabel lblProducto_2_6_1_1_1_3_1 = new JLabel("Stock:");
	    lblProducto_2_6_1_1_1_3_1.setBounds(119, 291, 49, 28);
	    lblProducto_2_6_1_1_1_3_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
	    MainBulkPanel.add(lblProducto_2_6_1_1_1_3_1);
	
	}
}
