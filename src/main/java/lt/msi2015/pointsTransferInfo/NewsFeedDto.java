package lt.msi2015.pointsTransferInfo;

public class NewsFeedDto {
	public String fromFirstName;
	public String fromLastName;
	public String toFirstName;
	public String toLastName;
	public int points;
	public String comment;
	public String date;

	public NewsFeedDto(String fromFirstName, String fromLastName, String toFirstName, String toLastName, int points,
			String comment, String date) {
		super();
		this.fromFirstName = fromFirstName;
		this.fromLastName = fromLastName;
		this.toFirstName = toFirstName;
		this.toLastName = toLastName;
		this.points = points;
		this.comment = comment;
		this.date = date;
	}

	
}
