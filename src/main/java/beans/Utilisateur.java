package beans;

public class Utilisateur 
{
	
	private int id, userRole;
	private String nom, prenom, login, password;
	public Utilisateur()
	{//obligatoire 
	}
	public Utilisateur(int id, String nom, String prenom, String login, String password, int userRole) 
	{
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.userRole = userRole;
	}
	public Utilisateur(String nom, String prenom, String login, String password, int userRole ) 
	{
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.userRole = userRole;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserRole() {
		return userRole;
	}
	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}
	 @Override
	 public String toString() {
		 return " [id= "+id +", nom: " +nom+", prenom: " +prenom+", login: "+login +", mot de passe: " +password +"]";
	 }
}
