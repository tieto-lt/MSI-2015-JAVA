package lt.msi2015.pointsTransferInfo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lt.msi2015.category.Category;

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
	public Date dateCreated;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="category_id")
	public Category category;

	public PointsTransferInfo() {
		//for JSON
	}
	
	public PointsTransferInfo(Long fromUserID, Long toUserID, Integer points, String comment, Category category) {
		this.fromUserID = fromUserID;
		this.toUserID = toUserID;
		this.points = points;
		this.comment = comment;
		this.dateCreated = new Date();
		this.category = category;
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

	public Date getDateCreated() {
		return dateCreated;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}	

}
