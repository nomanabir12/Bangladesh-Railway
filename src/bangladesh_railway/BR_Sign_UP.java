/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bangladesh_railway;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Hossain_T.I.R
 */
public class BR_Sign_UP extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
                        @Override
			public void run() {
				try {
					BR_Sign_UP frame = new BR_Sign_UP();
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
	
	Connection connection = null;
	private JTextField username;
	private JTextField address;
	private JTextField phone;
	private JTextField pname;
	private JTextField email;
	private JPasswordField password;
	
	public BR_Sign_UP() {
		connection = sqliteConnection.dbconnector();
		setType(Type.POPUP);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 923, 621);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BANGLADESH RAILWAY");
		lblNewLabel.setBounds(135, 31, 473, 45);
		lblNewLabel.setForeground(new Color(0, 153, 102));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 43));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BANGLADESH RAILWAY E-TICKETING SERVICE");
		lblNewLabel_1.setBounds(135, 74, 383, 23);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(60, 11, 65, 86);
		lblNewLabel_2.setIcon(new ImageIcon("E:\\Man Information\\Rifat Hossain\\My Poftfolio\\JavaFX\\Bangladesh-Railway\\Bangladesh Railway\\logo.png"));
		contentPane.add(lblNewLabel_2);
		
		JLabel label = new JLabel("");
		label.setBounds(725, 16, 150, 82);
		label.setIcon(new ImageIcon("E:\\Man Information\\Rifat Hossain\\My Poftfolio\\JavaFX\\Bangladesh-Railway\\Bangladesh Railway\\cns.png"));
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBounds(32, 167, 852, 420);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 22, 450, 368);
		panel.add(panel_1);
		panel_1.setLayout(null);
		


		
		JLabel lblNewLabel_5 = new JLabel("Username");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_5.setBounds(26, 38, 159, 36);
		panel_1.add(lblNewLabel_5);
		
		username = new JTextField();
		username.setBounds(26, 74, 359, 26);
		panel_1.add(username);
		username.setColumns(10);
		
		JLabel pass_lbl = new JLabel("Password");
		pass_lbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		pass_lbl.setBounds(26, 257, 114, 36);
		panel_1.add(pass_lbl);
		
		JLabel lblPessengerFullName = new JLabel("Passenger Full Name");
		lblPessengerFullName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPessengerFullName.setBounds(26, 111, 213, 36);
		panel_1.add(lblPessengerFullName);
		
		pname = new JTextField();
		pname.setColumns(10);
		pname.setBounds(26, 147, 359, 26);
		panel_1.add(pname);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(26, 220, 359, 26);
		panel_1.add(email);
		
		JLabel lblEmailAddress = new JLabel("Email Address");
		lblEmailAddress.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblEmailAddress.setBounds(26, 184, 127, 36);
		panel_1.add(lblEmailAddress);
		
		password = new JPasswordField();
		password.setBounds(26, 296, 359, 26);
		panel_1.add(password);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(479, 22, 363, 279);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(10, 24, 343, 23);
		lblNewLabel_4.setBorder(new TitledBorder(null, "FARE QUERY RESULT", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 100, 0)));
		panel_2.add(lblNewLabel_4);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAddress.setBounds(10, 49, 343, 36);
		panel_2.add(lblAddress);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(10, 85, 343, 85);
		panel_2.add(address);
		
		JLabel lblCellphoneNumber = new JLabel("CellPhone Number");
		lblCellphoneNumber.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblCellphoneNumber.setBounds(10, 181, 343, 36);
		panel_2.add(lblCellphoneNumber);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(10, 217, 343, 26);
		panel_2.add(phone);
		
		JButton btnNewButton_1 = new JButton("REGISTER");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "insert into login (Username, PFullname, Email, Password, Address, Phone) values (?,?,?,?,?,?)";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, username.getText());
					pst.setString(2, pname.getText());
					pst.setString(3, email.getText());
					pst.setString(4, password.getText());
					pst.setString(5, address.getText());
					pst.setString(6, phone.getText());
					pst.execute();
					pst.close();
					JOptionPane.showMessageDialog(null, "Success");
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(478, 312, 126, 32);
		panel.add(btnNewButton_1);
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_1.setBackground(new Color(60, 179, 113));
		
		JLabel lblNewLabel_3 = new JLabel("If You Have an Account With us, Please");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(479, 354, 234, 25);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton_2 = new JButton("Sign IN");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				BR_Login login = new BR_Login();
				login.setVisible(true);
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(60, 179, 113));
		btnNewButton_2.setBounds(701, 355, 89, 23);
		panel.add(btnNewButton_2);

	}
}
