package lt.msi2015.pointsTransferInfo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.msi2015.applicationSettings.ApplicationSettingsEnum;
import lt.msi2015.applicationSettings.ApplicationSettingsRepository;
import lt.msi2015.applicationSettings.ApplicationSettingsService;
import lt.msi2015.user.UserService;

@Service
public class PointsTransferInfoService {
	
	@Autowired
	UserService userService;
	
	@Autowired
	private PointsTransferInfoRepository pointsRepo;
	
	@Autowired
	private ApplicationSettingsService settingsService;
	
	@Autowired
	private ApplicationSettingsRepository settingsRepository;
	
	boolean save(PointsTransferInfoDto info) {
		Map<ApplicationSettingsEnum, Integer> settingsMap = 
				settingsService.convertSettingsToMap(settingsRepository.findAll());
		
		if (isPointsBelowLimit(settingsMap, info.points))
			return false;
		
		System.out.println("fromUserId: " + userService.getCurrentUser().getId());
		System.out.println("toUserId: " + info.toUserID);
		return pointsRepo.save(
			new PointsTransferInfo(
				userService.getCurrentUser().getId(),
				info.toUserID,
				info.points,
				info.comment)
			) != null;
	}
	
	private boolean isPointsBelowLimit(Map<ApplicationSettingsEnum, Integer> settingsMap, int points) {
		return settingsMap.get(ApplicationSettingsEnum.ONE_TIME_LIMIT) != null &&
			   points > settingsMap.get(ApplicationSettingsEnum.ONE_TIME_LIMIT);
	}
}
