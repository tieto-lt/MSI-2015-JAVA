package lt.msi2015.statistics;

import lt.msi2015.util.Dto;

public class StatisticsDto extends Dto {

	private Integer registeredUsersNumber;
	private Long totalKarmaPointsSent;
	private Long pointsToSendThisMonth;
	private Long pointsSentThisMonth;
	private Long totalItemsGiven;
	private String mostPopularCategory;
	private String mostTransfersBy;
	private String mostPopularItem;

	public StatisticsDto() {
		super();
	}

	public Integer getRegisteredUsersNumber() {
		return registeredUsersNumber;
	}

	public void setRegisteredUsersNumber(Integer registeredUsersNumber) {
		this.registeredUsersNumber = registeredUsersNumber;
	}

	public Long getTotalKarmaPointsSent() {
		return totalKarmaPointsSent;
	}

	public void setTotalKarmaPointsSent(Long totalKarmaPointsSent) {
		this.totalKarmaPointsSent = totalKarmaPointsSent;
	}

	public Long getPointsToSendThisMonth() {
		return pointsToSendThisMonth;
	}

	public void setPointsToSendThisMonth(Long pointsToSendThisMonth) {
		this.pointsToSendThisMonth = pointsToSendThisMonth;
	}

	public Long getPointsSentThisMonth() {
		return pointsSentThisMonth;
	}

	public void setPointsSentThisMonth(Long pointsSentThisMonth) {
		this.pointsSentThisMonth = pointsSentThisMonth;
	}

	public Long getTotalItemsGiven() {
		return totalItemsGiven;
	}

	public void setTotalItemsGiven(Long totalItemsGiven) {
		this.totalItemsGiven = totalItemsGiven;
	}

	public String getMostPopularCategory() {
		return mostPopularCategory;
	}

	public void setMostPopularCategory(String mostPopularCategory) {
		this.mostPopularCategory = mostPopularCategory;
	}

	public String getMostTransfersBy() {
		return mostTransfersBy;
	}

	public void setMostTransfersBy(String mostTransfersBy) {
		this.mostTransfersBy = mostTransfersBy;
	}

	public String getMostPopularItem() {
		return mostPopularItem;
	}

	public void setMostPopularItem(String mostPopularItem) {
		this.mostPopularItem = mostPopularItem;
	}

}
