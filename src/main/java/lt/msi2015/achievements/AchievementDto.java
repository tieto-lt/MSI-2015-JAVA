package lt.msi2015.achievements;

public class AchievementDto {

	private Long userId;
	private Long achievementId;
	private Integer points;
	
	public AchievementDto() {
		super();
	}

	public AchievementDto(Long userId, Long achievementId, Integer points) {
		super();
		this.userId = userId;
		this.achievementId = achievementId;
		this.points = points;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getAchievementId() {
		return achievementId;
	}

	public void setAchievementId(Long achievementId) {
		this.achievementId = achievementId;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}
	
	
	
}
