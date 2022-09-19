package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

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
	
	public int insert(User u) throws SQLException, ClassNotFoundException
	{
		String sql="insert into user (name, email, password)values(?,?,?)";
		con=getConnect();
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, u.getName());
		ps.setString(2, u.getEmail());
		ps.setString(3, u.getPassword());

		int a=ps.executeUpdate();
		return a;	
	}
	public boolean checkUser(String email,String pass) throws SQLException, ClassNotFoundException
	{
		String sql="select * from user where email=? and password=?";
		con=getConnect();
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, pass);
		ResultSet rs=ps.executeQuery();

boolean a=rs.absolute(1);

		return a;
	}

}
