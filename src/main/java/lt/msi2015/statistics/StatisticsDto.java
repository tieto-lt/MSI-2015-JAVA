package lt.msi2015.statistics;

import lt.msi2015.util.Dto;

public class StatisticsDto extends Dto {

	private Integer registeredUsersNumber;

	public StatisticsDto(Integer registeredUsers) {
		super();
		this.registeredUsersNumber = registeredUsers;
	}

	public Integer getRegisteredUsers() {
		return registeredUsersNumber;
	}
	
}
