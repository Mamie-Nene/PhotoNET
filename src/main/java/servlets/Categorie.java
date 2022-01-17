package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlbumDao;
import dao.CategorieDao;
import dao.ImgDao;

@WebServlet("/categorie")
public class Categorie extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String VUE_CATEGORIE = "/WEB-INF/categorie.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String categorie = request.getParameter("categorie");
		request.setAttribute("albums",AlbumDao.getAlbumByCategorie(Integer.parseInt(categorie)));
		request.setAttribute("images",ImgDao.ListeImgByCategorie(Integer.parseInt(categorie)));
		request.setAttribute("categories",CategorieDao.lister());
		getServletContext().getRequestDispatcher(VUE_CATEGORIE).forward(request, response);
	}
}
