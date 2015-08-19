package lt.msi2015.pointsTransferInfo;

import lt.msi2015.util.Dto;

public class ExistingPointsTransferInfoDto extends Dto {

	private Long id;
	private Long fromUserID;
	private Long toUserID;
	private Integer points;
	private String comment;
	private String dateCreated;
	
	public ExistingPointsTransferInfoDto() {
		super();
	}

	public ExistingPointsTransferInfoDto(Long id, Long fromUserID, Long toUserID, Integer points,
				String comment, String dateCreated) {
		super();
		this.id = id;
		this.fromUserID = fromUserID;
		this.toUserID = toUserID;
		this.points = points;
		this.comment = comment;
		this.dateCreated = dateCreated;
	}

	public Long getId() {
		return id;
	}

	public Long getFromUserID() {
		return fromUserID;
	}

	public Long getToUserID() {
		return toUserID;
	}

	public Integer getPoints() {
		return points;
	}

	public String getComment() {
		return comment;
	}

	public String getDateCreated() {
		return dateCreated;
	}
	
}
