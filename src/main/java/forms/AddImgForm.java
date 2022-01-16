package forms;

import java.io.IOException;

import beans.Album;
import beans.Image;
import dao.AlbumDao;
import dao.ImgDao;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class AddImgForm {

	
	private static final String CHAMP_TITRE = "titre";
	private static final String CHAMP_DESCRIPTION = "desc";
	private static final String CHAMP_MOTS_CLES = "mc";
	private static final String CHAMP_HAUTEUR = "hauteur";
	private static final String CHAMP_LARGEUR = "largeur";
	private static final String CHAMP_PHOTO = "photo";
	


	private boolean statusPhoto;
	private String statusMessagePhoto;
	private Image image;
	private Album album;
	private HttpServletRequest request;
//	private Map<String, String> erreurs;


    public AddImgForm( HttpServletRequest request) {
		this.statusPhoto = false;
		this.request = request;
//		this.erreurs = erreurs;
	}



 public boolean upload() throws IOException, ServletException{
	 
	String titre = request.getParameter(CHAMP_TITRE);
    String description = request.getParameter(CHAMP_DESCRIPTION);
    String motscles = request.getParameter(CHAMP_MOTS_CLES);
    String hauteur = request.getParameter(CHAMP_HAUTEUR);
    String largeur= request.getParameter(CHAMP_LARGEUR);
    String photo = request.getParameter(CHAMP_PHOTO);
    
    String nomalbum = request.getParameter("nomalbum");
    
    album = AlbumDao.getAlbumbyName(nomalbum);
    image = new Image(Integer.parseInt(hauteur),Integer.parseInt(largeur),titre,description,motscles,photo);
    
    statusPhoto = ImgDao.ajouter(request,image,album);
    if(statusPhoto) 
	{
		statusMessagePhoto = "Image enregistrée avec succès";
		
		return true;
	}
    
 				statusMessagePhoto = "Echec de l'enregistrement de l'image";
 				return false;
 }


public boolean getStatusPhoto() {
	return statusPhoto;
}



public String getStatusMessagePhoto() {
	return statusMessagePhoto;
}



public Image getImage() {
	return image;
}


public Album getAlbum() {
	return album;
}


public HttpServletRequest getRequest() {
	return request;
}
   

    
}

