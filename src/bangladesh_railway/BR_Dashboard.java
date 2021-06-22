/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bangladesh_railway;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;

import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.*;
import java.awt.Panel;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import java.awt.Label;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Hossain_T.I.R
 */
public class BR_Dashboard extends JFrame {

	private JPanel contentPane;
	public JLabel username_field;
	public JLabel user_mobile;
	public JLabel user_full_name;
	public JLabel user_father;
	public JLabel user_address;
	public JLabel user_email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BR_Dashboard frame = new BR_Dashboard();
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
	
	String user = "";
	String Phone, Email, Address, PFullname;
	
	void setUser(String username) {
        user = username;
        try
		{
			String query = "select * from login where username=?";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, user);
			
			ResultSet rs = pst.executeQuery();
		        username_field.setText(user);
	            Phone = rs.getString("Phone");
	            user_mobile.setText(Phone);
	            Email = rs.getString("Email");
	            user_email.setText(Email);
	            Address = rs.getString("Address");
	            user_address.setText(Address);
	            PFullname = rs.getString("PFullname");
	            user_full_name.setText(PFullname);
				
			}
			
	catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
        
    }
	
	Connection connection = null;
	
	public BR_Dashboard() {
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
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Rifat Hossain\\Downloads\\logo.png"));
		contentPane.add(lblNewLabel_2);
		
		JLabel label = new JLabel("");
		label.setBounds(725, 16, 150, 82);
		label.setIcon(new ImageIcon("C:\\Users\\Rifat Hossain\\Downloads\\cns.png"));
		contentPane.add(label);
		
		JButton btnDashboard_1 = new JButton("Fare Query");
		btnDashboard_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				BR_Fare_Query brfare = new BR_Fare_Query();
				brfare.setVisible(true);
			}
		});
		btnDashboard_1.setBounds(251, 134, 215, 33);
		btnDashboard_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDashboard_1.setBackground(new Color(0, 0, 94));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDashboard_1.setBackground( new Color(60, 179, 113) );
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		btnDashboard_1.setForeground(SystemColor.menu);
		btnDashboard_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnDashboard_1.setBorderPainted(true);
		btnDashboard_1.setBorder(null);
		btnDashboard_1.setBackground(new Color(60, 179, 113));
		contentPane.add(btnDashboard_1);
		
		JButton btnDashboard_2 = new JButton("Purchase Ticket");
		btnDashboard_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				BR_Purchase_Ticket brticker = new BR_Purchase_Ticket();
				brticker.setVisible(true);
			}
		});
		btnDashboard_2.setBounds(471, 134, 212, 33);
		btnDashboard_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDashboard_2.setBackground(new Color(0, 0, 94));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDashboard_2.setBackground( new Color(60, 179, 113) );
			}
		});
		btnDashboard_2.setForeground(SystemColor.menu);
		btnDashboard_2.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnDashboard_2.setBorderPainted(true);
		btnDashboard_2.setBorder(null);
		btnDashboard_2.setBackground(new Color(60, 179, 113));
		contentPane.add(btnDashboard_2);
		
		JButton btnDashboard_3 = new JButton("Change Password");
		btnDashboard_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				BR_Forget_Password brchangepass = new BR_Forget_Password();
				brchangepass.setVisible(true);
			}
		});
		btnDashboard_3.setBounds(688, 133, 197, 33);
		btnDashboard_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDashboard_3.setBackground(new Color(0, 0, 94));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDashboard_3.setBackground( new Color(60, 179, 113) );
			}
		});
		btnDashboard_3.setForeground(SystemColor.menu);
		btnDashboard_3.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnDashboard_3.setBorderPainted(true);
		btnDashboard_3.setBorder(null);
		btnDashboard_3.setBackground(new Color(60, 179, 113));
		contentPane.add(btnDashboard_3);
		
		JButton btnDashboard = new JButton("Dashboard");
		btnDashboard.setBounds(31, 133, 216, 33);
		btnDashboard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnDashboard.setBackground(new Color(0, 0, 94));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnDashboard.setBackground( new Color(60, 179, 113) );
			}
		});
		btnDashboard.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
			}
		});
		btnDashboard.setForeground(SystemColor.menu);
		btnDashboard.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnDashboard.setBorderPainted(true);
		btnDashboard.setBorder(null);
		btnDashboard.setBackground(new Color(60, 179, 113));
		contentPane.add(btnDashboard);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				BR_Login login = new BR_Login();
				login.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBounds(746, 99, 129, 33);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(32, 167, 852, 420);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblPersonalInformation = new JLabel("Personal Information");
		lblPersonalInformation.setBorder(new EmptyBorder(0, 20, 0, 0));
		lblPersonalInformation.setForeground(new Color(255, 255, 255));
		lblPersonalInformation.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblPersonalInformation.setOpaque(true);
		lblPersonalInformation.setBackground(new Color(60, 179, 113));
		lblPersonalInformation.setBounds(52, 50, 728, 35);
		panel.add(lblPersonalInformation);
		
		
		JLabel lblNewLabel_3 = new JLabel("Username");
		lblNewLabel_3.setBorder(new EmptyBorder(0, 20, 0, 0));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(52, 96, 359, 26);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(105, 105, 105), 1, true));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(53, 97, 729, 170);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		username_field = new JLabel("");
		username_field.setOpaque(true);
		username_field.setFont(new Font("Times New Roman", Font.BOLD, 16));
		username_field.setBorder(new EmptyBorder(0, 20, 0, 0));
		username_field.setBackground(Color.WHITE);
		username_field.setBounds(369, 0, 359, 26);
		panel_1.add(username_field);
		
		JLabel father_name = new JLabel("Passenger Full Name");
		father_name.setOpaque(true);
		father_name.setFont(new Font("Times New Roman", Font.BOLD, 16));
		father_name.setBorder(new EmptyBorder(0, 20, 0, 0));
		father_name.setBackground(Color.WHITE);
		father_name.setBounds(0, 29, 359, 26);
		panel_1.add(father_name);
		
		JLabel label_3 = new JLabel("");
		label_3.setOpaque(true);
		label_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_3.setBorder(new LineBorder(new Color(211, 211, 211)));
		label_3.setBackground(new Color(169, 169, 169));
		label_3.setBounds(0, 28, 728, 1);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setOpaque(true);
		label_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_4.setBorder(new LineBorder(new Color(211, 211, 211)));
		label_4.setBackground(new Color(169, 169, 169));
		label_4.setBounds(0, 56, 728, 1);
		panel_1.add(label_4);
		
		user_full_name = new JLabel("");
		user_full_name.setOpaque(true);
		user_full_name.setFont(new Font("Times New Roman", Font.BOLD, 16));
		user_full_name.setBorder(new EmptyBorder(0, 20, 0, 0));
		user_full_name.setBackground(Color.WHITE);
		user_full_name.setBounds(369, 29, 359, 26);
		panel_1.add(user_full_name);
		
		JLabel label_6 = new JLabel("");
		label_6.setOpaque(true);
		label_6.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_6.setBorder(new LineBorder(new Color(211, 211, 211)));
		label_6.setBackground(new Color(169, 169, 169));
		label_6.setBounds(0, 85, 728, 1);
		panel_1.add(label_6);
		
		user_mobile = new JLabel("");
		user_mobile.setOpaque(true);
		user_mobile.setFont(new Font("Times New Roman", Font.BOLD, 16));
		user_mobile.setBorder(new EmptyBorder(0, 20, 0, 0));
		user_mobile.setBackground(Color.WHITE);
		user_mobile.setBounds(369, 86, 359, 26);
		panel_1.add(user_mobile);
		
		JLabel phone = new JLabel("Mobile Number");
		phone.setOpaque(true);
		phone.setFont(new Font("Times New Roman", Font.BOLD, 16));
		phone.setBorder(new EmptyBorder(0, 20, 0, 0));
		phone.setBackground(Color.WHITE);
		phone.setBounds(0, 86, 359, 26);
		panel_1.add(phone);
		
		JLabel label_9 = new JLabel("");
		label_9.setOpaque(true);
		label_9.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_9.setBorder(new LineBorder(new Color(211, 211, 211)));
		label_9.setBackground(new Color(169, 169, 169));
		label_9.setBounds(0, 113, 728, 1);
		panel_1.add(label_9);
		
		JLabel mother_name = new JLabel("Father Name");
		mother_name.setOpaque(true);
		mother_name.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mother_name.setBorder(new EmptyBorder(0, 20, 0, 0));
		mother_name.setBackground(Color.WHITE);
		mother_name.setBounds(0, 57, 359, 26);
		panel_1.add(mother_name);
		
		JLabel user_father = new JLabel("");
		user_father.setOpaque(true);
		user_father.setFont(new Font("Times New Roman", Font.BOLD, 16));
		user_father.setBorder(new EmptyBorder(0, 20, 0, 0));
		user_father.setBackground(Color.WHITE);
		user_father.setBounds(369, 57, 359, 26);
		panel_1.add(user_father);
		
		JLabel label_12 = new JLabel("");
		label_12.setOpaque(true);
		label_12.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_12.setBorder(new LineBorder(new Color(211, 211, 211)));
		label_12.setBackground(new Color(169, 169, 169));
		label_12.setBounds(0, 142, 728, 1);
		panel_1.add(label_12);
		
		user_address = new JLabel("");
		user_address.setOpaque(true);
		user_address.setFont(new Font("Times New Roman", Font.BOLD, 16));
		user_address.setBorder(new EmptyBorder(0, 20, 0, 0));
		user_address.setBackground(Color.WHITE);
		user_address.setBounds(369, 143, 359, 26);
		panel_1.add(user_address);
		
		JLabel address = new JLabel("Address");
		address.setOpaque(true);
		address.setFont(new Font("Times New Roman", Font.BOLD, 16));
		address.setBorder(new EmptyBorder(0, 20, 0, 0));
		address.setBackground(Color.WHITE);
		address.setBounds(0, 143, 359, 26);
		panel_1.add(address);
		
		JLabel label_15 = new JLabel("");
		label_15.setOpaque(true);
		label_15.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_15.setBorder(new LineBorder(new Color(211, 211, 211)));
		label_15.setBackground(new Color(169, 169, 169));
		label_15.setBounds(0, 170, 728, 1);
		panel_1.add(label_15);
		
		JLabel email = new JLabel("Email Address");
		email.setOpaque(true);
		email.setFont(new Font("Times New Roman", Font.BOLD, 16));
		email.setBorder(new EmptyBorder(0, 20, 0, 0));
		email.setBackground(Color.WHITE);
		email.setBounds(0, 114, 359, 26);
		panel_1.add(email);
		
		user_email = new JLabel("");
		user_email.setOpaque(true);
		user_email.setFont(new Font("Times New Roman", Font.BOLD, 16));
		user_email.setBorder(new EmptyBorder(0, 20, 0, 0));
		user_email.setBackground(Color.WHITE);
		user_email.setBounds(369, 114, 359, 26);
		panel_1.add(user_email);
		
		JLabel label_18 = new JLabel("");
		label_18.setForeground(new Color(192, 192, 192));
		label_18.setBounds(363, -7, 1, 185);
		panel_1.add(label_18);
		label_18.setOpaque(true);
		label_18.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_18.setBorder(new LineBorder(new Color(211, 211, 211), 1, true));
		label_18.setBackground(new Color(169, 169, 169));
		
		JLabel label_2 = new JLabel("*** The unsuccessful purchases will be refunded to respective cards/mobile wallet within 8 working days by the respective issuer bank. ***",SwingConstants.CENTER);
		label_2.setForeground(new Color(255, 0, 0));
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		label_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		label_2.setBounds(25, 332, 790, 66);
		panel.add(label_2);
		
		JLabel lblRefundPolicy = new JLabel("REFUND POLICY",SwingConstants.CENTER);
		lblRefundPolicy.setBackground(new Color(60, 179, 113));
		lblRefundPolicy.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblRefundPolicy.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblRefundPolicy.setBounds(346, 310, 167, 24);
		panel.add(lblRefundPolicy);

	}
}
