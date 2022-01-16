package beans;

public class Image {

	private int id,hauteur,largeur;
	private String titre,description,motscles,img;
	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Image() {
		
	}
	public Image(int id, int hauteur, int largeur, String titre, String description, String motscles,String img) {
		
		this.id = id;
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.titre = titre;
		this.description = description;
		this.motscles = motscles;
		this.img = img;
	}
	public Image(int hauteur, int largeur, String titre, String description, String motscles,String img) {
		
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.titre = titre;
		this.description = description;
		this.motscles = motscles;
		this.img = img;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHauteur() {
		return hauteur;
	}
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}
	public int getLargeur() {
		return largeur;
	}
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMotscles() {
		return motscles;
	}
	public void setMotscles(String motscles) {
		this.motscles = motscles;
	}

}
