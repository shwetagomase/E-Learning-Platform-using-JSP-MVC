package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CourseDao 
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
	
	public int insert(Course u) throws SQLException, ClassNotFoundException
	{
		String sql="insert into courses (coursetitle, instructor, category, totalenroll, fees, imgurl)values(?,?,?,?,?,?)";
		con=getConnect();
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, u.getCoursetitle());
		ps.setString(2, u.getInstructor());
		ps.setString(3, u.getCategory());
		ps.setString(4, u.getTotalenroll());
		ps.setString(5, u.getFees());
		ps.setString(6, u.getImgurl());

		int a=ps.executeUpdate();
		return a;	
	}
	
	
}
