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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JComboBox;
public class BR_Fare_Query extends JFrame {

	private JPanel contentPane;
	private JComboBox station_from;
	private JComboBox journey_date;
	private JComboBox station_to;
	private JComboBox class_name;
	private JLabel fare_result;
	private JButton fare_reserve;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BR_Fare_Query frame = new BR_Fare_Query();
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
	
	
	private void fare_query()
	{
		try {
			String query = "select * from purchase_ticket";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				station_from.addItem(rs.getString("Station_name"));
				journey_date.addItem(rs.getString("Journey_date"));
				station_to.addItem(rs.getString("Station_to"));
				class_name.addItem(rs.getString("Class_name"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	Connection connection = null;
	private JTextField textField;
	private JTextField textField_1;
	public BR_Fare_Query() {
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
			public void actionPerformed(ActionEvent e) {
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
				BR_Purchase_Ticket purchaseticket = new BR_Purchase_Ticket();
				purchaseticket.setVisible(true);
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
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				BR_Dashboard dashboard = new BR_Dashboard();
				dashboard.setVisible(true);
			}
		});
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(25, 11, 550, 288);
		panel.add(panel_1);
		panel_1.setLayout(null);
		


		
		JLabel lblNewLabel_5 = new JLabel("Station From :");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_5.setBounds(22, 27, 114, 36);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblStationFrom = new JLabel("Journey Date :");
		lblStationFrom.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblStationFrom.setBounds(22, 65, 114, 36);
		panel_1.add(lblStationFrom);
		
		JLabel lblTrainName = new JLabel("Class :");
		lblTrainName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTrainName.setBounds(22, 140, 114, 36);
		panel_1.add(lblTrainName);
		
		JLabel lblStationTo = new JLabel("Station To :");
		lblStationTo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblStationTo.setBounds(22, 102, 114, 36);
		panel_1.add(lblStationTo);
		
		station_from = new JComboBox();
		station_from.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "select * from purchase_ticket where Station_name=?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, (String)station_from.getSelectedItem());
					ResultSet rs = pst.executeQuery();
					while(rs.next())
					{
						station_from.setSelectedItem(rs.getString("Station_to"));
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		station_from.setBounds(170, 31, 266, 26);
		panel_1.add(station_from);
		
		journey_date = new JComboBox();
		journey_date.setBounds(170, 69, 266, 26);
		panel_1.add(journey_date);
		
		station_to = new JComboBox();
		station_to.setBounds(170, 106, 266, 26);
		panel_1.add(station_to);
		
		class_name = new JComboBox();
		class_name.setBounds(170, 144, 266, 26);
		panel_1.add(class_name);
		
		
		JButton btnNewButton_1 = new JButton("Fare Query");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String w = String.valueOf(station_from.getSelectedItem());
				String x = String.valueOf(station_to.getSelectedItem());
				String y = String.valueOf(journey_date.getSelectedItem());
				String z = String.valueOf(class_name.getSelectedItem());
				if(w.equals("Dhaka") && x.equals("Mirpur") && z.equals("Shovon"))
				{
					if (y.equals("01-12-2017"))
					{
						fare_result.setText("Your fare is: 300 tk");
						fare_reserve.setVisible(true);
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Train Not Available with Your date");
					}

				}
				else if(w.equals("Barishal") && x.equals("Mirpur") && z.equals("Shovon"))
				{
					if (y.equals("01-12-2017"))
					{
						fare_result.setText("Your fare is: 700 tk");
						fare_reserve.setVisible(true);
						
					}
					if (y.equals("02-12-2017"))
					{
						fare_result.setText("Your fare is: 600 tk");
						fare_reserve.setVisible(true);
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Train Not Available with Your date");
					}

				}
				
				else if(w.equals("Barishal") && x.equals("Shonirakhra") && z.equals("Shovon"))
				{
					if (y.equals("01-12-2017"))
					{
						fare_result.setText("Your fare is: 700 tk");
						fare_reserve.setVisible(true);
						
					}
					if (y.equals("02-12-2017"))
					{
						fare_result.setText("Your fare is: 900 tk");
						fare_reserve.setVisible(true);
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Train Not Available with Your date");
					}

				}
				
				else if(w.equals("Barishal") && x.equals("Shonirakhra") && z.equals("Shovon_Chair"))
				{
					if (y.equals("01-12-2017"))
					{
						fare_result.setText("Your fare is: 700 tk");
						fare_reserve.setVisible(true);
						
					}
					if (y.equals("02-12-2017"))
					{
						fare_result.setText("Your fare is: 1000 tk");
						fare_reserve.setVisible(true);
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Train Not Available with Your date");
					}

				}
				else
				{
					JOptionPane.showMessageDialog(null, "Train Not Available");
				}
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_1.setBackground(new Color(60, 179, 113));
		btnNewButton_1.setBounds(210, 216, 157, 32);
		panel_1.add(btnNewButton_1);
		
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(599, 11, 226, 165);
		panel.add(panel_2);
		
		JLabel lblFareQueryResult = new JLabel("Fare Query Result");
		lblFareQueryResult.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblFareQueryResult.setBounds(10, 21, 206, 36);
		panel_2.add(lblFareQueryResult);
		
		fare_result = new JLabel("");
		fare_result.setBounds(10, 68, 206, 45);
		panel_2.add(fare_result);
		
		fare_reserve = new JButton("Want to Purchase?");
		fare_reserve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				BR_Purchase_Ticket purchaseticket = new BR_Purchase_Ticket();
				purchaseticket.setVisible(true);
				
			}
		});
		fare_reserve.setBackground(new Color(60, 179, 113));
		fare_reserve.setVisible(false);
		fare_reserve.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		fare_reserve.setBounds(10, 118, 206, 36);
		panel_2.add(fare_reserve);
		
		fare_query();

	}
}
