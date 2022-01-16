package forms;

import javax.servlet.http.HttpServletRequest;

import beans.Album;
import beans.Utilisateur;
import dao.AlbumDao;
import dao.UsersDao;

public class AddAlbumForm {

	
	private static final String CHAMP_DETAIL = "detail";
	private static final String CHAMP_NOMALBUM = "nomAlbum";
	private static final String CHAMP_PORTEE = "portee";
	

	private boolean statusAlbum;
	private String statusMessageAlbum;
	private Album album;
	private Utilisateur user;
	private HttpServletRequest request;
	
	 public AddAlbumForm( HttpServletRequest request) {
			this.statusAlbum = false;
			this.request = request;
		}
	 
	 public boolean AddAlbum()
	 {
		    String nomalbum = request.getParameter(CHAMP_NOMALBUM);
		    String detail = request.getParameter(CHAMP_DETAIL);
		    String portee = request.getParameter(CHAMP_PORTEE);
		    
		    String login = request.getParameter("loginuser");
		    user = UsersDao.get(login);
		    album = new Album(nomalbum,detail,portee);
		    
		    statusAlbum = AlbumDao.AjouterAlbum(album, user);
		    if(statusAlbum) 
			{
				statusMessageAlbum = "Image enregistrée avec succès";
				
				return true;
			}
		    
		 				statusMessageAlbum = "Echec de l'enregistrement de l'image";
		 				return false;
		 }

	public boolean getStatusAlbum() {
		return statusAlbum;
	}

	public String getStatusMessageAlbum() {
		return statusMessageAlbum;
	}

	public Album getAlbum() {
		return album;
	}

	public Utilisateur getUser() {
		return user;
	}
	 
}
