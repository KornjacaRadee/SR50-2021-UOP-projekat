package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ClanoviWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClanoviWindow frame = new ClanoviWindow();
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
	public ClanoviWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 255));
		panel.setBounds(0, 0, 434, 318);
		contentPane.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 11, 227, 138);
		panel.add(table);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setBounds(247, 24, 46, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(328, 21, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Ukloni");
		btnNewButton.setBounds(119, 160, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Dodaj");
		btnNewButton_1.setBounds(10, 160, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Azuriraj");
		btnNewButton_2.setBounds(10, 227, 89, 23);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Ime");
		lblNewLabel_1.setBounds(247, 55, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Prezime");
		lblNewLabel_2.setBounds(247, 86, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Broj meseci");
		lblNewLabel_3.setBounds(247, 244, 71, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("JMBG");
		lblNewLabel_4.setBounds(247, 117, 46, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Broj cl karte");
		lblNewLabel_5.setBounds(247, 149, 71, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Tip Clanarine");
		lblNewLabel_5_1.setBounds(247, 177, 71, 14);
		panel.add(lblNewLabel_5_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(328, 52, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(328, 83, 86, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(328, 114, 86, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(328, 146, 86, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(328, 174, 86, 20);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setBounds(328, 241, 86, 20);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(328, 205, 86, 20);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Datum uplate");
		lblNewLabel_6.setBounds(247, 208, 71, 14);
		panel.add(lblNewLabel_6);
		
		textField_8 = new JTextField();
		textField_8.setBounds(328, 272, 86, 20);
		panel.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Aktivnost");
		lblNewLabel_7.setBounds(247, 275, 71, 14);
		panel.add(lblNewLabel_7);
	}
}
