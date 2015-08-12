package lt.msi2015.leaderboard;

import lt.msi2015.util.Dto;

public class LeaderboardEntryDto extends Dto {
	
	public Long userID;
	public Long points;
	public String name;
	
	public LeaderboardEntryDto() {
		
	}
	
	public LeaderboardEntryDto(Long userID, String name, long points) {
		super();
		this.userID = userID;
		this.points = points;
		this.name = name;
	}
}
