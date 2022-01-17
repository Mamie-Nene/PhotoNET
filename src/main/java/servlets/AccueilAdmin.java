package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ImgDao;
import dao.UsersDao;

@WebServlet("/accueilAdmin")
public class AccueilAdmin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String VUE_ACCUEIL_ADMIN = "/WEB-INF/accueilAdmin.jsp";
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		Object form = session.getAttribute("form");
		boolean status=false;
		
		if(form != null) 
		{
			session.removeAttribute("form");
			status=true;
		}
		
		session.setAttribute("status", status);
		
		request.setAttribute("users",UsersDao.lister());
		request.setAttribute("images",ImgDao.ListAllImg());
		getServletContext().getRequestDispatcher(VUE_ACCUEIL_ADMIN).forward(request, response);
	}
	

}
