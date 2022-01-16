package forms;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.Utilisateur;
import dao.UsersDao;

public class LoginForm {
	private HttpServletRequest request;
	
	private static final String CHAMP_LOGIN ="login";
	private static final String CHAMP_PASSWORD ="pwd";
	private String login;
	
	
	public LoginForm(HttpServletRequest request) 
	{
		this.request = request;
	}
	
	public boolean authentifier() 
	{
		 login = request.getParameter(CHAMP_LOGIN);
		String password = request.getParameter(CHAMP_PASSWORD);
		
		Utilisateur utilisateur = null;
		HttpSession session = request.getSession();
		
		if("admin".equals(login) && "admin".equals(password)) 
		{
			utilisateur = new Utilisateur (2,"ADMIN","ADMIN", "ADMIN", "ADMIN","administrateur");
		}
		else 
		{
			utilisateur = UsersDao.get(login);
			if(utilisateur != null && !utilisateur.getPassword().equals(password)) 
			{
				utilisateur = null;
			}
			
			
		}
		if (utilisateur != null) 
		{
			session.setAttribute("utilisateur", utilisateur);
			return true;
		}
		return false;
		 
	}
	
	public String getLogin() 
	{
		return this.login;
	}
}

