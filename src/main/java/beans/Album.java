package beans;

public class Album {

	private int id;
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

	public Album(int id, String nomAlbum, String detail, String portee) {
		super();
		this.id = id;
		this.nomAlbum = nomAlbum;
		this.detail = detail;
		this.portee = portee;
	}

	public Album(String nomAlbum, String detail, String portee) {
		super();
		this.nomAlbum = nomAlbum;
		this.detail = detail;
		this.portee = portee;
	}

	
	
	
}
