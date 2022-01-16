package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import forms.InscriptionForm;


@WebServlet("/inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String VUE_INSCRIPTION_USER = "/WEB-INF/inscription.jsp";
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		HttpSession session = request.getSession();
		Object form = session.getAttribute("form");
		if(form != null) 
		{
			session.removeAttribute("form");
			
		}
		request.setAttribute("form", form);
		getServletContext().getRequestDispatcher(VUE_INSCRIPTION_USER).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		InscriptionForm form = new InscriptionForm(request);
		
		HttpSession session = request.getSession();
		session.setAttribute("form",form);
	
		if(form.ajouter())
		{
			String url = request.getContextPath() +"/list?message=" + form.getStatusMessage();
			response.sendRedirect(url);
		}
		else {
			response.sendRedirect(request.getContextPath() + "/addUser");
		}
	}

}
