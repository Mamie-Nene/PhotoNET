package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ImgDao;


@WebServlet("/accueilUser")
public class AccueilUserSimple extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String VUE_ACCUEIL_USER = "/WEB-INF/accueilUser.jsp";
    

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
		
		request.setAttribute("images",ImgDao.ListAllImg());
		getServletContext().getRequestDispatcher(VUE_ACCUEIL_USER).forward(request, response);
	}
	

}
