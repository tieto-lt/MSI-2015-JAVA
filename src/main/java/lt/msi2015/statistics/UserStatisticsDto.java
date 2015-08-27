package lt.msi2015.statistics;

import lt.msi2015.util.Dto;

public class UserStatisticsDto extends Dto {
	
	private Integer pointsSent; 
	private Integer transfersMade;
	private Integer transfersGotten;
	private Integer pointsGotten; 
	private Integer itemsGotten;
	private Boolean achievement_1;
	private Boolean achievement_2;
	private Boolean achievement_3;
	
	public UserStatisticsDto() {
		super();
	}

	public Integer getPointsSent() {
		return pointsSent;
	}

	public void setPointsSent(Integer pointsSent) {
		this.pointsSent = pointsSent;
	}

	public Integer getTransfersMade() {
		return transfersMade;
	}

	public void setTransfersMade(Integer transfersMade) {
		this.transfersMade = transfersMade;
	}

	public Integer getTransfersGotten() {
		return transfersGotten;
	}

	public void setTransfersGotten(Integer transfersGotten) {
		this.transfersGotten = transfersGotten;
	}

	public Integer getPointsGotten() {
		return pointsGotten;
	}

	public void setPointsGotten(Integer pointsGotten) {
		this.pointsGotten = pointsGotten;
	}

	public Integer getItemsGotten() {
		return itemsGotten;
	}

	public void setItemsGotten(Integer itemsGotten) {
		this.itemsGotten = itemsGotten;
	}

	public Boolean getAchievement_1() {
		return achievement_1;
	}

	public void setAchievement_1(Boolean achievement_1) {
		this.achievement_1 = achievement_1;
	}

	public Boolean getAchievement_2() {
		return achievement_2;
	}

	public void setAchievement_2(Boolean achievement_2) {
		this.achievement_2 = achievement_2;
	}

	public Boolean getAchievement_3() {
		return achievement_3;
	}

	public void setAchievement_3(Boolean achievement_3) {
		this.achievement_3 = achievement_3;
	}
	
}
