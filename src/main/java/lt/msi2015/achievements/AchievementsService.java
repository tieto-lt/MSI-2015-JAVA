package lt.msi2015.achievements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.msi2015.category.Category;
import lt.msi2015.category.CategoryRepository;
import lt.msi2015.pointsTransferInfo.PointsTransferInfo;
import lt.msi2015.pointsTransferInfo.PointsTransferInfoRepository;
import lt.msi2015.user.User;
import lt.msi2015.user.UserRepository;

@Service
public class AchievementsService {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	PointsTransferInfoRepository transfersRepo;
	
	@Autowired
	CategoryRepository categoryRepo;

	public void claimAchievement(AchievementDto dto) {
		User user =  userRepo.findById(dto.getUserId());
		
        switch (dto.getAchievementId().intValue()) {
		    case 1:  user.setAchievement_1(true);
		             break;
		    case 2:  user.setAchievement_2(true);
		             break;
		    case 3:  user.setAchievement_3(true);
		             break;
		    default: break;
        }
        
        user.setUserPoints(user.getUserPoints() + dto.getPoints());
        userRepo.save(user);
        
        Category category =  categoryRepo.findByName("Achievement").get(0);
        
        
        PointsTransferInfo fakeTransfer = new PointsTransferInfo(null, dto.getUserId(), dto.getPoints(), "Claimed achievement", category);
        transfersRepo.save(fakeTransfer);
	}

}
