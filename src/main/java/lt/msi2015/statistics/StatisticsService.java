package lt.msi2015.statistics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.msi2015.user.User;
import lt.msi2015.user.UserRepository;

@Service
public class StatisticsService {

	@Autowired
	UserRepository userRepo;
	
	public StatisticsDto getStatistics() {
		StatisticsDto statisticsDto =
				new StatisticsDto(getRegisteredUsersNumber());
		
		return statisticsDto;
	}
	
	private Integer getRegisteredUsersNumber() {
		List <User> userList = userRepo.findAll();
		return userList.size();
	}
	
}
