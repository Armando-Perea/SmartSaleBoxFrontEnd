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
	private JTextField textField;
	private JTextField textField_1;
	private JTable tableBulkSale;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 495);
		BulkPane = new JPanel();
		BulkPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(BulkPane);
		BulkPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.window);
		BulkPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("@SmartSaleBox.");
		lblNewLabel_1_1_1.setBounds(340, 12, 188, 29);
		lblNewLabel_1_1_1.setFont(new Font("Lucida Bright", Font.BOLD, 24));
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblConsultaProducto_1 = new JLabel("Venta a Granel");
		lblConsultaProducto_1.setBounds(23, 29, 145, 22);
		lblConsultaProducto_1.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		panel.add(lblConsultaProducto_1);
		
		JLabel lblProducto_2_6 = new JLabel("Producto:");
		lblProducto_2_6.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_6.setBounds(23, 63, 85, 28);
		panel.add(lblProducto_2_6);
		
		JLabel lblProducto_2_6_1 = new JLabel("Código:");
		lblProducto_2_6_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_6_1.setBounds(326, 63, 85, 28);
		panel.add(lblProducto_2_6_1);
		
		textField = new JTextField();
		textField.setBounds(23, 103, 179, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(326, 103, 179, 29);
		panel.add(textField_1);
		
		JScrollPane bulkSalePane = new JScrollPane();
		bulkSalePane.setBounds(23, 171, 276, 174);
		panel.add(bulkSalePane);
		
		tableBulkSale = new JTable();
		bulkSalePane.setViewportView(tableBulkSale);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(326, 309, 101, 25);
		panel.add(btnLimpiar);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(340, 400, 101, 25);
		panel.add(btnIngresar);
		
		textField_2 = new JTextField();
		textField_2.setBounds(78, 357, 77, 29);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(221, 357, 77, 29);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(78, 398, 77, 29);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(222, 398, 77, 29);
		panel.add(textField_5);
		
		JLabel lblProducto_2_6_1_1 = new JLabel("Total $");
		lblProducto_2_6_1_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_6_1_1.setBounds(165, 398, 57, 28);
		panel.add(lblProducto_2_6_1_1);
		
		JLabel lblProducto_2_6_1_1_1 = new JLabel("Kilo gr");
		lblProducto_2_6_1_1_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_6_1_1_1.setBounds(23, 357, 57, 28);
		panel.add(lblProducto_2_6_1_1_1);
		
		JLabel lblProducto_2_6_1_1_1_1 = new JLabel("Venta:$");
		lblProducto_2_6_1_1_1_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_6_1_1_1_1.setBounds(23, 398, 57, 28);
		panel.add(lblProducto_2_6_1_1_1_1);
		
		JLabel lblProducto_2_6_1_1_1_2 = new JLabel("$");
		lblProducto_2_6_1_1_1_2.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_6_1_1_1_2.setBounds(205, 356, 19, 28);
		panel.add(lblProducto_2_6_1_1_1_2);
		
		JLabel lblProducto_2_6_1_1_2 = new JLabel("(F5)");
		lblProducto_2_6_1_1_2.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_6_1_1_2.setBounds(445, 306, 57, 28);
		panel.add(lblProducto_2_6_1_1_2);
		
		JLabel lblProducto_2_6_1_1_2_1 = new JLabel("(ENTER)");
		lblProducto_2_6_1_1_2_1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblProducto_2_6_1_1_2_1.setBounds(459, 397, 57, 28);
		panel.add(lblProducto_2_6_1_1_2_1);
	}

}
