package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Utilisateur;
import dao.UsersDao;
import forms.UpdateUserForm;


@WebServlet("/updateUser")
public class UpdateUser extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	private static final String VUE_UPDATE_USERS = "/WEB-INF/updateUser.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String id = request.getParameter("id");
		if(id != null && id.matches("[0-9]+") ) 
		{
			Utilisateur utilisateur = UsersDao.getUser(Integer.parseInt(id));
			
			if(utilisateur !=null) 
			{
				//request.setAttribute("APP_URL", "request.getContextPath");
				//get retourne l'utilisateur dont l'id est donné en parametre
				
				request.setAttribute("utilisateur", utilisateur);
				getServletContext().getRequestDispatcher(VUE_UPDATE_USERS).forward(request, response);
			}
			getServletContext().getRequestDispatcher(VUE_UPDATE_USERS).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		UpdateUserForm form = new UpdateUserForm(request);
		
		HttpSession session = request.getSession();
		session.setAttribute("form",form); 
		
	
		if(form.modifier())
		{
			String url = request.getContextPath() +"/list?message=" + form.getStatusMessage();
			response.sendRedirect(url);
		}
		else {
			response.sendRedirect(request.getContextPath() + "/updateUser?id="+request.getParameter("id"));
		}

		
	}

}
