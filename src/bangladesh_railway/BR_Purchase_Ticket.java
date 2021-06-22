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
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
public class BR_Purchase_Ticket extends JFrame {

	private JPanel contentPane;
	private JComboBox station_from;
	private JComboBox journey_date;
	private JComboBox station_to;
	private JComboBox class_name;
	private JLabel departuretime;
	private JLabel childno;
	private JLabel adultno;
	private JLabel classname;
	private JLabel train_name_field;
	private JButton reserve_now_btn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BR_Purchase_Ticket frame = new BR_Purchase_Ticket();
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
	
	
	private void purchase_ticket()
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
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public BR_Purchase_Ticket() {
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
		});
		btnDashboard_1.setForeground(SystemColor.menu);
		btnDashboard_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnDashboard_1.setBorderPainted(true);
		btnDashboard_1.setBorder(null);
		btnDashboard_1.setBackground(new Color(60, 179, 113));
		contentPane.add(btnDashboard_1);
		
		JButton btnDashboard_2 = new JButton("Purchase Ticket");
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
		btnNewButton.setBounds(746, 89, 129, 33);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(32, 167, 852, 420);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(81, 11, 681, 288);
		panel.add(panel_1);
		panel_1.setLayout(null);
		


		
		JLabel lblNewLabel_5 = new JLabel("Station From :");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_5.setBounds(99, 24, 114, 36);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblStationFrom = new JLabel("Journey Date :");
		lblStationFrom.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblStationFrom.setBounds(99, 62, 114, 36);
		panel_1.add(lblStationFrom);
		
		JLabel lblTrainName = new JLabel("Class :");
		lblTrainName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTrainName.setBounds(99, 137, 114, 36);
		panel_1.add(lblTrainName);
		
		JLabel lblStationTo = new JLabel("Station To :");
		lblStationTo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblStationTo.setBounds(99, 99, 114, 36);
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
		station_from.setBounds(297, 24, 266, 26);
		panel_1.add(station_from);
		
		journey_date = new JComboBox();
		journey_date.setBounds(297, 62, 266, 26);
		panel_1.add(journey_date);
		
		station_to = new JComboBox();
		station_to.setBounds(297, 99, 266, 26);
		panel_1.add(station_to);
		
		class_name = new JComboBox();
		class_name.setBounds(297, 137, 266, 26);
		panel_1.add(class_name);
		
		
		JButton btnNewButton_1 = new JButton("Search Train");
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
						JOptionPane.showMessageDialog(null, "Found");
						train_name_field.setText("Turna Express");
						classname.setText("Shovon");
						departuretime.setText("12.00");
						adultno.setText("2 (Max)");
						childno.setText("2 (Max)");
						reserve_now_btn.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Train Not Available with Your date");
						train_name_field.setText("");
						classname.setText("");
						departuretime.setText("");
						adultno.setText("");
						childno.setText("");
						reserve_now_btn.setVisible(false);
					}

				}
				
				else if(w.equals("Dhaka") && x.equals("Mirpur") && z.equals("Shovon_Chair"))
				{
					if (y.equals("01-12-2017"))
					{
						JOptionPane.showMessageDialog(null, "Found");
						train_name_field.setText("Dhaka Mohanogor");
						classname.setText("Shovon");
						departuretime.setText("12.00");
						adultno.setText("2 (Max)");
						childno.setText("2 (Max)");
						reserve_now_btn.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Train Not Available with Your date");
						train_name_field.setText("");
						classname.setText("");
						departuretime.setText("");
						adultno.setText("");
						childno.setText("");
						reserve_now_btn.setVisible(false);
					}

				}
				
				else if(w.equals("Dhaka") && x.equals("Mirpur") && z.equals("Shovon_Chair"))
				{
					if (y.equals("02-12-2017"))
					{
						JOptionPane.showMessageDialog(null, "Found");
						train_name_field.setText("Tungipara Express");
						classname.setText("Shovon");
						departuretime.setText("12.00");
						adultno.setText("2 (Max)");
						childno.setText("2 (Max)");
						reserve_now_btn.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Train Not Available with Your date");
						train_name_field.setText("");
						classname.setText("");
						departuretime.setText("");
						adultno.setText("");
						childno.setText("");
						reserve_now_btn.setVisible(false);
					}

				}
				else
				{
					JOptionPane.showMessageDialog(null, "Train Not Available");
					train_name_field.setText("");
					classname.setText("");
					departuretime.setText("");
					adultno.setText("");
					childno.setText("");
					reserve_now_btn.setVisible(false);
				}
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_1.setBackground(new Color(60, 179, 113));
		btnNewButton_1.setBounds(378, 174, 157, 32);
		panel_1.add(btnNewButton_1);
		
		JLabel lblTrainName_1 = new JLabel("Train Name",SwingConstants.CENTER);
		lblTrainName_1.setOpaque(true);
		lblTrainName_1.setForeground(new Color(0, 0, 0));
		lblTrainName_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTrainName_1.setBackground(SystemColor.controlShadow);
		lblTrainName_1.setBounds(0, 232, 170, 21);
		panel_1.add(lblTrainName_1);
		
		JLabel lblClass = new JLabel("Class", SwingConstants.CENTER);
		lblClass.setOpaque(true);
		lblClass.setForeground(new Color(0, 0, 0));
		lblClass.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblClass.setBackground(SystemColor.controlShadow);
		lblClass.setBounds(169, 232, 64, 21);
		panel_1.add(lblClass);
		
		JLabel lblDepartureTime = new JLabel("Departure Time", SwingConstants.CENTER);
		lblDepartureTime.setOpaque(true);
		lblDepartureTime.setForeground(new Color(0, 0, 0));
		lblDepartureTime.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDepartureTime.setBackground(SystemColor.controlShadow);
		lblDepartureTime.setBounds(232, 232, 146, 21);
		panel_1.add(lblDepartureTime);
		
		JLabel lblSelection = new JLabel("Selection", SwingConstants.CENTER);
		lblSelection.setOpaque(true);
		lblSelection.setForeground(new Color(0, 0, 0));
		lblSelection.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSelection.setBackground(SystemColor.controlShadow);
		lblSelection.setBounds(535, 232, 146, 21);
		panel_1.add(lblSelection);
		
		JLabel lblChild = new JLabel("Child", SwingConstants.CENTER);
		lblChild.setOpaque(true);
		lblChild.setForeground(new Color(0, 0, 0));
		lblChild.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblChild.setBackground(SystemColor.controlShadow);
		lblChild.setBounds(457, 232, 78, 21);
		panel_1.add(lblChild);
		
		JLabel lblAdult = new JLabel("Adult", SwingConstants.CENTER);
		lblAdult.setOpaque(true);
		lblAdult.setForeground(new Color(0, 0, 0));
		lblAdult.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblAdult.setBackground(SystemColor.controlShadow);
		lblAdult.setBounds(378, 232, 85, 21);
		panel_1.add(lblAdult);
		
		childno = new JLabel("", SwingConstants.CENTER);
		childno.setOpaque(true);
		childno.setForeground(Color.WHITE);
		childno.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		childno.setBackground(new Color(60, 179, 113));
		childno.setBounds(457, 252, 88, 36);
		panel_1.add(childno);
		
		adultno = new JLabel("", SwingConstants.CENTER);
		adultno.setOpaque(true);
		adultno.setForeground(Color.WHITE);
		adultno.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		adultno.setBackground(new Color(60, 179, 113));
		adultno.setBounds(378, 252, 85, 36);
		panel_1.add(adultno);
		
		departuretime = new JLabel("", SwingConstants.CENTER);
		departuretime.setOpaque(true);
		departuretime.setForeground(Color.WHITE);
		departuretime.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		departuretime.setBackground(new Color(60, 179, 113));
		departuretime.setBounds(232, 252, 146, 36);
		panel_1.add(departuretime);
		
		classname = new JLabel("", SwingConstants.CENTER);
		classname.setOpaque(true);
		classname.setForeground(Color.WHITE);
		classname.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		classname.setBackground(new Color(60, 179, 113));
		classname.setBounds(169, 252, 64, 36);
		panel_1.add(classname);
		
		train_name_field = new JLabel("", SwingConstants.CENTER);
		train_name_field.setOpaque(true);
		train_name_field.setForeground(Color.WHITE);
		train_name_field.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		train_name_field.setBackground(new Color(60, 179, 113));
		train_name_field.setBounds(0, 252, 170, 36);
		panel_1.add(train_name_field);
		
		reserve_now_btn = new JButton("Reserve Now");
		reserve_now_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reserve_now_btn.setBackground(new Color(0, 128, 0));
				JOptionPane.showMessageDialog(null, "Reservation Successfull");
				
			}
		});
		reserve_now_btn.setVisible(false);
		reserve_now_btn.setForeground(new Color(255, 255, 255));
		reserve_now_btn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		reserve_now_btn.setBackground(new Color(60, 179, 113));
		reserve_now_btn.setBounds(545, 252, 136, 36);
		panel_1.add(reserve_now_btn);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(60, 179, 113));
		panel_2.setBounds(0, 252, 681, 36);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
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
		
		purchase_ticket();
	}
}
