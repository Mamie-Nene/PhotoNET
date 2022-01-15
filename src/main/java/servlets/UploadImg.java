package servlets;


import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import forms.UploadForm;


@WebServlet("/uploadImg")
@MultipartConfig(maxFileSize = 16177215) // upload file up to 16MB
public class UploadImg extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UploadImg() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 getServletContext().getRequestDispatcher("/WEB-INF/upload.jsp").forward(
	                request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UploadForm uploadform = new UploadForm(request);
		
		HttpSession session = request.getSession();
		session.setAttribute("uploadform",uploadform);
		if(uploadform.upload())
		{
			String url = request.getContextPath() +"/list?message=" + uploadform.getStatusMessage();
			response.sendRedirect(url);
		}
		else 
		{
			response.sendRedirect(request.getContextPath() + "/uploadImg?message = " + uploadform.getStatusMessage());
		}
		
	}

}
