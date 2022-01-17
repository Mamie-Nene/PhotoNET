package beans;

public class Autorisation 
{
	private int id ,proprioId, authorizedUser;
	public Autorisation() {
		
	}
	public Autorisation(int id, int proprioId, int authorizedUser) {
		this.id = id;
		this.proprioId = proprioId;
		this.authorizedUser = authorizedUser;
	}
	public Autorisation(int proprioId, int authorizedUser) {
		this.proprioId = proprioId;
		this.authorizedUser = authorizedUser;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProprioId() {
		return proprioId;
	}
	public void setProprioId(int proprioId) {
		this.proprioId = proprioId;
	}
	
	public int getAuthorizedUser() {
		return authorizedUser;
	}
	public void setAuthorizedUser(int authorizedUser) {
		this.authorizedUser = authorizedUser;
	}
	
}
