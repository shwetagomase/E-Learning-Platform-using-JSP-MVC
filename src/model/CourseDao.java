package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	public Course geCourse(int cid) throws SQLException, ClassNotFoundException
	{
		String sql="select * from courses where cid="+cid;
		con=getConnect();
		PreparedStatement ps=con.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		Course c=new Course();
		if(rs.absolute(1))
		{
			c.setCoursetitle(rs.getString(2));
			c.setInstructor(rs.getString(3));
			c.setCategory(rs.getString(4));
			c.setTotalenroll(rs.getString(5));
			c.setFees(rs.getString(6));
			c.setImgurl(rs.getString(7));
		}
   con.close();
    return c;
	}

}
