

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/EditServ2")
public class EditServ2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("id");
		String name=request.getParameter("fullname");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		int id=Integer.parseInt(sid);
		Emp e=new Emp();
		e.setId(id);
		e.setName(name);
		e.setPass(password);
		e.setEmail(email);
		
		if (EmpDao.update(e)>0)
		{
			out.println("records updated successfully");
			response.sendRedirect("ViewServ");
	     }
		else
			response.sendRedirect("index.html");

}
}
