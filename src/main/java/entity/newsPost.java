package entity;

public class newsPost {
	private int id;
	private String dayNews;
	private String titleName;
	private String imageLink;
	private String conTent;
	private String typeNews;
	private boolean trend;

	public newsPost() {
	}

	public newsPost(int id, String dayNews, String titleName, String imageLink, String conTent, String typeNews,
			boolean trend) {
		super();
		this.id = id;
		this.dayNews = dayNews;
		this.titleName = titleName;
		this.imageLink = imageLink;
		this.conTent = conTent;
		this.typeNews = typeNews;
		this.trend = trend;
	}

	public boolean isTrend() {
		return trend;
	}

	public void setTrend(boolean trend) {
		this.trend = trend;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public String getConTent() {
		return conTent;
	}

	public void setConTent(String conTent) {
		this.conTent = conTent;
	}

	public String getTypeNews() {
		return typeNews;
	}

	public void setTypeNews(String typeNews) {
		this.typeNews = typeNews;
	}

	public String getDayNews() {
		return dayNews;
	}

	public void setDayNews(String dayNews) {
		this.dayNews = dayNews;
	}

	@Override
	public String toString() {
		return "newsPost [id=" + id + ", dayNews=" + dayNews + ", titleName=" + titleName + ", imageLink=" + imageLink
				+ ", conTent=" + conTent + ", typeNews=" + typeNews + ", trend=" + trend + ", isTrend()=" + isTrend()
				+ ", getId()=" + getId() + ", getTitleName()=" + getTitleName() + ", getImageLink()=" + getImageLink()
				+ ", getConTent()=" + getConTent() + ", getTypeNews()=" + getTypeNews() + ", getDayNews()="
				+ getDayNews() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}