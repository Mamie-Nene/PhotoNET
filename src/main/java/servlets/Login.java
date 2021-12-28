package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forms.LoginForm;


@WebServlet({"","/login","/logout"})
public class Login extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	private static final String VUE_LOGIN = "/WEB-INF/login.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		switch(request.getServletPath()) 
		{
		case "/login" : case "":
			getServletContext().getRequestDispatcher(VUE_LOGIN).forward(request, response);
			break;
			default:
				request.getSession().invalidate();
				response.sendRedirect(request.getContextPath());
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{ // TODO Auto-generated method stub
		LoginForm form = new LoginForm(request);
		
		if(form.authentifier()) 
		{
			response.sendRedirect(request.getContextPath()+"/list");
		
		}
		else 
		{
			request.setAttribute("login", form.getLogin());
			getServletContext().getRequestDispatcher(VUE_LOGIN).forward(request, response);
			
		}
		
		

	}
}