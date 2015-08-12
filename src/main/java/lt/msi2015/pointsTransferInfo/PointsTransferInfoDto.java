package lt.msi2015.pointsTransferInfo;

import lt.msi2015.util.Dto;

public class PointsTransferInfoDto extends Dto {

	public Long toUserID;
	public Integer points;
	public String comment;
	
	public PointsTransferInfoDto() {
		super();
	}

	public PointsTransferInfoDto(Long toUserID, Integer points, String comment) {
		super();
		this.toUserID = toUserID;
		this.points = points;
		this.comment = comment;
	}
	
}
