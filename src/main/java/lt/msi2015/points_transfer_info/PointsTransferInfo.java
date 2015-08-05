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

//id, from, to, points, dateCreated

@Entity
public class PointsTransferInfo {
	
	@Id
	@GeneratedValue
	long id;
	
	@NotNull
	@Size(min=1, max=30)
	String from;
	
	@NotNull
	@Size(min=1, max=30)
	String to;
	
	@Max(100)
	@Min(1)
	@NotNull
	int points;
	
	@NotNull
	@Past
	Date dateCreated;
	

}
