/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bangladesh_railway;

/**
 *
 * @author Hossain_T.I.R
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
public class BR_Reset_Password extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BR_Reset_Password frame = new BR_Reset_Password();
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
	private JTextField reset_new_email;
	
    String uname ="";
    String strpass= "";
    private JPasswordField reset_new_password;
	
	
	public BR_Reset_Password() {
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
		
		JPanel panel = new JPanel();
		panel.setBounds(32, 167, 852, 420);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(190, 60, 430, 243);
		panel.add(panel_1);
		panel_1.setLayout(null);
		


		
		JLabel lblNewLabel_5 = new JLabel("Email Address");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_5.setBounds(67, 24, 132, 36);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblStationFrom = new JLabel("New Password");
		lblStationFrom.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblStationFrom.setBounds(67, 106, 151, 36);
		panel_1.add(lblStationFrom);
		
		
		JButton btnNewButton_1 = new JButton("Reset Password");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					String query = "select * from login where Email=?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, reset_new_email.getText());
					uname = reset_new_email.getText();
					strpass = reset_new_password.getText();
					
					ResultSet rs = pst.executeQuery();
					int count = 0;
					while(rs.next()) {
						count = count+1;
					}
					if(count == 1)
					{
						JOptionPane.showMessageDialog(null, "Account Found");
						
						String query2 = "UPDATE login SET Password=? where Email=?";
						PreparedStatement pst2 = connection.prepareStatement(query2);
						pst2.setString(1, reset_new_password.getText());
						pst2.setString(2, reset_new_email.getText());
						pst2.executeUpdate();
	                    JOptionPane.showMessageDialog(null, "PASSWORD UPDATE SUCCESSFUL");
	                    pst2.close();
	                    
						
					}
					else if(count > 1)
					{
						JOptionPane.showMessageDialog(null, "Duplicate Username Found");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Incorrect");
					}
					rs.close();
					pst.close();
					
				}catch (Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_1.setBackground(new Color(60, 179, 113));
		btnNewButton_1.setBounds(132, 200, 174, 32);
		panel_1.add(btnNewButton_1);
		
		reset_new_email = new JTextField();
		reset_new_email.setBounds(67, 59, 306, 36);
		panel_1.add(reset_new_email);
		reset_new_email.setColumns(10);
		
		reset_new_password = new JPasswordField();
		reset_new_password.setBounds(67, 138, 306, 36);
		panel_1.add(reset_new_password);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Rifat Hossain\\Downloads\\login.gif"));
		label_1.setBounds(639, 107, 129, 152);
		panel.add(label_1);
		
		JLabel lblNewLabel_3 = new JLabel("If You have an Account With use, Please");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(252, 335, 237, 21);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("If You have no Account With use, Please");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(249, 367, 240, 21);
		panel.add(lblNewLabel_4);
		
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
		btnNewButton_2.setBounds(484, 335, 89, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Sign UP");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				BR_Sign_UP signup = new BR_Sign_UP();
				signup.setVisible(true);
			}
		});
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(60, 179, 113));
		btnNewButton_3.setBounds(484, 366, 89, 23);
		panel.add(btnNewButton_3);
	}
}
