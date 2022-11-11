package entity;

public class typeNews {
	private int id;
	private String typeNews;
	private String imagesType;

	public typeNews() {

	}

	public typeNews(int id, String typeNews, String imagesType) {
		super();
		this.id = id;
		this.typeNews = typeNews;
		this.imagesType = imagesType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeNews() {
		return typeNews;
	}

	public void setTypeNews(String typeNews) {
		this.typeNews = typeNews;
	}

	public String getImagesType() {
		return imagesType;
	}

	public void setImagesType(String imagesType) {
		this.imagesType = imagesType;
	}

	@Override
	public String toString() {
		return "typeNews [id=" + id + ", typeNews=" + typeNews + ", imagesType=" + imagesType + ", getId()=" + getId()
				+ ", getTypeNews()=" + getTypeNews() + ", getImagesType()=" + getImagesType() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
