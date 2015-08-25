package lt.msi2015.pointsTransferInfo;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.msi2015.applicationSettings.ApplicationSettingsEnum;
import lt.msi2015.applicationSettings.ApplicationSettingsRepository;
import lt.msi2015.applicationSettings.ApplicationSettingsService;
import lt.msi2015.category.Category;
import lt.msi2015.category.CategoryRepository;
import lt.msi2015.mailers.MailerService;
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
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private MailerService mailer;
	
	@Transactional
	boolean save(PointsTransferInfoDto info) {
		
		if (isPointsAboveLimit(info.points))
			return false;
		
		if(!transferIsValid(info)){
			return false;
		}
		
		pointsCalculations(info);
		
		Category category = categoryRepository.findById(info.categoryId);
		if (category != null && category.isEnabled()) {
			mailer.sendMail(info);
			return pointsRepo.save(
				new PointsTransferInfo(
					userService.getCurrentUser().getId(),
					info.toUserID,
					info.points,
					info.comment,
					category)
				) != null;
		} else {
			return false;
		}
	}
	
	@Transactional
	private boolean isPointsAboveLimit( int points) {
		Map<ApplicationSettingsEnum, Integer> settingsMap = 
				settingsService.convertSettingsToMap(settingsRepository.findAll());
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
	
	private boolean transferIsValid(PointsTransferInfoDto info){
		User fromUser = userRepo.findById(userService.getCurrentUser().getId());
		return fromUser.pointsToGive >= info.points && userService.getCurrentUser().getId() != info.toUserID;
	}
	
}
