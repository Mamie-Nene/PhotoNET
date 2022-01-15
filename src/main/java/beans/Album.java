package beans;

public class Album {
	private int id, categorie, autorisationId ;
	private String nomAlbum,dateCreation,proprioAlbum,detail,portee;
	public Album()
	{//obligatoire 
	}
	public Album(int id, String nomAlbum, String dateCreation, String proprioAlbum, String detail, String portee ,int categorie, int autorisationId) {
		this.id = id;
		this.nomAlbum = nomAlbum;
		this.dateCreation = dateCreation;
		this.proprioAlbum = proprioAlbum;
		this.detail = detail;
		this.portee = portee;
		this.categorie= categorie;
		this.autorisationId = autorisationId;
	}
	public Album(String nomAlbum, String dateCreation, String proprioAlbum, String detail, String portee, int categorie, int autorisationId) {
		
		this.nomAlbum = nomAlbum;
		this.dateCreation = dateCreation;
		this.proprioAlbum = proprioAlbum;
		this.detail = detail;
		this.portee = portee;
		this.categorie= categorie;
		this.autorisationId = autorisationId;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomAlbum() {
		return nomAlbum;
	}
	public void setNomAlbum(String nomAlbum) {
		this.nomAlbum = nomAlbum;
	}
	public String getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getProprioAlbum() {
		return proprioAlbum;
	}
	public void setProprioAlbum(String proprioAlbum) {
		this.proprioAlbum = proprioAlbum;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getPortee() {
		return portee;
	}
	public void setPortee(String portee) {
		this.portee = portee;
	}
	public int getCategorie() {
		return categorie;
	}
	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}
	public int getAutorisationId() {
		return autorisationId;
	}
	public void setAutorisationId(int autorisationId) {
		this.autorisationId = autorisationId;
	}
	 @Override
	 public String toString() {
		 return " [id= "+id +", nomAlbum: " +nomAlbum+", dateCreation: " +dateCreation+", proprioAlbum: "+proprioAlbum +",detail: " +detail +",portee:"+portee + ",categorie: "+categorie +",autorisationId "+autorisationId +"]";
	 }
}
