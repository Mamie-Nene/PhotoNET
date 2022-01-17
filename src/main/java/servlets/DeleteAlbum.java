package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlbumDao;

/**
 * Servlet implementation class DeleteUser
 */
@WebServlet("/deleteAlbum")
public class DeleteAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//on récupere l'id de lutilisateur
		String id= request.getParameter("id");
		if(id != null && id.matches("[0-9]+") ) 
		{
			AlbumDao.supprimer(Integer.parseInt(id));
		}
		response.sendRedirect(request.getContextPath()+"/Albums");
	}

}
