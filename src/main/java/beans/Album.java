package beans;

public class Album {

	private int id, categorie;
	private String nomAlbum,detail,portee;
	

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

	public Album(int id, String nomAlbum, String detail, String portee, int categorie) {
		super();
		this.id = id;
		this.nomAlbum = nomAlbum;
		this.detail = detail;
		this.portee = portee;
		this.categorie =  categorie;
	}

	public Album(String nomAlbum, String detail, String portee,int categorie) {
		super();
		this.nomAlbum = nomAlbum;
		this.detail = detail;
		this.portee = portee;
		this.categorie =  categorie;
	}

	public int getCategorie() {
		return categorie;
	}

	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}

	
	
	
}
