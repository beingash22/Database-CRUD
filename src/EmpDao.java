
import java.sql.*;
import java.util.*;

public class EmpDao {

	public static Connection getConnection()
	{
		Connection con=null;
		
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/login","root","");
		}
		catch(Exception e){System.out.println (e.getMessage());
	}
		return con;
}
	
	public static int save(Emp e)
	{
		int status=0;
try
{
	Connection con=getConnection();
		PreparedStatement st=con.prepareStatement("insert into register values(?,?,?,?)");
		st.setInt(1,e.getId());
		st.setString(2,e.getName());
		st.setString(3,e.getPass());
		st.setString(4,e.getEmail());
		status=st.executeUpdate();
		st.close();
		con.close();
	}
catch(Exception p){
	p.printStackTrace();
}
return status;
}
	public static int update(Emp e)
	{
		int status=0;
		try
		{
			Connection con=getConnection();
				PreparedStatement st=con.prepareStatement("update register set name=?,password=?,email=? where id=?");
				st.setInt(1,e.getId());
				st.setString(2,e.getName());
				st.setString(3,e.getPass());
				st.setString(4,e.getEmail());
				status=st.executeUpdate();
				st.close();
				con.close();
			}
		catch(Exception p){
			p.printStackTrace();
		}
		return status;
	}
	
	public static int delete(int id)
	{
		int status=0;
		try
		{
			Connection con=getConnection();
				PreparedStatement st=con.prepareStatement("delete from register where id=?");
				st.setInt(1,id);
				status=st.executeUpdate();
				
				st.close();
				con.close();
			}
		catch(Exception p){
			p.printStackTrace();
		}
		return status;
	}
	public static List<Emp> list()
	{
		List<Emp> li=new ArrayList<Emp>();
		
		try
		{
			Connection con=getConnection();
				PreparedStatement st=con.prepareStatement("select * from register");
				ResultSet rs=st.executeQuery();
						while(rs.next())
						{Emp e=new Emp();
							e.setId(rs.getInt(1));
							e.setName(rs.getString(2));
							e.setPass(rs.getString(3));
							e.setEmail(rs.getString(4));
							li.add(e);
						}
				st.close();
				rs.close();
				con.close();
			}
		catch(Exception p){
			p.printStackTrace();
		}
		return li;
	}
	public static Emp select(int id)
	{
		Emp e=new Emp();
		try
		{
			Connection con=getConnection();
				PreparedStatement st=con.prepareStatement("select * from register where id=?");
				st.setInt(1,id);
				ResultSet rs=st.executeQuery();
						while(rs.next())
						{
							e.setId(rs.getInt(1));
							e.setName(rs.getString(2));
							e.setPass(rs.getString(3));
							e.setEmail(rs.getString(4));
						}
				st.close();
				rs.close();
				con.close();
			}
		catch(Exception p){
			p.printStackTrace();
		}
		return e;
	}
	}
