package DTO;

public class Notice {
	private int pryNumber;
	private String Title;
	private String Name;
	private String Date;
	private String Content;

	
	public Notice() {
		this(0,"","","","");
	}

	public Notice(int pryNumber, String title, String name,
			String date, String content) {
		super();
		this.pryNumber = pryNumber;
		this.Title = title;
		this.Name = name;
		this.Date = date;
		this.Content = content;
		
	}

	public int getPryNumber() {
		return pryNumber;
	}

	public void setPryNumber(int pryNumber) {
		this.pryNumber = pryNumber;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	
}