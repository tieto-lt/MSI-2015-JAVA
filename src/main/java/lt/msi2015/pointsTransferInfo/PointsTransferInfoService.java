package lt.msi2015.pointsTransferInfo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.msi2015.applicationSettings.ApplicationSettingsEnum;
import lt.msi2015.applicationSettings.ApplicationSettingsRepository;
import lt.msi2015.applicationSettings.ApplicationSettingsService;

@Service
public class PointsTransferInfoService {
	
	@Autowired
	private PointsTransferInfoRepository repository;
	
	@Autowired
	private ApplicationSettingsService settingsService;
	
	@Autowired
	private ApplicationSettingsRepository settingsRepository;
	
	boolean save(PointsTransferInfoDto info) {
		Map<ApplicationSettingsEnum, Integer> settingsMap = 
				settingsService.convertSettingsToMap(settingsRepository.findAll());
		
		if (isPointsBelowLimit(settingsMap, info.points))
			return false;
		
		return repository.save(
			new PointsTransferInfo(
				info.fromUser,
				info.toUser,
				info.points,
				info.comment)
			) != null;
	}
	
	private boolean isPointsBelowLimit(Map<ApplicationSettingsEnum, Integer> settingsMap, int points) {
		return settingsMap.get(ApplicationSettingsEnum.ONE_TIME_LIMIT) != null &&
			   points > settingsMap.get(ApplicationSettingsEnum.ONE_TIME_LIMIT);
	}
}
