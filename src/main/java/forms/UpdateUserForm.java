package forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import beans.Utilisateur;
import dao.UsersDao;

public class UpdateUserForm {
	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_PRENOM = "prenom";
	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_PASSWORD = "pwd";
	private static final String CHAMP_USERROLE = "userRole";

	private boolean status;
	private String statusMessage;
	private Utilisateur utilisateur;
	private HttpServletRequest request;
	private Map<String, String> erreurs;
	
	public 	UpdateUserForm(HttpServletRequest request) 
	{
		this.status = false;
		this.request = request;
		this.erreurs = new HashMap<>();
	}
		
	public boolean modifier()
	{
		String id= request.getParameter("id");
		if(id != null && id.matches("[0-9]+")) 
		{
		
			String nom = getParameter(CHAMP_NOM);
			String prenom = getParameter(CHAMP_PRENOM);
			String login = getParameter(CHAMP_LOGIN);
			String password = getParameter(CHAMP_PASSWORD);
			String userRole= getParameter(CHAMP_USERROLE);
			validerChamp(CHAMP_NOM, CHAMP_PRENOM, CHAMP_LOGIN, CHAMP_PASSWORD, CHAMP_USERROLE);
			if(erreurs.isEmpty()) 
			{
				Utilisateur utilisateur= new Utilisateur(Integer.parseInt(id), nom, prenom, login, password,Integer.parseInt(userRole));
				
				status = UsersDao.modifier(utilisateur);
				if(status) 
				{
					statusMessage = "Modification effectuée aves succès";
						
					return status;
				}
				
			}
			
		}
		statusMessage = "Echec de la modification";
		return false;
	}
		

	private String getParameter(String parametre) 
	{
		String valeur = request.getParameter(parametre);
		if(valeur==null || valeur.trim().isEmpty()) 
		{
			return null;
		}
		return valeur.trim();
	}
	
	private void validerChamp(String ...CHAMP) 
	{
		for (String champ: CHAMP) 
		{
			if(getParameter(champ)==null) 
			{
				erreurs.put(champ, "Vous devez remplir ce champ");
			}
		}
	}

	public boolean getStatus() 
	{
		return status;
	}

	public String getStatusMessage() 
	{
		return statusMessage;
	}

	public Utilisateur getUtilisateur()
	{
		return utilisateur;
	}

	public Map<String, String> getErreurs() 
	{
		return erreurs;
	}
	
	}

