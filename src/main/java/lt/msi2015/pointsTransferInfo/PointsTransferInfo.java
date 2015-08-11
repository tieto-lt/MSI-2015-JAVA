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
	@Size(min=1, max=30)
	public String fromUser;
	
	@NotNull
	@Size(min=1, max=30)
	public String toUser;

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
	
	public PointsTransferInfo(String from, String to, int points, String comment) {
		this.fromUser = from;
		this.toUser = to;
		this.points = points;
		this.comment = comment;
		this.dateCreated = new Date();
	}

}
