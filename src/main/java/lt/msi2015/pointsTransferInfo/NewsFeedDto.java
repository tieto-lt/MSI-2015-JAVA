package lt.msi2015.pointsTransferInfo;

import java.util.Date;

public class NewsFeedDto {
	public byte[] fromImage;
	public byte[] toImage;
	public String fromFirstName;
	public String fromLastName;
	public String toFirstName;
	public String toLastName;
	public int points;
	public String comment;
	public String date;
	public Date dateFull;
	
	

	public NewsFeedDto() {
		super();
	}



	public NewsFeedDto(byte[] fromImage, 
						byte[] toImage, 
						String fromFirstName, 
						String fromLastName, 
						String toFirstName, 
						String toLastName, 
						int points,
						String comment, 
						String date,
						Date dateFull) {

		super();
		this.fromImage = fromImage;
		this.toImage = toImage;
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
