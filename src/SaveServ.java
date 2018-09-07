

import java.io.IOException;
import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveServ")

public class SaveServ extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("fullname");
		String sid=request.getParameter("id");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		int id=Integer.parseInt(sid);
		Emp e=new Emp();
		e.setName(name);
		e.setId(id);
		e.setPass(password);
		e.setEmail(email);
		
		if (EmpDao.save(e)>0)
		out.println("<h1>Records entered successfully</h1>");
		
		else
		out.println ("Sorry! Enter your records again");
		
		RequestDispatcher rd=request.getRequestDispatcher("index.html");
		rd.include(request,response);
	}

}
