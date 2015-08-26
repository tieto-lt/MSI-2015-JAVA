package lt.msi2015.statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticsRest {
	
	@Autowired
	StatisticsService statisticsService;

	@RequestMapping(value = "api/statistics", method = RequestMethod.GET)
	StatisticsDto getCategories() {
		
		return statisticsService.getStatistics();
		
	}
	
}
