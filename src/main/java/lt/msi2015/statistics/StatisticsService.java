package lt.msi2015.statistics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.msi2015.pointsTransferInfo.PointsTransferInfo;
import lt.msi2015.pointsTransferInfo.PointsTransferInfoRepository;
import lt.msi2015.user.User;
import lt.msi2015.user.UserRepository;

@Service
public class StatisticsService {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	PointsTransferInfoRepository transferRepo;
	
	public StatisticsDto getStatistics() {
		StatisticsDto stats =new StatisticsDto();
		
		stats.setRegisteredUsersNumber(getRegisteredUsersNumber());
		stats.setTotalKarmaPointsSent(getTotalKarmaSent());
		
		return stats;
	}
	
	private Integer getRegisteredUsersNumber() {
		List <User> userList = userRepo.findAll();
		return userList.size();
	}
	
	private Long getTotalKarmaSent() {
		long totalPoints = 0;
	
		List<PointsTransferInfo> allTransfers = transferRepo.findAll();
		
		for(PointsTransferInfo transfer : allTransfers ){
			totalPoints += transfer.points;
		}
		
		return new Long(totalPoints);
	}
	
}
