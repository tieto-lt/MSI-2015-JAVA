package lt.msi2015.leaderboard;

import lt.msi2015.util.Dto;

public class LeaderboardEntryDto extends Dto {
	
	public String name;
	public long points;
	
	public LeaderboardEntryDto() {
		
	}
	
	public LeaderboardEntryDto(String name, long points) {
		super();
		this.name = name;
		this.points = points;
	}
}
