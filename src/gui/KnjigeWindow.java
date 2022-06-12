package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KnjigeWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField id;
	private JTextField naslov;
	private JTextField orgNaslov;
	private JTextField pisac;
	private JTextField godinaIzdavanja;
	private JTextField jezik;
	private JTextField zanr;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KnjigeWindow frame = new KnjigeWindow();
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
	public KnjigeWindow() {
		setTitle("Knjige");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1019, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 255));
		panel.setBounds(0, 0, 1003, 449);
		contentPane.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 11, 657, 396);
		panel.add(table);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setBounds(716, 14, 46, 14);
		panel.add(lblNewLabel);
		
		id = new JTextField();
		id.setBounds(797, 11, 184, 20);
		panel.add(id);
		id.setColumns(10);
		
		JButton btnNewButton = new JButton("Ukloni");
		btnNewButton.setBounds(892, 359, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Dodaj");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1.setBounds(793, 415, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Azuriraj");
		btnNewButton_2.setBounds(793, 359, 89, 23);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Naslov");
		lblNewLabel_1.setBounds(716, 45, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Org Naslov");
		lblNewLabel_2.setBounds(716, 76, 71, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Pisac");
		lblNewLabel_4.setBounds(716, 107, 46, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Godina izdavanja");
		lblNewLabel_5.setBounds(716, 139, 71, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Jezik");
		lblNewLabel_5_1.setBounds(716, 167, 46, 14);
		panel.add(lblNewLabel_5_1);
		
		naslov = new JTextField();
		naslov.setBounds(797, 42, 184, 20);
		panel.add(naslov);
		naslov.setColumns(10);
		
		orgNaslov = new JTextField();
		orgNaslov.setColumns(10);
		orgNaslov.setBounds(797, 73, 184, 20);
		panel.add(orgNaslov);
		
		pisac = new JTextField();
		pisac.setColumns(10);
		pisac.setBounds(797, 104, 184, 20);
		panel.add(pisac);
		
		godinaIzdavanja = new JTextField();
		godinaIzdavanja.setColumns(10);
		godinaIzdavanja.setBounds(797, 136, 184, 20);
		panel.add(godinaIzdavanja);
		
		jezik = new JTextField();
		jezik.setColumns(10);
		jezik.setBounds(797, 164, 184, 20);
		panel.add(jezik);
		
		JLabel lblNewLabel_6 = new JLabel("Opis");
		lblNewLabel_6.setBounds(716, 231, 46, 14);
		panel.add(lblNewLabel_6);
		
		JTextArea opis = new JTextArea();
		opis.setBounds(797, 232, 184, 116);
		panel.add(opis);
		
		zanr = new JTextField();
		zanr.setBounds(797, 195, 184, 20);
		panel.add(zanr);
		zanr.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Zanr");
		lblNewLabel_3.setBounds(716, 198, 46, 14);
		panel.add(lblNewLabel_3);
	}
}
