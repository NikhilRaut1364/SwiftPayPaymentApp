package test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginUser {
	String sql="select * from user where username=? and password=?";
	String url="jdbc:ucanaccess://E://Database//swiftpay.accdb";
	public boolean check(String uname1,String pass1) throws SQLException
	{
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			Connection con=DriverManager.getConnection(url);
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, uname1);
			st.setString(2, pass1);
			ResultSet rs=st.executeQuery();
			if(rs.next())
			{
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
