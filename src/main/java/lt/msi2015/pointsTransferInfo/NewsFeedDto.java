package lt.msi2015.pointsTransferInfo;

import java.util.Date;

public class NewsFeedDto {
	public String fromFirstName;
	public String fromLastName;
	public String toFirstName;
	public String toLastName;
	public int points;
	public String comment;
	public String date;
	public Date dateFull;

	public NewsFeedDto(String fromFirstName, String fromLastName, String toFirstName, String toLastName, int points,
			String comment, String date, Date dateFull) {
		super();
		this.fromFirstName = fromFirstName;
		this.fromLastName = fromLastName;
		this.toFirstName = toFirstName;
		this.toLastName = toLastName;
		this.points = points;
		this.comment = comment;
		this.date = date;
		this.dateFull = dateFull;
	}

	
}
