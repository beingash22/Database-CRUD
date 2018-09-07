

import java.io.IOException;
import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServ")
public class ViewServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	
		out.print("<html>");
		out.print("<head>");
		out.print("<style type='text/css'>");
		out.print("#logo{position:absolute;left:77%;top:130px;}body{ background-color:#5f9ea0 }li {    float: left;}li a {    display: block;    color: white;    text-align: center;    padding: 16px;    text-decoration: none;}li a:hover {    background-color: #111111;}ul {list-style-type: none;margin: 10;padding: 2;overflow: auto;background-color: #333333;");
		out.print("</style>");
		out.print("</head>");
		out.print("<body>");
		out.println("<img id='logo' src='image.png' alt='logo' height='300' width='250'>");
		out.print("<ul><li><a href='#home'>Home</a></li><li><a href='#news'>News</a></li><li><a href='#contact'>Contact</a></li><li><a href='#about'>About</a></li></ul>");
		
		out.print("<h1>Employee details</h1>");
		List<Emp> li=EmpDao.list();
		
		out.print("<table>");
		out.print("<tr><th>Id&nbsp;</th><th>Name&nbsp;</th><th>Password&nbsp;</th><th>Email&nbsp;</th><th>Edit&nbsp;</th><th>Delete&nbsp;</th></tr>");
		for (Emp e:li)
		{
			out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getPass()+"</td><td>"+e.getEmail()+"</td><td><a href=EditServ?id="+e.getId()+">Edit</a></td><td><a href=DeleteServ?id="+e.getId()+">Delete</a></td><tr>");
		}
		
		out.print("</table>");
		out.print("<a href='index.html'>Add new employee</a>"); 	
		out.print("</body>");
		out.print("</html>");
		out.close();
		}

}
