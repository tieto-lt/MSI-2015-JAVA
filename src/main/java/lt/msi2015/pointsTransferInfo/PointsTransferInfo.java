package lt.msi2015.pointsTransferInfo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class PointsTransferInfo {
	
	@Id
	@GeneratedValue
	public Long id;
	
	@NotNull
	public Long fromUserID;
	
	@NotNull
	public Long toUserID;

	@Min(1)
	@NotNull
	public Integer points;
	
	@Size(max=160)
	public String comment;
	
	@NotNull
	@Past
	public Date dateCreated;

	public PointsTransferInfo() {
		//for JSON
	}
	
	public PointsTransferInfo(Long fromUserID, Long toUserID, Integer points, String comment) {
		this.fromUserID = fromUserID;
		this.toUserID = toUserID;
		this.points = points;
		this.comment = comment;
		this.dateCreated = new Date();
	}

}
