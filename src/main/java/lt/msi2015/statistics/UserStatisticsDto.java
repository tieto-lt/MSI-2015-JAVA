package lt.msi2015.statistics;

import lt.msi2015.util.Dto;

public class UserStatisticsDto extends Dto {
	
	private Integer pointsSent; 
	private Integer transfersMade;
	private Integer transfersGotten;
	private Integer pointsGotten; 
	private Integer itemsGotten;
	
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
	
	
	
}
