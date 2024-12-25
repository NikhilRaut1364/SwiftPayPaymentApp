package test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Email {
	String sql="select * from user where email=?";
	String url="jdbc:ucanaccess://E://Database//swiftpay.accdb";
	public boolean check(String email) throws SQLException
	{
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			Connection con=DriverManager.getConnection(url);
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1,email);
			ResultSet rs=st.executeQuery();
			if(rs.next())
			{
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
}
