package forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import beans.Utilisateur;
import dao.UsersDao;

public class AddUserForm 
{

	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_PRENOM = "prenom";
	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_PASSWORD = "pwd";
	private static final String CHAMP_PASSWORD_BIS = "pwdBis";
	private static final String CHAMP_USERROLE = "userRole";

	private boolean status;
	private String statusMessage;
	private Utilisateur utilisateur;
	private HttpServletRequest request;
	private Map<String, String> erreurs;
	
	public AddUserForm(HttpServletRequest request) 
	{
		this.status = false;
		this.request = request;
		this.erreurs = new HashMap<>();
	}
	
	public boolean ajouter() {
		String nom = getParameter(CHAMP_NOM);
		String prenom = getParameter(CHAMP_PRENOM);
		String login = getParameter(CHAMP_LOGIN);
		String password = getParameter(CHAMP_PASSWORD);
		String userRole = getParameter(CHAMP_USERROLE);
		
		utilisateur = new Utilisateur(nom, prenom, login, password, Integer.parseInt(userRole));
		
		validerChamp(CHAMP_NOM, CHAMP_PRENOM, CHAMP_LOGIN, CHAMP_PASSWORD, CHAMP_USERROLE);
		validerPasswords();
		
		if(erreurs.isEmpty()) 
		{
			status = UsersDao.ajouter(utilisateur);
			if(status) 
			{
				statusMessage = "Ajout effectué aves succès";
				
				return true;
			}
		
		}
		statusMessage = "Echec de l'ajout";
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
	private void validerPasswords() {
		String password = getParameter(CHAMP_PASSWORD);
		String passwordBis = getParameter(CHAMP_PASSWORD_BIS);
		
		if(password != null && !password.equals(passwordBis)) 
		{
			erreurs.put(CHAMP_PASSWORD, "les mots de passe ne sont pas conformes");
			erreurs.put(CHAMP_PASSWORD_BIS, "les mots de passe ne sont pas conformes");
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



