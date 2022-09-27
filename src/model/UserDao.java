package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

	static Connection con;
	private static Connection getConnect() throws ClassNotFoundException, SQLException 
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

	public int studentCount() throws SQLException, ClassNotFoundException
	{
		String sql="select count(*) from user ";
		con=getConnect();
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
rs.next();
        int count =rs.getInt(1);
con.close();
		return count;
	}
	
	public List<User> geAllUser() throws SQLException, ClassNotFoundException
	{
		String sql="select * from user ";
		con=getConnect();
		PreparedStatement ps=con.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		
		List<User> uls=new ArrayList<User>();
		
		while(rs.next())
		{
			User u=new User();
			u.setUid(rs.getInt(1));
			u.setName(rs.getString(2));
			u.setEmail(rs.getString(3));
			u.setPassword(rs.getString(4));
			
			uls.add(u);
		}				
   con.close();
    return uls;
	}
	
	}



