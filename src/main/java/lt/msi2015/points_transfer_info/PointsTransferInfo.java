package lt.msi2015.points_transfer_info;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
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
	
	@Max(100)
	@Min(1)
	@NotNull
	public Integer points;

	
	@NotNull
	@Past
	Date dateCreated;

	public PointsTransferInfo() {
		//for JSON
	}
	
	public PointsTransferInfo(String from, String to, int points) {
		this.fromUser = from;
		this.toUser = to;
		this.points = points;
		this.dateCreated = new Date();
	}

	public PointsTransferInfo(String from, String to, int points, Date dateCreated) {
		this.fromUser = from;
		this.toUser = to;
		this.points = points;
		this.dateCreated = dateCreated;
	}
	
}
