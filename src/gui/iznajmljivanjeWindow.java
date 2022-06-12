package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class iznajmljivanjeWindow extends JFrame {

	private JPanel contentPane;
	private JTextField zaposleni;
	private JTextField clan;
	private JTextField datumIznajmljivanja;
	private JTextField primerak;
	private JTextField datumVracanja;
	private JTextField naslovKnjige;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					iznajmljivanjeWindow frame = new iznajmljivanjeWindow();
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
	public iznajmljivanjeWindow() {
		setTitle("Izdavanje");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 255));
		panel.setBounds(0, 0, 609, 352);
		contentPane.add(panel);
		panel.setLayout(null);
		
		zaposleni = new JTextField();
		zaposleni.setBounds(10, 117, 142, 20);
		panel.add(zaposleni);
		zaposleni.setColumns(10);
		
		clan = new JTextField();
		clan.setBounds(10, 199, 142, 20);
		panel.add(clan);
		clan.setColumns(10);
		
		datumIznajmljivanja = new JTextField();
		datumIznajmljivanja.setBounds(238, 117, 142, 20);
		panel.add(datumIznajmljivanja);
		datumIznajmljivanja.setColumns(10);
		
		primerak = new JTextField();
		primerak.setBounds(238, 199, 142, 20);
		panel.add(primerak);
		primerak.setColumns(10);
		
		datumVracanja = new JTextField();
		datumVracanja.setBounds(438, 117, 142, 20);
		panel.add(datumVracanja);
		datumVracanja.setColumns(10);
		
		naslovKnjige = new JTextField();
		naslovKnjige.setBounds(438, 199, 142, 20);
		panel.add(naslovKnjige);
		naslovKnjige.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Zaposleni");
		lblNewLabel.setBounds(10, 93, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Clan");
		lblNewLabel_1.setBounds(10, 176, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Datum iznajmljivanja");
		lblNewLabel_2.setBounds(243, 93, 111, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Datum vracanja");
		lblNewLabel_3.setBounds(438, 92, 111, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Primerak");
		lblNewLabel_4.setBounds(238, 176, 46, 14);
		panel.add(lblNewLabel_4);
		
		JLabel dassdas = new JLabel("Naslov knjige");
		dassdas.setBounds(438, 176, 111, 14);
		panel.add(dassdas);
		
		JButton btnNewButton = new JButton("Iznajmi");
		btnNewButton.setBounds(460, 278, 111, 49);
		panel.add(btnNewButton);
	}

}
