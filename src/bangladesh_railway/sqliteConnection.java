/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bangladesh_railway;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Hossain_T.I.R
 */
public class sqliteConnection {
    	Connection conn=null;
	public static Connection dbconnector()
	{
		
		try
		{
			Class.forName("org.sqlite.JDBC");
			Connection conn = 	DriverManager.getConnection("jdbc:sqlite:E:\\Man Information\\Rifat Hossain\\My Poftfolio\\JavaFX\\Bangladesh-Railway\\Bangladesh Railway\\test.sqlite");
			JOptionPane.showMessageDialog(null, "Connection Successfull");
			return conn;
			
		}catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}
