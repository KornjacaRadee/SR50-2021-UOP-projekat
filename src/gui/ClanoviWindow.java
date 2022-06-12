package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import knjige.Biblioteka;
import ljudi.Admin;
import ljudi.Clan;
import ljudi.TipClanarine;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	DefaultTableModel model;

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
	Biblioteka biblioteka = new Biblioteka();
	public ClanoviWindow() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 255));
		panel.setBounds(0, 0, 849, 377);
		contentPane.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 204));
		table.setBounds(10, 11, 552, 340);
		model = new DefaultTableModel();
		Object[] column = {"ID","IME","PREZIME","ADRESA","JMBG","POL","BROJ CL KARTE","TIP CLANARINE","DATUM UPLATE", "MESECI CLAN","AKTIVAN"};
		Object[] row = new Object[11];
		model.setColumnIdentifiers(column);
		biblioteka.ucitajClanove();
        for(Clan clan : biblioteka.getClanovi()) {
        	
        	TipClanarine clanarina = new TipClanarine();
        	row[0] = clan.getId();
        	row[1] = clan.getIme();
        	row[2] = clan.getPrezime();
        	row[3] = clan.getAdresa();
        	row[4] = clan.getJMBG();
        	row[5] = clan.getPolovi();
        	row[6] = clan.getBrojClanskeKarte();
        	row[7] = "Decja";
        	row[8] = clan.getDatumUplate();
        	row[9] = clan.getBrojMeseci();
        	row[10] = clan.isAktivnost();
            model.addRow(row);
		}
		table.setModel(model);
		panel.add(table);
		
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setBounds(586, 24, 46, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(661, 24, 178, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Ukloni");
		btnNewButton.setBounds(639, 306, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Dodaj");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(738, 306, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Azuriraj");
		btnNewButton_2.setBounds(639, 343, 89, 23);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Ime");
		lblNewLabel_1.setBounds(586, 55, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Prezime");
		lblNewLabel_2.setBounds(586, 86, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Broj meseci");
		lblNewLabel_3.setBounds(586, 244, 71, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("JMBG");
		lblNewLabel_4.setBounds(586, 117, 46, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Broj cl karte");
		lblNewLabel_5.setBounds(586, 149, 71, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Tip Clanarine");
		lblNewLabel_5_1.setBounds(586, 177, 71, 14);
		panel.add(lblNewLabel_5_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(661, 55, 178, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(661, 86, 178, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(661, 117, 178, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(661, 149, 178, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(661, 177, 178, 20);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setBounds(661, 244, 178, 20);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(661, 208, 178, 20);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Datum uplate");
		lblNewLabel_6.setBounds(586, 208, 71, 14);
		panel.add(lblNewLabel_6);
		
		textField_8 = new JTextField();
		textField_8.setBounds(661, 275, 178, 20);
		panel.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Aktivnost");
		lblNewLabel_7.setBounds(586, 275, 71, 14);
		panel.add(lblNewLabel_7);
	}
}
