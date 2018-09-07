

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditServ")
public class EditServ extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			String sid=request.getParameter("id");
			int id=Integer.parseInt(sid);
					Emp e=EmpDao.select(id);
			

					out.print("<html>");
					out.print("<head>");
					out.print("<style type='text/css'>");
					out.print("#logo{position:absolute;left:77%;top:130px;}body{ background-color:#5f9ea0 }li {    float: left;}li a {    display: block;    color: white;    text-align: center;    padding: 16px;    text-decoration: none;}li a:hover {    background-color: #111111;}ul {list-style-type: none;margin: 10;padding: 2;overflow: auto;background-color: #333333;");
					out.print("</style>");
					out.print("</head>");
					out.print("<body>");
					out.println("<img id='logo' src='image.png' alt='logo' height='300' width='250'>");
					out.print("<ul><li><a href='#home'>Home</a></li><li><a href='#news'>News</a></li><li><a href='#contact'>Contact</a></li><li><a href='#about'>About</a></li></ul>");
					
			out.println("<form action='EditServ2' method='POST'>");
			out.println ("<table>");
			out.println("<tr><td><input type='text' name='id' value='"+e.getId()+"'/></td></tr>");
			out.println("<tr><td><input type='text' name='username' value='"+e.getName()+"'/></td></tr>");
			out.println("<tr><td><input type='password' name='password' value='"+e.getPass()+"'/></td></tr>");
			out.println("<tr><td><input type='text' name='email' value='"+e.getEmail()+"'/></td></tr>");
			out.println("<tr><td><input type='submit' value='Save'/></td></tr>");
			out.println("</table></form>");
			out.print("</body>");
			out.print("</html>");
			out.close();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

}
