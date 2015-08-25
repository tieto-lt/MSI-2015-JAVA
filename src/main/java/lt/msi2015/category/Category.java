package lt.msi2015.category;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lt.msi2015.pointsTransferInfo.PointsTransferInfo;
import lt.msi2015.util.Dto;

@Entity
public class Category extends Dto {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Size(min = 1, max = 30)
	@Column(unique = true)
	private String name;
	
	@NotNull
	private Boolean enabled;
	
	@OneToMany(mappedBy = "category")
	private List<PointsTransferInfo> transferInfoEntries;
	
	public Category() {
		
	}
	
	public Category(String name, boolean enabled) {
		this.name = name;
		this.enabled = enabled;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<PointsTransferInfo> getTransferInfoEntries() {
		return transferInfoEntries;
	}

	public void setTransferInfoEntries(List<PointsTransferInfo> transferInfoEntries) {
		this.transferInfoEntries = transferInfoEntries;
	}	
	
	public void toggleEnabled(){
		enabled = !enabled;
	}
	
}
