/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bangladesh_railway;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author Hossain_T.I.R
 */
public class BR_Login extends JFrame {

	private JPanel contentPane;
	private JTextField usernamefield;
	private JPasswordField passwordfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BR_Login frame = new BR_Login();
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
	Connection connection=null;
	String username = "";
	
	public BR_Login() {
		connection = sqliteConnection.dbconnector();
		setType(Type.POPUP);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 448);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(16, 108, 488, 297);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(3, 3, 4, 2);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("E:\\Man Information\\Rifat Hossain\\My Poftfolio\\JavaFX\\Bangladesh-Railway\\Bangladesh Railway\\1.jpg"));
		lblNewLabel_5.setBounds(1, 2, 485, 294);
		panel.add(lblNewLabel_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(506, 108, 291, 297);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		usernamefield = new JTextField();
		usernamefield.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
			}
			@Override
			public void focusLost(FocusEvent e) {
			}
		});
		usernamefield.setBounds(10, 28, 271, 28);
		panel_1.add(usernamefield);
		usernamefield.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					String query = "select * from login where username=? and password=?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, usernamefield.getText());
					pst.setString(2, passwordfield.getText());
					username = usernamefield.getText();
					
					ResultSet rs = pst.executeQuery();
					int count = 0;
					while(rs.next()) {
						count = count+1;
					}
					if(count == 1)
					{
						JOptionPane.showMessageDialog(null, "Successfully Login");
						BR_Dashboard new_dashboard = new BR_Dashboard();
						new_dashboard.setUser(username);
						dispose();
						new_dashboard.setVisible(true);
						
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
		btnNewButton.setForeground(new Color(0, 128, 0));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBounds(95, 108, 108, 33);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Forget Password");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				BR_Forget_Password forgetpass = new BR_Forget_Password();
				forgetpass.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setForeground(new Color(0, 128, 0));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_1.setBounds(10, 152, 142, 33);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Signup");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				BR_Sign_UP signup = new BR_Sign_UP();
				signup.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setForeground(new Color(0, 128, 0));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_2.setBounds(192, 152, 89, 33);
		panel_1.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("<html>Please note:<br>\r\n" + 
				"&nbsp;a) This site does not store Card Security Information <br>\r\n" + 
				"&nbsp;b) The site records your IP/Connection Details for security purpose only <br>\r\n" + 
				"&nbsp;c) Any illegal usage of this site is punishable  underCommon Law of Bangladesh<br></html>");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(11, 186, 271, 110);
		panel_1.add(lblNewLabel_3);
		
		passwordfield = new JPasswordField();
		passwordfield.setBounds(10, 77, 271, 28);
		panel_1.add(passwordfield);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(10, 11, 271, 14);
		panel_1.add(label_1);
		
		JLabel lblNewLabel_6 = new JLabel("Enter Username");
		lblNewLabel_6.setBounds(10, 11, 95, 14);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblEnterYourPassword = new JLabel("Enter Your Password");
		lblEnterYourPassword.setBounds(10, 63, 271, 14);
		panel_1.add(lblEnterYourPassword);
		
		JLabel lblNewLabel = new JLabel("BANGLADESH RAILWAY");
		lblNewLabel.setForeground(new Color(0, 153, 102));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 43));
		lblNewLabel.setBounds(91, 31, 572, 45);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BANGLADESH RAILWAY E-TICKETING SERVICE");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(91, 74, 572, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("E:\\Man Information\\Rifat Hossain\\My Poftfolio\\JavaFX\\Bangladesh-Railway\\Bangladesh Railway\\logo.png"));
		lblNewLabel_2.setBounds(16, 11, 65, 86);
		contentPane.add(lblNewLabel_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("E:\\Man Information\\Rifat Hossain\\My Poftfolio\\JavaFX\\Bangladesh-Railway\\Bangladesh Railway\\cns.png"));
		label.setBounds(625, 15, 172, 82);
		contentPane.add(label);
	}
}
