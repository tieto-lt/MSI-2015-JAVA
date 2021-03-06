package lt.msi2015.pointsTransferInfo;

import java.util.Date;

import lt.msi2015.category.CategoryDto;

public class NewsFeedDto {
	public Long fromUserID;
	public Long toUserID;
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
	public CategoryDto category;
	

	public NewsFeedDto() {
		super();
	}

	public NewsFeedDto(Long fromUserID,
				Long toUserID,
				byte[] fromImage,
				byte[] toImage, String
				fromFirstName,
				String fromLastName,
				String toFirstName,
				String toLastName,
				int points,
				String comment,
				String date,
				Date dateFull,
				CategoryDto category) {
		super();
		this.fromUserID = fromUserID;
		this.toUserID = toUserID;
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
		this.category = category;
	}

	public Long getFromUserID() {
		return fromUserID;
	}

	public Long getToUserID() {
		return toUserID;
	}

	
}
