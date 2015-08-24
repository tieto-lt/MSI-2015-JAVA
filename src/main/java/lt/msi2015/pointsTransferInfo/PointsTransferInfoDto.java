package lt.msi2015.pointsTransferInfo;

import lt.msi2015.util.Dto;

public class PointsTransferInfoDto extends Dto {

	public Long toUserID;
	public Integer points;
	public String comment;
	public Long categoryId;
	
	public PointsTransferInfoDto() {
		super();
	}

	public PointsTransferInfoDto(Long toUserID, Integer points, String comment, Long categoryId) {
		super();
		this.toUserID = toUserID;
		this.points = points;
		this.comment = comment;
		this.categoryId = categoryId;
	}
	
}
