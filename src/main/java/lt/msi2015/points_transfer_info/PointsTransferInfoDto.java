package lt.msi2015.points_transfer_info;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lt.msi2015.util.Dto;

public class PointsTransferInfoDto extends Dto {

	public String fromUser;
	public String toUser;
	public Integer points;
	
	public PointsTransferInfoDto() {
		super();
	}
	
	
	public PointsTransferInfoDto(String fromUser, String toUser, Integer points) {
		super();
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.points = points;
	}

}
