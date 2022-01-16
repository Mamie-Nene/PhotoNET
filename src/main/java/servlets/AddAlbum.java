package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import forms.AddAlbumForm;


/**
 * Servlet implementation class AddAlbum
 */
@WebServlet("/AddAlbum")
public class AddAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_ADD_ALBUMS = "/WEB-INF/addAlbum.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAlbum() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getParameter("loginuser");
		
		
		getServletContext().getRequestDispatcher(VUE_ADD_ALBUMS).forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AddAlbumForm Albumform= new AddAlbumForm(request);
		
		HttpSession session = request.getSession();
		session.setAttribute("Albumform",Albumform);
		
		if(Albumform.AddAlbum())
		{
			String url = request.getContextPath() +"/Albums?message=" + Albumform.getStatusMessageAlbum();
			response.sendRedirect(url);
		}
		else 
		{
			response.sendRedirect(request.getContextPath() + "/AddAlbum?message = " + Albumform.getStatusMessageAlbum());
		}
	}

}
