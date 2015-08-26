package lt.msi2015.statistics;

import java.util.Calendar;
import java.util.Date;
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
		stats.setPointsSentThisMonth(getTotalKarmaSentThisMonth());
		
		return stats;
	}
	
	/*
	 * * * * * * * private methods * * * * * * * 
	 */
	
	private Date getMonthBefore() {  //for monthly statistics
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		
		return cal.getTime();
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
	
	
	private Long getTotalKarmaSentThisMonth() {
		long totalPoints = 0;
	
		List<PointsTransferInfo> allTransfers = transferRepo.findAll();
		
		for(PointsTransferInfo transfer : allTransfers ){
			if (transfer.dateCreated.after(getMonthBefore())){
				totalPoints += transfer.points;		
			}

		}
		
		return new Long(totalPoints);
	}
	

	
}
