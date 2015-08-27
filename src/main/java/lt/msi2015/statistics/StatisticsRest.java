package lt.msi2015.statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticsRest {
	
	@Autowired
	StatisticsService statisticsService;

	@RequestMapping(value = "statistics", method = RequestMethod.GET)
	StatisticsDto getStatistics() {
		
		return statisticsService.getStatistics();
		
	}
	
	//User statistics
	@RequestMapping(value = "api/statistics/{id}", method = RequestMethod.GET)
	UserStatisticsDto getUserStatistics(@PathVariable Long id) {
		
		return statisticsService.getUserStatistics(id);
		
	}
}
