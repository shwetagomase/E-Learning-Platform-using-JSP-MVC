package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao 
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
		
		public int insert(Admin u) throws SQLException, ClassNotFoundException
		{
			String sql="insert into courses (cname, cauthor, ccertificate, cprice)values(?,?,?,?)";
			con=getConnect();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, u.getCname());
			ps.setString(2, u.getCauthor());
			ps.setString(3, u.getCcertificate());
			ps.setString(4, u.getCprice());

			int a=ps.executeUpdate();
			return a;	
		}
		
		public int courseCount() throws SQLException, ClassNotFoundException
		{
			String sql="select count(*) from courses ";
			con=getConnect();
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
	rs.next();
	        int count =rs.getInt(1);
	con.close();
			return count;
		}
	/*	public boolean checkUser(String email,String pass) throws SQLException, ClassNotFoundException
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

		public boolean checkEmail(String email) throws SQLException, ClassNotFoundException
		{
			String sql="select * from user where email=? ";
			con=getConnect();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();

	        boolean a=rs.absolute(1);

			return a;
		}

		*/
	}

