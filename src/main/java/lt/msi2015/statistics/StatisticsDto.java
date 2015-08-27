package lt.msi2015.statistics;

import lt.msi2015.util.Dto;

public class StatisticsDto extends Dto {

	private Integer registeredUsersNumber; 
	private Long totalKarmaPointsSent; 
	private Long pointsToSend; 
	private Long pointsSentThisMonth; 
	private Long totalItemsGiven; 
	private String mostPopularCategory; 
	private Integer mostTransfersByOnePerson; 
	private String mostPopularItem; 
	private Long totalTransfers; 
	
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

	public Long getPointsToSend() {
		return pointsToSend;
	}

	public void setPointsToSend(Long pointsToSend) {
		this.pointsToSend = pointsToSend;
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

	public Integer getMostTransfersByOnePerson() {
		return mostTransfersByOnePerson;
	}

	public void setMostTransfersByOnePerson(Integer mostTransfersByOnePerson) {
		this.mostTransfersByOnePerson = mostTransfersByOnePerson;
	}

	public String getMostPopularItem() {
		return mostPopularItem;
	}

	public void setMostPopularItem(String mostPopularItem) {
		this.mostPopularItem = mostPopularItem;
	}

	public Long getTotalTransfers() {
		return totalTransfers;
	}

	public void setTotalTransfers(Long totalTransfers) {
		this.totalTransfers = totalTransfers;
	}

}
