package servlets;


import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Album;
import dao.AlbumDao;
import forms.AddImgForm;


/**
 * Servlet implementation class Myviewservlet
 */
@WebServlet("/uploadImg")
@MultipartConfig(maxFileSize = 16177215) // upload file up to 16MB
public class UploadImg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadImg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nomalbum");
		if(nom != null ) 
		{
			Album album = AlbumDao.getAlbumbyName(nom);
			
			if(album !=null) 
			{
				
				
				request.setAttribute("album", album);
				getServletContext().getRequestDispatcher("/WEB-INF/addImg.jsp").forward(
		                request, response);
			}
		}
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AddImgForm Imgform= new AddImgForm(request);
		
		HttpSession session = request.getSession();
		session.setAttribute("Imgform",Imgform);
		
		if(Imgform.upload())
		{
			String url = request.getContextPath() +"/list?message=" + Imgform.getStatusMessagePhoto();
			response.sendRedirect(url);
		}
		else 
		{
			response.sendRedirect(request.getContextPath() + "/uploadImg?message = " + Imgform.getStatusMessagePhoto());
		}
		
	}

}
