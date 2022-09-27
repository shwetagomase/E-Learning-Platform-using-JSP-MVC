package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PurchaseDao 
{
	Connection con;
	private Connection getConnect() throws ClassNotFoundException, SQLException 
	{
		String db="jspmvc1";
		String url="jdbc:mysql://localhost:3306/"+db;
		String uname="root";
		String upass="root";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url, uname, upass);
		return con;
	}
	
	public int insert(Purchase u) throws SQLException, ClassNotFoundException
	{
		String sql="insert into purchase (pname, pmno)values(?,?)";
		con=getConnect();
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, u.getPname());
		ps.setString(2, u.getPmno());
		
		int a=ps.executeUpdate();
		return a;	
	}
	
	public int purchaseCount() throws SQLException, ClassNotFoundException
	{
		String sql="select count(*) from purchase ";
		con=getConnect();
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
rs.next();
        int count =rs.getInt(1);
con.close();
		return count;
	}

}
