package lt.msi2015.pointsTransferInfo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.msi2015.applicationSettings.ApplicationSettingsEnum;
import lt.msi2015.applicationSettings.ApplicationSettingsRepository;
import lt.msi2015.applicationSettings.ApplicationSettingsService;
import lt.msi2015.user.User;
import lt.msi2015.user.UserRepository;
import lt.msi2015.user.UserService;

@Service
public class PointsTransferInfoService {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepo;
	
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
		
		if(transferIsValid(info.points)){
			pointsCalculations(info);
		}
		
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
	
	private void pointsCalculations(PointsTransferInfoDto info){
		User addToUser = userRepo.findById(info.toUserID);
		addToUser.userPoints += info.points;
		userRepo.save(addToUser);
		
		User subFromUser = userRepo.findById(userService.getCurrentUser().getId());
		subFromUser.pointsToGive -= info.points;
		userRepo.save(subFromUser);
	}
	
	private boolean transferIsValid(int points){
		User fromUser = userRepo.findById(userService.getCurrentUser().getId());
		return fromUser.pointsToGive <= points;
	}
}
