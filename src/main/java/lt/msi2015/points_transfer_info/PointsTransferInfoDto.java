package lt.msi2015.points_transfer_info;

import lt.msi2015.util.Dto;

public class PointsTransferInfoDto extends Dto {

	public String fromUser;
	public String toUser;
	public Integer points;
	public String comment;
	
	public PointsTransferInfoDto() {
		super();
	}
	
	
	public PointsTransferInfoDto(String fromUser, String toUser, Integer points, String comment) {
		super();
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.points = points;
		this.comment = comment;
	}

}
