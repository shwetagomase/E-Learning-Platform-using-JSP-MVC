package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MentorDao 
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
	
	public int insert(Mentor u) throws SQLException, ClassNotFoundException
	{
		String sql="insert into mentors (mname, memail, maddress, mno)values(?,?,?,?)";
		con=getConnect();
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, u.getMname());
		ps.setString(2, u.getMemail());
		ps.setString(3, u.getMaddress());
		ps.setString(4, u.getMno());

		int a=ps.executeUpdate();
		return a;	
	}
	
	public int mentorCount() throws SQLException, ClassNotFoundException
	{
		String sql="select count(*) from mentors ";
		con=getConnect();
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
rs.next();
        int count =rs.getInt(1);
con.close();
		return count;
	}

}
