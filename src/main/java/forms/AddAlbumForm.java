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
	private static final String CHAMP_CATEGORIE = "categorie";
	

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
		    String categorie = request.getParameter(CHAMP_CATEGORIE);
		    
		    String login = request.getParameter("loginuser");
		    user = UsersDao.getByLogin(login);
		    album = new Album(nomalbum,detail,portee,Integer.parseInt(categorie));
		    
		    statusAlbum = AlbumDao.AjouterAlbum(album, user);
		    if(statusAlbum) 
			{
				statusMessageAlbum = "Image enregistr�e avec succ�s";
				
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
