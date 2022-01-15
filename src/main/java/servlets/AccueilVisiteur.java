package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"","/accueil","/logout"})
public class AccueilVisiteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_ACCUEIL = "/WEB-INF/accueil.jsp";
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		switch(request.getServletPath()) 
		{
		case "/accueil" : case "":
			getServletContext().getRequestDispatcher(VUE_ACCUEIL).forward(request, response);
			break;
			default:
				request.getSession().invalidate();
				response.sendRedirect(request.getContextPath());
		}
		
	}


}
